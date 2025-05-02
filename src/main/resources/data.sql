INSERT INTO CLIENTES (NOMBRE, DIRECCION, TELEFONO, EMAIL)
VALUES
    ('Juan Pérez', 'Calle Falsa 123', '1234567890', 'juan@example.com'),
    ('Ana Gómez', 'Avenida Siempre Viva 456', '0987654321', 'ana@example.com');

INSERT INTO REPUESTOS (CODIGO, NOMBRE, MARCA, PRECIO)
VALUES
    (1, 'Amortiguador', 'Sachs', 30000.00),
    (2, 'Caliper', 'Brembo', 50000.00),
    (3, 'Embrague', 'Sachs', 130000.00);

INSERT INTO FACTURAS (CLIENTE_ID, FECHA_EMISION, TOTAL)
VALUES
    (1, '2025-04-20', 60000.00),
    (2, '2025-04-21', 80000.00);