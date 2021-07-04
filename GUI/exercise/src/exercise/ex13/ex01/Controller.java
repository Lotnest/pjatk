package exercise.ex13.ex01;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private Label login;
    @FXML
    private Label password;

    public void sayHello() {
        System.out.println("Hello!");
    }
}
