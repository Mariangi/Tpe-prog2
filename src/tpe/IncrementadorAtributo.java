package tpe;

public class IncrementadorAtributo extends Pocion{
	
	private final String nombre = "IncrementadorAtributo";
	private int porcentaje;
	private String atributo;
	
	public IncrementadorAtributo(int porcentaje, String atributo){
		this.porcentaje = porcentaje;
		this.atributo = atributo;
	}

	@Override
	public void EjecutarPocion(Carta carta) {
		Integer aux1 = new Integer(4);
		Caracteristica verdaderoBuscado = new Caracteristica(this.atributo, aux1);
		Caracteristica aux = carta.getCaracteristicaX(carta.getCaracteristicas().indexOf(verdaderoBuscado));
		aux.setValor(aux.getValor() + this.porcentaje * aux.getValor() / 100);

	}

	@Override
	public String getNombre() {
		return this.nombre;
	}

	
}
