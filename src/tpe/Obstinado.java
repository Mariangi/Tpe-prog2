package tpe;

public class Obstinado extends Estrategia{

	private String nombreAtributo;
	
	
	public Obstinado(String nombreAtributo){
		this.nombreAtributo = nombreAtributo;
	}
	
	public void setNombreAtributo(String nombreAtributoNuevo){
		this.nombreAtributo = nombreAtributoNuevo;
	}
	
	@Override
	public String aplicarEstrategia(Carta carta){
		return this.nombreAtributo;
	}

}