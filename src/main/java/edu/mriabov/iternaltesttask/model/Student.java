package edu.mriabov.iternaltesttask.model;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@XmlRootElement
public class Student {

    private String id;
    private String name;
    private String surname;


}

