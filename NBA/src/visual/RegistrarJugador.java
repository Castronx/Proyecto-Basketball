package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import javax.swing.border.TitledBorder;
import javax.swing.DefaultComboBoxModel;


public class RegistrarJugador extends JDialog implements Serializable{
    
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JTextField textEdad;
	private JTextField textApellido;

	public static void main(String[] args) {
		try {
			RegistrarJugador dialog = new RegistrarJugador();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public RegistrarJugador() {
		setBounds(100, 100, 700, 573);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Datos del Jugador", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(0, 11, 684, 178);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblEquipo = new JLabel("Equipo:");
				lblEquipo.setBounds(10, 30, 59, 14);
				panel.add(lblEquipo);
			}
			{
				JLabel lblNombre = new JLabel("Nombre:");
				lblNombre.setEnabled(false);
				lblNombre.setBounds(10, 71, 59, 14);
				panel.add(lblNombre);
			}
			{
				JLabel lblFechaN = new JLabel("Fecha de Nacimiento:");
				lblFechaN.setEnabled(false);
				lblFechaN.setBounds(10, 111, 115, 14);
				panel.add(lblFechaN);
			}
			{
				JLabel lblEdad = new JLabel("Edad:");
				lblEdad.setEnabled(false);
				lblEdad.setBounds(10, 151, 49, 14);
				panel.add(lblEdad);
			}
			{
				JLabel lblNo = new JLabel("No:");
				lblNo.setEnabled(false);
				lblNo.setBounds(165, 151, 36, 14);
				panel.add(lblNo);
			}
			
			JComboBox comboBoxEquipo = new JComboBox();
			comboBoxEquipo.setModel(new DefaultComboBoxModel(new String[] {"<Selecionne el Equipo>"}));
			comboBoxEquipo.setBounds(97, 24, 160, 20);
			panel.add(comboBoxEquipo);
			
			textNombre = new JTextField();
			textNombre.setBounds(100, 65, 157, 20);
			panel.add(textNombre);
			textNombre.setColumns(10);
			
			textEdad = new JTextField();
			textEdad.setBounds(69, 145, 42, 20);
			panel.add(textEdad);
			textEdad.setColumns(10);
			
			JSpinner spinnerNo = new JSpinner();
			spinnerNo.setEnabled(false);
			spinnerNo.setBounds(197, 145, 42, 20);
			panel.add(spinnerNo);
			
			JLabel lblPosicion = new JLabel("Posicion:");
			lblPosicion.setEnabled(false);
			lblPosicion.setBounds(315, 30, 68, 14);
			panel.add(lblPosicion);
			
			JComboBox comboBoxPosicion = new JComboBox();
			comboBoxPosicion.setEnabled(false);
			comboBoxPosicion.setBounds(396, 24, 153, 20);
			panel.add(comboBoxPosicion);
			
			JLabel lblApellido = new JLabel("Apellido:");
			lblApellido.setEnabled(false);
			lblApellido.setBounds(315, 71, 68, 14);
			panel.add(lblApellido);
			
			textApellido = new JTextField();
			
			textApellido.setBounds(396, 65, 153, 20);
			panel.add(textApellido);
			textApellido.setColumns(10);
			
			JLabel lblAltura = new JLabel("Altura:");
			lblAltura.setEnabled(false);
			lblAltura.setBounds(315, 111, 46, 14);
			panel.add(lblAltura);
			
			JSpinner spinnerPies = new JSpinner();
			spinnerPies.setEnabled(false);
			spinnerPies.setBounds(400, 105, 36, 20);
			panel.add(spinnerPies);
			
			JLabel lblPies = new JLabel("Pies");
			lblPies.setEnabled(false);
			lblPies.setBounds(442, 111, 31, 14);
			panel.add(lblPies);
			
			JSpinner spinnerPulgadas = new JSpinner();
			spinnerPulgadas.setEnabled(false);
			spinnerPulgadas.setBounds(469, 105, 36, 20);
			panel.add(spinnerPulgadas);
			
			JLabel lblPulgadas = new JLabel("Pulgadas");
			lblPulgadas.setEnabled(false);
			lblPulgadas.setBounds(515, 111, 46, 14);
			panel.add(lblPulgadas);
			
			JLabel lblPeso = new JLabel("Peso:");
			lblPeso.setEnabled(false);
			lblPeso.setBounds(315, 151, 46, 14);
			panel.add(lblPeso);
			
			JSpinner spinnerPeso = new JSpinner();
			spinnerPeso.setEnabled(false);
			spinnerPeso.setBounds(400, 145, 36, 20);
			panel.add(spinnerPeso);
			
			JLabel lblKgs = new JLabel("Kgs");
			spinnerPeso.setEnabled(false);
			lblKgs.setBounds(442, 151, 36, 14);
			panel.add(lblKgs);
			
			JLabel lblLesionado = new JLabel("Lesionado:");
			lblLesionado.setEnabled(false);
			lblLesionado.setBounds(515, 151, 68, 14);
			panel.add(lblLesionado);
			
			JComboBox comboBoxLesionado = new JComboBox();
			comboBoxLesionado.setEnabled(false);
			comboBoxLesionado.setModel(new DefaultComboBoxModel(new String[] {"NO", "SI"}));
			comboBoxLesionado.setBounds(593, 145, 59, 20);
			panel.add(comboBoxLesionado);
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
