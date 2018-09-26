package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Ficheros {

	/**
	 * CARGAR LISTA DE FICHEROS
	 * 
	 * DESCRIPTION: . Cargamos lista de String de un fichero para hacer la conexión SQL
	 * INPUT: Lista vacia
	 * OUTPUT: Lista rellena con los datos del fichero para hacer la conexión.  
	 * AUTOR: AROMERO
	 * */
	
	public static List<String> cargarFicheroCFG() throws Exception {
		List<String> cfg = new ArrayList<String>();
		FileReader fch = new FileReader("ficheroSQL.txt");
		BufferedReader b = new BufferedReader(fch);
		for (int i = 1; i <= 5; i++) {
			cfg.add(b.readLine());
		}
		b.close();
		return cfg;
	}

}
