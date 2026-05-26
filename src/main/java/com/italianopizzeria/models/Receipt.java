package com.italianopizzeria.models;

public class Receipt {

    private String receiptText;

    public Receipt(String receiptText) {
        this.receiptText = receiptText;
    }

    public String getReceiptText() {
        return receiptText;
    }
}