CREATE DATABASE Tienda_Videos;
USE Tienda_Videos;

CREATE TABLE TBL_CLIENTES (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre_cliente VARCHAR(50) NOT NULL,
    apellido_cliente VARCHAR(50) NOT NULL,
    direccion_cliente VARCHAR(100),
    telefono_cliente VARCHAR(15),
    correo_cliente VARCHAR(100) NOT NULL UNIQUE,
    estado_cliente ENUM('activo', 'inactivo') DEFAULT 'activo'
);

CREATE TABLE TBL_VIDEOS (
    id_video INT AUTO_INCREMENT PRIMARY KEY,
    titulo_video VARCHAR(50) NOT NULL,
    precio_video FLOAT(10, 2) NOT NULL,
    año_estreno_video VARCHAR(50) NOT NULL,
    genero_video VARCHAR(50) NOT NULL,
    actores_video VARCHAR(100) NOT NULL,
    sintesis_video VARCHAR(100) NOT NULL,
    existencia_video VARCHAR(50) NOT NULL,
    formato_video VARCHAR(50) NOT NULL
);

CREATE TABLE TBL_ADMINISTRADORES (
    id_admin INT AUTO_INCREMENT PRIMARY KEY,
    nombre_admin VARCHAR(50) NOT NULL,
    apellido_admin VARCHAR(50) NOT NULL,
    direccion_admin VARCHAR(100),
    telefono_admin VARCHAR(15),
    correo_admin VARCHAR(100) NOT NULL UNIQUE,
    contraseña_admin VARCHAR(255) NOT NULL,
    estado_admin ENUM('activo', 'inactivo') DEFAULT 'activo',
    nombre_usuario VARCHAR(50) NOT NULL
);

CREATE TABLE TBL_ALQUILERES (
    id_comprobante INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT,
    fecha_alquiler DATE NOT NULL,
    fecha_devolucion DATE,
    estatus_alquiler ENUM('Rentado', 'Devuelto') DEFAULT 'Rentado',
    id_video INT NOT NULL,
    FOREIGN KEY (id_video) REFERENCES TBL_VIDEOS(id_video),
    FOREIGN KEY (id_cliente) REFERENCES TBL_CLIENTES(id_cliente)
); 

CREATE TABLE TBL_SISTEMA_DE_PAGOS  (
    id_sispag INT AUTO_INCREMENT PRIMARY KEY,
    id_comprobante INT,
    pago DECIMAL(10, 2) NOT NULL,
    tipo_sispag ENUM('efectivo', 'tarjeta_credito', 'tarjeta_debito') NOT NULL,
    descuento_sispag INT NULL,
    mora_sispag INT NULL, 
    id_admin INT NOT NULL,
    FOREIGN KEY (id_admin) REFERENCES TBL_ADMINISTRADORES(id_admin),
    FOREIGN KEY (id_comprobante) REFERENCES TBL_ALQUILERES(id_comprobante)
);

CREATE TABLE IF NOT EXISTS TBL_TIPO_USUARIO (
	id_tipo_usuario INT NOT NULL AUTO_INCREMENT,
	nombre_Tusuario VARCHAR(60) NOT NULL,
	status_Tusuario VARCHAR(60) NOT NULL,
	PRIMARY KEY (id_tipo_usuario) );

CREATE TABLE IF NOT EXISTS TBL_USUARIO (
	id_usuario INT NOT NULL AUTO_INCREMENT,
	nombre_usuario VARCHAR(45) NOT NULL,
	contraseña_usuario VARCHAR(25) NOT NULL,
	ultima_sesion_usuario VARCHAR(25),
	status_usuario VARCHAR(1) NOT NULL,
	nombre_real_usuario VARCHAR(60),
	correo_usuario VARCHAR(60),
	telefono_usuario VARCHAR(25),
	direccion_usuario VARCHAR(80),
    id_tipo_usuario INT NOT NULL,
	PRIMARY KEY (id_usuario),
    FOREIGN KEY (id_tipo_usuario) REFERENCES TBL_TIPO_USUARIO  (id_tipo_usuario)
    );
    
	CREATE TABLE IF NOT EXISTS TBL_BITACORAS (
    id_bitacora int auto_increment PRIMARY KEY,
    fecha_bitacora datetime NULL, 
	accion_bitacora VARCHAR(10) NOT NULL,
    ip_pc_bitacora VARCHAR(25) NOT NULL,
    nombre_pc_bitacor VARCHAR(25) NOT NULL,
    id_admin INT NULL,
    id_usuario INT NULL,
    FOREIGN KEY (id_admin) REFERENCES TBL_ADMINISTRADORES(id_admin), 
    FOREIGN KEY (id_usuario) REFERENCES TBL_USUARIO(id_usuario) 
);	