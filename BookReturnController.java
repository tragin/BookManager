package test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.*;

public class BookReturnController {

    @FXML
    private Button logoutBtn;

    @FXML
    private Button rtnButton;

    @FXML
    private Button homeBtn;

    @FXML
    private TextField bookID;
    
    @FXML
    private TextField courseID;

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
    void returnFired(ActionEvent event) throws Exception {
        String ID= bookID.getText();
        String newStatus = null;
        //query using ID in book table...and check status. If checked out, return it. If checked in, check it out
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
            PreparedStatement stmt;
            String query = "select status, bookID, issuedDate " +
                    "from bookmanager.Books " +
                    "where bookID= ?";

            ResultSet rs = null;
            stmt = con1.prepareStatement(query);
            stmt.setString(1, ID);
            rs = stmt.executeQuery();

            if(rs.next()){
                //System.out.println(rs.getString("status"));
                if((rs.getString("status").equals("out"))){
                    //update to checked in
                    newStatus = "in";
                    PreparedStatement stmt1 = null;
                    String query1 = "update books " +
                            "set issuedDate = ?, status = ?" +
                            " where bookID= ?";

                    System.out.println(newStatus);
                    stmt1 = con1.prepareStatement(query1);
                    stmt1.setString(1, "2017-04-30");
                    stmt1.setString(2, newStatus);
                    stmt1.setString(3, ID);
                    stmt1.executeUpdate();
                }
                else {
                    //update to checked out, change issuedDate to TODAY
                    newStatus = "out";
                    PreparedStatement stmt2 = null;
                    String query2 = "update books " +
                            "set issuedDate = ?, status = ?" +
                            " where bookID= ?";

                    stmt2 = con1.prepareStatement(query2);
                    stmt2.setString(1, "2017-04-30");
                    stmt2.setString(2, newStatus);
                    stmt2.setString(3, ID);
                    stmt2.executeUpdate();
                }
            } else {
                //no result...so what do we print?
                bookID.setText("failed, try again");
                bookID.requestFocus();
            }

        } catch (SQLException ex2 ){
            System.out.println("No result in table.");
            ex2.printStackTrace();
        }
}
