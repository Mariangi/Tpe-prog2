package tpe;

import java.util.Collections;

public class Ambicioso extends Estrategia{

	@Override
	public String aplicarEstrategia(Carta carta){
		return Collections.max(carta.getCaracteristicas()).getNombre();
	}

}