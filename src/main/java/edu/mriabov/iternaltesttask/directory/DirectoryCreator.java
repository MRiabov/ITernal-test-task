package edu.mriabov.iternaltesttask.directory;

import edu.mriabov.iternaltesttask.config.Config;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;

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
        return new File(config.getOutputPath()).delete() &&
                new File(config.getInvalidOutputPath()).delete();
    }
}
