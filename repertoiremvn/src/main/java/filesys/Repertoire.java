package filesys;

import java.util.*;

/**
 * Cette classe nous permet de représenter un répertoire
 * 
 * @author Dumont Garadi 
 * @version 15/04/13
 */
public class Repertoire extends Objet
{
    // Création d'une liste de type Objet nommé répertoire
    private ArrayList<Objet> repertoire;
    private boolean aunpere;
    private boolean racine;
    
    /**
     * Définition du constructeur de Répertoire
     * On prend ici en argument le nom donné par l'utilisateur qui sera envoyé à la classe Objet
     * Ensuite on crée une liste de type Objet appelée repertoire
     */
    public Repertoire(String nom, boolean racine)
    {
        super(nom);
        repertoire = new ArrayList<Objet>();
        aunpere = false;
        this.racine = racine;
    }
   
    /**
     * Cette méthode ajoute un objet (fichier ou répertoire)dans la liste appelee répertoire.
     * Elle effectue une serie de tests afin de savoir si l'objet peut-etre ajoute a la liste
     */
    public void add(Object obj) throws RepException
    {
        if(obj instanceof Objet && obj != null){
            Objet o = (Objet) obj;  
            if(meme_nom(o)&& this!=o ){
                if(o instanceof Repertoire){
                    Repertoire r = (Repertoire) o;
                    if(r.aunpere == false && r.racine == false){
                    r.modifproprietes();
                    repertoire.add(o);
                    }
                    else
                        throw new RepException("Repertoire a deja un pere ");
                }
                else if(o instanceof Fichier){
                    repertoire.add(o);
                }
            }
            else
                throw new RepException("Objet déjà présent portant le meme nom ou ajout du meme objet");
        }
        else{
            throw new RepException("Reference nulle ou objet de type différent d'Objet");
        }
    }
    
    /**
     * Ici nous definissons l'affiliation à un pere. Cette methode est utilisee dans la methode
     * d'ajout afin de defnir les proprietes 
     * @param On prend en parametre le repertoire pere
     */
    public void modifproprietes(){
        aunpere = true;
    }
  
     /**
     * Cette methode nous permettra de determiner si un objet est deja contenu ou non 
     * dans le repertoire dans lequel on veut l'ajouter
     * @param Prend en parametre un objet obj
     * @return Elle renvoie un booleen
     */
    private boolean meme_nom(Objet obj){
        boolean result = true;
        int i = 0;
        
        for(i=0;i<repertoire.size();i++){
            if(repertoire.get(i).get_nom().equals(obj.get_nom())){
                result = false;
            }
        }
        return result;      
    }
    
    
   /**
     *Grace a cette methode nous allons calculer la taille d'un repertoire
     *En utilisant les proprietes d'une liste ( exemple : liste.get_size() )
     */
    public int get_taille()
    {
        int i=0;
        int taille=0;
        for(i=0 ; i<repertoire.size(); i++)
        {   
            taille += repertoire.get(i).get_taille();
        }
        
        return taille;
    }
 
    
}
