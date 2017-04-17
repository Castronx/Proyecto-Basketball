package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logical.Nba;
import logical.Team;
import logical.Player;

import logical.Injury;


import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class HistorialLesion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Object[] row;
	public static JTable table;
	private static JTable tableLesiones = new JTable();
	public static DefaultTableModel tableModel;
	public JComboBox<String> comboEquipo;
	public JComboBox<String> comboJugador;
	private JTable tableLesion = new JTable();

	private JLabel lblJugador;
	private JLabel lblEquipo;

	public HistorialLesion() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(HistorialLesion.class.getResource("/images/descarga (1).png")));
		setModal(true);
		setTitle("Historial Lesi\u00F3n");
		setBounds(100, 100, 861, 570);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Filtros", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 53, 825, 50);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				lblEquipo = new JLabel("Buscar por Equipo");
				lblEquipo.setBounds(12, 22, 109, 14);
				panel.add(lblEquipo);
			}
			{
				comboEquipo = new JComboBox();
				comboEquipo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						comboJugador.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione Jugador>"}));
						comboJugador.setEnabled(true);
						for (Team aux : Nba.getInstances().getMisEquipos()){	
							for (Player aux2 : aux.getMisJugadores()){	
								for (Injury aux3 : aux2.getLesion()){	
									if (aux.getMisJugadores().get(0).getLesion().size() > 0){
										if (comboEquipo.getSelectedItem().toString().equalsIgnoreCase(aux.getNombreEquipo()))
										{
											comboJugador.addItem(aux2.getNombre()+" "+aux2.getApellido());
										}
									}
								}
							}
						}
						if(comboEquipo.getSelectedIndex()==0)
						{
							comboJugador.setEnabled(false);
							cargarJugador();
						}
						if(comboEquipo.getSelectedIndex()!=0)
						{
							cargarJugadorporEquipo();
							if(comboJugador.getSelectedIndex()!=0)
							{
								cargarJugador();
							}
						}
					}
				});
				comboEquipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione Equipo>"}));
				comboEquipo.setBounds(118, 19, 235, 20);
				panel.add(comboEquipo);
				
				for (Team aux : Nba.getInstances().getMisEquipos())
					comboEquipo.addItem(aux.getNombreEquipo().toString());
			}
			{
				lblJugador = new JLabel("Buscar por Jugador");
				lblJugador.setBounds(466, 22, 116, 14);
				panel.add(lblJugador);
			}
			{
				comboJugador = new JComboBox();
				comboJugador.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						comboJugador.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione Jugador>"}));
						comboJugador.setEnabled(true);
						for (Team aux : Nba.getInstances().getMisEquipos()){	
							for (Player aux2 : aux.getMisJugadores()){	
								for (Injury aux3 : aux2.getLesion()){	
									if (aux.getMisJugadores().get(0).getLesion().size() > 0){
										if (comboEquipo.getSelectedItem().toString().equalsIgnoreCase(aux.getNombreEquipo()))
										{
											comboJugador.addItem(aux2.getNombre()+" "+aux2.getApellido());
										}
									}
								}
							}
						}
						if(comboEquipo.getSelectedIndex()==0)
						{
							comboJugador.setEnabled(false);
							cargarLesion();
						}
						if(comboEquipo.getSelectedIndex()!=0)
						{
							cargarJugadorporEquipo();
							if(comboJugador.getSelectedIndex()!=0)
							{
								cargarJugador();
							}
						}
					}
				});
				comboJugador.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione Jugador>"}));
				comboJugador.setBounds(581, 19, 234, 20);
				panel.add(comboJugador);
			}
		}
		{
			JLabel lblHistorialDeLesiones = new JLabel("Historial de Lesiones");
			lblHistorialDeLesiones.setFont(new Font("Verdana", Font.PLAIN, 20));
			lblHistorialDeLesiones.setBounds(276, 11, 256, 37);
			contentPanel.add(lblHistorialDeLesiones);
		}
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 107, 825, 380);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 11, 805, 358);
				panel.add(scrollPane);
				
				tableLesion = new JTable();
				scrollPane.setViewportView(tableLesion);
				
				tableModel = new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Equipo", "Nombre", "Apellido", "Tipo", "Informacion Adicional", "Fecha", "Retorno"
						});
				tableLesiones.setModel(tableModel);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Aceptar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	//metodo para cargar jugador a partir de equipo
	public void cargarJugadorporEquipo()
	{
		tableModel.setRowCount(0);
		row = new Object[tableModel.getColumnCount()];
		
		for (Team aux : Nba.getInstances().getMisEquipos()){
			if(comboEquipo.getSelectedItem().toString().equalsIgnoreCase(aux.getNombreEquipo())){
				for (Player aux2 : aux.getMisJugadores()){	
					for (Injury aux3 : aux2.getLesion()){
						if (aux.getMisJugadores().get(0).getLesion().size() > 0) 
						{							
								row[0] = aux.getNombreEquipo();
								row[1] = aux2.getNombre();
								row[2] = aux2.getApellido();
								row[3] = aux3.getTipo();
								row[4] = aux3.getFecha();
								row[5] = aux3.getRecuperacion();
								
								tableModel.addRow(row);
						}
					}	
				}
			}
		table.setModel(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel modeloColumna = table.getColumnModel();
		modeloColumna.getColumn(0).setPreferredWidth(95);
		modeloColumna.getColumn(1).setPreferredWidth(90);
		modeloColumna.getColumn(2).setPreferredWidth(90);
		modeloColumna.getColumn(3).setPreferredWidth(61);
		modeloColumna.getColumn(4).setPreferredWidth(90);
		modeloColumna.getColumn(5).setPreferredWidth(120);
		}
	}
    //metodo para cargar jugador
	public void cargarJugador()
	{
		tableModel.setRowCount(0);
		row = new Object[tableModel.getColumnCount()];
		for (Team aux : Nba.getInstances().getMisEquipos()){
			if(comboEquipo.getSelectedItem().toString().equalsIgnoreCase(aux.getNombreEquipo())){
				for (Player aux2 : aux.getMisJugadores()){	
					if(comboJugador.getSelectedItem().toString().equalsIgnoreCase(aux2.getNombre()+" "+aux2.getApellido())){
						for (Injury aux3 : aux2.getLesion()){
							if (aux.getMisJugadores().get(0).getLesion().size() > 0) 
							{								
								row[0] = aux.getNombreEquipo();
								row[1] = aux2.getNombre();
								row[2] = aux2.getApellido();
								row[3] = aux3.getInfoAdicional();
								row[4] = aux3.getFecha();
								row[5] = aux3.getRecuperacion();
								
								tableModel.addRow(row);
							}
						}
					}
				}	
			}
		}
		table.setModel(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel modelColumn = table.getColumnModel();
		modelColumn.getColumn(0).setPreferredWidth(95);
		modelColumn.getColumn(1).setPreferredWidth(90);
		modelColumn.getColumn(2).setPreferredWidth(90);
		modelColumn.getColumn(3).setPreferredWidth(61);
		modelColumn.getColumn(4).setPreferredWidth(90);
		modelColumn.getColumn(5).setPreferredWidth(120);
	}
	
	public void cargarLesion() 
	{
		tableModel.setRowCount(0); 
		row = new Object[tableModel.getColumnCount()];
		for (Team aux : Nba.getInstances().getMisEquipos()){	
			for (Player aux2 : aux.getMisJugadores()){	
				for (Injury aux3 : aux2.getLesion()){	
					if (aux.getMisJugadores().get(0).getLesion().size() > 0) 
					{
						row[0] = aux.getNombreEquipo();
						row[1] = aux2.getNombre();
						row[2] = aux2.getApellido();
						row[3] = aux3.getTipo();
						row[4] = aux3.getFecha();
						row[5] = aux3.getRecuperacion();
						
						tableModel.addRow(row);
					}
				}
			}
		}
		table.setModel(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel modeloColumna = table.getColumnModel();
		modeloColumna.getColumn(0).setPreferredWidth(95);
		modeloColumna.getColumn(1).setPreferredWidth(90);
		modeloColumna.getColumn(2).setPreferredWidth(90);
		modeloColumna.getColumn(3).setPreferredWidth(61);
		modeloColumna.getColumn(4).setPreferredWidth(90);
		modeloColumna.getColumn(5).setPreferredWidth(120);
	}
	
}
