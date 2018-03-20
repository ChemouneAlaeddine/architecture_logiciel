package soldier.core;

import Exceptions.*;

public interface Equipment {
	public void get() throws ImpossibleExtensionException ;
	public void let() throws ImpossibleExtensionException ;
	public float getAttacking();
	public float getDefending();
}