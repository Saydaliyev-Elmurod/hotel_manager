package org.example.controller;

import org.example.container.ComponentContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {
    @Autowired
    private AdminController adminController;

    public void start() {
        boolean b = true;
        while (b) {
            menu();
            int action = ComponentContainer.getAction();
            switch (action) {
                case 1 -> {
                    login();
                }
                case 2 -> {
                }

            }
        }
    }

    private void login() {
        System.out.print("Enter login");
        String login = ComponentContainer.StringScanner.next();
        System.out.print("Enter password");
        String password = ComponentContainer.StringScanner.next();
        if (login.equals("1") && password.equals("1")) {
            adminController.start();
        }
    }

    private void menu() {
        System.out.println("1.Login");
        System.out.println("2.Complain");
    }
}

