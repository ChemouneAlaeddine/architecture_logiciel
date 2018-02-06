package model;

public interface Pricing extends Cloneable{
	public double Price(int days, double fee, double price_day);
	public double pointDeFidelite(Customers cust);
}
