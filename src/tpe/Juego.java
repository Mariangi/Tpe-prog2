package tpe;

import java.util.ArrayList;

public class Juego {
	private Jugador jugador1;
	private Jugador jugador2;
	private Mazo mazo;
	private int maxRondas;
	private ArrayList<Pocion> pociones;
	
	
	public Juego(Jugador jugador1, Jugador jugador2, Mazo mazo, int maxRondas ){
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.mazo = mazo;
		this.maxRondas = maxRondas;
		this.pociones = new ArrayList<>();
	}
	
	public void setPociones(ArrayList<Pocion> pociones){
		this.pociones.addAll(pociones);
	}

	public int getMaxRondas(){
		return this.maxRondas;
	}
	
	private Pocion getPocion(){
		Pocion aux = this.pociones.get(0);
		this.pociones.remove(0);
		return aux;
	}
	
	
	public void repartirCartas(){
		int tamanioDelMazoOriginal = this.mazo.getTamanioDelMazo();
		for (int i= 0; i < tamanioDelMazoOriginal; i++){
			Carta aux = this.mazo.getCarta();
			if( ( i % 2 ) == 0 ){// % es modulo - modulo de 2 es igual a 0				
				if(this.pociones.size() > 0){
					aux.setPocion(this.getPocion());
				}
				this.jugador1.recibirCarta(aux);
			}else{
				if(this.pociones.size() > 0){
					aux.setPocion(this.getPocion());
				}
				this.jugador2.recibirCarta(aux);
			}
		}
	}
	
