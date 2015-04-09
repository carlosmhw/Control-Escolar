/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import Database.OracleBD;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Alejandro
 */
public class Faltas extends javax.swing.JDialog{
    
    public String fecha,matricula;
   
    
    
    /**
     * Creates new form Faltas
     */
    public Faltas() {
        initComponents();
        jDateChooser1.getDateEditor().setEnabled(false);
        ponerFechas();
     
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        fecha =  String.valueOf(sdf.format(jDateChooser1.getDate()));
        jDateChooser1.getDateEditor().addPropertyChangeListener(
            new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent e) {
                    if ("date".equals(e.getPropertyName())) {
                        fecha =  String.valueOf(sdf.format(jDateChooser1.getDate()));
                        System.out.println(fecha);
                    }
                }
            });
        System.out.println(fecha);
    }
    
    public Faltas(String matriculaPR) {
        matricula=matriculaPR;
        initComponents();
        jDateChooser1.getDateEditor().setEnabled(false);
        ponerFechas();
        
        btnguardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        
        
        jComboBoxGrupo.removeAllItems();
        OracleBD OracleConnection = new OracleBD();
        try{
                    OracleConnection.conectar();
                    Connection conn = OracleConnection.getConnection();
                    Statement s1 = conn.createStatement();
                    ResultSet rs1 = s1.executeQuery ("SELECT DISTINCT nombre FROM GRUPO JOIN RELPROFESORMATERIA USING(IDGRUPO) "
                            + "WHERE MATRICULAPR='"+matriculaPR+"' "
                            + "ORDER BY nombre");
                    while(rs1.next()){
                        jComboBoxGrupo.addItem(rs1.getString("nombre"));
                    } 
                }catch(Exception ex){
                    System.out.println("Error: " + ex.getMessage());
                }
        
        jDateChooser1.getDateEditor().setEnabled(false);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        fecha =  String.valueOf(sdf.format(jDateChooser1.getDate()));
        jDateChooser1.getDateEditor().addPropertyChangeListener(
            new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent e) {
                    if ("date".equals(e.getPropertyName())) {
                        fecha =  String.valueOf(sdf.format(jDateChooser1.getDate()));
                        System.out.println(fecha);
                    }
                }
            });
        System.out.println(fecha);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnguardar = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jComboBoxGrupo = new javax.swing.JComboBox();
        jComboBoxMateria = new javax.swing.JComboBox();
        jCheckBoxTodo = new javax.swing.JCheckBox();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Faltas");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Faltas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

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
        jScrollPane1.setViewportView(jTable1);

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        jDateChooser1.setDateFormatString("dd/MM/yyyy");
        jDateChooser1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDateChooser1MouseClicked(evt);
            }
        });
        jDateChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser1PropertyChange(evt);
            }
        });

        jComboBoxGrupo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxGrupoActionPerformed(evt);
            }
        });

        jComboBoxMateria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMateriaActionPerformed(evt);
            }
        });

        jCheckBoxTodo.setText("Marcar Todo");
        jCheckBoxTodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBoxTodoMouseClicked(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxTodo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxGrupo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxTodo))
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguardar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jDateChooser1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser1MouseClicked

    private void jDateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser1PropertyChange

    private void jComboBoxGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxGrupoActionPerformed
        jComboBoxMateria.removeAllItems();
        OracleBD OracleConnection = new OracleBD();
        try{
                    OracleConnection.conectar();
                    Connection conn = OracleConnection.getConnection();
                    Statement s1 = conn.createStatement();
                    ResultSet rs1 = s1.executeQuery ("SELECT nombre MATERIA FROM MATERIA JOIN RELPROFESORMATERIA USING(IDMATERIA) "
                            + "WHERE MATRICULAPR='"+matricula+"' "
                            + "AND IDGRUPO=(SELECT IDGRUPO FROM GRUPO WHERE NOMBRE='"+(String) jComboBoxGrupo.getSelectedItem()+"') "
                            + "Order BY nombre");
                    while(rs1.next()){
                        jComboBoxMateria.addItem(rs1.getString("MATERIA"));
                    } 
                }catch(Exception ex){
                    System.out.println("Error: " + ex.getMessage());
                }
    }//GEN-LAST:event_jComboBoxGrupoActionPerformed

    private void jComboBoxMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMateriaActionPerformed
        DefaultTableModel modelo = new DefaultTableModel(){
        
            
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
                };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            
            @Override
            public boolean isCellEditable(int row, int col) {
                return (col == 4); 
            }
            
        };
        modelo.addColumn("Matricula");
        modelo.addColumn("Nombre");
        modelo.addColumn("Ap. Paterno");
        modelo.addColumn("Ap. Materno");
        modelo.addColumn("Falta");
        
        TableRowSorter elQueOrdena = new TableRowSorter(modelo);//Permite ordenar las filas seleccionando la cabezera
        jTable1.setRowSorter(elQueOrdena);
        jTable1.setModel(modelo);
        
        OracleBD OracleConnection = new OracleBD();
        try{
            OracleConnection.conectar();
            Connection conn = OracleConnection.getConnection();
            Statement s1 = conn.createStatement();
            ResultSet rs1 = s1.executeQuery ("SELECT DISTINCT matriculaAL, A.nombre, apellidoPaterno, apellidoMaterno "
                    + "FROM ALUMNO A JOIN RELPROFESORMATERIA USING(IDGRUPO) "
                    + "JOIN GRUPO G USING(idGrupo) "
                    + "WHERE MATRICULAPR='"+matricula+"' AND G.nombre='"+jComboBoxGrupo.getSelectedItem()+"' "
                    + "ORDER BY apellidoPaterno,apellidoMaterno,A.nombre");
            while(rs1.next()){
                    System.out.println(rs1.getString(2));
                    Object[] fila = new Object[4];
                       for (int i = 0; i <= 3; i++){
                           fila[i]=rs1.getObject(i+1);
                       }
                       modelo.addRow(fila);
                       modelo.setValueAt(false, modelo.getRowCount()-1, 4);
                    btnguardar.setEnabled(true);
                    btnCancelar.setEnabled(true);
                }
            rs1.close();
            OracleConnection.cerrar();
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
        //Poner el color de los checkbox
        ((JComponent) jTable1.getDefaultRenderer(Boolean.class)).setOpaque(true);
        jCheckBoxTodo.setSelected(false);
    }//GEN-LAST:event_jComboBoxMateriaActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        String matAlumno;
        String materia = (String) jComboBoxMateria.getSelectedItem();
        int filas = jTable1.getRowCount();
        
        for (int i=0; i < filas; i++){
            if( (Boolean) jTable1.getValueAt(i, 4) ){
                matAlumno = (String) jTable1.getValueAt(i, 0);
                System.out.println(matAlumno+" "+fecha);
                OracleBD OracleConnection = new OracleBD();
                try{
                    OracleConnection.conectar();
                    Connection conn = OracleConnection.getConnection();
                    Statement s1 = conn.createStatement();
                    ResultSet rs1 = s1.executeQuery ("SELECT COUNT(*) CUENTA FROM FALTAS WHERE "
                            + "matriculaAL='"+matAlumno+"' AND idMateria=(SELECT IDMATERIA FROM MATERIA JOIN RELPROFESORMATERIA "
                            + "USING(IDMATERIA) WHERE MATERIA.NOMBRE='"+materia+"' AND "
                            + "MATRICULAPR='"+matricula+"') AND FECHA='"+fecha+"'");
                    int k=-1;
                    rs1.next();
                    k= (rs1.getInt("CUENTA"));
                    System.out.println(k);
                    if (k==0){
                        s1.executeQuery ("INSERT INTO FALTAS VALUES "
                            + "('',to_date('"+fecha+"','DD/MM/YYYY'),0,'"+matAlumno+"', "
                            + "(SELECT IDMATERIA FROM MATERIA JOIN RELPROFESORMATERIA USING(IDMATERIA) WHERE MATERIA.NOMBRE='"+materia+"' AND "
                            + "MATRICULAPR='"+matricula+"'),(SELECT IDRELPROFESORMATERIA FROM MATERIA JOIN RELPROFESORMATERIA USING(IDMATERIA) "
                            + "WHERE MATERIA.NOMBRE='"+materia+"' AND "
                            + "MATRICULAPR='"+matricula+"'))");
                    }
                }catch(Exception ex){
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Faltas ingresados para la fecha "+fecha);
        jCheckBoxTodo.setSelected(false);
        for (int i=0; i < filas; i++){
            jTable1.setValueAt(jCheckBoxTodo.isSelected(), i, 4);
        } 
    }//GEN-LAST:event_btnguardarActionPerformed

    private void jCheckBoxTodoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxTodoMouseClicked
        int filas = jTable1.getRowCount();
        for (int i=0; i < filas; i++){
            jTable1.setValueAt(jCheckBoxTodo.isSelected(), i, 4);
        }

    }//GEN-LAST:event_jCheckBoxTodoMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(Faltas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Faltas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Faltas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Faltas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Faltas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JCheckBox jCheckBoxTodo;
    private javax.swing.JComboBox jComboBoxGrupo;
    private javax.swing.JComboBox jComboBoxMateria;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void ponerFechas() {
        Date inicio, hoy, fin;
        OracleBD OracleConnection = new OracleBD();
                try{
                    OracleConnection.conectar();
                    Connection conn = OracleConnection.getConnection();
                    Statement s1 = conn.createStatement();
                    ResultSet rs1 = s1.executeQuery ("SELECT (select sysdate from dual) hoy, "
                            + "fechainicioclases inicio, fechafinclases fin FROM contador");
                    while(rs1.next()){
                        hoy = rs1.getDate("hoy");
                        jDateChooser1.setDate(hoy);

                        inicio = rs1.getDate("inicio");
                        jDateChooser1.getJCalendar().setMinSelectableDate(inicio);
                        

                        fin = rs1.getDate("fin");
                        
                        if (fin.before(hoy)){
                            jDateChooser1.getJCalendar().setMaxSelectableDate(fin);
                        }
                        else{
                            jDateChooser1.getJCalendar().setMaxSelectableDate(hoy);
                        } 
                        
                    }   
                }catch (SQLException ex) {
                    Logger.getLogger(Faltas.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
}
