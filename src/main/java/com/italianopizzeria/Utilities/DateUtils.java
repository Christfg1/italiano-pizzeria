package com.italianopizzeria.Utilities;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static String getReceiptTimestamp() {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

        return LocalDateTime.now().format(formatter);
    }
}