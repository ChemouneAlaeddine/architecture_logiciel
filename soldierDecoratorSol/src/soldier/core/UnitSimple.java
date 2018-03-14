package soldier.core;

import Exceptions.*;

public abstract class UnitSimple {
	
	private BehaviorSoldier soldier;
	
	private float m_attack;
	private float m_defense;
	private static float wear_ratio = 2.5f;
	
	private boolean hasSword = false;
	private boolean hasShield = false;
	private int nbarms = 0;
	
	UnitSimple(BehaviorSoldier s) {
		this.soldier = s;
	}

	public String getName() {
		return this.soldier.getName();
	}
	
	public float getHealthPoints() {
		return this.soldier.getHealthPoints();
	}
	
	public boolean alive() {
		return this.soldier.alive();
	}
	
	public void heal() {
		this.soldier.heal();
	}
	
	public float strike() {
		return soldier.strike();
	}

	public float parry(float force) {
		return soldier.parry(force);
	}
	
	//================
	public void addSword() throws ImpossibleExtensionException {
		if(this.hasSword == false) {
			this.soldier = new StdExtension(this.m_attack+wear_ratio,this.m_defense,this.soldier);
			this.hasSword = true;
		}else {
			throw new ImpossibleExtensionException();
		}
	}
	
	public void addShield() throws ImpossibleExtensionException {
		if(this.hasShield == false) {
			this.soldier = new StdExtension(this.m_attack,this.m_defense+wear_ratio,this.soldier);
			this.hasShield = true;
		}else {
			throw new ImpossibleExtensionException();
		}
	}
	//===============
	public void addEquipement(Equipment eq) throws ImpossibleExtensionException {
		try {
			eq.get();
		} catch (ImpossibleExtensionException e) {
			e.printStackTrace();
		}
		if(this.nbarms < 2) {
			this.m_attack += eq.getAttacking();
			this.m_defense += eq.getDefending();
			this.nbarms++;
		}else {
			throw new ImpossibleExtensionException();
		}
	}
	//==============
	public void takeSword() throws ImpossibleExtensionException {
		if(this.hasSword == true) {
			this.soldier = new StdExtension(this.m_attack-wear_ratio,this.m_defense,this.soldier);
			this.hasSword = false;
		}else {
			throw new ImpossibleExtensionException();
		}
	}
	
	public void takeShield() throws ImpossibleExtensionException {
		if(this.hasShield == true) {
			this.soldier = new StdExtension(this.m_attack,this.m_defense-wear_ratio,this.soldier);
			this.hasShield = false;
		}else {
			throw new ImpossibleExtensionException();
		}
	}
	//==============
	public void removeEquipement(Equipment eq) throws ImpossibleExtensionException {
		try {
			eq.let();
		} catch (ImpossibleExtensionException e) {
			e.printStackTrace();
		}
		if(this.nbarms > 0) {
			this.m_attack -= eq.getAttacking();
			this.m_defense -= eq.getDefending();
			this.nbarms--;
		}
	}
}
