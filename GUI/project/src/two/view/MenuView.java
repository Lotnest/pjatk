package two.view;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import two.MemoryCardGame;
import two.controller.MemoryCardController;

import java.io.IOException;
import java.util.Objects;

public class MenuView {

    @FXML
    private Button newGameButton, highScoreButton;

    private final Class<MemoryCardGame> memoryCardGameClass = MemoryCardGame.class;

    @FXML
    private void newGame() throws IOException {
        final FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(memoryCardGameClass.getResource("/game.fxml"));
        fxmlLoader.load();

        final Stage stage = (Stage) newGameButton.getScene().getWindow();

        final MemoryCardController memoryCardController = fxmlLoader.getController();
        memoryCardController.newGame();
        stage.getScene().setRoot(fxmlLoader.getRoot());
    }

    @FXML
    private void highScore() throws IOException {
        final Parent root = FXMLLoader.load(Objects.requireNonNull(memoryCardGameClass.getResource("/highScore.fxml")));
        final Stage stage = (Stage) highScoreButton.getScene().getWindow();
        stage.getScene().setRoot(root);
    }

    @FXML
    private void exit() {
        Platform.exit();
    }
}
