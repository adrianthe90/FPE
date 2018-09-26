package principal;

import java.util.List;

import javax.swing.JOptionPane;
/**
 * INICIO DE LA APP.
 * 
 * DESCRIPTION: . Invoca el método main de la aplicación para abrrirla. 
 * INPUT:
 * OUTPUT:
 * AUTOR: AROMERO
 * */
public class Start {

	public static void main(String[] args) {
		Start app = new Start();
		app.inicio();
	}

	private void inicio() {

		/**
		 * INICIO APP 2. 
		 * 
		 * DESCRIPTION: . Creamos uan lista para recuperar la lista de string para hacer conexión con la 
		 * bbdd. En el caso de que la cadena se pueda crear, hacemos un test de conexión y abrimos el 
		 * controlador del frame principal. 
		 * 
		 * En caso contrario, mostrará un JOptionPane con el error de conectarse el servidor. 
		 * INPUT:
		 * OUTPUT:
		 * AUTOR: AROMERO
		 * */
		
		List<String> cfg = null;
		try {
			cfg = util.Ficheros.cargarFicheroCFG();
		} catch (Exception e) {
		}
		dbm.DBSqlServer.crearCadenaConexion(cfg.get(0), cfg.get(1), cfg.get(2), cfg.get(3), cfg.get(4));
		if (dbm.DBSqlServer.testConexion()) {
			controller.ContrPrincipal.inicioApp();
		} else {
			JOptionPane.showMessageDialog(null, "No se puede establecer la conexión con el servidor.",
					"ERROR DE CONEXION", JOptionPane.ERROR_MESSAGE);
		}

	}

}