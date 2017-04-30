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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController {

    @FXML
    private Button logoutBtn;

    @FXML
    private Button registerButton;

    @FXML
    private TextField bookISBN;

    @FXML
    private Button homeBtn;

    @FXML
    void homeFired(ActionEvent event) throws Exception{
        Parent root;
        Stage stage;
        
        stage= (Stage) logoutBtn.getScene().getWindow();
        String sceneType = null;
        switch(Test.getUserType()){
            case "staff": sceneType = "/Staff Menu.fxml";
                            break;
            case "admin": sceneType = "/Admin Menu.fxml";
                            break;
        }
        root= FXMLLoader.load(getClass().getResource(sceneType));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void logoutFired(ActionEvent event) throws Exception {
        Parent root;
        Stage stage;
        
        stage= (Stage) logoutBtn.getScene().getWindow();
        root= FXMLLoader.load(getClass().getResource("FXML.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void registerFired(ActionEvent event) {
        //connect to db to see if isbn is there...if it is, update current book
        //if not, insert a new record and set it's initial values
        //this method makes me think that checkout will be strange tho...and how do we know if it's
        //out or in? is book id per book? or per isbn?
        if(bookISBN.getText().equals("12345"))
            System.out.println("YAY");
        else
            System.out.println("Nothing Found");
    }

}
