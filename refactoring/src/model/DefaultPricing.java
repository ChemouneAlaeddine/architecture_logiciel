package model;

public class DefaultPricing implements Pricing {
	
	public DefaultPricing() {}
	
	public Rental rental;
	
	public double price(int days, double fee, double price_day) {
		double amount = 0;
		amount += fee;
		if(this.rental.getDaysRented() > days)
			amount += (rental.getDaysRented() - days) * price_day;
		return amount;
	}
	

	public double pointDeFidelite() {
		// TODO Auto-generated method stub
		return 0;
	}

}
