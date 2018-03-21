package soldier.core;

import java.util.ArrayList;
import java.util.List;

public class Unit extends UnitSimple {
	
	private List<UnitSimple> groupe = new ArrayList<UnitSimple>();
	
	public Unit(String name, BehaviorSoldier behavior) {
		super(name, behavior);
	}
	
	public Unit() {
		super(this.na);
	}
	
	public void add(UnitSimple us) {
		groupe.add(us);
	}
	
	public void remove(UnitSimple us) {
		groupe.remove(us);
	}

}
