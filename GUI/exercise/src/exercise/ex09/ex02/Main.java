package exercise.ex09.ex02;

import exercise.ex09.ex02.grocery.Fruit;
import exercise.ex09.ex02.grocery.Vegetable;

import javax.swing.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            final JFrame jFrame = new JFrame();

            jFrame.setSize(600, 120);
            jFrame.setTitle("Grocery list");
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            final JList<String> jList = new JList<>();

            final DefaultListModel<String> defaultListModel = new DefaultListModel<>();
            defaultListModel.addAll(Arrays.stream(Fruit.values()).map(Fruit::getName).collect(Collectors.toList()));
            defaultListModel.addAll(Arrays.stream(Vegetable.values()).map(Vegetable::getName).collect(Collectors.toList()));

            jList.setModel(defaultListModel);
            jFrame.add(new JScrollPane(jList));

            jFrame.setVisible(true);
        });
    }
}
