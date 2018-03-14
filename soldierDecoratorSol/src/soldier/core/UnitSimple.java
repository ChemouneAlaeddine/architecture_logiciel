package soldier.core;

import Exceptions.*;

public abstract class UnitSimple extends BehaviorExtension {
	
	private float m_attack;
	private float m_defense;
	private static float wear_ratio = 2.5f;

	private float m_wear = 10;
	
	private boolean hasSword = false;
	private boolean hasShield = false;
	private int nbarms = 0;
	
	UnitSimple(float attack, float defense, BehaviorSoldier soldier) {
		super(soldier);
		m_attack = attack;
		m_defense = defense;
	}

	@Override
	public float strike() {
		float force = soldier.strike() + m_attack;
		m_wear -= wear_ratio * Math.min(m_wear, force) / m_wear;
		return force;
	}

	@Override
	public float parry(float force) {
		float taken_force;
		if(m_defense >= 0)
			taken_force = force / (1 + m_defense);
		else
			taken_force = force;
		m_wear -= wear_ratio * Math.min(m_wear, taken_force) / m_wear;
		return soldier.parry(taken_force);
	}
	//================
	public void addSword() throws ImpossibleExtensionException {
		if(this.hasSword == false) {
			this.m_attack += wear_ratio;
			this.hasSword = true;
		}else {
			throw new ImpossibleExtensionException();
		}
	}
	
	public void addShield() throws ImpossibleExtensionException {
		if(this.hasShield == false) {
			this.m_defense += wear_ratio;
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
			this.m_attack -= wear_ratio;
			this.hasSword = false;
		}else {
			throw new ImpossibleExtensionException();
		}
	}
	
	public void takeShield() throws ImpossibleExtensionException {
		if(this.hasShield == true) {
			this.m_defense -= wear_ratio;
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
