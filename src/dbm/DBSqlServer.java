package dbm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class DBSqlServer {

	public static String cadenaConexion;
	public static String textIP;
	public static String textPuerto;
	public static String textBBDD;
	public static String textUsuario;
	public static String textPaswword;

	
	/**
	 * CADENA DE STRING PARA CONEXIÓN CON BBDD DE SQL. 
	 * crearCadenaConexión.
	 * 
	 * DESCRIPTION: Recogemos los datos para pasarlo como cadena de texto 
	 * 				para crear la conexión. (IP, PUERTO, NOMBRE DE LA BBDD, USUARIO Y CONTRASEÑA)
	 * 
	 * INPUT:	PASAMOS POR PARAMETROS TODOS LOS VALORES NECESARIOS
	 * OUTPUT:	
	 * AUTOR: AROMERO
	 * */
	
	
	public static void crearCadenaConexion(String strIP, String strPort, String strDatabaseName, String strUserName,
			String strUserPassword) {
		String cadena = "jdbc:sqlserver:";
		cadena += "//" + strIP;
		cadena += ":" + strPort;
		cadena += ";database=" + strDatabaseName;
		cadena += ";user=" + strUserName;
		cadena += ";password=" + strUserPassword;
		cadenaConexion = cadena;
	}
	
	/**
	 * TEST DE CONEXIÓN.
	 * testConexion();
	 *  
	 * DESCRIPTION: Realiza la prueba de si logra conexionar el programa con la bbdd, 
	 * 				devolviendo booleano, verdadero si realiza la conexión y falso si no la puede iniciar.
	 * INPUT:
	 * OUTPUT:
	 * AUTOR: AROMERO
	 * */
	
	public static boolean testConexion() {
		boolean test = false;
		try {
			Connection c = establecerConexion();
			cerrarConexion(c);
			test = true;
		} catch(Exception e) {
			test = false;
		}
		return test;
	}

	/**
	 * CREAR CADENA DE CONEXIÓN_V 0.5 
	 * 
	 * @description: anteriormente se realizaba el conexionado a traves de botón. NO SE UTILIZA EN ESTA VERSION.
	 * 	 
	 * @param:
	 * @return:
	 * 
	 * @author AROMERO
	 * */
	
	public static void crearCadenaConexion_2() {

		try {
			FileReader fichero = new FileReader("ficheroSQL.txt");
			BufferedReader buffer = new BufferedReader(fichero);
			textIP = buffer.readLine();
			textPuerto = buffer.readLine();
			textBBDD = buffer.readLine();
			textUsuario = buffer.readLine();
			textPaswword = buffer.readLine();
			buffer.close();
		} catch (FileNotFoundException e) {
			System.out.print("ERROR: El fichero no existe");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.print("ERROR: no se puede leer del fichero");
			e.printStackTrace();
		}
		String cadena = "jdbc:sqlserver:";
		cadena += "//" + textIP;
		cadena += ":" + textPuerto;
		cadena += ";database=" + textBBDD;
		cadena += ";user=" + textUsuario;
		cadena += ";password=" + textPaswword;
		cadenaConexion = cadena;
	}

	/**
	 * ESTABLECER CONEXIÓN CON LA BBDD. 
	 * 
	 * @description: REALIZA LA CONEXIÓN CON LA BBDD.
	 * 
	 * @param: ENVÍA UNA Connection.
	 * @return: DEVUELVE EL getConnection. 
	 * 
	 * @author AROMERO
	 * */
	
	public static Connection establecerConexion() throws SQLException {
		return DriverManager.getConnection(cadenaConexion);
	}
	
	
	/**
	 * CERRAR CONEXIÓN CON LA BBDD. 
	 * 
	 * @description: REALIZA EL CIERRE DE LA CONEXIÓN CON LA BBDD.
	 * 
	 * @param: ENVÍA UNA Connection.
	 * @return: CIERRA LA CONEXIÓN.CLOSE
	 * 
	 * @author AROMERO
	 * */
	
	public static void cerrarConexion(Connection conn)  throws SQLException {
		conn.close();
	}

	
	/**
	 * CONSULTA SQL GENERICA.
	 * 
	 * @description: REALIZA EL ENVÍO DE UNA CONSULTA SQL A TRAVÉS DE UN STRIGN Y DEVUELVE
	 * 				 CACHEADO EL RESULTADO DE LA CONSULTA PARA PODER UTILIZAR ESOS DATOS A POSTERIORI.
	 * 				 1 - SE CREA CONEXIÓN, (YA CON UN MÉTODO CREADO ANTERIOR PASANDOLE EL STRING DE CONEXIÓN)
	 * 				 2 - CREA CANAL DE TRASMIISIÓN. 
	 * 				 3 - RECOGER LOS DATOS EN UN RESULSET Y TRANSFORMARLO EN CACHEADO.
	 * 				 4 - SE CIERRA LA CONEXIÓN CON OTRO MÉTODO ANTERIORMENTE PASANDOLE COMO PARAM. LA CONEX
	 * 
	 * @param: ENVÍA STRING (DE LA CONSULTA . SELECT * FROM TABLE)
	 * @return: DEVUELVE LOS DATOS CACHEADOS. 
	 * 
	 * @author AROMERO
	 * */
	
	public static CachedRowSet consultaSQL(String strSQL) throws SQLException {

		Connection c = establecerConexion();
		Statement s = c.createStatement();
		ResultSet r = s.executeQuery(strSQL);
		RowSetFactory factory = RowSetProvider.newFactory();
		CachedRowSet rowset = factory.createCachedRowSet();
		rowset.populate(r);
		cerrarConexion(c);
		return rowset;
	}

	
	/**
	 * EJECUTAR DML.
	 * 
	 * @description: EJECUTAR SENTENCIA DE INSERT, UPDATE O DELELTE A UNA BASE DE DATOS SQL.
	 * 				 - CREA CONEXIÓN,ESTABLLECE EL CANAL, REALIZA LA SENTENCIA Y CIERRA CONEXIÓN: 
	 * 
	 * @param: ENVÍA STRING CON LA SENTENCIA..
	 * @return: //
	 * 
	 * @author AROMERO
	 * */
	
	public static void ejecutarDML(String strSQL) throws SQLException {
		Connection c = establecerConexion();
		Statement s = c.createStatement();
		s.executeUpdate(strSQL);
		cerrarConexion(c);
	}

}