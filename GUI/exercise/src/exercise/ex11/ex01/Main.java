package exercise.ex11.ex01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(final Stage stage) {
        final String initialButtonText = "Hello world!";
        final Button button = new Button(initialButtonText);
        button.setOnMouseClicked(mouseEvent -> {
            if (!button.getText().equals(initialButtonText)) {
                button.setText(initialButtonText);
            } else {
                button.setText("Hi");
            }
        });

        final StackPane root = new StackPane();

        root.getChildren().add(button);

        final Scene scene = new Scene(root, 250, 50);

        stage.setTitle("Exercise 1");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
