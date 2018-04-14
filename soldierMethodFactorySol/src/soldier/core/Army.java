package soldier.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Army implements Unit {
	
	private String name;
	private List<Unit> groupe = new ArrayList<Unit>();
	private Iterator<Unit> itr = groupe.iterator();
	
	public Army() {}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public void addEquipment(Equipment eq) {
		
	}
	
	@Override
	public float parry(float force) {
		float part = force / groupe.size();
		float reste = force % groupe.size();
		return 0;
	}
	
	@Override
	public float strike() {
		int result = 0;
		while(itr.hasNext()) {
			Unit unit = itr.next();
			result += unit.strike();
		}
		return result;
	}
	
	//@Override
	public void add(Unit us) {
		groupe.add((Unit) us);
	}
	
	//@Override
	public void remove(Unit us) {
		groupe.remove(us);
	}

	//@Override
	public Iterator<Unit> getChildren() {
		return this.itr;
	}
}
