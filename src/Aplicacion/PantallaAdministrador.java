package Aplicacion;
import Database.OracleBD;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dialog;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.web.PromptData;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.xswingx.PromptSupport;
public final class PantallaAdministrador extends javax.swing.JFrame {
    String matricula = null, nombre = null, apPaterno = null, apMaterno = null, calle = null, colonia = null, telCasa = null, telMovil = null, corrInst = null, corrPers = null,
           contrasena = null, especialidad = null, carrera = null, grupo = null;
    int numero;
    public boolean flagEditar = false;
    /*DefaultTableModel modelo1 = new DefaultTableModel(); //tabla sin representacion grafica
    DefaultTableModel modelo2 = new DefaultTableModel(); //tabla sin representacion grafica*/

    public void guardarTextFildVar(){
        matricula = jTextFieldMatricula.getText();
        nombre = jTextFieldNombre.getText().toUpperCase();
        apPaterno = jTextFieldApellidoPaterno.getText().toUpperCase();
        apMaterno = jTextFieldApellidoMaterno.getText().toUpperCase();
        calle = jTextFieldCalle.getText().toUpperCase();
        colonia = jTextFieldColonia.getText().toUpperCase();
        telCasa = jTextFieldTelCasaLada.getText();
        telMovil = jTextFieldTelMovill.getText();
        corrInst = jTextFieldCorreoInstitucional.getText().toUpperCase();
        corrPers = jTextFieldCorreoPersonal.getText().toUpperCase();
        contrasena = jTextFieldContrasena.getText();
        numero = Integer.parseInt(jTextFieldNumero.getText());    
        carrera = (String) jComboBoxCarrera.getSelectedItem();
        //grupo = (String) jComboBoxGrupo.getSelectedItem();
    }
    
    public void disablejComboBoxBusqueda(){
        jComboBoxPorCarrera.setEnabled(false);
        jComboBoxPorGrupo.setEnabled(false);
        jComboBoxPorSemestre.setEnabled(false);
    }
    public void enablejComboBoxBusqueda(){
        jComboBoxPorCarrera.setEnabled(true);
        jComboBoxPorGrupo.setEnabled(true);
        jComboBoxPorSemestre.setEnabled(true);
    }
    
    public void disableBusqueda(){
        //jComboBoxTipoUser.setEnabled(false);
        jTextFieldPorMatricula.setEnabled(false);
        jTextFieldPorApellido.setEnabled(false);
        jTextFieldPorNombre.setEnabled(false);
    }
    public void enableBusqueda(){
        jTextFieldPorMatricula.setEnabled(true);
        jTextFieldPorApellido.setEnabled(true);
        jTextFieldPorNombre.setEnabled(true);
    }
    
    //Funcion para deshabilitar jTextField
    public void Deshabilitar(){
        jComboBoxUsuarioNuevo.setEnabled(false);
        jTextFieldMatricula.setEnabled(false);
        jTextFieldNombre.setEnabled(false);
        jTextFieldApellidoPaterno.setEnabled(false);
        jTextFieldApellidoMaterno.setEnabled(false);
        jTextFieldCalle.setEnabled(false);
        jTextFieldColonia.setEnabled(false);
        jTextFieldNumero.setEnabled(false);
        jTextFieldTelCasaLada.setEnabled(false);
        jTextFieldTelMovill.setEnabled(false);
        jTextFieldCorreoInstitucional.setEnabled(false);
        jTextFieldCorreoPersonal.setEnabled(false);
        jTextFieldContrasena.setEnabled(false);
        jComboBoxCarrera.setEnabled(false);
        jComboBoxSemestre.setEnabled(false);
        jComboBoxGrupo.setEnabled(false);
        btnActualizar.setEnabled(false);
        
    }
    public void Habilitar(){
            jComboBoxUsuarioNuevo.setEnabled(true);
            //jTextFieldMatricula.setEnabled(true);
            jTextFieldNombre.setEnabled(true);
            jTextFieldApellidoPaterno.setEnabled(true);
            jTextFieldApellidoMaterno.setEnabled(true);
            jTextFieldCalle.setEnabled(true);
            jTextFieldColonia.setEnabled(true);
            jTextFieldNumero.setEnabled(true);
            jTextFieldTelCasaLada.setEnabled(true);
            jTextFieldTelMovill.setEnabled(true);
            jTextFieldCorreoInstitucional.setEnabled(true);
            jTextFieldCorreoPersonal.setEnabled(true);
            jTextFieldContrasena.setEnabled(true);
            jComboBoxCarrera.setEnabled(true);
            //jComboBoxSemestre.setEnabled(true);
            //jComboBoxGrupo.setEnabled(true);  
           
            //btnActualizar.setEnabled(true);
    }
    public void Limpiar(){
        jTextFieldMatricula.setText("");
        jTextFieldNombre.setText("");
        jTextFieldApellidoPaterno.setText("");
        jTextFieldApellidoMaterno.setText("");
        jTextFieldCalle.setText("");
        jTextFieldColonia.setText("");
        jTextFieldNumero.setText("");
        jTextFieldTelCasaLada.setText("");
        jTextFieldTelMovill.setText("");
        jTextFieldCorreoInstitucional.setText("");
        jTextFieldCorreoPersonal.setText("");
        jTextFieldContrasena.setText("");     
    }
    public void descoloriarCorreo(){
        jTextFieldCorreoPersonal.setBorder(BorderFactory.createEmptyBorder());
        jTextFieldCorreoInstitucional.setBorder(BorderFactory.createEmptyBorder());
    }
    
    // Desabilitar botones debajo de tabla
    
    public void disableButtons(){        
        btncalificaciones.setEnabled(false);
        btnhorario.setEnabled(false);
        btnfaltas.setEnabled(false);
        btnmaterias.setEnabled(false);
        
    }
    public void enableButtons(){
        
        btncalificaciones.setEnabled(true);
        btnhorario.setEnabled(true);
        btnfaltas.setEnabled(true);
        btnmaterias.setEnabled(true);
        
    }

