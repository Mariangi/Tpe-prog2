package tpe;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;


public class Main {
		
	public static ArrayList<Carta> CargarMazo(String jsonFile){
	//URL url = getClass().getResource(jsonFile);
		File jsonInputFile = new File(jsonFile);
		InputStream is;
		ArrayList<Carta> arregloDeCartas = new ArrayList<>();
		//Mazo mazote = new Mazo(arregloDeCartas);
		try {
		    is = new FileInputStream(jsonInputFile);
		    
		    // Creo el objeto JsonReader de Json.
		    JsonReader reader = Json.createReader(is);
		    // Obtenemos el JsonObject a partir del JsonReader.
		    
		    JsonArray cartas = (JsonArray) reader.readObject().getJsonArray("cartas");
		    for (JsonObject carta : cartas.getValuesAs(JsonObject.class)){
		    
		        String nombreCarta = carta.getString("nombre");
		        JsonObject atributos = (JsonObject) carta.getJsonObject("atributos");
		        
		    String atributosStr = "";
		       	
		        Carta CartaNueva = new Carta(nombreCarta);
		       
		        for (String nombreAtributo:atributos.keySet()){
		            atributosStr = atributosStr + nombreAtributo + ": " + atributos.getInt(nombreAtributo) + "; ";
		        	Caracteristica CaracteristicaNueva = new Caracteristica(nombreAtributo, new Integer(atributos.getInt(nombreAtributo)));
		        	CartaNueva.setCaracteristica(CaracteristicaNueva);
		        }
		        //System.out.println(nombreCarta+"\t\t\t"+atributosStr);
		        arregloDeCartas.add(CartaNueva);
		    } 
		    
	
		   // Mazo mazote = new Mazo(arregloDeCartas);
		    reader.close();
		    
		
		} catch (FileNotFoundException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		return arregloDeCartas;
	}




		
		
		public static void main(String[] args) {	

			//String mazoPath = "autos.json";
			String mazoPath = "superheroes.json";
	        Main.CargarMazo(mazoPath);
	        //Jugador Nico = new Jugador("Nico");
	        //Jugador Angi = new Jugador("Angi");
	        Mazo mazoDeJuego = new Mazo(Main.CargarMazo(mazoPath));
	        //mazoDeJuego.filtrar();
	        //mazoDeJuego.imprimirMazo();
	        //Juego juego1 = new Juego(Nico, Angi, mazoDeJuego, 10);
	        ArrayList<String> ResultadoDelJuego = new ArrayList<>();
	        //ResultadoDelJuego = juego1.play();
	        
	        for(int index = 0; index < ResultadoDelJuego.size(); index++){
	        	System.out.println("     ");
	        	System.out.println(ResultadoDelJuego.get(index));
	        }
	        
	        
		}

}



	
		
