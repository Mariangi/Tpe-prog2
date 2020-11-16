package tpe;

public class QuieroValeX extends Pocion {
	
	private final String nombre = "QuieroValeX";
	private int valeX;
	
	public QuieroValeX(int valeX){
		this.valeX = valeX;
	}

	@Override
	public void EjecutarPocion(Carta carta) {
		for(int index = 0; index < carta.getCantidadDeCaracteristicas(); index++){
			carta.getCaracteristicas().get(index).setValor(this.valeX);
		}
	}
	
	@Override
	public String getNombre() {
		return this.nombre;
	}


}