package com.italianopizzeria.Utilities;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TextFormatter {

    public static void printSeparator() {
        System.out.println(ConsoleColors.GREEN +
                "════════════════════════════════════════════════════════════════════════════"
                + ConsoleColors.RESET);
    }

    public static void printTitle(String title) {
        printSeparator();
        System.out.println(title);
        printSeparator();
    }

    public static void printLogo() {
        System.out.println();

        System.out.println(ConsoleColors.GREEN + """
                ██╗████████╗ █████╗ ██╗     ██╗ █████╗ ███╗   ██╗ ██████╗
                ██║╚══██╔══╝██╔══██╗██║     ██║██╔══██╗████╗  ██║██╔═══██╗
                ██║   ██║   ███████║██║     ██║███████║██╔██╗ ██║██║   ██║
                ██║   ██║   ██╔══██║██║     ██║██╔══██║██║╚██╗██║██║   ██║
                ██║   ██║   ██║  ██║███████╗██║██║  ██║██║ ╚████║╚██████╔╝
                ╚═╝   ╚═╝   ╚═╝  ╚═╝╚══════╝╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝ ╚═════╝
                """ + ConsoleColors.RESET);

        System.out.println(ConsoleColors.RED + """
                ██████╗ ██╗███████╗███████╗███████╗██████╗ ██╗ █████╗
                ██╔══██╗██║╚══███╔╝╚══███╔╝██╔════╝██╔══██╗██║██╔══██╗
                ██████╔╝██║  ███╔╝   ███╔╝ █████╗  ██████╔╝██║███████║
                ██╔═══╝ ██║ ███╔╝   ███╔╝  ██╔══╝  ██╔══██╗██║██╔══██║
                ██║     ██║███████╗███████╗███████╗██║  ██║██║██║  ██║
                ╚═╝     ╚═╝╚══════╝╚══════╝╚══════╝╚═╝  ╚═╝╚═╝╚═╝  ╚═╝
                """ + ConsoleColors.RESET);

        System.out.println(ConsoleColors.YELLOW +
                "        🍃 FRESH INGREDIENTS • AUTHENTIC TASTE • MADE WITH PASSION 🍃"
                + ConsoleColors.RESET);

        printPizzaAscii();

        System.out.println(ConsoleColors.YELLOW +
                "                        🍕 BUON APPETITO • EST. 2026 🍕"
                + ConsoleColors.RESET);

        System.out.println();
    }

    private static void printPizzaAscii() {
        try {
            InputStream inputStream = TextFormatter.class.getResourceAsStream(
                    "/assets/art/pizza-ascii.txt"
            );

            if (inputStream == null) {
                System.out.println(ConsoleColors.RED + "Pizza ASCII file not found." + ConsoleColors.RESET);
                return;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(ConsoleColors.YELLOW + line + ConsoleColors.RESET);
            }

        } catch (Exception e) {
            System.out.println(ConsoleColors.RED + "Error loading pizza ASCII art." + ConsoleColors.RESET);
        }
    }
    public static void printScreenHeader(String title) {
        printLogo();
        printTitle(title);
    }
}