	public ArrayList<String> play(){
		int maxRondas = this.getMaxRondas();
		int i = 0;
		Jugador ganadorDeLaUltimaRonda = this.jugador1;
		Jugador perdedorDeLaUltimaRonda = this.jugador2;
		ArrayList<String> resultadoPartida = new ArrayList<>();
		this.mazo.filtrar();
		this.mazo.mezclar();
		this.repartirCartas();
		while( (i < maxRondas) && (this.jugador1.tieneCartas()) && (this.jugador2.tieneCartas()) ){
			resultadoPartida.add("-------------- Ronda " + i + " ----------");
			Carta cartaGanador = ganadorDeLaUltimaRonda.getCarta();
			Carta cartaPerdedor = perdedorDeLaUltimaRonda.getCarta();
			String caracteristicaRandom = ganadorDeLaUltimaRonda.getCaracteristica();
			if((cartaGanador.getPocion() != null) && (cartaPerdedor.getPocion() != null)){
				int valorViejoGanador = cartaGanador.indexOfValorAtributo(caracteristicaRandom);
				cartaGanador.getPocion().EjecutarPocion(cartaGanador);
				int valorViejoPerdedor = cartaPerdedor.indexOfValorAtributo(caracteristicaRandom);
				cartaPerdedor.getPocion().EjecutarPocion(cartaPerdedor);
				resultadoPartida.add("El jugador " + ganadorDeLaUltimaRonda.getNombre() + " selecciona competir por el atributo: " + caracteristicaRandom + " " + "La carta de " + ganadorDeLaUltimaRonda.getNombre() + " es " + cartaGanador.getNombre() + " con " + caracteristicaRandom + " " + valorViejoGanador + " , se aplico la pocima " + cartaGanador.getPocion().getNombre() +  " el valor resultante es "+ cartaGanador.indexOfValorAtributo(caracteristicaRandom) );				
				resultadoPartida.add("La carta de " + perdedorDeLaUltimaRonda.getNombre() + " es " + cartaPerdedor.getNombre() + " con " + caracteristicaRandom+ " " + + valorViejoPerdedor + " , se aplico la pocima " + cartaPerdedor.getPocion().getNombre() +  " el valor resultante es "+ cartaPerdedor.indexOfValorAtributo(caracteristicaRandom));
			}else if((cartaGanador.getPocion() == null) && (cartaPerdedor.getPocion() != null)){
				int valorViejoPerdedor = cartaPerdedor.indexOfValorAtributo(caracteristicaRandom);
				cartaPerdedor.getPocion().EjecutarPocion(cartaPerdedor);
				resultadoPartida.add("El jugador " + ganadorDeLaUltimaRonda.getNombre() + " selecciona competir por el atributo: " + caracteristicaRandom + " " + "La carta de " + ganadorDeLaUltimaRonda.getNombre() + " es " + cartaGanador.getNombre() + " con " + caracteristicaRandom+ " " + cartaGanador.indexOfValorAtributo(caracteristicaRandom) + " " + "La carta de " + perdedorDeLaUltimaRonda.getNombre() + " es " + cartaPerdedor.getNombre() + " con " + caracteristicaRandom + " "  + valorViejoPerdedor + " , se aplico la pocima " + cartaPerdedor.getPocion().getNombre() +  " el valor resultante es "+ cartaPerdedor.indexOfValorAtributo(caracteristicaRandom));				
			}else if((cartaGanador.getPocion() != null) && (cartaPerdedor.getPocion() == null)){
				int valorViejoGanador = cartaGanador.indexOfValorAtributo(caracteristicaRandom);
				cartaGanador.getPocion().EjecutarPocion(cartaGanador);
				resultadoPartida.add("El jugador " + ganadorDeLaUltimaRonda.getNombre() + " selecciona competir por el atributo: " + caracteristicaRandom + " " + "La carta de " + ganadorDeLaUltimaRonda.getNombre() + " es " + cartaGanador.getNombre() + " con " + caracteristicaRandom+ " " + valorViejoGanador + " " + "La carta de " + perdedorDeLaUltimaRonda.getNombre() + " es " + cartaPerdedor.getNombre() + " con " + caracteristicaRandom + " "  + cartaPerdedor.indexOfValorAtributo(caracteristicaRandom));
			}else{				
				resultadoPartida.add("El jugador " + ganadorDeLaUltimaRonda.getNombre() + " selecciona competir por el atributo: " + caracteristicaRandom + " " + "La carta de " + ganadorDeLaUltimaRonda.getNombre() + " es " + cartaGanador.getNombre() + " con " + caracteristicaRandom+ " " + cartaGanador.indexOfValorAtributo(caracteristicaRandom) + " " + "La carta de " + perdedorDeLaUltimaRonda.getNombre() + " es " + cartaPerdedor.getNombre() + " con " + caracteristicaRandom + " " + cartaPerdedor.indexOfValorAtributo(caracteristicaRandom));
			}
			/*System.out.println("El jugador " + ganadorDeLaUltimaRonda.getNombre() + " selecciona competir por el atributo: " + caracteristicaRandom);
			System.out.println("La carta de " + ganadorDeLaUltimaRonda.getNombre() + " es " + cartaGanador.getNombre() + " con " + caracteristicaRandom+ " " + cartaGanador.indexOfValorAtributo(caracteristicaRandom));
			System.out.println("La carta de " + perdedorDeLaUltimaRonda.getNombre() + " es " + cartaPerdedor.getNombre() + " con " + caracteristicaRandom+ " " + cartaPerdedor.indexOfValorAtributo(caracteristicaRandom));*/
			if(cartaGanador.gana(cartaPerdedor, caracteristicaRandom) > 0){//gana p1
				//System.out.println("if");
				ganadorDeLaUltimaRonda.recibirCarta(cartaPerdedor);
				ganadorDeLaUltimaRonda.recibirCarta(cartaGanador);
				resultadoPartida.add("Gana la ronda "+ ganadorDeLaUltimaRonda.getNombre() + " " + ganadorDeLaUltimaRonda.getNombre() + " posse ahora " + ganadorDeLaUltimaRonda.cantidadDeCartas()+ " y " + perdedorDeLaUltimaRonda.getNombre() + " posee ahora " + perdedorDeLaUltimaRonda.cantidadDeCartas()) ;
				i++;
				
			}else if (cartaGanador.gana(cartaPerdedor, caracteristicaRandom) < 0){//gana p2
				//System.out.println("else if");
				perdedorDeLaUltimaRonda.recibirCarta(cartaGanador);
				perdedorDeLaUltimaRonda.recibirCarta(cartaPerdedor);
				Jugador aux;
				aux = perdedorDeLaUltimaRonda;
				perdedorDeLaUltimaRonda = ganadorDeLaUltimaRonda;
				ganadorDeLaUltimaRonda = aux;
				resultadoPartida.add("Gana la ronda "+ ganadorDeLaUltimaRonda.getNombre() + " " + ganadorDeLaUltimaRonda.getNombre() + " posse ahora " + ganadorDeLaUltimaRonda.cantidadDeCartas()+ " y " + perdedorDeLaUltimaRonda.getNombre() + " posse ahora " + perdedorDeLaUltimaRonda.cantidadDeCartas());
				i++;
				
			}else{//en caso de un empate
				//System.out.println("else");
				ganadorDeLaUltimaRonda.recibirCarta(cartaGanador);
				perdedorDeLaUltimaRonda.recibirCarta(cartaPerdedor);
				
				resultadoPartida.add("La ronda termino en empate" + " " + ganadorDeLaUltimaRonda.getNombre() + " posse ahora " + ganadorDeLaUltimaRonda.cantidadDeCartas()+ " y " + perdedorDeLaUltimaRonda.getNombre() + " posse ahora " + perdedorDeLaUltimaRonda.cantidadDeCartas());		
				i++;
				
			}
		}
		return resultadoPartida;
	}
}
