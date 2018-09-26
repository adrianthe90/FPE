package logic;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

public class LogicProyecto {

	public static void borrarProyecto(int selectedRow) throws SQLException {
		String strSQL = "DELETE FROM ARProyecto WHERE ID_Proyecto=" + selectedRow;
		dbm.DBSqlServer.ejecutarDML(strSQL);
	}

	public static void guardarNuevoProyecto(int enviarID, String nombre, int enviarFechaI, int enviarFechaF,
			int enviarPresupuesto) throws SQLException {
		String strSQL = "INSERT INTO ARProyecto VALUES (" + enviarID + ",'" + nombre + "'," + enviarFechaI + ","
				+ enviarFechaF + "," + enviarPresupuesto + ")";
		dbm.DBSqlServer.ejecutarDML(strSQL);
	}

	public static void guardarEditadoProyecto(int enviarID, String nombre, int enviarFechaI, int enviarFechaF,
			int enviarPresupuesto) throws SQLException {
		String strSQL = "UPDATE ARProyecto SET ID_Proyecto =" + enviarID + ", Nombre = '" + nombre + "', Fecha_Inicio ="
				+ enviarFechaI + ", Fecha_Final = " + enviarFechaF + ", Presupuesto =" + enviarPresupuesto
				+ " WHERE ID_PROYECTO =" + enviarID;
		dbm.DBSqlServer.ejecutarDML(strSQL);
	}

	public static CachedRowSet consultaGenerica(String strSQL) throws SQLException {
		return dbm.DBSqlServer.consultaSQL(strSQL);
	}

}
