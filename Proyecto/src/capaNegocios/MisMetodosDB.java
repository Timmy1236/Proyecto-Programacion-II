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
    public static void subirDatosCliente(int Cedula, String NombreApellido, String fechaNacimiento, String Email, int Telefono, String Inmuebles, String Tipo) {
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
            preparedStatement.setString(3, fechaNacimiento);
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
    /* Registrar */
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
    
    public static void subirDatosTerreno(String Padron, String Ubicacion, int Valor, int Tamaño, String Servicios) {
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
            preparedStatement.setString(1, Padron);
            preparedStatement.setString(2, Ubicacion);
            preparedStatement.setInt(3, Valor);
            preparedStatement.setInt(4, Tamaño);
            preparedStatement.setString(5, Servicios);

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
    public static void subirDatosHabitable(String Padron, String Ubicacion, int Valor, int Tamaño, String Tipo, int Cuartos, int Cocina, int Comedor, int Baños, int Living, int Hall, int Garaje, int Gimnasio, int Piscina, int Sauna, int Barbacoa, int Churrasquera) {
        try {
            // Cargar el driver
            if (!cargarDriver()) {
                System.out.println("Error al cargar el driver.");
                return;
            }

            // Establecer la conexión
            conectar = DriverManager.getConnection(url, usuario, pass);

            // Consulta SQL para insertar datos en la tabla "clientes"
            String consulta = "INSERT INTO Inmueble_Habitable (Padron, Ubicacion, Valor, Tamaño, Tipo, Cuartos, Cocina, Comedor, Baños, Living, Hall, Garaje, Gimnasio, Piscina, Sauna, Barbacoa, Churrasquera) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // Preparar la sentencia SQL con parámetros
            PreparedStatement preparedStatement = conectar.prepareStatement(consulta);
            preparedStatement.setString(1, Padron);
            preparedStatement.setString(2, Ubicacion);
            preparedStatement.setInt(3, Valor);
            preparedStatement.setInt(4, Tamaño);
            preparedStatement.setString(5, Tipo);
            preparedStatement.setInt(6, Cuartos);
            preparedStatement.setInt(7, Cocina);
            preparedStatement.setInt(8, Comedor);
            preparedStatement.setInt(9, Baños);
            preparedStatement.setInt(10, Living);
            preparedStatement.setInt(11, Hall);
            preparedStatement.setInt(12, Garaje);
            preparedStatement.setInt(13, Gimnasio);
            preparedStatement.setInt(14, Piscina);
            preparedStatement.setInt(15, Sauna);
            preparedStatement.setInt(16, Barbacoa);
            preparedStatement.setInt(17, Churrasquera);
            
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
	
    
    public static void registrarCliente(int cedula, String nombreApellido, String fechaNacimiento, String email, int telefono, String inmuebles, String tipo) {
    	// TODO: Validar(?
    	// Subimos los datos recibidos a MySQL
    	subirDatosCliente(cedula, nombreApellido, fechaNacimiento, email, telefono, inmuebles, tipo);
    }
    
    public static void registrarTerreno(String padron, String ubicacion, int valor, int tamaño, String servicios) {
    	// TODO: Validar(?
    	// Subimos los datos recibidos a MySQL
    	subirDatosTerreno(padron, ubicacion, valor, tamaño, servicios);
    }
    
    public static void registrarHabitable(String padron, String ubicacion, int valor, int tamaño, String tipo, int cuartos, int cocina, int comedor, int baños, int living, int hall, int garaje, int gimnasio, int piscina, int sauna, int barbacoa, int churrasquera) {
    	// TODO: Validar(?
    	// Subimos los datos recibidos a MySQL
    	subirDatosHabitable(padron, ubicacion, valor, tamaño, tipo, cuartos, cocina, comedor, baños, living, hall, garaje, gimnasio, piscina, sauna, barbacoa, churrasquera);
    }
    
    
    /* Consultas */
	public static JTable consultar(JTable x, String sentencia, String opcion) {
		
		// Definir las columnas y nombres por defecto
	    String[] columnas = { "Cedula", "NombreApellido", "FechaNacimiento", "Email", "Telefono", "Inmueble", "Tipo" };

	    switch (opcion) {
	        case "Clientes": {
	            columnas = new String[]{ "Cedula", "NombreApellido", "FechaNacimiento", "Email", "Telefono", "Inmueble", "Tipo" };
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
	        	columnas = new String[]{ "NumeroContrato", "Tipo", "Cedula", "PadronTerreno", "PadronHabitable", "Fecha", "Fecha Inicio", "Fecha final", "Descripcion", "Precio x Mes", "Garantia" };
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
	
	// Método que permite cargar todas las JTable de la aplicación
	public static JTable consultarClientes(JTable x, String sentencia) {

			// Declaro el modelo de la tabla
			DefaultTableModel modeloMiTabla;

			// cantidad de columnas de la JTABLE
			String columnas[] = { "Cedula", "NombreApellido", "FechaNacimiento", "Email", "Telefono", "Inmueble", "Tipo" };

			// filas en las columnas con 3 datos
			Object filas[] = new Object[7];

			modeloMiTabla = new DefaultTableModel(null,columnas) {
				// esta línea es requerida solo si la versión de java lo solicita
				private static final long serialVersionUID = 1L;

				// este método isCellEditable se utiliza para que la Table no sea editable
				// que solo se utiliza para visualizar datos, si no se aplica los datos
				// cuando se muestran son editables, no se cambian en la base de datos
				// solo son editables en la ejecución de la aplicación
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}

			};

			//modifica todo el encabezado de la siguiente manera

			// cambia el tipo de letra del encabezado de la tabla

			x.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 15));

			// cambia el fondo del encabezado de la tabla

			x.getTableHeader().setBackground(new Color(255, 204, 204));

			// cambia el color de la letra del encabezado de la tabla

			x.getTableHeader().setForeground(Color.BLACK);

			try {

				conectar = DriverManager.getConnection(url, usuario, pass);

				sentenciaSQL = conectar.createStatement();

				resultado = sentenciaSQL.executeQuery(sentencia);

				while (resultado.next()) {

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
				// TODO: handle exception
				System.out.println(e.getMessage());
			}

			return x;
		}

	// Método que permite cargar todas las JTable de la aplicación
	public static JTable cargarInmueblesTerrenoTable(JTable x, String sentencia) {

				// Declaro el modelo de la tabla
				DefaultTableModel modeloMiTabla;

				// cantidad de columnas de la JTABLE
				String columnas[] = { "Padron", "Ubicacion", "Valor", "Tamaño", "Servicios" };

				// filas en las columnas con 3 datos
				Object filas[] = new Object[5];

				modeloMiTabla = new DefaultTableModel(null,columnas) {
					// esta línea es requerida solo si la versión de java lo solicita
					private static final long serialVersionUID = 1L;

					// este método isCellEditable se utiliza para que la Table no sea editable
					// que solo se utiliza para visualizar datos, si no se aplica los datos
					// cuando se muestran son editables, no se cambian en la base de datos
					// solo son editables en la ejecución de la aplicación
					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}

				};

				//modifica todo el encabezado de la siguiente manera

				// cambia el tipo de letra del encabezado de la tabla

				x.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 15));

				// cambia el fondo del encabezado de la tabla

				x.getTableHeader().setBackground(new Color(255, 204, 204));

				// cambia el color de la letra del encabezado de la tabla

				x.getTableHeader().setForeground(Color.BLACK);

				try {

					conectar = DriverManager.getConnection(url, usuario, pass);

					sentenciaSQL = conectar.createStatement();

					resultado = sentenciaSQL.executeQuery(sentencia);

					while (resultado.next()) {

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
					// TODO: handle exception
					System.out.println(e.getMessage());
				}

				return x;
			}

	// Método que permite cargar todas las JTable de la aplicación
	public static JTable cargarInmueblesHabitableTable(JTable x, String sentencia) {

						// Declaro el modelo de la tabla
						DefaultTableModel modeloMiTabla;

						// cantidad de columnas de la JTABLE
						String columnas[] = { "Padron", "Ubicacion", "Valor", "Tamaño", "Tipo", "Baños", "Cuartos", "Cocina", "Comedor", "Living", "Hall", "Garaje", "Gimnasio", "Piscina", "Sauna", "Barbacoa", "Churrasquero" };

						// filas en las columnas con 3 datos
						Object filas[] = new Object[17];

						modeloMiTabla = new DefaultTableModel(null,columnas) {
							// esta línea es requerida solo si la versión de java lo solicita
							private static final long serialVersionUID = 1L;

							// este método isCellEditable se utiliza para que la Table no sea editable
							// que solo se utiliza para visualizar datos, si no se aplica los datos
							// cuando se muestran son editables, no se cambian en la base de datos
							// solo son editables en la ejecución de la aplicación
							@Override
							public boolean isCellEditable(int row, int column) {
								return false;
							}

						};

						//modifica todo el encabezado de la siguiente manera

						// cambia el tipo de letra del encabezado de la tabla

						x.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 15));

						// cambia el fondo del encabezado de la tabla

						x.getTableHeader().setBackground(new Color(255, 204, 204));

						// cambia el color de la letra del encabezado de la tabla

						x.getTableHeader().setForeground(Color.BLACK);

						try {

							conectar = DriverManager.getConnection(url, usuario, pass);

							sentenciaSQL = conectar.createStatement();

							resultado = sentenciaSQL.executeQuery(sentencia);

							while (resultado.next()) {

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
							// TODO: handle exception
							System.out.println(e.getMessage());
						}

						return x;
					}
	
	// Método que buscara si ya existe el cliente
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
	
	// Método que buscara si ya existe el cliente
	public static boolean existeInmueble_habitable(String padron) {
		String sentencia = "SELECT * FROM Inmueble_habitable where Padron='"+padron+"';";
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
	
	// Método que buscara si ya existe el cliente
		public static boolean existeInmueble_terreno(String padron) {
			String sentencia = "SELECT * FROM Inmueble_terreno where Padron='"+padron+"';";
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
	public static void darBajaCliente(int cedula) {
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

            // Ejecutar la consulta
            registro.executeUpdate("DELETE FROM Clientes WHERE Cedula='"+cedula+"'");

            JOptionPane.showMessageDialog(null, "El cliente fue borrado del sistema.", "Borrar Cliente", JOptionPane.PLAIN_MESSAGE);

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
	
	public static void darBajaTerreno(String padron) {
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

            // Ejecutar la consulta
            registro.executeUpdate("DELETE FROM Inmueble_Terreno WHERE Padron='"+padron+"'");

            JOptionPane.showMessageDialog(null, "El terreno fue borrado del sistema.", "Borrar Terreno", JOptionPane.PLAIN_MESSAGE);
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
	
	public static void darBajaHabitable(String padron) {
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

            // Ejecutar la consulta
            registro.executeUpdate("DELETE FROM Inmueble_Habitable WHERE P='"+padron+"'");

            JOptionPane.showMessageDialog(null, "El inmueble habitable fue borrado del sistema.", "Borrar Inmueble Habitable", JOptionPane.PLAIN_MESSAGE);
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

}