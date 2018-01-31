package model;

public interface Pricing extends Cloneable{
	public double price(int days, double fee, double price_day);
	public double poitDeFidelite();
}
