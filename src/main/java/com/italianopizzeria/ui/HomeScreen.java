package com.italianopizzeria.ui;

import com.italianopizzeria.services.OrderManager;
import com.italianopizzeria.Utilities.ConsoleColors;
import com.italianopizzeria.Utilities.TextFormatter;

public class HomeScreen {

    private OrderManager orderManager;

    public HomeScreen(OrderManager orderManager) {
        this.orderManager = orderManager;
    }

    public void display() {
        boolean running = true;

        while (running) {
            TextFormatter.printTitle(ConsoleColors.GREEN + "ITALIANO PIZZERIA" + ConsoleColors.RESET);

            System.out.println("1) New Order");
            System.out.println("0) Exit");

            int choice = ConsoleHelper.readInt("Choose an option: ");

            switch (choice) {
                case 1:
                    orderManager.startNewOrder();
                    OrderScreen orderScreen = new OrderScreen(orderManager);
                    orderScreen.display();
                    break;

                case 0:
                    System.out.println("Thank you for using Italiano Pizzeria POS!");
                    running = false;
                    break;

                default:
                    System.out.println(ConsoleColors.RED + "Invalid option. Please try again." + ConsoleColors.RESET);
                    ConsoleHelper.pause();
                    break;
            }
        }
    }
}