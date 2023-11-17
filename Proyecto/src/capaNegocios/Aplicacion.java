package capaNegocios;

import javax.swing.JOptionPane;
import capaNegocios.MisMetodosDB;
import capaInterface.Interface;

public class Aplicacion {

	public static void main(String[] args) {
		
		try {
			// Cargaremos el driver del MySQL, si devuelve true, hacemos visible la interfaz, sino, daremos un mensaje de error.
			if (MisMetodosDB.cargarDriver()) {
				Interface aplicacion = new Interface();
				aplicacion.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "Error en la aplicación  no puede iniciar");
				System.exit(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}