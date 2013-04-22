package filesys;

/**
 * La classe Objet est la classe mère des classes Fichier et Répertoire
 * Cette classe a deux éléments communs aux classes Fichier et Répertoire
 * (le nom et la méthode calcul_taille).
 * 
 * @author Dumont Garadi
 * @version 15/04/13
 */
public abstract class Objet 
{
    // instance variables - replace the example below with your own
    String nom;
    
    public Objet(String nom)
    {
    	this.nom= nom;	
    }

    public abstract int get_taille();
    
    public String get_nom()
    {
    	return nom;
    }
    
}

