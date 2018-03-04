package abstfact;

public class concreteFabriquePado implements AbstractFabrique {

	@Override
	public Algorithm creerClasse() {
		Padovan padov = new Padovan();
		return (Algorithm) padov;
	}

}
