
public class Fibonacci implements Algorithm {

	@Override
	public String getName() {
		return "Fibonacci";
	}

	@Override
	public double getVal(int val) {
		if((val==0)||(val==1))
			return 1;
		return getVal(val-1)+getVal(val-2);
	}

}
