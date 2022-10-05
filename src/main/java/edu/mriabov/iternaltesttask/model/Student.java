package edu.mriabov.iternaltesttask.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@XmlRootElement
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String id;
    private String name;
    private String surname;


}

