package edu.mriabov.iternaltesttask;

import edu.mriabov.iternaltesttask.config.Config;
import edu.mriabov.iternaltesttask.csv.CsvReader;
import edu.mriabov.iternaltesttask.csv.CsvParser;
import edu.mriabov.iternaltesttask.xml.XMLCreatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
@RequiredArgsConstructor
public class StartupApplication implements ApplicationListener<ContextRefreshedEvent> {

    private final XMLCreatorService xmlCreatorService;
    private final CsvParser csvParser;
    private final Config config;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        new File(config.getOutputPath()).mkdirs();
        new File(config.getInvalidOutputPath()).mkdirs();
        xmlCreatorService.fillMultipleXML(
                csvParser.parseData().getRightValue());
    }

}
