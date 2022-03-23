package run;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;
import controller.Controller;

import javax.swing.*;

public class Runner {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
            new Controller();
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
    }
}
