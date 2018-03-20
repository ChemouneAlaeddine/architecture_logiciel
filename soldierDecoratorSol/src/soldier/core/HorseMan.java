package soldier.core;

public class HorseMan extends UnitSimple {

	public HorseMan() {
		super(new LogPowBehavior(3, 4, 12, "Georges"));
	}
	
}
