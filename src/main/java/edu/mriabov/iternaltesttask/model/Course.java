package edu.mriabov.iternaltesttask.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@XmlRootElement
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    private String code;
    private String name;
    private String type;
    private String semester;
    private String ayear;
    private String year_of_study;
    private Exam exam;

}
