package edu.mriabov.iternaltesttask.service;

import org.springframework.stereotype.Service;

@Service
public class ValidatorService {

    public boolean isNumber(String s) {
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c) || c == ',') return false;
        }
        return true;
    }

    public boolean isValidDate(String s) {
        //17.02.2021
        return s.matches("\\d\\d\\.\\d\\d.\\d\\d\\d\\d");
    }


}
