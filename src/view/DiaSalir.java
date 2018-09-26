package view;

import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DiaSalir extends JDialog {

	private static final long serialVersionUID = 1L;

	public DiaSalir() {
		initialize();
		setVisible(true);
	}

	private void initialize() {

		setModal(true);
		setTitle("Quieres Salir?");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Img\\logo12.png"));
		Dimension pantallaSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((pantallaSize.width - 314) / 2, (pantallaSize.height - 168) / 2, 314, 168);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblseguroQueQuieres = new JLabel("\u00BFSeguro que quieres SALIR?");
		lblseguroQueQuieres.setHorizontalAlignment(SwingConstants.CENTER);
		lblseguroQueQuieres.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblseguroQueQuieres.setBounds(0, 23, 301, 25);
		getContentPane().add(lblseguroQueQuieres);

		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSalir.setBounds(29, 74, 115, 23);
		getContentPane().add(btnSalir);

		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancelar.setBounds(154, 74, 119, 23);
		getContentPane().add(btnCancelar);
	}
}