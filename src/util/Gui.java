package util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.rowset.CachedRowSet;
import javax.swing.table.DefaultTableModel;

import pojo.Proyecto;
import pojo.Trabajador;

public class Gui {

	public static DefaultTableModel generarTabla(CachedRowSet resultado) throws SQLException {
		DefaultTableModel modelo = new DefaultTableModel();
		ResultSetMetaData md = resultado.getMetaData();
		int totalCampos = md.getColumnCount();
		for (int i = 1; i <= totalCampos; i++) {
			modelo.addColumn(md.getColumnName(i));
		}
		String[] campo = new String[totalCampos];
		while (resultado.next()) {
			for (int i = 1; i <= totalCampos; i++) {
				campo[i - 1] = resultado.getString(i);
			}
			modelo.addRow(campo);
		}
		return modelo;
	}

	public static ArrayList anadirEnLista(CachedRowSet resultado) throws SQLException {
		ResultSet m = resultado.getOriginal();
		while (m.next()) {
			int id = m.getInt("ID_Proyecto");
			String nombre = m.getString("Nombre");
			int fechaI = m.getInt("Fecha_Inicio");
			int fechaF = m.getInt("Fecha_Final");
			int presupuesto = m.getInt("Presupuesto");
			Proyecto p = new Proyecto();
			p.setId(id);
			p.setNombre(nombre);
			p.setFchInicio(fechaI);
			p.setFchFin(fechaF);
			p.setPresupuesto(presupuesto);
			controller.ContrProyecto.lstProyecto.add(p);
		}
		return (ArrayList) controller.ContrProyecto.lstProyecto;
	}

	public static ArrayList anadirEnListaTrabajador(CachedRowSet resultado) {
		ResultSet m;
		try {
			m = resultado.getOriginal();
			while (m.next()) {
				int id = m.getInt("ID_Trabajador");
				String dni = m.getString("Dni");
				String nombre = m.getString("Nombre");
				String apellido = m.getString("Apellido");
				String genero = m.getString("Genero");
				Trabajador t = new Trabajador();
				t.setId(id);
				t.setDni(dni);
				t.setNombre(nombre);
				t.setApellidos(apellido);
				t.setGenero(genero);
				controller.ContrTrabajador.lstTrabajdor.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (ArrayList) controller.ContrTrabajador.lstTrabajdor;
	}

	public static String obtenerID(CachedRowSet resultado) throws SQLException {
		ResultSet rs = resultado.getOriginal();
		int id;
		String maxID = "";
		while (rs.next()) {
			id = rs.getInt(1);
			maxID = Integer.toString(id);
		}
		return maxID;
	}

	public static void introducirProyectos(CachedRowSet resultado) {
		try {
			ResultSet m = resultado.getOriginal();
			view.FrmEquipo.comboBox.addItem("SELECCIONA PROYECTO");
			while (m.next()) {
				String nombrePro = m.getString(1);
				view.FrmEquipo.comboBox.addItem(nombrePro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void introducirTrabajadorDialog(CachedRowSet resultado) {
		try {
			ResultSet m = resultado.getOriginal();
			view.DiaDetEquipo.comboBoxT.addItem("SELECCIONA TRABAJADOR");
			while (m.next()) {
				String nombreTra = m.getString(1);
				view.DiaDetEquipo.comboBoxT.addItem(nombreTra);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void introducirCargoDialog(CachedRowSet resultado) {
		try {
			ResultSet m = resultado.getOriginal();
			view.DiaDetEquipo.comboBoxC.addItem("SELECCIONA CARGO");
			while (m.next()) {
				String nombreCar = m.getString(1);
				view.DiaDetEquipo.comboBoxC.addItem(nombreCar);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void obtenerNombreProyecto(CachedRowSet resultado) throws SQLException {
		ResultSet m = resultado.getOriginal();
		while (m.next()) {
			view.DiaDetEquipo.textProy.setText(m.getString(1));
		}
	}

	public static void obtenerIDProyecto(CachedRowSet resultado) throws SQLException {
		ResultSet m = resultado.getOriginal();
				while (m.next()) {
					int a = m.getInt(1)+1;
					String b = Integer.toString(a);
					view.DiaDetEquipo.textIDEquipo.setText(b);
		}
				view.DiaDetEquipo.textIDEquipo.setEditable(false);
	}
	public static void obtenerIDProyecto1(CachedRowSet resultado) throws SQLException {
		ResultSet m = resultado.getOriginal();
				while (m.next()) {
					int a = m.getInt(1);
					String b = Integer.toString(a);
					view.DiaDetEquipo.textIDEquipo.setText(b);
		}
				view.DiaDetEquipo.textIDEquipo.setEditable(false);
	}
}
