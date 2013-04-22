package filesys;

/**
 * Cette classe nous permet de représenter un fichier
 * 
 * @author Dumont Garadi 
 * @version 15/04/13
 */
public class Fichier extends Objet
{
    // Création d'une variable de type int qui contiendra la taille d'un fichier
   private int taille;

     /**
     * Définition du constructeur de Fichier
     * L'argument nom de type string est donné par l'utilisateur et sera envoyé à la classe mère Objet 
     * pour créer une instance de type Objet puis de type fichier
     */
    public Fichier(String nom, int taille) throws RepException
    {
        super(nom);
    	if(taille<=0) throw new RepException("Taille fichier incompatible");
        else this.taille= taille;
    }
    
    /**
     * Cette méthode permet de renvoyer la taille
     * @return Retourne la taille du fichier qui est un int
     */
    public int get_taille()
    {
        return  taille;
    }
}
