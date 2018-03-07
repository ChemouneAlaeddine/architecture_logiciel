package decorator;

public class SoldatDecorator extends SoldatClass {
	
	protected SoldatClass soldate;
	
	public SoldatDecorator(SoldatClass s) {
		this.soldate = s;
	}

	@Override
	public boolean isAlive() {
		return this.soldate.isAlive();
	}

	@Override
	public int strike() {
		return this.soldate.strike();
	}

	@Override
	public void parry(int strike) {
		this.soldate.parry(strike);
	}
	
	@Override
	public void setBouclier() {
		this.soldate.setBouclier();
	}
	
	@Override
	public void setEpee() {
		this.soldate.setEpee();
	}
}
