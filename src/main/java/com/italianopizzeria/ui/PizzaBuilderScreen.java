package com.italianopizzeria.ui;

import com.italianopizzeria.enums.*;
import com.italianopizzeria.models.Pizza;
import com.italianopizzeria.models.Topping;
import com.italianopizzeria.Utilities.ConsoleColors;
import com.italianopizzeria.Utilities.TextFormatter;

public class PizzaBuilderScreen {

    public Pizza buildPizza() {
        TextFormatter.printLogo();
        TextFormatter.printTitle(ConsoleColors.YELLOW + "ADD PIZZA" + ConsoleColors.RESET);

        System.out.println("1) 🍕 Signature Pizza");
        System.out.println("2) 🛠️ Build Your Own Pizza");
        System.out.println("0) Back");

        int choice = ConsoleHelper.readInt("Choose an option: ");

        return switch (choice) {
            case 1 -> buildSignaturePizza();
            case 2 -> buildCustomPizza();
            default -> null;
        };
    }

    private Pizza buildSignaturePizza() {
        TextFormatter.printLogo();
        TextFormatter.printTitle(ConsoleColors.YELLOW + "🍕 SIGNATURE PIZZAS 🍕" + ConsoleColors.RESET);

        SignaturePizzaType[] types = SignaturePizzaType.values();

        for (int i = 0; i < types.length; i++) {
            System.out.println((i + 1) + ") " + getSignatureEmoji(types[i]) + " " + types[i].getDisplayName()
                    + " - | Price:  $" + String.format("%.2f", calculateSignaturePrice(types[i], PizzaSize.PERSONAL_8)));

            System.out.println("   " + getSignatureDescription(types[i]));
            System.out.println();
        }

        System.out.println("0) Back");

        int choice = ConsoleHelper.readInt("Choose a signature pizza: ");

        if (choice == 0) {
            return null;
        }

        SignaturePizzaType selectedType = types[choice - 1];

        PizzaSize size = selectPizzaSize(selectedType);

        if (size == null) {
            return null;
        }

        CrustType crust = selectCrustType();

        if (crust == null) {
            return null;
        }

        Pizza pizza = new Pizza(size, crust);

        addSignatureToppings(pizza, selectedType);

        boolean stuffedCrust = ConsoleHelper.readYesNo("Would you like stuffed crust?");
        pizza.setStuffedCrust(stuffedCrust);

        System.out.println(ConsoleColors.GREEN + "🍕 " + selectedType.getDisplayName() + " added!" + ConsoleColors.RESET);
        double signaturePrice = calculateSignaturePrice(selectedType, size);

        System.out.println(ConsoleColors.YELLOW + "Estimated price: $" + String.format("%.2f", signaturePrice) + ConsoleColors.RESET);
        ConsoleHelper.pause();

        return pizza;
    }

    private Pizza buildCustomPizza() {
        TextFormatter.printLogo();
        TextFormatter.printTitle("BUILD YOUR OWN PIZZA");

        PizzaSize size = selectPizzaSize();

        if (size == null) {
            return null;
        }

        CrustType crust = selectCrustType();

        if (crust == null) {
            return null;
        }

        Pizza pizza = new Pizza(size, crust);

        addToppings(pizza);
        addSauces(pizza);

        boolean stuffedCrust = ConsoleHelper.readYesNo("Would you like stuffed crust?");
        pizza.setStuffedCrust(stuffedCrust);

        System.out.println(ConsoleColors.GREEN + "Custom pizza added!" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.YELLOW + "Estimated price: $" + String.format("%.2f", pizza.calculatePrice()) + ConsoleColors.RESET);

        ConsoleHelper.pause();

        return pizza;
    }

    private String getSignatureEmoji(SignaturePizzaType type) {
        return switch (type) {
            case CHEESE -> "🧀";
            case PEPPERONI -> "🍕";
            case HAWAIIAN -> "🍍";
            case MEAT_LOVERS -> "🥓";
            case VEGGIE -> "🫑";
            case SUPREME -> "⭐";
            case BBQ_CHICKEN -> "🍗";
            case ITALIANO_SPECIAL -> "🇮🇹";
        };
    }

    private String getSignatureDescription(SignaturePizzaType type) {
        return switch (type) {
            case CHEESE -> "Marinara • Mozzarella";
            case PEPPERONI -> "Marinara • Mozzarella • Pepperoni";
            case HAWAIIAN -> "Marinara • Mozzarella • Ham • Pineapple";
            case MEAT_LOVERS -> "Marinara • Pepperoni • Sausage • Bacon • Ham";
            case VEGGIE -> "Marinara • Mushrooms • Bell Peppers • Onions • Olives";
            case SUPREME -> "Marinara • Pepperoni • Sausage • Mushrooms • Bell Peppers • Onions";
            case BBQ_CHICKEN -> "BBQ Sauce • Chicken • Onions";
            case ITALIANO_SPECIAL -> "Marinara • Extra Mozzarella • Pepperoni • Sausage • Mushrooms • Bell Peppers";
        };
    }

