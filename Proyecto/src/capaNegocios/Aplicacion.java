package capaNegocios;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

import capaNegocios.MisMetodosDB;
import capaInterface.Interface;
import capaInterface.Interfaz_Registrar_Clientes;

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
				} catch (Exception e) { // Se fue todo a la mierda.
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void abrirRegistrarClientes() {
		Interfaz_Registrar_Clientes frame = new Interfaz_Registrar_Clientes();
		frame.setVisible(true);
	}
}