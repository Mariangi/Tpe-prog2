package tpe;

import java.util.ArrayList;
import java.util.Collections;//para poder hace shuffle

public class Mazo {
	private ArrayList<Carta> cartas; 
	private Carta cartaModelo;
	
	public Mazo(ArrayList<Carta> cartas){
		this.cartas = new ArrayList<>();
		this.cartas.addAll(cartas);
		this.cartaModelo = cartas.get(0);
	}
	
	public Mazo(){
		this.cartas = new ArrayList<>();
		this.cartaModelo = null;
	}
	
	public void setCartaModelo(Carta cartaModelo) {
		this.cartaModelo = cartaModelo;
	}

	public Carta getCarta(){
		Carta aux = this.cartas.get(0);
		this.cartas.remove(0);
		return aux;		
	}

	public Carta getCartaX(int indice){
		return this.cartas.get(indice);
	}
	
	public void mezclar(){
		Collections.shuffle(this.cartas);
	}
	
	public Carta getCartaModelo(){
		this.cartaModelo = this.cartas.get(0);
		return this.cartaModelo;
	}
	
	
	public boolean cumple(Carta carta){
		return this.cartaModelo.mismoTipoQue(carta);
	}
	
	public void filtrar(){
		for(int i = 0 ; i < this.cartas.size(); i++){
			if( !(this.cumple(this.cartas.get(i))) ){
				this.cartas.remove(i);
			}
		}
	}
	
	public int getTamanioDelMazo() {
		return this.cartas.size();
	}
	
	public void recibirCarta(Carta carta) {
		//System.out.println(carta);
		this.cartas.add(carta);
		
	}
	
	public void imprimirMazo(){
		for (int i = 0; i < this.getTamanioDelMazo(); i++){
			//System.out.print(this.cartas.get(i)+ " ");
			System.out.println("--------------------------------------------------------");
			System.out.println("   ");
			System.out.println(this.cartas.get(i).getNombre());
			System.out.println("   ");
			System.out.println(this.cartas.get(i).getCantidadDeCaracteristicas());
			System.out.println("   ");
			for(int index = 0; index < this.cartas.get(i).getCaracteristicas().size(); index ++){
				System.out.println(this.cartas.get(i).getCaracteristicas().get(index).getNombre() + " : " + this.cartas.get(i).getCaracteristicas().get(index).getValor());
			}
		}
	}
}