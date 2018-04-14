package soldier.core;

//import java.util.Iterator;

public interface Unit {
	public String getName();
	public void addEquipment(Equipment eq);
	public float parry(float force);
	public float strike();
	//public void add(Unit u);
	//public void remove(Unit u);
	//public java.util.Iterator<Unit> getChildren();
}
