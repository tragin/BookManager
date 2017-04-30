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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.*;

public class ChangePasswordController {

    @FXML
    private Button logoutBtn;

    @FXML
    private Button changeBtn;

    @FXML
    private Button homeBtn;

    @FXML
    private TextField newPWord;
    
    @FXML
    private Text errorMessage;

    @FXML
    private TextField newPWord2;

    @FXML
    void homeFired(ActionEvent event) throws Exception {
        Parent root;
        Stage stage;
        
        stage= (Stage) logoutBtn.getScene().getWindow();
        String sceneType = null;
        switch(Test.getUserType()){
            case "student": sceneType = "/Student Menu.fxml";
                break;
            case "staff": sceneType = "/Staff Menu.fxml";
                break;
            case "admin": sceneType = "/Admin Menu.fxml";
                break;
            case "teacher": sceneType = "/Teacher Menu.fxml";
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
        root= FXMLLoader.load(getClass().getResource("/FXML.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void changeFired(ActionEvent event) throws Exception{
        String newP = newPWord.getText();
        String newP2 = newPWord2.getText();
        if(newP.equals(newP2)) {
            Connection con1 = null;


            try {
                String sqlhost = "jdbc:mysql://localhost:3306/bookmanager?useSSH=false"; //This will be host of mysql server (localhost:3306)
                String login = "root";
                String pass = "pwnage";

                Class.forName("com.mysql.jdbc.Driver");

                con1 = DriverManager.getConnection(sqlhost, login, pass);

                if(con1 != null){
                    System.out.println("Connection success!");
                }

            } catch (SQLException ex) {
                System.out.println("An error occurred.");
                ex.printStackTrace();
            }

            try {
                PreparedStatement stmt = null;
                String loginUpdate = Test.getLoginName();
                String query = "update staff " +
                        "set password = ?" +
                        " where loginID= ?";

                ResultSet rs = null;
                stmt = con1.prepareStatement(query);
                stmt.setString(1, newP);
                stmt.setString(2, loginUpdate);
                stmt.executeUpdate();
                errorMessage.setText("Password successfully updated!");

            } catch (SQLException ex2 ){
                System.out.println("Password reset failed.");
                ex2.printStackTrace();
            }
        }
        else
        {
            errorMessage.setText("Passwords do not match.");
            newPWord.setText("");
            newPWord2.setText("");
            newPWord.requestFocus();
        }
    }

}