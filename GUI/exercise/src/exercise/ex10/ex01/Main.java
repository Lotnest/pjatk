package exercise.ex10.ex01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            final JFrame jFrame = new JFrame();

            jFrame.setSize(700, 700);
            jFrame.setTitle("ImageIcon");
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jFrame.setLayout(new GridBagLayout());

            final JLabel jLabel = new JLabel();
            final ImageIcon imageIconCodingStill = new ImageIcon("src/exercise/ex10/ex01/coding-still-cant-figure-out-issue.jpg");
            jLabel.setIcon(imageIconCodingStill);

            final ImageIcon imageIconThank = new ImageIcon("src/exercise/ex10/01/thank-goodness-i-took-that-coding-course.gif");

            final JButton jButton = new JButton("Next image");
            jButton.setPreferredSize(new Dimension(100, 20));
            jButton.addMouseListener(new MouseAdapter() {
                int imageState = 0;

                @Override
                public void mouseClicked(final MouseEvent e) {
                    if (imageState == 0) {
                        imageState = 1;
                        jLabel.setIcon(imageIconThank);
                    } else {
                        imageState = 0;
                        jLabel.setIcon(imageIconCodingStill);
                    }
                }
            });
            jFrame.add(jButton);
            jFrame.add(jLabel);

            jFrame.setVisible(true);
        });
    }
}
