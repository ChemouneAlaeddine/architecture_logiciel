package soldier.core;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Army implements Unit {
	
	private String name;
	private List<UnitSimple> groupe = new ArrayList<UnitSimple>();
	private Iterator itr = (Iterator) groupe.iterator();
	
	public Army() {}
	
	@Override
	public String getName() {
		return this.getName();
	}
	
	@Override
	public void addEquipment(Equipment eq) {
		
	}
	
	@Override
	public float strike() {
		return 0;
	}
	
	@Override
	public void add(Unit us) {
		groupe.add((UnitSimple) us);
	}
	
	@Override
	public void remove(Unit us) {
		groupe.remove(us);
	}
	
	public Iterator getChildren() {
		return this.itr;
	}
}
