package two;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class MemoryCardGame extends Application {

    @Override
    public void start(final Stage primaryStage) throws Exception {
        final Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mainMenu.fxml")));
        final Scene scene = new Scene(root, 1920, 1020);

        primaryStage.setTitle("Memory Card Game");
        primaryStage.setResizable(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
