package test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class FXMLController {

    @FXML
    private PasswordField password;

    @FXML
    private Button login;

    @FXML
    private TextField username;
    
    @FXML
    private Text pwFail;

    @FXML
    void goButtonFired(ActionEvent event) throws Exception {
        
            Stage stage; 
            Parent root2;
            System.out.println("There it goes");
            System.out.println(username.getText());
            String pWord=password.getText();
            String uName=username.getText();

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

            //CLOSE CONNECTION!!!

            try {
                PreparedStatement stmt;
                String query = "select password, userType, loginID " +
                        "from bookmanager.user" +
                        " where loginID= ?";

                ResultSet rs = null;
                stmt = con1.prepareStatement(query);
                stmt.setString(1, uName);
                rs = stmt.executeQuery();

                if (rs.next() && (rs.getString("password").equals(pWord))){

                /*while (rs.next()){
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    String staffID = rs.getString("staffID");
                    System.out.println(firstName + " " + lastName + " has staff ID: " + staffID);*/
                   Test.setLoginName(rs.getString("loginID"));
                   Test.setUserType(rs.getString("userType"));
                   String sceneType = null;
                   switch (Test.getUserType()){
                       case "staff": sceneType = "/Staff Menu.fxml";
                                    break;
                       case "teacher": sceneType = "/Teacher Menu.fxml";
                                    break;
                       case "admin": sceneType = "/Admin Menu.fxml";
                                    break;
                       case "student": sceneType = "/Student Menu.fxml";
                                    break;
                   }

                    stage=(Stage) login.getScene().getWindow();
                    //load up OTHER FXML document
                    root2 = FXMLLoader.load(getClass().getResource(sceneType));

                    Scene scene = new Scene(root2);
                    stage.setScene(scene);
                    stage.show();
                }
                else {
                    password.setText("");
                    password.requestFocus();
                    pwFail.setText("Incorrect Password, please try again");
                }

            } catch (SQLException ex2 ){
                System.out.println("No result in table.");
                ex2.printStackTrace();
            }


            /*//System.out.println(password.getText());
            if(pWord.equals("Moctezuma") && (!(username.getText()).equals("")))
            {
                pwFail.setText("");
                System.out.println("You may enter");
                password.setText("");
                username.setText("");
                stage=(Stage) login.getScene().getWindow();
                //load up OTHER FXML document
                root2 = FXMLLoader.load(getClass().getResource("/Student Menu.fxml"));
      
     
                //create a new scene with root and set the stage
                Scene scene = new Scene(root2);
                stage.setScene(scene);
                stage.show();
               
            }
            else if(pWord.equals("Ragin") && (!(uName.equals(""))))
            {
                stage=(Stage) login.getScene().getWindow();
                //load up OTHER FXML document
                root2 = FXMLLoader.load(getClass().getResource("/Admin Menu.fxml"));
      
     
                //create a new scene with root and set the stage
                Scene scene = new Scene(root2);
                stage.setScene(scene);
                stage.show();
            }   
            else if(pWord.equals("Azadeh") && (!(uName.equals(""))))
            {
                stage=(Stage) login.getScene().getWindow();
                //load up OTHER FXML document
                root2 = FXMLLoader.load(getClass().getResource("/Staff Menu.fxml"));
      
     
                //create a new scene with root and set the stage
                Scene scene = new Scene(root2);
                stage.setScene(scene);
                stage.show();
            }     
            else if(pWord.equals("Patil") && (!(uName.equals(""))))
            {
                stage=(Stage) login.getScene().getWindow();
                //load up OTHER FXML document
                root2 = FXMLLoader.load(getClass().getResource("/Teacher Menu.fxml"));
      
     
                //create a new scene with root and set the stage
                Scene scene = new Scene(root2);
                stage.setScene(scene);
                stage.show();
            }     
        
            else
            {
                password.setText("");
                password.requestFocus();
                pwFail.setText("Incorrect Password, please try again");
            }*/
        
    }
}
