package application.controllers;


import java.net.URL;

import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.stage.Stage;

public class HomeController implements Initializable {
	
	


	
    @FXML
    private Button btnManage;

    @FXML
    private Button btnshow;

    @FXML
    private Button btnAVG;
    

	
//	public HomeController() {
//		
//		List = FXCollections.observableArrayList();
//		ListShow = new TableView<Employers>();
//		
//	}



    //my bad - the freaking mouse event
    @FXML
    private void Rederiction(javafx.event.ActionEvent mouseEvent){
    	
    	try {	
		        if (mouseEvent.getSource() == btnManage) {
		            loadStage("../fxml/ManageEmploye.fxml");
		        } else if (mouseEvent.getSource() == btnshow) {
		            loadStage("../fxml/ListEmployers.fxml");
		            
		        } else if (mouseEvent.getSource() == btnAVG) {
		            loadStage("../fxml/AvgSalary.fxml");
		        }
        
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println(e.getMessage());
	    }
    }
    
    
    private void loadStage(String fxml)  throws Exception {
        
    
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            
  
}
    

    

	@Override	
	public void initialize(URL location, ResourceBundle resources) {
		

	
	}

}
