package com.github.nteditor;

import java.util.Scanner;

public class RebootMenu {
    public RebootMenu() {}

    private void rebootMenu() {
        var input = new Scanner(System.in);
        boolean isExitRebootMenu = false;
        System.out.println("");
        while (!isExitRebootMenu) {
            System.out.print("""
                1. System -> FastbootD
                2. System -> Recovery
                3. FastbootD -> System
                4. FastbootD -> Recovery
                Q. Exit
                """);
            System.out.print(": ");
            String selectedReboot = input.nextLine();
            System.out.println("");
            switch (selectedReboot) {
                case "1" -> {
                    System.out.println("Перезагрузка в FastbootD");
                    new Shell(new String[]{"adb", "reboot", "fastboot"}).start();
                }
                case "2" -> {
                    System.out.println("Перезагрузка в Recovery");
                    new Shell(new String[]{"adb", "reboot", "recovery"}).start();
                }
                case "3" -> {
                    System.out.println("Перезагрузка в System");
                    new Shell(new String[]{"fastboot", "reboot", "recovery"}).start();
                }
                case "4" -> {
                    System.out.println("Перезагрузка в Recovery");
                    new Shell(new String[]{"fastboot", "reboot", "recovery"}).start();
                }
                case "Q", "q" -> isExitRebootMenu = true;
                default -> System.out.println("Default test");
            }
        }
        
    }

    public void show() {
        rebootMenu();
    }
}
