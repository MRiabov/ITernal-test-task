package edu.mriabov.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@ConfigurationProperties(prefix = "csvparser")
@Component
public class CSVParserConfig {

    private String inputPath;
    private String outputPath;
    private String delimiter;

}
