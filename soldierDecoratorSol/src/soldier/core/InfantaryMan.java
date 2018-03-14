package soldier.core;

public class InfantaryMan extends UnitSimple {
	
	public InfantaryMan() {
		super(20,15,new StdExtension(5.f, 0.f, 
				new StdExtension(0.f, 6.f, 
						new ConstBehavior(3, 7, 10, "Arthur"))));
	}
}
