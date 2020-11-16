package tpe;

public class ReductorX extends Pocion{
	
	private String nombre;
	private int porcentaje;
	
	public ReductorX(int porcentaje){
		this.porcentaje = porcentaje;
	}
	
	@Override
	public void EjecutarPocion(Carta carta) {
		for(int index = 0; index < carta.getCantidadDeCaracteristicas(); index++){
			carta.getCaracteristicas().get(index).setValor( carta.getCaracteristicas().get(index).getValor() - (this.porcentaje * carta.getCaracteristicas().get(index).getValor() ) / 100);
		}
	}

	@Override
	public String getNombre() {
		return this.nombre;
	}

	
}
