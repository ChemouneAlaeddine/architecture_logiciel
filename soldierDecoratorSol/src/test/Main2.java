package test;

import soldier.core.*;
import Exceptions.*;

public class Main2 {
	public static void main(String[] args) {
		  UnitSimple hm = new HorseMan();
		  UnitSimple im = new InfantaryMan();
		  Equipment sw = new Sword();
		  Equipment sh = new Shield();
		  Equipment sw2 = new Sword();
		  try { 
		    im.parry(hm.strike());
		    im.addEquipement(sw);
		    hm.addEquipement(sw); // Lève une exception car l'arme est déjà attaché
		  }catch(ImpossibleExtensionException e) {}

		  try {
		   im.removeEquipement(sw);
		   hm.addEquipement(sw);
		   hm.addEquipement(sh);    
		   hm.addEquipement(sw2); // Lève une exception car deux armes maximum
		  }catch(ImpossibleExtensionException e) {}
	}
}
