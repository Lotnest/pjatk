package exercise.ex12.ex01;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private Label login;
    @FXML
    private Button register_button;

    public void sayHello() {
        System.out.println("Hello!");
    }
}
