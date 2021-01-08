package application.models;

//abstract Class
public abstract class Employe {
	
    private String nom;
    private String prenom;
    private int age;
    private int date;


    public Employe() {}
    public Employe(String prenom, String nom, int age, int date) 
    {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.date = date;
    }

    
    //abstract method
    public abstract double calculeSalaire();

    
    public String function()
        {
            return "L'employé =>" ;
        }

    public String getNomComplet() 
    {
        return function() + prenom + " " + nom;
    }

    //age & date Getters & Setters
	public int getAge() {
		return this.age;
	}

	public void setAge(int age) 
	{
		this.age = age;
	}

	public int getDate() 
	{
		return this.date;
	}

	public void setDate(int date) 
	{
		this.date = date;
	}

	@Override
	public String toString() 
	{
		return this.getNomComplet() + ",son age :" + age + ",et sa date d'entrée :" + date + "]";
	}
    
    
	
    
}
