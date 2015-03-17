package Aplicacion;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
public final class Admin_Menu extends javax.swing.JFrame {
    String nombre, apPaterno, apMaterno, calle, colonia, telCasa, telMovil, corrInst, corrPers,
           contrasena;
    int numero;
    int cont = 0; //contador para validar caracteres ingresados 
    
    
    public void guardarTextFildVar(){
        nombre = jTextFieldNombre.getText();
        apPaterno = jTextFieldApellidoPaterno.getText();
        apMaterno = jTextFieldApellidoMaterno.getText();
        calle = jTextFieldCalle.getText();
        colonia = jTextFieldColonia.getText();
        telCasa = jTextFieldTelCasa.getText();
        telMovil = jTextFieldTelMovill.getText();
        corrInst = jTextFieldCorreoInstitucional.getText();
        corrPers = jTextFieldCorreoPersonal.getText();
        contrasena = jTextFieldContrasena.getText();
        numero = Integer.parseInt(jTextFieldNumero.getText());        
    }
    
    //Funcion para deshabilitar jTextField
    public void Deshabilitar(){
        jTextFieldMatricula.setEnabled(false);
        jTextFieldNombre.setEnabled(false);
        jTextFieldApellidoPaterno.setEnabled(false);
        jTextFieldApellidoMaterno.setEnabled(false);
        jTextFieldCalle.setEnabled(false);
        jTextFieldColonia.setEnabled(false);
        jTextFieldNumero.setEnabled(false);
        jTextFieldTelCasa.setEnabled(false);
        jTextFieldTelMovill.setEnabled(false);
        jTextFieldCorreoInstitucional.setEnabled(false);
        jTextFieldCorreoPersonal.setEnabled(false);
        jTextFieldContrasena.setEnabled(false);
        jComboBoxsemestre.setEnabled(false);
        jComboBoxgrupo.setEnabled(false);
        
    }
    public void Habilitar(){
            jTextFieldMatricula.setEnabled(true);
            jTextFieldNombre.setEnabled(true);
            jTextFieldApellidoPaterno.setEnabled(true);
            jTextFieldApellidoMaterno.setEnabled(true);
            jTextFieldCalle.setEnabled(true);
            jTextFieldColonia.setEnabled(true);
            jTextFieldNumero.setEnabled(true);
            jTextFieldTelCasa.setEnabled(true);
            jTextFieldTelMovill.setEnabled(true);
            jTextFieldCorreoInstitucional.setEnabled(true);
            jTextFieldCorreoPersonal.setEnabled(true);
            jTextFieldContrasena.setEnabled(true);
            jComboBoxsemestre.setEnabled(true);
            jComboBoxgrupo.setEnabled(true);        
    }
    public void Limpiar(){
        jTextFieldMatricula.setText("");
        jTextFieldNombre.setText("");
        jTextFieldApellidoPaterno.setText("");
        jTextFieldApellidoMaterno.setText("");
        jTextFieldCalle.setText("");
        jTextFieldColonia.setText("");
        jTextFieldNumero.setText("");
        jTextFieldTelCasa.setText("");
        jTextFieldTelMovill.setText("");
        jTextFieldCorreoInstitucional.setText("");
        jTextFieldCorreoPersonal.setText("");
        jTextFieldContrasena.setText("");
        /*jComboBoxsemestre.(true);
        jComboBoxgrupo.setEnabled(true);*/        
    }

    public Admin_Menu() {
        initComponents();
        jTextFieldPorMatricula.requestFocusInWindow();
        jTableBusquedaUser.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnhecho.setEnabled(false);
        Deshabilitar();        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldPorMatricula = new javax.swing.JTextField();
        jTextFieldPorNombre = new javax.swing.JTextField();
        jTextFieldPorApellido = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBusquedaUser = new javax.swing.JTable();
        labuser = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnhecho = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldApellidoPaterno = new javax.swing.JTextField();
        jTextFieldApellidoMaterno = new javax.swing.JTextField();
        jTextFieldCalle = new javax.swing.JTextField();
        jTextFieldTelCasa = new javax.swing.JTextField();
        jTextFieldTelMovill = new javax.swing.JTextField();
        jTextFieldCorreoInstitucional = new javax.swing.JTextField();
        jTextFieldContrasena = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jComboBoxsemestre = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jComboBoxgrupo = new javax.swing.JComboBox();
        btnfaltas = new javax.swing.JButton();
        btncalificaciones = new javax.swing.JButton();
        btnhorario = new javax.swing.JButton();
        btnmaterias = new javax.swing.JButton();
        btncerrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldColonia = new javax.swing.JTextField();
        jTextFieldNumero = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldCorreoPersonal = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextFieldMatricula = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrador");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Busqueda Usuario:");

