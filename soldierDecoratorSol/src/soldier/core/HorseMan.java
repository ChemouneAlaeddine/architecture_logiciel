package soldier.core;

public class HorseMan extends UnitSimple {

	public HorseMan() {
		super(new StdExtension(5.f, 0.f, 
				new StdExtension(0.f, 6.f, 
						new LogPowBehavior(3, 4, 12, "Georges"))));
	}
	
}
