package org.example.container;

import java.util.Scanner;

public class ComponentContainer {
    public static Scanner IntScanner = new Scanner(System.in);
    public static Scanner StringScanner = new Scanner(System.in);
    public static Scanner doubleScanner = new Scanner(System.in);

    public  static  int getAction() {
        System.out.print("Action >> ");
        return IntScanner.nextInt();
    }

}
