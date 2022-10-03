package edu.mriabov.service;

public class ValidatorService {

    public boolean isNumber(String s) {
        s = s.replace(',', '.');
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c) || c == '.') return false;
        }
        return true;
    }

    public boolean isValidDate(String s) {
        return true;//todo!!!
    }


}
