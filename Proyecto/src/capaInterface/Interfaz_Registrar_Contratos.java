package capaInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import capaDatos.Validaciones;
import capaNegocios.MisMetodosDB;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Interfaz_Registrar_Contratos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNumeroContrato;
	private JTextField textCliente;
	private JTextField textInmueble;
	private JTextField textPrecioPorMes;

	/**
	 * Create the frame.
	 */
	public Interfaz_Registrar_Contratos() {
		setTitle("Registrando Contrato");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 584, 341);
		contentPane.add(tabbedPane);
		
		JPanel panelContrato = new JPanel();
		tabbedPane.addTab("Contrato", null, panelContrato, null);
		panelContrato.setLayout(null);
		
		JLabel lblNDelContrato_2 = new JLabel("N° Del contrato");
		lblNDelContrato_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNDelContrato_2.setBounds(40, 24, 150, 14);
		panelContrato.add(lblNDelContrato_2);
		
		textNumeroContrato = new JTextField();
		textNumeroContrato.setColumns(10);
		textNumeroContrato.setBounds(220, 24, 200, 20);
		panelContrato.add(textNumeroContrato);
		
		JLabel lblClienteInvolucrado_2 = new JLabel("Cliente Involucrado");
		lblClienteInvolucrado_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClienteInvolucrado_2.setBounds(40, 61, 150, 14);
		panelContrato.add(lblClienteInvolucrado_2);
		
		textCliente = new JTextField();
		textCliente.setColumns(10);
		textCliente.setBounds(220, 61, 200, 20);
		panelContrato.add(textCliente);
		
		JLabel lblInmuebleInvolucrado_2 = new JLabel("Inmueble Involucrado");
		lblInmuebleInvolucrado_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInmuebleInvolucrado_2.setBounds(40, 95, 150, 14);
		panelContrato.add(lblInmuebleInvolucrado_2);
		
		textInmueble = new JTextField();
		textInmueble.setColumns(10);
		textInmueble.setBounds(220, 97, 200, 20);
		panelContrato.add(textInmueble);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setEnabledAt(0, false);
				tabbedPane.setSelectedIndex(1);
				tabbedPane.setEnabledAt(1, true);
			}
		});
		btnContinuar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnContinuar.setBounds(10, 260, 200, 42);
		panelContrato.add(btnContinuar);
		
		JButton btnCancelar_2 = new JButton("Cancelar");
		btnCancelar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Cerramos la ventana
		        dispose();
			}
		});
		btnCancelar_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar_2.setBounds(369, 260, 200, 42);
		panelContrato.add(btnCancelar_2);
		
		JPanel panelTipo = new JPanel();
		tabbedPane.addTab("Tipo", null, panelTipo, null);
		tabbedPane.setEnabledAt(1, false);
		panelTipo.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("¿Cual es el tipo del contrato?");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(10, 40, 539, 25);
		panelTipo.add(lblNewLabel_3);
		
		JButton btnCompraventa = new JButton("Compra/Venta");
		btnCompraventa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setEnabledAt(1, false);
				tabbedPane.setSelectedIndex(2);
				tabbedPane.setEnabledAt(2, true);
			}
		});
		btnCompraventa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCompraventa.setBounds(185, 108, 200, 42);
		panelTipo.add(btnCompraventa);
		
		JButton btnAlquiler = new JButton("Alquiler");
		btnAlquiler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setEnabledAt(1, false);
				tabbedPane.setSelectedIndex(3);
				tabbedPane.setEnabledAt(3, true);
			}
		});
		btnAlquiler.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAlquiler.setBounds(185, 161, 200, 42);
		panelTipo.add(btnAlquiler);
		
		JPanel panelCompraVenta = new JPanel();
		tabbedPane.addTab("Compra/Venta", null, panelCompraVenta, null);
		tabbedPane.setEnabledAt(2, false);
		panelCompraVenta.setLayout(null);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecha.setBounds(39, 25, 127, 14);
		panelCompraVenta.add(lblFecha);
		
		JLabel lblDescripcin = new JLabel("Descripción");
		lblDescripcin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescripcin.setBounds(39, 79, 127, 14);
		panelCompraVenta.add(lblDescripcin);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Cerramos la ventana
		        dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar.setBounds(369, 260, 200, 42);
		panelCompraVenta.add(btnCancelar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(176, 65, 200, 42);
		panelCompraVenta.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(176, 25, 200, 20);
		panelCompraVenta.add(dateChooser);
		
		JPanel panelAlquiler = new JPanel();
		tabbedPane.addTab("Alquiler", null, panelAlquiler, null);
		tabbedPane.setEnabledAt(3, false);
		panelAlquiler.setLayout(null);
		
		JLabel lblFechaInicio = new JLabel("Fecha Inicio");
		lblFechaInicio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaInicio.setBounds(40, 30, 127, 14);
		panelAlquiler.add(lblFechaInicio);
		
		JLabel lblDescripcin_1 = new JLabel("Descripción");
		lblDescripcin_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescripcin_1.setBounds(40, 167, 127, 14);
		panelAlquiler.add(lblDescripcin_1);
		
		JButton btnCancelar_1 = new JButton("Cancelar");
		btnCancelar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Cerramos la ventana
		        dispose();
			}
		});
		btnCancelar_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar_1.setBounds(369, 260, 200, 42);
		panelAlquiler.add(btnCancelar_1);
		
		JDateChooser dateInicio = new JDateChooser();
		dateInicio.setBounds(177, 30, 200, 20);
		panelAlquiler.add(dateInicio);
		
		JLabel lblFechaFinal = new JLabel("Fecha Final");
		lblFechaFinal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaFinal.setBounds(40, 61, 127, 14);
		panelAlquiler.add(lblFechaFinal);
		
		JDateChooser dateFinal = new JDateChooser();
		dateFinal.setBounds(177, 61, 200, 20);
		panelAlquiler.add(dateFinal);
		
		JLabel lblNDelContrato_2_1 = new JLabel("Precio por Mes");
		lblNDelContrato_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNDelContrato_2_1.setBounds(40, 92, 127, 14);
		panelAlquiler.add(lblNDelContrato_2_1);
		
		textPrecioPorMes = new JTextField();
		textPrecioPorMes.setColumns(10);
		textPrecioPorMes.setBounds(177, 91, 173, 20);
		panelAlquiler.add(textPrecioPorMes);
		
		JLabel lblNDelContrato_2_1_1 = new JLabel("Garantia");
		lblNDelContrato_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNDelContrato_2_1_1.setBounds(40, 123, 127, 14);
		panelAlquiler.add(lblNDelContrato_2_1_1);
		
		JComboBox comboGarantia = new JComboBox();
		comboGarantia.setModel(new DefaultComboBoxModel(new String[] {"Anda", "Contaduria", "Depósito"}));
		comboGarantia.setBounds(177, 122, 173, 20);
		panelAlquiler.add(comboGarantia);
		
		JButton btnListo = new JButton("Listo");
		btnListo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!Validaciones.vacio(textNumeroContrato) && !Validaciones.vacio(textCliente) && !Validaciones.vacio(textInmueble)) {
					if (!MisMetodosDB.existeInmueble_habitable(textNumeroContrato.getText())) {
						int numeroContrato = Integer.parseInt(textNumeroContrato.getText());
						int cedulaCliente = Integer.parseInt(textCliente.getText());
						String padronInmueble = textInmueble.getText();
						String descripcion = textArea.getText();
				
						Date dateRaw = dateChooser.getDate();
						long time = dateRaw.getTime();
						java.sql.Date fecha = new java.sql.Date(time);
						
						MisMetodosDB.subirDatosContratoCompraVenta(numeroContrato, "Compra/Venta", cedulaCliente, padronInmueble, descripcion, fecha);
					}
				}
			}
		});
		btnListo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnListo.setBounds(10, 260, 200, 42);
		panelCompraVenta.add(btnListo);
		
		JButton btnListo_1 = new JButton("Listo");
		btnListo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!Validaciones.vacio(textNumeroContrato) && !Validaciones.vacio(textCliente) && !Validaciones.vacio(textInmueble)) {
					if (!MisMetodosDB.existeInmueble_habitable(textNumeroContrato.getText())) {
						int numeroContrato = Integer.parseInt(textNumeroContrato.getText());
						int cedulaCliente = Integer.parseInt(textCliente.getText());
						String padronInmueble = textInmueble.getText();
						String descripcion = textArea.getText();
						
						Date dateInicioRaw = dateInicio.getDate();
						long timeInicio = dateInicioRaw.getTime();
						java.sql.Date fechaInicio = new java.sql.Date(timeInicio);
						
						Date dateFinalRaw = dateFinal.getDate();
						long timeFinal = dateFinalRaw.getTime();
						java.sql.Date fechaFinal = new java.sql.Date(timeFinal);
						
						int precio = Integer.parseInt(textPrecioPorMes.getText());
						
						String garantia = (String) comboGarantia.getSelectedItem();
						
						MisMetodosDB.subirDatosContrato(numeroContrato, "Alquila", cedulaCliente, padronInmueble, descripcion, fechaInicio, fechaFinal, precio, garantia);
					}
				}
			}
		});
		btnListo_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnListo_1.setBounds(10, 260, 200, 42);
		panelAlquiler.add(btnListo_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(177, 153, 173, 42);
		panelAlquiler.add(scrollPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
	}
}
