package model;

public class Rental {
    private Movie _movie;
    private int _daysRented;
    
    public Rental(Movie movie, int daysRented){
	_movie=movie;
	_daysRented=daysRented;
    }
    
    public int getDaysRented(){
	return _daysRented; 
    }
    
    public Movie getMovie(){
	return _movie;
    }
    
    public double getAmount(Movie movie) {
    	double thisAmount = 0;
    	DefaultPricing price = new DefaultPricing();
    	switch (movie.getPriceCode()){
	    case Movie.REGULAR:
	    thisAmount += price.Price(this.getDaysRented(), 2, 1.5);
	    
	    case Movie.NEW_RELEASE:
	    thisAmount += price.Price(this.getDaysRented(), 0, 3);
	    
	    case Movie.CHILDRENS:
	    thisAmount += price.Price(this.getDaysRented(), 1.5, 1.5);
    	}
    	return thisAmount;
    }
}
