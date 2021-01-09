package application.controllers;


import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.database.Database;
import application.models.Employers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class HomeController implements Initializable {
	
	
	Database database = new Database();
	String query;
	ResultSet result;
	Employers employers;
	
	ObservableList<Employers> List = FXCollections.observableArrayList();
	
    @FXML
    private Button btnManage;

    @FXML
    private Button btnshow;

    @FXML
    private Button btnAVG;
    
    
    //Show for Grid
    @FXML
    private TableView<Employers> ListShow;

    @FXML
    private TableColumn<Employers, Integer> colID;
    @FXML
    private TableColumn<Employers, String> colNom;
    @FXML
    private TableColumn<Employers, String> colPrenom;
    @FXML
    private TableColumn<Employers, Integer> colAge;
    @FXML
    private TableColumn<Employers, Integer> colDate;
    @FXML
    private TableColumn<Employers, String> colFonction;
    @FXML
    private TableColumn<Employers, Double> colSalaire;

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
    
	public void showEmployers() throws Exception, SQLException {
		
		
		
		database.connexion();
		

		//System.out.println("Connected");
		query = "select * from employers";
		result = database.showLists(query);
		
			while(result.next())
			{
					
				employers = new Employers(result.getInt("id_employe"), result.getString("nom"), result.getString("prenom"), result.getInt("age"), result.getInt("date"), result.getString("fonction"), result.getDouble("salaire"));
				List.add(employers);
	
			}
		
			System.out.println(List);

//		colID.setCellValueFactory(new PropertyValueFactory<Employers, Integer>("id"));
//		colNom.setCellValueFactory(new PropertyValueFactory<Employers, String>("nom"));
//		colPrenom.setCellValueFactory(new PropertyValueFactory<Employers, String>("prenom"));
//		colAge.setCellValueFactory(new PropertyValueFactory<Employers, Integer>("age"));
//		colDate.setCellValueFactory(new PropertyValueFactory<Employers, Integer>("date"));
//		colFonction.setCellValueFactory(new PropertyValueFactory<Employers, String>("fonction"));
//		colSalaire.setCellValueFactory(new PropertyValueFactory<Employers, Double>("salaire"));
		
		ListShow.setItems(List);
		
		
		database.deConnexion();
	}
    

	@Override	
	public void initialize(URL location, ResourceBundle resources) {
		
		try {
			
			//Show List of Employers when page loading
			showEmployers();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	
	}

}
