package logic;

import java.sql.SQLException;

public class LogicEquipo {

	
	
	
	public static void borrarProyecto(String id_proyecto, String id_trabajador) throws SQLException {
		String strSQL = "DELETE FROM AREquipo WHERE ID_Proyecto=" + id_proyecto + "AND ID_Trabajador ="+id_trabajador;
		dbm.DBSqlServer.ejecutarDML(strSQL);
	}

	public static void guardarNuevoEquipo(int id_equipo, int id_Tr , int id_proye, int id_Car) throws SQLException {
		String strSQL = "INSERT INTO AREquipo VALUES (" + id_equipo + ",'" + id_Tr + "'," + id_proye + ","
				+ id_Car +  ")";
		dbm.DBSqlServer.ejecutarDML(strSQL);
	}

	public static void guardarEditadoEquipo(int id_equipo, int id_Tr , int id_proye, int id_Car) throws SQLException {
		String strSQL = "UPDATE AREquipo SET ID_Equipo =" + id_equipo + ", ID_Trabajador ="
				+ id_Tr +", ID_Proyecto = " + id_proye +  ", ID_Cargo = " + id_Car + " WHERE ID_Equipo =" + id_equipo;
		dbm.DBSqlServer.ejecutarDML(strSQL);
	}
}
