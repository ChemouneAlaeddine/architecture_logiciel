import abstfact.*;

public class Main {
	public static void main(String[] args) {
		
		//System.out.println("Hello world !!");
		
		// Evaluation_paresseuse
		/*Fibonacci fibo = new Fibonacci();
		FibonacciTampon fiboTam = new FibonacciTampon();
		
		Padovan pado = new Padovan();
		PadovanTampon padoTam = new PadovanTampon();
		
		System.out.println("fibonacci : "+fibo.getVal(3));
		System.out.println("fibonacci tampon : "+fiboTam.getVal(3));
		
		System.out.println("padovan : "+pado.getVal(3));
		System.out.println("padovan tampon : "+padoTam.getVal(3));*/
		
		// Fabrique_abstraite
		/*AbstractFabrique factoryFibo = new concreteFabriqueFibo();
		AbstractFabrique factoryPado = new concreteFabriquePado();
		
		Algorithm ClassFibo = factoryFibo.creerClasse();
		Algorithm ClassPado = factoryPado.creerClasse();
		
		System.out.println(ClassFibo.getName());
		System.out.println(ClassPado.getName());*/
		
		// Introspection
		if(args.length != 2) {
			System.err.println("erreur parametres");
			System.exit(0);
		}
		
		String name = (String)args[0];
		int number = Integer.parseInt(args[1]);
		//Object number = (integer)args[2];
		
		switch(name) {
		case "fibo" :
			AbstractFabrique fibo = new concreteFabriqueFibo();
			Algorithm ClassFibo = fibo.creerClasse();
			System.out.println("fibo de "+number+" est : "+ClassFibo.getVal(number));
			break;
		case "pado" :
			AbstractFabrique pado = new concreteFabriquePado();
			Algorithm ClassPado = pado.creerClasse();
			System.out.println("pado de "+number+" est : "+ClassPado.getVal(number));
			break;
		default :
			System.err.println("args problem");
			System.exit(0);
		}
		
	}
}
