package view;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class FrmEquipo extends JFrame {

	private static final long serialVersionUID = 1L;

	public static JTable tableEquipo;
	public static JComboBox comboBox;

	public FrmEquipo() throws SQLException {
		initialize();
		controller.ContrEquipo.rellenarJcombox();
		setVisible(true);
	}

	private void initialize() {

		setResizable(false);
		setTitle("GESTION EQUIPO");
		Dimension pantallaSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((pantallaSize.width - 450) / 2, (pantallaSize.height - 300) / 2, 450, 300);

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblEquipos = new JLabel("EQUIPOS:");
		lblEquipos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEquipos.setBounds(10, 11, 124, 25);
		getContentPane().add(lblEquipos);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 34, 192, 2);
		getContentPane().add(separator);

		JLabel lblProyecto = new JLabel("PROYECTO: ");
		lblProyecto.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProyecto.setBounds(68, 47, 99, 25);
		getContentPane().add(lblProyecto);

		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.ContrEquipo.actualizarTabla();
			}
		});
		comboBox.setBounds(159, 47, 217, 25);
		getContentPane().add(comboBox);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 82, 424, 139);
		getContentPane().add(scrollPane);

		tableEquipo = new JTable();
		scrollPane.setViewportView(tableEquipo);

		JButton btnAadir = new JButton("A\u00D1ADIR");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				controller.ContrEquipo.bottonSeleccionado = 1;
				try {
					controller.ContrEquipo.nuevoEquipo();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnAadir.setBounds(10, 232, 89, 23);
		getContentPane().add(btnAadir);

		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controller.ContrEquipo.borrarEqupo();
				
			}
		});
		btnEliminar.setBounds(172, 232, 89, 23);
		getContentPane().add(btnEliminar);

		JButton btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controller.ContrEquipo.bottonSeleccionado = 2;
				
				try {
					controller.ContrEquipo.editarEquipo();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnEditar.setBounds(345, 232, 89, 23);
		getContentPane().add(btnEditar);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Usuario\\ARL ECLIPSE\\AplicacionFinal\\Img\\logo-proyecto.png"));
		lblNewLabel.setBounds(190, -25, 254, 131);
		getContentPane().add(lblNewLabel);
		setVisible(true);
	}
}
