package capaInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import capaNegocios.MisMetodosDB;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Interfaz_Consulta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	// Creamos la interfaz
	public Interfaz_Consulta() {
		ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("icon.png"));
		setIconImage(logo.getImage());
		setResizable(false);
		setTitle("Consultar Datos");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 930, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 894, 309);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnConsultarContratos = new JButton("Salir");
		btnConsultarContratos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Cerramos la ventana
		        dispose();
			}
		});
		btnConsultarContratos.setBounds(755, 11, 149, 35);
		contentPane.add(btnConsultarContratos);
		
		JButton brnConsultar = new JButton("Consultar");
		brnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filaSeleccionada = table.getSelectedRow();
				String resultado = "";

				if (filaSeleccionada != -1) {
					for (int i = 0; i < table.getColumnCount(); i++) {
						TableColumnModel columnModel = table.getColumnModel();
						String nombreColumna = columnModel.getColumn(i).getHeaderValue().toString();
						Object dato = table.getValueAt(filaSeleccionada, i);

						// Agregar al resultado solo si el dato no es null
						if (dato != null) {
							resultado += nombreColumna + ": " + dato;

							// Agregar un salto de línea si no es la última columna
							if (i < table.getColumnCount() - 1) {
								resultado += "\n";
							}
						}
					}
					JOptionPane.showMessageDialog(null, resultado, "Datos", JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Error, no seleccionastes ninguna fila para consultar.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		brnConsultar.setBounds(815, 377, 89, 23);
		contentPane.add(brnConsultar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filaSeleccionada = table.getSelectedRow();

				if (filaSeleccionada != -1) {
					TableColumnModel columnModel = table.getColumnModel();
					String nombreColumna = columnModel.getColumn(0).getHeaderValue().toString();
					Object dato = table.getValueAt(filaSeleccionada, 0);
					Object dato2 = table.getValueAt(filaSeleccionada, 2);
					Object dato3 = table.getValueAt(filaSeleccionada, 3);
					
					System.out.println(dato);
					System.out.println(dato2);
					System.out.println(dato3);
					System.out.println(" ");
					System.out.println(nombreColumna);

					// Utilizar switch para determinar la tabla según el nombre de la columna
					String tabla = "";
					switch (nombreColumna) {
                    	case "ContratoNumero":
                    		tabla = "Contrato";
                    		
                    		if (MisMetodosDB.verificarBajaContrato(dato)) {
                    		    // El contrato no está autorizado, se puede permitir la baja.
                    		    MisMetodosDB.darBaja(nombreColumna, tabla, dato);
                    		} else {
                    		    JOptionPane.showMessageDialog(null, "No se puede dar de baja el contrato. Está autorizado.", "Error", JOptionPane.ERROR_MESSAGE);
                    		}

                        	break;
                    	case "Padron":
                    		tabla = "Inmueble";
                    		
                    		if (!MisMetodosDB.tieneContratosInmueble(dato)) {
                    		    // No hay contratos asociados con el cliente, se puede permitir la baja.
                    		    MisMetodosDB.darBaja(nombreColumna, tabla, dato);
                    		} else {
                    		    JOptionPane.showMessageDialog(null, "No se puede dar de baja el inmueble. Hay contratos asociados.", "Error", JOptionPane.ERROR_MESSAGE);
                    		}
                    		break;
                    	case "Cedula":
                    		tabla = "Clientes";
                    		
                    		if (!MisMetodosDB.tieneContratosCliente(dato)) {
                    		    // No hay contratos asociados con el cliente, se puede permitir la baja.
                    		    MisMetodosDB.darBaja(nombreColumna, tabla, dato);
                    		} else {
                    		    JOptionPane.showMessageDialog(null, "No se puede dar de baja el cliente. Hay contratos asociados.", "Error", JOptionPane.ERROR_MESSAGE);
                    		}
                    		break;
                    	default:
                    		JOptionPane.showMessageDialog(null, "Error, acaba de ocurrir un error mientras se intantaba borrar el dato.", "Error", JOptionPane.ERROR_MESSAGE);
                    		break;
					}
					
					//if (!MisMetodosDB.verificarClienteInmuebleExistente(cedula, padron)) {
					    // La combinación de cedula y padron no existe en Contrato, se puede borrar el dato.
					    //MisMetodosDB.darBaja(nombreColumna, tabla, dato);
					//} else {
					    //JOptionPane.showMessageDialog(null, "No se puede borrar el dato. Combinación Cliente/Inmueble existente en Contrato.", "Error", JOptionPane.ERROR_MESSAGE);
					//}
					
					//MisMetodosDB.darBaja(nombreColumna, tabla, dato);
				} else {
					JOptionPane.showMessageDialog(null, "Error, no seleccionastes ninguna fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEliminar.setBounds(10, 377, 89, 23);
		contentPane.add(btnEliminar);
		
		JButton btnAutorizar = new JButton("Autorizar");
		btnAutorizar.setEnabled(false);
		btnAutorizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Verificar si hay una fila seleccionada
		        int filaSeleccionada = table.getSelectedRow();
		        if (filaSeleccionada != -1) {
		            TableColumnModel columnModel = table.getColumnModel();
		            String nombreColumna = columnModel.getColumn(0).getHeaderValue().toString();
		            int dato = (int) table.getValueAt(filaSeleccionada, 0);

		            MisMetodosDB.autorizarContrato(dato);
		        } else {
		        	JOptionPane.showMessageDialog(null, "Error, no seleccionastes ningun contrato para autorizar.", "Error", JOptionPane.ERROR_MESSAGE);
		        }
			}
		});
		btnAutorizar.setBounds(716, 377, 89, 23);
		contentPane.add(btnAutorizar);
		
		JButton btnConsultarContratos_1 = new JButton("Consultar Contratos");
		btnConsultarContratos_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAutorizar.setEnabled(true);
				table = MisMetodosDB.consultar(table, "SELECT * FROM Contrato;", "Contrato");
			}
		});
		btnConsultarContratos_1.setBounds(328, 11, 149, 35);
		contentPane.add(btnConsultarContratos_1);
		
		JButton btnConsultarTerrenos = new JButton("Consultar Inmueble");
		btnConsultarTerrenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAutorizar.setEnabled(false);
				table = MisMetodosDB.consultar(table, "SELECT * FROM Inmueble;", "Inmueble_Habitable");
			}
		});
		btnConsultarTerrenos.setBounds(169, 11, 149, 35);
		contentPane.add(btnConsultarTerrenos);
		
		JButton btnConsultarClientes = new JButton("Consultar Clientes");
		btnConsultarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAutorizar.setEnabled(false);
				table = MisMetodosDB.consultar(table, "SELECT * FROM Clientes;", "Clientes");
			}
		});
		btnConsultarClientes.setBounds(10, 11, 149, 35);
		contentPane.add(btnConsultarClientes);
	}
}
