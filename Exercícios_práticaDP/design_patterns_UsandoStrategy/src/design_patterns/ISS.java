package design_patterns;

public class ISS implements Imposto{
	
	@Override
	public double calcula(orcamento orcamento) {
		return orcamento.getValor()*0.06;
	}
}
