package com.italianopizzeria.ui;

import com.italianopizzeria.models.Order;
import com.italianopizzeria.models.Product;
import com.italianopizzeria.models.Receipt;
import com.italianopizzeria.services.OrderManager;
import com.italianopizzeria.services.ReceiptFileManager;
import com.italianopizzeria.Utilities.ConsoleColors;
import com.italianopizzeria.Utilities.TextFormatter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class CheckOutScreen {

    private OrderManager orderManager;
    private ReceiptFileManager receiptFileManager;

    public CheckOutScreen(OrderManager orderManager) {
        this.orderManager = orderManager;
        this.receiptFileManager = new ReceiptFileManager();
    }

    public void display() {
        Order order = orderManager.getCurrentOrder();

        TextFormatter.printTitle("CHECKOUT");

        if (order == null || order.getProducts().isEmpty()) {
            System.out.println(ConsoleColors.RED + "No items in this order." + ConsoleColors.RESET);
            ConsoleHelper.pause();
            return;
        }

        String receiptText = buildReceiptText(order);
        System.out.println(receiptText);

        boolean confirm = ConsoleHelper.readYesNo("Confirm order?");

        if (confirm) {
            Receipt receipt = new Receipt(receiptText);
            receiptFileManager.saveReceipt(receipt);
            orderManager.cancelOrder();

            System.out.println(ConsoleColors.GREEN + "Order completed!" + ConsoleColors.RESET);
        } else {
            orderManager.cancelOrder();
            System.out.println(ConsoleColors.YELLOW + "Order cancelled." + ConsoleColors.RESET);
        }

        ConsoleHelper.pause();
    }

    private String buildReceiptText(Order order) {
        StringBuilder receipt = new StringBuilder();

        receipt.append("========================================\n");
        receipt.append("          ITALIANO PIZZERIA\n");
        receipt.append("========================================\n\n");

        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter dateFormatter =
                DateTimeFormatter.ofPattern("MMMM d, yyyy");

        DateTimeFormatter timeFormatter =
                DateTimeFormatter.ofPattern("h:mm a");

        receipt.append("Date: ")
                .append(now.format(dateFormatter))
                .append("\n");

        receipt.append("Time: ")
                .append(now.format(timeFormatter))
                .append("\n\n");


        for (Product product : order.getProducts()) {
            receipt.append(product.getName())
                    .append(" - $")
                    .append(String.format("%.2f", product.calculatePrice()))
                    .append("\n");
        }

        receipt.append("\n----------------------------------------\n");
        receipt.append("TOTAL: $")
                .append(String.format("%.2f", order.calculateTotal()))
                .append("\n");
        receipt.append("----------------------------------------\n");

        receipt.append("\nThank you for ordering!\n");

        return receipt.toString();
    }
}