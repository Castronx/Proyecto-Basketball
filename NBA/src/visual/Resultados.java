package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import logical.Game;
import logical.Nba;
import logical.Performance;
import logical.Team;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class Resultados extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Nba liga;
	private JugarPartido partido;
	private Team equipo;
	private Game juego;
	private Performance estad;
	private static DefaultTableModel tablelistado;
	static Object[] fila;
	private JButton okButton;
	private String busqueda = null;
	private JTextField textField;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;

	public Resultados(JugarPartido partido, Team equipo) {
		setTitle("Ver Resultados");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 571, 330);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.partido = partido;
		this.liga = liga;
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 115, 535, 132);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(28, 42, 177, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblEquipoLocal = new JLabel("Equipo local");
		lblEquipoLocal.setForeground(Color.BLUE);
		lblEquipoLocal.setBounds(91, 17, 114, 14);
		panel.add(lblEquipoLocal);
		
		textField1 = new JTextField();
		textField1.setBounds(316, 42, 193, 20);
		panel.add(textField1);
		textField1.setColumns(10);
		
		JLabel lblVisitante = new JLabel("Equipo Visitante");
		lblVisitante.setBounds(374, 17, 114, 14);
		panel.add(lblVisitante);
		
		JLabel lblVs = new JLabel("VS");
		lblVs.setForeground(Color.RED);
		lblVs.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVs.setBounds(248, 64, 33, 25);
		panel.add(lblVs);
		
		JLabel lblPuntosTotales = new JLabel("Puntos Totales");
		lblPuntosTotales.setForeground(Color.BLUE);
		lblPuntosTotales.setBounds(84, 73, 114, 14);
		panel.add(lblPuntosTotales);
		
		JLabel lblPuntosTotales_1 = new JLabel("Puntos Totales");
		lblPuntosTotales_1.setBounds(374, 73, 114, 14);
		panel.add(lblPuntosTotales_1);
		
		textField2 = new JTextField();
		textField2.setBounds(28, 101, 177, 20);
		panel.add(textField2);
		textField2.setColumns(10);
		
		textField3 = new JTextField();
		textField3.setBounds(316, 101, 193, 20);
		panel.add(textField3);
		textField3.setColumns(10);
		String[] columnsHeaders = {"Equipo local ","Puntos Totales","VS","Puntos Totales", "Equipo Visitante"};
		tablelistado = new DefaultTableModel();
		tablelistado.setColumnIdentifiers(columnsHeaders);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(10, 258, 538, 32);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton okButton_1 = new JButton("Aceptar");
				okButton_1.setBounds(372, 5, 71, 23);
				okButton_1.setActionCommand("OK");
				buttonPane.add(okButton_1);
				getRootPane().setDefaultButton(okButton_1);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setBounds(449, 5, 75, 23);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		

		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 535, 93);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int ind = comboBox.getSelectedIndex();
				juego = Nba.getInstances().getMisJuegos().get(ind);
				textField.setText(""+juego.getEquipoLocal());
				textField1.setText(""+juego.getEquipoVisitante());
				textField2.setText(""+ juego.getEquipoLocal());
				textField3.setText(""+juego.getEquipoVisitante());
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione partido>"}));
		comboBox.setBounds(37, 37, 249, 20);
		panel_1.add(comboBox);
		for(int index = 0; index<Nba.getInstances().getMisJuegos().size(); index++){
			comboBox.insertItemAt((String) (""+Nba.getInstances().getMisJuegos().get(index).getEquipoLocal()+" - "+ Nba.getInstances().getMisJuegos().get(index).getEquipoVisitante()), index);
		}
	//	Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
	
}
}