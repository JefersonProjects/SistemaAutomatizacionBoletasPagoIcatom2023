package Clases;

import Sistema.ConexionSQL;
import java.util.Properties;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import javax.swing.JOptionPane;

public class EmailDAO {

    public Session getSesion() {
        return sesion;
    }

    public void setSesion(Session sesion) {
        this.sesion = sesion;
    }
    private Session sesion;

    public EmailDAO(String nombreUsuario, String contrasena) {
        // Configuración de las propiedades de conexión
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); //TLS
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        // Autenticación
        this.sesion = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("jeffersonalejandro943@gmail.com", "cubd nngb oaml mxir");
            }
        });
    }

    public List<Trabajador> obtenerTrabajadoresConBoletas() {
        List<Trabajador> trabajadores = new ArrayList<>();

        ConexionSQL conexion = new ConexionSQL();

        try {
            // Crear una conexión a la base de datos
            Connection con = conexion.Conectar();

            
            String sql = "SELECT trabajadores.dni, Boletas.fecha, trabajadores.nombres, trabajadores.corr_elec, trabajadores.telefono, Boletas.archivo "
                    + "FROM trabajadores "
                    + "INNER JOIN Boletas ON trabajadores.dni = Boletas.dni";
            PreparedStatement stmt = con.prepareStatement(sql);

            // Ejecutar la consulta
            ResultSet rs = stmt.executeQuery();

            // Mientras haya resultados, añadir un trabajador a la lista
            while (rs.next()) {
                Trabajador trabajador = new Trabajador();
                trabajador.setDni(rs.getString(1));
                trabajador.setFechaNacimiento(rs.getDate(2));
                trabajador.setNombre(rs.getString(3));
                trabajador.setCorreoElectronico(rs.getString(4));
                trabajador.setTelefono(rs.getString(5));
                trabajador.setBoleta(rs.getBytes(6));  // Asume que la boleta está almacenada como un arreglo de bytes
                trabajadores.add(trabajador);
            }

            // Cerrar la conexión
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return trabajadores;
    }

    public void enviarCorreo(Trabajador trabajador, String asunto, String cuerpo) {

        try {

            // Crea el mensaje
            MimeMessage mensaje = new MimeMessage(sesion);
            mensaje.setFrom(new InternetAddress("jeffersonalejandro943@gmail.com"));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(trabajador.getCorreoElectronico()));
            mensaje.setSubject(asunto);

            // Crea el cuerpo del mensaje
            MimeBodyPart cuerpoMensaje = new MimeBodyPart();
            cuerpoMensaje.setText(cuerpo);

            // Crea el adjunto
            MimeBodyPart adjuntoBoleta = new MimeBodyPart();
            // Asume que getBoleta() devuelve la boleta como un arreglo de bytes
            DataSource source = new ByteArrayDataSource(trabajador.getBoleta(), "application/pdf");
            adjuntoBoleta.setDataHandler(new DataHandler(source));
            adjuntoBoleta.setFileName(trabajador.getDni() + ".pdf");

            // Combina el cuerpo del mensaje y el adjunto
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(cuerpoMensaje);
            multipart.addBodyPart(adjuntoBoleta);

            // Establece el contenido del mensaje
            mensaje.setContent(multipart);

            // Envía el mensaje
            Transport.send(mensaje);

            System.out.println("Correo enviado a " + trabajador.getCorreoElectronico());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
