package edu.mriabov.iternaltesttask;

import edu.mriabov.iternaltesttask.csv.CsvParser;
import edu.mriabov.iternaltesttask.directory.DirectoryCreator;
import edu.mriabov.iternaltesttask.xml.XMLCreatorService;
import edu.mriabov.iternaltesttask.zip.ZipCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StartupApplication implements ApplicationListener<ContextRefreshedEvent> {

    private final XMLCreatorService xmlCreatorService;
    private final CsvParser csvParser;
    private final ZipCreator zipCreator;
    private final DirectoryCreator directoryCreator;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        directoryCreator.clearDirectories();
        xmlCreatorService.fillMultipleXML(
                csvParser.parseData().getRightValue());
        zipCreator.toZip();
    }




}
