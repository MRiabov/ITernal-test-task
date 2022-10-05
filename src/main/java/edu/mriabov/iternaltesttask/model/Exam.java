package edu.mriabov.iternaltesttask.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Exam {

    private String result;
    private String date;
    private String teacher;
    private String grade;
    private int credits_reg;
    private int credits_obt;

}
