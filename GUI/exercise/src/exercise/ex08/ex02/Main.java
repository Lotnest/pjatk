package exercise.ex08.ex02;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                () -> {
                    final JFrame jFrame = new JFrame();

                    jFrame.setSize(800, 600);
                    jFrame.setTitle("Simple Chat");
                    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    jFrame.setLayout(new GridBagLayout());

                    final GridBagConstraints gridBagConstraints = new GridBagConstraints();

                    final JTextField jTextField = new JTextField();
                    gridBagConstraints.gridx = 0;
                    gridBagConstraints.gridy = 0;
                    gridBagConstraints.gridwidth = 0;
                    gridBagConstraints.weightx = 1;
                    gridBagConstraints.weighty = 0.5;
                    gridBagConstraints.fill = GridBagConstraints.BOTH;
                    jFrame.add(jTextField, gridBagConstraints);

                    final JTextArea jTextArea = new JTextArea();
                    gridBagConstraints.gridx = 0;
                    gridBagConstraints.gridy = 1;
                    gridBagConstraints.gridwidth = 1;
                    gridBagConstraints.weightx = 0.5;
                    gridBagConstraints.weighty = 0.5;
                    gridBagConstraints.fill = GridBagConstraints.BOTH;
                    jFrame.add(jTextArea, gridBagConstraints);

                    final JButton jButton = new JButton();
                    jButton.setText("Send");
                    gridBagConstraints.gridx = 1;
                    gridBagConstraints.gridy = 1;
                    gridBagConstraints.gridwidth = 1;
                    gridBagConstraints.weightx = 0.5;
                    gridBagConstraints.weighty = 0.5;
                    gridBagConstraints.fill = GridBagConstraints.BOTH;

                    jButton.addActionListener(actionEvent -> jTextField.setText(jTextField.getText() + "\n" + jTextArea.getText()));

                    jFrame.add(jButton, gridBagConstraints);

                    jFrame.setVisible(true);
                }
        );
    }
}
