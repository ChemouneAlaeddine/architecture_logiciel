package soldier.core;

import javax.swing.text.html.HTMLDocument.Iterator;

public interface Unit {
	public String getName();
	public void addEquipment(Equipment eq);
	public float strike();
	public void add(Unit u);
	public void remove(Unit u);
	public Iterator getChildren();
}
