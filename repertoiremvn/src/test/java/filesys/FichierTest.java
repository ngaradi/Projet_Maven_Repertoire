package filesys;

import static org.junit.Assert.*;

import org.junit.Test;

public class FichierTest {

	@Test(expected=RepException.class)
	public void ajouttaillenulle() throws RepException{
		Fichier f1 = new Fichier("f1", 0);
		
	}
	
	@Test
	public void ajouttaillenonnulle() throws RepException{
		Fichier f1 = new Fichier("f1", 10);

		
	}
	
}
