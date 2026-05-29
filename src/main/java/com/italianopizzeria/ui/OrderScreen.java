package com.italianopizzeria.ui;

import com.italianopizzeria.models.GarlicKnots;
import com.italianopizzeria.services.OrderManager;
import com.italianopizzeria.Utilities.ConsoleColors;
import com.italianopizzeria.Utilities.TextFormatter;
import com.italianopizzeria.models.Pizza;

public class OrderScreen {

    private OrderManager orderManager;

    public OrderScreen(OrderManager orderManager) {
        this.orderManager = orderManager;
    }

    public void display() {
        boolean ordering = true;

        while (ordering) {
            TextFormatter.printTitle("ORDER MENU");

            System.out.println("1) Add Pizza");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Garlic Knots");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");

            int choice = ConsoleHelper.readInt("Choose an option: ");

            switch (choice) {
                case 1:
                    PizzaBuilderScreen pizzaBuilderScreen = new PizzaBuilderScreen();

                    Pizza pizza = pizzaBuilderScreen.buildPizza();

                    if (pizza != null) {
                        orderManager.addProduct(pizza);
                    }

                    break;

                case 2:
                    DrinkScreen drinkScreen = new DrinkScreen();
                    orderManager.addProduct(drinkScreen.buildDrink());
                    break;

                case 3:
                    int quantity = ConsoleHelper.readInt("How many garlic knots? ");
                    orderManager.addProduct(new GarlicKnots(quantity));
                    break;

                case 4:
                    CheckOutScreen checkOutScreen = new CheckOutScreen(orderManager);
                    checkOutScreen.display();
                    ordering = false;
                    break;

                case 0:
                    orderManager.cancelOrder();
                    System.out.println(ConsoleColors.YELLOW + "Order cancelled." + ConsoleColors.RESET);
                    ConsoleHelper.pause();
                    ordering = false;
                    break;

                default:
                    System.out.println(ConsoleColors.RED + "Invalid option. Please try again." + ConsoleColors.RESET);
                    ConsoleHelper.pause();
                    break;
            }
        }
    }
}