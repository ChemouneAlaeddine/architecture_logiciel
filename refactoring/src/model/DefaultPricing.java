package model;

import java.util.Enumeration;
import java.util.Vector;

public class DefaultPricing implements Pricing {
	
	public DefaultPricing() {}

	public double Price(int days, double fee, double price_day) {
		double amount = fee;
		double movie_type = fee == 2 ? 2 : fee == 1.5 ? 3 : fee == 0 ? 0 : 0 ;
		if(days > movie_type)
			amount += (days - movie_type) * price_day;
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
	
	public Object clone() {
		//Object o = null;
		DefaultPricing dp = null;
		try {
			// On récupère l'instance à renvoyer par l'appel de la 
			// méthode super.clone()
			dp = (DefaultPricing)super.clone();
		} catch(CloneNotSupportedException cnse) {
			// Ne devrait jamais arriver car nous implémentons 
			// l'interface Cloneable
			cnse.printStackTrace(System.err);
		}
		// on renvoie le clone
		return dp;
	}
}
