package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class OptionGame extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static void main(String[] args) {
		try {
			OptionGame dialog = new OptionGame();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public OptionGame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(OptionGame.class.getResource("/images/descarga (2).png")));
		setTitle("Juego");
		setBounds(100, 100, 352, 226);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(OptionGame.class.getResource("/images/WhyWePlay.png")));
		lblNewLabel.setBounds(0, 0, 330, 142);
		contentPanel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Registrar partido");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarPartido reg = new RegistrarPartido();
				reg.setVisible(true);
			}
		});
		btnNewButton.setBounds(0, 149, 164, 34);
		contentPanel.add(btnNewButton);
		
		JButton btnPlayGame = new JButton("Jugar partido");
		btnPlayGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Horario jug = new Horario();
				jug.setVisible(true);
			}
		});
		btnPlayGame.setBounds(166, 149, 164, 34);
		contentPanel.add(btnPlayGame);
	}
}
