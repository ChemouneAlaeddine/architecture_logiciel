package test;

import static org.junit.Assert.*;

import org.junit.Test;
import junit.framework.*;
import model.*;

public class TestjUnit44 {
	
	@Test
	public void testSimple() throws TestException{
		
		Movie m1 = new Movie("Rogue One",1);
		Customers bob = new Customers("bob1");
		Rental rental1 = new Rental(m1,5);
		bob.addRental(rental1);
		
		Movie m2 = new Movie("Reine des neiges",2);
		Rental rental2 = new Rental(m2,7);
		bob.addRental(rental2);
		
		Movie m3 = new Movie("Star Wars III",3);
		Rental rental3 = new Rental(m3,4);
		bob.addRental(rental3);
		
		Assert.assertEquals("Rental Record for bob1\n" + 
				"	Rogue One	15.0 \n" + 
				"	Reine des neiges	7.5 \n" + 
				"	Star Wars III	0.0 \n" + 
				"Amount owned is 22.5\n" + 
				"You earned 4 frequent renter points", bob.statement());
		
	}

}
