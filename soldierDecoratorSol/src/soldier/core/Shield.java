package soldier.core;

import Exceptions.*;

public class Shield implements Equipment {
	
	private float attacking = 2;
	private float defending = 18;
	private boolean taken = false;
	
	public Shield() {}
	
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
