package edu.mriabov.iternaltesttask.service;

import edu.mriabov.iternaltesttask.model.Record;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.FileOutputStream;

@Service
@RequiredArgsConstructor
public class XMLCreatorService {

    @SneakyThrows
    public void fillXML(Record record) {
        JAXBContext contextObj = JAXBContext.newInstance(Record.class);

        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshallerObj.marshal(record, new FileOutputStream("output.xml"));
    }
}
