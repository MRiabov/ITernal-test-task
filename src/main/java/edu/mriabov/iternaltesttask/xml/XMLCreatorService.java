package edu.mriabov.iternaltesttask.xml;

import edu.mriabov.iternaltesttask.config.Config;
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

    private final Config config;

    public void createXML(Set<Record> records){
        for (Record studentRecord : records) {
            fillXML(studentRecord, config.getOutputPath()+studentRecord.getStudent().getId()+".xml");
        }
    }


    private void fillXML(Record studentRecord, String path){
        JAXBContext contextObj;
        try {
            contextObj = JAXBContext.newInstance(Record.class);
            Marshaller marshallerObj = contextObj.createMarshaller();
            marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshallerObj.marshal(studentRecord, new FileOutputStream(path));
        } catch (JAXBException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
