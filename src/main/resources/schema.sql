DROP TABLE IF EXISTS FACTURAS;
DROP TABLE IF EXISTS REPUESTOS;
DROP TABLE IF EXISTS CLIENTES;

CREATE TABLE CLIENTES (
    ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    NOMBRE VARCHAR(150) NOT NULL,
    DIRECCION VARCHAR(250),
    TELEFONO VARCHAR(20),
    EMAIL VARCHAR(100)
);

CREATE TABLE REPUESTOS (
   CODIGO INT NOT NULL PRIMARY KEY,
    NOMBRE VARCHAR(150) NOT NULL,
    MARCA VARCHAR(150) NOT NULL,
    PRECIO INT NOT NULL
    Stock INT NOT NULL
);

CREATE TABLE FACTURAS (
    ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    CLIENTE_ID INT NOT NULL,
    FECHA_EMISION DATE NOT NULL,
    TOTAL DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (CLIENTE_ID) REFERENCES CLIENTES(ID)
);

