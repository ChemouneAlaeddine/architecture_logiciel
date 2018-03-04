package test;

import static org.junit.Assert.*;

import org.junit.Test;
import junit.framework.*;
import Builder.*;

public class jUnitTest {
	
	@Test
	public void testSimple(){
		
		StandardPricing pricing = new StandardPricing(2,2,2);
		Movie movie = new Movie("un titre",pricing);
		Rental rental = new Rental(movie,5);
		
		Customer customer = new Customer("customer");
		customer.addRental(rental);
		
		CustomersTextuel custxt = new CustomersTextuel();
		custxt.createCustomer("customer");
		custxt.getCustomer().addRental(rental);
		
		Assert.assertEquals(customer.statement(),custxt.buildStatement());
		
	}
}