package decorator;

public abstract class SoldatDecorator implements Soldat {
	
	private Soldat soldate;
	private int attack;
	private int defend;
	private boolean isalive;
	private boolean epee = false;
	private boolean bouclier = false;
	
	public SoldatDecorator(Soldat s) {
		this.soldate = s;
	}

	@Override
	public boolean isAlive() {
		return this.isalive;
	}

	@Override
	public int strike() {
		return this.attack;
	}
	
	@Override
	public void setStrike(int val) {
		this.attack = val;
	}
	
	@Override
	public void setDefend(int val) {
		this.defend = val;
	}

	@Override
	public void parry(int strike) {
		this.soldate.parry(strike);
		System.out.println(" porte un coup a\n");
		if(this.strike() > this.defend)
			this.defend-=2;
		else
			this.defend--;
		if(this.defend < 0)
			this.isalive = false;
	}
	
	public void setBouclier() {
		System.out.println(" recupere un bouclier\n");
		this.bouclier = true;
		this.defend += 2;
	}
	
	public void setEpee() {
		System.out.println(" recupere une epee\n");
		this.epee = true;
		this.attack += 2;
	}
}
