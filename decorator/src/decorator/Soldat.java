package decorator;

public interface Soldat {
	
	public boolean isAlive();
	public int strike();
	public void setStrike(int val);
	public void setDefend(int val);
	public void parry(int strike);
}
