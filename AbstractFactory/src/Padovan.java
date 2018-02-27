
public class Padovan implements Algorithm {

	@Override
	public String getName() {
		return "Padovan";
	}

	@Override
	public double getVal(int val) {
		if((val==0)||(val==1)||(val==2))
			return 1;
		return getVal(val-2)+getVal(val-3);
	}

}
