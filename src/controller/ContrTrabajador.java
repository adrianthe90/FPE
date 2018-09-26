package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;
import javax.swing.table.DefaultTableModel;

import pojo.Trabajador;

/**
 * CONTROLADOR TRABAJADOR
 * 
 * @author AROMERO
 */
public class ContrTrabajador {

	public static List<Trabajador> lstTrabajdor = new ArrayList<Trabajador>();
	public static int bottonSeleccionado;
	public static int filaSeleccionada;
	public static int estado;

	/**
	 * CONTROLADOR ABRIR FRAME TRABAJADOR
	 * 
	 * @description: Abrir frame TRABAJADOR
	 * @author AROMERO
	 */
	public static void inicioTrabajador() {
		new view.FrmTrabajador();
	}

	/**
	 * CONTROLADOR ACTUALIZAR JTABLE DE TRABAJADOR
	 * 
	 * @description: ACTUALIZAR LA TABLA. 
	 * @author AROMERO
	 */
	public static void actualizarTabla() {

		try {
			// Recogemos un ResultSet (offline) tras mandar una SQL genérica
			String strSQL = "SELECT * FROM ARTrabajador";
			CachedRowSet resultado = logic.LogicTrabajador.consultaGenerica(strSQL);
			// Generamos un modelo de JTable y actualizamos la vista
			DefaultTableModel m = util.Gui.generarTabla(resultado);
			view.FrmTrabajador.tableTrabajador.setModel(m);
		} catch (Exception e) {
		}
	}

	public static void nuevoTrabajador() throws SQLException {
		bottonSeleccionado = 1;
		filaSeleccionada = 0;
		controller.ContrDialogTrabajador.iniciarDialog(bottonSeleccionado, filaSeleccionada);
	}

	public static void borrarTrabajador() {
		try {
			int selectedRow = view.FrmTrabajador.tableTrabajador.getSelectedRow() + 1;
			logic.LogicTrabajador.borrarProyecto(selectedRow);
			actualizarTabla();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void guardarProyecto() throws SQLException {
		String id = view.DiaDetTrabajador.textIDTr.getText();
		String dni = view.DiaDetTrabajador.textDNItr.getText();
		String nombre = view.DiaDetTrabajador.textNombre.getText();
		String apellido = view.DiaDetTrabajador.textApellidos.getText();
		String genero = view.DiaDetTrabajador.textGenero.getText();
		int enviarID = Integer.parseInt(id);
		if (estado == 1) {
			logic.LogicTrabajador.guardarNuevoTrabajador(enviarID, dni, nombre, apellido, genero);
		}
		if (estado == 2) {
			logic.LogicTrabajador.guardarEditadoTrabajador(enviarID, dni, nombre, apellido, genero);
		}
		actualizarTabla();
	}

	public static void editarTrabajador() throws SQLException {
		bottonSeleccionado = 2;
		filaSeleccionada = view.FrmTrabajador.tableTrabajador.getSelectedRow() + 1;
		controller.ContrDialogTrabajador.iniciarDialog(bottonSeleccionado, filaSeleccionada);
	}

	public static void infoTrabajador() throws SQLException {
		bottonSeleccionado = 3;
		filaSeleccionada = view.FrmTrabajador.tableTrabajador.getSelectedRow() + 1;
		controller.ContrDialogTrabajador.iniciarDialog(bottonSeleccionado, filaSeleccionada);
	}

	public static String obtenID() throws SQLException {
		String maxID;
		String strSQL = "SELECT MAX(ID_Trabajador) FROM ARTrabajador";
		// hago petición.
		CachedRowSet resultado = logic.LogicProyecto.consultaGenerica(strSQL);
		// obtengo el máximo ID
		String a = util.Gui.obtenerID(resultado);
		// lo cambio a entero para sumarle 1.
		int b = Integer.parseInt(a) + 1;
		// lo paso a string para meterlo en la caja de texto.
		maxID = Integer.toString(b);
		return maxID;
	}
}
