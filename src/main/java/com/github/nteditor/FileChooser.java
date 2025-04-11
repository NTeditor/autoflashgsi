package com.github.nteditor;

import java.io.File;
import javax.swing.JFileChooser;

public class FileChooser {
    private File fileChooser() {
        var jFileChooser = new JFileChooser();
        int openFileChooser = jFileChooser.showOpenDialog(null);
        if (openFileChooser == JFileChooser.APPROVE_OPTION) {
            var filePath = new File(jFileChooser.getSelectedFile().getAbsolutePath());
            return filePath;
        } else {
            System.out.println("Нажата кнопка отмены");
            return null;
        }
    }

    public File start() {
        return fileChooser();
    }
}
