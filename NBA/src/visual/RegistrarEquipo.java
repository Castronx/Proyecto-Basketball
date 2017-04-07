package visual;
 
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.ImageIcon;
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
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.UIManager;

import java.awt.Color;

import java.awt.GridLayout;
 
public class RegistrarEquipo extends JDialog implements Serializable {
	
	private static final long serialVersionUID = 7257619673015389543L;
		private final JPanel contentPanel = new JPanel();
        private JTextField NombreEquipo;
        private JTextField Coach;
        private JButton borrar;
        private JButton Insertar;
        private  JButton imprimir;
        private ArrayList<Team> equipos = new ArrayList<>();
        private Object[] fila;
       
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
                    addColumn("Coach");
                    addColumn("Localizacion");
                    Object object[]={new Boolean(false)};
                    addRow(object);
            }
   
}
         static JTable table = null;   
         private static JTable tablaEquipos;
         JButton button = new JButton();
         TABLE_MODEL tablem = new TABLE_MODEL();
         private JTextField localizacion;
         private JTextField estadio;

         public RegistrarEquipo() {
        	 	setResizable(false);
                CargarEquipo();
                setModal(true);
                setTitle("Registrar Equipo");
                setBounds(100, 100, 756, 501);
                getContentPane().setLayout(new BorderLayout());
                contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
                getContentPane().add(contentPanel, BorderLayout.CENTER);
                contentPanel.setLayout(null);
                JPanel panel = new JPanel();
                panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
                panel.setBounds(10, 11, 452, 148);
                contentPanel.add(panel);
                panel.setLayout(null);
               
                JLabel lblNombre = new JLabel("Nombre:");
                lblNombre.setBounds(10, 21, 57, 24);
                panel.add(lblNombre);
               
                NombreEquipo = new JTextField();
                NombreEquipo.setBounds(82, 23, 327, 20);
                panel.add(NombreEquipo);
                NombreEquipo.setColumns(10);
               
                JLabel label_1 = new JLabel("Coach:");
                label_1.setBounds(10, 113, 46, 24);
                panel.add(label_1);
               
                Coach = new JTextField();
                Coach.setBounds(82, 115, 327, 20);
                panel.add(Coach);
                Coach.setColumns(10);
               
                JLabel lblLocalizacion = new JLabel("Ciudad: ");
                lblLocalizacion.setBounds(10, 54, 78, 24);
                panel.add(lblLocalizacion);
                
                localizacion = new JTextField();
                localizacion.setBounds(82, 53, 327, 20);
                panel.add(localizacion);
                localizacion.setColumns(10);
                
                JLabel lblEstadio = new JLabel("Estadio: ");
                lblEstadio.setBounds(10, 88, 57, 14);
                panel.add(lblEstadio);
                
                estadio = new JTextField();
                estadio.setBounds(82, 84, 327, 20);
                panel.add(estadio);
                estadio.setColumns(10);
                JScrollPane scrollPane = new JScrollPane();
                scrollPane.setBounds(88, 171, 627, 214);
                contentPanel.add(scrollPane);
                scrollPane.setViewportView(tablaEquipos);
                
                JLabel lblNewLabel = new JLabel("");
                java.awt.Image image = new ImageIcon(this.getClass().getResource("/descarga.png")).getImage();
                lblNewLabel.setBounds(482, 11, 233, 148);
                contentPanel.add(lblNewLabel);
                {                      	
                	tablaEquipos.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent e) {
                        	Boolean checked=(Boolean)tablem.getValueAt(table.getSelectedRow(),0);
                            if (checked!=null && checked) {
                         	   equipos.add(Nba.getInstances().getMisEquipos().get(table.getSelectedRow()));  
                          }
                        }
                	}
                	);}
                        JPanel buttonPane = new JPanel();
                        getContentPane().add(buttonPane, BorderLayout.SOUTH);
                       
                        Insertar = new JButton("Registrar");
                        Insertar.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                	String nombreEq = NombreEquipo.getText().toString();
                                	String entrenador = Coach.getText().toString();
                                	String lugar = localizacion.getText().toString();
                                	String estadioE = estadio.getText().toString();
                                        if (NombreEquipo.getText()=="" || Coach.getText()=="" || localizacion.getText()==""||estadio.getText()=="") {
                                                JOptionPane.showMessageDialog(null, "Datos Incompletos", "Warning", JOptionPane.WARNING_MESSAGE);
                                        }
                                        else {
                                                Team equi = new Team(nombreEq, lugar, entrenador, 0, 0, estadioE);
                                                Nba.getInstances().insertarEquipo(equi);
                                                JOptionPane.showMessageDialog(null, "El equipo ha sido creado", null, JOptionPane.INFORMATION_MESSAGE, null);
                                                Clean();
                                                CargarEquipo();
                                        }
                                }
                        });
                        borrar = new JButton("Eliminar");
                        borrar.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent arg0) {
                                        int answer = JOptionPane.showConfirmDialog(null, "¿desea eliminar este equipo?",null,JOptionPane.YES_NO_OPTION);
                                if (answer == JOptionPane.YES_OPTION) {
                                        borrarEquipo();
                                        CargarEquipo();                                      
                                }
                                else {
                                        return;
                                }
                                }
                        });
                        buttonPane.setLayout(new GridLayout(0, 4, 0, 0));
                        
                        imprimir = new JButton("Imprimir");
                        imprimir.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        		 try{
          			               File file = new File("./Equipos.txt");  
          			               if(!file.exists()){
          			                   file.createNewFile();
          			               }
          			               
          			               FileWriter fw = new FileWriter(file.getAbsoluteFile());
          			               BufferedWriter bw = new BufferedWriter(fw);
          			               
          			               bw.write("\n														EQUIPOS														\n");
          			               bw.write("-----------------------------------------------------------------------------------------------------------------------------------------------\n");
          			               bw.write("\t\t\t\tNombre \t\t\tCoach \t\t\tLocacion\n");
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
                        buttonPane.add(imprimir);
                        buttonPane.add(borrar);
                        buttonPane.add(Insertar);
                        {
                                JButton cancelar = new JButton("Cancelar");
                                cancelar.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {
                                                dispose();
                                        }
                                });
                                cancelar.setActionCommand("Cancel");
                                buttonPane.add(cancelar);
                        }  
                }
        public void CargarEquipo(){
                tablem.setRowCount(0);
                fila = new Object[tablem.getColumnCount()];
                tablaEquipos= new JTable(tablem);
                tablaEquipos.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                        borrar.setEnabled(true);
                        table.setEnabled(true);
                }
        });
        tablaEquipos.getColumn("Select").setCellRenderer(new CELL_RENDERER());
        tablaEquipos.getColumn("Select").setMaxWidth(60);
        tablaEquipos.getColumn("Select").setCellEditor(new CELL_EDITOR(new JCheckBox()));
        tablaEquipos.setRowSelectionAllowed(true);
        for(Team aux : Nba.getInstances().getMisEquipos()){
			 fila[1] = aux.getNombreEquipo();
			 fila[2] = aux.getEntrenador();
			 fila[3] = aux.getCiudad();
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