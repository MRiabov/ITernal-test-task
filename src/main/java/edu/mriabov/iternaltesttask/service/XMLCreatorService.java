package edu.mriabov.iternaltesttask.service;

import edu.mriabov.iternaltesttask.config.CSVParserConfig;
import edu.mriabov.iternaltesttask.model.Record;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class XMLCreatorService {

    private final CSVParserConfig csvParserConfig;

    public void fillMultipleXML(Set<Record> records){
        for (Record record : records) {
            fillXML(record, csvParserConfig.getOutputPath()+record.getStudent().getId()+".xml");
        }
    }


    private void fillXML(Record record, String path){
        JAXBContext contextObj;
        try {
            contextObj = JAXBContext.newInstance(Record.class);
            Marshaller marshallerObj = contextObj.createMarshaller();
            marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshallerObj.marshal(record, new FileOutputStream(path));
        } catch (JAXBException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
