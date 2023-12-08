package Clases;

import Sistema.ConexionSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario {

    private String usuario;
    private String contraseña;

    public Usuario() {

    }

    

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String nombreUsuario) {
        this.usuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public boolean iniciarSesion(String usuario, String contraseña) {
        ConexionSQL conexion = new ConexionSQL();
        Connection con = conexion.Conectar();
        try {
            String sqlConsulta = "SELECT * FROM Usuarios WHERE Usuario = '" + usuario + "' AND Contraseña = '" + contraseña + "'";
            PreparedStatement ps = con.prepareStatement(sqlConsulta);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                return true;
            } else {

                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
