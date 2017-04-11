package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logical.Nba;
import logical.Player;
import sun.print.resources.serviceui;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Principal extends JFrame {

	private static final long serialVersionUID = -8951357698602046624L;
	private JPanel contentPane;
	private Dimension dim;
	public Nba lig;
	private Player play;
	private boolean hayequipo=false;
	private String usur;
	private boolean change;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nba lig = new Nba();
					Principal frame = new Principal(lig);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Principal(Nba lig) {
		setTitle("NBA");
		this.lig = lig;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Administrador");
		menuBar.add(mnNewMenu);
		
		JMenu mnHoteles = new JMenu("Equipos");
		mnNewMenu.add(mnHoteles);
		
		JMenuItem mntmRegistrar = new JMenuItem("Registrar");
		mntmRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					RegistrarEquipo regequi = new RegistrarEquipo();
					regequi.setVisible(true);
			}
		});
		mnHoteles.add(mntmRegistrar);
		
		JMenu mnUsuarios = new JMenu("Jugadores");
		mnNewMenu.add(mnUsuarios);
		
		JMenuItem mntmListado = new JMenuItem("Registrar");
		mntmListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hayequipo==true){
				RegistrarJugador registro = new RegistrarJugador();
				registro.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "Debe registrar un equipo antes de registrar un jugador.", null,JOptionPane.INFORMATION_MESSAGE, null);
				}
			}
		});
		mnUsuarios.add(mntmListado);
		
		JMenu mnReservaciones = new JMenu("Lesiones");
		mnNewMenu.add(mnReservaciones);
		
		JMenuItem mntmRealizar = new JMenuItem("Registrar");
		mntmRealizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hayequipo==true){
					RegistrarLesion registro = new RegistrarLesion();
					registro.setVisible(true);
				setLocationRelativeTo(null);
			}else{
				JOptionPane.showMessageDialog(null, "Debe registrar un jugador antes de registrar una lesión.", null,JOptionPane.INFORMATION_MESSAGE, null);
			}
		}});
		mnReservaciones.add(mntmRealizar);
		
		JMenu mnNewMenu_1 = new JMenu("Partidos");
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem mntmRegistrar_1 = new JMenuItem("Registrar");
		mntmRegistrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarPartido regipart = new RegistrarPartido();
				regipart.setVisible(true);
				setLocationRelativeTo(null);
			}
		});
		mnNewMenu_1.add(mntmRegistrar_1);
		dim = super.getToolkit().getScreenSize();
		super.setSize(dim.width, (dim.height-80));
		this.setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("Iniciar sesi\u00F3n");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//inicioSesion user = new inicioSesion(resort,"",false);
				//user.setVisible(true);
				//hues = user.getUsuario();
			}
		});
		button.setBounds(995, 11, 131, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Inicio sesi\u00F3n (Admin)");

		button_1.setBounds(1136, 11, 155, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Registrarse");
	
		
		button_2.setBounds(995, 82, 105, 23);
		contentPane.add(button_2);
		
		JButton btnCerrarSesin = new JButton("Cerrar sesi\u00F3n");

		btnCerrarSesin.setBounds(995, 45, 131, 23);
		contentPane.add(btnCerrarSesin);
		
		JButton btnCerrarSesinadmin = new JButton("Cerrar sesi\u00F3n (Admin)");
	
		btnCerrarSesinadmin.setBounds(1136, 45, 167, 23);
		contentPane.add(btnCerrarSesinadmin);
		
		JButton btnCambiarContraseaadmin = new JButton("Cambiar contrase\u00F1a (Admin)");
		btnCambiarContraseaadmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//cambiarContraseña cambia = new cambiarContraseña(resort, usur, change);
				//if(iniciodesesionad==true){
				//cambia.setVisible(true);
				setLocationRelativeTo(null);}
				//else{
					//cambia.setVisible(false);
				//}
			//}
		});
		btnCambiarContraseaadmin.setBounds(1136, 82, 214, 23);
		contentPane.add(btnCambiarContraseaadmin);
	}
}
