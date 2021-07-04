package two.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HighScoreView {

    @FXML
    private Button backButton;

    @FXML
    private void back() throws IOException {
        final Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mainMenu.fxml")));
        final Stage stage = (Stage) backButton.getScene().getWindow();
        stage.getScene().setRoot(root);
    }
}
