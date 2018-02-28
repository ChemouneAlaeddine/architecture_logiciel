package model;

import java.util.Enumeration;
import java.util.Vector;

public class Customers_2 extends Customers {

	public Customers_2(String name) {
		super(name);
	}
	
	@Override
	public String statement(){
	double totalAmount = 0;
	DefaultPricing price = new DefaultPricing();
	Enumeration rentals=_rentals.elements();
	int pfd = price.pointDeFidelite(rentals);
	rentals=_rentals.elements();
	String result = "Rental Record for "+getName()+"\n"; // Using StringBuffer
	while (rentals.hasMoreElements()){
		double thisAmount;
		Rental each=(Rental) rentals.nextElement();
		thisAmount=each.getAmount(each.getMovie());
		result +="\t" + each.getMovie().getTitle()+"\t"+
		    String.valueOf(thisAmount) +" \n";
		totalAmount+=thisAmount;
	    }
	result += "Amount owned is " + String.valueOf(totalAmount) +
	    "\n";
	result += "You earned " + String.valueOf(pfd) +
	    " frequent renter points";
	return result;
    }
	
	public String statementhtml(){
		double totalAmount = 0;
		DefaultPricing price = new DefaultPricing();
		Enumeration rentals=_rentals.elements();
		int pfd = price.pointDeFidelite(rentals);
		rentals=_rentals.elements();
		String result = "<html><br><body><br>Rental Record for "+getName()+"<br>"; // Using StringBuffer
		while (rentals.hasMoreElements()){
			double thisAmount;
			Rental each=(Rental) rentals.nextElement();
			thisAmount=each.getAmount(each.getMovie());
			result +="<br>" + each.getMovie().getTitle()+"<br>"+
			    String.valueOf(thisAmount) +"<br>";
			totalAmount+=thisAmount;
		    }
		result += "Amount owned is " + String.valueOf(totalAmount) +"<br>";
		result += "You earned " + String.valueOf(pfd) +" frequent renter points<br></body></html>";
		return result;
	    }
}
