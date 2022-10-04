package edu.mriabov.iternaltesttask.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Exam {

    private String result;
    private String date;
    private String teacher;
    private Double grade;
    private int credits_reg;
    private int credits_obt;

}
