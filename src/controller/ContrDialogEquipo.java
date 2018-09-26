package controller;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

public class ContrDialogEquipo {
//esto es el ejemplo del ejemplo  s gfasdasdfas
	public static void iniciarDialog(int bottonSeleccionado, int filaSeleccionada) throws SQLException {

		if (bottonSeleccionado == 1) {
			new view.DiaDetEquipo();
			try {
				rellenarTextyIDProyecto();
				rellenarComboBoxT();
				rellenarComboBoxC();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			view.DiaDetEquipo.btnGuardarCambios.setVisible(false);
		}
		if (bottonSeleccionado == 2) {
			if (filaSeleccionada >= 0) {
				new view.DiaDetEquipo();
			}
			ejecutarSentenciaDeRelleno(filaSeleccionada);
			view.DiaDetEquipo.btnNewEquipo.setVisible(false);
		}
	}

	private static void ejecutarSentenciaDeRelleno(int filaSeleccionada) throws SQLException {
		
		rellenarText();
		//rellenarTextyIDProyecto1();
		rellenarComboBoxT();
		rellenarComboBoxC();
		int a = Integer.parseInt(view.FrmEquipo.tableEquipo.getValueAt(filaSeleccionada, 1).toString());
		int b = Integer.parseInt(view.FrmEquipo.tableEquipo.getValueAt(filaSeleccionada, 2).toString());
		String c =view.FrmEquipo.tableEquipo.getValueAt(filaSeleccionada, 5).toString();
		view.DiaDetEquipo.textIDEquipo.setText(c);
		view.DiaDetEquipo.textIDEquipo.setEditable(false);
		view.DiaDetEquipo.comboBoxT.setSelectedIndex(a);
		view.DiaDetEquipo.comboBoxC.setSelectedIndex(b);
	}

	private static void rellenarText() throws SQLException {
		int a = view.FrmEquipo.comboBox.getSelectedIndex();
		String strSQL = "SELECT Nombre FROM ARProyecto WHERE ID_Proyecto=" + Integer.toString(a);
		CachedRowSet resultado = logic.LogicProyecto.consultaGenerica(strSQL);
		util.Gui.obtenerNombreProyecto(resultado);
	}

	private static void rellenarTextyIDProyecto() throws SQLException {

		int a = view.FrmEquipo.comboBox.getSelectedIndex();
		String strSQL = "SELECT Nombre FROM ARProyecto WHERE ID_Proyecto=" + Integer.toString(a);
		CachedRowSet resultado = logic.LogicProyecto.consultaGenerica(strSQL);
		String strSQL1 = "SELECT MAX(ID_Equipo) FROM AREquipo" ;
		CachedRowSet resultado1 = logic.LogicProyecto.consultaGenerica(strSQL1);
		util.Gui.obtenerNombreProyecto(resultado);
		util.Gui.obtenerIDProyecto(resultado1);
	}

	private static void rellenarComboBoxC() throws SQLException {
		String strSQL = "SELECT Nombre_Cargo FROM ARCargo";
		CachedRowSet resultado = logic.LogicProyecto.consultaGenerica(strSQL);
		util.Gui.introducirCargoDialog(resultado);
	}

	private static void rellenarComboBoxT() throws SQLException {
		String strSQL = "SELECT Nombre FROM ARTrabajador";
		CachedRowSet resultado = logic.LogicProyecto.consultaGenerica(strSQL);
		util.Gui.introducirTrabajadorDialog(resultado);
	}

}
