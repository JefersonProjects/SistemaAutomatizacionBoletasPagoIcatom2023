package Sistema;

import Vistas.Login;

public class Sistema {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }
}
 