package capaInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
		setAlwaysOnTop(true);
		setTitle("Consultar Datos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 894, 330);
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
				table = MisMetodosDB.consultar(table, "SELECT * FROM Inmueble_Terreno;", "Inmueble_Terreno");
			}
		});
		btnConsultarTerrenos.setBounds(169, 11, 149, 48);
		contentPane.add(btnConsultarTerrenos);
		
		JButton btnConsultarHabitables = new JButton("Consultar Habitables");
		btnConsultarHabitables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table = MisMetodosDB.consultar(table, "SELECT * FROM Inmueble_Habitable;", "Inmueble_Habitable");
			}
		});
		btnConsultarHabitables.setBounds(328, 11, 149, 48);
		contentPane.add(btnConsultarHabitables);
		
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
		btnConsultarContratos_1.setBounds(487, 11, 149, 48);
		contentPane.add(btnConsultarContratos_1);
	}
}
