CREATE DATABASE IF NOT EXISTS mi_base_de_datos;
USE mi_base_de_datos;

CREATE TABLE IF NOT EXISTS Clientes (
    Cedula INT(8) NOT NULL PRIMARY KEY,
    NombreApellido VARCHAR(50) NOT NULL,
    FechaNacimiento DATE NOT NULL,
    Email VARCHAR(50) NOT NULL,
    Telefono INT(9) NOT NULL,
    Inmueble VARCHAR(100) NOT NULL,
    Tipo ENUM('Dueño', 'Comprador/Alquila')
);

CREATE TABLE IF NOT EXISTS Inmueble (
	Padron CHAR(14) NOT NULL PRIMARY KEY,
    Ubicacion VARCHAR(50) NOT NULL,
    Valor INT NOT NULL,
    Tamaño INT NOT NULL,
    Servicios VARCHAR(50),
    Tipo ENUM('Terreno', 'Habitable'),
    TipoHabitable ENUM('Apartamento', 'Casa', 'Mejoras'),
    Baños SMALLINT,
    Cuartos SMALLINT,
    Cocina SMALLINT,
    Comedor SMALLINT,
    Living SMALLINT,
    Hall SMALLINT,
    Garaje SMALLINT,
    Gimnasio SMALLINT,
    Piscina SMALLINT,
    Sauna SMALLINT,
    Barbacoa SMALLINT,
    Churrasquera SMALLINT
);

CREATE TABLE IF NOT EXISTS Contrato (
	ContratoNumero INT NOT NULL,
    Tipo ENUM('Compra/Venta', 'Alquila'),
    Cedula INT NOT NULL,
    PadronInmueble CHAR(14),
    PRIMARY KEY (ContratoNumero),
    FOREIGN KEY (PadronInmueble) REFERENCES Inmueble(Padron) ON DELETE CASCADE,
    FOREIGN KEY (Cedula) REFERENCES Clientes(Cedula) ON DELETE CASCADE,
    Fecha DATETIME,
    FechaInicio DATETIME,
    FechaFinal DATETIME,
    Duracion INT,
    PrecioPorMes INT,
    TipoGarantia ENUM('Anda', 'Contaduria', 'Depósito'),
    Descripcion VARCHAR(100) NOT NULL,
    Autorización BOOL
);