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
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.date = date;
		this.fonction = fonction;
		this.salaire = salaire;
	}
	
	
	

}
