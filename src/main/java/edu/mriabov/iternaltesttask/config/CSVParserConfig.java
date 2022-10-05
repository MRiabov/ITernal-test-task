package edu.mriabov.iternaltesttask.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@ConfigurationProperties(prefix = "csvparser")
@Component
@Setter
public class CSVParserConfig {

    private String inputPath;
    private String outputPath;
    private String invalidOutputPath;
    private String delimiter;

}
