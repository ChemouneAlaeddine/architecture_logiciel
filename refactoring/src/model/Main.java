package model;
import model.*;

public class Main {
	
	Movie m1 = new Movie("Rogue One",5);

	Customers cust = new Customers("bob");
	
	Rental rental = new Rental(m1,1);
	
	cust.addRental(rental);
	System.out.println();
	//cust.addRental(rental);
	//cust.statement();
	
}
