package edu.mriabov.iternaltesttask.zip;

import edu.mriabov.iternaltesttask.config.Config;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Component
@RequiredArgsConstructor
@Slf4j
public class ZipCreator {

    private final Config config;

    public void toZip() {
        String resultName = "result.zip";
        toZip(Path.of(config.getOutputPath()), resultName);
        toZip(Path.of(config.getInvalidOutputPath()), resultName);
    }

    private void toZip(Path path, String zipAppendix) {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(path + zipAppendix))) {
            Files.walkFileTree(path, new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) {
                    if (attributes.isSymbolicLink()) return FileVisitResult.CONTINUE;
                    try (FileInputStream fis = new FileInputStream(file.toFile())) {
                        Path targetFile = path.relativize(file);
                        zos.putNextEntry(new ZipEntry(targetFile.toString()));
                        byte[] buffer = new byte[1024];
                        int len;
                        while ((len = fis.read(buffer)) > 0) zos.write(buffer, 0, len);
                        zos.closeEntry();
                        log.info("Zip file : {} with name {}", file, zipAppendix);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) {
                    log.info("Unable to zip : {}. Method threw {}", file, exc);
                    return FileVisitResult.CONTINUE;
                }
            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
