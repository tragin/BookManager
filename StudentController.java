package test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class StudentController {

    @FXML
    private Button logoutBtn;

    @FXML
    private Button changePWBtn;

    @FXML
    private ListView<String> schedulelist;

    @FXML
    void logoutFired(ActionEvent event) throws Exception {
        Parent root;
        Stage stage;
        
        stage= (Stage) logoutBtn.getScene().getWindow();
        root= FXMLLoader.load(getClass().getResource("/FXML.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void changePWFired(ActionEvent event) throws Exception{
         Parent root;
        Stage stage;
        
        stage= (Stage) logoutBtn.getScene().getWindow();
        root= FXMLLoader.load(getClass().getResource("/ChangePWordFXML.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