    public PantallaAdministrador() {
        initComponents();
        //jTextFieldTelCasaLada.setToolTipText("Ingresa el numero de casa");
    }
     //Inicia constructor 
    public PantallaAdministrador(String matriculaAdm){
        initComponents();
        btneditar.setEnabled(false);
        btneliminar.setEnabled(false);
        PromptSupport.setPrompt("(123)-456-78-91", jTextFieldTelCasaLada);
        PromptSupport.setPrompt("(123)-456-78-91", jTextFieldTelMovill);
        jTextFieldTelCasaLada.setToolTipText("Ingresa el numero de casa");
        //Prompt
        setLocationRelativeTo(null);
        disablejComboBoxBusqueda();
        jTextFieldMatricula.requestFocusInWindow();
        btnCancelar.setEnabled(false);
        btnhecho.setEnabled(false);
        btnActualizar.setEnabled(false);
        Deshabilitar();     
        disableBusqueda();
        disableButtons();
        llenarjComboBoxPorCarrera();
        jTableBusquedaUser.getTableHeader().setReorderingAllowed(false);
        btnCancelarLimpiar.setEnabled(false);
        //jTextFieldNombre.requestFocusInWindow();
        //jTableBusquedaUser.setEnabled(false);  
        jLabelMatriculaEmpTop.setText(matriculaAdm);
        
        
        String nombreAdm = null;
        String apellidoPaterno = null;
        String apellidoMaterno = null;
        jComboBoxTipoUser.setEnabled(true);
        jComboBoxCarrera.removeAllItems();
        jComboBoxPorCarrera.removeAllItems();
        jComboBoxSemestre.removeAllItems();
        OracleBD OracleConection = new OracleBD();
               
                try{
                    OracleConection.conectar();                
                    Connection conn = OracleConection.getConnection();
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery ("SELECT * FROM Administrador  WHERE matriculaAdm = '"+matriculaAdm+"'");
                    while(rs.next()){
                        nombreAdm= rs.getString("nombre"); 
                        apellidoPaterno= rs.getString("apellidoPaterno");
                        apellidoMaterno = rs.getString("apellidoMaterno");                    
                        labuser.setText(nombreAdm + " " + apellidoPaterno + " " + apellidoMaterno);
                    }
                    rs = stmt.executeQuery ("SELECT idCarrera FROM CARRERA");
                    while(rs.next()){
                        rs.getString("idCarrera");
                        jComboBoxCarrera.addItem(rs.getString("idCarrera"));
                        jComboBoxPorCarrera.addItem(rs.getString("idCarrera"));
                    } 
                    
                    stmt.close();
                    OracleConection.cerrar();
                }catch(Exception ex){
                    System.out.println("Error: " + ex.getMessage());
                }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labuser = new javax.swing.JLabel();
        btncerrar = new javax.swing.JButton();
        jLabelMatriculaEmpTop = new javax.swing.JLabel();
        jPanelBusqueda = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jComboBoxTipoUser = new javax.swing.JComboBox();
        jTextFieldPorMatricula = new javax.swing.JTextField();
        jTextFieldPorNombre = new javax.swing.JTextField();
        jTextFieldPorApellido = new javax.swing.JTextField();
        jLabelPorMatriula = new javax.swing.JLabel();
        jLabelPorNombre = new javax.swing.JLabel();
        jLabelPorApellido = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBusquedaUser = new javax.swing.JTable();
        btnfaltas = new javax.swing.JButton();
        btncalificaciones = new javax.swing.JButton();
        btnhorario = new javax.swing.JButton();
        btnmaterias = new javax.swing.JButton();
        btnCancelarLimpiar = new javax.swing.JButton();
        jComboBoxPorCarrera = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxPorGrupo = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        jComboBoxPorSemestre = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabelMatriculaEmp = new javax.swing.JLabel();
        jTextFieldMatricula = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldApellidoPaterno = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldApellidoMaterno = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldCalle = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldColonia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldNumero = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldTelCasaLada = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldTelMovill = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldCorreoInstitucional = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldCorreoPersonal = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldContrasena = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jComboBoxGrupo = new javax.swing.JComboBox();
        btnhecho = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxUsuarioNuevo = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxCarrera = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jComboBoxSemestre = new javax.swing.JComboBox();
        btnActualizar = new javax.swing.JButton();
        componenteAyuda1 = new Aplicacion.ComponenteAyuda();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrador Principal");
        setPreferredSize(new java.awt.Dimension(950, 700));
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        labuser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labuser.setText("Nombre de usuario ");

        btncerrar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btncerrar.setText("Cerrar Sesion");
        btncerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncerrarActionPerformed(evt);
            }
        });

        jLabelMatriculaEmpTop.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelMatriculaEmpTop.setText("Empleado");

        jPanelBusqueda.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Busqueda usuario", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Usuario:");

        jComboBoxTipoUser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "ADMINISTRADOR", "PROFESOR", "ALUMNO" }));
        jComboBoxTipoUser.setMinimumSize(new java.awt.Dimension(90, 20));
        jComboBoxTipoUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoUserActionPerformed(evt);
            }
        });

        jTextFieldPorMatricula.setText(" ");
        jTextFieldPorMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPorMatriculaActionPerformed(evt);
            }
        });
        jTextFieldPorMatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPorMatriculaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPorMatriculaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldPorMatriculaKeyTyped(evt);
            }
        });

        jTextFieldPorNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPorNombreActionPerformed(evt);
            }
        });
        jTextFieldPorNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPorNombreKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPorNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldPorNombreKeyTyped(evt);
            }
        });

        jTextFieldPorApellido.setNextFocusableComponent(jTextFieldPorMatricula);
        jTextFieldPorApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPorApellidoActionPerformed(evt);
            }
        });
        jTextFieldPorApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPorApellidoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPorApellidoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldPorApellidoKeyTyped(evt);
            }
        });

        jLabelPorMatriula.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelPorMatriula.setText("Matricula:");

        jLabelPorNombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelPorNombre.setText("Nombre:");

        jLabelPorApellido.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelPorApellido.setText("Apellido:");

        jTableBusquedaUser.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTableBusquedaUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableBusquedaUser.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableBusquedaUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableBusquedaUserMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTableBusquedaUserMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(jTableBusquedaUser);

        btnfaltas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnfaltas.setText("Faltas");

        btncalificaciones.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btncalificaciones.setText("Calificaiones");
        btncalificaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncalificacionesActionPerformed(evt);
            }
        });

        btnhorario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnhorario.setText("Horario");

        btnmaterias.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnmaterias.setText("Materias");

        btnCancelarLimpiar.setText("Cancelar");
        btnCancelarLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarLimpiarActionPerformed(evt);
            }
        });

        jComboBoxPorCarrera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxPorCarreraMouseClicked(evt);
            }
        });
        jComboBoxPorCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPorCarreraActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Carrera:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Grupo:");

        jComboBoxPorGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPorGrupoActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Semestre:");

        jComboBoxPorSemestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPorSemestreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBusquedaLayout = new javax.swing.GroupLayout(jPanelBusqueda);
        jPanelBusqueda.setLayout(jPanelBusquedaLayout);
        jPanelBusquedaLayout.setHorizontalGroup(
            jPanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBusquedaLayout.createSequentialGroup()
                        .addGroup(jPanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelPorNombre)
                            .addComponent(jLabelPorMatriula)
                            .addComponent(jLabelPorApellido)
                            .addComponent(jLabel22)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelBusquedaLayout.createSequentialGroup()
                                .addGroup(jPanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jComboBoxTipoUser, 0, 130, Short.MAX_VALUE)
                                        .addComponent(jTextFieldPorMatricula))
                                    .addComponent(jTextFieldPorApellido)
                                    .addComponent(jTextFieldPorNombre))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelarLimpiar))
                            .addGroup(jPanelBusquedaLayout.createSequentialGroup()
                                .addComponent(jComboBoxPorCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxPorSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxPorGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBusquedaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btncalificaciones)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnhorario, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnfaltas, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnmaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelBusquedaLayout.setVerticalGroup(
            jPanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBusquedaLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jComboBoxTipoUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxPorCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jComboBoxPorSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxPorGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPorMatriula)
                    .addComponent(jTextFieldPorMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPorNombre)
                    .addComponent(jTextFieldPorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPorApellido)
                    .addComponent(jTextFieldPorApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarLimpiar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncalificaciones)
                    .addComponent(btnhorario)
                    .addComponent(btnfaltas)
                    .addComponent(btnmaterias))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelMatriculaEmp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelMatriculaEmp.setText("Matricula:");

        jTextFieldMatricula.setNextFocusableComponent(jTextFieldNombre);
        jTextFieldMatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldMatriculaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldMatriculaKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Nombre:");

        jTextFieldNombre.setNextFocusableComponent(jTextFieldApellidoPaterno);
        jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreActionPerformed(evt);
            }
        });
        jTextFieldNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNombreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNombreKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Apellido paterno:");

        jTextFieldApellidoPaterno.setNextFocusableComponent(jTextFieldApellidoMaterno);
        jTextFieldApellidoPaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldApellidoPaternoActionPerformed(evt);
            }
        });
        jTextFieldApellidoPaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldApellidoPaternoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldApellidoPaternoKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Apellido materno:");

        jTextFieldApellidoMaterno.setNextFocusableComponent(jTextFieldCalle);
        jTextFieldApellidoMaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldApellidoMaternoActionPerformed(evt);
            }
        });
        jTextFieldApellidoMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldApellidoMaternoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldApellidoMaternoKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Calle:");

        jTextFieldCalle.setNextFocusableComponent(jTextFieldColonia);
        jTextFieldCalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCalleActionPerformed(evt);
            }
        });
        jTextFieldCalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldCalleKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCalleKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Colonia:");

        jTextFieldColonia.setNextFocusableComponent(jTextFieldNumero);
        jTextFieldColonia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldColoniaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldColoniaKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Numero:");

        jTextFieldNumero.setNextFocusableComponent(jTextFieldTelCasaLada);
        jTextFieldNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNumeroKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNumeroKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Telefono casa:");

        jTextFieldTelCasaLada.setNextFocusableComponent(jTextFieldTelMovill);
        jTextFieldTelCasaLada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldTelCasaLadaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTelCasaLadaKeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Telefono celular:");

        jTextFieldTelMovill.setNextFocusableComponent(jTextFieldCorreoPersonal);
        jTextFieldTelMovill.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldTelMovillKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTelMovillKeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Correo Institucional:");

        jTextFieldCorreoInstitucional.setNextFocusableComponent(jTextFieldCorreoPersonal);
        jTextFieldCorreoInstitucional.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldCorreoInstitucionalKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCorreoInstitucionalKeyTyped(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Correo Personal:");

        jTextFieldCorreoPersonal.setNextFocusableComponent(jTextFieldContrasena);
        jTextFieldCorreoPersonal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldCorreoPersonalKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCorreoPersonalKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Contraseña:");

        jTextFieldContrasena.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldContrasenaFocusGained(evt);
            }
        });
        jTextFieldContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldContrasenaActionPerformed(evt);
            }
        });
        jTextFieldContrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldContrasenaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldContrasenaKeyTyped(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Grupo:");

        jComboBoxGrupo.setNextFocusableComponent(jComboBoxGrupo);
        jComboBoxGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxGrupoActionPerformed(evt);
            }
        });
        jComboBoxGrupo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxGrupoKeyPressed(evt);
            }
        });

        btnhecho.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnhecho.setText("Listo");
        btnhecho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnhechoMouseEntered(evt);
            }
        });
        btnhecho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhechoActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnNuevo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btneditar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btneditar.setText("Editar");
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });

        btneliminar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btneliminar.setText("Eliminar");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Usuario:");

        jComboBoxUsuarioNuevo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "ADMINISTRADOR", "PROFESOR", "ALUMNO" }));
        jComboBoxUsuarioNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxUsuarioNuevoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Carrera:");

        jComboBoxCarrera.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxCarreraItemStateChanged(evt);
            }
        });
        jComboBoxCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCarreraActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Semestre:");

        jComboBoxSemestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSemestreActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
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
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel14)
                                                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                                                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelMatriculaEmp, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxUsuarioNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jComboBoxGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jComboBoxSemestre, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jComboBoxCarrera, javax.swing.GroupLayout.Alignment.LEADING, 0, 110, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnhecho, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 10, Short.MAX_VALUE))
                            .addComponent(jTextFieldNombre)
                            .addComponent(jTextFieldApellidoPaterno)
                            .addComponent(jTextFieldApellidoMaterno)
                            .addComponent(jTextFieldCalle)
                            .addComponent(jTextFieldColonia)
                            .addComponent(jTextFieldTelCasaLada)
                            .addComponent(jTextFieldTelMovill)
                            .addComponent(jTextFieldCorreoInstitucional)
                            .addComponent(jTextFieldCorreoPersonal)
                            .addComponent(jTextFieldContrasena)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btneditar)
                    .addComponent(btneliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxUsuarioNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMatriculaEmp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldColonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextFieldTelCasaLada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextFieldTelMovill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextFieldCorreoInstitucional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextFieldCorreoPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextFieldContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnhecho))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jComboBoxSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jComboBoxGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labuser, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelMatriculaEmpTop)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btncerrar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(componenteAyuda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labuser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelMatriculaEmpTop))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btncerrar)
                        .addComponent(componenteAyuda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("ghf");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldPorApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPorApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPorApellidoActionPerformed

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreActionPerformed

    private void jTextFieldNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNombreKeyPressed

        if(evt.getKeyCode() == 10){
            jTextFieldApellidoPaterno.requestFocusInWindow();
            
        }
        
    }//GEN-LAST:event_jTextFieldNombreKeyPressed

    private void jTextFieldApellidoPaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldApellidoPaternoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextFieldApellidoPaternoActionPerformed

    private void jTextFieldApellidoMaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldApellidoMaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldApellidoMaternoActionPerformed

    private void jTextFieldCalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCalleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCalleActionPerformed

    private void jTextFieldApellidoPaternoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldApellidoPaternoKeyPressed
        if(evt.getKeyCode()==10){
            jTextFieldApellidoMaterno.requestFocusInWindow();
        }
    }//GEN-LAST:event_jTextFieldApellidoPaternoKeyPressed

    private void jTextFieldCalleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCalleKeyTyped
        // TODO add your handling code here:
        if(jTextFieldCalle.getText().length() == 50){
            evt.consume();
        }
        
    }//GEN-LAST:event_jTextFieldCalleKeyTyped

    private void jTextFieldCalleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCalleKeyPressed
        if(evt.getKeyCode()==10){
            jTextFieldColonia.requestFocusInWindow();
        }
    }//GEN-LAST:event_jTextFieldCalleKeyPressed

    private void jTextFieldApellidoMaternoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldApellidoMaternoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10){
            jTextFieldCalle.requestFocusInWindow();
        }
    }//GEN-LAST:event_jTextFieldApellidoMaternoKeyPressed

    private void jTextFieldPorMatriculaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPorMatriculaKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10){
            jTextFieldPorNombre.requestFocusInWindow();
        }
    }//GEN-LAST:event_jTextFieldPorMatriculaKeyPressed

    private void jTextFieldPorNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPorNombreKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10){
            jTextFieldPorApellido.requestFocusInWindow();
        }
    }//GEN-LAST:event_jTextFieldPorNombreKeyPressed

    private void jTextFieldPorApellidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPorApellidoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10){
            jTextFieldPorMatricula.requestFocusInWindow();
        }
    }//GEN-LAST:event_jTextFieldPorApellidoKeyPressed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        /*Prueba*/
        jComboBoxTipoUser.setEnabled(false);
        disablejComboBoxBusqueda();
        llenarTableBorrar("", "", "Borrar");
        jTextFieldPorMatricula.setText("");
        jTextFieldPorNombre.setText("");
        jTextFieldPorApellido.setText("");
        jComboBoxTipoUser.setSelectedIndex(0);
        //Termina prueba
        Limpiar();
        jComboBoxUsuarioNuevo.setSelectedIndex(0);
        btneditar.setEnabled(false);
        btneliminar.setEnabled(false);
        btnCancelar.setEnabled(true);  
        jComboBoxUsuarioNuevo.setEnabled(true);
        jComboBoxUsuarioNuevo.requestFocusInWindow();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        flagEditar = false;
        int mensajeConfirmacion;
        mensajeConfirmacion = JOptionPane.showConfirmDialog(null, "¿Esta seguro de cancelar?", "Confirmación", 
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (mensajeConfirmacion == JOptionPane.NO_OPTION) {
            System.out.println("No button clicked");
        } else if (mensajeConfirmacion == JOptionPane.YES_OPTION) {
            //flagEditar = false;
            System.out.println("Yes button clicked");
            Limpiar();
            Deshabilitar();
            //descoloriarCorreo();
            jComboBoxTipoUser.setSelectedIndex(0);
            jTextFieldMatricula.setText("");
            btnCancelar.setEnabled(false);
            btnhecho.setEnabled(false);
            jTextFieldPorMatricula.requestFocusInWindow();
            jComboBoxUsuarioNuevo.setSelectedIndex(0);
            jComboBoxUsuarioNuevo.setEnabled(false);
            //jComboBoxgrupo.setSelectedIndex(0);
            //jComboBoxCarrera.setSelectedIndex(0);
            jComboBoxUsuarioNuevo.setEnabled(false);
            jComboBoxTipoUser.setEnabled(true);
            //btneditar.setEnabled(true);
            //btneliminar.setEnabled(true);
                    
        } else if (mensajeConfirmacion == JOptionPane.CLOSED_OPTION) {
            System.out.println("JOptionPane closed");
        }        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btncerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncerrarActionPerformed
        // TODO add your handling code here:           
        int mensajeConfirmacion;
        mensajeConfirmacion = JOptionPane.showConfirmDialog(null, "¿Esta seguro de cerrar sesión?", "Confirmación", 
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (mensajeConfirmacion == JOptionPane.NO_OPTION) {
            System.out.println("No button clicked");
        } else if (mensajeConfirmacion == JOptionPane.YES_OPTION) {
            this.dispose();
            Login login = new Login();       
            login.setVisible(true);
        } else if (mensajeConfirmacion == JOptionPane.CLOSED_OPTION) {
            System.out.println("JOptionPane closed");
        }
    }//GEN-LAST:event_btncerrarActionPerformed

    public void btnListoActualizar(){
        Limpiar();
        Deshabilitar();
        btnhecho.setEnabled(false);
        btnCancelar.setEnabled(false);
        jComboBoxUsuarioNuevo.setSelectedIndex(0);
        jComboBoxUsuarioNuevo.setEnabled(false);
        jComboBoxTipoUser.setEnabled(true);
        jComboBoxTipoUser.setSelectedIndex(0);
        btneditar.setEnabled(false);
        btneliminar.setEnabled(false);
    }
    private void btnhechoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhechoActionPerformed
        // TODO add your handling code here:
        
        guardarTextFildVar();  
        if(jComboBoxUsuarioNuevo.getSelectedItem().equals("ADMINISTRADOR")){
            guardarTextFildVar();
            String sQl = null;
            sQl = "insert into administrador values (?,?,?,?,?,?,?,?,?,?,?,?)";
            OracleBD OracleConnection = new OracleBD();
            try{
                OracleConnection.conectar();
                Connection conn = OracleConnection.getConnection();
                PreparedStatement pst = conn.prepareStatement(sQl);// Envia la sentencia SQL en la variavle sSQL ha SQL para ejecutar acciones en la base de datos.
                pst.setString(1,matricula);// Con el metodo setString se envian los valores a la base de datos colocando primero la pocicion del dato y luego la variable que contiene este mismo.
                pst.setString(2,nombre);
                pst.setString(3,apPaterno);
                pst.setString(4,apMaterno);
                pst.setString(5,telMovil);
                pst.setString(6,telCasa);
                pst.setString(7,calle);
                pst.setString(8,colonia);
                pst.setInt(9,numero);
                pst.setString(10,corrPers);
                pst.setString(11,corrInst);
                pst.setString(12,contrasena);
                int n = pst.executeUpdate();
                if(n>0){
                    JOptionPane.showMessageDialog(null, "Datos ingresados satifactoriamente");
                    btnListoActualizar();
                }
                pst.close();
                OracleConnection.cerrar();
            }catch(Exception ex){
                System.out.println("Error: " + ex.getMessage());
            }
        }
        else if(jComboBoxUsuarioNuevo.getSelectedItem().equals("PROFESOR")){
            guardarTextFildVar();
            String sQl = null;
            sQl = "insert into profesor values (?,?,?,?,?,?,?,?,?,?,?,?)";
            OracleBD OracleConnection = new OracleBD();
            try{
                OracleConnection.conectar();
                Connection conn = OracleConnection.getConnection();
                PreparedStatement pst = conn.prepareStatement(sQl);// Envia la sentencia SQL en la variavle sSQL ha SQL para ejecutar acciones en la base de datos.
                pst.setString(1,matricula);// Con el metodo setString se envian los valores a la base de datos colocando primero la pocicion del dato y luego la variable que contiene este mismo.
                pst.setString(2,nombre);
                pst.setString(3,apPaterno);
                pst.setString(4,apMaterno);
                pst.setString(5,telMovil);
                pst.setString(6,telCasa);
                pst.setString(7,calle);
                pst.setString(8,colonia);
                pst.setInt(9,numero);
                pst.setString(10,corrPers);
                pst.setString(11,corrInst);
                pst.setString(12,contrasena);
                int n = pst.executeUpdate();
                if(n>0){
                    JOptionPane.showMessageDialog(null, "Datos ingresados satifactoriamente");
                    btnListoActualizar();
                }    
                pst.close();
                OracleConnection.cerrar();
            }catch(Exception ex){
                System.out.println("Error: " + ex.getMessage());
            }
        }
        else if(jComboBoxUsuarioNuevo.getSelectedItem().equals("ALUMNO")){
            guardarTextFildVar();
            String pIdKardex = null;
            String nombreGrupo = (String) jComboBoxGrupo.getSelectedItem();
            grupo = encontrarGrupo(nombreGrupo);
            String sQl = null;
            sQl = "insert into alumno values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            OracleBD OracleConnection = new OracleBD();
            try{
                OracleConnection.conectar();
                Connection conn = OracleConnection.getConnection();
                PreparedStatement pst = conn.prepareStatement(sQl);// Envia la sentencia SQL en la variavle sSQL ha SQL para ejecutar acciones en la base de datos.
                pst.setString(1,matricula);// Con el metodo setString se envian los valores a la base de datos colocando primero la pocicion del dato y luego la variable que contiene este mismo.
                pst.setString(2,nombre);
                pst.setString(3,apPaterno);
                pst.setString(4,apMaterno);
                pst.setString(5,telMovil);
                pst.setString(6,telCasa);
                pst.setString(7,calle);
                pst.setString(8,colonia);
                pst.setInt(9,numero);
                pst.setString(10,corrPers);
                pst.setString(11,corrInst);
                pst.setString(12,contrasena);
                pst.setString(13,carrera);
                pst.setString(14,grupo);
                int n = pst.executeUpdate();
                if(n>0){
                    Statement stmt = conn.createStatement();
                    ResultSet rset = stmt.executeQuery("SELECT FUN_OBTENER_IDKARDEX('"+jTextFieldMatricula.getText()+"') AS IDKARDEX FROM DUAL");
                    while(rset.next()){
                        pIdKardex = rset.getString("IDKARDEX");
                        System.out.println(pIdKardex);
                    }
                    String sem = (String) jComboBoxSemestre.getSelectedItem();
                    //Connection conn2 = OracleConnection.getConnection();
                    CallableStatement cst = conn.prepareCall("CALL PRO_CAMBIAR_CURSANDO('"+pIdKardex+"', '"+sem+"')");
                    cst.execute();
                    JOptionPane.showMessageDialog(null, "Datos ingresados satifactoriamente");
                    btnListoActualizar();
                }   
                pst.close();
                OracleConnection.cerrar();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnhechoActionPerformed

    private void jTextFieldContrasenaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldContrasenaFocusGained
        // TODO add your handling code here:
        btnhecho.setEnabled(true);
    }//GEN-LAST:event_jTextFieldContrasenaFocusGained

    private void jTextFieldNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNumeroKeyTyped

        char caracter = evt.getKeyChar();
            if(((caracter < '0') || (caracter > '9')) &&(caracter != KeyEvent.VK_BACK_SPACE) || jTextFieldNumero.getText().length() == 4){
                evt.consume();
            }               
    }//GEN-LAST:event_jTextFieldNumeroKeyTyped

    private void jTextFieldColoniaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldColoniaKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10 || evt.getKeyCode()==9){
            jTextFieldNumero.requestFocusInWindow();
        }
    }//GEN-LAST:event_jTextFieldColoniaKeyPressed

    private void jTextFieldNumeroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNumeroKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10 || evt.getKeyCode()==9){
            jTextFieldTelCasaLada.requestFocusInWindow();
        }
    }//GEN-LAST:event_jTextFieldNumeroKeyPressed

    private void jTextFieldTelCasaLadaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTelCasaLadaKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10 || evt.getKeyCode()==9){
            jTextFieldTelMovill.requestFocusInWindow();
        }
    }//GEN-LAST:event_jTextFieldTelCasaLadaKeyPressed

    private void jTextFieldTelMovillKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTelMovillKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10 || evt.getKeyCode()==9){
            jTextFieldCorreoPersonal.requestFocusInWindow();
        }
    }//GEN-LAST:event_jTextFieldTelMovillKeyPressed

    private void jTextFieldCorreoInstitucionalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCorreoInstitucionalKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10 || evt.getKeyCode()==9){
            jTextFieldCorreoPersonal.requestFocusInWindow();
        }
    }//GEN-LAST:event_jTextFieldCorreoInstitucionalKeyPressed

    private void jTextFieldCorreoPersonalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCorreoPersonalKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10 || evt.getKeyCode()==9){
            jTextFieldContrasena.requestFocusInWindow();
        }
    }//GEN-LAST:event_jTextFieldCorreoPersonalKeyPressed

    private void jTextFieldContrasenaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldContrasenaKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10 || evt.getKeyCode()==9){
            jComboBoxCarrera.requestFocusInWindow();
        }
    }//GEN-LAST:event_jTextFieldContrasenaKeyPressed

    private void jTextFieldContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldContrasenaActionPerformed

    private void jComboBoxGrupoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxGrupoKeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode()==10 || evt.getKeyCode()==9){
            btnhecho.requestFocusInWindow();
        }
    }//GEN-LAST:event_jComboBoxGrupoKeyPressed

    private void jTextFieldNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNombreKeyTyped
        // TODO add your handling code here:
        if(jTextFieldNombre.getText().length() == 50){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldNombreKeyTyped

    private void jTextFieldMatriculaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldMatriculaKeyTyped
        // TODO add your handling code here:
        if(jTextFieldMatricula.getText().length() == 7){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldMatriculaKeyTyped

    private void jTextFieldApellidoPaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldApellidoPaternoKeyTyped
        // TODO add your handling code here:
        if(jTextFieldApellidoPaterno.getText().length() == 50){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldApellidoPaternoKeyTyped

    private void jTextFieldApellidoMaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldApellidoMaternoKeyTyped
        // TODO add your handling code here:
        if(jTextFieldApellidoMaterno.getText().length() == 50){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldApellidoMaternoKeyTyped

    private void jTextFieldColoniaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldColoniaKeyTyped
        // TODO add your handling code here:
        if(jTextFieldColonia.getText().length() == 50){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldColoniaKeyTyped

    private void jTextFieldTelCasaLadaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTelCasaLadaKeyTyped
        // TODO add your handling code here:
        if(jTextFieldTelCasaLada.getText().length() == 15){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldTelCasaLadaKeyTyped

    private void jTextFieldTelMovillKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTelMovillKeyTyped
        // TODO add your handling code here:
        if(jTextFieldTelMovill.getText().length() == 15){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldTelMovillKeyTyped

    private void jTextFieldCorreoInstitucionalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCorreoInstitucionalKeyTyped
        // TODO add your handling code here:
        Pattern plantilla = null;
        Matcher resultado = null;
        Matcher matchArroba = null;
        Pattern arroba  = null;
        arroba = Pattern.compile("@");
        plantilla = Pattern.compile("[a-zA-Z0-9]+[a-zA-Z0-9_-]*@[a-zA-Z]+\\p{Punct}[a-zA-Z]+");
        resultado = plantilla.matcher(jTextFieldCorreoInstitucional.getText());
        if (resultado.find() == true){  
            jTextFieldCorreoInstitucional.setBorder(BorderFactory.createLineBorder(Color.green));
        }else{
            jTextFieldCorreoInstitucional.setBorder(BorderFactory.createLineBorder(Color.yellow));
        }  
        if(jTextFieldCorreoInstitucional.getText().length() == 50){     
            evt.consume();        
        }        
            
        
        
        
    }//GEN-LAST:event_jTextFieldCorreoInstitucionalKeyTyped

    private void jTextFieldCorreoPersonalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCorreoPersonalKeyTyped
        // TODO add your handling code here:   
        Pattern plantilla = null;
        Matcher resultado = null;
        Matcher matchArroba = null;
        Pattern arroba  = null;
        arroba = Pattern.compile("@");
        plantilla = Pattern.compile("[a-zA-Z0-9]+[a-zA-Z0-9_-]*@[a-zA-Z]+\\p{Punct}[a-zA-Z]+");
        resultado = plantilla.matcher(jTextFieldCorreoPersonal.getText());
        if (resultado.find() == true){  
            jTextFieldCorreoPersonal.setBorder(BorderFactory.createLineBorder(Color.green));
        }else{
            jTextFieldCorreoPersonal.setBorder(BorderFactory.createLineBorder(Color.yellow));
        }
        
        if(jTextFieldCorreoPersonal.getText().length() == 50){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldCorreoPersonalKeyTyped

    private void jTextFieldContrasenaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldContrasenaKeyTyped
        // TODO add your handling code here:
        if(jTextFieldContrasena.getText().length() == 30){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldContrasenaKeyTyped

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        // TODO add your handling code here:
          if(jTextFieldMatricula.getText().length() == 50){
            evt.consume();
        }
    }//GEN-LAST:event_formKeyTyped

    private void jTextFieldMatriculaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldMatriculaKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == 10){
            jTextFieldNombre.requestFocusInWindow();
            
        }
    }//GEN-LAST:event_jTextFieldMatriculaKeyPressed

    public void llenarTableBorrar(String tabla, String user, String movimiento){
        DefaultTableModel modelo = new DefaultTableModel();        
        if(tabla.equals("ADMINISTRADOR")||tabla.equals("PROFESOR")){
            modelo.addColumn("Empleado");
            
        }else{
            modelo.addColumn("Matricula");
        }        
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido Paterno");
        modelo.addColumn("Apellido Materno");
        jTableBusquedaUser.setModel(modelo);
        OracleBD OracleConnection = new OracleBD();
        if(movimiento.equals("Llenar")){
            try {
            OracleConnection.conectar();
            Connection conn = OracleConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("SELECT "+user+", nombre, apellidoPaterno,"
                    + "apellidoMaterno from "+tabla+" WHERE ROWNUM <=50 ORDER BY "+user);  
            while(rset.next()){
                System.out.println(rset.getString(2));
                Object[] fila = new Object[4];
                       for (int i = 0; i <= 3; i++){
                           fila[i]=rset.getObject(i+1);                           
                       }
                       modelo.addRow(fila);
            }
            stmt.close();
            OracleConnection.cerrar();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }else{
            for (int i = 0; i < jTableBusquedaUser.getRowCount(); i++) {
                modelo.removeRow(i);
                i-=1;
            }
        }
        
        
    }
    private void jComboBoxTipoUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoUserActionPerformed

        btnCancelarLimpiar.setEnabled(true);
        String tipoUser;
        tipoUser = (String) jComboBoxTipoUser.getSelectedItem();
        if(tipoUser.equals("ADMINISTRADOR")){  
            Limpiar();
            Deshabilitar();
            llenarTableBorrar(tipoUser, "matriculaAdm", "Llenar");
            jLabelPorMatriula.setText("Empleado");
            jTextFieldPorMatricula.setText("ADM");
            enablejComboBoxBusqueda();
            disablejComboBoxBusqueda();
            enableBusqueda();
            disableButtons();
        }else if(tipoUser.equals("PROFESOR")){
            Limpiar();
            Deshabilitar();
            llenarTableBorrar(tipoUser, "matriculaPr", "Llenar");
            jTextFieldPorMatricula.setText("PR");
            jLabelPorMatriula.setText("Empleado");
            disablejComboBoxBusqueda();
            enableBusqueda();
            disableButtons();
            btnhorario.setEnabled(true);
            btnmaterias.setEnabled(true);
        }else if(tipoUser.equals("ALUMNO")){
            Limpiar();
            Deshabilitar();
            llenarTableBorrar(tipoUser , "matriculaAl", "Llenar");
            jTextFieldPorMatricula.setText("AL");
            enableBusqueda();
            enablejComboBoxBusqueda();
            jLabelPorMatriula.setText("Matricula");
            enableButtons();
        }else if(tipoUser.equals("")){
            Limpiar();
            Deshabilitar();
            //jComboBoxTipoUser.setEnabled(true);
            llenarTableBorrar("", "", "Borrar");
            jLabelMatriculaEmp.setText("Matricula");
            jTextFieldPorMatricula.setText("");
            disableBusqueda();
            disableButtons();
            jComboBoxPorCarrera.setEnabled(false);
            jComboBoxPorGrupo.setEnabled(false);
            jComboBoxPorSemestre.setEnabled(false);
            //jTableBusquedaUser.setEnabled(false);
            btnCancelarLimpiar.setEnabled(false);
            
            
        }
    }//GEN-LAST:event_jComboBoxTipoUserActionPerformed

    private void jComboBoxUsuarioNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxUsuarioNuevoActionPerformed
        // TODO add your handling code here:
        String matricula = null;
        String tipoUser;
        tipoUser = (String) jComboBoxUsuarioNuevo.getSelectedItem();
        jTextFieldNombre.requestFocusInWindow();
        if(tipoUser.equals("ADMINISTRADOR")){
            OracleBD OracleConnection = new OracleBD();
            try {
                OracleConnection.conectar();
                Connection conn = OracleConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rset = stmt.executeQuery("SELECT FUN_GENERA_MT('ADMINISTRADOR') AS MATRICULA FROM DUAL");
                while(rset.next()){
                    matricula = rset.getString("MATRICULA");
                }
                jTextFieldMatricula.setText(matricula);
                System.out.println("Matricula: " + matricula);
                stmt.close();
                OracleConnection.cerrar();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
            
            Habilitar();
            jTextFieldCorreoInstitucional.setEnabled(false);
            jTextFieldMatricula.setEnabled(false);
            jLabelMatriculaEmp.setText("Empleado");
            jComboBoxGrupo.setEnabled(false);
            jComboBoxSemestre.setEnabled(false);
            jComboBoxCarrera.setEnabled(false);
            jTextFieldCorreoInstitucional.setText("");
        }else if(tipoUser.equals("PROFESOR")){  
            OracleBD OracleConnection = new OracleBD();
            try {
                OracleConnection.conectar();
                Connection conn = OracleConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rset = stmt.executeQuery("SELECT FUN_GENERA_MT('PROFESOR') AS MATRICULA FROM DUAL");
                while(rset.next()){
                    matricula = rset.getString("MATRICULA");
                }
                jTextFieldMatricula.setText(matricula);
                System.out.println("Matricula: " + matricula);
                stmt.close();
                OracleConnection.cerrar();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
            Habilitar();
            jTextFieldCorreoInstitucional.setEnabled(false);
            jTextFieldMatricula.setEnabled(false);
            jLabelMatriculaEmp.setText("Empleado");
            //jTextFieldMatricula.setText("PR");
            jComboBoxGrupo.setEnabled(false);
            jComboBoxCarrera.setEnabled(false);
            jComboBoxSemestre.setEnabled(false);
            //jComboBoxTipoUser.setEnabled(false);
        }else if(tipoUser.equals("ALUMNO")){
            jComboBoxSemestre.setEnabled(false);
            OracleBD OracleConnection = new OracleBD();
            try {
                OracleConnection.conectar();
                Connection conn = OracleConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rset = stmt.executeQuery("SELECT FUN_GENERA_MT('ALUMNO') AS MATRICULA FROM DUAL");
                while(rset.next()){
                    matricula = rset.getString("MATRICULA");
                }
                jTextFieldMatricula.setText(matricula);
                System.out.println("Matricula: " + matricula);
                stmt.close();
                OracleConnection.cerrar();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
            Habilitar();
            jTextFieldCorreoInstitucional.setEnabled(false);
            jTextFieldMatricula.setEnabled(false);
            jLabelMatriculaEmp.setText("Matricula");
 
        }else if(tipoUser.equals("")){
            Deshabilitar();
            jComboBoxUsuarioNuevo.setEnabled(true);
        }
    }//GEN-LAST:event_jComboBoxUsuarioNuevoActionPerformed

    private void jTextFieldPorMatriculaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPorMatriculaKeyTyped
        // TODO add your handling code here:
        jTextFieldPorNombre.setText("");
        jTextFieldPorApellido.setText("");
        if(jTextFieldPorMatricula.getText().length() == 7){
            evt.consume();
        }
        
    }//GEN-LAST:event_jTextFieldPorMatriculaKeyTyped

    private void jTextFieldPorNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPorNombreKeyTyped
        // TODO add your handling code here:          
        

        
    }//GEN-LAST:event_jTextFieldPorNombreKeyTyped

    private void jTextFieldPorApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPorApellidoKeyTyped
        // TODO add your handling code here:
        jTextFieldPorNombre.setText("");
        jTextFieldPorMatricula.setText("");
        if(jTextFieldPorApellido.getText().length() == 50){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldPorApellidoKeyTyped

    private void btnCancelarLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarLimpiarActionPerformed
        // TODO add your handling code here:  
        disablejComboBoxBusqueda();
        llenarTableBorrar("", "", "Borrar");
        jTextFieldPorMatricula.setText("");
        jTextFieldPorNombre.setText("");
        jTextFieldPorApellido.setText("");
        jComboBoxTipoUser.setSelectedIndex(0);
    }//GEN-LAST:event_btnCancelarLimpiarActionPerformed

    private void jComboBoxCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCarreraActionPerformed

        String idCarrera = (String) jComboBoxCarrera.getSelectedItem();
        jComboBoxSemestre.removeAllItems();
        OracleBD OracleConnection = new OracleBD();
        try{
                    OracleConnection.conectar();
                    Connection conn = OracleConnection.getConnection();
                    Statement s1 = conn.createStatement();
                    ResultSet rs1 = s1.executeQuery ("select distinct semestre from materia where idCarrera ='"+idCarrera+"' order by semestre");
                    while(rs1.next()){                           
                            jComboBoxSemestre.addItem(rs1.getString("semestre"));                                               
                    } 
                }catch(Exception ex){
                    System.out.println("Error: " + ex.getMessage());
                }
    }//GEN-LAST:event_jComboBoxCarreraActionPerformed

    private void jTextFieldPorNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPorNombreKeyReleased
        // TODO add your handling code here:
        jTextFieldPorMatricula.setText("");
        jTextFieldPorApellido.setText("");
        if(jTextFieldPorNombre.getText().length() == 50){
            evt.consume();
        }
        String tipoUser = (String) jComboBoxTipoUser.getSelectedItem();
        String nombre = jTextFieldPorNombre.getText().toUpperCase();
        if(tipoUser.equals("ADMINISTRADOR")){
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Empleado");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido Paterno");
            modelo.addColumn("Apellido Materno");
            jTableBusquedaUser.setModel(modelo);
            OracleBD OracleConnection = new OracleBD();
            try {
                OracleConnection.conectar();
                Connection conn = OracleConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rset = stmt.executeQuery("SELECT matriculaAdm, nombre, apellidoPaterno,"
                + "apellidoMaterno from Administrador WHERE nombre like '%"+nombre+"%'" );  
                while(rset.next()){
                    System.out.println(rset.getString(2));
                    Object[] fila = new Object[4];
                    for (int i = 0; i <= 3; i++){
                        fila[i]=rset.getObject(i+1);
                    }
                modelo.addRow(fila);
            }
            stmt.close();
            OracleConnection.cerrar();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }   
        }else if(tipoUser.equals("PROFESOR")){
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Empleado");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido Paterno");
            modelo.addColumn("Apellido Materno");
            jTableBusquedaUser.setModel(modelo);
            OracleBD OracleConnection = new OracleBD();
            try {
                OracleConnection.conectar();
                Connection conn = OracleConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rset = stmt.executeQuery("SELECT matriculaPr, nombre, apellidoPaterno,"
                + "apellidoMaterno from Profesor WHERE nombre like '%"+nombre+"%'" );  
                while(rset.next()){
                    System.out.println(rset.getString(2));
                    Object[] fila = new Object[4];
                    for (int i = 0; i <= 3; i++){
                        fila[i]=rset.getObject(i+1);
                    }
                modelo.addRow(fila);
            }
            stmt.close();
            OracleConnection.cerrar();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            } 
            
        }else if(tipoUser.equals("ALUMNO")){
            String carreraBusqueda = (String) jComboBoxPorCarrera.getSelectedItem();
            String semestreBusqueda = (String) jComboBoxPorSemestre.getSelectedItem();
            String grupoBusqueda = (String) jComboBoxPorGrupo.getSelectedItem();
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Matricula");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido Paterno");
            modelo.addColumn("Apellido Materno");
            jTableBusquedaUser.setModel(modelo);
            OracleBD OracleConnection = new OracleBD();
            try {
                OracleConnection.conectar();
                Connection conn = OracleConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rset = stmt.executeQuery("SELECT Alumno.matriculaAl, Alumno.nombre, Alumno.apellidoPaterno,"
                    + "Alumno.apellidoMaterno from Alumno JOIN Grupo USING(idGrupo) "
                    + "WHERE Grupo.idCarrera = '"+carreraBusqueda+"' "
                    + "AND Grupo.semestre = "+semestreBusqueda+" AND Grupo.nombre = '"+grupoBusqueda+"' "
                    + "AND Alumno.nombre like '%"+nombre+"%'" );  
                while(rset.next()){
                    System.out.println(rset.getString(2));
                    Object[] fila = new Object[4];
                       for (int i = 0; i <= 3; i++){
                           fila[i]=rset.getObject(i+1);
                       }
                       modelo.addRow(fila);
                }
                stmt.close();
                OracleConnection.cerrar();
                } catch (SQLException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }            
        }


    }//GEN-LAST:event_jTextFieldPorNombreKeyReleased

    private void jComboBoxPorCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPorCarreraActionPerformed
        // TODO add your handling code here:
        String idCarrera = (String) jComboBoxPorCarrera.getSelectedItem();
        jComboBoxPorSemestre.removeAllItems();
        OracleBD OracleConnection = new OracleBD();
        try{
                    OracleConnection.conectar();
                    Connection conn = OracleConnection.getConnection();
                    Statement s1 = conn.createStatement();
                    ResultSet rs1 = s1.executeQuery ("select distinct semestre from materia where idCarrera ='"+idCarrera+"' order by semestre");
                    while(rs1.next()){
                        jComboBoxPorSemestre.addItem(rs1.getString("semestre"));
                    } 
                }catch(Exception ex){
                    System.out.println("Error: " + ex.getMessage());
                }
        

        
    }//GEN-LAST:event_jComboBoxPorCarreraActionPerformed

    private void jComboBoxGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxGrupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxGrupoActionPerformed

    private void jComboBoxSemestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSemestreActionPerformed
        // TODO add your handling code here:
        if(jComboBoxSemestre.getItemCount()!=0){
            String idCarrera = (String) jComboBoxCarrera.getSelectedItem();
            String semestre = (String) jComboBoxSemestre.getSelectedItem();
            jComboBoxGrupo.removeAllItems();
            OracleBD OracleConnection = new OracleBD();
            try{
                    OracleConnection.conectar();
                    Connection conn = OracleConnection.getConnection();
                    Statement stmt1 = conn.createStatement();
                    ResultSet rest1 = stmt1.executeQuery ("SELECT nombre from Grupo WHERE idCarrera = '"+idCarrera+"' AND Semestre = '"+semestre+"'");
                    while(rest1.next()){
                        jComboBoxGrupo.addItem(rest1.getString("nombre"));
                    } 
                    rest1.close();
                    OracleConnection.cerrar();
            }catch(Exception ex){
                    System.out.println("Error: " + ex.getMessage());
           }     
        }
        
        
    }//GEN-LAST:event_jComboBoxSemestreActionPerformed

    private void jComboBoxPorSemestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPorSemestreActionPerformed
        // TODO add your handling code here: 
       if(jComboBoxPorSemestre.getItemCount()!=0){
            String idCarrera = (String) jComboBoxPorCarrera.getSelectedItem();
            String semestre = (String) jComboBoxPorSemestre.getSelectedItem();
            jComboBoxPorGrupo.removeAllItems();
            OracleBD OracleConnection = new OracleBD();
            try{
                    OracleConnection.conectar();
                    Connection conn = OracleConnection.getConnection();
                    Statement stmt1 = conn.createStatement();
                    ResultSet rest1 = stmt1.executeQuery ("SELECT nombre from Grupo WHERE idCarrera = '"+idCarrera+"' AND Semestre = '"+semestre+"'");
                    while(rest1.next()){
                        jComboBoxPorGrupo.addItem(rest1.getString("nombre"));
                    } 
                    rest1.close();
                    OracleConnection.cerrar();
            }catch(Exception ex){
                    System.out.println("Error: " + ex.getMessage());
           }     
        }
        
    }//GEN-LAST:event_jComboBoxPorSemestreActionPerformed

    private void jComboBoxPorGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPorGrupoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBoxPorGrupoActionPerformed

    private void btncalificacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalificacionesActionPerformed
        // TODO add your handling code here:
        Calificaciones pantCalif = new Calificaciones("Administrador", matriculaSeleccionTabla);
        pantCalif.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        //this.setEnabled(false);
        pantCalif.setVisible(true);
        //pantCalif.setAlwaysOnTop(true);
    }//GEN-LAST:event_btncalificacionesActionPerformed

    private void jTextFieldPorMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPorMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPorMatriculaActionPerformed

    private void jTextFieldPorMatriculaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPorMatriculaKeyReleased
        // TODO add your handling code here:
        String jComboTipoUser = null;
        String matriculaBusqueda = null;
        String carreraBusqueda = null;
        String semestreBusqueda = null;
        String grupoBusqueda = null;
        jComboTipoUser = (String) jComboBoxTipoUser.getSelectedItem();
        if(jComboTipoUser.equals("ADMINISTRADOR")){
            //Busqueda de administradro 
            matriculaBusqueda = jTextFieldPorMatricula.getText().toUpperCase();
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Empleado");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido Paterno");
            modelo.addColumn("Apellido Materno");
            jTableBusquedaUser.setModel(modelo);
            OracleBD OracleConnection = new OracleBD();
            try {
                OracleConnection.conectar();
                Connection conn = OracleConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rset = stmt.executeQuery("SELECT matriculaAdm, nombre, apellidoPaterno,"
                    + "apellidoMaterno from Administrador WHERE matriculaAdm like '%"+matriculaBusqueda+"%'" );  
                while(rset.next()){
                    System.out.println(rset.getString(2));
                    Object[] fila = new Object[4];
                       for (int i = 0; i <= 3; i++){
                           fila[i]=rset.getObject(i+1);
                       }
                       modelo.addRow(fila);
                }
                stmt.close();
                OracleConnection.cerrar();
                } catch (SQLException ex) {
                    System.out.println("Error: " + ex.getMessage());
        }
            
        }else if(jComboTipoUser.equals("PROFESOR")){
            //Busqueda de profesor
            matriculaBusqueda = jTextFieldPorMatricula.getText().toUpperCase();            
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Empleado");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido Paterno");
            modelo.addColumn("Apellido Materno");
            jTableBusquedaUser.setModel(modelo);
            OracleBD OracleConnection = new OracleBD();
            try {
                OracleConnection.conectar();
                Connection conn = OracleConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rset = stmt.executeQuery("SELECT matriculaPr, nombre, apellidoPaterno,"
                    + "apellidoMaterno from Profesor WHERE matriculaPr like '%"+matriculaBusqueda+"%'" );  
                while(rset.next()){
                    System.out.println(rset.getString(2));
                    Object[] fila = new Object[4];
                       for (int i = 0; i <= 3; i++){
                           fila[i]=rset.getObject(i+1);
                       }
                       modelo.addRow(fila);
                }
                stmt.close();
                OracleConnection.cerrar();
                } catch (SQLException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            
        }else if(jComboTipoUser.equals("ALUMNO")){
            //Busdqueda de alumno 
            matriculaBusqueda = jTextFieldPorMatricula.getText().toUpperCase();
            carreraBusqueda = (String) jComboBoxPorCarrera.getSelectedItem();
            semestreBusqueda = (String) jComboBoxPorSemestre.getSelectedItem();
            grupoBusqueda = (String) jComboBoxPorGrupo.getSelectedItem();
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Matricula");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido Paterno");
            modelo.addColumn("Apellido Materno");
            jTableBusquedaUser.setModel(modelo);
            OracleBD OracleConnection = new OracleBD();
            try {
                OracleConnection.conectar();
                Connection conn = OracleConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rset = stmt.executeQuery("SELECT Alumno.matriculaAl, Alumno.nombre, Alumno.apellidoPaterno,"
                    + "Alumno.apellidoMaterno from Alumno JOIN Grupo USING(idGrupo) "
                    + "WHERE Grupo.idCarrera = '"+carreraBusqueda+"' "
                    + "AND Grupo.semestre = "+semestreBusqueda+" AND Grupo.nombre = '"+grupoBusqueda+"' "
                    + "AND Alumno.matriculaAl like '%"+matriculaBusqueda+"%'" );  
                while(rset.next()){
                    System.out.println(rset.getString(2));
                    Object[] fila = new Object[4];
                       for (int i = 0; i <= 3; i++){
                           fila[i]=rset.getObject(i+1);
                       }
                       modelo.addRow(fila);
                }
                stmt.close();
                OracleConnection.cerrar();
                } catch (SQLException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }            
        }
    }//GEN-LAST:event_jTextFieldPorMatriculaKeyReleased

    private void jTextFieldPorNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPorNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPorNombreActionPerformed

    private void jTextFieldPorApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPorApellidoKeyReleased
        // TODO add your handling code here:
        String tipoUser = (String) jComboBoxTipoUser.getSelectedItem();
        String apellido = jTextFieldPorApellido.getText().toUpperCase();
        if(tipoUser.equals("ADMINISTRADOR")){
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Empleado");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido Paterno");
            modelo.addColumn("Apellido Materno");
            jTableBusquedaUser.setModel(modelo);
            OracleBD OracleConnection = new OracleBD();
            try {
                OracleConnection.conectar();
                Connection conn = OracleConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rset = stmt.executeQuery("SELECT matriculaAdm, nombre, apellidoPaterno,"
                + "apellidoMaterno from Administrador WHERE apellidoPaterno||' '||apellidoMaterno"
                + " like '%"+apellido+"%'" );  
                while(rset.next()){
                    System.out.println(rset.getString(2));
                    Object[] fila = new Object[4];
                    for (int i = 0; i <= 3; i++){
                        fila[i]=rset.getObject(i+1);
                    }
                modelo.addRow(fila);
            }
            stmt.close();
            OracleConnection.cerrar();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }   
        }else if(tipoUser.equals("PROFESOR")){
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Empleado");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido Paterno");
            modelo.addColumn("Apellido Materno");
            jTableBusquedaUser.setModel(modelo);
            OracleBD OracleConnection = new OracleBD();
            try {
                OracleConnection.conectar();
                Connection conn = OracleConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rset = stmt.executeQuery("SELECT matriculaPr, nombre, apellidoPaterno,"
                + "apellidoMaterno from Profesor WHERE apellidoPaterno||' '||apellidoMaterno like '%"+apellido+"%'" );  
                while(rset.next()){
                    System.out.println(rset.getString(2));
                    Object[] fila = new Object[4];
                    for (int i = 0; i <= 3; i++){
                        fila[i]=rset.getObject(i+1);
                    }
                modelo.addRow(fila);
            }
            stmt.close();
            OracleConnection.cerrar();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            } 
            
        }else if(tipoUser.equals("ALUMNO")){
            String carreraBusqueda = (String) jComboBoxPorCarrera.getSelectedItem();
            String semestreBusqueda = (String) jComboBoxPorSemestre.getSelectedItem();
            String grupoBusqueda = (String) jComboBoxPorGrupo.getSelectedItem();
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Matricula");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido Paterno");
            modelo.addColumn("Apellido Materno");
            jTableBusquedaUser.setModel(modelo);
            OracleBD OracleConnection = new OracleBD();
            try {
                OracleConnection.conectar();
                Connection conn = OracleConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rset = stmt.executeQuery("SELECT Alumno.matriculaAl, Alumno.nombre, Alumno.apellidoPaterno,"
                    + "Alumno.apellidoMaterno from Alumno JOIN Grupo USING(idGrupo) "
                    + "WHERE Grupo.idCarrera = '"+carreraBusqueda+"' "
                    + "AND Grupo.semestre = "+semestreBusqueda+" AND Grupo.nombre = '"+grupoBusqueda+"' "
                    + "AND Alumno.apellidoPaterno||' '||Alumno.apellidoMaterno like '%"+apellido+"%'" );  
                while(rset.next()){
                    System.out.println(rset.getString(2));
                    Object[] fila = new Object[4];
                       for (int i = 0; i <= 3; i++){
                           fila[i]=rset.getObject(i+1);
                       }
                       modelo.addRow(fila);
                }
                stmt.close();
                OracleConnection.cerrar();
                } catch (SQLException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }            
        }
        
    }//GEN-LAST:event_jTextFieldPorApellidoKeyReleased
    public String matriculaSeleccionTabla = null;    
    private void jTableBusquedaUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableBusquedaUserMouseClicked
        // TODO add your handling code here:
        
        jComboBoxCarrera.setEnabled(false);
        jComboBoxSemestre.setEnabled(false);
        jComboBoxGrupo.setEnabled(false);
        btneditar.setEnabled(true);
        btneliminar.setEnabled(true);
        btnCancelar.setEnabled(false);
        int row = jTableBusquedaUser.getSelectedRow();
        matriculaSeleccionTabla = jTableBusquedaUser.getValueAt(row, 0).toString();
        //System.out.println(matriculaSeleccionTabla);
       //Empieza a llenar campos 
        
        String tipoUserLlenar = (String) jComboBoxTipoUser.getSelectedItem();
        String matricula = null, nombre = null, apellidoPaterno = null, correoPersonal = null, apellidoMaterno = null, calle = null, colonia = null,
               numero = null, telefonoMovil = null, telefonoCasa = null, correoPersonall = null, correoInstitucional = null, contrasena = null, 
               carrera = null, semestre = null, grupo = null;
        if(tipoUserLlenar.equals("ADMINISTRADOR")){
            jComboBoxUsuarioNuevo.setSelectedIndex(1);
            Deshabilitar();
            OracleBD OracleConnection = new OracleBD();
            try {
                OracleConnection.conectar();
                Connection conn = OracleConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rset = stmt.executeQuery("SELECT matriculaAdm, nombre, apellidoPaterno,"
                + "apellidoMaterno, calle, colonia, numero, telefonoMovil, telefonoCasa"
                + ", correoPersonal, correoInstitucional, contrasena "
                + "from Administrador WHERE matriculaAdm = '"+matriculaSeleccionTabla+"'");                 
                while(rset.next()){
                    matricula = rset.getString("matriculaAdm");
                    nombre = rset.getString("nombre");
                    apellidoPaterno = rset.getString("apellidoPaterno");
                    apellidoMaterno = rset.getString("apellidoMaterno");
                    calle = rset.getString("calle");
                    colonia = rset.getString("colonia");
                    numero = rset.getString("numero");
                    telefonoMovil = rset.getString("telefonoMovil");
                    telefonoCasa = rset.getString("telefonoCasa");
                    correoPersonall = rset.getString("correoPersonal");
                    correoInstitucional = rset.getString("correoInstitucional");
                    contrasena = rset.getString("contrasena");                
                }
                jTextFieldMatricula.setText(matricula);
                jTextFieldNombre.setText(nombre);
                jTextFieldApellidoPaterno.setText(apellidoPaterno);
                jTextFieldApellidoMaterno.setText(apellidoMaterno);
                jTextFieldCalle.setText(calle);
                jTextFieldColonia.setText(colonia);
                jTextFieldNumero.setText(numero);
                jTextFieldTelMovill.setText(telefonoMovil);
                jTextFieldTelCasaLada.setText(telefonoCasa);
                jTextFieldCorreoPersonal.setText(correoPersonall);
                jTextFieldCorreoInstitucional.setText(correoInstitucional);
                jTextFieldContrasena.setText(contrasena);
                OracleConnection.cerrar();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
            
        }else if(tipoUserLlenar.equals("PROFESOR")){
            jComboBoxUsuarioNuevo.setSelectedIndex(2);
            Deshabilitar();
            OracleBD OracleConnection = new OracleBD();
            try {
                OracleConnection.conectar();
                Connection conn = OracleConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rset = stmt.executeQuery("SELECT matriculaPR, nombre, apellidoPaterno,"
                + "apellidoMaterno, calle, colonia, numero, telefonoMovil, telefonoCasa"
                + ", correoPersonal, correoInstitucional, contrasena "
                + "from Profesor WHERE matriculaPr = '"+matriculaSeleccionTabla+"'");                 
                while(rset.next()){
                    matricula = rset.getString("matriculaPr");
                    nombre = rset.getString("nombre");
                    apellidoPaterno = rset.getString("apellidoPaterno");
                    apellidoMaterno = rset.getString("apellidoMaterno");
                    calle = rset.getString("calle");
                    colonia = rset.getString("colonia");
                    numero = rset.getString("numero");
                    telefonoMovil = rset.getString("telefonoMovil");
                    telefonoCasa = rset.getString("telefonoCasa");
                    correoPersonall = rset.getString("correoPersonal");
                    correoInstitucional = rset.getString("correoInstitucional");
                    contrasena = rset.getString("contrasena");                
                }
                jTextFieldMatricula.setText(matricula);
                jTextFieldNombre.setText(nombre);
                jTextFieldApellidoPaterno.setText(apellidoPaterno);
                jTextFieldApellidoMaterno.setText(apellidoMaterno);
                jTextFieldCalle.setText(calle);
                jTextFieldColonia.setText(colonia);
                jTextFieldNumero.setText(numero);
                jTextFieldTelMovill.setText(telefonoMovil);
                jTextFieldTelCasaLada.setText(telefonoCasa);
                jTextFieldCorreoPersonal.setText(correoPersonall);
                jTextFieldCorreoInstitucional.setText(correoInstitucional);
                jTextFieldContrasena.setText(contrasena);
                OracleConnection.cerrar();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
            
        }else if(tipoUserLlenar.equals("ALUMNO")){
            jComboBoxCarrera.setEnabled(false);
            jComboBoxSemestre.setEnabled(false);
            jComboBoxGrupo.setEnabled(false);
            jComboBoxUsuarioNuevo.setSelectedIndex(3);
            Deshabilitar();
            OracleBD OracleConnection = new OracleBD();
            try {
                OracleConnection.conectar();
                Connection conn = OracleConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rset = stmt.executeQuery("SELECT A.matriculaAl, A.nombre, A.apellidoPaterno,"
                + "A.apellidoMaterno, A.calle, A.colonia, A.numero, A.telefonoMovil, A.telefonoCasa"
                + ", A.correoPersonal, A.correoInstitucional, A.contrasena, A.idCarrera, Grupo.nombre AS nombreGrupo, Grupo.semestre "
                + "from Alumno A join Grupo using(idGrupo) WHERE matriculaAl = '"+matriculaSeleccionTabla+"'");                 
                while(rset.next()){
                    matricula = rset.getString("matriculaAl");
                    nombre = rset.getString("nombre");
                    apellidoPaterno = rset.getString("apellidoPaterno");
                    apellidoMaterno = rset.getString("apellidoMaterno");
                    calle = rset.getString("calle");
                    colonia = rset.getString("colonia");
                    numero = rset.getString("numero");
                    telefonoMovil = rset.getString("telefonoMovil");
                    telefonoCasa = rset.getString("telefonoCasa");
                    correoPersonall = rset.getString("correoPersonal");
                    correoInstitucional = rset.getString("correoInstitucional");
                    contrasena = rset.getString("contrasena");   
                    carrera = rset.getString("idCarrera");
                    semestre = rset.getString("semestre");
                    grupo = rset.getString("nombreGrupo");
                }
                jTextFieldMatricula.setText(matricula);
                jTextFieldNombre.setText(nombre);
                jTextFieldApellidoPaterno.setText(apellidoPaterno);
                jTextFieldApellidoMaterno.setText(apellidoMaterno);
                jTextFieldCalle.setText(calle);
                jTextFieldColonia.setText(colonia);
                jTextFieldNumero.setText(numero);
                jTextFieldTelMovill.setText(telefonoMovil);
                jTextFieldTelCasaLada.setText(telefonoCasa);
                jTextFieldCorreoPersonal.setText(correoPersonall);
                jTextFieldCorreoInstitucional.setText(correoInstitucional);
                jTextFieldContrasena.setText(contrasena);
                jComboBoxCarrera.setSelectedItem(carrera);
                jComboBoxSemestre.setSelectedItem(semestre);
                jComboBoxGrupo.setSelectedItem(grupo);
                OracleConnection.cerrar();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
            
        }
        
        
        
    }//GEN-LAST:event_jTableBusquedaUserMouseClicked

    private void jComboBoxPorCarreraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxPorCarreraMouseClicked
        // TODO add your handling code here:
              
        
    }//GEN-LAST:event_jComboBoxPorCarreraMouseClicked

    private void jTableBusquedaUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableBusquedaUserMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableBusquedaUserMouseEntered

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        // TODO add your handling code here:
        flagEditar = true;
        String tipoUser = (String) jComboBoxTipoUser.getSelectedItem();
        if(tipoUser.equals("ALUMNO")){
            Habilitar();
            btnhecho.setEnabled(false);
            btnActualizar.setEnabled(true);
            btnCancelar.setEnabled(true);
            jTextFieldCorreoInstitucional.setEnabled(false);
            jComboBoxGrupo.setEnabled(true);
            jComboBoxSemestre.setEnabled(true);
            }else{
            Habilitar();
            btnActualizar.setEnabled(true);
            btnCancelar.setEnabled(true);
            jTextFieldCorreoInstitucional.setEnabled(false);
            jComboBoxCarrera.setEnabled(false);
        }
        
        
         
       
    }//GEN-LAST:event_btneditarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        flagEditar = false;
        String tipoUser = (String) jComboBoxTipoUser.getSelectedItem();
        String matriculaUpdate = jTextFieldMatricula.getText();
        //Inicia actualización 
        
        if(tipoUser.equals("ADMINISTRADOR")){
            guardarTextFildVar();
            String sQl = null;
            sQl = "UPDATE Administrador "
                    + "SET matriculaAdm = ?,"
                    + "nombre = ?,"
                    + "apellidoPaterno = ?,"
                    + "apellidoMaterno = ?,"
                    + "telefonoMovil = ?,"
                    + "telefonoCasa = ?,"
                    + "calle = ?,"
                    + "colonia = ?,"
                    + "numero = ?,"
                    + "correoPersonal = ?,"
                    + "correoInstitucional = ?,"
                    + "contrasena = ? "
                    + "WHERE matriculaAdm = '"+matriculaUpdate+"'";
            OracleBD OracleConnection = new OracleBD();
            try{
                OracleConnection.conectar();
                Connection conn = OracleConnection.getConnection();
                PreparedStatement pst = conn.prepareStatement(sQl);// Envia la sentencia SQL en la variavle sSQL ha SQL para ejecutar acciones en la base de datos.
                pst.setString(1,matricula);// Con el metodo setString se envian los valores a la base de datos colocando primero la pocicion del dato y luego la variable que contiene este mismo.
                pst.setString(2,nombre);
                pst.setString(3,apPaterno);
                pst.setString(4,apMaterno);
                pst.setString(5,telMovil);
                pst.setString(6,telCasa);
                pst.setString(7,calle);
                pst.setString(8,colonia);
                pst.setInt(9,numero);
                pst.setString(10,corrPers);
                pst.setString(11,corrInst);
                pst.setString(12,contrasena);
                int n = pst.executeUpdate();
                if(n>0){
                    JOptionPane.showMessageDialog(null, "Datos actualizados satifactoriamente");
                    btnListoActualizar();
                }
                pst.close();
                OracleConnection.cerrar();
            }catch(Exception ex){
                System.out.println("Error: " + ex.getMessage());
            }
            
        }else if(tipoUser.equals("PROFESOR")){
            guardarTextFildVar();
            String sQl = null;
            sQl = "UPDATE Profesor "
                    + "SET matriculaPr = ?,"
                    + "nombre = ?,"
                    + "apellidoPaterno = ?,"
                    + "apellidoMaterno = ?,"
                    + "telefonoMovil = ?,"
                    + "telefonoCasa = ?,"
                    + "calle = ?,"
                    + "colonia = ?,"
                    + "numero = ?,"
                    + "correoPersonal = ?,"
                    + "correoInstitucional = ?,"
                    + "contrasena = ? "
                    + "WHERE matriculaPr = '"+matriculaUpdate+"'";
            OracleBD OracleConnection = new OracleBD();
            try{
                OracleConnection.conectar();
                Connection conn = OracleConnection.getConnection();
                PreparedStatement pst = conn.prepareStatement(sQl);// Envia la sentencia SQL en la variavle sSQL ha SQL para ejecutar acciones en la base de datos.
                pst.setString(1,matricula);// Con el metodo setString se envian los valores a la base de datos colocando primero la pocicion del dato y luego la variable que contiene este mismo.
                pst.setString(2,nombre);
                pst.setString(3,apPaterno);
                pst.setString(4,apMaterno);
                pst.setString(5,telMovil);
                pst.setString(6,telCasa);
                pst.setString(7,calle);
                pst.setString(8,colonia);
                pst.setInt(9,numero);
                pst.setString(10,corrPers);
                pst.setString(11,corrInst);
                pst.setString(12,contrasena);
                int n = pst.executeUpdate();
                if(n>0){
                    JOptionPane.showMessageDialog(null, "Datos actualizados satifactoriamente");
                    btnListoActualizar();
                }
                pst.close();
                OracleConnection.cerrar();
            }catch(Exception ex){
                System.out.println("Error: " + ex.getMessage());
            }
            
        }else if(tipoUser.equals("ALUMNO")){
            String carraraUpdate2 = (String) jComboBoxCarrera.getSelectedItem();
            guardarTextFildVar();
            String sQl = null;
            sQl = "UPDATE Alumno "
                    + "SET matriculaAl = ?,"
                    + "nombre = ?,"
                    + "apellidoPaterno = ?,"
                    + "apellidoMaterno = ?,"
                    + "telefonoMovil = ?,"
                    + "telefonoCasa = ?,"
                    + "calle = ?,"
                    + "colonia = ?,"
                    + "numero = ?,"
                    + "correoPersonal = ?,"
                    + "correoInstitucional = ?,"
                    + "contrasena = ?,"
                    + "idCarrera = ?"
                    + "WHERE matriculaAl = '"+matriculaUpdate+"'";
            OracleBD OracleConnection = new OracleBD();
            try{
                OracleConnection.conectar();
                Connection conn = OracleConnection.getConnection();
                PreparedStatement pst = conn.prepareStatement(sQl);// Envia la sentencia SQL en la variavle sSQL ha SQL para ejecutar acciones en la base de datos.
                pst.setString(1,matricula);// Con el metodo setString se envian los valores a la base de datos colocando primero la pocicion del dato y luego la variable que contiene este mismo.
                pst.setString(2,nombre);
                pst.setString(3,apPaterno);
                pst.setString(4,apMaterno);
                pst.setString(5,telMovil);
                pst.setString(6,telCasa);
                pst.setString(7,calle);
                pst.setString(8,colonia);
                pst.setInt(9,numero);
                pst.setString(10,corrPers);
                pst.setString(11,corrInst);
                pst.setString(12,contrasena);
                pst.setString(13,carraraUpdate2);
                int n = pst.executeUpdate();
                if(n>0){
                    JOptionPane.showMessageDialog(null, "Datos actualizados satifactoriamente");
                    btnListoActualizar();
                }
                pst.close();
                OracleConnection.cerrar();
            }catch(Exception ex){
                System.out.println("Error: " + ex.getMessage());
            }         
        }
        
        //Termina actualización
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void jComboBoxCarreraItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxCarreraItemStateChanged
        //System.out.println("Cambio");
        String matriculaAlm = jTextFieldMatricula.getText();
        String carreraActual = null;
            OracleBD OracleConnection = new OracleBD();
            try {
                OracleConnection.conectar();
                Connection conn = OracleConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rset = stmt.executeQuery("SELECT idCarrera FROM Alumno WHERE matriculaAL = '"+matriculaAlm+"'");
                while(rset.next()){
                    carreraActual = rset.getString("idCarrera");
                } 
                stmt.close();
                OracleConnection.cerrar();                
            } catch (SQLException ex) {
                System.out.println("Error: " +ex.getMessage());
            }
            String carreraComparar = (String) jComboBoxCarrera.getSelectedItem();
            //Saver si el usuario cambio de carrera 
            //System.out.println("CarreraCompar: " + carreraComparar);
            //System.out.println("CarreraActual: "+ carreraActual);
            
            
            if(!carreraComparar.equals(carreraActual) && flagEditar == true){
                jComboBoxSemestre.setEnabled(false);
                jComboBoxGrupo.setEnabled(false);  
            }else if(carreraComparar.equals(carreraActual) && flagEditar == true){
                jComboBoxSemestre.setEnabled(true);
                jComboBoxGrupo.setEnabled(true);
            }
    }//GEN-LAST:event_jComboBoxCarreraItemStateChanged

    private void btnhechoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhechoMouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnhechoMouseEntered

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
            java.util.logging.Logger.getLogger(PantallaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new PantallaAdministrador().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelarLimpiar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btncalificaciones;
    private javax.swing.JButton btncerrar;
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnfaltas;
    private javax.swing.JButton btnhecho;
    private javax.swing.JButton btnhorario;
    private javax.swing.JButton btnmaterias;
    private Aplicacion.ComponenteAyuda componenteAyuda1;
    private javax.swing.JComboBox jComboBoxCarrera;
    private javax.swing.JComboBox jComboBoxGrupo;
    private javax.swing.JComboBox jComboBoxPorCarrera;
    private javax.swing.JComboBox jComboBoxPorGrupo;
    private javax.swing.JComboBox jComboBoxPorSemestre;
    private javax.swing.JComboBox jComboBoxSemestre;
    private javax.swing.JComboBox jComboBoxTipoUser;
    private javax.swing.JComboBox jComboBoxUsuarioNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelMatriculaEmp;
    private javax.swing.JLabel jLabelMatriculaEmpTop;
    private javax.swing.JLabel jLabelPorApellido;
    private javax.swing.JLabel jLabelPorMatriula;
    private javax.swing.JLabel jLabelPorNombre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelBusqueda;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableBusquedaUser;
    private javax.swing.JTextField jTextFieldApellidoMaterno;
    private javax.swing.JTextField jTextFieldApellidoPaterno;
    private javax.swing.JTextField jTextFieldCalle;
    private javax.swing.JTextField jTextFieldColonia;
    private javax.swing.JTextField jTextFieldContrasena;
    private javax.swing.JTextField jTextFieldCorreoInstitucional;
    private javax.swing.JTextField jTextFieldCorreoPersonal;
    private javax.swing.JTextField jTextFieldMatricula;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldNumero;
    private javax.swing.JTextField jTextFieldPorApellido;
    private javax.swing.JTextField jTextFieldPorMatricula;
    private javax.swing.JTextField jTextFieldPorNombre;
    private javax.swing.JTextField jTextFieldTelCasaLada;
    private javax.swing.JTextField jTextFieldTelMovill;
    private javax.swing.JLabel labuser;
    // End of variables declaration//GEN-END:variables


    /*private void buscarNombre(String buscar) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Empleado");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido Paterno");
        modelo.addColumn("Apellido Materno");
        jTableBusquedaUser.setModel(modelo);
        OracleBD OracleConnection = new OracleBD();
        try {
            OracleConnection.conectar();
            Connection conn = OracleConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("SELECT matriculaPr, nombre, apellidoPaterno,"
                    + "apellidoMaterno from Profesor WHERE nombre like '%"+buscar+"%'" );  
            while(rset.next()){
                System.out.println(rset.getString(2));
                Object[] fila = new Object[4];
                       for (int i = 0; i <= 3; i++){
                           fila[i]=rset.getObject(i+1);
                       }
                       modelo.addRow(fila);
            }
            stmt.close();
            OracleConnection.cerrar();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        
    }*/

    private void llenarjComboBoxPorCarrera() {
        //jComboBoxPorCarrera.removeAllItems();
        OracleBD OracleConnection = new OracleBD();
        try{
                    OracleConnection.conectar();
                    Connection conn = OracleConnection.getConnection();
                    Statement stms = conn.createStatement();
                    ResultSet rest = stms.executeQuery ("SELECT idCarrera FROM CARRERA");
                    while(rest.next()){
                        jComboBoxPorCarrera.addItem(rest.getString("idCarrera"));
                    } 
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private String encontrarGrupo(String PNombreGrupo) {
        String idGrupo = null;
        OracleBD OracleConnection = new OracleBD();
        try{
            OracleConnection.conectar();
            Connection conn = OracleConnection.getConnection();
            Statement stms = conn.createStatement();
            ResultSet rest = stms.executeQuery ("SELECT idGrupo FROM Grupo where nombre ='"+PNombreGrupo+"'");
            while(rest.next()){
                idGrupo = rest.getString("idGrupo");
            } 
            //System.out.println("idGrupo: " + idGrupo);
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
     return idGrupo;
    }

    private int FunComparar(String carreraComparar, String carreraActual) {
        if(carreraComparar == carreraActual){
            return 1;
        }else{
            return 0;
        }
        
    }
}
