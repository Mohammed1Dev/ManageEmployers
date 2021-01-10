package application.models;

public class Employers {

	public int id;
	public String nom;
	public String prenom;
	public int age;
	public int date;
	public String fonction;
	public double salaire;
	
	
	public Employers() {}


	public Employers(int id, String nom, String prenom, int age, int date, String fonction, double salaire) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.date = date;
		this.fonction = fonction;
		this.salaire = salaire;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public int getDate() {
		return date;
	}


	public void setDate(int date) {
		this.date = date;
	}


	public String getFonction() {
		return fonction;
	}


	public void setFonction(String fonction) {
		this.fonction = fonction;
	}


	public double getSalaire() {
		return salaire;
	}


	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	
	
	
	
	
	
	

}
