package Builder;

public class Main {
	public static void main(String[] args) {
		StandardPricing pricing = new StandardPricing(2,2,2);
		Movie movie = new Movie("un titre",pricing);
		Rental rental = new Rental(movie,5);
		
		Customer customer = new Customer("customer");
		customer.addRental(rental);
		
		CustomersTextuel custxt = new CustomersTextuel();
		custxt.createCustomer("customer");
		custxt.getCustomer().addRental(rental);
		
		System.out.println(customer.statement()+"\n"+custxt.buildStatement());
	}
}
