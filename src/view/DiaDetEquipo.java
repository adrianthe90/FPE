package view;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class DiaDetEquipo extends JDialog {

	private static final long serialVersionUID = 1L;
	public static JTextField textIDEquipo;
	public static JButton btnNewEquipo;
	public static JButton btnGuardarCambios;
	public static JComboBox comboBoxT;
	public static JComboBox comboBoxC;
	public static JTextField textProy;

	public DiaDetEquipo() {
		initialize();
	}

	private void initialize() {
		//DIMENSIONADO DE LA VENTANA: 
		setTitle("A\u00D1ADIR EQUIPO");
		Dimension pantallaSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((pantallaSize.width - 382) / 2, (pantallaSize.height - 329) / 2, 382, 329);
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		getContentPane().setLayout(null);
		// ICONO DE FONDO DE VENTANA:
		JLabel lblIdEquipo = new JLabel("ID EQUIPO:");
		lblIdEquipo.setBounds(10, 11, 76, 14);
		getContentPane().add(lblIdEquipo);
		//BOTONES.....
		textIDEquipo = new JTextField();
		textIDEquipo.setFont(new Font("Tahoma", Font.BOLD, 11));
		textIDEquipo.setBounds(72, 8, 45, 20);
		getContentPane().add(textIDEquipo);
		textIDEquipo.setColumns(10);

		JLabel lblProyecto = new JLabel("PROYECTO");
		lblProyecto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProyecto.setBounds(10, 75, 76, 19);
		getContentPane().add(lblProyecto);

		JLabel lblTrabajador = new JLabel("TRABAJADOR");
		lblTrabajador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTrabajador.setBounds(10, 111, 91, 19);
		getContentPane().add(lblTrabajador);

		comboBoxT = new JComboBox();
		comboBoxT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBoxT.setBounds(106, 105, 251, 25);
		getContentPane().add(comboBoxT);

		JLabel lblCargo = new JLabel("CARGO");
		lblCargo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCargo.setBounds(10, 147, 48, 19);
		getContentPane().add(lblCargo);

		comboBoxC = new JComboBox();
		comboBoxC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBoxC.setBounds(106, 141, 251, 25);
		getContentPane().add(comboBoxC);

		btnNewEquipo = new JButton("GUARDAR NUEVO EQUIPO");
		btnNewEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				controller.ContrEquipo.bottonSeleccionado = 1;
				controller.ContrEquipo.guardarNuevoEquipo();
				dispose();

			}
		});
		btnNewEquipo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewEquipo.setBounds(72, 207, 229, 57);
		getContentPane().add(btnNewEquipo);

		btnGuardarCambios = new JButton("GUARDAR CAMBIOS");
		btnGuardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.ContrEquipo.bottonSeleccionado = 2;
				controller.ContrEquipo.guardarNuevoEquipo();
				dispose();
			}
		});
		btnGuardarCambios.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGuardarCambios.setBounds(72, 207, 229, 57);
		getContentPane().add(btnGuardarCambios);

		textProy = new JTextField();
		textProy.setFont(new Font("Tahoma", Font.BOLD, 15));
		textProy.setEditable(false);
		textProy.setBounds(106, 69, 251, 25);
		getContentPane().add(textProy);
		textProy.setColumns(10);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Usuario\\ARL ECLIPSE\\AplicacionFinal\\Img\\logo-proyecto.png"));
		lblNewLabel.setBounds(111, -24, 254, 131);
		getContentPane().add(lblNewLabel);
		//VISIBLE...
		setVisible(true);
	}
}
