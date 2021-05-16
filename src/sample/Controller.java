package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;


public class Controller {

;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Button connectionButton;

    @FXML
    void connectToDatabase(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("resources/MainWindow.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = (Stage) connectionButton.getScene().getWindow();
        stage.setScene(new Scene(root1));
        stage.show();
    }



}
  /**  Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Something went wrong classnotfound-exc!");
                alert.showAndWait();*/