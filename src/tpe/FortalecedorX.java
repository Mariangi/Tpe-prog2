package tpe;

public class FortalecedorX extends Pocion{

	private final String nombre = "Fortalecedora";
	private int porcentaje;
	
	public FortalecedorX(int porcentaje){
		this.porcentaje = porcentaje;
	}
	
	
	@Override
	public void EjecutarPocion(Carta carta) {
		for(int index = 0; index < carta.getCantidadDeCaracteristicas(); index++){
			carta.getCaracteristicas().get(index).setValor((this.porcentaje * carta.getCaracteristicas().get(index).getValor() ) / 100 + carta.getCaracteristicas().get(index).getValor());
		}
	}


	@Override
	public String getNombre() {
		return this.nombre;
	}

}
