# 💼 Sistema de Automatización de Boletas de Pago - ICATOM 2023

Aplicación de escritorio desarrollada para la gestión y entrega automatizada de boletas de pago a los trabajadores del fundo ICATOM. Esta herramienta permite registrar, visualizar y enviar boletas en formato PDF a los correos de los empleados, mejorando la eficiencia y reduciendo los procesos manuales.

---

## 🖥️ Tecnologías utilizadas

- 💻 **Java** (Lenguaje principal)
- 🧰 **Swing** (Interfaz gráfica)
- 🗃️ **SQL Server** (Base de datos)
- 🛠️ **NetBeans** (IDE de desarrollo)
- 📄 **iText**  para manipulación de PDFs
- 📧 JavaMail API para el envío de correos

---

## ✨ Funcionalidades principales

- 📥 **Carga masiva de boletas en PDF**, vinculadas automáticamente a cada empleado mediante su DNI y mes correspondiente.
- 👤 **Gestión de trabajadores**:
  - Agregar nuevo empleado
  - Editar información
  - Eliminar registros
  - Buscar y filtrar en tiempo real (por DNI, nombre, etc.)
- 📄 **Visualización de boletas de pago** directamente desde la app.
- 📬 **Envío automático de boletas al correo del trabajador**, respetando su mes y DNI.
- 🔐 Validación y control de errores en carga, visualización y envío de archivos.

---

## 🧾 Estructura de boletas

Cada archivo PDF debe:
- Tener en el nombre del archivo el **DNI** del empleado.
- Estar asociado a un **mes específico**.
- Pueden cargarse múltiples archivos a la vez.
