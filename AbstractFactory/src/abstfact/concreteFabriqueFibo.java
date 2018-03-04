package abstfact;

public class concreteFabriqueFibo implements AbstractFabrique {

	@Override
	public Algorithm creerClasse() {
		Fibonacci fibon = new Fibonacci();
		return (Algorithm) fibon;
	}

}
