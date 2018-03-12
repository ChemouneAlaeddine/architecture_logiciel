package decorator;

public abstract class SoldatClass implements Soldat {

	public String name;
	private int attacking;
	private int defending;
	private boolean isalive;
	
	public SoldatClass() {
		this.isalive = true;
	}
	
	@Override
	public boolean isAlive() {
		return this.isalive;
	}

	@Override
	public int strike() {
		System.out.println(this.name+" porte un coup ");
		return this.attacking;
	}

	@Override
	public void parry(int strike) {
		if(strike > this.defending)
			this.defending-=2;
		else
			this.defending--;
		if(this.defending < 0)
			this.isalive = false;
	}
}
