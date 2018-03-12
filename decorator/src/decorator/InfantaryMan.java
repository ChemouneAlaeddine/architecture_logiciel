package decorator;

public class InfantaryMan implements Soldat {
	
	private int attacking;
	private int defending;
	private boolean isalive;
	
	public InfantaryMan() {
		super();
		this.attacking = 5;
		this.defending = 5;
		this.isalive = true;
	}

	@Override
	public boolean isAlive() {
		return this.isalive;
	}

	@Override
	public int strike() {
		System.out.println(" porte un coup ");
		return this.attacking;
	}

	@Override
	public void parry(int strike) {
		System.out.println(" porte un coup ");
		if(strike > this.defending)
			this.defending-=2;
		else
			this.defending--;
		if(this.defending < 0)
			this.isalive = false;
	}

	@Override
	public void setStrike(int val) {
		this.attacking = val;
		
	}

	@Override
	public void setDefend(int val) {
		this.defending = val;
	}
	
}
