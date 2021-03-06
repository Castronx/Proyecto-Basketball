package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.PortableServer.ServantLocatorOperations;


import logical.Nba;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim;
	private static Nba nb;
	File f = new File("./Datos.dat");

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal(nb);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Principal(final Nba nb) {
		setResizable(false);
		setTitle("National Basketball Asociation");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Jesus\\Pictures\\Nueva carpeta\\descarga.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		Nba.getInstances().cargarNba(nb);
		dim = super.getToolkit().getScreenSize();
		super.setSize(dim.width, (dim.height-80));
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Principal.class.getResource("/images/maxresdefault (1).jpg")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistrarEquipo registrar = new RegistrarEquipo();
				registrar.setVisible(true);
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(147, 103, 163, 115);
		contentPane.add(btnNewButton);
		
		JButton btnPlayer = new JButton("Player");
		btnPlayer.setIcon(new ImageIcon(Principal.class.getResource("/images/MTLML8KBc.jpg")));
		btnPlayer.setVisible(true);
		btnPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistrarJugador registrar = new RegistrarJugador();
				registrar.setVisible(true);
			}
		});
		btnPlayer.setForeground(Color.BLACK);
		btnPlayer.setBounds(147, 270, 163, 115);
		contentPane.add(btnPlayer);
		
		JButton btnGame = new JButton("");
		btnGame.setIcon(new ImageIcon(Principal.class.getResource("/images/images (1).png")));
		btnGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OptionGame opc = new OptionGame();
				opc.setVisible(true);
				opc.setLocationRelativeTo(null);
			}
		});
		btnGame.setForeground(Color.BLACK);
		btnGame.setBounds(147, 432, 163, 115);
		contentPane.add(btnGame);
		
		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(1241, 593, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Juego");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(147, 568, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Jugador");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(147, 396, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEquipo.setForeground(Color.RED);
		lblEquipo.setBounds(147, 234, 46, 14);
		contentPane.add(lblEquipo);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/images/michael-jordan-chicago-bulls-basketball-nba.jpg")));
		lblNewLabel.setBounds(10, 11, 1340, 616);
		contentPane.add(lblNewLabel);
		
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
				regist.setLocationRelativeTo(null);
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
		mntmHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HistorialLesion histole = new HistorialLesion();
				histole.setVisible(true);
				histole.setLocationRelativeTo(null);
			}
		});
		mnLesiones.add(mntmHistorial);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mnAdministrador.add(mntmSalir);
	
	
	addWindowListener(new WindowAdapter()
    {
        @Override
        public void windowClosing(WindowEvent e)
        {	
            Nba.getInstances().guardarNba(Nba.getInstances());;
            e.getWindow().dispose();
        }
    });
}
}
