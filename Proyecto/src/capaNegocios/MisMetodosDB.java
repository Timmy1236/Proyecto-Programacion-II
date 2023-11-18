package capaNegocios;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class MisMetodosDB {

	public static String usuario = "root";
	public static String pass = "MYSQL;DevTesting123";
	public static String baseDeDatos = "mi_base_de_datos";
	public static String url = "jdbc:mysql://localhost:3306/" + baseDeDatos;

	public static Connection conectar = null;
	public static Statement sentenciaSQL = null;
	public static ResultSet resultado = null;

	// Método que carga el driver para conectar con MySQL
	public static boolean cargarDriver() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	// NOTE: ESTO ES UN TEST, BORRARLO!!
    public static void obtenerDatosRegistroCliente(int cedula, String nombre, String apellido, String email, int telefono, String inmuebles, String tipo) {
    	System.out.println("Datos del cliente para registro obtenidos!");
    	System.out.println(cedula);
    	System.out.println(nombre);
    	System.out.println(apellido);
    	System.out.println(email);
    	System.out.println(telefono);
    	System.out.println(inmuebles);
    	System.out.println(tipo);
    	
    	// TODO!!: Subirlo a MYSQL :)
    }
}