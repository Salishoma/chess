package com.oma.utils;

import java.util.regex.Pattern;

public class CharacterValidation {

    public static boolean validateNumber(String num) {
        Pattern pattern = Pattern.compile("\\d");
        return pattern.matcher(num).matches();
    }

    public static boolean validateLetter(String letter) {
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        return pattern.matcher(letter).matches();
    }
}
