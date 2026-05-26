package com.italianopizzeria.Utilities;

public class TextFormatter {

    public static void printSeparator() {
        System.out.println("========================================");
    }

    public static void printTitle(String title) {

        printSeparator();

        System.out.println(title);

        printSeparator();
    }
}