package com.github.nteditor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (var input = new Scanner(System.in)) {
            boolean isExitMenu = false;
            System.out.println("");
            while (!isExitMenu) {
                System.out.print("""
                        1. Перезагрузка
                        2. Прошивка GSI
                        3. Прошивка Boot
                        Q. Выход
                        """);
                System.out.print(": ");
                String selected = input.nextLine();
                switch (selected) {
                    case "1" -> {
                        new RebootMenu().show();
                    }
                    case "2" -> {
                        new FlashGSI().start();
                    }
                    case "3" -> {
                        new FlashBoot().start();
                    }
                    case "Q", "q" -> isExitMenu = true;
                    default -> System.out.println("default test");
                }
            }
        }
    }
}