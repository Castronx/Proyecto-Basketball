package visual;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.awt.event.ActionEvent;

import javax.swing.JSeparator;
import javax.swing.border.TitledBorder;

import logical.Nba;
import logical.Performance;

import javax.swing.UIManager;



import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class JugarPartido extends JDialog implements Serializable{
	
	private final JPanel contentPanel = new JPanel();
	public JTextField equipovisitante;
	public JTextField equipolocal;
	public JTextField jugador1;
	public JTextField jugador2;
	private JTextField jugador4;
	private JTextField jugador3;
	private JTextField jugador6;
	private JTextField jugador5;
	private JTextField jugador8;
	private JTextField jugador7;
	private JTextField jugador10;
	private JTextField jugador9;
	private JTextField jugador12;
	private JTextField jugador11;
	private JPanel jugadoreslocales;
	public JTextField j1l;
	public JTextField j2l;
	private JTextField j4l;
	private JTextField j3l;
	private JTextField j6l;
	private JTextField j5l;
	private JTextField j8l;
	private JTextField j7l;
	private JTextField j10l;
	private JTextField j9l;
	private JTextField j12l;
	private JTextField j11l;
	private JPanel dosjv;
	private JPanel tljv;
	private JPanel tresjv;
	private JPanel dospuntoslocal;
	private JPanel tiroslibreslocal;
	private JPanel treslocal;
	private JTextField faltaslocal;
	private JTextField faltasV;
	private JTextField puntosV;
	private JTextField puntosequipolocal;
	private JTextField dosj1;
	private JTextField dosj2;
	private JTextField dosj4;
	private JTextField dosj3;
	private JTextField dosj6;
	private JTextField dosj5;
	private JTextField dosj8;
	private JTextField dosj7;
	private JTextField dosj10;
	private JTextField dosj9;
	private JTextField dosj12;
	private JTextField dosj11;
	private JTextField tlj1;
	private JTextField tlj2;
	private JTextField tlj3;
	private JTextField tlj4;
	private JTextField tlj5;
	private JTextField tlj6;
	private JTextField tlj7;
	private JTextField tlj8;
	private JTextField tlj9;
	private JTextField tlj10;
	private JTextField tlj11;
	private JTextField tlj12;
	private JTextField tresj1;
	private JTextField tresj2;
	private JTextField tresj3;
	private JTextField tresj4;
	private JTextField tresj5;
	private JTextField tresj6;
	private JTextField tresj7;
	private JTextField tresj8;
	private JTextField tresj9;
	private JTextField tresj10;
	private JTextField tresj11;
	private JTextField tresj12;

	private JTextField dosjl1;
	private JTextField dosjl2;
	private JTextField dosjl3;
	private JTextField dosjl4;
	private JTextField dosjl5;
	private JTextField dosjl6;
	private JTextField dosjl7;
	private JTextField dosjl8;
	private JTextField dosjl9;
	private JTextField dosjl10;
	private JTextField dosjl11;
	private JTextField dosjl12;
	private JTextField tllj1;
	private JTextField tllj2;
	private JTextField tllj3;
	private JTextField tjll4;
	private JTextField tllj5;
	private JTextField tllj6;
	private JTextField tllj7;
	private JTextField tllj8;
	private JTextField tllj9;
	private JTextField tllj10;
	private JTextField tllj11;
	private JTextField tllj12;
	private JTextField treslj1;
	private JTextField treslj2;
	private JTextField treslj3;
	private JTextField treslj4;
	private JTextField treslj5;
	private JTextField treslj6;
	private JTextField treslj7;
	private JTextField treslj8;
	private JTextField treslj9;
	private JTextField treslj10;
	private JTextField treslj11;
	private JTextField treslj12;
	
	
	private JButton guardar;
	
	int puntosvis;
	
	int dosvis1;
	int dosvis2;
	int dosvis3;
	int dosvis4;
	int dosvis5;
	int dosvis6;
	int dosvis7;
	int dosvis8;
	int dosvis9;
	int dosvis10;
	int dosvis11;
	int dosvis12;
	
	int tirolv1;
	int tirolv2;
	int tirolv3;
	int tirolv4;
	int tirolv5;
	int tirolv6;
	int tirolv7;
	int tirolv8;
	int tirolv9;
	int tirolv10;
	int tirolv11;
	int tirolv12;
	
	int tresvis1;
	int tresvis2;
	int tresvis3; 
	int tresvis4; 
	int tresvis5; 
	int tresvis6; 
	int tresvis7; 
	int tresvis8; 
	int tresvis9; 
	int tresvis10; 
	int tresvis11; 
	int tresvis12; 
	
	int puntoslocal;
	
	int doslocal1;
	int doslocal2;
	int doslocal3;
	int doslocal4;
	int doslocal5;
	int doslocal6;
	int doslocal7;
	int doslocal8;
	int doslocal9;
	int doslocal10;
	int doslocal11;
	int doslocal12;
	
	int tiroll1;
	int tiroll2;
	int tiroll3;
	int tiroll4;
	int tiroll5;
	int tiroll6;
	int tiroll7;
	int tiroll8;
	int tiroll9;
	int tiroll10;
	int tiroll11;
	int tiroll12;
	
	int treslocal1;
	int treslocal2;
	int treslocal3;
	int treslocal4;
	int treslocal5;
	int treslocal6;
	int treslocal7;
	int treslocal8;
	int treslocal9;
	int treslocal10;
	int treslocal11;
	int treslocal12;
	
	RegistrarPartido insertarJuego;
	int faltasLocales, faltasVisitante;
	Horario schedule;
	private JLabel lblNewLabel_1;
	
	public JugarPartido() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Jesus\\Pictures\\Nueva carpeta\\play_game_video-512.png"));
		schedule = new Horario();
		setModal(true);
		insertarJuego = new RegistrarPartido();
		
		setTitle("Live");
		setBounds(50, 10, 1212, 640);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
		}
		JSeparator separator = new JSeparator(SwingConstants.VERTICAL);
		separator.setBounds(532, 9, 2, 445);
		contentPanel.add(separator);
		{
			JLabel lblAwayTeam = new JLabel("Equipo visitante:");
			lblAwayTeam.setBounds(10, 9, 117, 27);
			contentPanel.add(lblAwayTeam);
		}
		equipovisitante = new JTextField();
		equipovisitante.setHorizontalAlignment(SwingConstants.CENTER);
		equipovisitante.setFont(new Font("Tahoma", Font.BOLD, 14));
		equipovisitante.setEditable(false);
		equipovisitante.setBounds(137, 12, 200, 20);
		contentPanel.add(equipovisitante);
		equipovisitante.setColumns(10);
		{
			equipolocal = new JTextField();
			equipolocal.setHorizontalAlignment(SwingConstants.CENTER);
			equipolocal.setFont(new Font("Tahoma", Font.BOLD, 14));
			equipolocal.setEditable(false);
			equipolocal.setColumns(10);
			equipolocal.setBounds(734, 12, 200, 20);
			contentPanel.add(equipolocal);
		}
		{
			JLabel lblHomeTeam = new JLabel("Equipo local:");
			lblHomeTeam.setBounds(649, 9, 75, 27);
			contentPanel.add(lblHomeTeam);
		}
		{
			JPanel jugadoresVis = new JPanel();
			jugadoresVis.setBorder(new TitledBorder(null, "Jugadores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			jugadoresVis.setToolTipText("");
			jugadoresVis.setBounds(10, 39, 165, 403);
			contentPanel.add(jugadoresVis);
			jugadoresVis.setLayout(null);
			{
				jugador1 = new JTextField();
				jugador1.setEditable(false);
				jugador1.setBounds(10, 31, 145, 20);
				jugadoresVis.add(jugador1);
				jugador1.setColumns(10);
			}
			{
				jugador2 = new JTextField();
				jugador2.setEditable(false);
				jugador2.setColumns(10);
				jugador2.setBounds(10, 62, 145, 20);
				jugadoresVis.add(jugador2);
			}
			{
				jugador4 = new JTextField();
				jugador4.setEditable(false);
				jugador4.setColumns(10);
				jugador4.setBounds(10, 124, 145, 20);
				jugadoresVis.add(jugador4);
			}
			{
				jugador3 = new JTextField();
				jugador3.setEditable(false);
				jugador3.setColumns(10);
				jugador3.setBounds(10, 93, 145, 20);
				jugadoresVis.add(jugador3);
			}
			{
				jugador6 = new JTextField();
				jugador6.setEditable(false);
				jugador6.setColumns(10);
				jugador6.setBounds(10, 186, 145, 20);
				jugadoresVis.add(jugador6);
			}
			{
				jugador5 = new JTextField();
				jugador5.setEditable(false);
				jugador5.setColumns(10);
				jugador5.setBounds(10, 155, 145, 20);
				jugadoresVis.add(jugador5);
			}
			{
				jugador8 = new JTextField();
				jugador8.setEditable(false);
				jugador8.setColumns(10);
				jugador8.setBounds(10, 248, 145, 20);
				jugadoresVis.add(jugador8);
			}
			{
				jugador7 = new JTextField();
				jugador7.setEditable(false);
				jugador7.setColumns(10);
				jugador7.setBounds(10, 217, 145, 20);
				jugadoresVis.add(jugador7);
			}
			{
				jugador10 = new JTextField();
				jugador10.setEditable(false);
				jugador10.setColumns(10);
				jugador10.setBounds(10, 310, 145, 20);
				jugadoresVis.add(jugador10);
			}
			{
				jugador9 = new JTextField();
				jugador9.setEditable(false);
				jugador9.setColumns(10);
				jugador9.setBounds(10, 279, 145, 20);
				jugadoresVis.add(jugador9);
			}
			{
				jugador12 = new JTextField();
				jugador12.setEditable(false);
				jugador12.setColumns(10);
				jugador12.setBounds(10, 372, 145, 20);
				jugadoresVis.add(jugador12);
			}
			{
				jugador11 = new JTextField();
				jugador11.setEditable(false);
				jugador11.setColumns(10);
				jugador11.setBounds(10, 341, 145, 20);
				jugadoresVis.add(jugador11);
			}
		}
		{
			jugadoreslocales = new JPanel();
			jugadoreslocales.setLayout(null);
			jugadoreslocales.setToolTipText("");
			jugadoreslocales.setBorder(new TitledBorder(null, "Jugadores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			jugadoreslocales.setBounds(649, 39, 165, 403);
			contentPanel.add(jugadoreslocales);
			{
				j1l = new JTextField();
				j1l.setEditable(false);
				j1l.setColumns(10);
				j1l.setBounds(10, 31, 145, 20);
				jugadoreslocales.add(j1l);
			}
			{
				j2l = new JTextField();
				j2l.setEditable(false);
				j2l.setColumns(10);
				j2l.setBounds(10, 62, 145, 20);
				jugadoreslocales.add(j2l);
			}
			{
				j4l = new JTextField();
				j4l.setEditable(false);
				j4l.setColumns(10);
				j4l.setBounds(10, 124, 145, 20);
				jugadoreslocales.add(j4l);
			}
			{
				j3l = new JTextField();
				j3l.setEditable(false);
				j3l.setColumns(10);
				j3l.setBounds(10, 93, 145, 20);
				jugadoreslocales.add(j3l);
			}
			{
				j6l = new JTextField();
				j6l.setEditable(false);
				j6l.setColumns(10);
				j6l.setBounds(10, 186, 145, 20);
				jugadoreslocales.add(j6l);
			}
			{
				j5l = new JTextField();
				j5l.setEditable(false);
				j5l.setColumns(10);
				j5l.setBounds(10, 155, 145, 20);
				jugadoreslocales.add(j5l);
			}
			{
				j8l = new JTextField();
				j8l.setEditable(false);
				j8l.setColumns(10);
				j8l.setBounds(10, 248, 145, 20);
				jugadoreslocales.add(j8l);
			}
			{
				j7l = new JTextField();
				j7l.setEditable(false);
				j7l.setColumns(10);
				j7l.setBounds(10, 217, 145, 20);
				jugadoreslocales.add(j7l);
			}
			{
				j10l = new JTextField();
				j10l.setEditable(false);
				j10l.setColumns(10);
				j10l.setBounds(10, 310, 145, 20);
				jugadoreslocales.add(j10l);
			}
			{
				j9l = new JTextField();
				j9l.setEditable(false);
				j9l.setColumns(10);
				j9l.setBounds(10, 279, 145, 20);
				jugadoreslocales.add(j9l);
			}
			{
				j12l = new JTextField();
				j12l.setEditable(false);
				j12l.setColumns(10);
				j12l.setBounds(10, 372, 145, 20);
				jugadoreslocales.add(j12l);
			}
			{
				j11l = new JTextField();
				j11l.setEditable(false);
				j11l.setColumns(10);
				j11l.setBounds(10, 341, 145, 20);
				jugadoreslocales.add(j11l);
			}
		}
		{
			dosjv = new JPanel();
			dosjv.setBorder(new TitledBorder(null, "T-2Pts", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			dosjv.setBounds(185, 39, 67, 403);
			contentPanel.add(dosjv);
			dosjv.setLayout(null);
			
			dosj1 = new JTextField();
			dosj1.setHorizontalAlignment(SwingConstants.CENTER);
			dosj1.setBounds(10, 31, 47, 20);
			dosjv.add(dosj1);
			dosj1.setColumns(10);
			
			dosj2 = new JTextField();
			dosj2.setHorizontalAlignment(SwingConstants.CENTER);
			dosj2.setColumns(10);
			dosj2.setBounds(10, 62, 47, 20);
			dosjv.add(dosj2);
			
			dosj3 = new JTextField();
			dosj3.setHorizontalAlignment(SwingConstants.CENTER);
			dosj3.setColumns(10);
			dosj3.setBounds(10, 93, 47, 20);
			dosjv.add(dosj3);
			
			dosj4 = new JTextField();
			dosj4.setHorizontalAlignment(SwingConstants.CENTER);
			dosj4.setColumns(10);
			dosj4.setBounds(10, 124, 47, 20);
			dosjv.add(dosj4);
			
			dosj5 = new JTextField();
			dosj5.setHorizontalAlignment(SwingConstants.CENTER);
			dosj5.setColumns(10);
			dosj5.setBounds(10, 155, 47, 20);
			dosjv.add(dosj5);
			
			dosj6 = new JTextField();
			dosj6.setHorizontalAlignment(SwingConstants.CENTER);
			dosj6.setColumns(10);
			dosj6.setBounds(10, 186, 47, 20);
			dosjv.add(dosj6);
			
			dosj7 = new JTextField();
			dosj7.setHorizontalAlignment(SwingConstants.CENTER);
			dosj7.setColumns(10);
			dosj7.setBounds(10, 217, 47, 20);
			dosjv.add(dosj7);
			
			dosj8 = new JTextField();
			dosj8.setHorizontalAlignment(SwingConstants.CENTER);
			dosj8.setColumns(10);
			dosj8.setBounds(10, 248, 47, 20);
			dosjv.add(dosj8);
			
			dosj9 = new JTextField();
			dosj9.setHorizontalAlignment(SwingConstants.CENTER);
			dosj9.setColumns(10);
			dosj9.setBounds(10, 279, 47, 20);
			dosjv.add(dosj9);
			
			dosj10 = new JTextField();
			dosj10.setHorizontalAlignment(SwingConstants.CENTER);
			dosj10.setColumns(10);
			dosj10.setBounds(10, 310, 47, 20);
			dosjv.add(dosj10);
			
			dosj11 = new JTextField();
			dosj11.setHorizontalAlignment(SwingConstants.CENTER);
			dosj11.setColumns(10);
			dosj11.setBounds(10, 341, 47, 20);
			dosjv.add(dosj11);
			
			dosj12 = new JTextField();
			dosj12.setHorizontalAlignment(SwingConstants.CENTER);
			dosj12.setColumns(10);
			dosj12.setBounds(10, 372, 47, 20);
			dosjv.add(dosj12);
		}
		{
			tljv = new JPanel();
			tljv.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "T-Libres", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			tljv.setBounds(259, 39, 75, 403);
			contentPanel.add(tljv);
			tljv.setLayout(null);
			
			tlj1 = new JTextField();
			tlj1.setHorizontalAlignment(SwingConstants.CENTER);
			tlj1.setColumns(10);
			tlj1.setBounds(10, 31, 47, 20);
			tljv.add(tlj1);
			
			tlj2 = new JTextField();
			tlj2.setHorizontalAlignment(SwingConstants.CENTER);
			tlj2.setColumns(10);
			tlj2.setBounds(10, 62, 47, 20);
			tljv.add(tlj2);
			
			tlj3 = new JTextField();
			tlj3.setHorizontalAlignment(SwingConstants.CENTER);
			tlj3.setColumns(10);
			tlj3.setBounds(10, 93, 47, 20);
			tljv.add(tlj3);
			
			tlj4 = new JTextField();
			tlj4.setHorizontalAlignment(SwingConstants.CENTER);
			tlj4.setColumns(10);
			tlj4.setBounds(10, 124, 47, 20);
			tljv.add(tlj4);
			
			tlj5 = new JTextField();
			tlj5.setHorizontalAlignment(SwingConstants.CENTER);
			tlj5.setColumns(10);
			tlj5.setBounds(10, 155, 47, 20);
			tljv.add(tlj5);
			
			tlj6 = new JTextField();
			tlj6.setHorizontalAlignment(SwingConstants.CENTER);
			tlj6.setColumns(10);
			tlj6.setBounds(10, 186, 47, 20);
			tljv.add(tlj6);
			
			tlj7 = new JTextField();
			tlj7.setHorizontalAlignment(SwingConstants.CENTER);
			tlj7.setColumns(10);
			tlj7.setBounds(10, 217, 47, 20);
			tljv.add(tlj7);
			
			tlj8 = new JTextField();
			tlj8.setHorizontalAlignment(SwingConstants.CENTER);
			tlj8.setColumns(10);
			tlj8.setBounds(10, 248, 47, 20);
			tljv.add(tlj8);
			
			tlj9 = new JTextField();
			tlj9.setHorizontalAlignment(SwingConstants.CENTER);
			tlj9.setColumns(10);
			tlj9.setBounds(10, 279, 47, 20);
			tljv.add(tlj9);
			
			tlj10 = new JTextField();
			tlj10.setHorizontalAlignment(SwingConstants.CENTER);
			tlj10.setColumns(10);
			tlj10.setBounds(10, 310, 47, 20);
			tljv.add(tlj10);
			
			tlj11 = new JTextField();
			tlj11.setHorizontalAlignment(SwingConstants.CENTER);
			tlj11.setColumns(10);
			tlj11.setBounds(10, 341, 47, 20);
			tljv.add(tlj11);
			
			tlj12 = new JTextField();
			tlj12.setHorizontalAlignment(SwingConstants.CENTER);
			tlj12.setColumns(10);
			tlj12.setBounds(10, 372, 47, 20);
			tljv.add(tlj12);
		}
		{
			tresjv = new JPanel();
			tresjv.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "T-3Pts", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			tresjv.setBounds(344, 39, 67, 403);
			contentPanel.add(tresjv);
			tresjv.setLayout(null);
			
			tresj1 = new JTextField();
			tresj1.setHorizontalAlignment(SwingConstants.CENTER);
			tresj1.setColumns(10);
			tresj1.setBounds(10, 31, 47, 20);
			tresjv.add(tresj1);
			
			tresj2 = new JTextField();
			tresj2.setHorizontalAlignment(SwingConstants.CENTER);
			tresj2.setColumns(10);
			tresj2.setBounds(10, 62, 47, 20);
			tresjv.add(tresj2);
			
			tresj3 = new JTextField();
			tresj3.setHorizontalAlignment(SwingConstants.CENTER);
			tresj3.setColumns(10);
			tresj3.setBounds(10, 93, 47, 20);
			tresjv.add(tresj3);
			
			tresj4 = new JTextField();
			tresj4.setHorizontalAlignment(SwingConstants.CENTER);
			tresj4.setColumns(10);
			tresj4.setBounds(10, 124, 47, 20);
			tresjv.add(tresj4);
			
			tresj5 = new JTextField();
			tresj5.setHorizontalAlignment(SwingConstants.CENTER);
			tresj5.setColumns(10);
			tresj5.setBounds(10, 155, 47, 20);
			tresjv.add(tresj5);
			
			tresj6 = new JTextField();
			tresj6.setHorizontalAlignment(SwingConstants.CENTER);
			tresj6.setColumns(10);
			tresj6.setBounds(10, 186, 47, 20);
			tresjv.add(tresj6);
			
			tresj7 = new JTextField();
			tresj7.setHorizontalAlignment(SwingConstants.CENTER);
			tresj7.setColumns(10);
			tresj7.setBounds(10, 217, 47, 20);
			tresjv.add(tresj7);
			
			tresj8 = new JTextField();
			tresj8.setHorizontalAlignment(SwingConstants.CENTER);
			tresj8.setColumns(10);
			tresj8.setBounds(10, 248, 47, 20);
			tresjv.add(tresj8);
			
			tresj9 = new JTextField();
			tresj9.setHorizontalAlignment(SwingConstants.CENTER);
			tresj9.setColumns(10);
			tresj9.setBounds(10, 279, 47, 20);
			tresjv.add(tresj9);
			
			tresj10 = new JTextField();
			tresj10.setHorizontalAlignment(SwingConstants.CENTER);
			tresj10.setColumns(10);
			tresj10.setBounds(10, 310, 47, 20);
			tresjv.add(tresj10);
			
			tresj11 = new JTextField();
			tresj11.setHorizontalAlignment(SwingConstants.CENTER);
			tresj11.setColumns(10);
			tresj11.setBounds(10, 341, 47, 20);
			tresjv.add(tresj11);
			
			tresj12 = new JTextField();
			tresj12.setHorizontalAlignment(SwingConstants.CENTER);
			tresj12.setColumns(10);
			tresj12.setBounds(10, 372, 47, 20);
			tresjv.add(tresj12);
		}
		{
			dospuntoslocal = new JPanel();
			dospuntoslocal.setBorder(new TitledBorder(null, "T-2Pts", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			dospuntoslocal.setBounds(822, 39, 67, 403);
			contentPanel.add(dospuntoslocal);
			dospuntoslocal.setLayout(null);
			
			dosjl1 = new JTextField();
			dosjl1.setHorizontalAlignment(SwingConstants.CENTER);
			dosjl1.setColumns(10);
			dosjl1.setBounds(10, 30, 47, 20);
			dospuntoslocal.add(dosjl1);
			
			dosjl2 = new JTextField();
			dosjl2.setHorizontalAlignment(SwingConstants.CENTER);
			dosjl2.setColumns(10);
			dosjl2.setBounds(10, 62, 47, 20);
			dospuntoslocal.add(dosjl2);
			
			dosjl3 = new JTextField();
			dosjl3.setHorizontalAlignment(SwingConstants.CENTER);
			dosjl3.setColumns(10);
			dosjl3.setBounds(10, 93, 47, 20);
			dospuntoslocal.add(dosjl3);
			
			dosjl4 = new JTextField();
			dosjl4.setHorizontalAlignment(SwingConstants.CENTER);
			dosjl4.setColumns(10);
			dosjl4.setBounds(10, 124, 47, 20);
			dospuntoslocal.add(dosjl4);
			
			dosjl5 = new JTextField();
			dosjl5.setHorizontalAlignment(SwingConstants.CENTER);
			dosjl5.setColumns(10);
			dosjl5.setBounds(10, 155, 47, 20);
			dospuntoslocal.add(dosjl5);
			
			dosjl6 = new JTextField();
			dosjl6.setHorizontalAlignment(SwingConstants.CENTER);
			dosjl6.setColumns(10);
			dosjl6.setBounds(10, 186, 47, 20);
			dospuntoslocal.add(dosjl6);
			
			dosjl7 = new JTextField();
			dosjl7.setHorizontalAlignment(SwingConstants.CENTER);
			dosjl7.setColumns(10);
			dosjl7.setBounds(10, 217, 47, 20);
			dospuntoslocal.add(dosjl7);
			
			dosjl8 = new JTextField();
			dosjl8.setHorizontalAlignment(SwingConstants.CENTER);
			dosjl8.setColumns(10);
			dosjl8.setBounds(10, 248, 47, 20);
			dospuntoslocal.add(dosjl8);
			
			dosjl9 = new JTextField();
			dosjl9.setHorizontalAlignment(SwingConstants.CENTER);
			dosjl9.setColumns(10);
			dosjl9.setBounds(10, 279, 47, 20);
			dospuntoslocal.add(dosjl9);
			
			dosjl10 = new JTextField();
			dosjl10.setHorizontalAlignment(SwingConstants.CENTER);
			dosjl10.setColumns(10);
			dosjl10.setBounds(10, 310, 47, 20);
			dospuntoslocal.add(dosjl10);
			
			dosjl11 = new JTextField();
			dosjl11.setHorizontalAlignment(SwingConstants.CENTER);
			dosjl11.setColumns(10);
			dosjl11.setBounds(10, 341, 47, 20);
			dospuntoslocal.add(dosjl11);
			
			dosjl12 = new JTextField();
			dosjl12.setHorizontalAlignment(SwingConstants.CENTER);
			dosjl12.setColumns(10);
			dosjl12.setBounds(10, 372, 47, 20);
			dospuntoslocal.add(dosjl12);
		}
		{
			tiroslibreslocal = new JPanel();
			tiroslibreslocal.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "T-Libres", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			tiroslibreslocal.setBounds(899, 39, 75, 403);
			contentPanel.add(tiroslibreslocal);
			tiroslibreslocal.setLayout(null);
			
			tllj1 = new JTextField();
			tllj1.setHorizontalAlignment(SwingConstants.CENTER);
			tllj1.setColumns(10);
			tllj1.setBounds(10, 30, 47, 20);
			tiroslibreslocal.add(tllj1);
			
			tllj2 = new JTextField();
			tllj2.setHorizontalAlignment(SwingConstants.CENTER);
			tllj2.setColumns(10);
			tllj2.setBounds(10, 62, 47, 20);
			tiroslibreslocal.add(tllj2);
			
			tllj3 = new JTextField();
			tllj3.setHorizontalAlignment(SwingConstants.CENTER);
			tllj3.setColumns(10);
			tllj3.setBounds(10, 93, 47, 20);
			tiroslibreslocal.add(tllj3);
			
			tjll4 = new JTextField();
			tjll4.setHorizontalAlignment(SwingConstants.CENTER);
			tjll4.setColumns(10);
			tjll4.setBounds(10, 124, 47, 20);
			tiroslibreslocal.add(tjll4);
			
			tllj5 = new JTextField();
			tllj5.setHorizontalAlignment(SwingConstants.CENTER);
			tllj5.setColumns(10);
			tllj5.setBounds(10, 155, 47, 20);
			tiroslibreslocal.add(tllj5);
			
			tllj6 = new JTextField();
			tllj6.setHorizontalAlignment(SwingConstants.CENTER);
			tllj6.setColumns(10);
			tllj6.setBounds(10, 186, 47, 20);
			tiroslibreslocal.add(tllj6);
			
			tllj7 = new JTextField();
			tllj7.setHorizontalAlignment(SwingConstants.CENTER);
			tllj7.setColumns(10);
			tllj7.setBounds(10, 217, 47, 20);
			tiroslibreslocal.add(tllj7);
			
			tllj8 = new JTextField();
			tllj8.setHorizontalAlignment(SwingConstants.CENTER);
			tllj8.setColumns(10);
			tllj8.setBounds(10, 248, 47, 20);
			tiroslibreslocal.add(tllj8);
			
			tllj9 = new JTextField();
			tllj9.setHorizontalAlignment(SwingConstants.CENTER);
			tllj9.setColumns(10);
			tllj9.setBounds(10, 279, 47, 20);
			tiroslibreslocal.add(tllj9);
			
			tllj10 = new JTextField();
			tllj10.setHorizontalAlignment(SwingConstants.CENTER);
			tllj10.setColumns(10);
			tllj10.setBounds(10, 310, 47, 20);
			tiroslibreslocal.add(tllj10);
			
			tllj11 = new JTextField();
			tllj11.setHorizontalAlignment(SwingConstants.CENTER);
			tllj11.setColumns(10);
			tllj11.setBounds(10, 341, 47, 20);
			tiroslibreslocal.add(tllj11);
			
			tllj12 = new JTextField();
			tllj12.setHorizontalAlignment(SwingConstants.CENTER);
			tllj12.setColumns(10);
			tllj12.setBounds(10, 372, 47, 20);
			tiroslibreslocal.add(tllj12);
		}
		{
			treslocal= new JPanel();
			treslocal.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "T-3Pts", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			treslocal.setBounds(984, 39, 67, 403);
			contentPanel.add(treslocal);
			treslocal.setLayout(null);
			
			treslj1 = new JTextField();
			treslj1.setHorizontalAlignment(SwingConstants.CENTER);
			treslj1.setColumns(10);
			treslj1.setBounds(10, 30, 47, 20);
			treslocal.add(treslj1);
			
			treslj2 = new JTextField();
			treslj2.setHorizontalAlignment(SwingConstants.CENTER);
			treslj2.setColumns(10);
			treslj2.setBounds(10, 62, 47, 20);
			treslocal.add(treslj2);
			
			treslj3 = new JTextField();
			treslj3.setHorizontalAlignment(SwingConstants.CENTER);
			treslj3.setColumns(10);
			treslj3.setBounds(10, 93, 47, 20);
			treslocal.add(treslj3);
			
			treslj4 = new JTextField();
			treslj4.setHorizontalAlignment(SwingConstants.CENTER);
			treslj4.setColumns(10);
			treslj4.setBounds(10, 124, 47, 20);
			treslocal.add(treslj4);
			
			treslj5 = new JTextField();
			treslj5.setHorizontalAlignment(SwingConstants.CENTER);
			treslj5.setColumns(10);
			treslj5.setBounds(10, 155, 47, 20);
			treslocal.add(treslj5);
			
			treslj6 = new JTextField();
			treslj6.setHorizontalAlignment(SwingConstants.CENTER);
			treslj6.setColumns(10);
			treslj6.setBounds(10, 186, 47, 20);
			treslocal.add(treslj6);
			
			treslj7 = new JTextField();
			treslj7.setHorizontalAlignment(SwingConstants.CENTER);
			treslj7.setColumns(10);
			treslj7.setBounds(10, 217, 47, 20);
			treslocal.add(treslj7);
			
			treslj8 = new JTextField();
			treslj8.setHorizontalAlignment(SwingConstants.CENTER);
			treslj8.setColumns(10);
			treslj8.setBounds(10, 248, 47, 20);
			treslocal.add(treslj8);
			
			treslj9 = new JTextField();
			treslj9.setHorizontalAlignment(SwingConstants.CENTER);
			treslj9.setColumns(10);
			treslj9.setBounds(10, 279, 47, 20);
			treslocal.add(treslj9);
			
			treslj10 = new JTextField();
			treslj10.setHorizontalAlignment(SwingConstants.CENTER);
			treslj10.setColumns(10);
			treslj10.setBounds(10, 310, 47, 20);
			treslocal.add(treslj10);
			
			treslj11 = new JTextField();
			treslj11.setHorizontalAlignment(SwingConstants.CENTER);
			treslj11.setColumns(10);
			treslj11.setBounds(10, 341, 47, 20);
			treslocal.add(treslj11);
			
			treslj12 = new JTextField();
			treslj12.setHorizontalAlignment(SwingConstants.CENTER);
			treslj12.setColumns(10);
			treslj12.setBounds(10, 372, 47, 20);
			treslocal.add(treslj12);
		}
		JPanel panel_GameInfo = new JPanel();
		panel_GameInfo.setBorder(new TitledBorder(null, "Resumen de juego", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_GameInfo.setBounds(10, 465, 1219, 95);
		contentPanel.add(panel_GameInfo);
		panel_GameInfo.setLayout(null);
		
		JLabel lblHomeTeamFouls = new JLabel("Total de faltas:");
		lblHomeTeamFouls.setBounds(642, 56, 105, 28);
		panel_GameInfo.add(lblHomeTeamFouls);
		
		faltaslocal = new JTextField();
		faltaslocal.setHorizontalAlignment(SwingConstants.CENTER);
		faltaslocal.setBounds(757, 60, 80, 20);
		panel_GameInfo.add(faltaslocal);
		faltaslocal.setColumns(10);
		
		JLabel lblAwayTeamFouls = new JLabel("Total de faltas: ");
		lblAwayTeamFouls.setBounds(10, 56, 105, 28);
		panel_GameInfo.add(lblAwayTeamFouls);
		
		faltasV = new JTextField();
		faltasV.setHorizontalAlignment(SwingConstants.CENTER);
		faltasV.setColumns(10);
		faltasV.setBounds(125, 60, 80, 20);
		panel_GameInfo.add(faltasV);
		
		JLabel lblAwayTeam_points = new JLabel("Total de puntos: ");
		lblAwayTeam_points.setBounds(10, 17, 115, 28);
		panel_GameInfo.add(lblAwayTeam_points);
		
		puntosV = new JTextField();
		puntosV.setHorizontalAlignment(SwingConstants.CENTER);
		puntosV.setEditable(false);
		puntosV.setBounds(125, 21, 80, 20);
		panel_GameInfo.add(puntosV);
		puntosV.setColumns(10);
		
		JLabel lblHomeTeam_1 = new JLabel("Total de puntos: ");
		lblHomeTeam_1.setBounds(642, 17, 115, 28);
		panel_GameInfo.add(lblHomeTeam_1);
		
		puntosequipolocal = new JTextField();
		puntosequipolocal.setHorizontalAlignment(SwingConstants.CENTER);
		puntosequipolocal.setEditable(false);
		puntosequipolocal.setColumns(10);
		puntosequipolocal.setBounds(757, 21, 80, 20);
		panel_GameInfo.add(puntosequipolocal);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(JugarPartido.class.getResource("/images/tumblr_static_filename_640_v2.png")));
		lblNewLabel.setBounds(252, 17, 210, 67);
		panel_GameInfo.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(JugarPartido.class.getResource("/images/1ycs60oaqdmk431jcp6v_400x400.jpeg")));
		lblNewLabel_1.setBounds(882, 17, 210, 67);
		panel_GameInfo.add(lblNewLabel_1);
		
		JButton actualizar = new JButton("Actualizar");
		actualizar.setBounds(887, 571, 89, 23);
		contentPanel.add(actualizar);
		
		
		guardar = new JButton("Guardar");
		guardar.setBounds(986, 571, 89, 23);
		contentPanel.add(guardar);
		guardar.setEnabled(false);
		JButton btnClose = new JButton("Cerrar");
		btnClose.setBounds(1085, 571, 101, 23);
		contentPanel.add(btnClose);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();						
			}
		});
		btnClose.setActionCommand("Cancelar");
		
		JButton btnNewButton = new JButton("Resultados");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Resultados result = new Resultados(null, null);
				result.setVisible(true);
				result.setLocationRelativeTo(null);
			}
		});
		btnNewButton.setBounds(680, 571, 101, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reiniciar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Datos reiniciados.", "", JOptionPane.INFORMATION_MESSAGE);
				reiniciar();
			}
		});
		btnNewButton_1.setBounds(788, 571, 89, 23);
		contentPanel.add(btnNewButton_1);
		guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Juego guardado satisfactoriamente.", "", JOptionPane.INFORMATION_MESSAGE);
				guardar();
				dispose();
			}
		});
		actualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update();
				guardar.setEnabled(true);
			}
		});
	}
	public void llenarCampos() {
		for (int i = 0; i < Nba.getInstances().getMisEquipos().size(); i++) {
				//Visitante
				if (Nba.getInstances().getMisEquipos().get(i).getNombreEquipo().equalsIgnoreCase(equipovisitante.getText())) {
					jugador1.setText(""+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(0).getEquipo()+" "+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(0).getApellido());
					jugador2.setText(""+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(1).getEquipo()+" "+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(1).getApellido());
					jugador4.setText(""+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(2).getEquipo()+" "+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(2).getApellido());
					jugador3.setText(""+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(3).getEquipo()+" "+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(3).getApellido());
					jugador6.setText(""+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(4).getEquipo()+" "+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(4).getApellido());
					jugador5.setText(""+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(5).getEquipo()+" "+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(5).getApellido());
					jugador8.setText(""+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(6).getEquipo()+" "+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(6).getApellido());
					jugador7.setText(""+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(7).getEquipo()+" "+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(7).getApellido());
					jugador10.setText(""+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(8).getEquipo()+" "+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(8).getApellido());
					jugador9.setText(""+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(9).getEquipo()+" "+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(9).getApellido());
					jugador12.setText(""+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(10).getEquipo()+" "+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(10).getApellido());
					jugador11.setText(""+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(11).getEquipo()+" "+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(11).getApellido());
				}
				//Local
				if (Nba.getInstances().getMisEquipos().get(i).getNombreEquipo().equalsIgnoreCase(equipolocal.getText())) {
					j1l.setText(""+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(0).getEquipo()+" "+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(0).getApellido());
					j2l.setText(""+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(1).getEquipo()+" "+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(1).getApellido());
					j4l.setText(""+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(2).getEquipo()+" "+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(2).getApellido());
					j3l.setText(""+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(3).getEquipo()+" "+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(3).getApellido());
					j6l.setText(""+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(4).getEquipo()+" "+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(4).getApellido());
					j5l.setText(""+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(5).getEquipo()+" "+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(5).getApellido());
					j8l.setText(""+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(6).getEquipo()+" "+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(6).getApellido());
					j7l.setText(""+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(7).getEquipo()+" "+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(7).getApellido());
					j10l.setText(""+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(8).getEquipo()+" "+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(8).getApellido());
					j9l.setText(""+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(9).getEquipo()+" "+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(9).getApellido());
					j12l.setText(""+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(10).getEquipo()+" "+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(10).getApellido());
					j11l.setText(""+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(11).getEquipo()+" "+Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(11).getApellido());
				}
			}
		}
	
	public void reiniciar() {
		puntosV.setText(""+0);
		
		dosj1.setText(""+0);
		dosj2.setText(""+0);
		dosj3.setText(""+0);
		dosj4.setText(""+0);
		dosj5.setText(""+0);
		dosj6.setText(""+0);
		dosj7.setText(""+0);
		dosj8.setText(""+0);
		dosj9.setText(""+0);
		dosj10.setText(""+0);
		dosj11.setText(""+0);
		dosj12.setText(""+0);
		
		tlj1.setText(""+0);
		tlj2.setText(""+0);
		tlj3.setText(""+0);
		tlj4.setText(""+0);
		tlj5.setText(""+0);
		tlj6.setText(""+0);
		tlj7.setText(""+0);
		tlj8.setText(""+0);
		tlj9.setText(""+0);
		tlj10.setText(""+0);
		tlj11.setText(""+0);
		tlj12.setText(""+0);
		
		tresj1.setText(""+0);
		tresj2.setText(""+0);
		tresj3.setText(""+0);
		tresj4.setText(""+0);
		tresj5.setText(""+0);
		tresj6.setText(""+0);
		tresj7.setText(""+0);
		tresj8.setText(""+0);
		tresj9.setText(""+0);
		tresj10.setText(""+0);
		tresj11.setText(""+0);
		tresj12.setText(""+0);
		
		puntosequipolocal.setText(""+0);
		
		dosjl1.setText(""+0);
		dosjl2.setText(""+0);
		dosjl3.setText(""+0);
		dosjl4.setText(""+0);
		dosjl5.setText(""+0);
		dosjl6.setText(""+0);
		dosjl7.setText(""+0);
		dosjl8.setText(""+0);
		dosjl9.setText(""+0);
		dosjl10.setText(""+0);
		dosjl11.setText(""+0);
		dosjl12.setText(""+0);
		
		tllj1.setText(""+0);
		tllj2.setText(""+0);
		tllj3.setText(""+0);
		tjll4.setText(""+0);
		tllj5.setText(""+0);
		tllj6.setText(""+0);
		tllj7.setText(""+0);
		tllj8.setText(""+0);
		tllj9.setText(""+0);
		tllj10.setText(""+0);
		tllj11.setText(""+0);
		tllj12.setText(""+0);
		
		treslj1.setText(""+0);
		treslj2.setText(""+0);
		treslj3.setText(""+0);
		treslj4.setText(""+0);
		treslj5.setText(""+0);
		treslj6.setText(""+0);
		treslj7.setText(""+0);
		treslj8.setText(""+0);
		treslj9.setText(""+0);
		treslj10.setText(""+0);
		treslj11.setText(""+0);
		treslj12.setText(""+0);
		
		faltasV.setText(""+0);
		faltaslocal.setText(""+0);
	}
	
	public void Update() {
		//Puntos visitante
		try {
			//Tiros de campo = 2
			puntosvis = 0;
			dosvis1 = Integer.parseInt(""+dosj1.getText());
			dosvis2 = Integer.parseInt(""+dosj2.getText());
			dosvis3 = Integer.parseInt(""+dosj3.getText());
			dosvis4 = Integer.parseInt(""+dosj4.getText());
			dosvis5 = Integer.parseInt(""+dosj5.getText());
			dosvis6 = Integer.parseInt(""+dosj6.getText());
			dosvis7 = Integer.parseInt(""+dosj7.getText());
			dosvis8 = Integer.parseInt(""+dosj8.getText());
			dosvis9 = Integer.parseInt(""+dosj9.getText());
			dosvis10 = Integer.parseInt(""+dosj10.getText());
			dosvis11 = Integer.parseInt(""+dosj11.getText());
			dosvis12 = Integer.parseInt(""+dosj12.getText());
			
			//Total de puntos de 2
			puntosvis += (dosvis1*2) + (dosvis2*2) + (dosvis3*2) + (dosvis4*2) + (dosvis5*2) + (dosvis6*2) + (dosvis7*2) + (dosvis8*2) + 
					(dosvis9*2) + (dosvis10*2) + (dosvis11*2) + (dosvis12*2);
			
			puntosV.setText(""+puntosvis);
			
			//Tiros libres = 1
			tirolv1 = Integer.parseInt(""+tlj1.getText());
			tirolv2 = Integer.parseInt(""+tllj2.getText());
			tirolv3 = Integer.parseInt(""+tllj3.getText());
			tirolv4 = Integer.parseInt(""+tjll4.getText());
			tirolv5 = Integer.parseInt(""+tllj5.getText());
			tirolv6 = Integer.parseInt(""+tllj6.getText());
			tirolv7 = Integer.parseInt(""+tllj7.getText());
			tirolv8 = Integer.parseInt(""+tllj8.getText());
			tirolv9 = Integer.parseInt(""+tllj9.getText());
			tirolv10 = Integer.parseInt(""+tllj10.getText());
			tirolv11 = Integer.parseInt(""+tllj11.getText());
			tirolv12 = Integer.parseInt(""+tllj12.getText());
			
			//Total puntos tiros libres.
			puntosvis += (tirolv1) + (tirolv2) + (tirolv3)+ (tirolv4)+ (tirolv5)+ (tirolv6)+ (tirolv7)+ (tirolv8)+ (tirolv9)+ (tirolv10)+ (tirolv11)+ (tirolv12);
			
			puntosV.setText(""+puntosvis);

			//Tiros de tres = 3
			tresvis1 = Integer.parseInt(""+tresj1.getText());
			tresvis2 = Integer.parseInt(""+tresj2.getText());
			tresvis3 = Integer.parseInt(""+tresj3.getText());
			tresvis4 = Integer.parseInt(""+tresj4.getText());
			tresvis5 = Integer.parseInt(""+tresj5.getText());
			tresvis6 = Integer.parseInt(""+tresj6.getText());
			tresvis7 = Integer.parseInt(""+tresj7.getText());
			tresvis8 = Integer.parseInt(""+tresj8.getText());
			tresvis9 = Integer.parseInt(""+tresj9.getText());
			tresvis10 = Integer.parseInt(""+tresj10.getText());
			tresvis11 = Integer.parseInt(""+tresj11.getText());
			tresvis12 = Integer.parseInt(""+tresj12.getText());
			
			puntosvis += (tresvis1*3)+ (tresvis2*3)+ (tresvis3*3)+ (tresvis4*3)+ (tresvis5*3)+ (tresvis6*3)+ (tresvis7*3)+ (tresvis8*3)+ (tresvis9*3)+ 
					(tresvis10*3)+ (tresvis11*3)+ (tresvis12*3);
			
			puntosV.setText(""+puntosvis);
			
			//Puntos local.
			//Tiros de campo = 2
			puntoslocal = 0;
			doslocal1 = Integer.parseInt(""+dosjl1.getText());
			doslocal2 = Integer.parseInt(""+dosjl2.getText());
			doslocal3 = Integer.parseInt(""+dosjl3.getText());
			doslocal4 = Integer.parseInt(""+dosjl4.getText());
			doslocal5 = Integer.parseInt(""+dosjl5.getText());
			doslocal6 = Integer.parseInt(""+dosjl6.getText());
			doslocal7 = Integer.parseInt(""+dosjl7.getText());
			doslocal8 = Integer.parseInt(""+dosjl8.getText());
			doslocal9 = Integer.parseInt(""+dosjl9.getText());
			doslocal10 = Integer.parseInt(""+dosjl10.getText());
			doslocal11 = Integer.parseInt(""+dosjl11.getText());
			doslocal12 = Integer.parseInt(""+dosjl12.getText());
					
			//Total de puntos de 2
			puntoslocal += (doslocal1*2) + (doslocal2*2) + (doslocal3*2) + (doslocal4*2) + (doslocal5*2) + (doslocal6*2) + (doslocal7*2) + (doslocal8*2) + (doslocal9*2) + (doslocal10*2) + (doslocal11*2) + (doslocal12*2);
			puntosequipolocal.setText(""+puntoslocal);
					
			//Estos son los tiros libres
			tiroll1= Integer.parseInt(""+tllj1.getText());
			tiroll2 = Integer.parseInt(""+tllj2.getText());
			tiroll3 = Integer.parseInt(""+tllj3.getText());
			tiroll4 = Integer.parseInt(""+tjll4.getText());
			tiroll5 = Integer.parseInt(""+tllj5.getText());
			tiroll6 = Integer.parseInt(""+tllj6.getText());
			tiroll7 = Integer.parseInt(""+tllj7.getText());
			tiroll8 = Integer.parseInt(""+tllj8.getText());
			tiroll9 = Integer.parseInt(""+tllj9.getText());
			tiroll10 = Integer.parseInt(""+tllj10.getText());
			tiroll11 = Integer.parseInt(""+tllj11.getText());
			tiroll12 = Integer.parseInt(""+tllj12.getText());
			
			puntoslocal += tiroll1 + tiroll2+ tiroll3+ tiroll4+ tiroll5+ tiroll6+ tiroll7+ tiroll8+ tiroll9+ tiroll10+ tiroll11+ tiroll12;
			
			puntosequipolocal.setText(""+puntoslocal);

			//Estos son los tiros de tres de la casa
			treslocal1 = Integer.parseInt(""+treslj1.getText());
			treslocal2 = Integer.parseInt(""+treslj2.getText());
			treslocal3 = Integer.parseInt(""+treslj3.getText());
			treslocal4 = Integer.parseInt(""+treslj4.getText());
			treslocal5 = Integer.parseInt(""+treslj5.getText());
			treslocal6 = Integer.parseInt(""+treslj6.getText());
			treslocal7 = Integer.parseInt(""+treslj7.getText());
			treslocal8 = Integer.parseInt(""+treslj8.getText());
			treslocal9 = Integer.parseInt(""+treslj9.getText());
			treslocal10 = Integer.parseInt(""+treslj10.getText());
			treslocal11 = Integer.parseInt(""+treslj11.getText());
			treslocal12 = Integer.parseInt(""+treslj12.getText());
			
			puntoslocal += (treslocal1*3) + (treslocal2*3)+ (treslocal3*3)+ (treslocal4*3)+ (treslocal5*3)+ (treslocal6*3)+
					(treslocal7*3)+ (treslocal8*3)+ (treslocal9*3)+ (treslocal10*3)+ (treslocal11*3)+ (treslocal12*3);

			puntosequipolocal.setText(""+puntoslocal);
			
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Sólo se pueden textear números.", "", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	public void guardar() {
		for (int i = 0; i < Nba.getInstances().getMisEquipos().size(); i++) {
			if (equipovisitante.getText().equalsIgnoreCase(Nba.getInstances().getMisEquipos().get(i).getNombreEquipo())) {
				Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(0).InsertarEstadisticasJugador(new Performance(tirolv1, tresvis1, dosvis1));
				Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(1).InsertarEstadisticasJugador(new Performance(tirolv2, tresvis2, dosvis2));
				Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(2).InsertarEstadisticasJugador(new Performance(tirolv3, tresvis3, dosvis2));
				Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(3).InsertarEstadisticasJugador(new Performance(tirolv4, tresvis4, dosvis3));
				Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(4).InsertarEstadisticasJugador(new Performance(tirolv5, tresvis5, dosvis4));
				Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(5).InsertarEstadisticasJugador(new Performance(tirolv6, tresvis6, dosvis5));
				Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(6).InsertarEstadisticasJugador(new Performance(tirolv7, tresvis7, dosvis6));
				Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(7).InsertarEstadisticasJugador(new Performance(tirolv8, tresvis8, dosvis7));
				Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(8).InsertarEstadisticasJugador(new Performance(tirolv9, tresvis9, dosvis8));
				Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(9).InsertarEstadisticasJugador(new Performance(tirolv10, tresvis10, dosvis9));
				Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(10).InsertarEstadisticasJugador(new Performance(tirolv11, tresvis11, dosvis10));
				Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(11).InsertarEstadisticasJugador(new Performance(tirolv12, tresvis2, dosvis11));
			}
			if (equipolocal.getText().equalsIgnoreCase(Nba.getInstances().getMisEquipos().get(i).getNombreEquipo())) {
				Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(0).InsertarEstadisticasJugador(new Performance(tiroll1, treslocal1, doslocal1));
				Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(1).InsertarEstadisticasJugador(new Performance(tiroll2, treslocal2, doslocal2));
				Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(2).InsertarEstadisticasJugador(new Performance(tiroll3, treslocal3, doslocal3));
				Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(3).InsertarEstadisticasJugador(new Performance(tiroll4, treslocal4, doslocal4));
				Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(4).InsertarEstadisticasJugador(new Performance(tiroll5, treslocal5, doslocal5));
				Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(5).InsertarEstadisticasJugador(new Performance(tiroll6, treslocal6, doslocal6));
				Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(6).InsertarEstadisticasJugador(new Performance(tiroll7, treslocal7, doslocal7));
				Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(7).InsertarEstadisticasJugador(new Performance(tiroll8, treslocal8, doslocal8));
				Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(8).InsertarEstadisticasJugador(new Performance(tiroll9, treslocal9, doslocal9));
				Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(9).InsertarEstadisticasJugador(new Performance(tiroll10, treslocal10, doslocal10));
				Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(10).InsertarEstadisticasJugador(new Performance(tiroll11, treslocal11, doslocal11));
				Nba.getInstances().getMisEquipos().get(i).getMisJugadores().get(11).InsertarEstadisticasJugador(new Performance(tiroll12, treslocal12, doslocal12));
			}
		}
		Horario schedule = new Horario();
		int i = schedule.tableHorario.getSelectedRow();
		String local = schedule.tableModel.getValueAt(schedule.tableHorario.getSelectedRow(), 3).toString();
		String visitante = schedule.tableModel.getValueAt(schedule.tableHorario.getSelectedRow(), 2).toString();
		String ciudad = Nba.getInstances().getMisEquipos().get(schedule.tableHorario.getSelectedRow()).toString();
		String fechapar = schedule.tableModel.getValueAt(schedule.tableHorario.getSelectedRow(), 0).toString();
		int marcadorL = puntoslocal;
		int marcadorV = puntosvis;
		String tiempos = schedule.tableModel.getValueAt(schedule.tableHorario.getSelectedRow(), 1).toString();
		Nba.getInstances().setPartido(i, local, visitante, ciudad, "estadio", tiempos, marcadorL, marcadorV, fechapar, true);
	}
}
