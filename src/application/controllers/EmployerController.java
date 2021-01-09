package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


import application.database.Database;
import application.models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EmployerController implements Initializable {
	
	
	Employe employer;
	String query = "";
	
	Database database = new Database();
	boolean res;
	
	//Employer Input
	@FXML
	TextField nameText;
	@FXML
	TextField prenomText;
	@FXML
	TextField ageText;
	@FXML
	TextField dateText;
	@FXML
	ComboBox<String> fonctionsList;
	@FXML
	TextField nbrunit;
	@FXML
	TextField chiffre;
	@FXML
	TextField nbrheurs;
	@FXML
	TextField salair;
	
	@FXML
	Label labelunit;
	@FXML
	Label labelChiffre;
	@FXML
	Label LabelNberHeur;
	
	@FXML
	Label check;
	
	//Crud Button
	@FXML
	Button btnAjout;
	@FXML
	Button btnUpdate;
	@FXML
	Button btnDelete;
	@FXML
	Button btnClear;
	
	
	ObservableList<String> typeList = FXCollections.observableArrayList(
			"vendeur",
			"representeur",
			"producteur",
			"Manutentionaire"
	    );
	

	@FXML
	public void FillComboBx()throws Exception{
		
		fonctionsList.setItems(typeList);
		fonctionsList.getSelectionModel().selectFirst();
		
		labelChiffre.setVisible(true);
		chiffre.setVisible(true);
		
	}
	
	@FXML
	public void selectFunction()throws Exception{
		
		if(fonctionsList.getSelectionModel().getSelectedItem().equals("vendeur"))
		{
			labelChiffre.setVisible(true);
			chiffre.setVisible(true);
			
			labelunit.setVisible(false);
			nbrunit.setVisible(false);
			
			LabelNberHeur.setVisible(false);
			nbrheurs.setVisible(false);
			
		}else if(fonctionsList.getSelectionModel().getSelectedItem().equals("representeur"))
		{
			labelChiffre.setVisible(true);
			chiffre.setVisible(true);
			
			labelunit.setVisible(false);
			nbrunit.setVisible(false);
			
			LabelNberHeur.setVisible(false);
			nbrheurs.setVisible(false);
			
		}else if(fonctionsList.getSelectionModel().getSelectedItem().equals("producteur"))
		{
			labelChiffre.setVisible(false);
			chiffre.setVisible(false);
			
			labelunit.setVisible(true);
			nbrunit.setVisible(true);
			
			LabelNberHeur.setVisible(false);
			nbrheurs.setVisible(false);
			
		}else if(fonctionsList.getSelectionModel().getSelectedItem().equals("Manutentionaire"))
		{
			labelChiffre.setVisible(false);
			chiffre.setVisible(false);
			
			labelunit.setVisible(false);
			nbrunit.setVisible(false);
			
			LabelNberHeur.setVisible(true);
			nbrheurs.setVisible(true);
		}
		
	}
	
	

	
	
	@FXML
	public void insertEmployer(ActionEvent mouseEvent){
		
		try {
		
		if(mouseEvent.getSource() == btnAjout) {
			
			database.connexion();
			
			if(fonctionsList.getSelectionModel().getSelectedItem().equals("vendeur"))
			{
				
			
				employer = new Vendeur(nameText.getText(), prenomText.getText(), Integer.parseInt(ageText.getText()), Integer.parseInt(dateText.getText()), Double.parseDouble(chiffre.getText()));
				String salary = ""+employer.calculeSalaire();
				salair.setText(salary);
				query = "INSERT INTO employers values(null,'"+nameText.getText()+"','"+prenomText.getText()+"',"+employer.getAge()+","+employer.getDate()+",'"+employer.function()+"',"+employer.calculeSalaire()+")";
				res = database.insertOne(query);

				if(res == true) {
					check.setText("Ajout Effectué avec Succes");
				}	
				else {
					check.setText("Error!!!Ajout Failed");
				}
					
				
				//salair.setText(employer.calculeSalaire());  
				
			}else 
			if(fonctionsList.getSelectionModel().getSelectedItem().equals("representeur"))
			{
				employer = new Representeur(nameText.getText(), prenomText.getText(), Integer.parseInt(ageText.getText()), Integer.parseInt(dateText.getText()), Double.parseDouble(chiffre.getText()));
				String salary = ""+employer.calculeSalaire();
				salair.setText(salary);
				query = "insert into employers values(null,'"+nameText.getText()+"','"+prenomText.getText()+"',"+employer.getAge()+","+employer.getDate()+",'"+employer.function()+"',"+employer.calculeSalaire()+")";
				res = database.insertOne(query);
				
				if(res == true)
					check.setText("Ajout Effectué avec Succes");
				else
					check.setText("Error!!!Ajout Failed");
				
				
			}else if(fonctionsList.getSelectionModel().getSelectedItem().equals("producteur"))
			{
				
				employer = new Producteur(nameText.getText(), prenomText.getText(), Integer.parseInt(ageText.getText()), Integer.parseInt(dateText.getText()), Integer.parseInt(nbrunit.getText()));
				String salary = ""+employer.calculeSalaire();
				salair.setText(salary);
				query = "insert into employers values(null,'"+nameText.getText()+"','"+prenomText.getText()+"',"+employer.getAge()+","+employer.getDate()+",'"+employer.function()+"',"+employer.calculeSalaire()+")";
				res = database.insertOne(query);
				if(res == true)
					check.setText("Ajout Effectué avec Succes");
				else
					check.setText("Error!!!Ajout Failed");
					
			}else if(fonctionsList.getSelectionModel().getSelectedItem().equals("Manutentionaire"))
			{
				employer = new Manutentionnaire(nameText.getText(), prenomText.getText(), Integer.parseInt(ageText.getText()), Integer.parseInt(dateText.getText()), Integer.parseInt(nbrheurs.getText()));
				String salary = ""+employer.calculeSalaire();
				salair.setText(salary);
				query = "insert into employers values(null,'"+nameText.getText()+"','"+prenomText.getText()+"',"+employer.getAge()+","+employer.getDate()+",'"+employer.function()+"',"+employer.calculeSalaire()+")";
				res = database.insertOne(query);
				if(res == true)
					check.setText("Ajout Effectué avec Succes");
				else
					check.setText("Error!!!Ajout Failed");
			}
			
			database.deConnexion();
		}
		

		}catch(Exception e){ 
			
			//System.out.println(e.getMessage());
			e.printStackTrace();
			//System.out.println("He Enter Here");
			
	} 
		
		
	
	}
	
	
	@FXML
	public void updateEmployer(ActionEvent mouseEvent)throws IOException,SQLException{
		
	
	}
	
	
	@FXML
	public void deleteEmployer(ActionEvent mouseEvent)throws IOException,SQLException{
		
	
	}
	
	
	@FXML
	public void clearEmployer(ActionEvent mouseEvent)throws IOException,SQLException{
		
		
		
	
	}
	
	
	
	
	
	
	
	
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
    	try {
    		FillComboBx();
    		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	

    }

}
