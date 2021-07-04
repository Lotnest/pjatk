package exercise.ex10.ex02;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            final JFrame jFrame = new JFrame();

            jFrame.setSize(700, 700);
            jFrame.setTitle("ImageIcon");
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jFrame.setLayout(new GridBagLayout());

            final JTable jTable = new JTable();

            jFrame.setVisible(true);
        });
    }
}
