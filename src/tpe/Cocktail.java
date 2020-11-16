package tpe;

import java.util.ArrayList;

public class Cocktail extends Pocion {

	private final String nombre = "Cocktail";
	private ArrayList<Pocion> pociones;
	
	public Cocktail(){
		this.pociones = new ArrayList<>();
	}
	
	public void setPociones(ArrayList<Pocion> pociones){
		this.pociones = pociones;
	}

	@Override
	public void EjecutarPocion(Carta carta) {
		for(int index = 0; index < this.pociones.size(); index ++){
			this.pociones.get(index).EjecutarPocion(carta);
		}
	}
	
	@Override
	public String getNombre() {
		return this.nombre;
	}


}
