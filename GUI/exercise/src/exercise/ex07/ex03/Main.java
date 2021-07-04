package exercise.ex07.ex03;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                () -> {
                    final JFrame jFrame = new JFrame();
                    jFrame.setSize(800, 600);
                    jFrame.setTitle("Draw Diagonals");
                    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    jFrame.add(new JComponent() {
                        @Override
                        public void paint(final Graphics graphics) {
                            graphics.setColor(Color.RED);
                            graphics.drawRect(100, 100, 100, 100);
                        }
                    });
                    jFrame.setVisible(true);
                }
        );
    }
}
