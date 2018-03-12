package main;

import decorator.*;

public class Main {
	
	static void fight(Soldat s1, Soldat s2) {
		Soldat attack = s1;
		Soldat defend = s2;
		while(s1.isAlive() && s2.isAlive()) {
			System.out.println(" porte un coup\n");
		    defend.parry(attack.strike());
		    Soldat tmpSwap = attack;
		    attack = defend;
		    defend = tmpSwap;
		}
		if (s1.isAlive()) 
		    System.out.println("Soldier 1  Won");
		else
		    System.out.println("Soldier 2  Won");
		}
	
	public static void main(String[] args) {
		Soldat sld1 = new InfantaryManD(new InfantaryMan());
		Soldat sld2 = new HorseManD(new HorseMan());
		
		fight(sld1,sld2);
	}
	
}
