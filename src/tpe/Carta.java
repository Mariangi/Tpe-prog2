package tpe;

import java.util.ArrayList;

public class Carta{
	private String nombre;
	private ArrayList<Caracteristica> caracteristicas;
	
	public Carta(String nombre){
		this.nombre = nombre;
		this.caracteristicas = new ArrayList<>();
	}
	
	public Carta(String nombre, ArrayList<Caracteristica> caracteristicas){
		this.nombre = nombre;
		this.caracteristicas = new ArrayList<>();
		this.caracteristicas.addAll(caracteristicas);
	}
	
	public void setCaracteristica(Caracteristica caracteristica){
		this.caracteristicas.add(caracteristica);
	}
	
	public ArrayList<Caracteristica> getCaracteristicas(){
		ArrayList<Caracteristica> Aux = new ArrayList<>();
		Aux.addAll(this.caracteristicas);
		return Aux;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public Caracteristica getCaracteristicaX(int indice){
		System.out.println(indice);
		return this.caracteristicas.get(indice);
	}
	
	public int getCantidadDeCaracteristicas(){		return this.caracteristicas.size();
	}
	
	public int compareTo(Carta carta, int indice){
		//return this.caracteristicas.get(indice).compareTo(carta.getCaracteristicas().get(indice));
		return this.getCaracteristicaX(indice).compareTo(carta.getCaracteristicaX(indice));
	}
	
	public boolean mismoTipoQue(Carta carta){
		if(this.getCantidadDeCaracteristicas() == carta.getCantidadDeCaracteristicas() 
			&& this.getCaracteristicas().contains(carta.getCaracteristicas())
			&& carta.getCaracteristicas().contains(this.getCaracteristicas()))
		{
			return true;
		}else{
			return false;
		}
	}
	
	public int indexOfValorAtributo(String buscado){
		Integer aux = new Integer(4);
		Caracteristica verdaderoBuscado = new Caracteristica(buscado, aux);
		return this.getCaracteristicaX(this.getCaracteristicas().indexOf(verdaderoBuscado)).getValor();
	}

	public int gana(Carta carta, String atributoBuscado){ 
		//return this.caracteristicas.get(indice).compareTo(carta.getCaracteristicas().get(indice));
		Integer aux = new Integer(2);
		Caracteristica verdaderoBuscado = new Caracteristica(atributoBuscado, aux);
		int indice = this.getCaracteristicas().indexOf(verdaderoBuscado);
		return this.getCaracteristicaX(indice).compareTo(carta.getCaracteristicaX(indice)); 
		}
}
