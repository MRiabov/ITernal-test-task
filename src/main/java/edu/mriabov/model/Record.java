package edu.mriabov.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Record {

    private Student student;
    private Set<Study> studies;

}
