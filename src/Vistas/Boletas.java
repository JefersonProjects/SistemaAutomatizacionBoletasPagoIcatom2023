package Vistas;

import Clases.BoletaDAO;
import Clases.TrabajadorDAO;
import Clases.Trabajador;
import Sistema.ConexionSQL;
import java.sql.ResultSetMetaData;
import java.sql.ResultSet;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

public class Boletas extends javax.swing.JFrame {

    ButtonGroup btnGroup;

    public Boletas() {
        initComponents();
        txtId.setVisible(false);
        btnGroup = new ButtonGroup();
        btnGroup.add(rbtnMasculino);
        btnGroup.add(rbtnFemenino);
        CargarTabla();
        agregarEscuchadorDeTeclado();//metodo para buscar la boleta

        //filtro para limitar campo de texto
        class LengthFilter extends DocumentFilter {

            private final int max;

            public LengthFilter(int max) {
                this.max = max;
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String string = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;

                if (string.length() <= max) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        }

        //  filtro al JTextField del DNI
        PlainDocument docDNI = (PlainDocument) txtDNI.getDocument();
        docDNI.setDocumentFilter(new LengthFilter(8));

        // filtro al JTextField del telfono
        PlainDocument docTelefono = (PlainDocument) txtTelef.getDocument();
        docTelefono.setDocumentFilter(new LengthFilter(9));

    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------
    //METODO PARA BUSCAR Boleta//
    private void FiltrarTablaPorDNI(String dni) {
        DefaultTableModel vistaTabla = (DefaultTableModel) tablaboletas.getModel();
        vistaTabla.setRowCount(0);

        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;

        try {
            ConexionSQL conexion = new ConexionSQL();
            Connection con = conexion.Conectar();
            ps = con.prepareStatement("SELECT b.dni, b.fecha,t.nombres,t.Corr_elec ,t.telefono FROM Boletas b INNER JOIN trabajadores t ON b.dni = t.dni WHERE b.dni LIKE ?");
            ps.setString(1, "%" + dni + "%");
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();

            while (rs.next()) {
                Object[] fila = new Object[columnas];
                for (int indice = 0; indice < columnas; indice++) {
                    fila[indice] = rs.getObject(indice + 1);
                }
                vistaTabla.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    private void agregarEscuchadorDeTeclado() {
        txtBusquedaBoletas.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String dni = txtBusquedaBoletas.getText();
                FiltrarTablaPorDNI(dni);
            }
        });
    }
//-----------------------------------------------------------------------------------------------------------------------------
    //METODO PARA CONVERTIR  EL JFRAME A JPANEL 

    public JPanel getPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        for (Component comp : this.getContentPane().getComponents()) {
            panel.add(comp);
        }
        return panel;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jOptionPane1 = new javax.swing.JOptionPane();
        jOptionPane2 = new javax.swing.JOptionPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaboletas = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtCorrElec = new javax.swing.JTextField();
        txtTelef = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        rbtnMasculino = new javax.swing.JRadioButton();
        rbtnFemenino = new javax.swing.JRadioButton();
        DateFech_Nac = new com.toedter.calendar.JDateChooser();
        btnSubirBoletas = new javax.swing.JButton();
        btnEliminarBoleta = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        btnVisualisar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        panelBusqueda = new javax.swing.JPanel();
        Buscar = new javax.swing.JLabel();
        txtBusquedaBoletas = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trabajadores");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Servicio de boletas");

        tablaboletas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo de  boleta", "Fecha de carga", "Trabajador", "Correo_Elec", "Telefono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaboletas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaboletasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaboletas);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel3.setText("DNI:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 74, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel4.setText("Nombres:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 106, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel5.setText("Apellidos:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 146, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel6.setText("Fecha de nacimiento:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 183, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel7.setText("Direccion:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 234, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel8.setText("Correo Electronico:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 272, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel9.setText("Telefono:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 316, -1, -1));

        txtDNI.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDNIActionPerformed(evt);
            }
        });
        jPanel1.add(txtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 100, -1));
        jPanel1.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 167, -1));
        jPanel1.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 167, -1));

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 227, 167, -1));
        jPanel1.add(txtCorrElec, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 265, 194, -1));

        txtTelef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefActionPerformed(evt);
            }
        });
        jPanel1.add(txtTelef, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 309, 126, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel11.setText("Genero");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 357, -1, -1));

        rbtnMasculino.setText("Masculino");
        rbtnMasculino.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbtnMasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnMasculinoActionPerformed(evt);
            }
        });
        jPanel1.add(rbtnMasculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 353, -1, -1));

        rbtnFemenino.setText("Femenino");
        rbtnFemenino.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(rbtnFemenino, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 353, -1, -1));
        jPanel1.add(DateFech_Nac, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 168, -1));

        btnSubirBoletas.setText("Subir Boleta....");
        btnSubirBoletas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirBoletasActionPerformed(evt);
            }
        });
        jPanel1.add(btnSubirBoletas, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 408, 106, -1));

        btnEliminarBoleta.setText("Eliminar Boleta");
        btnEliminarBoleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarBoletaActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarBoleta, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 408, -1, -1));
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 74, 19, -1));

        btnVisualisar.setText("Visualizar");
        btnVisualisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualisarActionPerformed(evt);
            }
        });
        jPanel1.add(btnVisualisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 408, 115, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel2.setText("del trabajador");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 130, 30));

        Buscar.setText("BUSCAR BOLETA POR DNI  :");

        javax.swing.GroupLayout panelBusquedaLayout = new javax.swing.GroupLayout(panelBusqueda);
        panelBusqueda.setLayout(panelBusquedaLayout);
        panelBusquedaLayout.setHorizontalGroup(
            panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBusquedaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Buscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBusquedaBoletas, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(149, 149, 149))
        );
        panelBusquedaLayout.setVerticalGroup(
            panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBusquedaLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Buscar)
                    .addComponent(txtBusquedaBoletas))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
                        .addGap(8, 8, 8))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(panelBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(panelBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void txtDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDNIActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtTelefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefActionPerformed

    private void btnSubirBoletasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirBoletasActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);

        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File[] files = fileChooser.getSelectedFiles();

            //Instanciamos un objeto de la clase GestorBoletas
            BoletaDAO gestor = new BoletaDAO();
            gestor.subirBoletas(files);
        }
        limpiar();
        CargarTabla();
    }//GEN-LAST:event_btnSubirBoletasActionPerformed

    private void btnEliminarBoletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarBoletaActionPerformed
        // Creas una instancia de GestorBoletas
        BoletaDAO gestor = new BoletaDAO();

        // Llamas al método eliminarBoleta
        gestor.eliminarBoleta(tablaboletas);

        // Llamas a los métodos limpiar y CargarTabla
        limpiar();
        CargarTabla();

    }//GEN-LAST:event_btnEliminarBoletaActionPerformed

    private void tablaboletasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaboletasMouseClicked
        limpiar();
        try {
            int fila = tablaboletas.getSelectedRow();
            String dni = tablaboletas.getValueAt(fila, 0).toString(); // Obtiene el DNI de la fila seleccionada
            PreparedStatement ps;
            ResultSet rs;

            ConexionSQL conexion = new ConexionSQL();
            Connection con = conexion.Conectar();
            ps = con.prepareStatement("SELECT dni,nombres,apellidos,fecha_nac,direccion,corr_elec,telefono,genero from trabajadores WHERE dni=?");
            ps.setString(1, dni); // Usa el DNI obtenido de la tabla
            rs = ps.executeQuery();

            while (rs.next()) {
                txtDNI.setText(rs.getString("dni"));
                txtNombres.setText(rs.getString("nombres"));
                txtApellidos.setText(rs.getString("apellidos"));
                java.sql.Date dbSqlDate = rs.getDate("fecha_nac");
                java.util.Date date = new java.util.Date(dbSqlDate.getTime());
                DateFech_Nac.setDate(date);
                txtDireccion.setText(rs.getString("direccion"));
                txtCorrElec.setText(rs.getString("corr_elec"));
                txtTelef.setText(rs.getString("telefono"));
                if (rs.getString("genero").equals("M")) {
                    rbtnMasculino.setSelected(true);
                } else if (rs.getString("genero").equals("F")) {
                    rbtnFemenino.setSelected(true);
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }//GEN-LAST:event_tablaboletasMouseClicked

    private void btnVisualisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualisarActionPerformed
        // Obtén el DNI del campo de texto correspondiente
        String dni = txtDNI.getText();

        // Crea una instancia de GestorBoletas y llama al método visualizarBoleta
        BoletaDAO gestor = new BoletaDAO();
        gestor.visualizarBoleta(dni);

        limpiar();
    }//GEN-LAST:event_btnVisualisarActionPerformed

    private void rbtnMasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnMasculinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnMasculinoActionPerformed

    private void limpiar() {
        txtId.setText("");
        txtDNI.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtDireccion.setText("");
        txtCorrElec.setText("");
        txtTelef.setText("");
        rbtnFemenino.setSelected(false);
        rbtnMasculino.setSelected(false);
        DateFech_Nac.setDate(null);
        btnGroup.clearSelection();
        btnVisualisar.setFocusable(false);
        btnSubirBoletas.setFocusable(false);
        btnEliminarBoleta.setFocusable(false);
       
    }

    //METODOD PARA CARGAR TABLA
    private void CargarTabla() {
        //tamaño de columnas
        int[] anchos = {112, 120, 130, 155, 115};
        for (int i = 0; i < tablaboletas.getColumnCount(); i++) {
            TableColumn column = tablaboletas.getColumnModel().getColumn(i);
            column.setMinWidth(anchos[i]);
            column.setMaxWidth(anchos[i]);
            column.setPreferredWidth(anchos[i]);
        }

        DefaultTableModel vistaTabla = (DefaultTableModel) tablaboletas.getModel();
        vistaTabla.setRowCount(0);

        ConexionSQL conexion = new ConexionSQL();

        try {
            // Crear una conexión a la base de datos
            Connection con = conexion.Conectar();

            // Crear una declaración SQL
            String sql = "SELECT trabajadores.dni, Boletas.fecha, trabajadores.nombres, trabajadores.corr_elec, trabajadores.telefono "
                    + "FROM trabajadores "
                    + "INNER JOIN Boletas ON trabajadores.dni = Boletas.dni";
            PreparedStatement stmt = con.prepareStatement(sql);

            // Ejecutar la consulta
            ResultSet rs = stmt.executeQuery();

            // Mientras haya resultados, añadir una fila a la tabla
            while (rs.next()) {
                Object[] fila = new Object[]{rs.getString(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getString(5)};
                vistaTabla.addRow(fila);
            }

            // Cerrar la conexión
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Boletas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Buscar;
    private com.toedter.calendar.JDateChooser DateFech_Nac;
    private javax.swing.JButton btnEliminarBoleta;
    private javax.swing.JButton btnSubirBoletas;
    private javax.swing.JButton btnVisualisar;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JOptionPane jOptionPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelBusqueda;
    private javax.swing.JRadioButton rbtnFemenino;
    private javax.swing.JRadioButton rbtnMasculino;
    private javax.swing.JTable tablaboletas;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtBusquedaBoletas;
    private javax.swing.JTextField txtCorrElec;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelef;
    // End of variables declaration//GEN-END:variables
}
