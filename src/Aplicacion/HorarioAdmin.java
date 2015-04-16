/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import Database.OracleBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Arael
 */
public class HorarioAdmin extends javax.swing.JFrame {

    public DefaultTableModel modeloHorario = new DefaultTableModel(){

        @Override
        public boolean isCellEditable(int row, int column) {
           //all cells false
           return false;
        }
    };;
    
    
    
    
    
    public HorarioAdmin() {
        initComponents();
    }
    
    
    public HorarioAdmin(String Usuario, String matricula) {
        initComponents();
        jTableHorario.getTableHeader().setReorderingAllowed(false);
        String query = "SELECT M.NOMBRE MATERIA, "
                + "H.LUNES||'  '||H.SALLUN LUNES, "
                + "H.MARTE||'  '||H.SALMAR MARTES, "
                + "H.MIERC||'  '||H.SALMIE MIERCOLES, "
                + "H.JUEVE||'  '||H.SALJUE JUEVES, "
                + "H.VIERN||'  '||H.SALVIE VIERNES, "
                + "H.SABAD||'  '||H.SALSAB SABADO "
                + "FROM HORARIO2 H JOIN ALUMNO USING(IDGRUPO) JOIN MATERIA M USING(IDMATERIA) "
                + "WHERE MATRICULAAL='"+matricula+"'";
        
        if (Usuario.equals("PROFESOR")){
            query = "SELECT M.NOMBRE, "
                    + "H.LUNES||H.SALLUN LUNES, "
                    + "H.MARTE||H.SALMAR MARTES, "
                    + "H.MIERC||H.SALMIE MIERCOLES, "
                    + "H.JUEVE||H.SALJUE JUEVES, "
                    + "H.VIERN||H.SALVIE VIERNES, "
                    + "H.SABAD||H.SALSAB SABADO "
                    + "FROM HORARIO2 H JOIN RELPROFESORMATERIA R USING(IDMATERIA) "
                    + "JOIN MATERIA M USING(IDMATERIA) WHERE MATRICULAPR='"+matricula+"'";
        }
        
        
        OracleBD OracleConection = new OracleBD();
        try{
            OracleConection.conectar();                
            Connection conn = OracleConection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery (query);
            ResultSetMetaData metaData = rs.getMetaData();
            int count = metaData.getColumnCount(); //number of column

            for (int i = 1; i <= count; i++)
            {
               modeloHorario.addColumn(metaData.getColumnLabel(i));
            }
                    
            while(rs.next()){
                Object[] fila = new Object[count];
                       for (int i = 0; i <= count-1; i++){
                           fila[i]=rs.getObject(i+1);
                       }
                       modeloHorario.addRow(fila);
            }
            jTableHorario.setModel(modeloHorario);
            stmt.close();
            OracleConection.cerrar();
        }catch(Exception ex){
            System.out.println("Error Pendejo: " + ex.getMessage());
        }
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
        jTableHorario = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        jScrollPane1.setViewportView(jTableHorario);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
            java.util.logging.Logger.getLogger(HorarioAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HorarioAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HorarioAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HorarioAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HorarioAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableHorario;
    // End of variables declaration//GEN-END:variables
}