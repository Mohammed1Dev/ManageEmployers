package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
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

    //my bad - the freaking mouse event
    @FXML
    private void Rederiction(ActionEvent mouseEvent) throws IOException {
    	
        //if (mouseEvent.getSource() == btnManage) {
            loadStage(btnManage, "../fxml/ManageEmploye.fxml");
        //} else if (mouseEvent.getSource() == btnshow) {
            loadStage(btnshow, "../fxml/ListEmployers.fxml");
        //} else if (mouseEvent.getSource() == btnAVG) {
            loadStage(btnAVG, "../fxml/AvgSalary.fxml");
        //}
    }
    
    
    private void loadStage(Button btn, String fxml) throws IOException{
        
	
      Parent root = FXMLLoader.load(getClass().getResource(fxml));
		Stage window = (Stage) btn.getScene().getWindow();
		Scene scene = new Scene(root);
		window.setScene(scene);
      

}

@Override
public void initialize(URL location, ResourceBundle resources) {

}

}
