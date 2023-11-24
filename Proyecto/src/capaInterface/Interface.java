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
		tabbedPane.setBounds(0, 0, 584, 341);
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
		lblSeleccioneRol.setBounds(149, 95, 238, 14);
		panelIniciarSesion.add(lblSeleccioneRol);
		
		JPanel panelCeo = new JPanel();
		tabbedPane.addTab("Ceo", null, panelCeo, null);
		tabbedPane.setEnabledAt(1, false);
		panelCeo.setLayout(null);
		
		JButton btnSalirCeo = new JButton("Desconectarse");
		btnSalirCeo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO!!: Crear una funcion que permita hacer esto para cada boton, en vez de escribirlo en cada uno.
				tabbedPane.setEnabledAt(tabbedPane.getSelectedIndex(), false);
		        tabbedPane.setSelectedIndex(0);
		        tabbedPane.setEnabledAt(0, true);
			}
		});
		btnSalirCeo.setBounds(460, 257, 109, 45);
		panelCeo.add(btnSalirCeo);
		
		JPanel panelConsultar_2 = new JPanel();
		panelConsultar_2.setLayout(null);
		panelConsultar_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelConsultar_2.setBounds(220, 11, 200, 100);
		panelCeo.add(panelConsultar_2);
		
		JLabel lblConsultar_2 = new JLabel("Consultar");
		lblConsultar_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultar_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblConsultar_2.setBounds(10, 0, 180, 23);
		panelConsultar_2.add(lblConsultar_2);
		
		JButton btnClientesinmuebles_2 = new JButton("Clientes/Inmuebles");
		btnClientesinmuebles_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClientesinmuebles_2.setBounds(20, 34, 160, 55);
		panelConsultar_2.add(btnClientesinmuebles_2);
		
		JPanel panelRegistrar_2 = new JPanel();
		panelRegistrar_2.setLayout(null);
		panelRegistrar_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelRegistrar_2.setBounds(10, 11, 200, 142);
		panelCeo.add(panelRegistrar_2);
		
		JLabel lblNewLabel_2 = new JLabel("Registrar");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(10, 0, 180, 23);
		panelRegistrar_2.add(lblNewLabel_2);
		
		JButton btnRegistrarCliente_2 = new JButton("Clientes");
		btnRegistrarCliente_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarCliente();
			}
		});
		btnRegistrarCliente_2.setBounds(20, 34, 160, 23);
		panelRegistrar_2.add(btnRegistrarCliente_2);
		
		JButton btnRegistrarInmueble_2 = new JButton("Inmuebles");
		btnRegistrarInmueble_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarInmueble();
			}
		});
		btnRegistrarInmueble_2.setBounds(20, 66, 160, 23);
		panelRegistrar_2.add(btnRegistrarInmueble_2);
		
		JButton btnContratos_2 = new JButton("Contratos");
		btnContratos_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarContrato();
			}
		});
		btnContratos_2.setBounds(20, 100, 160, 23);
		panelRegistrar_2.add(btnContratos_2);
		
		JPanel panelRegistrar_4 = new JPanel();
		panelRegistrar_4.setLayout(null);
		panelRegistrar_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelRegistrar_4.setBounds(10, 160, 200, 142);
		panelCeo.add(panelRegistrar_4);
		
		JLabel lblEliminar = new JLabel("Eliminar");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEliminar.setBounds(10, 0, 180, 23);
		panelRegistrar_4.add(lblEliminar);
		
		JButton btnRegistrarCliente_3 = new JButton("Clientes");
		btnRegistrarCliente_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bajaCliente();
			}
		});
		btnRegistrarCliente_3.setBounds(20, 34, 160, 23);
		panelRegistrar_4.add(btnRegistrarCliente_3);
		
		JButton btnRegistrarInmueble_3 = new JButton("Inmuebles");
		btnRegistrarInmueble_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bajaInmueble();
			}
		});
		btnRegistrarInmueble_3.setBounds(20, 66, 160, 23);
		panelRegistrar_4.add(btnRegistrarInmueble_3);
		
		JButton btnContratos_4 = new JButton("Contratos");
		btnContratos_4.setBounds(20, 100, 160, 23);
		panelRegistrar_4.add(btnContratos_4);
		
		JPanel panelGerente = new JPanel();
		tabbedPane.addTab("Gerente", null, panelGerente, null);
		tabbedPane.setEnabledAt(2, false);
		panelGerente.setLayout(null);
		
		JButton btnSalirGerente = new JButton("Desconectarse");
		btnSalirGerente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO!!: Crear una funcion que permita hacer esto para cada boton, en vez de escribirlo en cada uno.
				tabbedPane.setEnabledAt(tabbedPane.getSelectedIndex(), false);
		        tabbedPane.setSelectedIndex(0);
		        tabbedPane.setEnabledAt(0, true);
			}
		});
		btnSalirGerente.setBounds(460, 257, 109, 45);
		panelGerente.add(btnSalirGerente);
		
		JPanel panelConsultar_1 = new JPanel();
		panelConsultar_1.setLayout(null);
		panelConsultar_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelConsultar_1.setBounds(220, 11, 200, 100);
		panelGerente.add(panelConsultar_1);
		
		JLabel lblConsultar_1 = new JLabel("Consultar");
		lblConsultar_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultar_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblConsultar_1.setBounds(10, 0, 180, 23);
		panelConsultar_1.add(lblConsultar_1);
		
		JButton btnClientesinmuebles_1 = new JButton("Clientes/Inmuebles");
		btnClientesinmuebles_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClientesinmuebles_1.setBounds(20, 34, 160, 55);
		panelConsultar_1.add(btnClientesinmuebles_1);
		
		JPanel panelRegistrar_1 = new JPanel();
		panelRegistrar_1.setLayout(null);
		panelRegistrar_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelRegistrar_1.setBounds(10, 11, 200, 142);
		panelGerente.add(panelRegistrar_1);
		
		JLabel lblNewLabel_1 = new JLabel("Registrar");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 0, 180, 23);
		panelRegistrar_1.add(lblNewLabel_1);
		
		JButton btnRegistrarCliente_1 = new JButton("Clientes");
		btnRegistrarCliente_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarCliente();
			}
		});
		btnRegistrarCliente_1.setBounds(20, 34, 160, 23);
		panelRegistrar_1.add(btnRegistrarCliente_1);
		
		JButton btnRegistrarInmueble_1 = new JButton("Inmuebles");
		btnRegistrarInmueble_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarInmueble();
			}
		});
		btnRegistrarInmueble_1.setBounds(20, 66, 160, 23);
		panelRegistrar_1.add(btnRegistrarInmueble_1);
		
		JButton btnContratos_1 = new JButton("Contratos");
		btnContratos_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarContrato();
			}
		});
		btnContratos_1.setBounds(20, 100, 160, 23);
		panelRegistrar_1.add(btnContratos_1);
		
		JPanel panelAdministrativo = new JPanel();
		tabbedPane.addTab("Administrativo", null, panelAdministrativo, null);
		panelAdministrativo.setLayout(null);
		
		JButton btnSalirAdministrativo = new JButton("Desconectarse");
		btnSalirAdministrativo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO!!: Crear una funcion que permita hacer esto para cada boton, en vez de escribirlo en cada uno.
				tabbedPane.setEnabledAt(tabbedPane.getSelectedIndex(), false);
		        tabbedPane.setSelectedIndex(0);
		        tabbedPane.setEnabledAt(0, true);
			}
		});
		btnSalirAdministrativo.setBounds(460, 257, 109, 45);
		panelAdministrativo.add(btnSalirAdministrativo);
		
		JPanel panelRegistrar = new JPanel();
		panelRegistrar.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelRegistrar.setBounds(10, 11, 200, 142);
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
		
		JButton btnContratos = new JButton("Contratos");
		btnContratos.setBounds(20, 100, 160, 23);
		panelRegistrar.add(btnContratos);
		
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
	
	public static void registrarContrato() {
		Aplicacion.abrirRegistrarContratos();
	}
	
	public static void consultarDatos() {
		Aplicacion.abrirConsultaDeDatos();
	}
	
	public static void bajaCliente() {
		Aplicacion.abrirBajaCliente();
	}
	
	public static void bajaInmueble() {
		Aplicacion.abrirBajaInmueble();
	}
}
