package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import javax.swing.border.TitledBorder;
import javax.swing.DefaultComboBoxModel;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import logical.Nba;
import logical.Player;
import logical.Team;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;


public class RegistrarJugador extends JDialog implements Serializable
    {
    
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField nombre;
	private JTextField edad;
	private JTextField apellido;
	private JTable tabladeJugadores;
	private DefaultTableModel tableModel;
	private JSpinner nocamiseta,pies, pulgadas, peso;
	@SuppressWarnings("rawtypes")
	private JComboBox equipo, posicion, lesionado;
	private Object[] row;
	private JLabel lblEquipo, lblNombre, lblFechaN, lblEdad, lblNo, lblPosicion, lblApellido, lblAltura, lblPies, lblPulgadas, lblPeso, lblKgs, lblLesionado, lblAos ;
    private JDateChooser fechaNaci;
    private JButton btnModify,btnDelete, btnInsert, btnBorrar, btnImprimir, btnClose;
    int year;
	String aux;
	RegistrarLesion injury;
	File filePlayers;
	ArrayList<Player> listPlayers;
	private JLabel lblPas;
	private JTextField pais;
	private boolean modificacion = false;
	private Team miEquipo;
	private Player miJugador;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public RegistrarJugador() 
	    {
		setTitle("Registrar Jugador");
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrarJugador.class.getResource("/images/mini-jugador-de-basquet.jpg")));
        setResizable(false);
		setModal(true);
		injury = new RegistrarLesion();
		listPlayers = new ArrayList<>();
		new JCalendar();
		setBounds(100, 100, 818, 634);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(304, 507, 75, 23);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setEnabled(false);
		btnBorrar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				int answer = JOptionPane.showConfirmDialog(null, "Desea eliminar este jugador?",null,JOptionPane.YES_NO_OPTION);
				if (answer == JOptionPane.YES_OPTION)
				{
					borrarJugadores();
					cargarJugadores();
				}
			}
		});
		btnBorrar.setBounds(413, 571, 75, 23);
		contentPanel.add(btnBorrar);
		
		btnModify = new JButton("Modificar");
		btnModify.setEnabled(false);
		btnModify.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) {
				modificarJugadores();
				modificacion = true;
				btnModify.setEnabled(false);
				tabladeJugadores.setEnabled(false);
				btnDelete.setEnabled(false); 
			}
		});
		btnModify.setBounds(498, 571, 101, 23);
		contentPanel.add(btnModify);
		
		btnInsert = new JButton("Registrar");
		btnInsert.setEnabled(false);
		btnInsert.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(modificacion==false){
					String Born = new SimpleDateFormat("MMM/dd/yyyy").format(fechaNaci.getDate());
					aux = ""+Born.charAt(7)+Born.charAt(8)+Born.charAt(9)+Born.charAt(10);
					year = Integer.parseInt(aux);
					boolean inj = false;
					if (lesionado.getSelectedIndex() == 0)
					{
						inj = false;
					}
					else
					{
						inj = true;
					}
					String name = nombre.getText().toString();
					String lastname = apellido.getText().toString();
					int weight = (int) peso.getValue();
					int pi = (int) pies.getValue();
					int pulg = (int) pulgadas.getValue();
					int numCam = (int) nocamiseta.getValue();
					String pos = posicion.getSelectedItem().toString();
					String equi = equipo.getSelectedItem().toString();
					String country = pais.getText().toString();
					Player pla = new Player(name, lastname, country, Born, 2017-year, pi, pulg, weight, numCam, pos, equi, inj);
					if (nombre.getText().isEmpty() || apellido.getText().isEmpty() || posicion.getSelectedIndex() == 0 || equipo.getSelectedIndex() == 0) 
					{
						JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos.", "Warning!", JOptionPane.WARNING_MESSAGE);
						return;
					}
					for (Team aux : Nba.getInstances().getMisEquipos()) {
						for (Player aux2 : aux.getMisJugadores()) {
							if ((nombre.getText().equalsIgnoreCase(aux2.getNombre()) && (apellido.getText().equalsIgnoreCase(aux2.getApellido())))) {
								JOptionPane.showMessageDialog(null, "Este jugador ya existe.", "Warning!", JOptionPane.WARNING_MESSAGE);
								clean();
								return;
							}
						}
					}
					for (Team aux : Nba.getInstances().getMisEquipos()) {
						if (equipo.getSelectedItem().toString().equalsIgnoreCase(aux.getNombreEquipo())) {
							aux.InsertarJugador(pla);
							JOptionPane.showMessageDialog(null, "El jugador ha sido registrado exitosamente.", null, JOptionPane.INFORMATION_MESSAGE);
							btnModify.setEnabled(false);
							tabladeJugadores.setEnabled(true);
							btnDelete.setEnabled(false);
							equipo.setEnabled(true);
							if (inj) {
								injury.getComboBox_Team().setSelectedItem(equipo.getSelectedItem().toString());
								injury.getComboBox_Team().setEnabled(false);
								injury.getComboBox_Player().setSelectedItem(nombre.getText()+" "+apellido.getText());
								injury.getComboBox_Player().setEnabled(false);
								injury.setVisible(true);
							}
							clean();
							cargarJugadores();
						}
					}
				}else{
					String Born = new SimpleDateFormat("MMM/dd/yyyy").format(fechaNaci.getDate());
					aux = ""+Born.charAt(7)+Born.charAt(8)+Born.charAt(9)+Born.charAt(10);
					year = Integer.parseInt(aux);
					boolean inj = false;
					if (lesionado.getSelectedIndex() == 0)
					{
						inj = false;
					}
					else
					{
						inj = true;
					}
					String name = nombre.getText().toString();
					String lastname = apellido.getText().toString();
					int weight = (int) peso.getValue();
					int pi = (int) pies.getValue();
					int pulg = (int) pulgadas.getValue();
					int numCam = (int) nocamiseta.getValue();
					String pos = posicion.getSelectedItem().toString();
					String equi = equipo.getSelectedItem().toString();
					String country = pais.getText().toString();
					if (nombre.getText().isEmpty() || apellido.getText().isEmpty() || posicion.getSelectedIndex() == 0 || equipo.getSelectedIndex() == 0) 
					{
						JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos.", "Warning!", JOptionPane.WARNING_MESSAGE);
						return;
					}else{
						miJugador.setApellido(lastname);
						miJugador.setNombre(name);
						miJugador.setNumero(numCam);
						miJugador.setPais(country);
						miJugador.setEquipo(equi);
						miJugador.setFechaNacimiento(Born);
						miJugador.setPies(pi);
						miJugador.setPulgadas(pulg);
						miJugador.setPosicion(pos);
						miJugador.setPeso(weight);
						JOptionPane.showMessageDialog(null, "El jugador ha sido Modificado exitosamente.", null, JOptionPane.INFORMATION_MESSAGE);
						btnModify.setEnabled(false);
						tabladeJugadores.setEnabled(true);
						btnDelete.setEnabled(false);
						equipo.setEnabled(true);
						cargarJugadores();
					}
					if (inj) {
						injury.getComboBox_Team().setSelectedItem(equipo.getSelectedItem().toString());
						injury.getComboBox_Team().setEnabled(false);
						injury.getComboBox_Player().setSelectedItem(nombre.getText()+" "+apellido.getText());
						injury.getComboBox_Player().setEnabled(false);
						injury.setVisible(true);
					}
					clean();
					cargarJugadores();
 					for (Team aux : Nba.getInstances().getMisEquipos()) {
						if (equipo.getSelectedItem().toString().equalsIgnoreCase(aux.getNombreEquipo())) {
						}
					}
				}
			}
		});
		contentPanel.add(btnInsert);
		btnInsert.setBounds(609, 571, 89, 23);
		{
		btnClose = new JButton("Salir\r\n");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnClose.setBounds(713, 571, 89, 23);
		contentPanel.add(btnClose);
	    }
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Datos del Jugador", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(0, 11, 802, 213);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				lblEquipo = new JLabel("Equipo:");
				lblEquipo.setBounds(10, 30, 59, 14);
				panel.add(lblEquipo);
			}
			{
				lblNombre = new JLabel("Nombre:");
				lblNombre.setEnabled(false);
				lblNombre.setBounds(10, 71, 59, 14);
				panel.add(lblNombre);
			}
			{
				lblFechaN = new JLabel("Nacimiento:");
				lblFechaN.setEnabled(false);
				lblFechaN.setBounds(10, 145, 68, 14);
				panel.add(lblFechaN);
			}
			{
				lblEdad = new JLabel("Edad:");
				lblEdad.setEnabled(false);
				lblEdad.setBounds(10, 185, 49, 14);
				panel.add(lblEdad);
			}
			{
				lblNo = new JLabel("No:");
				lblNo.setEnabled(false);
				lblNo.setBounds(181, 185, 24, 14);
				panel.add(lblNo);
			}
			equipo = new JComboBox();
			equipo.setModel(new DefaultComboBoxModel(new String[] {"<Selecionne el Equipo>"}));
			for (Team aux : Nba.getInstances().getMisEquipos())
				equipo.addItem(""+aux.getNombreEquipo());
			equipo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					int opt = equipo.getSelectedIndex();	
					cargarJugadores();
					switch (opt){
					case 0:
						lblNombre.setEnabled(false);
						nombre.setEnabled(false);
						lblApellido.setEnabled(false);
						apellido.setEnabled(false);
						lblEdad.setEnabled(false);
						lblPosicion.setEnabled(false);
						posicion.setEnabled(false);
						lblPeso.setEnabled(false);
						peso.setEnabled(false);
						lblAltura.setEnabled(false);
						pies.setEnabled(false);
						pulgadas.setEnabled(false);
						lblFechaN.setEnabled(false);
						btnInsert.setEnabled(false);
						lblNo.setEnabled(false);
						nocamiseta.setEnabled(false);
						fechaNaci.setEnabled(false);
						edad.setEnabled(false);
						lblLesionado.setEnabled(false);
						lesionado.setEnabled(false);
						lblAos.setEnabled(false);
						lblPas.setEnabled(false);
						pais.setEnabled(false);
						break;
						default:
						lblNombre.setEnabled(true);
						nombre.setEnabled(true);
						lblApellido.setEnabled(true);
						apellido.setEnabled(true);
						lblEdad.setEnabled(true);
						lblPosicion.setEnabled(true);
						posicion.setEnabled(true);
						lblPeso.setEnabled(true);
						peso.setEnabled(true);
						lblAltura.setEnabled(true);
						pies.setEnabled(true);
						pulgadas.setEnabled(true);
						lblFechaN.setEnabled(true);
						btnInsert.setEnabled(true);
						lblNo.setEnabled(true);
						nocamiseta.setEnabled(true);
						fechaNaci.setEnabled(true);
						edad.setEnabled(false);
						lblLesionado.setEnabled(true);
						lesionado.setEnabled(true);
						lblAos.setEnabled(true);
						lblPas.setEnabled(true);
						pais.setEnabled(true);
						lblKgs.setEnabled(true);
						lblPulgadas.setEnabled(true);
						lblPies.setEnabled(true);
					}
				}
			});
			equipo.setBounds(97, 27, 160, 20);
			panel.add(equipo);
			
			nombre = new JTextField();
			nombre.setEnabled(false);
			nombre.setBounds(97, 68, 160, 20);
			panel.add(nombre);
			nombre.setColumns(10);
			
			edad = new JTextField();
			edad.setEnabled(false);
			edad.setBounds(97, 182, 31, 20);
			panel.add(edad);
			edad.setColumns(10);
			
			nocamiseta = new JSpinner();
			nocamiseta.setEnabled(false);
			nocamiseta.setBounds(215, 182, 42, 20);
			panel.add(nocamiseta);
			
			lblPosicion = new JLabel("Posici\u00F3n:");
			lblPosicion.setEnabled(false);
			lblPosicion.setBounds(315, 30, 68, 14);
			panel.add(lblPosicion);
			
			posicion = new JComboBox();
			posicion.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "PG", "SG", "C", "PF", "SF"}));
			posicion.setEnabled(false);
			posicion.setBounds(396, 27, 153, 20);
			panel.add(posicion);
			
			lblApellido = new JLabel("Apellido:");
			lblApellido.setEnabled(false);
			lblApellido.setBounds(315, 71, 68, 14);
			panel.add(lblApellido);
			
			apellido = new JTextField();
			apellido.setEnabled(false);
			apellido.setBounds(396, 68, 153, 20);
			panel.add(apellido);
			apellido.setColumns(10);
			
			lblAltura = new JLabel("Altura:");
			lblAltura.setEnabled(false);
			lblAltura.setBounds(315, 145, 46, 14);
			panel.add(lblAltura);
			
			pies = new JSpinner();
			pies.setEnabled(false);
			pies.setBounds(396, 142, 36, 20);
			panel.add(pies);
			
			lblPies = new JLabel("Pies");
			lblPies.setEnabled(false);
			lblPies.setBounds(442, 145, 31, 14);
			panel.add(lblPies);
			
			pulgadas = new JSpinner();
			pulgadas.setEnabled(false);
			pulgadas.setBounds(473, 142, 36, 20);
			panel.add(pulgadas);
			
			lblPulgadas = new JLabel("Pulgadas");
			lblPulgadas.setEnabled(false);
			lblPulgadas.setBounds(519, 145, 68, 14);
			panel.add(lblPulgadas);
			
			lblPeso = new JLabel("Peso:");
			lblPeso.setEnabled(false);
			lblPeso.setBounds(315, 107, 46, 14);
			panel.add(lblPeso);
			
			peso = new JSpinner();
			peso.setEnabled(false);
			peso.setBounds(396, 104, 47, 20);
			panel.add(peso);
			
			lblKgs = new JLabel("Kgs");
			lblKgs.setEnabled(false);
			lblKgs.setBounds(453, 107, 36, 14);
			panel.add(lblKgs);
			
			lblLesionado = new JLabel("Lesionado:");
			lblLesionado.setEnabled(false);
			lblLesionado.setBounds(315, 185, 68, 14);
			panel.add(lblLesionado);
			
			lesionado = new JComboBox();
			lesionado.setEnabled(false);
			lesionado.setModel(new DefaultComboBoxModel(new String[] {"NO", "SI"}));
			lesionado.setBounds(396, 182, 42, 20);
			panel.add(lesionado);
				
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 235, 802, 2);
		contentPanel.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent arg0)
			{
				btnModify.setEnabled(true);
			}
		});
		scrollPane.setBounds(13, 209, 558, 253);
		scrollPane.setBounds(14, 277, 618, 253);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(14, 277, 788, 283);
		contentPanel.add(scrollPane1);
		SimpleDateFormat format = new SimpleDateFormat("MMM/dd/yyyy");
		Date minDate = null, maxDate = null, selectDate = null;
		try
		{
			minDate = format.parse("Jan/01/1977");
			maxDate = format.parse("Dec/31/1997");
			selectDate = format.parse("Jan/01/1997");
		}
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		fechaNaci = new JDateChooser();
		fechaNaci.setEnabled(false);
		fechaNaci.setBounds(97, 142, 160, 20);
		panel.add(fechaNaci);
		fechaNaci.setSelectableDateRange(minDate, maxDate);
		fechaNaci.setDate(selectDate);
		
		lblAos = new JLabel("a\u00F1os");
		lblAos.setEnabled(false);
		lblAos.setBounds(138, 185, 36, 14);
		panel.add(lblAos);
		
		lblPas = new JLabel("Pa\u00EDs:");
		lblPas.setBounds(10, 107, 46, 14);
		panel.add(lblPas);
		
		pais = new JTextField();
		pais.setEnabled(false);
		pais.setBounds(97, 104, 160, 20);
		panel.add(pais);
		pais.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(RegistrarJugador.class.getResource("/images/feeb7e52-61ff-4909-839c-045e03b53c37.png")));
		lblNewLabel.setBounds(585, 11, 207, 188);
		panel.add(lblNewLabel);
		String Born = new SimpleDateFormat("MMM/dd/yyyy").format(fechaNaci.getDate());
		aux = ""+Born.charAt(7)+Born.charAt(8)+Born.charAt(9)+Born.charAt(10);
		year = Integer.parseInt(aux);
		
		fechaNaci.getDateEditor().addPropertyChangeListener( new PropertyChangeListener() 
		{
		    @Override
		    public void propertyChange(PropertyChangeEvent e) 
		    {
		    	String Born = new SimpleDateFormat("MMM/dd/yyyy").format(fechaNaci.getDate());
				aux = ""+Born.charAt(7)+Born.charAt(8)+Born.charAt(9)+Born.charAt(10);
				year = Integer.parseInt(aux);	
		        edad.setText(""+(2017-year));
		        edad.validate();
		    }
		});
		tabladeJugadores = new JTable();
		tabladeJugadores.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if (btnModify.isEnabled() == false && tabladeJugadores.isEnabled() == true) 
				{
					btnModify.setEnabled(true);
					btnBorrar.setEnabled(true);
				}
				else if (btnBorrar.isEnabled() == false && tabladeJugadores.isEnabled() == true)
				{
					btnModify.setEnabled(true);
					btnBorrar.setEnabled(true);
				}
			}
		});
		scrollPane1.setViewportView(tabladeJugadores);
{
			tableModel = new DefaultTableModel
				(
					new Object[][] {},
					new String[] 
						{
						"Nombre", "Apellido", "País", "Nacimiento", "Edad", "Altura", "Peso", "No.", "Posición","Equipo","¿Lesión?"
						}
				);
			tabladeJugadores.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Nombre", "Apellido", "Pa\u00EDs", "Fecha Nac.", "Edad", "Altura", "Peso", "No.", "Posici\u00F3n", "Equipo", "¿Lesión?"
				}
			));
			tabladeJugadores.getColumnModel().getColumn(0).setPreferredWidth(90);
			tabladeJugadores.getColumnModel().getColumn(1).setPreferredWidth(100);
			tabladeJugadores.getColumnModel().getColumn(2).setPreferredWidth(140);
			tabladeJugadores.getColumnModel().getColumn(3).setPreferredWidth(140);
			tabladeJugadores.getColumnModel().getColumn(4).setPreferredWidth(100);
			tabladeJugadores.getColumnModel().getColumn(5).setPreferredWidth(110);
			tabladeJugadores.getColumnModel().getColumn(6).setPreferredWidth(50);
			tabladeJugadores.getColumnModel().getColumn(7).setPreferredWidth(60);
			tabladeJugadores.getColumnModel().getColumn(8).setPreferredWidth(80);
			tabladeJugadores.getColumnModel().getColumn(9).setPreferredWidth(110);
		
			JButton btnImprimir = new JButton("Imprimir");
			btnImprimir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					   try{
			               File file = new File("./Jugadores.txt");
			               if(!file.exists()){
			                   file.createNewFile();
			               }
			               FileWriter fw = new FileWriter(file.getAbsoluteFile());
			               BufferedWriter bw = new BufferedWriter(fw);
			               bw.write("\n														Listado de jugadores														                            	\n");
			               bw.write("-----------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
			               bw.write("Nombre \t\tApellido \t\tPaís \t\t\tFecha Nac. \t\t\tEdad \t\tAltura \t\t\tPeso \t\t\tNo. \t\t\tPosición \t\t\tEquipo \t\t\t¿Lesión?\n");
			               bw.write("-----------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
			               for(int i = 0; i < tabladeJugadores.getRowCount(); i++){
			                   for(int j = 0; j < tabladeJugadores.getColumnCount(); j++){
			                       bw.write(tabladeJugadores.getModel().getValueAt(i, j)+"			 ");
			                   }
			                   bw.write("\n");
			               }
			               bw.write("----------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
			               bw.close();
			               fw.close();
			               JOptionPane.showMessageDialog(null, "El listado de jugadores ha sido impreso.");
			               }catch(Exception ex){
			                   ex.printStackTrace();
			               }
				}
			});
			btnImprimir.setBounds(314, 571, 89, 23);
			contentPanel.add(btnImprimir);
           }   
               }
	private void clean() {	
		nombre.setText("");
		apellido.setText("");
		peso.setValue(0);
		posicion.setSelectedIndex(0);
		equipo.setSelectedIndex(0);
		pulgadas.setValue(new Integer(0));
		pies.setValue(new Integer(0));
		nocamiseta.setValue(new Integer(0));
		lesionado.setSelectedIndex(0);
	}
	public void modificarJugadores(){
		SimpleDateFormat formatter = new SimpleDateFormat("MMM/dd/yyyy");
		Date date = null;
		char Feets, Inches;
		int feets, inches;
		String Name = (String) tableModel.getValueAt(tabladeJugadores.getSelectedRow(), 0);
		String LastName = (String) tableModel.getValueAt(tabladeJugadores.getSelectedRow(), 1);
		String Country = (String) tableModel.getValueAt(tabladeJugadores.getSelectedRow(), 2);
		try
		{
			date = formatter.parse((String) tableModel.getValueAt(tabladeJugadores.getSelectedRow(), 3));
		}
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		int Age = (int) tableModel.getValueAt(tabladeJugadores.getSelectedRow(), 4);
		String Height = (String) tableModel.getValueAt(tabladeJugadores.getSelectedRow(), 5);
		Feets = Height.charAt(0);
		Inches = Height.charAt(2);
		feets = Character.getNumericValue(Feets);
		inches = Character.getNumericValue(Inches);
		int Weight = (int) tableModel.getValueAt(tabladeJugadores.getSelectedRow(), 6);
		int Number = (int) tableModel.getValueAt(tabladeJugadores.getSelectedRow(), 7);
		String Position = (String) tableModel.getValueAt(tabladeJugadores.getSelectedRow(), 8);
		String Team = (String) tableModel.getValueAt(tabladeJugadores.getSelectedRow(), 9);
		String Injuried = (String) tableModel.getValueAt(tabladeJugadores.getSelectedRow(), 10);
		miEquipo = Nba.getInstances().buscarEquipo(Team);
		miJugador = miEquipo.buscarJugador(Name);
		posicion.setSelectedItem(Position);
		nombre.setText(Name);
		apellido.setText(LastName);
		peso.setValue(Weight);
		pies.setValue(feets);
		pulgadas.setValue(inches);
		equipo.setSelectedItem(Team);
		nocamiseta.setValue(Number);
		fechaNaci.setDate(date);
		edad.setText(""+Age);
		if (Injuried == "No") 
		{
			lesionado.setSelectedIndex(0);
		}
		else
		{
			lesionado.setSelectedIndex(1);
		}
	}
	public void borrarJugadores() {
		int temp = 0;
    	for (int i = 0; i < Nba.getInstances().getMisEquipos().size(); i++) {
    		    for (int j = 0; j < listPlayers.size(); j++) {
					if (listPlayers.get(j).getNombre().equalsIgnoreCase(Nba.getInstances().getMisEquipos().get(i).getNombreEquipo())) {
						Nba.getInstances().getMisEquipos().remove(i);
						temp = i;
					}
				}
    	}
    	Nba.getInstances().getMisEquipos().remove(temp);
    	tableModel.fireTableDataChanged();
	}
	public void cargarJugadores() {
		tableModel.setRowCount(0); 
		row = new Object[tableModel.getColumnCount()];
			      for(Team aux : Nba.getInstances().getMisEquipos()){
						for (Player aux2 : aux.getMisJugadores()) {
							row[0] = aux2.getNombre();
							row[1] = aux2.getApellido();
							row[2] = aux2.getPais();
							row[3] = aux2.getFechaNacimiento();
							row[4] = aux2.getEdad();
							row[5] = aux2.getPies() + "'" + aux2.getPulgadas();
							row[6] = aux2.getPeso();
							row[7] = aux2.getNumero();
							row[8] = aux2.getPosicion();
							row[9] = aux2.getEquipo();
							if (aux2.isLesionado() == false) {
								row[10] = "No";
							}
							else {
								row[10] = "Si";
							}
							tableModel.addRow(row);
						}
					}
		tabladeJugadores.setModel(tableModel);
		tabladeJugadores.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tabladeJugadores.getTableHeader().setReorderingAllowed(true);
		TableColumnModel modeloColumna = tabladeJugadores.getColumnModel();
		modeloColumna.getColumn(0).setPreferredWidth(80);
		modeloColumna.getColumn(1).setPreferredWidth(80);
		modeloColumna.getColumn(2).setPreferredWidth(90);
		modeloColumna.getColumn(3).setPreferredWidth(90);
		modeloColumna.getColumn(4).setPreferredWidth(50);
		modeloColumna.getColumn(5).setPreferredWidth(50);
		modeloColumna.getColumn(6).setPreferredWidth(50);
		modeloColumna.getColumn(7).setPreferredWidth(50);
		modeloColumna.getColumn(8).setPreferredWidth(65);
		modeloColumna.getColumn(9).setPreferredWidth(155);
		modeloColumna.getColumn(10).setPreferredWidth(100);
		}
}