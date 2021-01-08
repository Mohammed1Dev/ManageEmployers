package application.models;

public class Producteur extends Employe{

		private final int PRIX_UNIT = 5;
	    private int nbrUnites;

	    public Producteur() {}
	    public Producteur(String prenom, String nom, int age, int date, int nbrUnites)
	    {
	        super(prenom, nom, age, date);
	        this.nbrUnites = nbrUnites;
	    }

	    
	    public double calculeSalaire() 
	    {
	    	
	        return this.PRIX_UNIT * this.nbrUnites;
	    }

	    @Override
	    public String function()
	        {
	            return "Producteur =>";
	        }
}
