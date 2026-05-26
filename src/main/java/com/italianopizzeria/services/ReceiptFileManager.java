package com.italianopizzeria.services;

import com.italianopizzeria.models.Receipt;
import com.italianopizzeria.utils.DateUtils;
import com.italianopizzeria.utils.FileUtils;

import java.io.FileWriter;
import java.io.IOException;

public class ReceiptFileManager {

    public void saveReceipt(Receipt receipt) {
        FileUtils.createReceiptsFolder();

        String fileName = "receipts/" + DateUtils.getReceiptTimestamp() + ".txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(receipt.getReceiptText());
            System.out.println("Receipt saved: " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}