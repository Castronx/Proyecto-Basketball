package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import logical.Injury;
import logical.Nba;
import logical.Player;
import logical.Team;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.awt.event.ActionEvent;

public class RegistrarLesion extends JDialog implements Serializable {

	private static final long serialVersionUID = 9067065319805762038L;
	private final JPanel contentPanel = new JPanel();
	private Team equipo;
	private Player jugador;
	private Injury lesion;
	private Nba liga;
	private JDateChooser txtFecha;
	private JDateChooser txtRecuperacion;
	private JTextField txtInfo;
	private JComboBox comboEquipo;
	private JComboBox comboJugador;
	private JComboBox comboTipo;
	

	public RegistrarLesion() {
		setTitle("Insertar Lesi\u00F3n");
		setBounds(100, 100, 659, 290);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n de Lesi\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 622, 206);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setBounds(10, 34, 46, 14);
		panel.add(lblEquipo);
		
		comboEquipo = new JComboBox();
		comboEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboJugador.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione Jugador>"}));
				comboJugador.setEnabled(true);
				for (Team aux : Nba.getInstances().getMisEquipos()){
					for (Player aux2 : aux.getMisJugadores()){
						comboJugador.setEnabled(true);
						if (comboEquipo.getSelectedItem().toString().equalsIgnoreCase(aux.getNombreEquipo())){
							comboJugador.addItem(aux2.getNombre()+" "+aux2.getApellido());
						}
					}
				}
				if (comboEquipo.getSelectedIndex()==0)
					comboJugador.setEnabled(false);
			} 		 
			});
		comboEquipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione Equipo>"}));
		comboEquipo.setBounds(98, 31, 227, 20);
		for (Team aux : Nba.getInstances().getMisEquipos())
		comboEquipo.addItem(aux.getNombreEquipo());
		panel.add(comboEquipo);
		
		JLabel lblJugador = new JLabel("Jugador");
		lblJugador.setBounds(10, 74, 46, 14);
		panel.add(lblJugador);
		
		comboJugador = new JComboBox();
		comboJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(comboEquipo.getSelectedIndex()!=0)
				comboJugador.setEnabled(true);
				if(comboJugador.getSelectedIndex()!=0)
					comboTipo.setEnabled(true);
				if(comboJugador.getSelectedIndex()==0)
					comboTipo.setEnabled(false);
			}
		});
		comboJugador.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione Jugador>"}));
		comboJugador.setBounds(98, 71, 227, 20);
		panel.add(comboJugador);
		
		JLabel lblTipo = new JLabel("Tipo de Lesi\u00F3n");
		lblTipo.setBounds(10, 114, 90, 14);
		panel.add(lblTipo);
		
		comboTipo = new JComboBox();
		comboTipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar Lesi\u00F3n>", "Cabeza", "Cuello", "Hombro", "Espalda", "Mu\u00F1eca", "Rodilla", "Tobillo"}));
		comboTipo.setBounds(98, 111, 227, 20);
		panel.add(comboTipo);
		
		JLabel lblInfo = new JLabel("Info Adicional");
		lblInfo.setBounds(10, 155, 72, 14);
		panel.add(lblInfo);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(420, 31, 46, 14);
		panel.add(lblFecha);
		
		txtFecha = new JDateChooser();
		txtFecha.setBounds(498, 28, 107, 20);
		panel.add(txtFecha);
		
		JLabel lblRecuperacion = new JLabel("Recuperaci\u00F3n");
		lblRecuperacion.setBounds(420, 71, 74, 14);
		panel.add(lblRecuperacion);
		
		txtRecuperacion = new JDateChooser();
		txtRecuperacion.setBounds(498, 68, 107, 20);
		panel.add(txtRecuperacion);
		
		txtInfo = new JTextField();
		txtInfo.setBounds(98, 152, 507, 20);
		panel.add(txtInfo);
		txtInfo.setColumns(10);
		
		JLabel lblEjAvisoDel = new JLabel("ej. Aviso del entrenador, reacci\u00F3n de los fan\u00E1ticos...");
		lblEjAvisoDel.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblEjAvisoDel.setBounds(98, 177, 315, 14);
		panel.add(lblEjAvisoDel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Insertar Lesi\u00F3n");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						boolean listo = false;
						if(comboEquipo.getSelectedIndex()!=0 && comboJugador.getSelectedIndex()!=0 && comboTipo.getSelectedIndex()!=0 && !txtFecha.getDate().toString().isEmpty() && !txtRecuperacion.getDate().toString().isEmpty()){
							String equipo = comboEquipo.getSelectedItem().toString();
							String jugador = comboJugador.getSelectedItem().toString();
							String tipo = comboTipo.getSelectedItem().toString();
							String fecha = txtFecha.getDate().toString();
							String recuperacion = txtRecuperacion.getDate().toString();
							String infoAdicional = txtInfo.getText();
							listo = true;
							Injury aux = new Injury(equipo, jugador, tipo, fecha, recuperacion, infoAdicional); 
			
		 JOptionPane.showMessageDialog(null, "Lesión Registrada " + comboJugador.getSelectedItem().toString(), null, JOptionPane.INFORMATION_MESSAGE);
							Nba.getInstances().getMisEquipos().get(comboEquipo.getSelectedIndex()).getMisJugadores().get(comboJugador.getSelectedIndex()).InsertarLesion(aux);
							clean();
						}
						
						else{
							listo=false;
							JOptionPane.showMessageDialog(null, "Verifique que todos los campos estén llenos", null, JOptionPane.ERROR_MESSAGE, null);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	 public JComboBox<String> getComboBox_Team() {
		return comboEquipo;
	}
	
	public JComboBox<String> getComboBox_Player() {
		return comboJugador;
	}
	private void clean() {
		comboEquipo.setSelectedIndex(0);
		comboJugador.setSelectedIndex(0);
		comboTipo.setSelectedIndex(0);
		txtFecha.setDate(null);;
		txtRecuperacion.setDate(null);;
		txtInfo.setText("");
	}
}
