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
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class GridController implements Initializable {
	
	
	
	
	
	Database database = new Database();
	String query;
	ResultSet result;
	Employers employers;
	
	ObservableList<Employers> List = FXCollections.observableArrayList();
    
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
    
    
    
	
	
	
	
	
	
	
    @FXML
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
		
//			System.out.println(List);
			
//			colID = new TableColumn<Employers,Integer>("id");
//			colNom = new TableColumn<Employers,String>("nom");
//			colPrenom = new TableColumn<Employers,String>("prenom");
//			colAge = new TableColumn<Employers,Integer>("age");
//			colDate = new TableColumn<Employers,Integer>("date");
//			colFonction = new TableColumn<Employers,String>("fonction");
//			colSalaire = new TableColumn<Employers,Double>("salaire");

		colID.setCellValueFactory(new PropertyValueFactory<>("id"));
		colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
		colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
		colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
		colFonction.setCellValueFactory(new PropertyValueFactory<>("fonction"));
		colSalaire.setCellValueFactory(new PropertyValueFactory<>("salaire"));
		
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
