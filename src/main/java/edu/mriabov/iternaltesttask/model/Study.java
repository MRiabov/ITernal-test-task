package edu.mriabov.iternaltesttask.model;

import lombok.Data;

import java.util.Set;

@Data
public class Study {

    private String id;
    private String field;
    private String fieldCode;
    private Set<Course> course;

}
