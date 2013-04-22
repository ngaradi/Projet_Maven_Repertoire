package filesys;

import static org.junit.Assert.*;

import org.junit.Test;

public class FichierTest {

	/**
	 * Ce test nous permet de controler qu'un fichier ne peut avoir une taille nulle
	 * @throws RepException
	 */
	@Test(expected=RepException.class)
	public void ajouttaillenulle() throws RepException{
		Fichier f1 = new Fichier("f1", 0);
		
	}
	
	/**
	 * Ici nous verifions qu'une taille positive peut-etre ajoutee a un fichier
	 * @throws RepException
	 */
	@Test
	public void ajouttaillenonnulle() throws RepException{
		Fichier f1 = new Fichier("f1", 10);

		
	}
	
}
