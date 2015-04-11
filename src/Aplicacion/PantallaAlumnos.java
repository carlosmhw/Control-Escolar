/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;


import Database.OracleBD;
import java.awt.Dialog;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alejandro
 */
public class PantallaAlumnos extends javax.swing.JFrame {
    String nombre, paterno, materno, carrera;
    int semestre;
    
    public DefaultTableModel modeloCalif = new DefaultTableModel(){

        @Override
        public boolean isCellEditable(int row, int column) {
           //all cells false
           return false;
        }
    };;
    
    public DefaultTableModel modeloFaltas = new DefaultTableModel(){

        @Override
        public boolean isCellEditable(int row, int column) {
           //all cells false
           return false;
        }
    };;
    
    public PantallaAlumnos() {
        initComponents();
    }
     public PantallaAlumnos (String matriculaAl) {
        initComponents();
        labMatricula.setText(matriculaAl);
        
        
        modeloCalif.addColumn("ID");
        modeloCalif.addColumn("Semestre");
        modeloCalif.addColumn("Materia");
        modeloCalif.addColumn("Parcial 1");
        modeloCalif.addColumn("Parcial 2");
        modeloCalif.addColumn("Parcial 3");
        modeloCalif.addColumn("Promedio");
        
        modeloFaltas.addColumn("IDMATERIA");
        modeloFaltas.addColumn("MATERIA");
        modeloFaltas.addColumn("FALTAS");
        
        
        
        OracleBD OracleConection = new OracleBD();
               
                try{
                    OracleConection.conectar();                
                    Connection conn = OracleConection.getConnection();
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery ("SELECT * FROM Alumno  WHERE matriculaAL = '"+matriculaAl+"'");
                    while(rs.next()){
                    nombre= rs.getString("nombre"); 
                    paterno = rs.getString("apellidoPaterno");
                    materno = rs.getString("apellidoMaterno");                    
                    carrera = rs.getString("idCarrera");    
                    labnombre.setText(nombre + " " + paterno + " " + materno);
                    labCarrera.setText(carrera);
                    }
                }catch(Exception ex){
                    System.out.println("Error: " + ex.getMessage());
                }
       
                
        String query = "select idmateria,M.semestre, M.nombre, parcial1,parcial2,parcial3,promedio" + 
                    " from alumno " +
                    "join grupo G using(idgrupo)" +
                    "join kardex K using(matriculaAL)" +
                    "join calificaciones C using(idkardex)\n" +
                    "join materia M using(idMateria)\n" +
                    "where matriculaAL='"+matriculaAl+"' and G.semestre = M.semestre order by idmateria";         
                
                
                
        OracleBD OracleConnection = new OracleBD();
            try {
                OracleConnection.conectar();
                Connection conn = OracleConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rset = stmt.executeQuery(
                        query
                );  
                while(rset.next()){
                    Object[] fila = new Object[7];
                           for (int i = 0; i <= 6; i++){
                               fila[i]=rset.getObject(i+1);
                           }
                           modeloCalif.addRow(fila);
                }
                jTableCalifiAlumno.setModel(modeloCalif);
                stmt.close();
                OracleConnection.cerrar();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
            
            
        //OracleBD OracleConnection = new OracleBD();
            try {
                OracleConnection.conectar();
                Connection conn = OracleConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rset = stmt.executeQuery("SELECT IDMATERIA, M.NOMBRE, FUN_CONTADOR_FALTAS('"+matriculaAl+"',IDMATERIA) FALTAS "
                        + "FROM MATERIA M JOIN GRUPO USING(IDCARRERA) "
                        + "WHERE IDGRUPO=(SELECT IDGRUPO FROM ALUMNO WHERE MATRICULAAL='"+matriculaAl+"') "
                        + "AND M.SEMESTRE=GRUPO.SEMESTRE"); 
                //System.out.println("Query ejecutado");
                while(rset.next()){
                    //System.out.println("kjhk");
                    Object[] fila = new Object[3];
                           for (int i = 0; i <= 2; i++){
                               fila[i]=rset.getObject(i+1);
                           }
                           modeloFaltas.addRow(fila);
                }
                jTableFaltasAlumno.setModel(modeloFaltas);
                stmt.close();
                OracleConnection.cerrar();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }   
            
            //jtable

    }
     
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labnombre = new javax.swing.JLabel();
        labMatricula = new javax.swing.JLabel();
        labCarrera = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        componenteAyuda1 = new Aplicacion.ComponenteAyuda();
        jSeparator1 = new javax.swing.JSeparator();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelHorarioAlumno = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableHorario = new javax.swing.JTable();
        jPanelCalifAlumno = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableCalifiAlumno = new javax.swing.JTable();
        jPanelFaltasAlumno = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTableFaltasAlumno = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Control Escolar");
        setResizable(false);

        labnombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labnombre.setText("Nombre");

        labMatricula.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labMatricula.setText("Matricula");

        labCarrera.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labCarrera.setText("Grupo");

        jButton1.setText("Cerrar Sesion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanelHorarioAlumno.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Horario", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jTableHorario.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTableHorario);

        javax.swing.GroupLayout jPanelHorarioAlumnoLayout = new javax.swing.GroupLayout(jPanelHorarioAlumno);
        jPanelHorarioAlumno.setLayout(jPanelHorarioAlumnoLayout);
        jPanelHorarioAlumnoLayout.setHorizontalGroup(
            jPanelHorarioAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHorarioAlumnoLayout.createSequentialGroup()
                .addContainerGap(220, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(299, 299, 299))
        );
        jPanelHorarioAlumnoLayout.setVerticalGroup(
            jPanelHorarioAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHorarioAlumnoLayout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(272, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Horario", jPanelHorarioAlumno);

        jPanelCalifAlumno.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Calififcaciones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jTableCalifiAlumno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Semestre", "Materia", "Parcial 1", "Parcial 2", "Parcial 3", "Promedio"
            }
        ));
        jTableCalifiAlumno.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableCalifiAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCalifiAlumnoMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTableCalifiAlumno);

        javax.swing.GroupLayout jPanelCalifAlumnoLayout = new javax.swing.GroupLayout(jPanelCalifAlumno);
        jPanelCalifAlumno.setLayout(jPanelCalifAlumnoLayout);
        jPanelCalifAlumnoLayout.setHorizontalGroup(
            jPanelCalifAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCalifAlumnoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 951, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelCalifAlumnoLayout.setVerticalGroup(
            jPanelCalifAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCalifAlumnoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Calificaciones", jPanelCalifAlumno);

        jPanelFaltasAlumno.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Faltas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jTableFaltasAlumno.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane10.setViewportView(jTableFaltasAlumno);

        javax.swing.GroupLayout jPanelFaltasAlumnoLayout = new javax.swing.GroupLayout(jPanelFaltasAlumno);
        jPanelFaltasAlumno.setLayout(jPanelFaltasAlumnoLayout);
        jPanelFaltasAlumnoLayout.setHorizontalGroup(
            jPanelFaltasAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFaltasAlumnoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 951, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelFaltasAlumnoLayout.setVerticalGroup(
            jPanelFaltasAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFaltasAlumnoLayout.createSequentialGroup()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Faltas", jPanelFaltasAlumno);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(labMatricula)
                                .addGap(18, 18, 18)
                                .addComponent(labnombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jSeparator1)
                                .addGap(47, 47, 47))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(labCarrera)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(componenteAyuda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(componenteAyuda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(labnombre)
                                .addComponent(labMatricula))
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labCarrera)))
                .addGap(9, 9, 9)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         int mensajeConfirmacion;
        mensajeConfirmacion = JOptionPane.showConfirmDialog(null, "¿Esta seguro de cerrar sesión?", "Confirmación", 
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        /*Limpiar();
        Deshabilitar();*/
        if (mensajeConfirmacion == JOptionPane.NO_OPTION) {
            System.out.println("No button clicked");
        } else if (mensajeConfirmacion == JOptionPane.YES_OPTION) {
            this.dispose();
            Login login = new Login();       
            login.setVisible(true);
        } else if (mensajeConfirmacion == JOptionPane.CLOSED_OPTION) {
            System.out.println("JOptionPane closed");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTableCalifiAlumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCalifiAlumnoMouseClicked
        //btnEditar.setEnabled(true);
    }//GEN-LAST:event_jTableCalifiAlumnoMouseClicked

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
            java.util.logging.Logger.getLogger(PantallaAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaAlumnos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Aplicacion.ComponenteAyuda componenteAyuda1;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanelCalifAlumno;
    private javax.swing.JPanel jPanelFaltasAlumno;
    private javax.swing.JPanel jPanelHorarioAlumno;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableCalifiAlumno;
    private javax.swing.JTable jTableFaltasAlumno;
    private javax.swing.JTable jTableHorario;
    private javax.swing.JLabel labCarrera;
    private javax.swing.JLabel labMatricula;
    private javax.swing.JLabel labnombre;
    // End of variables declaration//GEN-END:variables
}