    private void addSignatureToppings(Pizza pizza, SignaturePizzaType type) {
        switch (type) {
            case CHEESE:
                pizza.addSauce(SauceType.MARINARA);
                pizza.addTopping(new Topping(ToppingName.MOZZARELLA, false));
                break;

            case PEPPERONI:
                pizza.addSauce(SauceType.MARINARA);
                pizza.addTopping(new Topping(ToppingName.MOZZARELLA, false));
                pizza.addTopping(new Topping(ToppingName.PEPPERONI, false));
                break;

            case HAWAIIAN:
                pizza.addSauce(SauceType.MARINARA);
                pizza.addTopping(new Topping(ToppingName.MOZZARELLA, false));
                pizza.addTopping(new Topping(ToppingName.HAM, false));
                pizza.addTopping(new Topping(ToppingName.PINEAPPLE, false));
                break;

            case MEAT_LOVERS:
                pizza.addSauce(SauceType.MARINARA);
                pizza.addTopping(new Topping(ToppingName.PEPPERONI, false));
                pizza.addTopping(new Topping(ToppingName.SAUSAGE, false));
                pizza.addTopping(new Topping(ToppingName.BACON, false));
                pizza.addTopping(new Topping(ToppingName.HAM, false));
                break;

            case VEGGIE:
                pizza.addSauce(SauceType.MARINARA);
                pizza.addTopping(new Topping(ToppingName.MUSHROOMS, false));
                pizza.addTopping(new Topping(ToppingName.BELL_PEPPERS, false));
                pizza.addTopping(new Topping(ToppingName.ONIONS, false));
                pizza.addTopping(new Topping(ToppingName.OLIVES, false));
                break;

            case SUPREME:
                pizza.addSauce(SauceType.MARINARA);
                pizza.addTopping(new Topping(ToppingName.PEPPERONI, false));
                pizza.addTopping(new Topping(ToppingName.SAUSAGE, false));
                pizza.addTopping(new Topping(ToppingName.MUSHROOMS, false));
                pizza.addTopping(new Topping(ToppingName.BELL_PEPPERS, false));
                pizza.addTopping(new Topping(ToppingName.ONIONS, false));
                break;

            case BBQ_CHICKEN:
                pizza.addSauce(SauceType.BBQ);
                pizza.addTopping(new Topping(ToppingName.CHICKEN, false));
                pizza.addTopping(new Topping(ToppingName.ONIONS, false));
                break;

            case ITALIANO_SPECIAL:
                pizza.addSauce(SauceType.MARINARA);
                pizza.addTopping(new Topping(ToppingName.MOZZARELLA, true));
                pizza.addTopping(new Topping(ToppingName.PEPPERONI, false));
                pizza.addTopping(new Topping(ToppingName.SAUSAGE, false));
                pizza.addTopping(new Topping(ToppingName.MUSHROOMS, false));
                pizza.addTopping(new Topping(ToppingName.BELL_PEPPERS, false));
                break;
        }
    }

    private PizzaSize selectPizzaSize(SignaturePizzaType type) {
        System.out.println("Select Pizza Size:");

        PizzaSize[] sizes = PizzaSize.values();

        for (int i = 0; i < sizes.length; i++) {
            double price = calculateSignaturePrice(type, sizes[i]);

            System.out.println((i + 1) + ") " + sizes[i].getDisplayName()
                    + " - $" + String.format("%.2f", price));
        }

        System.out.println("0) Back");

        int choice = ConsoleHelper.readInt("Choose a size: ");

        if (choice == 0) {
            return null;
        }

        return sizes[choice - 1];
    }

    private PizzaSize selectPizzaSize() {
        System.out.println("Select Pizza Size:");

        PizzaSize[] sizes = PizzaSize.values();

        for (int i = 0; i < sizes.length; i++) {
            System.out.println((i + 1) + ") " + sizes[i].getDisplayName()
                    + " - $" + String.format("%.2f", sizes[i].getBasePrice()));
        }

        System.out.println("0) Back");

        int choice = ConsoleHelper.readInt("Choose a size: ");

        if (choice == 0) {
            return null;
        }

        return sizes[choice - 1];
    }

    private CrustType selectCrustType() {
        System.out.println("Select Crust Type:");

        CrustType[] crustTypes = CrustType.values();

        for (int i = 0; i < crustTypes.length; i++) {
            System.out.println((i + 1) + ") " + crustTypes[i].getDisplayName());
        }

        System.out.println("0) Back");

        int choice = ConsoleHelper.readInt("Choose a crust: ");

        if (choice == 0) {
            return null;
        }

        return crustTypes[choice - 1];
    }

