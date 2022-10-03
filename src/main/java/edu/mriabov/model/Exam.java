package edu.mriabov.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Exam {

    private String result;
    private Date date;
    private String teacher;
    private int grade;
    private int credits_reg;
    private int credits_obt;

}
