package decorator;

public abstract class SoldatDecorator extends SoldatClass {
	
	protected SoldatClass soldate;
	private boolean epee = false;
	private boolean bouclier = false;
	
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
	
	public void setBouclier() {
		System.out.println(this.soldate.name+" recupere un bouclier\n");
		this.bouclier = true;
	}
	
	public void setEpee() {
		System.out.println(this.soldate.name+" recupere une epee\n");
		this.epee = true;
	}
}
