package com.example.w22comp1008lhw3;

public class SimpleValidation {
    public static void main(String[] args) {
        String name = " Ja";
        if (name.trim().matches("[A-Z][a-z][a-z]*"))
            System.out.println("validation works for: "+name);
        else
            System.out.println("validation failed for: "+name);

        //Area code is the first 3 digits of a phone number
        //705 - Barrie
        //416, 905, 647 - Toronto
        //2-9 0-9 0-9
        String areaCode = "416";
        if (areaCode.matches("[2-9][0-9][0-9]"))
            System.out.println("valid area code");
    }
}
