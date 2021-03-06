package visual;
 
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logical.Nba;
import logical.Team;

import javax.swing.JTable;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.table.TableCellRenderer;
//import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.UIManager;

import java.awt.Color;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
 
public class RegistrarEquipo extends JDialog implements Serializable {
	
	private static final long serialVersionUID = 7257619673015389543L;
		private final JPanel contentPanel = new JPanel();
        private JTextField NombreEquipo;
        private JTextField Coach;
        private ArrayList<Team> equipos = new ArrayList<>();
        private Object[] fila;
        private JTextField localizacion;
        private JTextField estadio;
        private String nombreEquipo;
        private JButton eliminar;
        private JButton modificar;
        
        private class CELL_RENDERER extends JCheckBox implements TableCellRenderer{
			private static final long serialVersionUID = -82726668020420698L;
				public CELL_RENDERER(){
                    setHorizontalAlignment(JLabel.CENTER);
                }
                public Component getTableCellRendererComponent(JTable arg0, Object value, boolean arg2, boolean arg3, int arg4, int arg5) {
                    setSelected((value != null && ((Boolean) value).booleanValue()));
                    setBackground(arg0.getBackground());
                    setHorizontalAlignment(JLabel.CENTER);
                    return this;
                }
            }
         	private class CELL_EDITOR extends DefaultCellEditor{
				private static final long serialVersionUID = 3727661195130308862L;
				public CELL_EDITOR(JCheckBox checkBox) {
                    super(checkBox);
                    checkBox.setHorizontalAlignment(JLabel.CENTER);    
                }
            }
        public class TABLE_MODEL extends DefaultTableModel{  
			private static final long serialVersionUID = -6335799403628701645L;
				public TABLE_MODEL(){
                    addColumn("Select");
                    addColumn("Nombre");
                    addColumn("Ciudad");
                    addColumn("Estadio");
                    addColumn("Coach");
                    Object object[]={new Boolean(false)};
                    addRow(object);
            }
        }
         static JTable table = new JTable();   
         private static JTable tablaEquipos = new JTable();
         JButton button = new JButton();
         TABLE_MODEL tablem = new TABLE_MODEL();
       
