package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import java.sql.*;
import java.io.IOException;
import java.util.concurrent.ExecutionException;


public class Controller {


    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Button connectionButton;

    @FXML
    void connectToDatabase(ActionEvent event) throws IOException {

        Connection conn;

        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd", username, password);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("resources/MainWindow.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = (Stage) connectionButton.getScene().getWindow();
            stage.setScene(new Scene(root1));
            stage.show();

        } catch (Exception ex) {
            /*Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            ex.printStackTrace();
            alert.setContentText(ex.getMessage());
            alert.showAndWait();*/

        }


    }


}