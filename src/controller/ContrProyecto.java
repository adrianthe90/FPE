package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;
import javax.swing.table.DefaultTableModel;

import pojo.Proyecto;

/**
 * CONTROLADOR DE PROYECTO
 * 
 * @author AROMERO
 */
public class ContrProyecto {

	public static List<Proyecto> lstProyecto = new ArrayList<Proyecto>();
	public static int bottonSeleccionado;
	public static int filaSeleccionada;
	public static int estado;

	/**
	 * CONTROLADOR ABRIR FRAME PROYECTO
	 * 
	 * @author AROMERO
	 */
	public static void inicioProyecto() {
		new view.FrmProyectos();
	}

	/**
	 * CONTROLADOR ABRIR NUEVO PROYECTO.
	 *
	 * <p>@description: Abrir dialog para introductir nuevo proyecto. pasa como
	 *               parámetros el botón seleccionado para posteriormente tener un
	 *               botón u otro botón para guardar los cambios. La fila es = 0
	 *               porque no sirve para nada en este caso.</p>
	 * @param: botónSeleccionado
	 *             y filaSeleccinada (desde JTable)
	 * @author AROMERO
	 */
	public static void nuevoProyecto() throws SQLException {
		bottonSeleccionado = 1;
		filaSeleccionada = 0;
		controller.ContrDialogProyecto.iniciarDialog(bottonSeleccionado, filaSeleccionada);
	}

	/**
	 * CONTROLADOR ACTUALIZAR LA TABLA DEL JFRAME DE PROYECTOS.
	 * 
	 * @description: Actualizar la tabla del Jframe de Proyectos. Con un try-catch
	 *               pasamos un string y nos regresa el resultado cacheado de
	 *               realizar la consulta genérica (en la capa lógica de proyecto)
	 *               Con el resultado generamos la tabla y aplicamos el modelo
	 *               creado sobre el Jtable de Proyectos.
	 * @author AROMERO
	 */
	public static void actualizarTabla() {

		try {
			// Recogemos un ResultSet (offline) tras mandar una SQL genérica
			String strSQL = "SELECT * FROM ARProyecto";
			CachedRowSet resultado = logic.LogicProyecto.consultaGenerica(strSQL);
			// Generamos un modelo de JTable y actualizamos la vista
			DefaultTableModel m = util.Gui.generarTabla(resultado);
			view.FrmProyectos.tableProyectos.setModel(m);
		} catch (Exception e) {
		}
	}

	/**
	 * CONTROLADOR GUARDAR PROYECTO.
	 * 
	 * @description: Para guardar el proyecto en la BBDD, primero obtenemos los
	 *               datos de los JtextFields con sus respectivos campos. Parseamos
	 *               los valores que necesitamos de String a Integer y según el
	 *               parámetro estado(es según el botón seleccionado si es grabar
	 *               nuevo proyecto o un proyecto editado) realizamos en la capa
	 *               lógica de proyecto el envío de los parámetros recogidos para
	 *               guardar el proyecto, ya sea nuevo o editado. finalizando con la
	 *               actualización de la tabla @see actualizarTabla();
	 * @author AROMERO
	 */
	public static void guardarProyecto() {
		String id = view.DiaDetProyecto.textID.getText();
		String nombre = view.DiaDetProyecto.textNombre.getText();
		String fechainicio = view.DiaDetProyecto.textFechaInicio.getText();
		String fechafin = view.DiaDetProyecto.textFechaFin.getText();
		String presupuesto = view.DiaDetProyecto.textPresupuesto.getText();
		int enviarID = Integer.parseInt(id);
		int enviarPresupuesto = Integer.parseInt(presupuesto);
		int enviarFechaI = Integer.parseInt(fechainicio);
		int enviarFechaF = Integer.parseInt(fechafin);
		try {
			if (estado == 1) {
				logic.LogicProyecto.guardarNuevoProyecto(enviarID, nombre, enviarFechaI, enviarFechaF,
						enviarPresupuesto);
			}
			if (estado == 2) {
				logic.LogicProyecto.guardarEditadoProyecto(enviarID, nombre, enviarFechaI, enviarFechaF,
						enviarPresupuesto);
			}
			actualizarTabla();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * CONTROLADOR OBTENER ID
	 * 
	 * @description: Obtienes el último ID de la BBDD para crear nuevo proyecto (se
	 *               le suma 1 para su posterior incorporación al JTextField de ID
	 *               (no editable) para su posterior guardado
	 * @param: String
	 * @return: el maxID convertido a string para incoporarlo.
	 * @author AROMERO
	 */
	public static String obtenID() throws SQLException {

		String maxID;
		String strSQL = "SELECT MAX(ID_Proyecto) FROM ARProyecto";
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

	/**
	 * BORRAR PROYECTO
	 * 
	 * @description: Borrar el proyecto seleccionado desde la JTable.
	 * @author AROMERO
	 */
	public static void borrarProyecto() {
		try {
			int selectedRow = view.FrmProyectos.tableProyectos.getSelectedRow() + 1;
			logic.LogicProyecto.borrarProyecto(selectedRow);
			actualizarTabla();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * EDITAR PROYECTO
	 * 
	 * @description: Iniciar el Dialog de Proyectos para cambiar los valores de la
	 *               fila seleccionada.
	 * @author AROMERO
	 */
	public static void editarProyecto() throws SQLException {
		bottonSeleccionado = 2;
		filaSeleccionada = view.FrmProyectos.tableProyectos.getSelectedRow() + 1;
		controller.ContrDialogProyecto.iniciarDialog(bottonSeleccionado, filaSeleccionada);
	}

	/**
	 * INFO PROYECTO
	 * 
	 * @description: Iniciar el Dialog de Proyectos para ver los valores (sin poder
	 *               cambiar a posteriori) de la fila seleccionada.
	 * @author AROMERO
	 */
	public static void infoProyecto() throws SQLException {
		bottonSeleccionado = 3;
		filaSeleccionada = view.FrmProyectos.tableProyectos.getSelectedRow() + 1;
		controller.ContrDialogProyecto.iniciarDialog(bottonSeleccionado, filaSeleccionada);
	}
}
