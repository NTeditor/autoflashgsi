package com.github.nteditor;

public class FlashGSI {
    public FlashGSI() {}

    private void flash() {
        System.out.println("Прошивка GSI");
        var filePath = new FileChooser().start();
        if (filePath == null) {
            System.out.println(filePath);
        } else {
            new Shell(new String[]{"fastboot", "reboot", "fastboot"});
            System.out.println("Очистка System..");
            new Shell(new String[]{"fastboot", "erase", "system"});
            System.out.println("Удаление раздела product_a..");
            new Shell(new String[]{"fastboot", "delete-logical-partition", "product_a"});
            System.out.println("Удаление раздела product_b..");
            new Shell(new String[]{"fastboot", "delete-logical-partition", "product_b"});
            System.out.println("Прошивка System..");
            new Shell(new String[]{"fastboot", "flash", filePath.toString()});
            System.out.println("Перезагрузка в Recovery..");
            new Shell(new String[]{"fastboot", "reboot", "recovery"});
            System.out.println("Прошивка завершена, сделайте сброс настроек через Recovery и перезагрузитесь в систему.");
        }
    }

    public void start() {
        flash();
    }
}
