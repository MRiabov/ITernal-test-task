package edu.mriabov.iternaltesttask.model;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@XmlRootElement

public class Course {

    private String code;
    private String name;
    private String type;
    private String semester;
    private String ayear;
    private String year_of_study;
    private Exam exam;

}
