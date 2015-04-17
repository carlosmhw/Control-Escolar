package Aplicacion;
import Database.OracleBD;
import java.awt.Cursor;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class Login extends javax.swing.JFrame {         
        String usuario; 
        String contrasena;
        String tipoUsuario;
        /*ResultSet rs;
        Statement stm;*/     
    public Login() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        componenteAyuda1 = new Aplicacion.ComponenteAyuda();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Control Escolar - Inicio sesión");
        setIconImages(null);
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Aplicacion/image/logo.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Institución Academica ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addContainerGap(97, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(componenteAyuda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(componenteAyuda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Usuario: ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Contraseña: ");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jButton1.setText("Entrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(jPasswordField1))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(148, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        usuario = jTextField1.getText().toUpperCase();
        contrasena = jPasswordField1.getText();
        ValidacionLogin validaruser = new ValidacionLogin();
        if(validaruser.validarUsuario(usuario, contrasena)){
            if(usuario.substring(0,2).equals("AL")){
                tipoUsuario = "ALUMNO";
                System.out.println(tipoUsuario);
                String usuarioRs = null; 
                String contrasenaRs = null; 
                OracleBD OracleConection = new OracleBD();
                try {
                    OracleConection.conectar();
                    Connection conn = OracleConection.getConnection();
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery ("SELECT * FROM Alumno WHERE matriculaAl = '"+usuario+"'");
                    while(rs.next()){
                        usuarioRs= rs.getString("matriculaAl");                            
                        contrasenaRs = rs.getString("contrasena");
                    }
                    stmt.close();
                    OracleConection.cerrar();
                    if(usuario.equals(usuarioRs) && contrasena.equals(contrasenaRs)){
                        PantallaAlumnos cnAl = new PantallaAlumnos(usuarioRs);
                        this.dispose();
                        cnAl.setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null,"Usuario o contraseña incorrectos","Información", JOptionPane.INFORMATION_MESSAGE);
                    }      
                }catch (SQLException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }         
            }else if(usuario.substring(0,2).equals("PR")){ 
                    tipoUsuario = "PROFESOR";
                    System.out.println(tipoUsuario);
                    //Inicia conexion con la base de datos                     
                    String usuarioRs = null; 
                    String contrasenaRs = null;
                    OracleBD OracleConection = new OracleBD();
                try {
                    OracleConection.conectar();
                    Connection conn = OracleConection.getConnection();
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery ("SELECT * FROM Profesor WHERE matriculaPR = '"+usuario+"'");
                    while(rs.next()){
                        usuarioRs= rs.getString("matriculaPr");
                        contrasenaRs = rs.getString("contrasena");
                    }
                    if(usuario.equals(usuarioRs) && contrasena.equals(contrasenaRs)){
                        PantallaProfesor pantProfesor = new PantallaProfesor(usuario);
                        this.dispose();
                        pantProfesor.setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null,"Usuario o contraseña incorrectos","Información", JOptionPane.INFORMATION_MESSAGE);
                    }  
                    stmt.close();
                    OracleConection.cerrar();
                } catch (SQLException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }   
                //Termina conexion base de datos 
            }else if(usuario.substring(0,2).equals("AD")){
                tipoUsuario = "ADMINISTRADOR";
                System.out.println(tipoUsuario);                    
                //Inicia conexion con la base de datos                     
                String usuarioRs = null; 
                String contrasenaRs = null; 
                OracleBD OracleConection = new OracleBD();
                try{
                    OracleConection.conectar();
                    Connection conn = OracleConection.getConnection();
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Administrador WHERE matriculaAdm = '"+usuario+"'");
                    while (rs.next()) {
                        usuarioRs = rs.getString("matriculaAdm");
                        contrasenaRs = rs.getString("contrasena");
                    }
                    if(usuario.equals(usuarioRs) && contrasena.equals(contrasenaRs)){
                        PantallaAdministrador pantAdministrador = new PantallaAdministrador(usuario);
                        this.dispose();
                        pantAdministrador.setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null,"Usuario o contraseña incorrectos","Información", JOptionPane.INFORMATION_MESSAGE);
                    } 
                    stmt.close();
                    OracleConection.cerrar();
                        
                }catch(SQLException ex){
                     System.out.println("Error: " + ex.getMessage());                       
                        
                }           
                //Termina conexion con la base dedatos                                       
            }else{
                JOptionPane.showMessageDialog(null,"Usuario o contraseña incorrectos","Información", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
        if(jTextField1.getText().length() == 7){
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jPasswordField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyTyped
        // TODO add your handling code here:
        if(jPasswordField1.getText().length() == 20){
            evt.consume();
        }
    }//GEN-LAST:event_jPasswordField1KeyTyped

    private void jPasswordField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == 10){
            usuario = jTextField1.getText().toUpperCase();
            contrasena = jPasswordField1.getText();
            ValidacionLogin validaruser = new ValidacionLogin();
            if(validaruser.validarUsuario(usuario, contrasena)){
                if(usuario.substring(0,2).equals("AL")){
                    tipoUsuario = "ALUMNO";
                    System.out.println(tipoUsuario);
                    String usuarioRs = null; 
                    String contrasenaRs = null; 
                    OracleBD OracleConection = new OracleBD();
                try {
                    OracleConection.conectar();
                    Connection conn = OracleConection.getConnection();
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery ("SELECT * FROM Alumno WHERE matriculaAl = '"+usuario+"'");
                    while(rs.next()){
                        usuarioRs= rs.getString("matriculaAl");                            
                        contrasenaRs = rs.getString("contrasena");
                    }
                    stmt.close();
                    OracleConection.cerrar();
                    if(usuario.equals(usuarioRs) && contrasena.equals(contrasenaRs)){
                        PantallaAlumnos cnAl = new PantallaAlumnos(usuarioRs);
                        this.dispose();
                        cnAl.setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null,"Usuario o contraseña incorrectos","Información", JOptionPane.INFORMATION_MESSAGE);
                    }      
                }catch (SQLException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }         
            }else if(usuario.substring(0,2).equals("PR")){ 
                    tipoUsuario = "PROFESOR";
                    System.out.println(tipoUsuario);
                    //Inicia conexion con la base de datos                     
                    String usuarioRs = null; 
                    String contrasenaRs = null;
                    OracleBD OracleConection = new OracleBD();
                try {
                    OracleConection.conectar();
                    Connection conn = OracleConection.getConnection();
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery ("SELECT * FROM Profesor WHERE matriculaPR = '"+usuario+"'");
                    while(rs.next()){
                        usuarioRs= rs.getString("matriculaPr");
                        contrasenaRs = rs.getString("contrasena");
                    }
                    if(usuario.equals(usuarioRs) && contrasena.equals(contrasenaRs)){
                        PantallaProfesor pantProfesor = new PantallaProfesor(usuario);
                        this.dispose();
                        pantProfesor.setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null,"Usuario o contraseña incorrectos","Información", JOptionPane.INFORMATION_MESSAGE);
                    }  
                    stmt.close();
                    OracleConection.cerrar();
                } catch (SQLException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }   
                //Termina conexion base de datos 
            }else if(usuario.substring(0,2).equals("AD")){
                tipoUsuario = "ADMINISTRADOR";
                System.out.println(tipoUsuario);                    
                //Inicia conexion con la base de datos                     
                String usuarioRs = null; 
                String contrasenaRs = null; 
                OracleBD OracleConection = new OracleBD();
                try{
                    OracleConection.conectar();
                    Connection conn = OracleConection.getConnection();
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Administrador WHERE matriculaAdm = '"+usuario+"'");
                    while (rs.next()) {
                        usuarioRs = rs.getString("matriculaAdm");
                        contrasenaRs = rs.getString("contrasena");
                    }
                    if(usuario.equals(usuarioRs) && contrasena.equals(contrasenaRs)){
                        PantallaAdministrador pantAdministrador = new PantallaAdministrador(usuario);
                        this.dispose();
                        pantAdministrador.setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null,"Usuario o contraseña incorrectos","Información", JOptionPane.INFORMATION_MESSAGE);
                    } 
                    stmt.close();
                    OracleConection.cerrar();
                        
                }catch(SQLException ex){
                     System.out.println("Error: " + ex.getMessage());                       
                        
                }           
                //Termina conexion con la base dedatos                                       
            }else{
                JOptionPane.showMessageDialog(null,"Usuario o contraseña incorrectos","Información", JOptionPane.INFORMATION_MESSAGE);
            }
            }
        }
    }//GEN-LAST:event_jPasswordField1KeyPressed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == 10){
            jPasswordField1.requestFocusInWindow();
        }
    }//GEN-LAST:event_jTextField1KeyPressed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Aplicacion.ComponenteAyuda componenteAyuda1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
