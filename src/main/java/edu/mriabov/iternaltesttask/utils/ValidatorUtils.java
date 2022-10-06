package edu.mriabov.iternaltesttask.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@NoArgsConstructor(access = AccessLevel.NONE)
public class ValidatorUtils {

    public static boolean isLineValid(String[] params) {
        return (isDateValid(params[13]) &&
                isDateValid(params[15]) &&
                isDouble(params[23]) &&
                isInt(params[24]) &&
                isInt(params[25]) &&
                isInt(params[26]) &&
                isInt(params[27]));
    }

    public static boolean isDateValid(String date) {
        try {
            DateTimeFormatter.ofPattern("dd.MM.yyyy").parse(date);
        } catch (DateTimeParseException dateTimeParseException) {
            return false;
        }
        return true;
    }

    public static boolean isDouble(String number) {
        try {
            Double.valueOf(number.replace(",","."));
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }

    public static boolean isInt(String number) {
        try {
            Integer.valueOf(number);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }

}
