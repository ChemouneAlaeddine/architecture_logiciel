package model;

import java.util.Enumeration;
import java.util.Vector;

public class DefaultPricing implements Pricing {
	
	public DefaultPricing() {}
	
	public Rental rental;
	
	public double price(int days, double fee, double price_day) {
		double amount = fee;
		double movie_type = fee == 2 ? 2 : fee == 1.5 ? 3 : fee == 0 ? 0 : 0 ;
		if(days > movie_type)
			amount += (days - movie_type) * price_day;
		return amount;
	}
	

	public double pointDeFidelite(Customers cust) {
		double p = 0;
		Vector _rentals = new Vector();
		Enumeration rentals=_rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each=(Rental) rentals.nextElement();
			p++;
			if((each.getMovie().getPriceCode()== Movie.NEW_RELEASE)
			   && (each.getDaysRented()>1)) 
			    p++;
		}
		return p;
	}

}
