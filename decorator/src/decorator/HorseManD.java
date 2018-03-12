package decorator;

public class HorseManD extends SoldatDecorator {

	public HorseManD(Soldat s) {
		super(s);
		this.setDefend(4);
		this.setStrike(6);
		this.setBouclier();
		this.setEpee();
	}

}
