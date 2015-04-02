


package Aplicacion;
public class Calificaciones extends javax.swing.JFrame {
    String usuario;
    boolean flag_habilitar = false;
    
    public Calificaciones(String tipoUsuario, String matriculaAL){
        this.usuario = tipoUsuario;  
        initComponents(); 
        if(usuario.equals("ALUMNO")){
            ocultarCampos();
            ocultarBotones();
        }
    }
    public Calificaciones() {
        initComponents(); 
        habilitarBotones(flag_habilitar);
        habilitarCampos(flag_habilitar);
        
    }
       

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnguardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jComboBoxCalificacion = new javax.swing.JComboBox();
        lblPunto = new javax.swing.JLabel();
        jComboBoxDecimal = new javax.swing.JComboBox();
        jComboBoxParcial = new javax.swing.JComboBox();
        btnEditar = new javax.swing.JButton();
        lbParcial = new javax.swing.JLabel();
        lblCalif = new javax.swing.JLabel();
        btnConfirmarCalif = new javax.swing.JButton();
        componenteAyuda1 = new Aplicacion.ComponenteAyuda();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Calificaciones");
        setResizable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        jComboBoxCalificacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        jComboBoxCalificacion.setPreferredSize(new java.awt.Dimension(42, 20));
        jComboBoxCalificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCalificacionActionPerformed(evt);
            }
        });

        lblPunto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPunto.setText(".");

        jComboBoxDecimal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        jComboBoxDecimal.setPreferredSize(new java.awt.Dimension(47, 20));
        jComboBoxDecimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDecimalActionPerformed(evt);
            }
        });

        jComboBoxParcial.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Parcial 1", "Parcial 2", "Parcial 3" }));

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        lbParcial.setText("Parcial: ");

        lblCalif.setText("Calificacion:");

        btnConfirmarCalif.setText("Confirmar Calificacion");
        btnConfirmarCalif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarCalifActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnConfirmarCalif, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btncancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbParcial)
                                    .addComponent(lblCalif))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jComboBoxParcial, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboBoxCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblPunto, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxDecimal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(9, 9, 9)))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(componenteAyuda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(btnEditar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBoxParcial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbParcial))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBoxCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPunto)
                                    .addComponent(jComboBoxDecimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblCalif, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGap(14, 14, 14)
                            .addComponent(btnguardar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btncancelar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnConfirmarCalif)))
                    .addComponent(componenteAyuda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        //Actualizar tabla y guardar en base de datos
        
        flag_habilitar = false;
        habilitarCampos(flag_habilitar);
        habilitarBotones(flag_habilitar);
    }//GEN-LAST:event_btnguardarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        btnEditar.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        flag_habilitar = true;
        habilitarCampos(flag_habilitar);
        habilitarBotones(flag_habilitar);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void jComboBoxDecimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDecimalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxDecimalActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        flag_habilitar = false;
        habilitarCampos(flag_habilitar);
        habilitarBotones(flag_habilitar);
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnConfirmarCalifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarCalifActionPerformed
        //Pedir contrasenia
        //guardar
        flag_habilitar = false;
        habilitarCampos(flag_habilitar);
        habilitarBotones(flag_habilitar);
    }//GEN-LAST:event_btnConfirmarCalifActionPerformed

    private void jComboBoxCalificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCalificacionActionPerformed
        //si es un 10 la calificacion, bloquear los decimales
        if ("10".equals(jComboBoxCalificacion.getSelectedItem())){
            jComboBoxDecimal.setSelectedIndex(0);
            jComboBoxDecimal.setEnabled(false);
        }
        else{
            jComboBoxDecimal.setEnabled(true);
        }
    }//GEN-LAST:event_jComboBoxCalificacionActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Calificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calificaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmarCalif;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnguardar;
    private Aplicacion.ComponenteAyuda componenteAyuda1;
    private javax.swing.JComboBox jComboBoxCalificacion;
    private javax.swing.JComboBox jComboBoxDecimal;
    private javax.swing.JComboBox jComboBoxParcial;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbParcial;
    private javax.swing.JLabel lblCalif;
    private javax.swing.JLabel lblPunto;
    // End of variables declaration//GEN-END:variables

    private void ocultarCampos() {
        jComboBoxParcial.setVisible(false);
        jComboBoxCalificacion.setVisible(false);
        jComboBoxDecimal.setVisible(false);
        lbParcial.setVisible(false);
        lblCalif.setVisible(false);
        lblPunto.setVisible(false);
    }

    private void ocultarBotones() {
        btnEditar.setVisible(false);
        btnguardar.setVisible(false);
        btncancelar.setVisible(false);
        btnConfirmarCalif.setVisible(false);
    }

    private void habilitarCampos(boolean b) {
        jComboBoxParcial.setEnabled(b);
        jComboBoxCalificacion.setEnabled(b);
        jComboBoxDecimal.setEnabled(b);
        lbParcial.setEnabled(b);
        lblCalif.setEnabled(b);
        lblPunto.setEnabled(b);
    }

    private void habilitarBotones(boolean b) {
        btnEditar.setEnabled(b);
        btnguardar.setEnabled(b);
        btncancelar.setEnabled(b);
        btnConfirmarCalif.setEnabled(b);
    }
}
