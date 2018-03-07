package decorator;

public class SoldatClass implements Soldat {

	private int attacking;
	private int defending;
	private boolean isalive;
	private boolean bouclier;
	private boolean epee;
	
	public SoldatClass() {
		this.attacking = 5;
		this.defending = 5;
		this.isalive = true;
		this.bouclier = false;
		this.epee = false;
	}
	
	@Override
	public boolean isAlive() {
		return this.isalive;
	}

	@Override
	public int strike() {
		return this.attacking;
	}

	@Override
	public void parry(int strike) {
		if(strike > this.defending)
			this.isalive = false;
	}
	
	public void setBouclier() {
		this.bouclier = true;
	}
	
	public void setEpee() {
		this.epee = true;
	}

}
