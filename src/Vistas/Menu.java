/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author jeffe
 */
public class Menu extends javax.swing.JFrame {



    public Menu() {
        initComponents();
        Principal vistaPrincipal = new Principal();
        ShowJPanel(vistaPrincipal);
        this.setLocationRelativeTo(null); // Esto centrará la ventana
    }
    
    public  void ShowJPanel(JPanel p) {
        
        p.setSize(1050, 550);
        p.setLocation(0,0);
        
        conten.removeAll();
        conten.add(p, BorderLayout.CENTER);
        conten.revalidate();
        conten.repaint();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btn_trab = new javax.swing.JButton();
        appName = new javax.swing.JLabel();
        btn_prin = new javax.swing.JButton();
        btn_envioB = new javax.swing.JButton();
        btn_Boletas = new javax.swing.JButton();
        conten = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        Fondo.setBackground(new java.awt.Color(255, 255, 255));
        Fondo.setPreferredSize(new java.awt.Dimension(1100, 765));

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));

        btn_trab.setBackground(new java.awt.Color(255, 255, 255));
        btn_trab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Icon_Trabajdores.jpeg"))); // NOI18N
        btn_trab.setBorder(null);
        btn_trab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_trab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_trabActionPerformed(evt);
            }
        });

        appName.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        appName.setForeground(new java.awt.Color(255, 255, 255));
        appName.setText("Sistema de administracion ,control y entrega de boletas");

        btn_prin.setBackground(new java.awt.Color(255, 255, 255));
        btn_prin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Icon_Principal.jpeg"))); // NOI18N
        btn_prin.setBorder(null);
        btn_prin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_prin.setMaximumSize(new java.awt.Dimension(80, 27));
        btn_prin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prinActionPerformed(evt);
            }
        });

        btn_envioB.setBackground(new java.awt.Color(255, 255, 255));
        btn_envioB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Icon_EnvioCorreo.jpeg"))); // NOI18N
        btn_envioB.setBorder(null);
        btn_envioB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_envioB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_envioBActionPerformed(evt);
            }
        });

        btn_Boletas.setBackground(new java.awt.Color(255, 255, 255));
        btn_Boletas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Icon_Boletas.jpeg"))); // NOI18N
        btn_Boletas.setBorder(null);
        btn_Boletas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Boletas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BoletasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(287, 287, 287)
                .addComponent(appName)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(btn_prin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119)
                .addComponent(btn_trab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Boletas, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122)
                .addComponent(btn_envioB, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(appName)
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_trab, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_prin, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_envioB, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Boletas, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        conten.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contenLayout = new javax.swing.GroupLayout(conten);
        conten.setLayout(contenLayout);
        contenLayout.setHorizontalGroup(
            contenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1055, Short.MAX_VALUE)
        );
        contenLayout.setVerticalGroup(
            contenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 525, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(FondoLayout.createSequentialGroup()
                .addComponent(conten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(conten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 1055, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_trabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_trabActionPerformed
           Trabajadores trabajadores = new Trabajadores();
           JPanel vistatrabajadores= trabajadores.getPanel();
           ShowJPanel(vistatrabajadores);
    }//GEN-LAST:event_btn_trabActionPerformed

    private void btn_prinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prinActionPerformed
        ShowJPanel(new Principal());
    }//GEN-LAST:event_btn_prinActionPerformed

    private void btn_BoletasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BoletasActionPerformed
           Boletas boletas = new Boletas();
           JPanel vistaboleta= boletas.getPanel();
           ShowJPanel(vistaboleta);
    }//GEN-LAST:event_btn_BoletasActionPerformed

    private void btn_envioBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_envioBActionPerformed
             ShowJPanel(new Email());
    }//GEN-LAST:event_btn_envioBActionPerformed

    private static javax.swing.JPanel content;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel appName;
    private javax.swing.JButton btn_Boletas;
    private javax.swing.JButton btn_envioB;
    private javax.swing.JButton btn_prin;
    private javax.swing.JButton btn_trab;
    private javax.swing.JPanel conten;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
