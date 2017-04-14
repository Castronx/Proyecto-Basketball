package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.PortableServer.ServantLocatorOperations;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim;

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
	public Principal() {
		setResizable(false);
		setTitle("National Basketball Asociation");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Jesus\\Pictures\\Nueva carpeta\\descarga.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		dim = super.getToolkit().getScreenSize();
		super.setSize(dim.width, (dim.height-80));
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAdministrador = new JMenu("Administrador");
		menuBar.add(mnAdministrador);
		
		JMenu mnNewMenu = new JMenu("Equipos");
		mnAdministrador.add(mnNewMenu);
		
		JMenuItem mntmRegistrar = new JMenuItem("Registrar");
		mntmRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarEquipo regis = new RegistrarEquipo();
				regis.setVisible(true);
				setLocationRelativeTo(null);
			}
		});
		mnNewMenu.add(mntmRegistrar);
		
		JMenu mnJugadores = new JMenu("Jugadores");
		mnAdministrador.add(mnJugadores);
		
		JMenuItem mntmRegistrar_1 = new JMenuItem("Registrar");
		mntmRegistrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarJugador regist = new RegistrarJugador();
				regist.setVisible(true);
				setLocationRelativeTo(null);
			}
		});
		mnJugadores.add(mntmRegistrar_1);
		
		JMenu mnPartidos = new JMenu("Partidos");
		mnAdministrador.add(mnPartidos);
		
		JMenuItem mntmRegistrar_2 = new JMenuItem("Registrar");
		mntmRegistrar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarPartido regis = new RegistrarPartido();
				regis.setVisible(true);
				regis.setLocationRelativeTo(null);
			}
		});
		mnPartidos.add(mntmRegistrar_2);
		
		JMenuItem mntmJugar = new JMenuItem("Jugar");
		mntmJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Horario hora = new Horario();
				try {
					hora.cargarJuego();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				hora.setVisible(true);
			}
		});
		mnPartidos.add(mntmJugar);
		
		JMenu mnLesiones = new JMenu("Lesiones");
		mnAdministrador.add(mnLesiones);
		
		JMenuItem mntmRegistrar_3 = new JMenuItem("Registrar");
		mntmRegistrar_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarLesion regis = new RegistrarLesion();
				regis.setVisible(true);
				regis.setLocationRelativeTo(null);
			}
		});
		mnLesiones.add(mntmRegistrar_3);
		
		JMenuItem mntmHistorial = new JMenuItem("Historial");
		mnLesiones.add(mntmHistorial);
	}
}
