package view;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DiaDetProyecto extends JDialog {

	private static final long serialVersionUID = 1L;
	public static JTextField textID;
	public static JTextField textNombre;
	public static JTextField textPresupuesto;
	public static JTextField textFechaInicio;
	public static JTextField textFechaFin;
	public static JButton btnGuardarNuevoProyecto;
	public static JButton btnGuardarCambios;
	public static JButton btnOK;

	public DiaDetProyecto() {

		initialize();
	}

	private void initialize() {
		Dimension pantallaSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((pantallaSize.width - 359) / 2, (pantallaSize.height - 249) / 2, 359, 249);
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		getContentPane().setLayout(null);
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(10, 24, 23, 14);
		getContentPane().add(lblId);

		JLabel lblNombreProyecto = new JLabel("NOMBRE PROYECTO:");
		lblNombreProyecto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreProyecto.setBounds(10, 49, 103, 14);
		getContentPane().add(lblNombreProyecto);

		JLabel lblPresupuesto = new JLabel("PRESUPUESTO:");
		lblPresupuesto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPresupuesto.setBounds(10, 74, 103, 14);
		getContentPane().add(lblPresupuesto);

		JLabel lblFechaInicio = new JLabel("FECHA INICIO:");
		lblFechaInicio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaInicio.setBounds(10, 99, 103, 14);
		getContentPane().add(lblFechaInicio);

		JLabel lblFechaFin = new JLabel("FECHA FIN:");
		lblFechaFin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaFin.setBounds(10, 124, 103, 14);
		getContentPane().add(lblFechaFin);

		btnGuardarNuevoProyecto = new JButton("GUARDAR NUEVO PROYECTO");
		btnGuardarNuevoProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.ContrProyecto.estado = 1;
				controller.ContrProyecto.guardarProyecto();
				dispose();
			}
		});
		btnGuardarNuevoProyecto.setBounds(85, 157, 200, 23);
		// btnGuardarNuevoProyecto.setVisible(false);
		getContentPane().add(btnGuardarNuevoProyecto);
		btnGuardarCambios = new JButton("GUARDAR CAMBIOS");
		btnGuardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.ContrProyecto.estado = 2;
				controller.ContrProyecto.guardarProyecto();
				dispose();
			}
		});
		// btnGuardarCambios.setVisible(false);
		btnGuardarCambios.setBounds(85, 157, 175, 23);
		getContentPane().add(btnGuardarCambios);
		btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		// btnOK.setVisible(false);
		btnOK.setBounds(85, 157, 175, 23);
		getContentPane().add(btnOK);
		textID = new JTextField();
		textID.setEditable(false);
		textID.setBounds(38, 21, 86, 20);
		getContentPane().add(textID);
		textID.setColumns(10);
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(123, 46, 210, 20);
		getContentPane().add(textNombre);
		textPresupuesto = new JTextField();
		textPresupuesto.setColumns(10);
		textPresupuesto.setBounds(123, 71, 210, 20);
		getContentPane().add(textPresupuesto);
		textFechaInicio = new JTextField();
		textFechaInicio.setColumns(10);
		textFechaInicio.setBounds(123, 96, 62, 20);
		getContentPane().add(textFechaInicio);
		textFechaFin = new JTextField();
		textFechaFin.setColumns(10);
		textFechaFin.setBounds(123, 121, 62, 20);
		getContentPane().add(textFechaFin);
		setVisible(true);
	}
}
