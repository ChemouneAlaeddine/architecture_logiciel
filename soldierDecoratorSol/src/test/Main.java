package test;

import soldier.core.*;
import Exceptions.*;

public class Main {
	
	public static void main(String argv[]) {
		  UnitSimple hm = new HorseMan();
		  UnitSimple im = new InfantaryMan();
		  im.parry(hm.strike());
		  try {
		   im.addSword();
		   hm.addShield();
		   hm.parry(im.strike());
		   im.addShield(); 
		   im.addSword(); // Lève une exception car deux armes maximum
		  }catch(ImpossibleExtensionException e) {}
		}
}
