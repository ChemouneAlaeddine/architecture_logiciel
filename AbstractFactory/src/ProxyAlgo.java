import java.util.HashMap;

public abstract class ProxyAlgo implements Algorithm {

	protected Algorithm algo;
	HashMap<Integer, Integer> hmap;
	
	public ProxyAlgo() {
		hmap = new HashMap<Integer, Integer>();
	}
	
	@Override
	public String getName() {
		return "ProcciFibo";
	}

	@Override
	public abstract double getVal(int a);
	
	public abstract double createAlgo();
}
