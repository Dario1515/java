# 📘 Proyecto JV — API de Gestión

Este proyecto es una API REST desarrollada en **Spring Boot** que permite administrar:

- 🧑‍💼 Clientes
- 🧾 Facturas
- 🔧 Repuestos

Ideal para sistemas de facturación simples.

---

## 🚀 Tecnologías.

- Java 17+
- Spring Boot
- Spring Data JPA
- H2 Database
- Swagger OpenAPI

---

## 📌 Base URL

http://localhost:8080/


## 🔍 Documentación Swagger

Accedé desde:

http://localhost:8080/swagger-ui.html

---

## 🧑‍💼 Clientes

📍 Ruta base: `/cliente`

### 🔹 GET /cliente

> Obtener todos los clientes

🔁 **Respuesta 200 OK**  
Devuelve una lista con todos los clientes registrados.

---

### 🔹 GET /cliente/{id}

> Obtener un cliente por ID

🔁 **Respuesta 200 OK**  
🔁 **Respuesta 404 Not Found** si no se encuentra.

---

### 🔹 POST /cliente

> Crear un nuevo cliente

📝 **Body (JSON)**

```json
{
  "nombre": "María López",
  "direccion": "Av. Siempre Viva 123",
  "telefono": "1122334455",
  "email": "maria@example.com"
}
```
-------------
🔁 Respuesta 200 OK
🔁 Respuesta 400 Bad Request si hay un error de validación.

🔹 PUT /cliente/{id}
Modificar un cliente existente

🔁 Respuesta 200 OK
🔁 Respuesta 404 Not Found

🔹 DELETE /cliente/{id}
Eliminar un cliente

🔁 Respuesta 200 OK
🔁 Respuesta 404 Not Found

🧾 Facturas (Ruta: /factura)
Incluye operaciones CRUD para facturas, asociadas a un cliente y a repuestos.

Campos:

id

cliente_id

fecha_emision

total

repuestos

🔧 Repuestos (Ruta: /repuesto)
Operaciones CRUD básicas para productos o repuestos.

Campos:

codigo

nombre

marca

precio

🗃️ Base de Datos
Usa H2 en modo archivo, accesible desde:


http://localhost:8080/h2-console
JDBC URL: jdbc:h2:file:./data/proyectoJv

Usuario: admin

Contraseña: admin

✅ Estado
✅ CRUD funcionando para todas las entidades.
✅ Swagger documentado.
✅ Persistencia con H2 en disco.
