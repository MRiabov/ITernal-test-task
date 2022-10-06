package edu.mriabov.iternaltesttask;

import edu.mriabov.iternaltesttask.csv.CsvCreator;
import edu.mriabov.iternaltesttask.csv.CsvParser;
import edu.mriabov.iternaltesttask.directory.DirectoryCreator;
import edu.mriabov.iternaltesttask.model.Record;
import edu.mriabov.iternaltesttask.utils.Pair;
import edu.mriabov.iternaltesttask.xml.XMLCreatorService;
import edu.mriabov.iternaltesttask.zip.ZipCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class StartupApplication implements ApplicationListener<ContextRefreshedEvent> {

    private final XMLCreatorService xmlCreatorService;
    private final CsvParser csvParser;
    private final ZipCreator zipCreator;
    private final DirectoryCreator directoryCreator;
    private final CsvCreator csvCreator;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        directoryCreator.clearDirectories();
        Pair<List<String[]>, Set<Record>> parsedData = csvParser.parseData();
        xmlCreatorService.createXML(parsedData.getRightValue());
        csvCreator.createCSV(parsedData.getLeftValue());
        zipCreator.toZip();
    }




}
