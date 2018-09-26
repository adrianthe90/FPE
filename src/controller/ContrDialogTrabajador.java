package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.rowset.CachedRowSet;

import pojo.Trabajador;

public class ContrDialogTrabajador {

	public static void iniciarDialog(int bottonSeleccionado, int filaSeleccionada) throws SQLException {

		if (bottonSeleccionado == 1) {

			new view.DiaDetTrabajador();
			view.DiaDetTrabajador.textIDTr.setText(controller.ContrTrabajador.obtenID().toString());
			view.DiaDetTrabajador.btnGuardarNuevo.setVisible(true);
			view.DiaDetTrabajador.btnGuardarCambios.setVisible(false);
			view.DiaDetTrabajador.btnOK.setVisible(false);
		}
		if (bottonSeleccionado == 2) {
			if (filaSeleccionada >= 0) {
				new view.DiaDetTrabajador();
			}
			ejecutarSentenciaDeRelleno(filaSeleccionada);
			view.DiaDetTrabajador.textIDTr.setEditable(false);
			view.DiaDetTrabajador.btnGuardarNuevo.setVisible(false);
			view.DiaDetTrabajador.btnGuardarCambios.setVisible(true);
			view.DiaDetTrabajador.btnOK.setVisible(false);
		}
		if (bottonSeleccionado == 3) {
			if (filaSeleccionada >= 0) {
				new view.DiaDetTrabajador();
			}
			ejecutarSentenciaDeRelleno(filaSeleccionada);
			view.DiaDetTrabajador.textIDTr.setEditable(false);
			view.DiaDetTrabajador.textDNItr.setEditable(false);
			view.DiaDetTrabajador.textNombre.setEditable(false);
			view.DiaDetTrabajador.textApellidos.setEditable(false);
			view.DiaDetTrabajador.textGenero.setEditable(false);
			view.DiaDetTrabajador.btnGuardarNuevo.setVisible(false);
			view.DiaDetTrabajador.btnGuardarCambios.setVisible(false);
			view.DiaDetTrabajador.btnOK.setVisible(true);
		}
	}
	
	public static void ejecutarSentenciaDeRelleno(int filaSeleccionada) {
		
		try {
			String strSQL = "SELECT * FROM ARTrabajador WHERE ID_Trabajador ="+Integer.toString(filaSeleccionada);
			CachedRowSet resultado = logic.LogicTrabajador.consultaGenerica(strSQL);
			@SuppressWarnings("unchecked")
			ArrayList<Trabajador> t = util.Gui.anadirEnListaTrabajador(resultado);
			rellenarTabla(t,filaSeleccionada);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void rellenarTabla(ArrayList<Trabajador> t, int filaSeleccionada) {

		if (filaSeleccionada >= 0) {
			view.DiaDetTrabajador.textIDTr.setText(Integer.toString(t.get(0).getId()));
			view.DiaDetTrabajador.textDNItr.setText(t.get(0).getDni());
			view.DiaDetTrabajador.textNombre.setText(t.get(0).getNombre());
			view.DiaDetTrabajador.textApellidos.setText(t.get(0).getApellidos());
			view.DiaDetTrabajador.textGenero.setText(t.get(0).getGenero());
		}
	}
}
