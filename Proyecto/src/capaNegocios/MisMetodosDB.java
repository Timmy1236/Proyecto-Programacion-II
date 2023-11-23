package capaNegocios;

import java.sql.SQLException;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
    
    
    
    /* Consultas */
	public static JTable consultarClientes(JTable x, String sentencia, String opcion) {
		
		// Definir las columnas y nombres por defecto
	    String[] columnas = { "Nombre", "Teléfono", "Apellido", "Fecha Nacimiento", "Email", "Telefono", "Inmueble", "Vendedor?" };

	    switch (opcion) {
	        case "Clientes": {
	            columnas = new String[]{ "Nombre", "Teléfono", "Apellido", "Fecha Nacimiento", "Email", "Telefono", "Inmueble", "Vendedor?" };
	            break;
	        }
	        case "Inmueble_Terreno": {
	        	columnas = new String[]{ "Padron", "Ubicacion", "Valor", "Tamaño", "Servicios" };
	            break;
	        }
	        case "Inmueble_Habitable": {
	        	columnas = new String[]{ "Padron", "Ubicacion", "Valor", "Tamaño", "Tipo", "Baños", "Cuartos", "Cocina", "Comedor", "Living", "Hall", "Garaje", "Gimnasio", "Piscina", "Sauna", "Barbacoa", "Churrasquero" };
	            break;
	        }
	        // TODO: Agregar el caso cuando es un contrato!
	        default: {
	            System.out.println("Error"); // Esto no deberia de pasar.
	        }
	    }
	
		// Declaro el modelo de la tabla
		DefaultTableModel modeloMiTabla;

		modeloMiTabla = new DefaultTableModel(null,columnas) {
			// esta línea es requerida solo si la versión de java lo solicita
			private static final long serialVersionUID = 1L;
			// este método isCellEditable se utiliza para que la Table no sea editable
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		try {
			conectar = DriverManager.getConnection(url, usuario, pass);
			sentenciaSQL = conectar.createStatement();
			resultado = sentenciaSQL.executeQuery(sentencia);
			
			// Agregamos la primera fila que describira que es cada columna
			Vector<String> columnNames = new Vector<>();
			for (String columna : columnas) {
			    columnNames.add(columna);
			}

			modeloMiTabla.addRow(columnNames);
	        
			// Por cada fila que haya en la tabla, se creara una nueva fila en JTable y se añadira los datos del MySQL
			while (resultado.next()) {
				Object[] filas = new Object[columnas.length];
				for (int i = 0; i < filas.length; i++) {
					filas[i] = resultado.getObject(i + 1);
				}
				modeloMiTabla.addRow(filas);
			}
			
			// Cierra la Base de Datos
			conectar.close();
			x.setModel(modeloMiTabla);
			modeloMiTabla.removeTableModelListener(x);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return x;
	}
}