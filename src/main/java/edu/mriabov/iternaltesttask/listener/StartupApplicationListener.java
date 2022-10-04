package edu.mriabov.iternaltesttask.listener;

import edu.mriabov.iternaltesttask.io.InputCSV;
import edu.mriabov.iternaltesttask.service.ParserService;
import edu.mriabov.iternaltesttask.service.XMLCreatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private final XMLCreatorService xmlCreatorService;
    private final ParserService parserService;
    private final InputCSV inputCSV;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        xmlCreatorService.fillXML(parserService.parse(inputCSV.getLinesFromCSV()));
    }

}
