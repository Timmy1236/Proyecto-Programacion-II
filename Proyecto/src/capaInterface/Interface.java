package capaInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import capaNegocios.Aplicacion;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;

public class Interface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public Interface() {
		setResizable(false);
		setTitle("Inmobiliaria ITS");
		// TODO: Cambiarlo por un logo mejor.
		// Ponemos el logo de ITS a la aplicacion
		ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("icon.png"));
		setIconImage(logo.getImage());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 564, 319);
		contentPane.add(tabbedPane);
		
		JPanel panelIniciarSesion = new JPanel();
		tabbedPane.addTab("Iniciar sesión", null, panelIniciarSesion, null);
		panelIniciarSesion.setLayout(null);
		
		JComboBox usuarioOpciones = new JComboBox();
		usuarioOpciones.setModel(new DefaultComboBoxModel(new String[] {"Ceo", "Gerente", "Administrativo"}));
		usuarioOpciones.setBounds(194, 120, 145, 22);
		panelIniciarSesion.add(usuarioOpciones);
		
		JLabel lblSeleccioneRol = new JLabel("Por favor, seleccione su rol");
		lblSeleccioneRol.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccioneRol.setBounds(146, 96, 238, 14);
		panelIniciarSesion.add(lblSeleccioneRol);
		
		JPanel panelCeo = new JPanel();
		tabbedPane.addTab("Ceo", null, panelCeo, null);
		tabbedPane.setEnabledAt(1, false);
		panelCeo.setLayout(null);
		
		JButton btnSalirCeo = new JButton("Salir");
		btnSalirCeo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO!!: Crear una funcion que permita hacer esto para cada boton, en vez de escribirlo en cada uno.
				tabbedPane.setEnabledAt(tabbedPane.getSelectedIndex(), false);
		        tabbedPane.setSelectedIndex(0);
		        tabbedPane.setEnabledAt(0, true);
			}
		});
		btnSalirCeo.setBounds(460, 257, 89, 23);
		panelCeo.add(btnSalirCeo);
		
		JPanel panelRegistrar_2 = new JPanel();
		panelRegistrar_2.setLayout(null);
		panelRegistrar_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelRegistrar_2.setBounds(10, 11, 200, 150);
		panelCeo.add(panelRegistrar_2);
		
		JLabel lblNewLabel_2 = new JLabel("Registrar");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(10, 11, 180, 23);
		panelRegistrar_2.add(lblNewLabel_2);
		
		JButton btnRegistrarCliente_2 = new JButton("Nuevos Clientes");
		btnRegistrarCliente_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarCliente();
			}
		});
		btnRegistrarCliente_2.setBounds(20, 45, 160, 23);
		panelRegistrar_2.add(btnRegistrarCliente_2);
		
		JButton btnRegistrarInmueble_2 = new JButton("Nuevos Inmuebles");
		btnRegistrarInmueble_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarInmueble();
			}
		});
		btnRegistrarInmueble_2.setBounds(20, 79, 160, 23);
		panelRegistrar_2.add(btnRegistrarInmueble_2);
		
		JPanel panelGerente = new JPanel();
		tabbedPane.addTab("Gerente", null, panelGerente, null);
		tabbedPane.setEnabledAt(2, false);
		panelGerente.setLayout(null);
		
		JButton btnSalirGerente = new JButton("Salir");
		btnSalirGerente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO!!: Crear una funcion que permita hacer esto para cada boton, en vez de escribirlo en cada uno.
				tabbedPane.setEnabledAt(tabbedPane.getSelectedIndex(), false);
		        tabbedPane.setSelectedIndex(0);
		        tabbedPane.setEnabledAt(0, true);
			}
		});
		btnSalirGerente.setBounds(460, 257, 89, 23);
		panelGerente.add(btnSalirGerente);
		
		JPanel panelRegistrar_1 = new JPanel();
		panelRegistrar_1.setLayout(null);
		panelRegistrar_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelRegistrar_1.setBounds(10, 11, 200, 150);
		panelGerente.add(panelRegistrar_1);
		
		JLabel lblNewLabel_1 = new JLabel("Registrar");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 11, 180, 23);
		panelRegistrar_1.add(lblNewLabel_1);
		
		JButton btnRegistrarCliente_1 = new JButton("Nuevos Clientes");
		btnRegistrarCliente_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarCliente();
			}
		});
		btnRegistrarCliente_1.setBounds(20, 45, 160, 23);
		panelRegistrar_1.add(btnRegistrarCliente_1);
		
		JButton btnRegistrarInmueble_1 = new JButton("Nuevos Inmuebles");
		btnRegistrarInmueble_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarInmueble();
			}
		});
		btnRegistrarInmueble_1.setBounds(20, 79, 160, 23);
		panelRegistrar_1.add(btnRegistrarInmueble_1);
		
		JPanel panelAdministrativo = new JPanel();
		tabbedPane.addTab("Administrativo", null, panelAdministrativo, null);
		panelAdministrativo.setLayout(null);
		
		JButton btnSalirAdministrativo = new JButton("Salir");
		btnSalirAdministrativo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO!!: Crear una funcion que permita hacer esto para cada boton, en vez de escribirlo en cada uno.
				tabbedPane.setEnabledAt(tabbedPane.getSelectedIndex(), false);
		        tabbedPane.setSelectedIndex(0);
		        tabbedPane.setEnabledAt(0, true);
			}
		});
		btnSalirAdministrativo.setBounds(460, 257, 89, 23);
		panelAdministrativo.add(btnSalirAdministrativo);
		
		JPanel panelRegistrar = new JPanel();
		panelRegistrar.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelRegistrar.setBounds(10, 11, 200, 100);
		panelAdministrativo.add(panelRegistrar);
		panelRegistrar.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registrar");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 0, 180, 23);
		panelRegistrar.add(lblNewLabel);
		
		JButton btnRegistrarCliente = new JButton("Clientes");
		btnRegistrarCliente.setBounds(20, 34, 160, 23);
		panelRegistrar.add(btnRegistrarCliente);
		
		JButton btnRegistrarInmueble = new JButton("Inmuebles");
		btnRegistrarInmueble.setBounds(20, 66, 160, 23);
		panelRegistrar.add(btnRegistrarInmueble);
		
		JPanel panelConsultar = new JPanel();
		panelConsultar.setLayout(null);
		panelConsultar.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelConsultar.setBounds(220, 11, 200, 100);
		panelAdministrativo.add(panelConsultar);
		
		JLabel lblConsultar = new JLabel("Consultar");
		lblConsultar.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultar.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblConsultar.setBounds(10, 0, 180, 23);
		panelConsultar.add(lblConsultar);
		
		JButton btnClientesinmuebles = new JButton("Clientes/Inmuebles");
		btnClientesinmuebles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarDatos();
			}
		});
		btnClientesinmuebles.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClientesinmuebles.setBounds(20, 34, 160, 55);
		panelConsultar.add(btnClientesinmuebles);
		btnRegistrarInmueble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarInmueble();
			}
		});
		btnRegistrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarCliente();
			}
		});
		tabbedPane.setEnabledAt(3, false);
		
		// Boton "Continuar" del panel "Iniciar Sesion"
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Si el usuario presiona el boton de continuar, agarremos el item actual seleccionado en JComboBox
				String opcion = (String) usuarioOpciones.getSelectedItem();
				
				// Dependiendo de que item fue seleccionado, activamos el panel de la opcion. Si es Ceo, activamos panel del Ceo.
				switch(opcion) {
				case "Ceo":
					tabbedPane.setEnabledAt(0, false);
					tabbedPane.setSelectedIndex(1);
					tabbedPane.setEnabledAt(1, true);
					break;
				
				case "Gerente":
					tabbedPane.setEnabledAt(0, false);
					tabbedPane.setSelectedIndex(2);
					tabbedPane.setEnabledAt(2, true);
					break;
					
				case "Administrativo":
					tabbedPane.setEnabledAt(0, false);
					tabbedPane.setSelectedIndex(3);
					tabbedPane.setEnabledAt(3, true);
					break;
				}
			}
		});
		
		btnContinuar.setBounds(227, 153, 89, 23);
		panelIniciarSesion.add(btnContinuar);
	}
	
	public static void registrarCliente() {
		Aplicacion.abrirRegistrarClientes();
	}
	
	public static void registrarInmueble() {
		Aplicacion.abrirRegistrarInmuebles();
	}
	
	public static void consultarDatos() {
		Aplicacion.abrirConsultaDeDatos();
	}
}
