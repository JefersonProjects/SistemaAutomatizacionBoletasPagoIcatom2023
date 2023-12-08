package Sistema;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConexionSQL {

    //VARIABLES DE ACCESO A LA BASE SQL
    public String usuario = "sa";
    public String passwordSQL = "123";

    //DIRECCION DE MI SQL
    String url = "jdbc:sqlserver://DESKTOP-91S2HU9\\SQLEXPRESS:1433;databaseName=BD Sistema de entrega de boletas;integratedSecurity=false; trustServerCertificate=true";

    public Connection cn = null;

    //METODO CONECTAR  
    public Connection Conectar() {
        try {
            cn = DriverManager.getConnection(url, usuario, passwordSQL);
        } catch (SQLException i) {
            JOptionPane.showMessageDialog(null, i);
        }
        return cn;
    }
}
