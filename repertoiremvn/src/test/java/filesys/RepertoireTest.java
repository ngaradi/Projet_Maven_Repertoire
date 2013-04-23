package filesys;

import static org.junit.Assert.*;

import org.junit.Test;

public class RepertoireTest {

	/**
	 * Ceci est un test permettant de definir que l'ajout d'une reference nulle est impossible
	 * @throws RepException
	 */
	@Test(expected=RepException.class)
	public void ajoutreferencenulle() throws RepException{
		Repertoire r1 = new Repertoire("r1", true);
		r1.add(null);
	}
	
	/**
	 * Ce test nous permet de verfier que l'ajout d'une reference non nulle est possible 
	 * @throws RepException
	 */
	@Test(expected=RepException.class)
	public void ajoutreferenceautre() throws RepException{
		Repertoire r1 = new Repertoire("r1", true);
		String a = "abc";
		r1.add(a);
	}
		
	/**
	 * Ici nous testons l'ajout d'un objet avec le meme nom. L'ajout sera donc impossible
	 * @throws RepException
	 */
	@Test(expected=RepException.class)
	public void ajoutnomexistant() throws RepException{
		Repertoire r1 = new Repertoire("r1", true);
		Repertoire r2 = new Repertoire("r2", false);
		Repertoire r3 = new Repertoire("r2", false);
		r1.add(r2);
		r1.add(r3);
	}
	
	/**
	 * Dans ce test nous verifions que l'ajout d'un repertoire à lui meme est impossible
	 * @throws RepException
	 */
	@Test(expected=RepException.class)
	public void ajoutsurluimeme() throws RepException{
		Repertoire r1 = new Repertoire("r1", true);
		r1.add(r1);
	}
	
	/**
	 * Grace a ce test nous controlons qu'un repertoire ne peut etre sous repertoire de lui-meme
	 * indirectement
	 * @throws RepException
	 */
	@Test(expected=RepException.class)
	public void ajoutrepexistant() throws RepException{
		Repertoire r1 = new Repertoire("r1", true);
		Repertoire r2 = new Repertoire("r2", false);
		r1.add(r2);
		r2.add(r1);
	}
	
	/**
	 * Ce test nous permet de verifier le calcul de la taille d'un repertoire contenant un fichier
	 * @throws RepException
	 */
	@Test
	public void testtailleunfichier() throws RepException{
		Repertoire r1 = new Repertoire("r1", true);
		Fichier f1 = new Fichier("f1", 5);
		r1.add(f1);
		assertEquals(5, r1.get_taille(),0);
	}
	
	/**
	 * Ce test nous permet de verifier le calcul de la taille d'un repertoire contenant 
	 * un fichier et un repertoire lui-meme contenant un fichier
	 * @throws RepException
	 */
	@Test
	public void testtailleplusieursfichier() throws RepException{
		Repertoire r1 = new Repertoire("r1", true);
		Repertoire r2 = new Repertoire("r2", false);
		Fichier f1 = new Fichier("f1", 5);
		Fichier f2 = new Fichier("f2", 15);
		r1.add(f1);
		r2.add(f2);
		r1.add(r2);
		assertEquals(20, r1.get_taille(),0);
	}

}
