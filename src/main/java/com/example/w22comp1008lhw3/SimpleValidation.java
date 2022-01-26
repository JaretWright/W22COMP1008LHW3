package com.example.w22comp1008lhw3;

public class SimpleValidation {
    public static void main(String[] args) {
        String name = " Ja";
        if (name.trim().matches("[A-Z][a-z][a-z]*"))
            System.out.println("validation works for: "+name);
        else
            System.out.println("validation failed for: "+name);
    }
}
