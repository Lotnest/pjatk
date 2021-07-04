package exercise.ex11.ex00;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorld extends Application {

    @Override
    public void start(final Stage stage) {
        final Label label = new Label("Hello World");
        final StackPane root = new StackPane();

        root.getChildren().add(label);

        final Scene scene = new Scene(root, 250, 50);

        stage.setTitle("Hello World Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
