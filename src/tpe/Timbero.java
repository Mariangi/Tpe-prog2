package tpe;

import java.util.ArrayList;

public class Timbero extends Estrategia {

	@Override
	public String aplicarEstrategia(Carta carta) {
		ArrayList<Caracteristica> AuxCaracteristicas = new ArrayList<>();
		AuxCaracteristicas.addAll(carta.getCaracteristicas());
		int numeroRandom = (int)(Math.random()*AuxCaracteristicas.size());
		return carta.getCaracteristicaX(numeroRandom).getNombre();
	}

}
