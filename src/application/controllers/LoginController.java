package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import application.database.Database;
import application.models.Admin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class LoginController implements Initializable {
	
	@FXML
	TextField username;
	@FXML
	TextField password;
	@FXML
	Button btnLogin;
	
	Database database = new Database();
	Admin admin;
	
	ArrayList<Admin> listAdmin = new ArrayList<Admin>();
	
	Map<String, String> mapAdmin = new HashMap<String, String>();
	ResultSet result;
	
	String query;
	
	
	
	
	@FXML
	public void login(ActionEvent mouseEvent)throws IOException,SQLException{
		
		database.connexion();
		
		
			
			//System.out.println("Connected");
			query = "select * from users";
			result = database.showLists(query);
			
				while(result.next())
				{
//					admin.setId(result.getInt("id"));
//					admin.setUsername(result.getString("username"));
//					admin.setPassword(result.getString("password"));
					
					admin = new Admin(result.getInt("id"),result.getString("username"),result.getString("password"));
					
					listAdmin.add(admin);
				}
				
				
				
				
			for(int i = 0; i < listAdmin.size() ; i++)
			{
				if(listAdmin.get(i).getUsername().equals(username.getText()))
						
				{
				
					if(listAdmin.get(i).getPassword().equals(password.getText()))
					{
						
						loadStage("../fxml/Home.fxml");
						
						
					}
				
				}
			
		}


		database.deConnexion();	

	
	}
	
    private void loadStage(String fxml) throws IOException{
       
//            Parent root = FXMLLoader.load(getClass().getResource(fxml));
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));
//            stage.getIcons().add(new Image("/home/icons/icon.png"));
//            stage.initModality(Modality.APPLICATION_MODAL);
//            stage.show();
    	
//            System.out.println("test success");
    	
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
    		Stage window = (Stage) btnLogin.getScene().getWindow();
    		Scene scene = new Scene(root);
    		window.setScene(scene);
	        
  
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
