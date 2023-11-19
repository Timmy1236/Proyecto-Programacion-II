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

public class Interfaz_Registrar_Inmuebles extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNDePadron;
	private JTextField textUbicacion;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz_Registrar_Inmuebles frame = new Interfaz_Registrar_Inmuebles();
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
	public Interfaz_Registrar_Inmuebles() {
		setTitle("Registrador de Inmuebles");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(170, 56, 200, 20);
		panelTerreno.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(170, 81, 200, 20);
		panelTerreno.add(textField_3);
		
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
		
		JButton btnTerminar = new JButton("Terminar");
		btnTerminar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTerminar.setBounds(170, 155, 200, 42);
		panelTerreno.add(btnTerminar);
		
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
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(169, 11, 200, 20);
		panelHabitable.add(textField_4);
		
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
		
		JButton btnTerminar_1 = new JButton("Terminar");
		btnTerminar_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTerminar_1.setBounds(10, 208, 190, 42);
		panelHabitable.add(btnTerminar_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Casa", "Departamento", "Mejoras"}));
		comboBox.setBounds(169, 35, 200, 22);
		panelHabitable.add(comboBox);
		
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
	}
}
