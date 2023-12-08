package Clases;

import Sistema.ConexionSQL;
import java.awt.Desktop;
import java.sql.Connection;
import java.sql.SQLException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.nio.file.Files;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import javax.swing.JTable;

public class BoletaDAO extends TrabajadorDAO {

  
    public void subirBoletas(File[] files) {
        for (File file : files) {
            String nombreArchivo = file.getName();
            nombreArchivo = nombreArchivo.substring(0, nombreArchivo.lastIndexOf("."));
            String dni = nombreArchivo;

            // Validar que el nombre del archivo tenga exactamente 8 caracteres
            if (nombreArchivo.length() != 8) {
                JOptionPane.showMessageDialog(null, "El nombre del archivo debe tener exactamente 8 caracteres.");
                continue;
            }
            // Validar que el nombre del archivo solo contenga dígitos
            if (!nombreArchivo.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "El nombre del archivo solo debe contener dígitos.");
                continue;
            }
            // Validar que el DNI exista en la tabla de trabajadores
            if (!existeTrabajador(dni)) {
                JOptionPane.showMessageDialog(null, "No se puede subir esta boleta porque el trabajador no existe. Verifique el nombre del archivo y vuelva a intentarlo.");
                continue;
            }
            guardarBoleta(dni, file);
        }
    }
    //METODO exisiteTrabajador QUE USA EL METODO SUBIR BOLETAS//

    private boolean existeTrabajador(String dni) {
        ConexionSQL conexion = new ConexionSQL();
        Connection cn = conexion.Conectar();

        try {
            PreparedStatement stmt = cn.prepareStatement("SELECT COUNT(*) FROM Trabajadores WHERE dni = ?");
            stmt.setString(1, dni);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    //METODO guardarBoleta QUE USA EL METODO SUBIR BOLETAS//
    private void guardarBoleta(String dni, File file) {
        ConexionSQL conexion = new ConexionSQL();
        Connection cn = conexion.Conectar();

        try {
            PreparedStatement stmt = cn.prepareStatement("INSERT INTO Boletas (dni, fecha, archivo) VALUES (?, ?, ?)");

            stmt.setString(1, dni);
            stmt.setDate(2, java.sql.Date.valueOf(LocalDate.now()));

            // Lee el archivo PDF en un array de bytes
            byte[] pdfData = Files.readAllBytes(file.toPath());
            stmt.setBytes(3, pdfData);// Guarda el archivo PDF en la base de datos
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Boleta subida a la base de datos correctamente ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void visualizarBoleta(String dni) {
        ConexionSQL conexion = new ConexionSQL();
        Connection con = conexion.Conectar();

        try {
            PreparedStatement stmt = con.prepareStatement("SELECT archivo FROM Boletas WHERE dni = ?");
            stmt.setString(1, dni);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                byte[] pdfData = rs.getBytes("archivo");

                // Crea un archivo temporal para almacenar los datos del PDF
                File tempFile = File.createTempFile("boleta", ".pdf");
                tempFile.deleteOnExit();
                FileOutputStream fos = new FileOutputStream(tempFile);
                fos.write(pdfData);
                fos.close();

                // Abre el archivo PDF en el visor de PDF predeterminado
                Desktop.getDesktop().open(tempFile);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró una boleta con el DNI proporcionado.");
            }
        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public void eliminarBoleta(JTable tablaBoletas) {
        // Obtiene la fila seleccionada en la tabla
        int selectedRow = tablaBoletas.getSelectedRow();

        // Verifica si se ha seleccionado una fila
        if (selectedRow != -1) {
            // Obtiene el DNI de la fila seleccionada
            String dniStr = tablaBoletas.getValueAt(selectedRow, 0).toString();
            int dni = Integer.parseInt(dniStr);

            // Verifica si la base de datos ha sido inicializada
            if (this.baseDeDatos == null) {
                this.baseDeDatos = new ConexionSQL();
            }

            try {
                PreparedStatement consultasql = baseDeDatos.Conectar().prepareStatement("DELETE FROM Boletas WHERE dni=?");
                consultasql.setInt(1, dni);
                consultasql.executeUpdate();
                JOptionPane.showMessageDialog(null, "Boleta eliminada ");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }

        } else {
            // Si no se ha seleccionado ninguna fila, muestra un mensaje pidiendo al usuario que seleccione una boleta
            JOptionPane.showMessageDialog(null, "Por favor, selecciona una boleta.");
        }
    }

}
