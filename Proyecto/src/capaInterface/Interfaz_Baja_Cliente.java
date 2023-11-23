package capaInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import capaNegocios.MisMetodosDB;

public class Interfaz_Baja_Cliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtBorrarCliente;
	private JTable table;
	private JButton btnEliminar;
	private JLabel lblNewLabel;

	/**
	 * Create the frame.
	 */
	public Interfaz_Baja_Cliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		table = new JTable();
		table.setBounds(10, 65, 864, 283);
		contentPane.add(table);
		
		txtBorrarCliente = new JTextField();
		txtBorrarCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtBorrarCliente.getText().isEmpty()) {
					String sentencia="SELECT Cedula,Nombre,Apellido,FechaNacimiento,Email,Telefono,Inmueble,Tipo FROM Clientes where Cedula LIKE '"+e.getKeyChar()+"%';";
					table=MisMetodosDB.cargarJTable(table, sentencia);
				}else {
				// esto lo hace para cuando pulsamos el retroceso para borrar letras
					if(e.getKeyChar()==8) {
						String sentencia="SELECT Cedula,Nombre,Apellido,FechaNacimiento,Email,Telefono,Inmueble,Tipo FROM Clientes where Cedula LIKE '"+txtBorrarCliente.getText().substring(0, txtBorrarCliente.getText().length())+"%';";
						table=MisMetodosDB.cargarJTable(table, sentencia);
					}else {
						// esto lo hace para todas las letras del JtextField 
						String sentencia="SELECT Cedula,Nombre,Apellido,FechaNacimiento,Email,Telefono,Inmueble,Tipo FROM Clientes where Cedula LIKE '"+txtBorrarCliente.getText()+e.getKeyChar()+"%';";
						table=MisMetodosDB.cargarJTable(table, sentencia);
					}
				}
			}
		});
		txtBorrarCliente.setBounds(400, 13, 170, 43);
		contentPane.add(txtBorrarCliente);
		txtBorrarCliente.setColumns(10);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filaseleccionada;
		        try{
		            //Guardamos en un entero la fila seleccionada.
		            filaseleccionada = table.getSelectedRow();
		            if (filaseleccionada == -1){
		                JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila.");
		            } else {
		                int cedula = (int)table.getValueAt(filaseleccionada, 0);
		                MisMetodosDB.darBajaCliente(cedula);
		            }
		        }catch (HeadlessException ex){
		            JOptionPane.showMessageDialog(null, "Error: "+ex+"\nInténtelo nuevamente", " .::Error En la Operacion::." ,JOptionPane.ERROR_MESSAGE);
		        } 
			}
		});
		btnEliminar.setBounds(785, 357, 89, 23);
		contentPane.add(btnEliminar);
		
		lblNewLabel = new JLabel("Escribe la cedula del cliente que deseas dar de baja:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 11, 415, 43);
		contentPane.add(lblNewLabel);
	}
}
