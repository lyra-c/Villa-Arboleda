package awakelab.Prado_del_bosque.algoritmo;

import org.springframework.stereotype.Service;

public interface ICalculoMensualidad {
	
	float calcularMensualidad (float medida_metros, float valor_tipo, float gastos_mensuales);
	
}
