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
	private boolean iniciodesesionad=false;
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
					RegistrarEquipo reghotel = new RegistrarEquipo();
					reghotel.setVisible(true);
			}
		});
		mnHoteles.add(mntmRegistrar);
		
		JMenu mnUsuarios = new JMenu("Jugadores");
		mnNewMenu.add(mnUsuarios);
		
		JMenuItem mntmListado = new JMenuItem("Registrar");
		mntmListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(iniciodesesionad==true){
					ListadoUsuarios lista = new ListadoUsuarios(resort);
					lista.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "Debe registrar un equipo antes de registrar un jugador.", null,JOptionPane.INFORMATION_MESSAGE, null);
				}
			}
		});
		mnUsuarios.add(mntmListado);
		
		JMenu mnReservaciones = new JMenu("Reservaciones");
		mnNewMenu.add(mnReservaciones);
		
		JMenuItem mntmRealizar = new JMenuItem("Realizar");
		mntmRealizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(iniciodesesionad==true){
				hacerReservacion reservacion = new hacerReservacion(resort, hues);
				reservacion.setVisible(true);
				setLocationRelativeTo(null);
			}else{
				JOptionPane.showMessageDialog(null, "Inicio de sesión (admin) requerido.", null,JOptionPane.INFORMATION_MESSAGE, null);
			}
		}});
		mnReservaciones.add(mntmRealizar);
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
				inicioSesion user = new inicioSesion(resort,"",false);
				user.setVisible(true);
				hues = user.getUsuario();
			}
		});
		button.setBounds(995, 11, 131, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Inicio sesi\u00F3n (Admin)");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicioSesion sesion = new inicioSesion(resort, "", true);
				sesion.setVisible(true);
				if(sesion.admin()==true){
				iniciodesesionad=true;
				}
			}
		});
		button_1.setBounds(1136, 11, 155, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Registrarse");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarUsuario registro = new RegistrarUsuario(resort);
				registro.setVisible(true);
			}
		});
		button_2.setBounds(995, 82, 105, 23);
		contentPane.add(button_2);
		
		JButton btnCerrarSesin = new JButton("Cerrar sesi\u00F3n");
		btnCerrarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hues = null;
				if(iniciodesesionad==true){
					JOptionPane.showMessageDialog(null, "Se ha cerrado sesión.", null,JOptionPane.INFORMATION_MESSAGE, null);
				}else if(iniciodesesionad==false){
					JOptionPane.showMessageDialog(null, "No hay sesión activa.", null, JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnCerrarSesin.setBounds(995, 45, 131, 23);
		contentPane.add(btnCerrarSesin);
		
		JButton btnCerrarSesinadmin = new JButton("Cerrar sesi\u00F3n (Admin)");
		btnCerrarSesinadmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(iniciodesesionad==true){
					JOptionPane.showMessageDialog(null, "Usted ha Cerrado Sesión.", null,JOptionPane.INFORMATION_MESSAGE, null);
				}else if(iniciodesesionad==false){
					JOptionPane.showMessageDialog(null, "No hay sesión activa.", null,JOptionPane.INFORMATION_MESSAGE, null);
				}
				iniciodesesionad=false;
			}
		});
		btnCerrarSesinadmin.setBounds(1136, 45, 167, 23);
		contentPane.add(btnCerrarSesinadmin);
		
		JButton btnCambiarContraseaadmin = new JButton("Cambiar contrase\u00F1a (Admin)");
		btnCambiarContraseaadmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarContraseña cambia = new cambiarContraseña(resort, usur, change);
				if(iniciodesesionad==true){
				cambia.setVisible(true);
				setLocationRelativeTo(null);}
				else{
					cambia.setVisible(false);
				}
			}
		});
		btnCambiarContraseaadmin.setBounds(1136, 82, 214, 23);
		contentPane.add(btnCambiarContraseaadmin);
	}
}
