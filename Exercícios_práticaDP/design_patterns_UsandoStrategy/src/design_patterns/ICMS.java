package design_patterns;

public class ICMS implements Imposto{
	
	@Override
	public double calcula(orcamento orcamento) {
		return orcamento.getValor()*0.1;
	}
}
