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
    
    public static void registrarTerreno(int padron, String ubicacion, int valor, int tamaño, String servicios) {
    	System.out.println("Datos del terreno para registro obtenidos!");
    	System.out.println(padron);
    	System.out.println(ubicacion);
    	System.out.println(valor);
    	System.out.println(tamaño);
    	System.out.println(servicios);

    	// TODO!!: Subirlo a MySQL :)
    }
    
    // NOTE: En estos momentos es cuando empiezo a cuestionar si realmente estoy haciendo algo bien o mal. -Ignacio Dortta
    // LINK: https://timmy1236.me/assets/images/huh.png
    public static void registrarHabitable(int padron, String ubicacion, int valor, int tamaño, String tipo, int cuartos, int cocina, int comedor, int living, int hall, int garaje, int piscina, int sauna, int barbacoa, int churrasquera) {
    	System.out.println("Datos del terreno para registro obtenidos!");
    	System.out.println(padron);
    	System.out.println(ubicacion);
    	System.out.println(valor);
    	System.out.println(tamaño);
    	System.out.println(tipo);
    	System.out.println(cuartos);
    	System.out.println(cocina);
    	System.out.println(comedor);
    	System.out.println(living);
    	System.out.println(hall);
    	System.out.println(garaje);
    	System.out.println(piscina);
    	System.out.println(sauna);
    	System.out.println(barbacoa);
    	System.out.println(churrasquera);
    	
    	// TODO!!: Subirlo a MySQL :)
    }
}