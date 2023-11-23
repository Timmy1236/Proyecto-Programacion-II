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
	
	// Método para subir datos del cliente a la tabla "clientes"
    public static void subirDatosCliente(int Cedula, String Nombre, String Apellido, String fechaNacimiento, String Email, int Telefono, String Inmuebles, String Tipo) {
        try {
            // Cargar el driver
            if (!cargarDriver()) {
                System.out.println("Error al cargar el driver.");
                return;
            }

            // Establecer la conexión
            conectar = DriverManager.getConnection(url, usuario, pass);

            // Consulta SQL para insertar datos en la tabla "clientes"
            String consulta = "INSERT INTO Clientes (Cedula, Nombre, Apellido, FechaNacimiento, Email, Telefono, Inmueble, Tipo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            // Preparar la sentencia SQL con parámetros
            PreparedStatement preparedStatement = conectar.prepareStatement(consulta);
            preparedStatement.setInt(1, Cedula);
            preparedStatement.setString(2, Nombre);
            preparedStatement.setString(3, Apellido);
            preparedStatement.setString(4, fechaNacimiento);
            preparedStatement.setString(5, Email);
            preparedStatement.setInt(6, Telefono);
            preparedStatement.setString(7, Inmuebles);
            preparedStatement.setString(8, Tipo);

            // Ejecutar la consulta
            preparedStatement.executeUpdate();

            System.out.println("Datos del cliente registrados en la tabla clientes.");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar la conexión
            try {
                if (conectar != null) {
                    conectar.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
 // Método para subir datos del cliente a la tabla "clientes"
    public static void subirDatosTerreno(int Padron, String Ubicacion, int Valor, int Tamaño, String Servicios) {
        try {
            // Cargar el driver
            if (!cargarDriver()) {
                System.out.println("Error al cargar el driver.");
                return;
            }

            // Establecer la conexión
            conectar = DriverManager.getConnection(url, usuario, pass);

            // Consulta SQL para insertar datos en la tabla "clientes"
            String consulta = "INSERT INTO Inmueble_Terreno (Padron, Ubicacion, Valor, Tamaño, Servicios) VALUES (?, ?, ?, ?, ?)";

            // Preparar la sentencia SQL con parámetros
            PreparedStatement preparedStatement = conectar.prepareStatement(consulta);
            preparedStatement.setInt(1, Padron);
            preparedStatement.setString(2, Ubicacion);
            preparedStatement.setInt(3, Valor);
            preparedStatement.setInt(4, Tamaño);
            preparedStatement.setString(5, Servicios);

            // Ejecutar la consulta
            preparedStatement.executeUpdate();

            System.out.println("Datos del cliente registrados en la tabla clientes.");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar la conexión
            try {
                if (conectar != null) {
                    conectar.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
	
	// NOTE: ESTO ES UN TEST, MODIFICARLO!!
    public static void obtenerDatosRegistroCliente(int cedula, String nombre, String apellido, String fechaNacimiento, String email, int telefono, String inmuebles, String tipo) {
    	// Subimos los datos recibidos a MySQL
    	subirDatosCliente(cedula, nombre, apellido, fechaNacimiento, email, telefono, inmuebles, tipo);
    }
    
    public static void registrarTerreno(int padron, String ubicacion, int valor, int tamaño, String servicios) {
    	System.out.println("Datos del terreno para registro obtenidos!");
    	System.out.println(padron);
    	System.out.println(ubicacion);
    	System.out.println(valor);
    	System.out.println(tamaño);
    	System.out.println(servicios);
    	
    	subirDatosTerreno(padron, ubicacion, valor, tamaño, servicios);

    	// TODO!!: Subirlo a MySQL :)
    }
    
    // NOTE: En estos momentos es cuando empiezo a cuestionar si realmente estoy haciendo algo bien o algo malo. -Ignacio Dortta
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