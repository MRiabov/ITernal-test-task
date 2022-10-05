package edu.mriabov.iternaltesttask.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pair<L,R> {

    private L leftValue;
    private R rightValue;

}
