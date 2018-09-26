package controller;

import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;
import javax.swing.table.DefaultTableModel;

public class ContrEquipo {

	public static int bottonSeleccionado;
	public static int filaSeleccionada;

	public static void inicioEquipo() {
		try {
			new view.FrmEquipo();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void rellenarJcombox() throws SQLException {
		// Recogemos un ResultSet (offline) tras mandar una SQL genérica
		String strSQL = "SELECT Nombre FROM ARProyecto";
		CachedRowSet resultado = logic.LogicProyecto.consultaGenerica(strSQL);
		util.Gui.introducirProyectos(resultado);
	}

	/**
	 * MÉTODO PARA ACTUALIZAR LA TABLA
	 */
	public static void actualizarTabla() {

		try {
			int posicionComboBox = view.FrmEquipo.comboBox.getSelectedIndex();
			// Recogemos un ResultSet (offline) tras mandar una SQL genérica
			String strSQL = "SELECT P.ID_Proyecto,T.ID_Trabajador,C.ID_Cargo,T.Nombre,C.Nombre_Cargo" + ",E.ID_Equipo "
					+ "FROM AREquipo AS E INNER JOIN ARTrabajador AS T ON E.ID_Trabajador = "
					+ "T.ID_Trabajador INNER JOIN ARCargo AS C ON C.ID_Cargo = E.ID_Cargo "
					+ "INNER JOIN ARProyecto AS P ON P.ID_Proyecto=E.ID_Proyecto WHERE P.ID_Proyecto="
					+ posicionComboBox;
			CachedRowSet resultado = logic.LogicProyecto.consultaGenerica(strSQL);
			// Generamos un modelo de JTable y actualizamos la vista
			DefaultTableModel m = util.Gui.generarTabla(resultado);
			/*
			 * GENERAMOS LA TABLA QUE QUEREMOS VER VISIBLE, SOLO LOS CAMPOS QUE QUEREMOS
			 * MOSTRAR AL USUARIO, SIN TENER QUE PONER LOS IDS....
			 */
			view.FrmEquipo.tableEquipo.setModel(m);
			view.FrmEquipo.tableEquipo.getColumnModel().getColumn(0).setMinWidth(0);
			view.FrmEquipo.tableEquipo.getColumnModel().getColumn(0).setMaxWidth(0);
			view.FrmEquipo.tableEquipo.getColumnModel().getColumn(1).setMinWidth(0);
			view.FrmEquipo.tableEquipo.getColumnModel().getColumn(1).setMaxWidth(0);
			view.FrmEquipo.tableEquipo.getColumnModel().getColumn(2).setMinWidth(0);
			view.FrmEquipo.tableEquipo.getColumnModel().getColumn(2).setMaxWidth(0);
			view.FrmEquipo.tableEquipo.getColumnModel().getColumn(5).setMinWidth(0);
			view.FrmEquipo.tableEquipo.getColumnModel().getColumn(5).setMaxWidth(0);
		} catch (Exception e) {
		}
	}

	public static void borrarEqupo() {
		try {
			int selectedRow = view.FrmEquipo.tableEquipo.getSelectedRow();
			String id_proyecto = view.FrmEquipo.tableEquipo.getValueAt(selectedRow, 0).toString();
			String id_trabajador = view.FrmEquipo.tableEquipo.getValueAt(selectedRow, 1).toString();
			logic.LogicEquipo.borrarProyecto(id_proyecto, id_trabajador);
			actualizarTabla();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void guardarNuevoEquipo() {
		// recogemos valores.
		String id_equi = view.DiaDetEquipo.textIDEquipo.getText();
		int id_pro1 = view.FrmEquipo.comboBox.getSelectedIndex();
		int id_Tr = view.DiaDetEquipo.comboBoxT.getSelectedIndex();
		int id_Car = view.DiaDetEquipo.comboBoxC.getSelectedIndex();
		int id_equipo = Integer.parseInt(id_equi);
		// según botón (añadir o editar)hacemos el ingreso de nuevo equipo;
		try {
			if (bottonSeleccionado == 1) {
				logic.LogicEquipo.guardarNuevoEquipo(id_equipo, id_Tr, id_pro1, id_Car);
			}
			if (bottonSeleccionado == 2) {
				logic.LogicEquipo.guardarEditadoEquipo(id_equipo, id_Tr, id_pro1, id_Car);
			}
			// actualizamos la tabla.
			actualizarTabla();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void editarEquipo() throws SQLException {
		bottonSeleccionado = 2;
		filaSeleccionada = view.FrmEquipo.tableEquipo.getSelectedRow();
		controller.ContrDialogEquipo.iniciarDialog(bottonSeleccionado, filaSeleccionada);
	}

	public static void nuevoEquipo() throws SQLException {
		bottonSeleccionado = 1;
		filaSeleccionada = 0;
		controller.ContrDialogEquipo.iniciarDialog(bottonSeleccionado, filaSeleccionada);
	}
}