    private void addToppings(Pizza pizza) {
        boolean addingToppings = true;

        while (addingToppings) {
            System.out.println("Available Toppings:");

            ToppingName[] toppings = ToppingName.values();

            for (int i = 0; i < toppings.length; i++) {
                System.out.println((i + 1) + ") " + toppings[i].getDisplayName());
            }

            System.out.println("0) Finish Toppings");

            int choice = ConsoleHelper.readInt("Choose a topping: ");

            if (choice == 0) {
                addingToppings = false;
            } else {
                ToppingName toppingName = toppings[choice - 1];
                boolean extra = ConsoleHelper.readYesNo("Extra " + toppingName.getDisplayName() + "?");
                pizza.addTopping(new Topping(toppingName, extra));
            }
        }
    }

    private void addSauces(Pizza pizza) {
        boolean addingSauces = true;

        while (addingSauces) {
            System.out.println("Available Sauces:");

            SauceType[] sauces = SauceType.values();

            for (int i = 0; i < sauces.length; i++) {
                System.out.println((i + 1) + ") " + sauces[i].getDisplayName());
            }

            System.out.println("0) Finish Sauces");

            int choice = ConsoleHelper.readInt("Choose a sauce: ");

            if (choice == 0) {
                addingSauces = false;
            } else {
                pizza.addSauce(sauces[choice - 1]);
            }
        }
    }

    private double calculateSignaturePrice(SignaturePizzaType type, PizzaSize size) {
        double total = size.getBasePrice();

        switch (type) {
            case CHEESE:
                total += calculateToppingPrice(size, ToppingName.MOZZARELLA, false);
                break;

            case PEPPERONI:
                total += calculateToppingPrice(size, ToppingName.MOZZARELLA, false);
                total += calculateToppingPrice(size, ToppingName.PEPPERONI, false);
                break;

            case HAWAIIAN:
                total += calculateToppingPrice(size, ToppingName.MOZZARELLA, false);
                total += calculateToppingPrice(size, ToppingName.HAM, false);
                total += calculateToppingPrice(size, ToppingName.PINEAPPLE, false);
                break;

            case MEAT_LOVERS:
                total += calculateToppingPrice(size, ToppingName.PEPPERONI, false);
                total += calculateToppingPrice(size, ToppingName.SAUSAGE, false);
                total += calculateToppingPrice(size, ToppingName.BACON, false);
                total += calculateToppingPrice(size, ToppingName.HAM, false);
                break;

            case VEGGIE:
                total += calculateToppingPrice(size, ToppingName.MUSHROOMS, false);
                total += calculateToppingPrice(size, ToppingName.BELL_PEPPERS, false);
                total += calculateToppingPrice(size, ToppingName.ONIONS, false);
                total += calculateToppingPrice(size, ToppingName.OLIVES, false);
                break;

            case SUPREME:
                total += calculateToppingPrice(size, ToppingName.PEPPERONI, false);
                total += calculateToppingPrice(size, ToppingName.SAUSAGE, false);
                total += calculateToppingPrice(size, ToppingName.MUSHROOMS, false);
                total += calculateToppingPrice(size, ToppingName.BELL_PEPPERS, false);
                total += calculateToppingPrice(size, ToppingName.ONIONS, false);
                break;

            case BBQ_CHICKEN:
                total += calculateToppingPrice(size, ToppingName.CHICKEN, false);
                total += calculateToppingPrice(size, ToppingName.ONIONS, false);
                break;

            case ITALIANO_SPECIAL:
                total += calculateToppingPrice(size, ToppingName.MOZZARELLA, true);
                total += calculateToppingPrice(size, ToppingName.PEPPERONI, false);
                total += calculateToppingPrice(size, ToppingName.SAUSAGE, false);
                total += calculateToppingPrice(size, ToppingName.MUSHROOMS, false);
                total += calculateToppingPrice(size, ToppingName.BELL_PEPPERS, false);
                break;
        }

        return total;
    }

    private double calculateToppingPrice(PizzaSize size, ToppingName toppingName, boolean extra) {
        ToppingCategory category = toppingName.getCategory();

        if (category == ToppingCategory.REGULAR) {
            return 0.00;
        }

        if (category == ToppingCategory.MEAT) {
            if (extra) {
                return switch (size) {
                    case PERSONAL_8 -> 0.50;
                    case MEDIUM_12 -> 1.00;
                    case LARGE_16 -> 1.50;
                };
            }

            return switch (size) {
                case PERSONAL_8 -> 1.00;
                case MEDIUM_12 -> 2.00;
                case LARGE_16 -> 3.00;
            };
        }

        if (category == ToppingCategory.CHEESE) {
            if (extra) {
                return switch (size) {
                    case PERSONAL_8 -> 0.30;
                    case MEDIUM_12 -> 0.60;
                    case LARGE_16 -> 0.90;
                };
            }

            return switch (size) {
                case PERSONAL_8 -> 0.75;
                case MEDIUM_12 -> 1.50;
                case LARGE_16 -> 2.25;
            };
        }

        return 0.00;
    }
}