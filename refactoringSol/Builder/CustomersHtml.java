package Builder;

public class CustomersHtml extends CustomersBuilder {

	@Override
	public String buildStatement() {
		String result = "<html><body>\n"+"Rental Record for "+this.getCustomer().getName()+ "<br>";
		for(Rental each : this.getCustomer()._rentals)
		{
			result += 
					"&nbsp;&nbsp;" + each.getMovie().getTitle() 
					+ "&nbsp;&nbsp;" + String.valueOf(each.getAmount()) 
					+ " " + "<br>";
		}

		result += "Amount owed is " + String.valueOf(this.getCustomer().getTotalAmount()) +
				"<br>";
		result += "You earned " + String.valueOf(this.getCustomer().getRenterPoints()) +
				" frequent renter points"+"\n</body></html>";
		return result;
	}

}
