package com.italianopizzeria;

import com.italianopizzeria.Utilities.TextFormatter;
import com.italianopizzeria.services.OrderManager;
import com.italianopizzeria.services.SoundManager;
import com.italianopizzeria.ui.HomeScreen;

public class ItalianoPizzeria {

    public static void main(String[] args) {

        SoundManager soundManager = new SoundManager();
        soundManager.playBackgroundMusic();

        TextFormatter.printLogo();

        OrderManager orderManager = new OrderManager();

        HomeScreen homeScreen = new HomeScreen(orderManager);

        homeScreen.display();
    }
}