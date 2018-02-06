package model;
import model.*;

public class Main {
	
	public static void main (String[] args) {
	
		Movie m1 = new Movie("Rogue One",1);
		Customers cust1 = new Customers("bob1");
		Rental rental1 = new Rental(m1,5);
		cust1.addRental(rental1);
		
		System.out.println("- Le film "+rental1.getMovie().getTitle()+" de type "+
						rental1.getMovie().NEW_RELEASE+" pendant "+rental1.getDaysRented()+" jours\n");
		
		Movie m2 = new Movie("Reine des neiges",2);
		Rental rental2 = new Rental(m2,7);
		cust1.addRental(rental2);
		
		System.out.println("- Le film "+rental2.getMovie().getTitle()+" de type "+
						rental2.getMovie().CHILDRENS+" pendant "+rental2.getDaysRented()+" jours\n");
		
		Movie m3 = new Movie("Star Wars III",0);
		Rental rental3 = new Rental(m3,4);
		cust1.addRental(rental3);
		
		System.out.println("- Le film "+rental3.getMovie().getTitle()+" de type "+
						rental3.getMovie().REGULAR+" pendant "+rental3.getDaysRented()+" jours\n");
		
		System.out.println("statment : "+cust1.statement()+"\n");
	}
}