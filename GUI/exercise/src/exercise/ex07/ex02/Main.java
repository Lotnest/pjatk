package exercise.ex07.ex02;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                () -> {
                    final JFrame jFrame = new JFrame();
                    jFrame.setSize(800, 600);
                    jFrame.setTitle("Simple Text Editor");
                    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    jFrame.add(createJTextArea(Color.YELLOW, Color.BLUE, Font.DIALOG, 24, Font.TRUETYPE_FONT));
                    jFrame.setLayout(new FlowLayout());
                    jFrame.setVisible(true);
                }
        );
    }

    public static JTextArea createJTextArea(final Color backgroundColor, final Color textColor, final String fontName, final int fontSize, final int fontStyle) {
        final JTextArea jTextArea = new JTextArea();
        jTextArea.setBackground(backgroundColor);
        jTextArea.setForeground(textColor);
        jTextArea.setSelectedTextColor(textColor);
        jTextArea.setFont(new Font(fontName, fontStyle, fontSize));
        jTextArea.setVisible(true);
        return jTextArea;
    }
}
