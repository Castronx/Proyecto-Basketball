package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;

import logical.Game;
import logical.Nba;

import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class RegistrarPartido extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JSpinner spnTiempo;
	private JComboBox equipolocal;
	private JComboBox equipovisitante;
	private JComboBox estadio;
	private JTextField ciudad;
	private JDateChooser fechapartido;
	private Date fecha;

	public static void main(String[] args) {
		try {
			RegistrarPartido dialog = new RegistrarPartido();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public RegistrarPartido() {
		setTitle("Registrar Partido");
		setBounds(100, 100, 553, 236);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblHomeTeam = new JLabel("Equipo local");
		lblHomeTeam.setBounds(10, 11, 70, 14);
		contentPanel.add(lblHomeTeam);
		
		equipolocal = new JComboBox();
		equipolocal.setBounds(85, 8, 157, 20);
		contentPanel.add(equipolocal);
		
		JLabel lblAwayTeam = new JLabel("Equipo visitante");
		lblAwayTeam.setBounds(284, 11, 98, 14);
		contentPanel.add(lblAwayTeam);
		
		equipovisitante = new JComboBox();
		equipovisitante.setBounds(392, 8, 135, 20);
		contentPanel.add(equipovisitante);
		
		JLabel lblEstadio = new JLabel("Estadio:");
		lblEstadio.setBounds(10, 94, 46, 14);
		contentPanel.add(lblEstadio);
		
		estadio = new JComboBox();
		estadio.setBounds(85, 91, 442, 20);
		contentPanel.add(estadio);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(10, 125, 46, 14);
		contentPanel.add(lblFecha);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setBounds(333, 125, 35, 14);
		contentPanel.add(lblHora);
		
		fechapartido = new JDateChooser();
		fechapartido.setBounds(85, 122, 134, 20);
		contentPanel.add(fechapartido);
		
		JSpinner hora = new JSpinner();
		hora.setBounds(378, 122, 77, 20);
		contentPanel.add(hora);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setBounds(10, 54, 57, 14);
		contentPanel.add(lblCiudad);
		
		ciudad = new JTextField();
		ciudad.setBounds(85, 51, 328, 20);
		contentPanel.add(ciudad);
		ciudad.setColumns(10);
		
		JLabel lblEjPuertoPlata = new JLabel("Ej: Puerto Plata");
		lblEjPuertoPlata.setBounds(423, 54, 104, 14);
		contentPanel.add(lblEjPuertoPlata);
		
		JLabel lblPm = new JLabel("pm");
		lblPm.setBounds(462, 125, 46, 14);
		contentPanel.add(lblPm);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String dat = new SimpleDateFormat("MMM/dd/yyyy").format(fechapartido.getDate());
						JSpinner.DateEditor fe = new JSpinner.DateEditor(hora, "hh:mm a");
						String local = equipolocal.getSelectedItem().toString();
						String visitante = equipovisitante.getSelectedItem().toString();
						String campo = estadio.getSelectedItem().toString();
						String fechaJuego = fe.getTextField().getText().toString();
						String city = ciudad.getText().toString();
						String time = hora.getValue().toString();
						boolean jugados = false;
						Game partido = new Game(local, visitante, city, campo, time, 0, 0, fechaJuego, jugados);
						if (equipovisitante.getSelectedIndex() == 0 || equipolocal.getSelectedIndex() == 0 || estadio.getSelectedIndex() == 0 || fechapartido.getDate().toString().isEmpty()||ciudad.getText().toString()=="") {
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
		estadio.setSelectedIndex(0);
		fechapartido.setDate(fecha);
	}
}