        jTextFieldPorMatricula.setText(" ");
        jTextFieldPorMatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPorMatriculaKeyPressed(evt);
            }
        });

        jTextFieldPorNombre.setText(" ");
        jTextFieldPorNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPorNombreKeyPressed(evt);
            }
        });

        jTextFieldPorApellido.setText(" ");
        jTextFieldPorApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPorApellidoActionPerformed(evt);
            }
        });
        jTextFieldPorApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPorApellidoKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Por Matricula");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Por Nombre");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Por Apellido");

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
        ));
        jScrollPane1.setViewportView(jTableBusquedaUser);

        labuser.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labuser.setText("Nombre_user");

        btnNuevo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btneditar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btneditar.setText("Editar");

        btneliminar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btneliminar.setText("Eliminar");

        btnhecho.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnhecho.setText("Hecho");
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

        jTextFieldNombre.setText(" ");
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

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Nombre:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Apellido paterno:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Apellido materno:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Calle:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Telefono casa:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Telefono celular:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Contraseña:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Correo Institucional:");

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

        jTextFieldApellidoMaterno.setText(" ");
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

        jTextFieldCalle.setText(" ");
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

        jTextFieldTelCasa.setText(" ");
        jTextFieldTelCasa.setNextFocusableComponent(jTextFieldTelMovill);
        jTextFieldTelCasa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldTelCasaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTelCasaKeyTyped(evt);
            }
        });

        jTextFieldTelMovill.setText(" ");
        jTextFieldTelMovill.setNextFocusableComponent(jTextFieldCorreoInstitucional);
        jTextFieldTelMovill.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldTelMovillKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTelMovillKeyTyped(evt);
            }
        });

        jTextFieldCorreoInstitucional.setText(" ");
        jTextFieldCorreoInstitucional.setNextFocusableComponent(jTextFieldCorreoPersonal);
        jTextFieldCorreoInstitucional.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldCorreoInstitucionalKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCorreoInstitucionalKeyTyped(evt);
            }
        });

        jTextFieldContrasena.setText(" ");
        jTextFieldContrasena.setNextFocusableComponent(jComboBoxsemestre);
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

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Semestre");

        jComboBoxsemestre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxsemestre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxsemestreKeyPressed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Grupo:");

        jComboBoxgrupo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxgrupo.setNextFocusableComponent(jComboBoxgrupo);
        jComboBoxgrupo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxgrupoKeyPressed(evt);
            }
        });

        btnfaltas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnfaltas.setText("Faltas");

        btncalificaciones.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btncalificaciones.setText("Calificaiones");

        btnhorario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnhorario.setText("Ver horario");

        btnmaterias.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnmaterias.setText("Materias");

        btncerrar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btncerrar.setText("Cerrar Sesion");
        btncerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncerrarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Colonia: ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Numero: ");

        jTextFieldColonia.setNextFocusableComponent(jTextFieldNumero);
        jTextFieldColonia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldColoniaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldColoniaKeyTyped(evt);
            }
        });

        jTextFieldNumero.setNextFocusableComponent(jTextFieldTelCasa);
        jTextFieldNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNumeroKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNumeroKeyTyped(evt);
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

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Bienvenido:  ");

        jLabel19.setText("Matricula");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Matricula: ");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Matricula: ");

        jTextFieldMatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldMatriculaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btncalificaciones)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnhorario)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnfaltas, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnmaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jTextFieldPorMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldPorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addGap(12, 12, 12)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldPorApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(labuser, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(169, 169, 169)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btncerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnhecho, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel7)
                                                .addComponent(jLabel8))
                                            .addComponent(jLabel9))
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel21))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextFieldApellidoPaterno)
                                        .addComponent(jTextFieldNombre)
                                        .addComponent(jTextFieldCalle)
                                        .addComponent(jTextFieldColonia)
                                        .addComponent(jTextFieldApellidoMaterno, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                                        .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel14)
                                        .addComponent(jLabel17)
                                        .addComponent(jLabel13))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextFieldTelCasa)
                                        .addComponent(jTextFieldTelMovill)
                                        .addComponent(jTextFieldCorreoInstitucional)
                                        .addComponent(jTextFieldContrasena)
                                        .addComponent(jTextFieldCorreoPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel15)
                                        .addComponent(jLabel16))
                                    .addGap(14, 14, 14)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jComboBoxsemestre, 0, 225, Short.MAX_VALUE)
                                        .addComponent(jComboBoxgrupo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labuser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1)
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel21)
                                .addComponent(jTextFieldMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)))
                    .addComponent(btneliminar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNuevo)
                        .addComponent(btneditar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldPorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldPorApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldPorMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnhorario)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btncalificaciones)
                                .addComponent(btnfaltas)
                                .addComponent(btnmaterias))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextFieldApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTextFieldApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jTextFieldCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldColonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jTextFieldTelCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jTextFieldTelMovill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jTextFieldCorreoInstitucional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jTextFieldCorreoPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jTextFieldContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jComboBoxsemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jComboBoxgrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnhecho)
                            .addComponent(btnCancelar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btncerrar)))
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
         //jTextFieldNombre.transferFocus();
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
        //jTextFielCalle.transferFocus();
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
        // TODO add your handling code here:
        Habilitar();
        btnCancelar.setEnabled(true);        
        jTextFieldMatricula.requestFocusInWindow();
        //btnhecho.setEnabled(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        int mensajeConfirmacion;
        mensajeConfirmacion = JOptionPane.showConfirmDialog(null, "¿Esta seguro de cancelar?", "Confirmación", 
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        /*Limpiar();
        Deshabilitar();*/
        if (mensajeConfirmacion == JOptionPane.NO_OPTION) {
            System.out.println("No button clicked");
        } else if (mensajeConfirmacion == JOptionPane.YES_OPTION) {
            System.out.println("Yes button clicked");
            Limpiar();
            Deshabilitar();
            btnCancelar.setEnabled(false);
            btnhecho.setEnabled(false);
            jTextFieldPorMatricula.requestFocusInWindow();
        } else if (mensajeConfirmacion == JOptionPane.CLOSED_OPTION) {
            System.out.println("JOptionPane closed");
        }        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btncerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncerrarActionPerformed
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
    }//GEN-LAST:event_btncerrarActionPerformed

    private void btnhechoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhechoActionPerformed
        // TODO add your handling code here:
        guardarTextFildVar();   
    }//GEN-LAST:event_btnhechoActionPerformed

    private void jTextFieldContrasenaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldContrasenaFocusGained
        // TODO add your handling code here:
        btnhecho.setEnabled(true);
    }//GEN-LAST:event_jTextFieldContrasenaFocusGained

    private void jTextFieldNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNumeroKeyTyped
        // TODO add your handling code here:
        //System.out.println("Key: " + evt.getKeyChar());
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
            jTextFieldTelCasa.requestFocusInWindow();
        }
    }//GEN-LAST:event_jTextFieldNumeroKeyPressed

    private void jTextFieldTelCasaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTelCasaKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10 || evt.getKeyCode()==9){
            jTextFieldTelMovill.requestFocusInWindow();
        }
    }//GEN-LAST:event_jTextFieldTelCasaKeyPressed

    private void jTextFieldTelMovillKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTelMovillKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10 || evt.getKeyCode()==9){
            jTextFieldCorreoInstitucional.requestFocusInWindow();
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
            jComboBoxsemestre.requestFocusInWindow();
        }
    }//GEN-LAST:event_jTextFieldContrasenaKeyPressed

    private void jTextFieldContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldContrasenaActionPerformed

    private void jComboBoxsemestreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxsemestreKeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode()==10 || evt.getKeyCode()==9){
            jComboBoxgrupo.requestFocusInWindow();
        }
    }//GEN-LAST:event_jComboBoxsemestreKeyPressed

    private void jComboBoxgrupoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxgrupoKeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode()==10 || evt.getKeyCode()==9){
            btnhecho.requestFocusInWindow();
        }
    }//GEN-LAST:event_jComboBoxgrupoKeyPressed

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

    private void jTextFieldTelCasaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTelCasaKeyTyped
        // TODO add your handling code here:
        if(jTextFieldTelCasa.getText().length() == 15){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldTelCasaKeyTyped

    private void jTextFieldTelMovillKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTelMovillKeyTyped
        // TODO add your handling code here:
        if(jTextFieldTelMovill.getText().length() == 15){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldTelMovillKeyTyped

    private void jTextFieldCorreoInstitucionalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCorreoInstitucionalKeyTyped
        // TODO add your handling code here:
        if(jTextFieldCorreoInstitucional.getText().length() == 50){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldCorreoInstitucionalKeyTyped

    private void jTextFieldCorreoPersonalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCorreoPersonalKeyTyped
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(Admin_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Admin_Menu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btncalificaciones;
    private javax.swing.JButton btncerrar;
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnfaltas;
    private javax.swing.JButton btnhecho;
    private javax.swing.JButton btnhorario;
    private javax.swing.JButton btnmaterias;
    private javax.swing.JComboBox jComboBoxgrupo;
    private javax.swing.JComboBox jComboBoxsemestre;
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
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
    private javax.swing.JTextField jTextFieldTelCasa;
    private javax.swing.JTextField jTextFieldTelMovill;
    private javax.swing.JLabel labuser;
    // End of variables declaration//GEN-END:variables
}
