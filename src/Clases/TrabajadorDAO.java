package Clases;

import Sistema.ConexionSQL;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;

public class TrabajadorDAO {

    protected ConexionSQL baseDeDatos;

    public TrabajadorDAO() {
        this.baseDeDatos = new ConexionSQL();
    }

    public void agregarTrabajador(Trabajador trabajador) {
        try {
            //Objeto de clase conexion sql
            ConexionSQL conexion = new ConexionSQL();
            Connection con = conexion.Conectar();
            // verifica si el trabajador ya existe en el sistema 
            PreparedStatement consultaExistente = con.prepareStatement("SELECT * FROM Trabajadores WHERE dni = ?");
            consultaExistente.setString(1, trabajador.getDni());
            ResultSet rs = consultaExistente.executeQuery();

            //si el ResultSet tiene al menos un resultado muestra un mensaje y termina el método
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Ya existe un trabajador con el DNI ingresado.");
                return;
            }
            PreparedStatement consultasql = con.prepareStatement("INSERT INTO  Trabajadores(dni,nombres,apellidos,fecha_nac,direccion,corr_elec,telefono,genero) VALUES(?,?,?,?,?,?,?,?)");
            consultasql.setString(1, trabajador.getDni());
            consultasql.setString(2, trabajador.getNombre());
            consultasql.setString(3, trabajador.getApellidos());
            // convertimos JDateChooser a date
            java.util.Date fechaUtil = trabajador.getFechaNacimiento();
            // convertimos  java.util.Date a java.sql.Date
            java.sql.Date fechaSql = new java.sql.Date(fechaUtil.getTime());
            consultasql.setDate(4, fechaSql);
            consultasql.setString(5, trabajador.getDireccion());
            consultasql.setString(6, trabajador.getCorreoElectronico());
            consultasql.setString(7, trabajador.getTelefono());
            consultasql.setString(8, trabajador.getGenero());
            consultasql.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro guardado correctamente ");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public void eliminarTrabajador(JTable tablaTrabajadores) {
        int selectedRow = tablaTrabajadores.getSelectedRow();
        if (selectedRow != -1) {
            String idStr = tablaTrabajadores.getValueAt(selectedRow, 0).toString();
            int id = Integer.parseInt(idStr);

            try {
                PreparedStatement consultasql = baseDeDatos.Conectar().prepareStatement("DELETE FROM Trabajadores WHERE id=?");
                consultasql.setInt(1, id);
                consultasql.executeUpdate();
                JOptionPane.showMessageDialog(null, "Trabajador eliminado ");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }

        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona un trabajador.");
        }
    }

    public void modificarTrabajador(Trabajador trabajador) {
        //PARAMETROS A EVALUAR EN LA CONSULTA

        try {
            PreparedStatement consultasql = getBaseDeDatos().Conectar().prepareStatement("UPDATE Trabajadores SET dni=?,nombres=?,apellidos=?,fecha_nac=?,direccion=?,corr_elec=?,telefono=?,genero=?   WHERE id=?");
            consultasql.setString(1, trabajador.getDni());
            consultasql.setString(2, trabajador.getNombre());
            consultasql.setString(3, trabajador.getApellidos());
            // convertimos JDateChooser a date
            java.util.Date fechaUtil = trabajador.getFechaNacimiento();
            // convertimos  java.util.Date a java.sql.Date
            java.sql.Date fechaSql = new java.sql.Date(fechaUtil.getTime());
            consultasql.setDate(4, fechaSql);
            consultasql.setString(5, trabajador.getDireccion());
            consultasql.setString(6, trabajador.getCorreoElectronico());
            consultasql.setString(7, trabajador.getTelefono());
            consultasql.setString(8, trabajador.getGenero());
            consultasql.setInt(9, trabajador.getId());

            consultasql.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro modificado ");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    //Metodo que nos ayudara a buscar trabajadores//
    public List<Trabajador> obtenerTrabajadores() {
        List<Trabajador> trabajadores = new ArrayList<>();
        try {
            PreparedStatement ps = baseDeDatos.Conectar().prepareStatement("SELECT id,dni,nombres,apellidos,fecha_nac,direccion,corr_elec,telefono,genero FROM trabajadores");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Trabajador trabajador = new Trabajador();
                trabajador.setId(rs.getInt("id"));
                trabajador.setDni(rs.getString("dni"));
                trabajador.setNombre(rs.getString("nombres"));
                trabajador.setApellidos(rs.getString("apellidos"));
                //Conversion de tipo de fecha
                java.sql.Date fechaNacimientoSql = rs.getDate("fecha_nac");
                java.util.Date fechaNacimiento = new java.util.Date(fechaNacimientoSql.getTime());

                // Ahora puedes usar fechaNacimiento para establecer la fecha de nacimiento en tu objeto Trabajador
                trabajador.setFechaNacimiento(fechaNacimiento);
                trabajador.setDireccion(rs.getString("direccion"));
                trabajador.setCorreoElectronico(rs.getString("corr_elec"));
                trabajador.setTelefono(rs.getString("telefono"));
                trabajador.setGenero(rs.getString("genero"));
                trabajadores.add(trabajador);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return trabajadores;
    }

    public boolean obtenerDniTrabajador(String dniNuevo, int idActual) {
        try {
            ConexionSQL conexion = new ConexionSQL();
            Connection con = conexion.Conectar();
            PreparedStatement consultaDni = con.prepareStatement("SELECT COUNT(*) FROM Trabajadores WHERE dni = ? AND id != ?");
            consultaDni.setString(1, dniNuevo);
            consultaDni.setInt(2, idActual);
            ResultSet rs = consultaDni.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            } else {
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

    public ConexionSQL getBaseDeDatos() {
        return baseDeDatos;
    }
}
