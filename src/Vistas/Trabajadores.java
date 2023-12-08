package Vistas;

import Clases.TrabajadorDAO;
import Clases.Trabajador;
import Sistema.ConexionSQL;
import java.sql.ResultSetMetaData;
import java.sql.ResultSet;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

public class Trabajadores extends javax.swing.JFrame {

    ButtonGroup btnGroup;

    public Trabajadores() {
        initComponents();
        txtId.setVisible(false);
        btnGroup = new ButtonGroup();
        btnGroup.add(rbtnMasculino);
        btnGroup.add(rbtnFemenino);
        CargarTabla();
        agregarEscuchadorDeTeclado();//metodo para buscar el trabajador

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
    //METODO PARA BUSCAR TRABAJADOR//
    private void FiltrarTablaPorDNI(String dni) {
        DefaultTableModel vistaTabla = (DefaultTableModel) tablaTrabajadores.getModel();
        vistaTabla.setRowCount(0);

        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;

        try {
            ConexionSQL conexion = new ConexionSQL();
            Connection con = conexion.Conectar();
            ps = con.prepareStatement("SELECT id,dni,nombres,apellidos,fecha_nac,direccion,corr_elec,telefono,genero FROM trabajadores WHERE dni LIKE ?");
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
        txtBusquedaTrabajador.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String dni = txtBusquedaTrabajador.getText();
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
        tablaTrabajadores = new javax.swing.JTable();
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
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        rbtnMasculino = new javax.swing.JRadioButton();
        rbtnFemenino = new javax.swing.JRadioButton();
        DateFech_Nac = new com.toedter.calendar.JDateChooser();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        panelBusqueda = new javax.swing.JPanel();
        Buscar = new javax.swing.JLabel();
        txtBusquedaTrabajador = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trabajadores");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Trabajadores");

        tablaTrabajadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "DNI", "Nombres", "Apellidos", "Fecha_nac", "Direccion", "Correo Electronico", "Telefono", "Genero"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaTrabajadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaTrabajadoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaTrabajadores);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel3.setText("DNI:");

        jLabel4.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel4.setText("Nombres:");

        jLabel5.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel5.setText("Apellidos:");

        jLabel6.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel6.setText("Fecha de nacimiento:");

        jLabel7.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel7.setText("Direccion:");

        jLabel8.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel8.setText("Correo Electronico:");

        jLabel9.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel9.setText("Telefono:");

        txtDNI.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDNIActionPerformed(evt);
            }
        });

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        txtTelef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel11.setText("Genero");

        rbtnMasculino.setText("Masculino");
        rbtnMasculino.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        rbtnFemenino.setText("Femenino");
        rbtnFemenino.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(rbtnMasculino)
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(DateFech_Nac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(26, 26, 26))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnEliminar)
                                            .addComponent(txtTelef, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtCorrElec)
                                        .addGap(16, 16, 16))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(274, 274, 274)
                                .addComponent(rbtnFemenino))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(82, 82, 82)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombres, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                    .addComponent(txtApellidos)
                                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(DateFech_Nac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCorrElec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTelef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(rbtnMasculino)
                    .addComponent(rbtnFemenino))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnGuardar)
                    .addComponent(btnLimpiar))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        panelBusqueda.setPreferredSize(new java.awt.Dimension(620, 30));

        Buscar.setText("BUSCAR POR DNI :");

        txtBusquedaTrabajador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout panelBusquedaLayout = new javax.swing.GroupLayout(panelBusqueda);
        panelBusqueda.setLayout(panelBusquedaLayout);
        panelBusquedaLayout.setHorizontalGroup(
            panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBusquedaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Buscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBusquedaTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        panelBusquedaLayout.setVerticalGroup(
            panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBusquedaLayout.createSequentialGroup()
                .addGroup(panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBusquedaLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(Buscar))
                    .addGroup(panelBusquedaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtBusquedaTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(panelBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addGap(7, 7, 7)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
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

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //CREAMOS UN OBJETO DE LA CLASE TRABAJADOR//
        Trabajador trabajador = new Trabajador();
        trabajador.setDni(txtDNI.getText());
        trabajador.setNombre(txtNombres.getText());
        trabajador.setApellidos(txtApellidos.getText());
        trabajador.setFechaNacimiento(DateFech_Nac.getDate());
        trabajador.setDireccion(txtDireccion.getText());
        trabajador.setCorreoElectronico(txtCorrElec.getText());
        trabajador.setTelefono(txtTelef.getText());
        String regex = "^[\\w-]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-zA-Z]{2,})$";
        String genero = null;
        if (rbtnMasculino.isSelected() == true) {
            genero = "M";
        } else if (rbtnFemenino.isSelected() == true) {
            genero = "F";
        }
        trabajador.setGenero(genero);

        //Verifica si los campos están vacios
        if (trabajador.getDni().isEmpty() || trabajador.getNombre().isEmpty() || trabajador.getApellidos().isEmpty() || trabajador.getFechaNacimiento() == null || trabajador.getDireccion().isEmpty() || trabajador.getCorreoElectronico().isEmpty() || trabajador.getTelefono().isEmpty() || trabajador.getGenero() == null) {
            JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacios");
            return;
        }

        //Verifica si el DNI tiene exactamente 8 numeros y no letras
        if (!trabajador.getDni().matches("\\d{8}")) {
            JOptionPane.showMessageDialog(null, "El DNI debe tener 8 numeros");
            return;
        }
        // Verifica si el correo electronico es valido
        if (!trabajador.getCorreoElectronico().matches(regex)) {
            JOptionPane.showMessageDialog(null, "Ingrese un correo valido");
            return;
        }
        // Verifica si el teléfono contiene solo dígitos y tiene exactamente 9 dígitos
        if (!trabajador.getTelefono().matches("\\d{9}")) {
            JOptionPane.showMessageDialog(null, "Ingrese un numero de telefono válido de 9 digitos");
            return;
        }
        // instancia de GestorTrabajador
        TrabajadorDAO gestor = new TrabajadorDAO();

        // Llamamos al metodo agregar trabajador
        gestor.agregarTrabajador(trabajador);
        limpiar();
        CargarTabla();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void tablaTrabajadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTrabajadoresMouseClicked
        limpiar();
        try {
            int fila = tablaTrabajadores.getSelectedRow();
            int id = Integer.parseInt(tablaTrabajadores.getValueAt(fila, 0).toString());
            PreparedStatement ps;
            ResultSet rs;

            ConexionSQL conexion = new ConexionSQL();
            Connection con = conexion.Conectar();
            ps = con.prepareStatement("SELECT dni,nombres,apellidos,fecha_nac,direccion,corr_elec,telefono,genero from trabajadores WHERE id=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                txtId.setText(String.valueOf(id));
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
    }//GEN-LAST:event_tablaTrabajadoresMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        //instancia trabajador
        Trabajador trabajador = new Trabajador();
        trabajador.setId(Integer.parseInt(txtId.getText()));
        trabajador.setDni(txtDNI.getText());
        trabajador.setNombre(txtNombres.getText());
        trabajador.setApellidos(txtApellidos.getText());
        trabajador.setFechaNacimiento(DateFech_Nac.getDate());
        trabajador.setDireccion(txtDireccion.getText());
        trabajador.setCorreoElectronico(txtCorrElec.getText());
        trabajador.setTelefono(txtTelef.getText());
        String regex = "^[\\w-]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-zA-Z]{2,})$";
        String genero = null;
        if (rbtnMasculino.isSelected() == true) {
            genero = "M";
        } else if (rbtnFemenino.isSelected() == true) {
            genero = "F";
        }
        trabajador.setGenero(genero);

        //Verifica si los campos están vacios
        if (trabajador.getDni().isEmpty() || trabajador.getNombre().isEmpty() || trabajador.getApellidos().isEmpty() || trabajador.getFechaNacimiento() == null || trabajador.getDireccion().isEmpty() || trabajador.getCorreoElectronico().isEmpty() || trabajador.getTelefono().isEmpty() || trabajador.getGenero() == null) {
            JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacios");
            return;
        }

        //Verifica si el DNI tiene exactamente 8 numeros y no letras
        if (!trabajador.getDni().matches("\\d{8}")) {
            JOptionPane.showMessageDialog(null, "El DNI debe tener 8 numeros");
            return;
        }
        // Verifica si el correo electronico es valido
        if (!trabajador.getCorreoElectronico().matches(regex)) {
            JOptionPane.showMessageDialog(null, "Ingrese un correo valido");
            return;
        }
        // Verifica si el teléfono contiene solo dígitos y tiene exactamente 9 dígitos
        if (!trabajador.getTelefono().matches("\\d{9}")) {
            JOptionPane.showMessageDialog(null, "Ingrese un numero de telefono válido de 9 digitos");
            return;
        }
        // instancia de GestorTrabajador
        TrabajadorDAO gestor = new TrabajadorDAO();
        // Obtenemos el ID del trabajador que se está modificando
        int idActual = Integer.parseInt(txtId.getText());

        // Verificamos si el DNI ya existe y no es el mismo que el del trabajador original
        if (gestor.obtenerDniTrabajador(trabajador.getDni(), idActual)) {
            JOptionPane.showMessageDialog(null, "No se puede modificar porque el dni le pertence a otro trabajador");
            return;
        }
        // Llamas al metodo actualizarTrabajador
        gestor.modificarTrabajador(trabajador);
        limpiar();
        CargarTabla();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       
// Creas una instancia de GestorTrabajador
        TrabajadorDAO gestor = new TrabajadorDAO();

        // Llamas al método eliminarTrabajador
       gestor.eliminarTrabajador(tablaTrabajadores);

        // Llamas a los métodos limpiar y CargarTabla
        limpiar();
        CargarTabla();
    }//GEN-LAST:event_btnEliminarActionPerformed

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
        btnEliminar.setFocusable(false);
        btnModificar.setFocusable(false);
        btnGuardar.setFocusable(false);
        btnLimpiar.setFocusable(false);
        
    }

    //METODOD PARA CARGAR TABLA
    private void CargarTabla() {
        //tamaño de columnas
        int[] anchos = {37, 75, 65, 65, 80, 65, 85, 80, 55};
        for (int i = 0; i < tablaTrabajadores.getColumnCount(); i++) {
            TableColumn column = tablaTrabajadores.getColumnModel().getColumn(i);
            column.setMinWidth(anchos[i]);
            column.setMaxWidth(anchos[i]);
            column.setPreferredWidth(anchos[i]);
        }

        DefaultTableModel vistaTabla = (DefaultTableModel) tablaTrabajadores.getModel();
        vistaTabla.setRowCount(0);

        TrabajadorDAO gestor = new TrabajadorDAO();
        List<Trabajador> trabajadores = gestor.obtenerTrabajadores();

        //bucle for each para recorrer el array mas facil
        for (Trabajador trabajador : trabajadores) {
            java.util.Date fechaNacimiento = trabajador.getFechaNacimiento();
            SimpleDateFormat sdf = new SimpleDateFormat("d MMM yyyy", new Locale("es", "ES"));
            String fechaFormateada = sdf.format(fechaNacimiento);

            String genero = trabajador.getGenero();
            String generoStr = "";
            if ("M".equals(genero)) {
                generoStr = "M";
                rbtnMasculino.setSelected(true);
            } else if ("F".equals(genero)) {
                generoStr = "F";
                rbtnFemenino.setSelected(true);
            }

            Object[] fila = new Object[]{trabajador.getId(), trabajador.getDni(), trabajador.getNombre(), trabajador.getApellidos(),
                fechaFormateada, trabajador.getDireccion(), trabajador.getCorreoElectronico(), trabajador.getTelefono(), generoStr
            };
            vistaTabla.addRow(fila);
        }
    }

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Buscar;
    private com.toedter.calendar.JDateChooser DateFech_Nac;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JTable tablaTrabajadores;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtBusquedaTrabajador;
    private javax.swing.JTextField txtCorrElec;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelef;
    // End of variables declaration//GEN-END:variables
}
