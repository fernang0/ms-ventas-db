CREATE TABLE cliente (
  id_cliente BIGINT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  contrasena VARCHAR(255) NOT NULL,
  direccion VARCHAR(200) NOT NULL,
  email VARCHAR(100) UNIQUE NOT NULL,
  telefono VARCHAR(20)
);

CREATE TABLE proveedor (
  id_proveedor INT PRIMARY KEY,
  nombre VARCHAR(100),
  email VARCHAR(100),
  telefono VARCHAR(20)
);

CREATE TABLE descuento (
  id_descuento INT PRIMARY KEY,
  codigo VARCHAR(50),
  porcentaje DECIMAL(5,2),
  fecha_inicio DATE,
  fecha_fin DATE
);

CREATE TABLE empleado_logistica (
  id_empleadologistica INT PRIMARY KEY,
  nombre VARCHAR(100),
  email VARCHAR(100),
  telefono VARCHAR(20)
);

CREATE TABLE producto (
  id_producto BIGINT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  descripcion TEXT,
  precio DECIMAL(10,2) NOT NULL,
  stock INT,
  proveedor_id INT,
  FOREIGN KEY (proveedor_id) REFERENCES proveedor(id_proveedor)
);

CREATE TABLE pedido (
  id_pedido BIGINT PRIMARY KEY,
  cliente_id BIGINT,
  fecha TIMESTAMP NOT NULL,
  estado ENUM('Pendiente', 'Pagado', 'Enviado', 'Cancelado') NOT NULL,
  total DECIMAL(10,2) NOT NULL,
  descuento_id INT NULL,
  FOREIGN KEY (cliente_id) REFERENCES cliente(id_cliente),
  FOREIGN KEY (descuento_id) REFERENCES descuento(id_descuento)
);

CREATE TABLE detalle_pedido (
  id_detalle BIGINT PRIMARY KEY,
  pedido_id BIGINT,
  producto_id BIGINT,
  cantidad INT,
  precio_unitario DECIMAL(10,2) NOT NULL,
  FOREIGN KEY (pedido_id) REFERENCES pedido(id_pedido),
  FOREIGN KEY (producto_id) REFERENCES producto(id_producto)
);

CREATE TABLE pago (
  id_pago BIGINT PRIMARY KEY,
  pedido_id BIGINT UNIQUE,
  monto DECIMAL(10,2),
  metodo_pago VARCHAR(50),
  fecha_pago TIMESTAMP,
  FOREIGN KEY (pedido_id) REFERENCES pedido(id_pedido)
);

CREATE TABLE factura (
  id_factura BIGINT PRIMARY KEY,
  pedido_id BIGINT UNIQUE,
  fecha_emision TIMESTAMP,
  total DECIMAL(10,2),
  FOREIGN KEY (pedido_id) REFERENCES pedido(id_pedido)
);

CREATE TABLE envio (
  id_envio BIGINT PRIMARY KEY,
  pedido_id BIGINT UNIQUE,
  direccion_entrega VARCHAR(200),
  fecha_envio DATE,
  estado VARCHAR(20),
  empleado_logistica_id INT,
  FOREIGN KEY (pedido_id) REFERENCES pedido(id_pedido),
  FOREIGN KEY (empleado_logistica_id) REFERENCES empleado_logistica(id_empleadologistica)
);


-- CLIENTES
INSERT INTO cliente VALUES
(1, 'Carlos Díaz', 'pass123', 'Av. Siempre Viva 742', 'carlos@example.com', '912345678'),
(2, 'Laura Gómez', 'pass456', 'Calle Falsa 123', 'laura@example.com', '987654321');

-- PROVEEDORES
INSERT INTO proveedor VALUES
(1, 'Distribuidora Sur', 'contacto@distsur.cl', '222333444'),
(2, 'Importadora Andes', 'ventas@andes.cl', '223344556');

-- DESCUENTOS
INSERT INTO descuento VALUES
(1, 'DESC10', 10.00, '2025-06-01', '2025-06-30'),
(2, 'DESC20', 20.00, '2025-06-15', '2025-07-15');

-- EMPLEADOS DE LOGÍSTICA
INSERT INTO empleado_logistica VALUES
(1, 'Marcelo Soto', 'marcelo@logistica.cl', '933112233'),
(2, 'Paula Reyes', 'paula@logistica.cl', '933445566');

-- PRODUCTOS
INSERT INTO producto VALUES
(1, 'Perfume Clásico', 'Perfume de aroma suave y duradero', 19990, 50, 1),
(2, 'Perfume Floral', 'Aroma fresco con notas florales', 25990, 30, 1),
(3, 'Perfume Amaderado', 'Fragancia intensa con base de madera', 28990, 20, 2);

-- PEDIDOS
INSERT INTO pedido VALUES
(1, 1, '2025-06-18 10:00:00', 'Pagado', 44981.00, 1),
(2, 2, '2025-06-19 11:30:00', 'Pendiente', 51981.00, 2);

-- DETALLE PEDIDO
INSERT INTO detalle_pedido VALUES
(1, 1, 1, 2, 19990),
(2, 1, 2, 1, 25990),
(3, 2, 3, 2, 28990);

-- PAGOS
INSERT INTO pago VALUES
(1, 1, 44981.00, 'Tarjeta de crédito', '2025-06-18 10:05:00');

-- FACTURAS
INSERT INTO factura VALUES
(1, 1, '2025-06-18 10:10:00', 44981.00);

-- ENVIOS
INSERT INTO envio VALUES
(1, 1, 'Av. Siempre Viva 742', '2025-06-19', 'En camino', 1);