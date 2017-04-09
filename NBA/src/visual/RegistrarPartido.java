package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;
import javax.swing.JSpinner;

public class RegistrarPartido extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JSpinner spnTiempo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarPartido dialog = new RegistrarPartido();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarPartido() {
		setTitle("Registrar Partido");
		setBounds(100, 100, 500, 195);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblHomeTeam = new JLabel("Home Team");
		lblHomeTeam.setBounds(10, 11, 70, 14);
		contentPanel.add(lblHomeTeam);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(90, 8, 129, 20);
		contentPanel.add(comboBox);
		
		JLabel lblAwayTeam = new JLabel("Away Team");
		lblAwayTeam.setBounds(259, 11, 70, 14);
		contentPanel.add(lblAwayTeam);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(339, 8, 135, 20);
		contentPanel.add(comboBox_1);
		
		JLabel lblEstadio = new JLabel("Estadio:");
		lblEstadio.setBounds(10, 55, 46, 14);
		contentPanel.add(lblEstadio);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(90, 52, 267, 20);
		contentPanel.add(comboBox_2);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(10, 98, 46, 14);
		contentPanel.add(lblFecha);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setBounds(259, 98, 46, 14);
		contentPanel.add(lblHora);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(85, 92, 134, 20);
		contentPanel.add(dateChooser);
		
		JSpinner spnTiempo = new JSpinner();
		spnTiempo.setBounds(339, 95, 77, 20);
		contentPanel.add(spnTiempo);
		
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
