package exercise.ex08.ex01;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                () -> {
                    final JFrame jFrame = new JFrame();

                    jFrame.setSize(300, 200);
                    jFrame.setTitle("GridBagLayout Demo");
                    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    jFrame.setLayout(new GridBagLayout());

                    final GridBagConstraints gridBagConstraints = new GridBagConstraints();

                    final JButton jButton1 = new JButton();
                    jButton1.setText("Button 1");
                    gridBagConstraints.gridx = 0;
                    gridBagConstraints.gridy = 0;
                    jFrame.add(jButton1, gridBagConstraints);

                    final JButton jButton2 = new JButton();
                    jButton2.setText("Button 2");
                    gridBagConstraints.gridx = 1;
                    gridBagConstraints.gridy = 0;
                    jFrame.add(jButton2, gridBagConstraints);

                    final JButton jButton3 = new JButton();
                    jButton3.setText("Button 3");
                    gridBagConstraints.gridx = 2;
                    gridBagConstraints.gridy = 0;
                    jFrame.add(jButton3, gridBagConstraints);

                    final JButton jButton4 = new JButton();
                    jButton4.setText("Button 4");
                    gridBagConstraints.gridx = 0;
                    gridBagConstraints.gridy = 1;
                    gridBagConstraints.fill = GridBagConstraints.BOTH;
                    gridBagConstraints.gridwidth = 3;
                    jFrame.add(jButton4, gridBagConstraints);

                    final JButton jButton5 = new JButton();
                    jButton5.setText("Button 5");
                    gridBagConstraints.gridx = 1;
                    gridBagConstraints.gridy = 2;
                    gridBagConstraints.gridwidth = 2;
                    gridBagConstraints.fill = GridBagConstraints.BOTH;
                    jFrame.add(jButton5, gridBagConstraints);

                    final JButton jButton6 = new JButton();
                    jButton6.setText("Button 6");
                    gridBagConstraints.gridx = 1;
                    gridBagConstraints.gridy = 3;
                    gridBagConstraints.gridwidth = 1;
                    jFrame.add(jButton6, gridBagConstraints);

                    final JButton jButton7 = new JButton();
                    jButton7.setText("Button 7");
                    gridBagConstraints.gridx = 0;
                    gridBagConstraints.gridy = 2;
                    gridBagConstraints.gridheight = 2;
                    gridBagConstraints.fill = GridBagConstraints.BOTH;
                    jFrame.add(jButton7, gridBagConstraints);

                    jFrame.setVisible(true);
                }
        );
    }
}
