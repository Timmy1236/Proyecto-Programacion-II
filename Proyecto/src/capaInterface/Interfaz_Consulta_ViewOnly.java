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

public class Interfaz_Consulta_ViewOnly extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	// Creamos la interfaz
	public Interfaz_Consulta_ViewOnly() {
		ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("icon.png"));
		setIconImage(logo.getImage());
		setResizable(false);
		setTitle("Consultar Datos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			}
		});
		brnConsultar.setBounds(815, 377, 89, 23);
		contentPane.add(brnConsultar);
		
		JButton btnConsultarContratos_1 = new JButton("Consultar Contratos");
		btnConsultarContratos_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table = MisMetodosDB.consultar(table, "SELECT * FROM Contrato;", "Contrato");
			}
		});
		btnConsultarContratos_1.setBounds(328, 11, 149, 35);
		contentPane.add(btnConsultarContratos_1);
		
		JButton btnConsultarTerrenos = new JButton("Consultar Inmueble");
		btnConsultarTerrenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table = MisMetodosDB.consultar(table, "SELECT * FROM Inmueble;", "Inmueble_Habitable");
			}
		});
		btnConsultarTerrenos.setBounds(169, 11, 149, 35);
		contentPane.add(btnConsultarTerrenos);
		
		JButton btnConsultarClientes = new JButton("Consultar Clientes");
		btnConsultarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table = MisMetodosDB.consultar(table, "SELECT * FROM Clientes;", "Clientes");
			}
		});
		btnConsultarClientes.setBounds(10, 11, 149, 35);
		contentPane.add(btnConsultarClientes);
	}
}