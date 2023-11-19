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

public class Interfaz_Registrar_Inmuebles extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNDePadron;
	private JTextField textUbicacion;

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
		setTitle("Registrador de Inmuebles (1/2)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNDePadron = new JLabel("N° de Padron");
		lblNDePadron.setBounds(44, 62, 127, 14);
		contentPane.add(lblNDePadron);
		
		JLabel lblUbicacindepartamentoCalle = new JLabel("Ubicación");
		lblUbicacindepartamentoCalle.setBounds(44, 87, 127, 14);
		contentPane.add(lblUbicacindepartamentoCalle);
		
		textNDePadron = new JTextField();
		textNDePadron.setColumns(10);
		textNDePadron.setBounds(181, 59, 200, 20);
		contentPane.add(textNDePadron);
		
		textUbicacion = new JTextField();
		textUbicacion.setColumns(10);
		textUbicacion.setBounds(181, 84, 200, 20);
		contentPane.add(textUbicacion);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar.setBounds(181, 211, 200, 42);
		contentPane.add(btnCancelar);
		
		JLabel lblNewLabel_1 = new JLabel("Departamento, calle y nº de puerta");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_1.setBounds(181, 104, 200, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
			}
		});
		btnContinuar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnContinuar.setBounds(181, 158, 200, 42);
		contentPane.add(btnContinuar);
	}
}
