package capaNegocios;

import java.sql.SQLException;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;
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
	
	/* Registrar */
    public static void subirDatosCliente(int Cedula, String NombreApellido, Date fechaNacimiento, String Email, int Telefono, String Inmuebles, String Tipo) {
        try {
            // Cargar el driver
            if (!cargarDriver()) {
                System.out.println("Error al cargar el driver.");
                return;
            }

            // Establecer la conexión
            conectar = DriverManager.getConnection(url, usuario, pass);

            // Consulta SQL para insertar datos en la tabla "clientes"
            String consulta = "INSERT INTO Clientes (Cedula, NombreApellido, FechaNacimiento, Email, Telefono, Inmueble, Tipo) VALUES (?, ?, ?, ?, ?, ?, ?)";

            // Preparar la sentencia SQL con parámetros
            PreparedStatement preparedStatement = conectar.prepareStatement(consulta);
            preparedStatement.setInt(1, Cedula);
            preparedStatement.setString(2, NombreApellido);
            preparedStatement.setDate(3, fechaNacimiento);
            preparedStatement.setString(4, Email);
            preparedStatement.setInt(5, Telefono);
            preparedStatement.setString(6, Inmuebles);
            preparedStatement.setString(7, Tipo);

            // Ejecutar la consulta
            preparedStatement.executeUpdate();
            
            // Mostramos que se subieron los datos correctamente
            JOptionPane.showMessageDialog(null, "El cliente fue registrado en el sistema.", "Registrando cliente", JOptionPane.PLAIN_MESSAGE);
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
    
    public static void subirDatosContrato(int ContratoNumero, String Tipo, int Cedula, String PadronInmueble, String Descripcion, Date FechaInicio, Date FechaFinal, int PrecioPorMes, String TipoGarantia) {
        try {
            // Cargar el driver
            if (!cargarDriver()) {
                System.out.println("Error al cargar el driver.");
                return;
            }

            // Establecer la conexión
            conectar = DriverManager.getConnection(url, usuario, pass);

            // Consulta SQL para insertar datos en la tabla "clientes"
            String consulta = "INSERT INTO Contrato (ContratoNumero, Tipo, Cedula, PadronInmueble, Descripcion, FechaInicio, FechaFinal, PrecioPorMes, TipoGarantia) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // Preparar la sentencia SQL con parámetros
            PreparedStatement preparedStatement = conectar.prepareStatement(consulta);
            preparedStatement.setInt(1, ContratoNumero);
            preparedStatement.setString(2, Tipo);
            preparedStatement.setInt(3, Cedula);
            preparedStatement.setString(4, PadronInmueble);
            preparedStatement.setString(5, Descripcion);
            preparedStatement.setDate(6, FechaInicio);
            preparedStatement.setDate(7, FechaFinal);
            preparedStatement.setInt(8, PrecioPorMes);
            preparedStatement.setString(9, TipoGarantia);

            // Ejecutar la consulta
            preparedStatement.executeUpdate();
            
            // Mostramos que se subieron los datos correctamente
            JOptionPane.showMessageDialog(null, "El contrato fue registrado en el sistema.", "Registrando contrato", JOptionPane.PLAIN_MESSAGE);
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
    
    public static void subirDatosContratoCompraVenta(int ContratoNumero, String Tipo, int Cedula, String PadronInmueble, String Descripcion, Date Fecha) {
        try {
            // Cargar el driver
            if (!cargarDriver()) {
                System.out.println("Error al cargar el driver.");
                return;
            }

            // Establecer la conexión
            conectar = DriverManager.getConnection(url, usuario, pass);

            // Consulta SQL para insertar datos en la tabla "clientes"
            String consulta = "INSERT INTO Contrato (ContratoNumero, Tipo, Cedula, PadronInmueble, Descripcion, Fecha) VALUES (?, ?, ?, ?, ?, ?)";
            
            // Preparar la sentencia SQL con parámetros
            PreparedStatement preparedStatement = conectar.prepareStatement(consulta);
            preparedStatement.setInt(1, ContratoNumero);
            preparedStatement.setString(2, Tipo);
            preparedStatement.setInt(3, Cedula);
            preparedStatement.setString(4, PadronInmueble);
            preparedStatement.setString(5, Descripcion);
            preparedStatement.setDate(6, Fecha);

            // Ejecutar la consulta
            preparedStatement.executeUpdate();
            
            // Mostramos que se subieron los datos correctamente
            JOptionPane.showMessageDialog(null, "El contrato fue registrado en el sistema.", "Registrando contrato", JOptionPane.PLAIN_MESSAGE);
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
    
    public static void subirDatosTerreno(String Padron, String Ubicacion, int Valor, int Tamaño, String Servicios, String Tipo) {
        try {
            // Cargar el driver
            if (!cargarDriver()) {
                System.out.println("Error al cargar el driver.");
                return;
            }

            // Establecer la conexión
            conectar = DriverManager.getConnection(url, usuario, pass);

            // Consulta SQL para insertar datos en la tabla "clientes"
            String consulta = "INSERT INTO Inmueble (Padron, Ubicacion, Valor, Tamaño, Servicios, Tipo) VALUES (?, ?, ?, ?, ?)";

            // Preparar la sentencia SQL con parámetros
            PreparedStatement preparedStatement = conectar.prepareStatement(consulta);
            preparedStatement.setString(1, Padron);
            preparedStatement.setString(2, Ubicacion);
            preparedStatement.setInt(3, Valor);
            preparedStatement.setInt(4, Tamaño);
            preparedStatement.setString(5, Servicios);
            preparedStatement.setString(6, Tipo);

            // Ejecutar la consulta
            preparedStatement.executeUpdate();

            // Mostramos que se subieron los datos correctamente
            JOptionPane.showMessageDialog(null, "El terreno fue registrado en el sistema.", "Registrando Terreno", JOptionPane.PLAIN_MESSAGE);
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
    
    public static void subirDatosHabitable(String Padron, String Ubicacion, int Valor, int Tamaño, String Tipo, String TipoHabitable, int Cuartos, int Cocina, int Comedor, int Baños, int Living, int Hall, int Garaje, int Gimnasio, int Piscina, int Sauna, int Barbacoa, int Churrasquera) {
        try {
            // Cargar el driver
            if (!cargarDriver()) {
                System.out.println("Error al cargar el driver.");
                return;
            }

            // Establecer la conexión
            conectar = DriverManager.getConnection(url, usuario, pass);

            // Consulta SQL para insertar datos en la tabla "clientes"
            String consulta = "INSERT INTO Inmueble (Padron, Ubicacion, Valor, Tamaño, Tipo, TipoHabitable, Cuartos, Cocina, Comedor, Baños, Living, Hall, Garaje, Gimnasio, Piscina, Sauna, Barbacoa, Churrasquera) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // Preparar la sentencia SQL con parámetros
            PreparedStatement preparedStatement = conectar.prepareStatement(consulta);
            preparedStatement.setString(1, Padron);
            preparedStatement.setString(2, Ubicacion);
            preparedStatement.setInt(3, Valor);
            preparedStatement.setInt(4, Tamaño);
            preparedStatement.setString(5, Tipo);
            preparedStatement.setString(6, TipoHabitable);
            preparedStatement.setInt(7, Cuartos);
            preparedStatement.setInt(8, Cocina);
            preparedStatement.setInt(9, Comedor);
            preparedStatement.setInt(10, Baños);
            preparedStatement.setInt(11, Living);
            preparedStatement.setInt(12, Hall);
            preparedStatement.setInt(13, Garaje);
            preparedStatement.setInt(14, Gimnasio);
            preparedStatement.setInt(15, Piscina);
            preparedStatement.setInt(16, Sauna);
            preparedStatement.setInt(17, Barbacoa);
            preparedStatement.setInt(18, Churrasquera);
            
            // Ejecutar la consulta
            preparedStatement.executeUpdate();
            
            // Mostramos que se subieron los datos correctamente
            JOptionPane.showMessageDialog(null, "El terreno habitable fue registrado en el sistema.", "Registrando terreno habitable", JOptionPane.PLAIN_MESSAGE);
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
    /* Subir datos a MySQL */
    
    
    /* Consultas */
	public static JTable consultar(JTable x, String sentencia, String opcion) {
	    String[] columnas = { "Columna" };

	    switch (opcion) {
	        case "Clientes": {
	            columnas = new String[]{ "Cedula", "Nombre Apellido", "Fecha Nacimiento", "Email", "Telefono", "Inmueble", "Tipo" };
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
	        case "Contrato": {
	        	columnas = new String[]{ "ContratoNumero", "Tipo", "Cedula", "Padron", "Fecha", "Fecha Inicio", "Fecha final", "Duración", "Precio x Mes", "Garantia", "Descripción", "Autorización" };
	        	break;
	        }
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

			//modeloMiTabla.addRow(columnNames);
	        
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
	/* Consultas */

	// Este metodo nos servira para verificar si ya existe un cliente con esta cedula, así podemos evitar errores de claves primarias repetidas
	public static boolean existeCliente(int cedula) {
		String sentencia = "SELECT * FROM Clientes where Cedula='"+cedula+"';";
		boolean encontro = false;

		try {

			// realizar la conexion y abre la base de datos usando la url, el usuario y la
			// contraseña.
			conectar = DriverManager.getConnection(url, usuario, pass);

			// crea la sentencia SQL
			sentenciaSQL = conectar.createStatement();

			// ejecuta la sentencia SQL y guarda el resultado de la consulta
			resultado = sentenciaSQL.executeQuery(sentencia);

			// para consultar el dato, si hay resultado es que el número ya fue registrado
			if (resultado.next()) {
				encontro = true;
			}

			// cierra la conexión
			conectar.close();
			} catch (SQLException e) {
				// para verificar errores
				System.out.println(e.getMessage());
			}
			return encontro;
		}
	
	// Este metodo nos servira para verificar si ya existe un inmueble con ese padron, así podemos evitar errores de claves primarias repetidas
	public static boolean existeInmueble(String padron) {
		String sentencia = "SELECT * FROM Inmueble where Padron='"+padron+"';";
		boolean encontro = false;

		try {

			// realizar la conexion y abre la base de datos usando la url, el usuario y la
			// contraseña.
			conectar = DriverManager.getConnection(url, usuario, pass);

			// crea la sentencia SQL
			sentenciaSQL = conectar.createStatement();

			// ejecuta la sentencia SQL y guarda el resultado de la consulta
			resultado = sentenciaSQL.executeQuery(sentencia);

			// para consultar el dato, si hay resultado es que el número ya fue registrado
			if (resultado.next()) {
				encontro = true;
			}

			// cierra la conexión
			conectar.close();
			} catch (SQLException e) {
				// para verificar errores
				System.out.println(e.getMessage());
			}
			return encontro;
		}
	
	/* Bajas */
	public static void darBaja(String key, String tabla, Object keyBuscarRaw) {
		try {
            // Cargar el driver
            if (!cargarDriver()) {
                System.out.println("Error al cargar el driver.");
                return;
            }

            // Establecer la conexión
            conectar = DriverManager.getConnection(url, usuario, pass);

            // Preparar la sentencia SQL con parámetros
            Statement registro = conectar.createStatement();
            
            // Pasamos el Object a String
            String keyBuscar = keyBuscarRaw.toString();
            
            // Verificar si la cadena contiene solo dígitos
            if (keyBuscar.matches("\\d+")) {
                // Si contiene solo dígitos, convertir a int
                int valorNumerico = Integer.parseInt(keyBuscar);

                // Ejecutar la consulta con el valor numérico
                registro.executeUpdate("DELETE FROM "+tabla+" WHERE "+key+"="+valorNumerico);

                JOptionPane.showMessageDialog(null, "El dato de la tabla " + tabla + " acaba de ser borrado correctamente del sistema.", "Dato borrado", JOptionPane.PLAIN_MESSAGE);
            } else {
                // Si contiene otros caracteres, usar como cadena en la consulta
                registro.executeUpdate("DELETE FROM "+tabla+" WHERE "+key+"='"+keyBuscar+"'");

                JOptionPane.showMessageDialog(null, "El dato de la tabla " + tabla + " acaba de ser borrado correctamente del sistema.", "Dato borrado", JOptionPane.PLAIN_MESSAGE);
            }
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
	
	 /* Actualizar Autorización de Contrato */
    public static void autorizarContrato(int numeroContrato) {
        try {
            // Cargar el driver
            if (!cargarDriver()) {
                System.out.println("Error al cargar el driver.");
                return;
            }

            // Establecer la conexión
            conectar = DriverManager.getConnection(url, usuario, pass);

            // Consulta SQL para actualizar la autorización
            String consulta = "UPDATE Contrato SET Autorización = true WHERE ContratoNumero = ?";

            // Preparar la sentencia SQL con parámetros
            PreparedStatement preparedStatement = conectar.prepareStatement(consulta);
            preparedStatement.setInt(1, numeroContrato);

            // Ejecutar la consulta
            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
            	JOptionPane.showMessageDialog(null, "El contrato numero " + numeroContrato + " acaba de ser autorizado correctamente.", "Autorizado", JOptionPane.ERROR_MESSAGE);
            } else {
            	JOptionPane.showMessageDialog(null, "Error, acaba de ocurrir un error mientras se intantaba autorizar el contrato.", "Error", JOptionPane.ERROR_MESSAGE);
            }
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
    /* Actualizar Autorización de Contrato */
}
