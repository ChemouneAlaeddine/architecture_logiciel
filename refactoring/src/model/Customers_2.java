package model;

import java.util.Enumeration;

public class Customers_2 extends Customers {

	public Customers_2(String name) {
		super(name);
	}
	
	@Override
	public String statement(){
	double totalAmount = 0;
	DefaultPricing price = new DefaultPricing();
	Enumeration rentals=_rentals.elements();
	String result = "Rental Record for "+getName()+"\n";
	while (rentals.hasMoreElements()){
		double thisAmount=0;
		Rental each=(Rental) rentals.nextElement();
		each.getAmount(each.getMovie());
		result +="\t" + each.getMovie().getTitle()+"\t"+
		    String.valueOf(thisAmount) +" \n";
		totalAmount+=thisAmount;
	    }
	result += "Amount owned is " + String.valueOf(totalAmount) +
	    "\n";
	result += "You earned " + String.valueOf(price.pointDeFidelite(this)) +
	    " frequent renter points";
	return result;
    }
}
