package edu.mriabov.iternaltesttask.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Course {

    private String code;
    private String name;
    private String type;
    private String semester;
    private String ayear;
    private String year_of_study;
    private Exam exam;

}
