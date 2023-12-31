package Vistas;

import Clases.Usuario;
import java.awt.Color;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    int xMouse, yMouse;

    public Login() {
        initComponents();
        this.setLocationRelativeTo(null); // Esto centrará la ventana
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanelFondo = new javax.swing.JPanel();
        JLabelinicioSesion = new javax.swing.JLabel();
        JLabelUsuario = new javax.swing.JLabel();
        JLabelContraseña = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        JLabelLogoUtp = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        ContenedorEntrar = new javax.swing.JPanel();
        jLabelEntrar = new javax.swing.JLabel();
        JlabelLogoIcatom = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Header = new javax.swing.JPanel();
        ExitBtn = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        JPanelFondo.setBackground(new java.awt.Color(255, 255, 255));
        JPanelFondo.setForeground(new java.awt.Color(255, 255, 255));
        JPanelFondo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JPanelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JLabelinicioSesion.setFont(new java.awt.Font("MS PGothic", 1, 24)); // NOI18N
        JLabelinicioSesion.setForeground(new java.awt.Color(102, 102, 102));
        JLabelinicioSesion.setText("INICIAR SESION");
        JPanelFondo.add(JLabelinicioSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 230, -1));

        JLabelUsuario.setFont(new java.awt.Font("MS PGothic", 1, 16)); // NOI18N
        JLabelUsuario.setForeground(new java.awt.Color(102, 102, 102));
        JLabelUsuario.setText("USUARIO");
        JPanelFondo.add(JLabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 90, -1));

        JLabelContraseña.setFont(new java.awt.Font("MS PGothic", 1, 16)); // NOI18N
        JLabelContraseña.setForeground(new java.awt.Color(102, 102, 102));
        JLabelContraseña.setText("CONTRASEÑA");
        JPanelFondo.add(JLabelContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        txtUsuario.setBackground(new java.awt.Color(255, 255, 255));
        txtUsuario.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 12)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(204, 204, 204));
        txtUsuario.setText("Ingrese su nombre de usuario");
        txtUsuario.setBorder(null);
        txtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtUsuarioMousePressed(evt);
            }
        });
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        JPanelFondo.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 360, 30));

        JLabelLogoUtp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoUTP.png"))); // NOI18N
        JPanelFondo.add(JLabelLogoUtp, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 70, 50));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        JPanelFondo.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 340, 20));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        JPanelFondo.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 340, 20));

        ContenedorEntrar.setBackground(new java.awt.Color(255, 51, 0));
        ContenedorEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabelEntrar.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        jLabelEntrar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEntrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEntrar.setText("ENTRAR");
        jLabelEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEntrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelEntrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelEntrarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout ContenedorEntrarLayout = new javax.swing.GroupLayout(ContenedorEntrar);
        ContenedorEntrar.setLayout(ContenedorEntrarLayout);
        ContenedorEntrarLayout.setHorizontalGroup(
            ContenedorEntrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContenedorEntrarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        ContenedorEntrarLayout.setVerticalGroup(
            ContenedorEntrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContenedorEntrarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        JPanelFondo.add(ContenedorEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 130, 40));

        JlabelLogoIcatom.setForeground(new java.awt.Color(0, 0, 0));
        JlabelLogoIcatom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Icatom.jpg"))); // NOI18N
        JlabelLogoIcatom.setText("jLabel1");
        JPanelFondo.add(JlabelLogoIcatom, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, 264, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Toamtes.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        JPanelFondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 373, 500));

        Header.setBackground(new java.awt.Color(255, 255, 255));
        Header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                HeaderMouseDragged(evt);
            }
        });
        Header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                HeaderMousePressed(evt);
            }
        });

        ExitBtn.setBackground(new java.awt.Color(255, 255, 255));
        ExitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("X");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout ExitBtnLayout = new javax.swing.GroupLayout(ExitBtn);
        ExitBtn.setLayout(ExitBtnLayout);
        ExitBtnLayout.setHorizontalGroup(
            ExitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ExitBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
        );
        ExitBtnLayout.setVerticalGroup(
            ExitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExitBtnLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addComponent(ExitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 801, Short.MAX_VALUE))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ExitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        JPanelFondo.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 40));

        txtContraseña.setBackground(new java.awt.Color(255, 255, 255));
        txtContraseña.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 12)); // NOI18N
        txtContraseña.setForeground(new java.awt.Color(204, 204, 204));
        txtContraseña.setText("********");
        txtContraseña.setBorder(null);
        txtContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtContraseñaMousePressed(evt);
            }
        });
        txtContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaActionPerformed(evt);
            }
        });
        JPanelFondo.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 150, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void HeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_HeaderMousePressed

    private void HeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_HeaderMouseDragged

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        ExitBtn.setBackground(Color.red);
        ExitBtn.setForeground(Color.white);
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        ExitBtn.setBackground(Color.white);
        ExitBtn.setForeground(Color.black);
    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabelEntrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEntrarMouseEntered
        jLabelEntrar.setBackground(Color.red);
    }//GEN-LAST:event_jLabelEntrarMouseEntered

    private void txtUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsuarioMousePressed
        if (txtUsuario.getText().equals("Ingrese su nombre de usuario")) {
            txtUsuario.setText("");
            txtUsuario.setForeground(Color.black);
        }
        if (String.valueOf(txtContraseña.getPassword()).isEmpty()) {
            txtContraseña.setText("********");
            txtContraseña.setForeground(Color.gray);
    }//GEN-LAST:event_txtUsuarioMousePressed
    }

    private void txtContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseñaActionPerformed

    private void txtContraseñaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtContraseñaMousePressed
        if (String.valueOf(txtContraseña.getPassword()).equals("********")) {
            txtContraseña.setText("");
            txtContraseña.setForeground(Color.black);
        }
        if (txtUsuario.getText().isEmpty()) {
            txtUsuario.setText("Ingrese su nombre de usuario");
            txtUsuario.setForeground(Color.gray);
        }
     }//GEN-LAST:event_txtContraseñaMousePressed

    private void jLabelEntrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEntrarMouseExited
        jLabelEntrar.setBackground(new Color(255, 51, 0));
    }//GEN-LAST:event_jLabelEntrarMouseExited

    private void jLabelEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEntrarMouseClicked
        //CAPTURAMOS EL TEXTO DE LA CASILLA USUARIO Y CONTRASEÑA EN ESTAS VARIABLES 
        String nombreUsuario = txtUsuario.getText();
        String contraseña = txtContraseña.getText();

        if (contraseña.isEmpty() || nombreUsuario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacios. Intente nuevamente");
        } else {
            Usuario usuario = new Usuario();
            usuario.setUsuario(nombreUsuario);
            usuario.setContraseña(contraseña);
            boolean inicioSesionExitoso = usuario.iniciarSesion(usuario.getUsuario(),usuario.getContraseña()); // Intenta iniciar sesión

            if (inicioSesionExitoso) {
                JOptionPane.showMessageDialog(null, "Datos validados correctamente");
                Menu vistamenu = new Menu();
                vistamenu.setVisible(true); // Muestra el JFrame Menu
                this.dispose(); // Cierra la ventana de inicio de sesión
            } else {
                JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectos");
            }
        }

    }//GEN-LAST:event_jLabelEntrarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ContenedorEntrar;
    private javax.swing.JPanel ExitBtn;
    private javax.swing.JPanel Header;
    private javax.swing.JLabel JLabelContraseña;
    private javax.swing.JLabel JLabelLogoUtp;
    private javax.swing.JLabel JLabelUsuario;
    private javax.swing.JLabel JLabelinicioSesion;
    private javax.swing.JPanel JPanelFondo;
    private javax.swing.JLabel JlabelLogoIcatom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelEntrar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
