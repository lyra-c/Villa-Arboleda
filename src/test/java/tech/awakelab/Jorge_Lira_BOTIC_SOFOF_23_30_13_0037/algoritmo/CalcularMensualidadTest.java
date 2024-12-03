package tech.awakelab.Jorge_Lira_BOTIC_SOFOF_23_30_13_0037.algoritmo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import awakelab.Prado_del_bosque.algoritmo.*;


class CalcularMensualidadTest {

	private float medida = 150;
	private float valorTipo = 200;
	private float gasto = 30000;
	private boolean moroso = true;
	
	// El resultado para el algoritmo simple es 22500
	// El resultado para el algoritmo con intereses es 23175
	
	/*
	 * mensualidad = (medida_metros / valor_tipo) * gastos_mensuales;
		
		
			mensualidad_con_intereses += (mensualidad * 0.03);
	 * */
	
	@Test
	public void CalcularMensualidad() {
		
		/* Arrange de la clase CalculoMensualidadImp1 del algoritmo, con su método
		 * calcularMensualidad() proveniente de la interfaz ICalculoMensualidad
		 * */
		CalculoMensualidadImp1 algoritmo = new CalculoMensualidadImp1();
		
		// Eje
		float result = algoritmo.calcularMensualidad(medida, valorTipo, gasto);
		
		// Assert
		assertEquals(22500, result, "El resultado del cálculo es incorrecto. Debiera dar 22500");
		
		System.out.println("Prueba para algoritmo 1 realizada con éxito");
		
	}
	
	@Test
	void CalcularMensualidadConIntereses() {
		
		/* Arrange de la clase CalculoMensualidadImp2 del algoritmo, con su método
		 * calcularMensualidadConIntereses() proveniente de la interfaz 
		 * ICalculoMensualidadIntereses
		 * */
		CalculoMensualidadImp2 algoritmoIntereses = new CalculoMensualidadImp2();
		
		// Act
		float result = algoritmoIntereses.calcularMensualidadConIntereses(medida, valorTipo, gasto, moroso);
		
		// Assert
		assertEquals(23175, result, "El resultado del cálculo es incorrecto. Debiera dar 23175");
		
		System.out.println("Prueba para algoritmo 2 realizada con éxito");
		
	}

}
