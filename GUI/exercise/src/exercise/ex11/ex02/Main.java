package exercise.ex11.ex02;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(final Stage stage) {
        final GridPane root = new GridPane();
        root.setPadding(new Insets(5, 15, 0, 5));

        final Scene scene = new Scene(root, 540, 40);

        final double width1 = 170.0;
        final double height1 = 20.0;
        final double width2 = 15.0;
        final double height2 = 20.0;

        final Label labelA = new Label("a:");
        labelA.setPrefSize(width2, height2);
        root.add(labelA, 0, 0);

        final TextField textFieldA = new TextField("0");
        textFieldA.setPrefSize(width1, height1);
        root.add(textFieldA, 1, 0);

        final Label labelB = new Label("b:");
        labelB.setPrefSize(width2, height2);
        root.add(labelB, 2, 0);

        final TextField textFieldB = new TextField("0");
        textFieldB.setPrefSize(width1, height1);
        root.add(textFieldB, 3, 0);

        final Button button = new Button("a + b");
        button.setPrefSize(width1, height1);
        button.setOnMouseClicked(mouseEvent -> {
            try {
                final long a = Long.parseLong(textFieldA.getText());
                try {
                    final long b = Long.parseLong(textFieldB.getText());
                    button.setText("" + (a + b));
                } catch (NumberFormatException e) {
                    button.setText("Invalid number in field B");
                }
            } catch (NumberFormatException e) {
                button.setText("Invalid number in field A");
            }
        });
        root.add(button, 4, 0);

        stage.setTitle("Calculate sum");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
