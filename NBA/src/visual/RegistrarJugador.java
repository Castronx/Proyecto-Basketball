package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JSeparator;

public class RegistrarJugador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarJugador dialog = new RegistrarJugador();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarJugador() {
		setBounds(100, 100, 700, 573);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 684, 178);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Equipo:");
				lblNewLabel.setBounds(10, 11, 59, 14);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Nombre:");
				lblNewLabel_1.setBounds(10, 59, 59, 14);
				panel.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Fecha de Nacimiento:");
				lblNewLabel_2.setBounds(10, 103, 115, 14);
				panel.add(lblNewLabel_2);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Edad:");
				lblNewLabel_3.setBounds(10, 151, 36, 14);
				panel.add(lblNewLabel_3);
			}
			{
				JLabel lblNo = new JLabel("No:");
				lblNo.setBounds(100, 151, 36, 14);
				panel.add(lblNo);
			}
			
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(97, 8, 142, 20);
			panel.add(comboBox);
			
			textField = new JTextField();
			textField.setBounds(100, 56, 139, 20);
			panel.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setBounds(54, 148, 31, 20);
			panel.add(textField_1);
			textField_1.setColumns(10);
			
			JSpinner spinner = new JSpinner();
			spinner.setBounds(132, 148, 42, 20);
			panel.add(spinner);
			
			JLabel lblPosicion = new JLabel("Posicion:");
			lblPosicion.setBounds(317, 11, 68, 14);
			panel.add(lblPosicion);
			
			JComboBox comboBox_1 = new JComboBox();
			comboBox_1.setBounds(396, 8, 153, 20);
			panel.add(comboBox_1);
			
			JLabel lblApellido = new JLabel("Apellido:");
			lblApellido.setBounds(317, 59, 68, 14);
			panel.add(lblApellido);
			
			textField_2 = new JTextField();
			textField_2.setBounds(396, 56, 153, 20);
			panel.add(textField_2);
			textField_2.setColumns(10);
			
			JLabel lblAltura = new JLabel("Altura:");
			lblAltura.setBounds(317, 103, 46, 14);
			panel.add(lblAltura);
			
			JSpinner spinner_1 = new JSpinner();
			spinner_1.setBounds(396, 100, 36, 20);
			panel.add(spinner_1);
			
			JLabel lblPies = new JLabel("Pies");
			lblPies.setBounds(442, 103, 31, 14);
			panel.add(lblPies);
			
			JSpinner spinner_2 = new JSpinner();
			spinner_2.setBounds(469, 100, 36, 20);
			panel.add(spinner_2);
			
			JLabel lblPulgadas = new JLabel("Pulgadas");
			lblPulgadas.setBounds(515, 103, 46, 14);
			panel.add(lblPulgadas);
			
			JLabel lblPeso = new JLabel("Peso:");
			lblPeso.setBounds(317, 151, 46, 14);
			panel.add(lblPeso);
			
			JSpinner spinner_3 = new JSpinner();
			spinner_3.setBounds(396, 148, 36, 20);
			panel.add(spinner_3);
			
			JLabel lblKgs = new JLabel("Kgs");
			lblKgs.setBounds(442, 151, 36, 14);
			panel.add(lblKgs);
			
			JLabel lblLesionado = new JLabel("Lesionado:");
			lblLesionado.setBounds(515, 151, 68, 14);
			panel.add(lblLesionado);
			
			JComboBox comboBox_2 = new JComboBox();
			comboBox_2.setBounds(593, 148, 59, 20);
			panel.add(comboBox_2);
		}
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 200, 684, 2);
		contentPanel.add(separator);
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
