package model;

import java.util.Enumeration;

public interface Pricing extends Cloneable{
	public double Price(int days, double fee, double price_day);
	public int pointDeFidelite(Enumeration rentals);
}
