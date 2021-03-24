package design_patterns;

public class TesteDeImpostos {
	public static void main(String[] args) {
		Imposto iss = new ISS();
		Imposto icms = new ICMS();
		
		orcamento orcamento = new orcamento(500.0);
		
		CalculadorDeImpostos calculador = new CalculadorDeImpostos();
	
		calculador.realizaCalculo(orcamento, iss);
		calculador.realizaCalculo(orcamento, icms);

	}
}
