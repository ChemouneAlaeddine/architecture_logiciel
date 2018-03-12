package decorator;

public class InfantaryManD extends SoldatDecorator {

	public InfantaryManD(Soldat s) {
		super(s);
		this.setDefend(5);
		this.setStrike(5);
		this.setBouclier();
		this.setEpee();
	}

}
