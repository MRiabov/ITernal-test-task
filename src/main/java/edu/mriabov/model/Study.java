package edu.mriabov.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Study {

    private String id;
    private String field;
    private String fieldCode;
    private String surname;
    private Set<Course> course;

}
