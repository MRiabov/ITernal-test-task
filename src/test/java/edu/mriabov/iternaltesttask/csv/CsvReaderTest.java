package edu.mriabov.iternaltesttask.csv;

import edu.mriabov.iternaltesttask.config.Config;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CsvReaderTest {

    /**
     * Method under test: {@link CsvReader#getLinesFromCSV()}
     */
    @Test
    void wrongTestPathResultsNothing() {
        // Arrange
        Config config = new Config();
        config.setInputPath("Input Path");

        // Act and Assert
        assertTrue((new CsvReader(config)).getLinesFromCSV().isEmpty());
    }
}

