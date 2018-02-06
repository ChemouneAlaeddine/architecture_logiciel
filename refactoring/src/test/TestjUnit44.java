package test;

import static org.junit.Assert.*;

import org.junit.Test;
import junit.framework.*;
import model.*;

public class TestjUnit44 {
	
	@Test
	public void testSimple() throws TestException{
		
		Customers bob1 = new Customers("bob1");
		Customers_2 bob2 = new Customers_2("bob1");
		
		Movie m1 = new Movie("Rogue One",1);
		Rental rental1 = new Rental(m1,5);
		
		bob1.addRental(rental1);
		bob2.addRental(rental1);
		
		Movie m2 = new Movie("Reine des neiges",2);
		Rental rental2 = new Rental(m2,7);
		
		bob1.addRental(rental2);
		bob2.addRental(rental2);
		
		Movie m3 = new Movie("Star Wars III",0);
		Rental rental3 = new Rental(m3,4);
		
		bob1.addRental(rental3);
		bob2.addRental(rental3);
		
		Assert.assertEquals(bob1.statement(),bob2.statement());
		
		
		Assert.assertEquals("Rental Record for bob1\n" + 
				"	Rogue One	15.0 \n" + 
				"	Reine des neiges	7.5 \n" + 
				"	Star Wars III	5.0 \n" + 
				"Amount owned is 27.5\n" + 
				"You earned 4 frequent renter points", bob1.statement());
		
		Assert.assertEquals("Rental Record for bob1\n" + 
				"	Rogue One	15.0 \n" + 
				"	Reine des neiges	7.5 \n" + 
				"	Star Wars III	5.0 \n" + 
				"Amount owned is 27.5\n" + 
				"You earned 4 frequent renter points", bob2.statement());
		
	}
}