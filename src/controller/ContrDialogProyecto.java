package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.rowset.CachedRowSet;

import pojo.Proyecto;

public class ContrDialogProyecto {

	public static void iniciarDialog(int bottonSeleccionado, int filaSeleccionada) throws SQLException {

		if (bottonSeleccionado == 1) {
			new view.DiaDetProyecto();
			view.DiaDetProyecto.textID.setText(controller.ContrProyecto.obtenID().toString());
			view.DiaDetProyecto.btnGuardarNuevoProyecto.setVisible(true);
			view.DiaDetProyecto.btnGuardarCambios.setVisible(false);
			view.DiaDetProyecto.btnOK.setVisible(false);
		}

		if (bottonSeleccionado == 2) {

			if (filaSeleccionada >= 0) {
				new view.DiaDetProyecto();
			}
			ejecutarSentenciaDeRelleno(filaSeleccionada);
			view.DiaDetProyecto.btnGuardarNuevoProyecto.setVisible(false);
			view.DiaDetProyecto.btnGuardarCambios.setVisible(true);
			view.DiaDetProyecto.btnOK.setVisible(false);
		}

		if (bottonSeleccionado == 3) {
			new view.DiaDetProyecto();
			ejecutarSentenciaDeRelleno(filaSeleccionada);
			view.DiaDetProyecto.textNombre.setEditable(false);
			view.DiaDetProyecto.textFechaInicio.setEditable(false);
			view.DiaDetProyecto.textFechaFin.setEditable(false);
			view.DiaDetProyecto.textPresupuesto.setEditable(false);
			view.DiaDetProyecto.btnGuardarNuevoProyecto.setVisible(false);
			view.DiaDetProyecto.btnGuardarCambios.setVisible(false);
			view.DiaDetProyecto.btnOK.setVisible(true);
		}
	}

	public static void ejecutarSentenciaDeRelleno(int filaSeleccionada) {

		try {
			String strSQL = "SELECT * FROM ARProyecto WHERE ID_Proyecto =" + Integer.toString(filaSeleccionada);
			CachedRowSet resultado = logic.LogicProyecto.consultaGenerica(strSQL);
			@SuppressWarnings("unchecked")
			ArrayList<Proyecto> p = util.Gui.anadirEnLista(resultado);
			rellenarTabla(p, filaSeleccionada);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void rellenarTabla(ArrayList<Proyecto> p, int filaSeleccionada) {

		if (filaSeleccionada >= 0) {
			view.DiaDetProyecto.textID.setText(Integer.toString(p.get(0).getId()));
			view.DiaDetProyecto.textNombre.setText(p.get(0).getNombre());
			view.DiaDetProyecto.textFechaInicio.setText(Integer.toString(p.get(0).getFchInicio()));
			view.DiaDetProyecto.textFechaFin.setText(Integer.toString(p.get(0).getFchFin()));
			view.DiaDetProyecto.textPresupuesto.setText(Integer.toString(p.get(0).getPresupuesto()));
		}
	}

}
