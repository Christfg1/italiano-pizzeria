package com.italianopizzeria.Utilities;

import java.io.File;

public class FileUtils {

    public static void createReceiptsFolder() {

        File folder = new File("receipts");

        if (!folder.exists()) {
            folder.mkdir();
        }
    }
}