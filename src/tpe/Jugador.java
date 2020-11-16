package tpe;

import java.util.ArrayList;

public class Jugador {
	private String nombre;
	private Mazo mazo;
	private Estrategia estrategia;

	public Jugador(String nombre, Estrategia estrategia){
		this.nombre = nombre;
		this.mazo = new Mazo();
		this.estrategia = estrategia;
	}
	
	public Estrategia getEstrategia(){
		return estrategia;
	}

	public void setEstrategia(Estrategia estrategia){
		this.estrategia = estrategia;
	}

	public void setNombreJugador(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public void recibirCarta(Carta carta){//el final del arreglo es el final del mazo del jugador, la parte de abajo.
		//System.out.println(carta + " : " + carta.getNombre());
		this.mazo.recibirCarta(carta);
	
	}
	
	public Carta getCarta(){//me da la primer carta del mazo del jugador
		return this.mazo.getCarta();	
	}
	
	public boolean tieneCartas(){
		return (this.mazo.getTamanioDelMazo() > 0);
	}
	
	public int cantidadDeCartas(){
		return this.mazo.getTamanioDelMazo();
	}
	
	/*public String getCaracteristicaRandom(){
		ArrayList<Caracteristica> AuxCaracteristicas = new ArrayList<>();
		AuxCaracteristicas.addAll(this.mazo.getCartaX(0).getCaracteristicas());
		int numeroRandom = (int)(Math.random()*AuxCaracteristicas.size());
		return this.mazo.getCartaX(0).getCaracteristicaX(numeroRandom).getNombre();
	}*/
	
	public String getCaracteristica(){
		return this.estrategia.aplicarEstrategia(this.mazo.getCartaModelo());
	}
}