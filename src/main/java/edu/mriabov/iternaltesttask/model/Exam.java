package edu.mriabov.iternaltesttask.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Exam {

    private String result;
    private Date date;
    private String teacher;
    private Double grade;
    private int credits_reg;
    private int credits_obt;

}
