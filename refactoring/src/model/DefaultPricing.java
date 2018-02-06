package model;

import java.util.Enumeration;
import java.util.Vector;

public class DefaultPricing implements Pricing {
	
	public DefaultPricing() {}

	public double Price(int days, double fee, double price_day) {
		double amount = fee;
		//System.out.println("fee = "+fee);
		double movie_type = fee == 2 ? 2 : fee == 1.5 ? 3 : fee == 0 ? 0 : 0 ;
		//System.out.println("movie_type = "+movie_type);
		if(days > movie_type)
			amount += (days - movie_type) * price_day;
		//System.out.println("amount = "+amount);
		return amount;
	}

	public int pointDeFidelite(Enumeration rentals) {
		int p = 0;
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
