package org.example.files;

import javax.swing.*;


public class File {

    private final JFrame frame;
    public File() {
        frame = new JFrame();
        frame.setVisible(false);
        BringToFront();
    }

    public String loadFile() {
        JFileChooser fileOpen = new JFileChooser("Capmain");
        int ret = fileOpen.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            return fileOpen.getSelectedFile().getAbsolutePath();
        } else {
            System.out.println("Файл не выбран");
            System.exit(1);
        }
        return null;
    }

    private void BringToFront() {
        frame.setExtendedState(JFrame.ICONIFIED);
        frame.setExtendedState(JFrame.NORMAL);
    }
}
