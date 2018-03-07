package decorator;

public class InfantaryMan extends SoldatDecorator {
	
	public InfantaryMan(SoldatClass s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int strike() {
		System.out.println(" porte un cou a ");
		return super.strike();
	}
	
	@Override
	public void setBouclier() {
		System.out.println(" recupere un bouclier ");
		this.soldate.setBouclier();
	}
	
	public void setEpee() {
		System.out.println(" recupere une epee ");
		this.soldate.setEpee();
	}
}
