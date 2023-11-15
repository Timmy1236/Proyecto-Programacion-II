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
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Interface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Interface() {
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
}
