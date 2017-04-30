/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class StaffMenuController {

    @FXML
    private Button logoutBtn;

    @FXML
    private Button changePWBtn;

    @FXML
    private Button searchBtn;

    @FXML
    private Button bookrtnBtn;
    
    @FXML
    private Button registerBtn;

    @FXML
    void logoutFired(ActionEvent event)throws Exception {
        Parent root;
        Stage stage;
        
        stage= (Stage) logoutBtn.getScene().getWindow();
        root= FXMLLoader.load(getClass().getResource("/FXML.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void searchFired(ActionEvent event)throws Exception {
        Parent root;
        Stage stage;
        
        stage= (Stage) logoutBtn.getScene().getWindow();
        root= FXMLLoader.load(getClass().getResource("/Search_FXML.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void bookReturnFired(ActionEvent event) throws Exception {
        Parent root;
        Stage stage;
        
        stage= (Stage) logoutBtn.getScene().getWindow();
        root= FXMLLoader.load(getClass().getResource("/BookReturnFXML.fxml"));
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
    
    @FXML
    void registerFired(ActionEvent event) throws Exception
    {
        Parent root;
        Stage stage;
        
        stage=(Stage) registerBtn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/Book Register.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
