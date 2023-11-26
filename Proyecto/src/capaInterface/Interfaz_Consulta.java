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
		setResizable(false);
		setTitle("Consultar Datos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 894, 296);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnConsultarClientes = new JButton("Consultar Clientes");
		btnConsultarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table = MisMetodosDB.consultar(table, "SELECT * FROM Clientes;", "Clientes");
			}
		});
		btnConsultarClientes.setBounds(10, 11, 149, 48);
		contentPane.add(btnConsultarClientes);
		
		JButton btnConsultarTerrenos = new JButton("Consultar Terrenos");
		btnConsultarTerrenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table = MisMetodosDB.consultar(table, "SELECT * FROM Inmueble;", "Inmueble_Habitable");
			}
		});
		btnConsultarTerrenos.setBounds(169, 11, 149, 48);
		contentPane.add(btnConsultarTerrenos);
		
		JButton btnConsultarContratos = new JButton("Salir");
		btnConsultarContratos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Cerramos la ventana
		        dispose();
			}
		});
		btnConsultarContratos.setBounds(755, 11, 149, 48);
		contentPane.add(btnConsultarContratos);
		
		JButton btnConsultarContratos_1 = new JButton("Consultar Contratos");
		btnConsultarContratos_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table = MisMetodosDB.consultar(table, "SELECT * FROM Contrato;", "Contrato");
			}
		});
		btnConsultarContratos_1.setBounds(328, 11, 149, 48);
		contentPane.add(btnConsultarContratos_1);
		
		JButton brnConsultar = new JButton("Consultar");
		brnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filaSeleccionada = table.getSelectedRow();
				String resultado = "";

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

                // Imprimir el resultado
                System.out.println(resultado);
                
                JOptionPane.showMessageDialog(null, resultado, "Datos", JOptionPane.PLAIN_MESSAGE);
			}
		});
		brnConsultar.setBounds(815, 377, 89, 23);
		contentPane.add(brnConsultar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filaSeleccionada = table.getSelectedRow();

                TableColumnModel columnModel = table.getColumnModel();
                String nombreColumna = columnModel.getColumn(0).getHeaderValue().toString();
                Object dato = table.getValueAt(filaSeleccionada, 0);

                // Utilizar switch para determinar la tabla según el nombre de la columna
                String tabla = "";
                switch (nombreColumna) {
                    case "Numero Contrato":
                        tabla = "Contrato";
                        break;
                    case "Padron":
                        tabla = "Inmueble";
                        break;
                    case "Cedula":
                    	tabla = "Clientes";
                    	break;
                    default:
                    	JOptionPane.showMessageDialog(null, "Error, acaba de ocurrir un error mientras se intantaba borrar el dato.", "Error", JOptionPane.ERROR_MESSAGE);
                    	break;
                }
                MisMetodosDB.darBaja(nombreColumna, tabla, dato);
			}
		});
		btnEliminar.setBounds(716, 377, 89, 23);
		contentPane.add(btnEliminar);
	}
}
