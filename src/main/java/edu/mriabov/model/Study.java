package edu.mriabov.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Study {

    private String id;
    private String field;
    private String surname;
    private Set<Course> course;

}
