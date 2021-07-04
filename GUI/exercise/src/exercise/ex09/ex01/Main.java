package exercise.ex09.ex01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            final JFrame jFrame = new JFrame();
            final GridBagConstraints gridBagConstraints = new GridBagConstraints();
            final Dimension dimension = new Dimension(170, 20);
            final Dimension dimension1 = new Dimension(15, 20);

            jFrame.setSize(600, 100);
            jFrame.setTitle("Calculate sum");
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jFrame.setLayout(new GridBagLayout());

            final JLabel jLabelA = new JLabel("a:");
            jLabelA.setPreferredSize(dimension1);
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 0;
            jFrame.add(jLabelA, gridBagConstraints);

            final JTextField jTextFieldA = new JTextField("0");
            jTextFieldA.setPreferredSize(dimension);
            gridBagConstraints.gridx = 1;
            jFrame.add(jTextFieldA, gridBagConstraints);

            final JLabel jLabelB = new JLabel(" b:");
            jLabelB.setPreferredSize(dimension1);
            gridBagConstraints.gridx = 2;
            gridBagConstraints.gridy = 0;
            jFrame.add(jLabelB, gridBagConstraints);

            final JTextField jTextFieldB = new JTextField("0");
            jTextFieldB.setPreferredSize(dimension);
            gridBagConstraints.gridx = 3;
            gridBagConstraints.gridy = 0;
            jFrame.add(jTextFieldB, gridBagConstraints);

            final JButton jButton = new JButton("a + b");
            jButton.setPreferredSize(dimension);
            gridBagConstraints.gridx = 4;
            gridBagConstraints.gridy = 0;
            jButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(final MouseEvent e) {
                    try {
                        final long a = Long.parseLong(jTextFieldA.getText());
                        try {
                            final long b = Long.parseLong(jTextFieldB.getText());

                            jButton.setText("" + (a + b));
                        } catch (final NumberFormatException e1) {
                            jButton.setText("Invalid number in field B");
                        }
                    } catch (final NumberFormatException e1) {
                        jButton.setText("Inalid number in field A");
                    }
                }
            });
            jFrame.add(jButton, gridBagConstraints);

            jFrame.setVisible(true);
        });
    }
}
