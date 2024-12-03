package awakelab.Prado_del_bosque.algoritmo;

public class CalculoMensualidadImp1 implements ICalculoMensualidad {

	@Override
	public float calcularMensualidad (float medida_metros, float valor_tipo, float gastos_mensuales) {
		return (medida_metros / valor_tipo) * gastos_mensuales;
	}
	
}
