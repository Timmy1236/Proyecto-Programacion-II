package capaNegocios;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

import capaNegocios.MisMetodosDB;

import capaInterface.Interface;
import capaInterface.Interfaz_Registrar_Clientes;
import capaInterface.Interfaz_Registrar_Inmuebles;
import capaInterface.Interfaz_Registrar_Contratos;
import capaInterface.Interfaz_Consulta;
import capaInterface.Interfaz_Consulta_ViewOnly;

public class Aplicacion {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Cargaremos el driver del MySQL, si devuelve true, hacemos visible la interfaz, sino, daremos un mensaje de error.
					if (MisMetodosDB.cargarDriver()) {
						Interface aplicacion = new Interface();
						aplicacion.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Error en la aplicación no puede iniciar");
						System.exit(0);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void abrirRegistrarClientes() {
		Interfaz_Registrar_Clientes frame = new Interfaz_Registrar_Clientes();
		frame.setVisible(true);
	}
	
	public static void abrirRegistrarInmuebles() {
		Interfaz_Registrar_Inmuebles frame = new Interfaz_Registrar_Inmuebles();
		frame.setVisible(true);
	}
	
	public static void abrirRegistrarContratos() {
		Interfaz_Registrar_Contratos frame = new Interfaz_Registrar_Contratos();
		frame.setVisible(true);
	}
	
	public static void abrirConsultaDeDatos() {
		Interfaz_Consulta frame = new Interfaz_Consulta();
		frame.setVisible(true);
	}
	
	public static void abrirConsultaDeDatosViewonly() {
		Interfaz_Consulta_ViewOnly frame = new Interfaz_Consulta_ViewOnly();
		frame.setVisible(true);
	}
}