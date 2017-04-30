/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Daniel
 */
public class Test extends Application {
    Stage stage;
    String myName;
    Scene scene1;
    Parent root;

    private static String loginName = null;
    private static String userType = null;

    @Override
    public void start(Stage primaryStage) throws Exception {

        stage = primaryStage;
        root = FXMLLoader.load(getClass().getResource("/FXML.fxml"));
        //Parent root2 = FXMLLoader.load(getClass().getResource("Search_FXML.fxml"));

        scene1 = new Scene(root, 600, 400);
        //Scene scene2= new Scene(root2,600,400);

        stage.setTitle("FXML Welcome");
        stage.setScene(scene1);
        stage.show();
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }


    public static void setLoginName(String loginName) {
        Test.loginName = loginName;
    }

    public static String getLoginName() {
        return loginName;
    }


    public static void setUserType(String userType) {
        Test.userType = userType;
    }

    public static String getUserType() {
        return userType;
    }
}