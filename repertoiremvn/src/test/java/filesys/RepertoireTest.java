package filesys;

import static org.junit.Assert.*;

import org.junit.Test;

public class RepertoireTest {

	@Test(expected=RepException.class)
	public void ajoutreferencenulle() throws RepException{
		Repertoire r1 = new Repertoire("r1", true);
		r1.add(null);
	}
	
	@Test(expected=RepException.class)
	public void ajoutreferenceautre() throws RepException{
		Repertoire r1 = new Repertoire("r1", true);
		String a = "abc";
		r1.add(a);
	}
		
	@Test(expected=RepException.class)
	public void ajoutnomexistant() throws RepException{
		Repertoire r1 = new Repertoire("r1", true);
		Repertoire r2 = new Repertoire("r2", false);
		Repertoire r3 = new Repertoire("r2", false);
		r1.add(r2);
		r1.add(r3);
	}
	
	@Test(expected=RepException.class)
	public void ajoutsurluimeme() throws RepException{
		Repertoire r1 = new Repertoire("r1", true);
		r1.add(r1);
	}
	
	@Test(expected=RepException.class)
	public void ajoutrepexistant() throws RepException{
		Repertoire r1 = new Repertoire("r1", true);
		Repertoire r2 = new Repertoire("r2", false);
		r1.add(r2);
		r2.add(r1);
	}
	
	@Test
	public void testtailleunfichier() throws RepException{
		Repertoire r1 = new Repertoire("r1", true);
		Fichier f1 = new Fichier("f1", 5);
		r1.add(f1);
		assertEquals(5, r1.get_taille(),0);
	}
	
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
