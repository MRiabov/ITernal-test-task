package edu.mriabov.iternaltesttask;

import edu.mriabov.iternaltesttask.csv.CSVReader;
import edu.mriabov.iternaltesttask.csv.CSVParser;
import edu.mriabov.iternaltesttask.xml.XMLCreatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StartupApplication implements ApplicationListener<ContextRefreshedEvent> {

    private final XMLCreatorService xmlCreatorService;
    private final CSVParser CSVParser;
    private final CSVReader CSVReader;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        xmlCreatorService.fillMultipleXML(
                CSVParser.parseData().getRightValue());
    }

}
