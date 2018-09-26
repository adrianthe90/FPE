package controller;

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
	 * CONTROLADOR ABRIR DIALOG PARA SALIR DEFINITIVAMENTE DEL PROGRAMA.
	 * @author AROMERO
	 */
	public static void quieresSalir() {
		new view.DiaSalir();
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