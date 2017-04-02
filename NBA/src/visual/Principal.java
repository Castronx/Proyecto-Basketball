package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setTitle("NBA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnJuego = new JMenu("Eventos");
		menuBar.add(mnJuego);
		
		JMenuItem mntmRegistrarPartido = new JMenuItem("Registrar Partido");
		mnJuego.add(mntmRegistrarPartido);
		
		JMenuItem mntmVerPartidos = new JMenuItem("Ver Partidos");
		mnJuego.add(mntmVerPartidos);
		
		JMenuItem mntmModificarPartido = new JMenuItem("Modificar Partido");
		mnJuego.add(mntmModificarPartido);
		
		JMenuItem mntmCancelarPartido = new JMenuItem("Cancelar Partido");
		mnJuego.add(mntmCancelarPartido);
		
		JMenu mnGestionEquipo = new JMenu("Gestion Administrativa");
		menuBar.add(mnGestionEquipo);
		
		JMenuItem mntmRegistrarEquipo = new JMenuItem("Registrar Equipo");
		mnGestionEquipo.add(mntmRegistrarEquipo);
		
		JMenuItem mntmRegistrarJugador = new JMenuItem("Registrar Jugador");
		mnGestionEquipo.add(mntmRegistrarJugador);
		
		JMenuItem mntmVerEquipo = new JMenuItem("Ver Equipos");
		mnGestionEquipo.add(mntmVerEquipo);
		
		JMenuItem mntmVerJugadores = new JMenuItem("Ver Jugadores");
		mnGestionEquipo.add(mntmVerJugadores);
		
		JMenu mnEstadisticas = new JMenu("Estadisticas");
		menuBar.add(mnEstadisticas);
		
		JMenuItem mntmVerEstadisticas = new JMenuItem("Ver Estadisticas");
		mnEstadisticas.add(mntmVerEstadisticas);
		
		JMenu mnLesiones = new JMenu("Lesiones");
		menuBar.add(mnLesiones);
		
		JMenuItem mntmInsertar = new JMenuItem("Reportar Lesiones");
		mnLesiones.add(mntmInsertar);
		
		JMenuItem mntmRecordDeLesiones = new JMenuItem("Record de Lesiones");
		mnLesiones.add(mntmRecordDeLesiones);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(1251, 674, 89, 23);
		contentPane.add(btnSalir);
	}
}
