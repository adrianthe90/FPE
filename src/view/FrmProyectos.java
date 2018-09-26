package view;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class FrmProyectos extends JFrame {

	private static final long serialVersionUID = 1L;
	public static JTable tableProyectos;

	public FrmProyectos() {

		initialize();
		controller.ContrProyecto.actualizarTabla();
		setVisible(true);

	}

	private void initialize() {

		setResizable(false);
		Dimension pantallaSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((pantallaSize.width - 450) / 2, (pantallaSize.height - 300) / 2, 450, 300);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		getContentPane().setLayout(null);

		JLabel lblProyectos = new JLabel("Proyectos:");
		lblProyectos.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblProyectos.setBounds(10, 19, 137, 32);
		getContentPane().add(lblProyectos);

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					controller.ContrProyecto.nuevoProyecto();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNuevo.setBounds(20, 225, 89, 23);
		getContentPane().add(btnNuevo);

		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.ContrProyecto.borrarProyecto();
			}
		});
		btnBorrar.setBounds(136, 225, 89, 23);
		getContentPane().add(btnBorrar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.ContrProyecto.estado = 2;
				
				try {
					controller.ContrProyecto.editarProyecto();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnEditar.setBounds(255, 225, 89, 23);
		getContentPane().add(btnEditar);

		JButton btnInfo = new JButton("Info");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.ContrProyecto.estado = 3;
				
				try {
					controller.ContrProyecto.infoProyecto();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnInfo.setBounds(354, 225, 70, 23);
		getContentPane().add(btnInfo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 414, 152);
		getContentPane().add(scrollPane);

		tableProyectos = new JTable();
		tableProyectos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPane.setViewportView(tableProyectos);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Usuario\\ARL ECLIPSE\\AplicacionFinal\\Img\\logo-proyecto.png"));
		lblNewLabel.setBounds(170, 0, 254, 93);
		getContentPane().add(lblNewLabel);

		setVisible(true);
	}
}