         public RegistrarEquipo() {
         	setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrarEquipo.class.getResource("/images/images.png")));
        	 	setResizable(false);
                CargarEquipo();
                setModal(true);
                setTitle("Registrar Equipo");
                setBounds(100, 100, 731, 561);
                getContentPane().setLayout(new BorderLayout());
                contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
                getContentPane().add(contentPanel, BorderLayout.CENTER);
                contentPanel.setLayout(null);
                JPanel panel = new JPanel();
                panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
                panel.setBounds(10, 11, 468, 190);
                contentPanel.add(panel);
                panel.setLayout(null);
               
                JLabel lblNombre = new JLabel("Nombre:");
                lblNombre.setBounds(10, 21, 57, 24);
                panel.add(lblNombre);
               
                NombreEquipo = new JTextField();
                NombreEquipo.setBounds(82, 23, 376, 20);
                panel.add(NombreEquipo);
                NombreEquipo.setColumns(10);
               
                JLabel label_1 = new JLabel("Coach:");
                label_1.setBounds(10, 122, 46, 24);
                panel.add(label_1);
               
                Coach = new JTextField();
                Coach.setBounds(82, 124, 376, 20);
                panel.add(Coach);
                Coach.setColumns(10);
               
                JLabel lblLocalizacion = new JLabel("Ciudad: ");
                lblLocalizacion.setBounds(10, 56, 78, 24);
                panel.add(lblLocalizacion);
                
                localizacion = new JTextField();
                localizacion.setBounds(82, 58, 376, 20);
                panel.add(localizacion);
                localizacion.setColumns(10);
                
                JLabel lblEstadio = new JLabel("Estadio: ");
                lblEstadio.setBounds(10, 95, 57, 14);
                panel.add(lblEstadio);
                
                estadio = new JTextField();
                estadio.setBounds(82, 91, 376, 20);
                panel.add(estadio);
                estadio.setColumns(10);
                JScrollPane scrollPane = new JScrollPane();
                scrollPane.setBounds(10, 229, 705, 258);
                contentPanel.add(scrollPane);
                scrollPane.setViewportView(tablaEquipos);
                
                JButton Cancelar = new JButton("Cancelar");
                Cancelar.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		dispose();
                	}
                });
                Cancelar.setBounds(626, 498, 89, 23);
                contentPanel.add(Cancelar);
                
                JButton registrar = new JButton("Registrar");
                registrar.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		String nombreEq = NombreEquipo.getText().toString();
                    	String entrenador = Coach.getText().toString();
                    	String lugar = localizacion.getText().toString();
                    	String estadioE = estadio.getText().toString();
                            if (NombreEquipo.getText().isEmpty() || Coach.getText().isEmpty() || localizacion.getText().isEmpty()||estadio.getText().isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "Datos Incompletos", "Warning", JOptionPane.WARNING_MESSAGE);
                            }
                            else {
                                    Team equi = new Team(nombreEq, lugar, entrenador, 0, 0, estadioE);
                                    Nba.getInstances().insertarEquipo(equi);
                                    JOptionPane.showMessageDialog(null, "El equipo ha sido creado exitosamente.", null, JOptionPane.INFORMATION_MESSAGE, null);
                                    Clean();
                                    CargarEquipo();
                            }
                    }
                });
                registrar.setBounds(527, 498, 89, 23);
                contentPanel.add(registrar);
                
                eliminar = new JButton("Eliminar");
                eliminar.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		int answer = JOptionPane.showConfirmDialog(null, "�Desea eliminar este equipo?",null,JOptionPane.YES_NO_OPTION);
                        if (answer == JOptionPane.YES_OPTION) {
                                borrarEquipo();
                                CargarEquipo();                                      
                        }
                        else {
                                return;
                        }
                	}
                });
                eliminar.setBounds(428, 498, 89, 23);
                contentPanel.add(eliminar);
                
                modificar = new JButton("Modificar");
                modificar.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		modificarEquipo();
                		eliminar.setEnabled(false);
                		tablaEquipos.setEnabled(false);
                		modificar.setEnabled(false);
                	}
                });
                modificar.setBounds(329, 498, 89, 23);
                contentPanel.add(modificar);
                
                JButton Imprimir = new JButton("Imprimir");
                Imprimir.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		try{
   			               File file = new File("./Equipos.txt");  
   			               if(!file.exists()){
   			                   file.createNewFile();
   			               }
   			               FileWriter fw = new FileWriter(file.getAbsoluteFile());
   			               BufferedWriter bw = new BufferedWriter(fw);
   			               
   			               bw.write("\n														Listado de equipos													\n");
   			               bw.write("-----------------------------------------------------------------------------------------------------------------------------------------------\n");
   			               bw.write("\t\t\t\tNombre \t\t\tCiudad \t\t\tEstadio \t\t\tCoach\n");
   			             bw.write("-----------------------------------------------------------------------------------------------------------------------------------------------\n");
   			               for(int i = 0; i < tablaEquipos.getRowCount(); i++){
   			                   for(int j = 0; j < tablaEquipos.getColumnCount(); j++){
   			                       bw.write(tablaEquipos.getModel().getValueAt(i, j)+"			 ");
   			                   }
   			                   bw.write("\n");
   			               }
   			             bw.write("-----------------------------------------------------------------------------------------------------------------------------------------------\n");
   			               bw.close();
   			               fw.close();
   			               JOptionPane.showMessageDialog(null, "Lista de equipos impresa!");
   			               }catch(Exception ex){
   			                   ex.printStackTrace();
   			               }
                 	}
                });
                Imprimir.setBounds(230, 498, 89, 23);
                contentPanel.add(Imprimir);
                
                JLabel lblNewLabel = new JLabel("");
                lblNewLabel.setIcon(new ImageIcon(RegistrarEquipo.class.getResource("/images/descarga.png")));
                lblNewLabel.setBounds(488, 11, 227, 190);
                contentPanel.add(lblNewLabel);
                {                      	
                	tablaEquipos.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent e) {
                        	if(table.getSelectedRow()>=0){
        						int index = table.getSelectedRow();
        						nombreEquipo = (String)table.getModel().getValueAt(index, 0);	
        						System.out.println(""+index);
        					}
                        }
                	}
                	);}
                        JPanel buttonPane = new JPanel();
                        getContentPane().add(buttonPane, BorderLayout.SOUTH);
                        buttonPane.setLayout(new GridLayout(0, 4, 0, 0));
                }
        public void CargarEquipo(){
                tablem.setRowCount(0);
                fila = new Object[tablem.getColumnCount()];
                tablaEquipos= new JTable(tablem);
                tablaEquipos.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                        eliminar.setEnabled(true);
                        modificar.setEnabled(true);
                }
        });
        tablaEquipos.getColumn("Select").setCellRenderer(new CELL_RENDERER());
        tablaEquipos.getColumn("Select").setMaxWidth(60);
        tablaEquipos.getColumn("Select").setCellEditor(new CELL_EDITOR(new JCheckBox()));
        tablaEquipos.setRowSelectionAllowed(true);
        for(Team aux : Nba.getInstances().getMisEquipos()){
			 fila[1] = aux.getNombreEquipo();
			 fila[2] = aux.getCiudad();
			 fila[3] = aux.getEstadio();
			 fila[4] = aux.getEntrenador();
			 tablem.addRow(fila);
		}
		tablaEquipos.setModel(tablem);
		tablaEquipos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tablaEquipos.getTableHeader().setReorderingAllowed(false);

		TableColumnModel modeloColumna = tablaEquipos.getColumnModel();
		modeloColumna.getColumn(0).setPreferredWidth(50);
		modeloColumna.getColumn(1).setPreferredWidth(190);
		modeloColumna.getColumn(2).setPreferredWidth(180);
		modeloColumna.getColumn(3).setPreferredWidth(200);
	}
        public void modificarEquipo() {          
                String NombEqui = (String) tablem.getValueAt(tablaEquipos.getSelectedRow(), 1);
                String Localiza = (String) tablem.getValueAt(tablaEquipos.getSelectedRow(), 2);
                String estadiop = (String) tablem.getValueAt(tablaEquipos.getSelectedRow(), 3);
                String HeadCoach = (String) tablem.getValueAt(tablaEquipos.getSelectedRow(), 4);
            
                NombreEquipo.setText(NombEqui);
                localizacion.setText(Localiza);
                estadio.setText(estadiop);
                Coach.setText(HeadCoach);
                borrarEquipo();
        }
        public void borrarEquipo(){
        	int temp = 0;
        	for (int i = 0; i < Nba.getInstances().getMisEquipos().size(); i++) {
        		    for (int j = 0; j < equipos.size(); j++) {
						if (equipos.get(j).getNombreEquipo().equalsIgnoreCase(Nba.getInstances().getMisEquipos().get(i).getNombreEquipo())) {
							Nba.getInstances().getMisEquipos().remove(i);
							temp = i;
						}
					}
        	}
        	Nba.getInstances().getMisEquipos().remove(temp);
        	tablem.fireTableDataChanged();
        }
        private void Clean() {
                NombreEquipo.setText("");
                Coach.setText("");
                localizacion.setText("");
                estadio.setText("");
        }
 }