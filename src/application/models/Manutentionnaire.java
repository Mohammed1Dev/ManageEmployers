package application.models;

public class Manutentionnaire extends Employe {
	
    private final double HEUR_PRICE = 50;
    private int nbrHeurs;

    public Manutentionnaire() {}
    public Manutentionnaire(String prenom, String nom, int age, int date, int nbrHeurs) 
    {
        super(prenom, nom, age, date);
        this.nbrHeurs = nbrHeurs;
    }

    
    public double calculeSalaire() 
    {
    	
        return this.HEUR_PRICE * this.nbrHeurs;
    }

    @Override
    public String function()
        {
            return "Le Manutentionnaire =>" ;
        }
}
