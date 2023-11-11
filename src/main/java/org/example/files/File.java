package org.example.files;

import javax.swing.*;


public class File {

    public File() {

    }

    public String loadFile() {
        JFileChooser fileOpen = new JFileChooser("C:\\Users\\dante5453\\Downloads\\EmployeeAccountingSystem\\Capmain");
        int ret = fileOpen.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            return fileOpen.getSelectedFile().getAbsolutePath();
        }
        return null;
    }
}
