import soldier.core.*;
import soldier.equipment.*;
import soldier.units.*;

public class MainEx2 {
	public static void main(String argv[]) {
		  Unit hm = new UnitHorseMan();
		  Unit im = new UnitCenturion();
		  Unit gr1 = new Army();
		  gr1.add(hm);
		  gr1.add(im);
		  Unit hm2 = new UnitCenturion();
		  Unit im2 = new UnitHorseMan();
		  Unit gr2 = new Army();
		  gr2.add(hm2);
		  gr2.add(im2);
		  Unit gr3 = new Army();
		  gr3.add(gr1);
		  gr3.add(gr2);
		  Equipment shield = new WeaponShield();
		  gr3.addEquipment(shield);
		  System.out.println("la force de frappe de l'armée "+gr3.getName()+" + est de : "+gr3.strike());
		}
}


