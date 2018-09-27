package controller;

import javax.swing.JOptionPane;

public class ContrPrincipal {

	/**
	 * CONTROLADOR ABRIR FRAME PRINCIPAL
	 * 
	 * @description: Abrir frame principal
	 * @author AROMERO
	 */
	public static void inicioApp() {
		new view.FrmPrincipal();
	}

	/**
	 * CONTROLADOR PARA SHOW DIALOG PARA SALIR DEL PGRAMA.
	 * @author AROMERO
	 * @since 2.0
	 */
	public static void quieresSalir() {
		//new view.DiaSalir();
		int result = JOptionPane.showConfirmDialog(null, "QUIERES SALIR TOTALMENTE DEL PROGRAMA?", "SALIR", JOptionPane.YES_NO_OPTION);
		System.out.println(result);
		if (result == 0) {
			System.exit(0);
		}
	}

	/**
	 * CONTROLADOR ABRIR CONTROLADOR DE INICIAR PROYECTOS
	 * @author AROMERO
	 */
	public static void opcProyectos() {
		controller.ContrProyecto.inicioProyecto();
	}

	/**
	 * CONTROLADOR ABRIR CONTROLADOR DE INICIAR TRABJADOR.
	 * @author AROMERO
	 */
	public static void opcTrabajadores() {
		controller.ContrTrabajador.inicioTrabajador();
	}

	/**
	 * CONTROLADOR ABRIR CONTROLADOR DE INICIAR EQUIPO.
	 * @author AROMERO
	 */
	public static void opcEquipos() {
		controller.ContrEquipo.inicioEquipo();
	}



}