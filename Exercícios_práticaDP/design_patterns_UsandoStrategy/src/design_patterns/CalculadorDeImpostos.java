package design_patterns;

public class CalculadorDeImpostos {
	
	public void realizaCalculo(orcamento orcamento, Imposto impostoQualquer) {
		
		double icms = impostoQualquer.calcula(orcamento);
			System.out.println(icms);
	
		}
}

