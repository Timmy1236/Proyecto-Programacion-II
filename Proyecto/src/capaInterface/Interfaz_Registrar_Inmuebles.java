package capaInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import javax.swing.SpinnerNumberModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import capaDatos.Validaciones;
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

	// Creamos la interfaz
	public Interfaz_Registrar_Inmuebles() {
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("Registrador de Inmuebles");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 564, 319);
		contentPane.add(tabbedPane);
		
		JPanel panelInmueble = new JPanel();
		tabbedPane.addTab("Inmueble", null, panelInmueble, null);
		tabbedPane.setEnabledAt(0, true);
		panelInmueble.setLayout(null);
		
		JLabel lblNDePadron = new JLabel("N° de Padron");
		lblNDePadron.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNDePadron.setBounds(32, 36, 127, 14);
		panelInmueble.add(lblNDePadron);
		
		JLabel lblUbicacindepartamentoCalle = new JLabel("Ubicación");
		lblUbicacindepartamentoCalle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUbicacindepartamentoCalle.setBounds(32, 103, 127, 14);
		panelInmueble.add(lblUbicacindepartamentoCalle);
		
		textNDePadron = new JTextField();
		textNDePadron.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (textNDePadron.getText().length() >= 14 ) 
	                e.consume();
			}
		});
		textNDePadron.setColumns(10);
		textNDePadron.setBounds(169, 33, 200, 20);
		panelInmueble.add(textNDePadron);
		
		textUbicacion = new JTextField();
		textUbicacion.setColumns(10);
		textUbicacion.setBounds(169, 100, 200, 20);
		panelInmueble.add(textUbicacion);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Cerramos la ventana
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar.setBounds(349, 238, 200, 42);
		panelInmueble.add(btnCancelar);
		
		JLabel lblNewLabel_1 = new JLabel("(Departamento, calle, nº puerta)");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_1.setBounds(363, 103, 186, 14);
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
		btnContinuar.setBounds(10, 238, 200, 42);
		panelInmueble.add(btnContinuar);
		
		JLabel lblValordolares = new JLabel("Valor");
		lblValordolares.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValordolares.setBounds(32, 168, 127, 14);
		panelInmueble.add(lblValordolares);
		
		textValor = new JTextField();
		textValor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				Validaciones.validarInt(e);
			}
		});
		textValor.setColumns(10);
		textValor.setBounds(169, 165, 200, 20);
		panelInmueble.add(textValor);
		
		JLabel lblNewLabel_2 = new JLabel("(01-01-001-0000)");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(373, 36, 176, 14);
		panelInmueble.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("(En dolares)");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_2_1.setBounds(373, 168, 176, 14);
		panelInmueble.add(lblNewLabel_2_1);
		
		JPanel panelTipo = new JPanel();
		tabbedPane.addTab("Tipo", null, panelTipo, null);
		tabbedPane.setEnabledAt(1, false);
		panelTipo.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("¿Cual es el tipo del inmueble?");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(10, 32, 539, 25);
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
		btnTerreno.setBounds(185, 100, 200, 42);
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
		btnHabitable.setBounds(185, 153, 200, 42);
		panelTipo.add(btnHabitable);
		
		JPanel panelTerreno = new JPanel();
		tabbedPane.addTab("Terreno", null, panelTerreno, null);
		tabbedPane.setEnabledAt(2, false);
		panelTerreno.setLayout(null);
		
		JLabel lblTamaoenM = new JLabel("Tamaño");
		lblTamaoenM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTamaoenM.setBounds(45, 59, 81, 14);
		panelTerreno.add(lblTamaoenM);
		
		JLabel lblServicios = new JLabel("Servicios");
		lblServicios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblServicios.setBounds(45, 146, 81, 14);
		panelTerreno.add(lblServicios);
		
		textTamano = new JTextField();
		textTamano.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				Validaciones.validarInt(e);
			}
		});
		textTamano.setColumns(10);
		textTamano.setBounds(137, 58, 200, 20);
		panelTerreno.add(textTamano);
		
		textServicios = new JTextField();
		textServicios.setColumns(10);
		textServicios.setBounds(136, 146, 200, 20);
		panelTerreno.add(textServicios);
		
		JButton btnCancelar_1 = new JButton("Cancelar");
		btnCancelar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Cerramos la ventana
				dispose();
			}
		});
		btnCancelar_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar_1.setBounds(349, 238, 200, 42);
		panelTerreno.add(btnCancelar_1);
		
		JPanel panelHabitable = new JPanel();
		tabbedPane.addTab("Habitable", null, panelHabitable, null);
		tabbedPane.setEnabledAt(3, false);
		panelHabitable.setLayout(null);
		
		JLabel lblTamaoenM_1 = new JLabel("Tamaño");
		lblTamaoenM_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTamaoenM_1.setBounds(50, 38, 127, 14);
		panelHabitable.add(lblTamaoenM_1);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipo.setBounds(50, 63, 127, 14);
		panelHabitable.add(lblTipo);
		
		textTamañoHabitable = new JTextField();
		textTamañoHabitable.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				Validaciones.validarInt(e);
			}
		});
		textTamañoHabitable.setColumns(10);
		textTamañoHabitable.setBounds(187, 35, 200, 20);
		panelHabitable.add(textTamañoHabitable);
		
		JButton btnCancelar_1_1 = new JButton("Cancelar");
		btnCancelar_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Cerramos la ventana
				dispose();
			}
		});
		btnCancelar_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar_1_1.setBounds(359, 238, 190, 42);
		panelHabitable.add(btnCancelar_1_1);
		
		JComboBox tipoOpciones = new JComboBox();
		tipoOpciones.setModel(new DefaultComboBoxModel(new String[] {"Casa", "Departamento", "Mejoras"}));
		tipoOpciones.setBounds(187, 59, 200, 22);
		panelHabitable.add(tipoOpciones);
		
		JLabel lblNewLabel = new JLabel("Cantidad de habitaciones cada uno");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(107, 110, 337, 14);
		panelHabitable.add(lblNewLabel);
		
		JLabel lblCuartos = new JLabel("Cuartos");
		lblCuartos.setBounds(85, 135, 65, 14);
		panelHabitable.add(lblCuartos);
		
		JLabel lblCocina = new JLabel("Cocina");
		lblCocina.setBounds(85, 160, 65, 14);
		panelHabitable.add(lblCocina);
		
		JLabel lblComedor = new JLabel("Comedor");
		lblComedor.setBounds(85, 185, 65, 14);
		panelHabitable.add(lblComedor);
		
		JSpinner spinnerCuartos = new JSpinner();
		spinnerCuartos.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinnerCuartos.setBounds(160, 129, 30, 20);
		panelHabitable.add(spinnerCuartos);
		
		JSpinner spinnerCocina = new JSpinner();
		spinnerCocina.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinnerCocina.setBounds(160, 154, 30, 20);
		panelHabitable.add(spinnerCocina);
		
		JSpinner spinnerComedor = new JSpinner();
		spinnerComedor.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinnerComedor.setBounds(160, 179, 30, 20);
		panelHabitable.add(spinnerComedor);
		
		JLabel lblLiving = new JLabel("Living");
		lblLiving.setBounds(222, 210, 65, 14);
		panelHabitable.add(lblLiving);
		
		JSpinner spinnerLiving = new JSpinner();
		spinnerLiving.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinnerLiving.setBounds(297, 204, 30, 20);
		panelHabitable.add(spinnerLiving);
		
		JLabel lblHall = new JLabel("Hall");
		lblHall.setBounds(222, 135, 65, 14);
		panelHabitable.add(lblHall);
		
		JSpinner spinnerHall = new JSpinner();
		spinnerHall.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinnerHall.setBounds(297, 129, 30, 20);
		panelHabitable.add(spinnerHall);
		
		JLabel lblGaraje = new JLabel("Garaje");
		lblGaraje.setBounds(222, 160, 65, 14);
		panelHabitable.add(lblGaraje);
		
		JSpinner spinnerGaraje = new JSpinner();
		spinnerGaraje.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinnerGaraje.setBounds(297, 154, 30, 20);
		panelHabitable.add(spinnerGaraje);
		
		JLabel lblPiscina = new JLabel("Piscina");
		lblPiscina.setBounds(222, 185, 65, 14);
		panelHabitable.add(lblPiscina);
		
		JSpinner spinnerPiscina = new JSpinner();
		spinnerPiscina.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinnerPiscina.setBounds(297, 179, 30, 20);
		panelHabitable.add(spinnerPiscina);
		
		JLabel lblSauna = new JLabel("Sauna");
		lblSauna.setBounds(353, 185, 81, 14);
		panelHabitable.add(lblSauna);
		
		JSpinner spinnerSauna = new JSpinner();
		spinnerSauna.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinnerSauna.setBounds(444, 179, 30, 20);
		panelHabitable.add(spinnerSauna);
		
		JLabel lblBarbacoa = new JLabel("Barbacoa");
		lblBarbacoa.setBounds(353, 135, 81, 14);
		panelHabitable.add(lblBarbacoa);
		
		JLabel lblChurrasquera = new JLabel("Churrasquera");
		lblChurrasquera.setBounds(353, 160, 81, 14);
		panelHabitable.add(lblChurrasquera);
		
		JSpinner spinnerBarbacoa = new JSpinner();
		spinnerBarbacoa.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinnerBarbacoa.setBounds(444, 129, 30, 20);
		panelHabitable.add(spinnerBarbacoa);
		
		JSpinner spinnerChurrasquera = new JSpinner();
		spinnerChurrasquera.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinnerChurrasquera.setBounds(444, 154, 30, 20);
		panelHabitable.add(spinnerChurrasquera);
		
		// !!: Dejar los eventos/botones siempre debajo de todo para evitar errores ;)
		
		// Terreno
		JButton btnTerminar = new JButton("Terminar");
		btnTerminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!Validaciones.vacio(textNDePadron) && !Validaciones.vacio(textUbicacion) && !Validaciones.vacio(textValor) && !Validaciones.vacio(textTamano) && !Validaciones.vacio(textServicios)) {
					if (!MisMetodosDB.existeInmueble(textNDePadron.getText())) {
						// Datos del primer tab (Inmueble)
						String padron = textNDePadron.getText();
						String ubicacion = textUbicacion.getText();
						int valor = Integer.parseInt(textValor.getText());
				
						// Datos del tab "Terreno"
						int tamaño = Integer.parseInt(textTamano.getText());
						String servicios = textServicios.getText();

						MisMetodosDB.subirDatosTerreno(padron, ubicacion, valor, tamaño, servicios, "Terreno");
						
						// Cerramos la ventana
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Ya existe un inmueble con este padron", "Error, inmueble duplicado", JOptionPane.PLAIN_MESSAGE);
					}
				}
			}
		});
		btnTerminar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTerminar.setBounds(10, 238, 200, 42);
		panelTerreno.add(btnTerminar);
		
		JLabel lblNewLabel_4 = new JLabel("(En m2)");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_4.setBounds(347, 61, 169, 14);
		panelTerreno.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("(OSE, UTE, etc)");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_5.setBounds(346, 149, 169, 14);
		panelTerreno.add(lblNewLabel_5);
		
		JLabel lblBaños = new JLabel("Baños");
		lblBaños.setBounds(85, 210, 46, 14);
		panelHabitable.add(lblBaños);
		
		JSpinner spinnerBaños = new JSpinner();
		spinnerBaños.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinnerBaños.setBounds(160, 204, 30, 20);
		panelHabitable.add(spinnerBaños);
				
		JLabel lblGimnasio = new JLabel("Gimnasio");
		lblGimnasio.setBounds(353, 210, 46, 14);
		panelHabitable.add(lblGimnasio);
				
		JSpinner spinnerGimnasio = new JSpinner();
		spinnerGimnasio.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinnerGimnasio.setBounds(444, 207, 30, 20);
		panelHabitable.add(spinnerGimnasio);
		
		// Habitable
		JButton btnTerminar_1 = new JButton("Terminar");
		btnTerminar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!Validaciones.vacio(textNDePadron) && !Validaciones.vacio(textUbicacion) && !Validaciones.vacio(textValor) && !Validaciones.vacio(textTamañoHabitable)) {
					if (!MisMetodosDB.existeInmueble(textNDePadron.getText())) {
						// Datos del primer tab (Inmueble)
						String padron = textNDePadron.getText();
						String ubicacion = textUbicacion.getText();
						int valor = Integer.parseInt(textValor.getText());
				
						// NOTE: ... Es enserio que tenemos que hacerlo de esta manera????? ¿¿¿¿No hay una forma mejor????
						// Datos del tab "Habitable"
						int tamaño = Integer.parseInt(textTamañoHabitable.getText());
						String tipoHabitable = (String) tipoOpciones.getSelectedItem();
						int cuartos = (int) spinnerCuartos.getValue();
						int cocina = (int) spinnerCocina.getValue();
						int comedor = (int) spinnerComedor.getValue();
						int baños = (int) spinnerBaños.getValue();
						int living = (int) spinnerLiving.getValue();
						int hall = (int) spinnerHall.getValue();
						int garaje = (int) spinnerGaraje.getValue();
						int piscina = (int) spinnerPiscina.getValue();
						int sauna = (int) spinnerSauna.getValue();
						int barbacoa = (int) spinnerBarbacoa.getValue();
						int churrasquera = (int) spinnerChurrasquera.getValue();
						int gimnasio = (int) spinnerGimnasio.getValue();
					
						MisMetodosDB.subirDatosHabitable(padron, ubicacion, valor, tamaño, "Habitable", tipoHabitable, cuartos, cocina, comedor, baños, living, hall, garaje, gimnasio, piscina, sauna, barbacoa, churrasquera);
					
						// Cerramos la ventana
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Ya existe un inmueble con este padron", "Error, inmueble duplicado", JOptionPane.PLAIN_MESSAGE);
					}
				}
			}
		});
		btnTerminar_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTerminar_1.setBounds(10, 238, 190, 42);
		panelHabitable.add(btnTerminar_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("(En m2)");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_4_1.setBounds(380, 38, 169, 14);
		panelHabitable.add(lblNewLabel_4_1);
	}
}
