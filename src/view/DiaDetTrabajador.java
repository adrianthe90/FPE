package view;

import javax.swing.JLabel;
import javax.swing.JTextField;

import pojo.Trabajador;

import javax.swing.JDialog;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

public class DiaDetTrabajador extends JDialog {

	private static final long serialVersionUID = 1L;
	public static JTextField textIDTr;
	public static JTextField textDNItr;
	public static JTextField textNombre;
	public static JTextField textApellidos;
	public static JTextField textGenero;
	public static JButton btnGuardarNuevo;
	public static JButton btnGuardarCambios;
	public static JButton btnOK;

	public DiaDetTrabajador() {
		initialize();
	}

	private void initialize() {
		setTitle("DETALLES TRABAJADOR");
		setResizable(false);
		Dimension pantallaSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((pantallaSize.width - 318) / 2, (pantallaSize.height - 241) / 2, 318, 241);
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		getContentPane().setLayout(null);
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(10, 17, 46, 14);
		getContentPane().add(lblId);
		JLabel lblNombre = new JLabel("NOMBRE:");
		lblNombre.setBounds(10, 73, 46, 14);
		getContentPane().add(lblNombre);
		JLabel lblApellidos = new JLabel("APELLIDOS:");
		lblApellidos.setBounds(10, 98, 58, 14);
		getContentPane().add(lblApellidos);
		JLabel lblGenero = new JLabel("GENERO:");
		lblGenero.setBounds(10, 123, 45, 14);
		getContentPane().add(lblGenero);
		JLabel lblDniTrabajador = new JLabel("DNI TRABAJADOR:");
		lblDniTrabajador.setBounds(10, 45, 92, 14);
		getContentPane().add(lblDniTrabajador);
		textIDTr = new JTextField();
		textIDTr.setEditable(false);
		textIDTr.setBounds(40, 11, 86, 20);
		getContentPane().add(textIDTr);
		textIDTr.setColumns(10);
		textDNItr = new JTextField();
		textDNItr.setColumns(10);
		textDNItr.setBounds(108, 42, 185, 20);
		getContentPane().add(textDNItr);
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(76, 70, 217, 20);
		getContentPane().add(textNombre);
		textApellidos = new JTextField();
		textApellidos.setColumns(10);
		textApellidos.setBounds(76, 95, 217, 20);
		getContentPane().add(textApellidos);
		textGenero = new JTextField();
		textGenero.setColumns(10);
		textGenero.setBounds(65, 120, 129, 20);
		getContentPane().add(textGenero);
		btnGuardarNuevo = new JButton("GUARDAR NUEVO TRABAJADOR");
		btnGuardarNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.ContrTrabajador.estado = 1;
				try {
					controller.ContrTrabajador.guardarProyecto();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				dispose();
			}
		});

		btnGuardarNuevo.setBounds(33, 163, 229, 23);
		getContentPane().add(btnGuardarNuevo);
		btnGuardarCambios = new JButton("GUARDAR CAMBIOS");
		btnGuardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.ContrTrabajador.estado = 2;
				try {
					controller.ContrTrabajador.guardarProyecto();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dispose();
			}
		});
		btnGuardarCambios.setBounds(85, 157, 175, 23);
		getContentPane().add(btnGuardarCambios);
		btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnOK.setBounds(85, 157, 175, 23);
		getContentPane().add(btnOK);
		setVisible(true);
	}
}
