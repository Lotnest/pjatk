package exercise.ex13.ex01;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

    @Override
    public void start(final Stage primaryStage) throws Exception {
        final URL resource = getClass().getResource("app.fxml");
        if (resource != null) {
            final Parent root = FXMLLoader.load(resource);

            primaryStage.setTitle("Simple Login");
            primaryStage.setScene(new Scene(root, 300, 275));
            primaryStage.show();
        } else {
            throw new IllegalStateException("Could not load app.fxml");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
