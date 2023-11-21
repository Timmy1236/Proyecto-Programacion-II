package capaInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JSpinner;
import java.awt.Component;
import javax.swing.Box;

import capaNegocios.MisMetodosDB;

public class Interfaz_Registrar_Inmuebles extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNDePadron;
	private JTextField textUbicacion;
	private JTextField textTamano;
	private JTextField textServicios;
	private JTextField textTamañoHabitable;
	private JTextField textValor;

	/**
	 * Create the frame.
	 */
	public Interfaz_Registrar_Inmuebles() {
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("Registrador de Inmuebles");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 414, 289);
		contentPane.add(tabbedPane);
		
		JPanel panelInmueble = new JPanel();
		tabbedPane.addTab("Inmueble", null, panelInmueble, null);
		tabbedPane.setEnabledAt(0, true);
		panelInmueble.setLayout(null);
		
		JLabel lblNDePadron = new JLabel("N° de Padron");
		lblNDePadron.setBounds(32, 52, 127, 14);
		panelInmueble.add(lblNDePadron);
		
		JLabel lblUbicacindepartamentoCalle = new JLabel("Ubicación");
		lblUbicacindepartamentoCalle.setBounds(32, 77, 127, 14);
		panelInmueble.add(lblUbicacindepartamentoCalle);
		
		textNDePadron = new JTextField();
		textNDePadron.setColumns(10);
		textNDePadron.setBounds(169, 49, 200, 20);
		panelInmueble.add(textNDePadron);
		
		textUbicacion = new JTextField();
		textUbicacion.setColumns(10);
		textUbicacion.setBounds(169, 74, 200, 20);
		panelInmueble.add(textUbicacion);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Cerramos la ventana
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar.setBounds(170, 208, 200, 42);
		panelInmueble.add(btnCancelar);
		
		JLabel lblNewLabel_1 = new JLabel("Departamento, calle y nº de puerta");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_1.setBounds(169, 94, 200, 14);
		panelInmueble.add(lblNewLabel_1);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setEnabledAt(0, false);
				tabbedPane.setSelectedIndex(1);
				tabbedPane.setEnabledAt(1, true);
			}
		});
		btnContinuar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnContinuar.setBounds(170, 155, 200, 42);
		panelInmueble.add(btnContinuar);
		
		JLabel lblValordolares = new JLabel("Valor (Dolares)");
		lblValordolares.setBounds(32, 115, 127, 14);
		panelInmueble.add(lblValordolares);
		
		textValor = new JTextField();
		textValor.setColumns(10);
		textValor.setBounds(169, 112, 200, 20);
		panelInmueble.add(textValor);
		
		JPanel panelTipo = new JPanel();
		tabbedPane.addTab("Tipo", null, panelTipo, null);
		tabbedPane.setEnabledAt(1, false);
		panelTipo.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("¿Cual es el tipo del inmueble?");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(10, 37, 389, 20);
		panelTipo.add(lblNewLabel_3);
		
		JButton btnTerreno = new JButton("Terreno");
		btnTerreno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setEnabledAt(1, false);
				tabbedPane.setSelectedIndex(2);
				tabbedPane.setEnabledAt(2, true);
			}
		});
		btnTerreno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTerreno.setBounds(104, 95, 200, 42);
		panelTipo.add(btnTerreno);
		
		JButton btnHabitable = new JButton("Habitable");
		btnHabitable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setEnabledAt(1, false);
				tabbedPane.setSelectedIndex(3);
				tabbedPane.setEnabledAt(3, true);
			}
		});
		btnHabitable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHabitable.setBounds(104, 148, 200, 42);
		panelTipo.add(btnHabitable);
		
		JPanel panelTerreno = new JPanel();
		tabbedPane.addTab("Terreno", null, panelTerreno, null);
		tabbedPane.setEnabledAt(2, false);
		panelTerreno.setLayout(null);
		
		JLabel lblTamaoenM = new JLabel("Tamaño (en m2)");
		lblTamaoenM.setBounds(33, 59, 127, 14);
		panelTerreno.add(lblTamaoenM);
		
		JLabel lblServicios = new JLabel("Servicios (OSE, UTE, etc.)");
		lblServicios.setBounds(33, 84, 127, 14);
		panelTerreno.add(lblServicios);
		
		textTamano = new JTextField();
		textTamano.setColumns(10);
		textTamano.setBounds(170, 56, 200, 20);
		panelTerreno.add(textTamano);
		
		textServicios = new JTextField();
		textServicios.setColumns(10);
		textServicios.setBounds(170, 81, 200, 20);
		panelTerreno.add(textServicios);
		
		JButton btnCancelar_1 = new JButton("Cancelar");
		btnCancelar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Cerramos la ventana
				dispose();
			}
		});
		btnCancelar_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar_1.setBounds(170, 208, 200, 42);
		panelTerreno.add(btnCancelar_1);
		
		JPanel panelHabitable = new JPanel();
		tabbedPane.addTab("Habitable", null, panelHabitable, null);
		tabbedPane.setEnabledAt(3, false);
		panelHabitable.setLayout(null);
		
		JLabel lblTamaoenM_1 = new JLabel("Tamaño (en m2)");
		lblTamaoenM_1.setBounds(32, 14, 127, 14);
		panelHabitable.add(lblTamaoenM_1);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(32, 39, 127, 14);
		panelHabitable.add(lblTipo);
		
		textTamañoHabitable = new JTextField();
		textTamañoHabitable.setColumns(10);
		textTamañoHabitable.setBounds(169, 11, 200, 20);
		panelHabitable.add(textTamañoHabitable);
		
		JButton btnCancelar_1_1 = new JButton("Cancelar");
		btnCancelar_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Cerramos la ventana
				dispose();
			}
		});
		btnCancelar_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar_1_1.setBounds(209, 208, 190, 42);
		panelHabitable.add(btnCancelar_1_1);
		
		JComboBox tipoOpciones = new JComboBox();
		tipoOpciones.setModel(new DefaultComboBoxModel(new String[] {"Casa", "Departamento", "Mejoras"}));
		tipoOpciones.setBounds(169, 35, 200, 22);
		panelHabitable.add(tipoOpciones);
		
		JLabel lblNewLabel = new JLabel("Cantidad de habitaciones cada uno");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(32, 83, 337, 14);
		panelHabitable.add(lblNewLabel);
		
		JLabel lblCuartos = new JLabel("Cuartos");
		lblCuartos.setBounds(10, 108, 65, 14);
		panelHabitable.add(lblCuartos);
		
		JLabel lblCocina = new JLabel("Cocina");
		lblCocina.setBounds(10, 133, 65, 14);
		panelHabitable.add(lblCocina);
		
		JLabel lblComedor = new JLabel("Comedor");
		lblComedor.setBounds(10, 158, 65, 14);
		panelHabitable.add(lblComedor);
		
		JSpinner spinnerCuartos = new JSpinner();
		spinnerCuartos.setBounds(85, 102, 30, 20);
		panelHabitable.add(spinnerCuartos);
		
		JSpinner spinnerCocina = new JSpinner();
		spinnerCocina.setBounds(85, 127, 30, 20);
		panelHabitable.add(spinnerCocina);
		
		JSpinner spinnerComedor = new JSpinner();
		spinnerComedor.setBounds(85, 152, 30, 20);
		panelHabitable.add(spinnerComedor);
		
		JLabel lblLiving = new JLabel("Living");
		lblLiving.setBounds(10, 183, 65, 14);
		panelHabitable.add(lblLiving);
		
		JSpinner spinnerLiving = new JSpinner();
		spinnerLiving.setBounds(85, 177, 30, 20);
		panelHabitable.add(spinnerLiving);
		
		JLabel lblHall = new JLabel("Hall");
		lblHall.setBounds(147, 108, 65, 14);
		panelHabitable.add(lblHall);
		
		JSpinner spinnerHall = new JSpinner();
		spinnerHall.setBounds(222, 102, 30, 20);
		panelHabitable.add(spinnerHall);
		
		JLabel lblGaraje = new JLabel("Garaje");
		lblGaraje.setBounds(147, 133, 65, 14);
		panelHabitable.add(lblGaraje);
		
		JSpinner spinnerGaraje = new JSpinner();
		spinnerGaraje.setBounds(222, 127, 30, 20);
		panelHabitable.add(spinnerGaraje);
		
		JLabel lblPiscina = new JLabel("Piscina");
		lblPiscina.setBounds(147, 158, 65, 14);
		panelHabitable.add(lblPiscina);
		
		JSpinner spinnerPiscina = new JSpinner();
		spinnerPiscina.setBounds(222, 152, 30, 20);
		panelHabitable.add(spinnerPiscina);
		
		JLabel lblSauna = new JLabel("Sauna");
		lblSauna.setBounds(278, 158, 81, 14);
		panelHabitable.add(lblSauna);
		
		JSpinner spinnerSauna = new JSpinner();
		spinnerSauna.setBounds(369, 152, 30, 20);
		panelHabitable.add(spinnerSauna);
		
		JLabel lblBarbacoa = new JLabel("Barbacoa");
		lblBarbacoa.setBounds(278, 108, 81, 14);
		panelHabitable.add(lblBarbacoa);
		
		JLabel lblChurrasquera = new JLabel("Churrasquera");
		lblChurrasquera.setBounds(278, 133, 81, 14);
		panelHabitable.add(lblChurrasquera);
		
		JSpinner spinnerBarbacoa = new JSpinner();
		spinnerBarbacoa.setBounds(369, 102, 30, 20);
		panelHabitable.add(spinnerBarbacoa);
		
		JSpinner spinnerChurrasquera = new JSpinner();
		spinnerChurrasquera.setBounds(369, 127, 30, 20);
		panelHabitable.add(spinnerChurrasquera);
		
		// !!: Dejar los eventos/botones siempre debajo de todo para evitar errores ;)
		
		// Terreno
		JButton btnTerminar = new JButton("Terminar");
		btnTerminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Datos del primer tab (Inmueble)
				int padron = Integer.parseInt(textNDePadron.getText());
				String ubicacion = textUbicacion.getText();
				int valor = Integer.parseInt(textValor.getText());
				
				// Datos del tab "Terreno"
				int tamaño = Integer.parseInt(textTamano.getText());
				String servicios = textServicios.getText();

				MisMetodosDB.registrarTerreno(padron, ubicacion, valor, tamaño, servicios);
			}
		});
		btnTerminar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTerminar.setBounds(170, 155, 200, 42);
		panelTerreno.add(btnTerminar);
		
		// Habitable
		JButton btnTerminar_1 = new JButton("Terminar");
		btnTerminar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Datos del primer tab (Inmueble)
				int padron = Integer.parseInt(textNDePadron.getText());
				String ubicacion = textUbicacion.getText();
				int valor = Integer.parseInt(textValor.getText());
				
				// NOTE: ... Es enserio que tenemos que hacerlo de esta manera????? ¿¿¿¿No hay una forma mejor????
				// Datos del tab "Habitable"
				int tamaño = Integer.parseInt(textTamañoHabitable.getText());
				String tipo = (String) tipoOpciones.getSelectedItem();
				int cuartos = (int) spinnerCuartos.getValue();
				int cocina = (int) spinnerCocina.getValue();
				int comedor = (int) spinnerComedor.getValue();
				int living = (int) spinnerLiving.getValue();
				int hall = (int) spinnerHall.getValue();
				int garaje = (int) spinnerGaraje.getValue();
				int piscina = (int) spinnerPiscina.getValue();
				int sauna = (int) spinnerSauna.getValue();
				int barbacoa = (int) spinnerBarbacoa.getValue();
				int churrasquera = (int) spinnerChurrasquera.getValue();
				
				//(int padron, String ubicacion, int valor, int tamaño, String tipo, int cuartos, int cocina, int comedor, int living, int hall, int garaje, int piscina, int sauna, int barbacoa)
				MisMetodosDB.registrarHabitable(padron, ubicacion, valor, tamaño, tipo, cuartos, cocina, comedor, living, hall, garaje, piscina, sauna, barbacoa, churrasquera);
			}
		});
		btnTerminar_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTerminar_1.setBounds(10, 208, 190, 42);
		panelHabitable.add(btnTerminar_1);
	}
}
