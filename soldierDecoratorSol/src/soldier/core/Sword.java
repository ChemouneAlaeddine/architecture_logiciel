package soldier.core;

import Exceptions.*;

public class Sword implements Equipment {
	
	private float attacking = 20;
	private float defending = 3;
	private boolean taken = false;
	
	public Sword() {}
	
	@Override
	public void get() throws ImpossibleExtensionException {
		if(!this.taken)
			this.taken = true;
		else
			throw new ImpossibleExtensionException();
	}
	
	@Override
	public void let() throws ImpossibleExtensionException {
		if(this.taken)
			this.taken = false;
		else
			throw new ImpossibleExtensionException();
	}

	@Override
	public float getAttacking() {
		return this.attacking;
	}

	@Override
	public float getDefending() {
		return this.defending;
	}
	
}
