package tpe;

public class Caracteristica implements Comparable<Caracteristica>{
	private String nombre;
	private int valor;
	
	public Caracteristica(String nombre, int valor){
		this.nombre = nombre;
		this.valor = valor;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public int getValor(){
		return this.valor;
	}
	
	@Override
	public boolean equals(Object obj){
		try{
			Caracteristica c = (Caracteristica) obj;
			return this.getNombre().equals(c.getNombre());
		}catch(Exception e){
			return false;
		}
	}
	
	@Override
	public int compareTo(Caracteristica caracteristica){
		int thisValor = (int)this.getValor();//hacemos cast de un objeto Integer que sabemos que siempre llega Integer
		int caracteristicaExterior = (int)caracteristica.getValor();//Como sabemos que llega Integer podemos hacer casting a int sin que falle
		/*if(thisValor > caracteristicaExterior){
			return 1;
		}else if(thisValor < caracteristicaExterior){
			return -1;
		}else{//de lo contrario son iguales
			return 0;
		}*/
		return thisValor - caracteristicaExterior;
	}
}


	
	