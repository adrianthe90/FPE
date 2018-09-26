package logic;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

public class LogicTrabajador {

	public static void borrarProyecto(int selectedRow) throws SQLException {
		String strSQL = "DELETE FROM ARTrabajador WHERE ID_Trabajador=" + selectedRow;
		dbm.DBSqlServer.ejecutarDML(strSQL);
	}

	public static CachedRowSet consultaGenerica(String strSQL) throws SQLException {
		return dbm.DBSqlServer.consultaSQL(strSQL);
	}

	public static void guardarNuevoTrabajador(int enviarID, String dni, String nombre, String apellido, String genero)
			throws SQLException {
		String strSQL = "INSERT INTO ARTrabajador VALUES (" + enviarID + ",'" + dni + "','" + nombre + "','" + apellido
				+ "','" + genero + "')";
		dbm.DBSqlServer.ejecutarDML(strSQL);
	}

	public static void guardarEditadoTrabajador(int enviarID, String dni, String nombre, String apellido, String genero)
			throws SQLException {
		String strSQL = "UPDATE ARTrabajador SET ID_Trabajador =" + enviarID + ", DNI = '" + dni + "', Nombre ='"
				+ nombre + "', Apellido = '" + apellido + "', Genero ='" + genero + "' WHERE ID_Trabajador ="
				+ enviarID;
		dbm.DBSqlServer.ejecutarDML(strSQL);
	}
}
