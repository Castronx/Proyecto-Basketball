package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;


import logical.Game;
import logical.Nba;
import logical.Team;

import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import java.util.Calendar;
import java.awt.Toolkit;

public class RegistrarPartido extends JDialog {

	private static final long serialVersionUID = -9168198932418671005L;
	private final JPanel contentPanel = new JPanel();
	private JSpinner spnTiempo;
	private JComboBox equipolocal;
	private JComboBox equipovisitante;
	private JTextField ciudad;
	private JDateChooser fechapartido;
	private Date fecha;
	private JSpinner hora;
	private SpinnerDateModel spinnerDateModel;
	private Team equipoloc;
	private JTextField estadio;

	public RegistrarPartido() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrarPartido.class.getResource("/images/5215-200.png")));
		fechapartido = new JDateChooser();
		fecha = new Date();
		spinnerDateModel = new SpinnerDateModel(fecha, null, null, Calendar.MINUTE);
		
		setTitle("Registrar Partido");
		setBounds(100, 100, 553, 236);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblHomeTeam = new JLabel("Equipo local");
		lblHomeTeam.setBounds(10, 11, 70, 14);
		contentPanel.add(lblHomeTeam);
		
		equipolocal = new JComboBox<String>();
		equipolocal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nomequipo = equipolocal.getSelectedItem().toString();
				equipoloc = Nba.getInstances().buscarEquipo(nomequipo);
				ciudad.setText(equipoloc.getCiudad());
				estadio.setText(equipoloc.getEstadio());
	
			}
		});
		equipolocal.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>"}));
		equipolocal.setBounds(85, 8, 135, 20);
		for (int i = 0; i < Nba.getInstances().getMisEquipos().size(); i++)
		equipolocal.addItem(""+Nba.getInstances().getMisEquipos().get(i).getNombreEquipo());
		contentPanel.add(equipolocal);
		
		JLabel lblAwayTeam = new JLabel("Equipo visitante");
		lblAwayTeam.setBounds(284, 11, 98, 14);
		contentPanel.add(lblAwayTeam);
				
		equipovisitante = new JComboBox<String>();
		equipovisitante.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>"}));
		equipovisitante.setBounds(392, 8, 135, 20);
		for (int i = 0; i < Nba.getInstances().getMisEquipos().size(); i++)
		equipovisitante.addItem(""+Nba.getInstances().getMisEquipos().get(i).getNombreEquipo());
		contentPanel.add(equipovisitante);
		
		JLabel lblEstadio = new JLabel("Estadio:");
		lblEstadio.setBounds(10, 94, 46, 14);
		contentPanel.add(lblEstadio);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(10, 130, 46, 14);
		contentPanel.add(lblFecha);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setBounds(333, 125, 35, 14);
		contentPanel.add(lblHora);
		
		fechapartido = new JDateChooser();
		fechapartido.setBounds(85, 127, 134, 20);
		contentPanel.add(fechapartido);
		
		hora = new JSpinner();
		hora.setModel(new SpinnerDateModel(new Date(1492038000000L), null, null, Calendar.MINUTE));
		JSpinner.DateEditor de_spnTiempo = new JSpinner.DateEditor(hora, "hh:mm a");
		de_spnTiempo.getTextField().setEditable(true);
		hora.setEditor(de_spnTiempo);
		hora.setBounds(392, 122, 98, 20);
		contentPanel.add(hora);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setBounds(10, 54, 57, 14);
		contentPanel.add(lblCiudad);
		
		ciudad = new JTextField();
		ciudad.setEditable(false);
		ciudad.setBounds(85, 51, 328, 20);
		contentPanel.add(ciudad);
		ciudad.setColumns(10);
		
		estadio = new JTextField();
		estadio.setEditable(false);
		estadio.setBounds(85, 91, 328, 20);
		contentPanel.add(estadio);
		estadio.setColumns(10);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String dat = new SimpleDateFormat("MMM-dd-yyyy").format(fechapartido.getDate());
						JSpinner.DateEditor fe = new JSpinner.DateEditor(hora, "hh:mm a");
						String local = equipolocal.getSelectedItem().toString();
						String visitante = equipovisitante.getSelectedItem().toString();
						String campo = estadio.getText().toString();
						String time = fe.getTextField().getText().toString();
						String city = ciudad.getText().toString();
						boolean jugados = false;
						Game partido = new Game(local, visitante, city, campo, time, 0, 0, dat, jugados);
						if (equipovisitante.getSelectedIndex() == 0 || equipolocal.getSelectedIndex() == 0 || estadio.getText().toString() == "" || fechapartido.getDate().toString().isEmpty()||ciudad.getText().toString()=="") {
							JOptionPane.showMessageDialog(null, "Completar todos los campos.", "Warning!", JOptionPane.WARNING_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "El juego ha sido registrado exitosamente.", "", JOptionPane.INFORMATION_MESSAGE);
							Nba.getInstances().insertarPartido(partido);
							clean();
							dispose();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
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
	public void clean() {
		equipovisitante.setSelectedIndex(0);
		equipovisitante.setSelectedIndex(0);
		estadio.setText("");
		fechapartido.setDate(fecha);
	}
}
