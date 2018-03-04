package Builder;

public class CustomersTextuel extends CustomersBuilder {

	@Override
	public String buildStatement() {
		String result = "Rental Record for "+this.getCustomer().getName()+ "\n";
		for(Rental each : this.getCustomer()._rentals)
		{
			result += 
					"\t" + each.getMovie().getTitle() 
					+ "\t" + String.valueOf(each.getAmount()) 
					+ " " + "\t";
		}

		result += "Amount owed is " + String.valueOf(this.getCustomer().getTotalAmount()) +
				"\n";
		result += "You earned " + String.valueOf(this.getCustomer().getRenterPoints()) +
				" frequent renter points";
		return result;
	}

}
