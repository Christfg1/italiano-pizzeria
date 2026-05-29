package com.italianopizzeria.ui;

import com.italianopizzeria.enums.DrinkFlavor;
import com.italianopizzeria.enums.DrinkSize;
import com.italianopizzeria.models.Drink;
import com.italianopizzeria.Utilities.ConsoleColors;
import com.italianopizzeria.Utilities.TextFormatter;

public class DrinkScreen {

    public Drink buildDrink() {

        TextFormatter.printTitle(ConsoleColors.CYAN + "ADD DRINK" + ConsoleColors.RESET);

        DrinkSize size = selectDrinkSize();
        DrinkFlavor flavor = selectDrinkFlavor();

        Drink drink = new Drink(size, flavor);

        System.out.println(ConsoleColors.GREEN + "Drink added to order!" + ConsoleColors.RESET);

        ConsoleHelper.pause();

        return drink;
    }

    private DrinkSize selectDrinkSize() {

        System.out.println("Select Drink Size:");

        DrinkSize[] sizes = DrinkSize.values();

        for (int i = 0; i < sizes.length; i++) {
            System.out.println((i + 1) + ") " + sizes[i].getDisplayName());
        }

        int choice = ConsoleHelper.readInt("Choose a size: ");

        return sizes[choice - 1];
    }

    private DrinkFlavor selectDrinkFlavor() {

        System.out.println("Select Drink Flavor:");

        DrinkFlavor[] flavors = DrinkFlavor.values();

        for (int i = 0; i < flavors.length; i++) {
            System.out.println((i + 1) + ") " + flavors[i].getDisplayName());
        }

        int choice = ConsoleHelper.readInt("Choose a flavor: ");

        return flavors[choice - 1];
    }
}