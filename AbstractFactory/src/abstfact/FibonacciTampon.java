package abstfact;
import java.nio.IntBuffer;

public class FibonacciTampon implements Algorithm {
	
	private Fibonacci fibo;
	private IntBuffer tampon;

	@Override
	public String getName() {
		return fibo.getName()+"Tampon";
	}

	@Override
	public double getVal(int val) {
		if(this.tampon == null) {
			this.tampon = IntBuffer.allocate(val+1);
			for(int i=0;i<val+1;i++)
				tampon.put(i, 0);
		}
		if(this.tampon.get(val) != 0)
			return this.tampon.get(val);
		else {
			if(this.tampon.get(0) == 0)
				return calculVal(val);
			else {
				if(this.tampon.capacity() < val) {
					IntBuffer tampon2 = IntBuffer.allocate(val);
					tampon2 = this.tampon;
					this.tampon = tampon2;
					tampon2 = null;
				}
				for(int i=0;i<val;i++) {
					if(this.tampon.get(i) == 0)
						this.tampon.put(i,this.tampon.get(i-1) + this.tampon.get(i-2));
				}
			}
		}
		return this.tampon.get(val);
	}
	
	public double calculVal(int val) {
		if(val==0) {
			this.tampon.put(val, 1);
			return this.tampon.get(val); 
		}
		if(val==1) {
			this.tampon.put(val-1,1);
			this.tampon.put(val,1);
			return this.tampon.get(val);
		}
		if(val>1) {
			this.tampon.put(0,1);
			this.tampon.put(1,1);
			for(int i=2;i<val+1;i++) {
				this.tampon.put(i,this.tampon.get(i-1)+this.tampon.get(i-2));
			}
		}
		return this.tampon.get(val);
	}
}
