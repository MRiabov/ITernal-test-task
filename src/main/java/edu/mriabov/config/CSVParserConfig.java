package edu.mriabov.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ConfigurationProperties(prefix = "csvparser")

public class CSVParserConfig {

    private String inputPath;
    private String outputPath;
    private String delimiter;

}
