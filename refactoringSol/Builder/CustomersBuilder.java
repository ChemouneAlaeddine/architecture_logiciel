package Builder;
import java.util.Set;
import java.util.TreeSet;

public abstract class CustomersBuilder {
	
	protected Customer customer;
	
	public Customer getCustomer() {
		return this.customer;
	}
	
	public void createCustomer(String name) {
		customer = new Customer(name);
	}

	public abstract String buildStatement();
	
}
