package com.github.nteditor;

public class FlashBoot {
    public FlashBoot() {}

    private void flash() {
        System.out.println("Прошивка Boot");
        var filePath = new FileChooser().start();
        if (filePath == null) {
            System.out.println(filePath);
        } else {
            new Shell(new String[]{"fastboot", "flash", "boot", filePath.toString()}).start();
        }
    }

    public void start() {
        flash();
    }
}
