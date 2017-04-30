package test;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import javafx.scene.text.Text;
import javafx.stage.Stage;



public class Search_Controller {
    
    

    @FXML
    private TextField searchField;

    @FXML
    private TableView<String> searchList;
    
    @FXML
    TableColumn <String,String> stype;
    
    @FXML
    TableColumn <String,String> results;
    
    @FXML
    TableColumn <String,String> status;

    @FXML
    private ComboBox<String> searchbox;
    
    @FXML
    private Text searchMsg;
    
   
    
    @FXML
    void searchFired(ActionEvent event) {
        searchMsg.setText("");
        String key1=searchbox.getValue();
        String key2=searchField.getText();
        
        if(key1==null)
        {
            searchMsg.setText("Please select a search Type.");
        }
        else   
        {
            System.out.println(key1+" " +key2);
            
            
 
        
        }
    }
    
    
    @FXML
    void logoutFired(ActionEvent event) throws Exception
    {
        Parent root;
        Stage stage;
        
        stage= (Stage) logoutBtn.getScene().getWindow();
        root= FXMLLoader.load(getClass().getResource("FXML.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        
        
    }
    
    @FXML
    private Button searchButton;
    
    @FXML
    private Button logoutBtn;
    
    @FXML
    private Button homeBtn;
    
    @FXML
    void homeFired(ActionEvent event) throws Exception
    {
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
    
}

