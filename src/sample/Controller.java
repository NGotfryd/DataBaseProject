package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.Entity.Adres;
import sample.Entity.Pracownik;
import java.io.IOException;
import javafx.fxml.FXMLLoader;


public class Controller {

   // private Stage stage;
   // private Scene scene;
  //  private Parent root;

    @FXML
    private Pane addPracownikButton;

    @FXML
    private Button newPracownikButton;

    @FXML
    public void newPracownik(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PracownikTab.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = (Stage) newPracownikButton.getScene().getWindow();
        stage.setScene(new Scene(root1));
        stage.show();


    }

}
  /**  Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Something went wrong classnotfound-exc!");
                alert.showAndWait();*/