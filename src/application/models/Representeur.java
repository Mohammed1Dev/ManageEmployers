package application.models;

public class Representeur extends Employe {
	
	private final double POURCENTAGE = 0.2;
    private final int BONUS = 2500;
    
    private double chiffreAffaire;

    public Representeur() {}
    public Representeur(String prenom, String nom, int age, int date, double chiffreAffaire) 
    {
    	
        super(prenom, nom, age, date);
        this.chiffreAffaire = chiffreAffaire;
    }

    
    public double calculeSalaire() 
    {
        return (this.POURCENTAGE * this.chiffreAffaire) + this.BONUS;
    }

    @Override
    public String function()
        {
            return "Le Representeur =>";
        }
}
