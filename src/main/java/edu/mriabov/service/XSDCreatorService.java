package edu.mriabov.service;

import edu.mriabov.model.Record;
import org.springframework.stereotype.Service;

@Service
public class XSDCreatorService {

    void create(Record record) {
        String header = lines.get(0);
        String[] split = header.split(delimiter);
        for (String s : split) {
            switch (s) {
                case "" ->
            }
        }
    }

}
