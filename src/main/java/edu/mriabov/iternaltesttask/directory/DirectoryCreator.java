package edu.mriabov.iternaltesttask.directory;

import edu.mriabov.iternaltesttask.config.Config;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.FileSystemUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@RequiredArgsConstructor
@Component
@Slf4j
public class DirectoryCreator {

    private final Config config;

    public void clearDirectories() {
        boolean successfulDelete = deleteDirectories();
        createDirectories();
        if (successfulDelete) log.info("Directories successfully cleared!");
        else log.error("Directories weren't deleted!");
    }

    private void createDirectories() {
        new File(config.getInvalidOutputPath()).mkdirs();
        new File(config.getOutputPath()).mkdirs();
    }

    private boolean deleteDirectories() {

        try {
            return FileSystemUtils.deleteRecursively(Path.of(config.getOutputPath().substring(0, config.getOutputPath().length() - 1))) &&
                    FileSystemUtils.deleteRecursively(Path.of(config.getInvalidOutputPath().substring(0, config.getInvalidOutputPath().length() - 1)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
