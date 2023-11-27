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
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import javax.swing.JTextArea;

public class Interface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public Interface() {
		setResizable(false);
		setTitle("Inmobiliaria ITS");
		ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("icon.png"));
		setIconImage(logo.getImage());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Esta imagen serivra para los perfiles de los roles
		ImageIcon userProfile = new ImageIcon(getClass().getClassLoader().getResource("user.png"));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, -26, 584, 367);
		contentPane.add(tabbedPane);
		
		JPanel panelIniciarSesion = new JPanel();
		tabbedPane.addTab("Iniciar sesión", null, panelIniciarSesion, null);
		panelIniciarSesion.setLayout(null);
		
		JPanel panelCeo = new JPanel();
		tabbedPane.addTab("Ceo", null, panelCeo, null);
		tabbedPane.setEnabledAt(1, false);
		panelCeo.setLayout(null);
		
		JPanel panelRegistrar_2 = new JPanel();
		panelRegistrar_2.setLayout(null);
		panelRegistrar_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelRegistrar_2.setBounds(10, 82, 559, 110);
		panelCeo.add(panelRegistrar_2);
		
		JLabel lblNewLabel_2 = new JLabel("Registrar");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_2.setBounds(10, 11, 539, 28);
		panelRegistrar_2.add(lblNewLabel_2);
		
		JButton btnRegistrarCliente_2 = new JButton("Clientes");
		btnRegistrarCliente_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarCliente();
			}
		});
		btnRegistrarCliente_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRegistrarCliente_2.setBounds(20, 50, 160, 50);
		panelRegistrar_2.add(btnRegistrarCliente_2);
		
		JButton btnRegistrarInmueble_2 = new JButton("Inmuebles");
		btnRegistrarInmueble_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarInmueble();
			}
		});
		btnRegistrarInmueble_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRegistrarInmueble_2.setBounds(205, 50, 160, 50);
		panelRegistrar_2.add(btnRegistrarInmueble_2);
		
		JButton btnContratos_2 = new JButton("Contratos");
		btnContratos_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarContrato();
			}
		});
		btnContratos_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnContratos_2.setBounds(389, 50, 160, 50);
		panelRegistrar_2.add(btnContratos_2);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panel_1_2.setBounds(10, 11, 559, 60);
		panelCeo.add(panel_1_2);
		
		JLabel lblCeo = new JLabel("CEO");
		lblCeo.setIcon(userProfile);
		lblCeo.setBounds(10, 11, 200, 38);
		panel_1_2.add(lblCeo);
		
		JButton btnSalirAdministrativo_2 = new JButton("Desconectarse");
		btnSalirAdministrativo_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setEnabledAt(tabbedPane.getSelectedIndex(), false);
		        tabbedPane.setSelectedIndex(0);
		        tabbedPane.setEnabledAt(0, true);
			}
		});
		btnSalirAdministrativo_2.setBounds(423, 8, 126, 45);
		panel_1_2.add(btnSalirAdministrativo_2);
		
		JPanel panelRegistrar_3_1_1 = new JPanel();
		panelRegistrar_3_1_1.setLayout(null);
		panelRegistrar_3_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelRegistrar_3_1_1.setBounds(10, 218, 559, 110);
		panelCeo.add(panelRegistrar_3_1_1);
		
		JLabel lblConsultarEliminarAutorizar_1 = new JLabel("Consultar eliminar autorizar y editar");
		lblConsultarEliminarAutorizar_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultarEliminarAutorizar_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblConsultarEliminarAutorizar_1.setBounds(10, 11, 539, 28);
		panelRegistrar_3_1_1.add(lblConsultarEliminarAutorizar_1);
		
		JButton btnDatos_1 = new JButton("Datos");
		btnDatos_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarDatos();
			}
		});
		btnDatos_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDatos_1.setBounds(205, 49, 160, 50);
		panelRegistrar_3_1_1.add(btnDatos_1);
		
		JPanel panelGerente = new JPanel();
		tabbedPane.addTab("Gerente", null, panelGerente, null);
		tabbedPane.setEnabledAt(2, false);
		panelGerente.setLayout(null);
		
		JPanel panelRegistrar_3_1 = new JPanel();
		panelRegistrar_3_1.setLayout(null);
		panelRegistrar_3_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelRegistrar_3_1.setBounds(10, 218, 559, 110);
		panelGerente.add(panelRegistrar_3_1);
		
		JLabel lblConsultarEliminarAutorizar = new JLabel("Consultar eliminar autorizar y editar");
		lblConsultarEliminarAutorizar.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultarEliminarAutorizar.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblConsultarEliminarAutorizar.setBounds(10, 11, 539, 28);
		panelRegistrar_3_1.add(lblConsultarEliminarAutorizar);
		
		JButton btnDatos = new JButton("Datos");
		btnDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarDatos();
			}
		});
		btnDatos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDatos.setBounds(205, 49, 160, 50);
		panelRegistrar_3_1.add(btnDatos);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panel_1_1.setBounds(10, 11, 559, 60);
		panelGerente.add(panel_1_1);
		
		JLabel lblGerente = new JLabel("Gerente");
		lblGerente.setIcon(userProfile);
		lblGerente.setBounds(10, 11, 200, 38);
		panel_1_1.add(lblGerente);
		
		JButton btnSalirAdministrativo_1 = new JButton("Desconectarse");
		btnSalirAdministrativo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setEnabledAt(tabbedPane.getSelectedIndex(), false);
		        tabbedPane.setSelectedIndex(0);
		        tabbedPane.setEnabledAt(0, true);
			}
		});
		btnSalirAdministrativo_1.setBounds(423, 8, 126, 45);
		panel_1_1.add(btnSalirAdministrativo_1);
		
		JPanel panelRegistrar_1 = new JPanel();
		panelRegistrar_1.setLayout(null);
		panelRegistrar_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelRegistrar_1.setBounds(10, 82, 559, 110);
		panelGerente.add(panelRegistrar_1);
		
		JLabel lblNewLabel_1 = new JLabel("Registrar");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBounds(10, 11, 539, 28);
		panelRegistrar_1.add(lblNewLabel_1);
		
		JButton btnRegistrarCliente_1 = new JButton("Clientes");
		btnRegistrarCliente_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarCliente();
			}
		});
		btnRegistrarCliente_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRegistrarCliente_1.setBounds(20, 50, 160, 50);
		panelRegistrar_1.add(btnRegistrarCliente_1);
		
		JButton btnRegistrarInmueble_1 = new JButton("Inmuebles");
		btnRegistrarInmueble_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarInmueble();
			}
		});
		btnRegistrarInmueble_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRegistrarInmueble_1.setBounds(205, 50, 160, 50);
		panelRegistrar_1.add(btnRegistrarInmueble_1);
		
		JButton btnContratos_1 = new JButton("Contratos");
		btnContratos_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarContrato();
			}
		});
		btnContratos_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnContratos_1.setBounds(389, 50, 160, 50);
		panelRegistrar_1.add(btnContratos_1);
		
		JPanel panelAdministrativo = new JPanel();
		tabbedPane.addTab("Administrativo", null, panelAdministrativo, null);
		panelAdministrativo.setLayout(null);
		
		JPanel panelRegistrar = new JPanel();
		panelRegistrar.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelRegistrar.setBounds(10, 82, 559, 110);
		panelAdministrativo.add(panelRegistrar);
		panelRegistrar.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registrar");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 539, 28);
		panelRegistrar.add(lblNewLabel);
		
		JButton btnRegistrarCliente = new JButton("Clientes");
		btnRegistrarCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRegistrarCliente.setBounds(20, 50, 160, 50);
		panelRegistrar.add(btnRegistrarCliente);
		
		JButton btnRegistrarInmueble = new JButton("Inmuebles");
		btnRegistrarInmueble.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRegistrarInmueble.setBounds(205, 50, 160, 50);
		panelRegistrar.add(btnRegistrarInmueble);
		
		JButton btnContratos = new JButton("Contratos");
		btnContratos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarContrato();
			}
		});
		btnContratos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnContratos.setBounds(389, 50, 160, 50);
		panelRegistrar.add(btnContratos);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panel_1.setBounds(10, 11, 559, 60);
		panelAdministrativo.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblUserAdministrativo = new JLabel("Administrativo");
		lblUserAdministrativo.setIcon(userProfile);
		lblUserAdministrativo.setBounds(10, 11, 200, 38);
		panel_1.add(lblUserAdministrativo);
		
		JButton btnSalirAdministrativo = new JButton("Desconectarse");
		btnSalirAdministrativo.setBounds(423, 8, 126, 45);
		panel_1.add(btnSalirAdministrativo);
		
		JPanel panelRegistrar_3 = new JPanel();
		panelRegistrar_3.setLayout(null);
		panelRegistrar_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelRegistrar_3.setBounds(10, 218, 200, 110);
		panelAdministrativo.add(panelRegistrar_3);
		
		JLabel lblConsultar = new JLabel("Consultar");
		lblConsultar.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultar.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblConsultar.setBounds(10, 11, 180, 28);
		panelRegistrar_3.add(lblConsultar);
		
		JButton btnClientesinmuebles = new JButton("Datos (View Only)");
		btnClientesinmuebles.setBounds(20, 49, 160, 50);
		panelRegistrar_3.add(btnClientesinmuebles);
		btnClientesinmuebles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aplicacion.abrirConsultaDeDatosViewonly();
			}
		});
		btnClientesinmuebles.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JTextArea txtrTuRol = new JTextArea();
		txtrTuRol.setBackground(UIManager.getColor("Button.background"));
		txtrTuRol.setWrapStyleWord(true);
		txtrTuRol.setEditable(false);
		txtrTuRol.setFont(new Font("Nirmala UI", Font.ITALIC, 14));
		txtrTuRol.setLineWrap(true);
		txtrTuRol.setText("* Tu rol no cuenta con los permisos suficientes para editar, autorizar o eliminar datos de la base de datos, solo eres capaz de consultarlos.");
		txtrTuRol.setBounds(220, 232, 349, 96);
		panelAdministrativo.add(txtrTuRol);
		btnSalirAdministrativo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setEnabledAt(tabbedPane.getSelectedIndex(), false);
		        tabbedPane.setSelectedIndex(0);
		        tabbedPane.setEnabledAt(0, true);
			}
		});
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
		
		ImageIcon banner = new ImageIcon(getClass().getClassLoader().getResource("banner.png"));
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(banner);
		lblNewLabel_3.setBounds(25, 11, 569, 73);
		panelIniciarSesion.add(lblNewLabel_3);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 95, 559, 233);
		panelIniciarSesion.add(panel);
		panel.setLayout(null);
		
		// Boton "Continuar" del panel "Iniciar Sesion"
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(190, 174, 180, 48);
		panel.add(btnContinuar);
		
		JComboBox usuarioOpciones = new JComboBox();
		usuarioOpciones.setBounds(190, 61, 180, 22);
		panel.add(usuarioOpciones);
		usuarioOpciones.setModel(new DefaultComboBoxModel(new String[] {"Ceo", "Gerente", "Administrativo"}));
		
		JLabel lblSeleccioneRol = new JLabel("Por favor, seleccione su rol.");
		lblSeleccioneRol.setBounds(190, 36, 180, 14);
		panel.add(lblSeleccioneRol);
		lblSeleccioneRol.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSeleccioneRol.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblBienvenidoMain = new JLabel("Bienvenido");
		lblBienvenidoMain.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenidoMain.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBienvenidoMain.setBounds(190, 11, 180, 14);
		panel.add(lblBienvenidoMain);
		
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
}
