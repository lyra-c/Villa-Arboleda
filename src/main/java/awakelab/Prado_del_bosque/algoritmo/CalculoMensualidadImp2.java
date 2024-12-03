package awakelab.Prado_del_bosque.algoritmo;

public class CalculoMensualidadImp2 implements ICalculoMensualidadIntereses {

	// Mensualidad con intereses	// No es la mejor manera, pero sigue la sugerencia de la prueba
	@Override
	public float calcularMensualidadConIntereses (float medida_metros, float valor_tipo, float gastos_mensuales, boolean moroso) {
		
		float mensualidad_con_intereses = (medida_metros / valor_tipo) * gastos_mensuales;
		
		if (moroso) {
			mensualidad_con_intereses += (mensualidad_con_intereses * 0.03);
		}
		
		
		return mensualidad_con_intereses;
	}
	
}
