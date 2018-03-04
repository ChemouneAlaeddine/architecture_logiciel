package test;

import static org.junit.Assert.*;

import org.junit.Test;
import junit.framework.*;
import abstfact.*;

public class jUnitTest {
	
	@Test
	public void testSimple(){
		
		Fibonacci fibo = new Fibonacci();
		FibonacciTampon fiboTam = new FibonacciTampon();
		
		Padovan pado = new Padovan();
		PadovanTampon padoTam = new PadovanTampon();
		
		//for(int i=0;i<10;i++) {
		Assert.assertEquals(fibo.getVal(10),fiboTam.getVal(10));
		Assert.assertEquals(pado.getVal(10),padoTam.getVal(10));
		//}
	}
}