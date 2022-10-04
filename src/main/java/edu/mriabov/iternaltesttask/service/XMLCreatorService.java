package edu.mriabov.iternaltesttask.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class XMLCreatorService {

    private final XSDCreatorService xsdCreatorService;

    void create(List<String> arguments){

    }
}
