package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logical.Game;
import logical.Nba;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Horario extends JDialog {
	
	private Nba liga;
	Object[] fila;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JButton jugar;
	private JButton imprimir;
	private JButton cerrar;
	public DefaultTableModel tableModel;
	
	public Horario() {
		setTitle("Horario");
		setBounds(100, 100, 599, 395);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(10, 312, 563, 33);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton imprimir = new JButton("Imprimir");
				imprimir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try{
							File file = new File("./Horario.txt");
							if(!file.exists()){
								file.createNewFile();
							}
							
							FileWriter fw = new FileWriter(file.getAbsoluteFile());
							BufferedWriter bw = new BufferedWriter(fw);
							
							   bw.write("\n								HORARIO DE PARTIDOS\n");
				               bw.write("-----------------------------------------------------------------------------------------\n");
				               bw.write("Fecha \t\t\t\tTiempo \t\t\t\tAway team \t\t\t\tHome team\n");
				               bw.write("-----------------------------------------------------------------------------------------\n");
				               for(int i = 0; i < table.getRowCount(); i++){
				                  
				                   for(int j = 0; j < table.getColumnCount(); j++){
				                       bw.write(table.getModel().getValueAt(i, j)+"			 ");
				                     
				                   }
				                   bw.write("\n");
				               }
				               bw.write("-----------------------------------------------------------------------------------------");;
				               bw.close();
				               fw.close();
				               JOptionPane.showMessageDialog(null, "Horario Imprimido!");
						}
						       catch(Exception except){
						    	   except.printStackTrace();
						       }
					}
				});
				imprimir.setBounds(366, 5, 98, 23);
				buttonPane.add(imprimir);
			}
			{
				cerrar = new JButton("Cerrar");
				cerrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cerrar.setBounds(474, 5, 79, 23);
				cerrar.setActionCommand("Cancel");
				buttonPane.add(cerrar);
			}
			jugar = new JButton("Jugar");
			jugar.setEnabled(false);
			jugar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JugarPartido juga = new JugarPartido();
					juga.setVisible(true);
					setLocationRelativeTo(null);
				}
			});
			jugar.setBounds(267, 5, 89, 23);
			buttonPane.add(jugar);
		}
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 563, 290);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				jugar.setEnabled(true);
			}
		});
		scrollPane.setViewportView(table);
		{
			tableModel = new DefaultTableModel(new Object[][] {}, new String[] {"Fecha", "Tiempo", "Equipo Local","Equipo visitante"}				
			);
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(125);
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		table.getColumnModel().getColumn(2).setPreferredWidth(135);
		table.getColumnModel().getColumn(3).setPreferredWidth(135);
		try {
			cargarJuego();
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e){
			e.printStackTrace();
		}
		}
	}
	public void cargarJuego() throws IOException, ClassNotFoundException {
		tableModel.setRowCount(0);
		fila = new Object[tableModel.getColumnCount()];
		for (Game aux : Nba.getInstances().getPartido()) {
			fila[0] = aux.getFecha();
			fila[1] = aux.getHora();
			fila[2] = aux.getEquipoLocal();
			fila[3] = aux.getEquipoVisitante();
			tableModel.addRow(fila);
		}
		table.setModel(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(125);
		columnModel.getColumn(1).setPreferredWidth(110);
		columnModel.getColumn(2).setPreferredWidth(135);
		columnModel.getColumn(3).setPreferredWidth(125);
	}
}
