package capaInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import capaNegocios.MisMetodosDB;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interfaz_Baja_Inmueble extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableTerreno;
	private JTextField textPadronTerreno;
	private JTable tableHabitable;
	private JTextField textPadronHabitable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz_Baja_Inmueble frame = new Interfaz_Baja_Inmueble();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interfaz_Baja_Inmueble() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 864, 369);
		contentPane.add(tabbedPane);
		
		JPanel panelSeleccionar = new JPanel();
		tabbedPane.addTab("Seleccionar", null, panelSeleccionar, null);
		panelSeleccionar.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("¿Cual es el tipo del inmueble que deseas borrar de la base de datos?");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(10, 11, 839, 34);
		panelSeleccionar.add(lblNewLabel_2);
		
		JComboBox inmuebleOpciones = new JComboBox();
		inmuebleOpciones.setModel(new DefaultComboBoxModel(new String[] {"Terreno", "Habitable"}));
		inmuebleOpciones.setBounds(355, 56, 130, 22);
		panelSeleccionar.add(inmuebleOpciones);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Si el usuario presiona el boton de continuar, agarremos el item actual seleccionado en JComboBox
				String opcion = (String) inmuebleOpciones.getSelectedItem();
				
				// Dependiendo de que item fue seleccionado, activamos el panel de la opcion. Si es Ceo, activamos panel del Ceo.
				switch(opcion) {
				case "Terreno":
					tabbedPane.setEnabledAt(0, false);
					tabbedPane.setSelectedIndex(1);
					tabbedPane.setEnabledAt(1, true);
					break;
				
				case "Habitable":
					tabbedPane.setEnabledAt(0, false);
					tabbedPane.setSelectedIndex(2);
					tabbedPane.setEnabledAt(2, true);
					break;
				}
			}
		});
		btnContinuar.setBounds(378, 89, 89, 23);
		panelSeleccionar.add(btnContinuar);
		
		JPanel panelTerreno = new JPanel();
		tabbedPane.addTab("Terreno", null, panelTerreno, null);
		tabbedPane.setEnabledAt(1, false);
		panelTerreno.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingrese el Padron del terreno que deseas eliminar del sistema");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 425, 32);
		panelTerreno.add(lblNewLabel);
		
		tableTerreno = new JTable();
		tableTerreno.setBounds(10, 54, 839, 255);
		panelTerreno.add(tableTerreno);
		
		textPadronTerreno = new JTextField();
		textPadronTerreno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (textPadronTerreno.getText().isEmpty()) {
					String sentencia="SELECT Padron,Ubicacion,Valor,Tamaño,Servicios FROM Inmueble_Terreno where Padron LIKE '"+e.getKeyChar()+"%';";
					tableTerreno=MisMetodosDB.cargarInmueblesTerrenoTable(tableTerreno, sentencia);
				}else {
				// esto lo hace para cuando pulsamos el retroceso para borrar letras
					if(e.getKeyChar()==8) {
						String sentencia="SELECT Padron,Ubicacion,Valor,Tamaño,Servicios FROM Inmueble_Terreno where Padron LIKE '"+textPadronTerreno.getText().substring(0, textPadronTerreno.getText().length())+"%';";
						tableTerreno=MisMetodosDB.cargarInmueblesTerrenoTable(tableTerreno, sentencia);
					}else {
						// esto lo hace para todas las letras del JtextField 
						String sentencia="SELECT Padron,Ubicacion,Valor,Tamaño,Servicios FROM Inmueble_Terreno where Padron LIKE '"+textPadronTerreno.getText()+e.getKeyChar()+"%';";
						tableTerreno=MisMetodosDB.cargarInmueblesTerrenoTable(tableTerreno, sentencia);
					}
				}
			}
		});
		textPadronTerreno.setBounds(445, 13, 145, 32);
		panelTerreno.add(textPadronTerreno);
		textPadronTerreno.setColumns(10);
		
		JButton btnBajaTerreno = new JButton("Dar Baja");
		btnBajaTerreno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filaseleccionada;
		        try{
		            //Guardamos en un entero la fila seleccionada.
		            filaseleccionada = tableTerreno.getSelectedRow();
		            if (filaseleccionada == -1){
		                JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila.");
		            } else {
		                String Padron = (String)tableTerreno.getValueAt(filaseleccionada, 0);
		                MisMetodosDB.darBajaTerreno(Padron);
		            }
		        }catch (HeadlessException ex){
		            JOptionPane.showMessageDialog(null, "Error: "+ex+"\nInténtelo nuevamente", " .::Error En la Operacion::." ,JOptionPane.ERROR_MESSAGE);
		        } 
			}
		});
		btnBajaTerreno.setBounds(770, 318, 89, 23);
		panelTerreno.add(btnBajaTerreno);
		
		JPanel panelHabitable = new JPanel();
		tabbedPane.addTab("Habitable", null, panelHabitable, null);
		tabbedPane.setEnabledAt(2, false);
		panelHabitable.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese el Padron del terreno que deseas eliminar del sistema");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 11, 398, 32);
		panelHabitable.add(lblNewLabel_1);
		
		tableHabitable = new JTable();
		tableHabitable.setBounds(10, 54, 839, 255);
		panelHabitable.add(tableHabitable);
		
		textPadronHabitable = new JTextField();
		textPadronHabitable.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (textPadronTerreno.getText().isEmpty()) {
					String sentencia="SELECT Padron,Ubicacion,Valor,Tamaño,Tipo,Baños,Cuartos,Cocina,Comedor,Living,Hall,Garaje,Gimnasio,Piscina,Sauna,Barbacoa,Churrasquera FROM Inmueble_Habitable where Padron LIKE '"+e.getKeyChar()+"%';";
					tableTerreno=MisMetodosDB.cargarInmueblesHabitableTable(tableHabitable, sentencia);
				}else {
				// esto lo hace para cuando pulsamos el retroceso para borrar letras
					if(e.getKeyChar()==8) {
						String sentencia="SELECT Padron,Ubicacion,Valor,Tamaño,Tipo,Baños,Cuartos,Cocina,Comedor,Living,Hall,Garaje,Gimnasio,Piscina,Sauna,Barbacoa,Churrasquera FROM Inmueble_Habitable where Padron LIKE '"+textPadronTerreno.getText().substring(0, textPadronTerreno.getText().length())+"%';";
						tableTerreno=MisMetodosDB.cargarInmueblesHabitableTable(tableHabitable, sentencia);
					}else {
						// esto lo hace para todas las letras del JtextField 
						String sentencia="SELECT Padron,Ubicacion,Valor,Tamaño,Tipo,Baños,Cuartos,Cocina,Comedor,Living,Hall,Garaje,Gimnasio,Piscina,Sauna,Barbacoa,Churrasquera FROM Inmueble_Habitable where Padron LIKE '"+textPadronTerreno.getText()+e.getKeyChar()+"%';";
						tableTerreno=MisMetodosDB.cargarInmueblesHabitableTable(tableHabitable, sentencia);
					}
				}
			}
		});
		textPadronHabitable.setColumns(10);
		textPadronHabitable.setBounds(437, 13, 136, 32);
		panelHabitable.add(textPadronHabitable);
		
		JButton btnBajaHabitable = new JButton("Dar Baja");
		btnBajaHabitable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filaseleccionada;
		        try{
		            //Guardamos en un entero la fila seleccionada.
		            filaseleccionada = tableTerreno.getSelectedRow();
		            if (filaseleccionada == -1){
		                JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila.");
		            } else {
		                String Padron = (String)tableHabitable.getValueAt(filaseleccionada, 0);
		                MisMetodosDB.darBajaHabitable(Padron);
		            }
		        }catch (HeadlessException ex){
		            JOptionPane.showMessageDialog(null, "Error: "+ex+"\nInténtelo nuevamente", " .::Error En la Operacion::." ,JOptionPane.ERROR_MESSAGE);
		        } 
			}
		});
		btnBajaHabitable.setBounds(770, 318, 89, 23);
		panelHabitable.add(btnBajaHabitable);
	}
}
