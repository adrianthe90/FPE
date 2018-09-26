package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.URL;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class FrmPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JMenuItem mntmAyuda;

	public FrmPrincipal() {
		setTitle("APP ARL");
		Dimension pantallaSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((pantallaSize.width - 450) / 2, (pantallaSize.height - 300) / 2, 450, 300);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				controller.ContrPrincipal.quieresSalir();
			}
		});
		getContentPane().setLayout(null);
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("Img\\logo-proyecto.png"));
		label.setBounds(92, 66, 254, 131);
		getContentPane().add(label);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu mnNewMenu = new JMenu("BASE");
		menuBar.add(mnNewMenu);
		JMenuItem mntmProyectos = new JMenuItem("PROYECTOS");
		mntmProyectos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.ContrPrincipal.opcProyectos();
			}
		});
		mnNewMenu.add(mntmProyectos);
		JMenuItem mntmTrabajadores = new JMenuItem("TRABAJADORES");
		mntmTrabajadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.ContrPrincipal.opcTrabajadores();
			}
		});
		mnNewMenu.add(mntmTrabajadores);
		JMenu mnGestion = new JMenu("GESTION");
		menuBar.add(mnGestion);
		JMenuItem mntmEquipo = new JMenuItem("EQUIPO");
		mntmEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.ContrPrincipal.opcEquipos();
			}
		});
		mnGestion.add(mntmEquipo);

		JMenu mnAyuda = new JMenu("AYUDA");
		menuBar.add(mnAyuda);

		mntmAyuda = new JMenuItem("AYUDA");
		mnAyuda.add(mntmAyuda);
		cargarAyuda();
		setVisible(true);
	}

	protected void cargarAyuda() {

		try {
			// Carga el fichero de ayuda
			File fichero = new File("proyecto/help/help.hs");
			URL hsURL = fichero.toURI().toURL();

			// Crea el HelpSet y el HelpBroker
			HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
			HelpBroker hb = helpset.createHelpBroker();

			// mntmAyuda en el JMenuitem
			hb.enableHelpOnButton(mntmAyuda, "manual", helpset);
		} catch (Exception e) {
			// logger.error("Error al cargar la ayuda: " + e);
		}
	}

}
