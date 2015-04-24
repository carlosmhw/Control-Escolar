package Aplicacion;
import Database.OracleBD;
import java.awt.Dialog;
import java.awt.Image;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
public class PantallaProfesor extends javax.swing.JFrame {

    public PantallaProfesor() {
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/aplicacion/image/icono.png"));
        setIconImage(icon);
    }
    
    String matricula, fecha;
    
    
    public DefaultTableModel modeloHorario = new DefaultTableModel(){

        @Override
        public boolean isCellEditable(int row, int column) {
           //all cells false
           return false;
        }
    };;
    
    
    
    
    public PantallaProfesor(String matriculaPR){
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/aplicacion/image/icono.png"));
        setIconImage(icon);
        //this.setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        jTableCalif.getTableHeader().setReorderingAllowed(false);
        jTableFaltas.getTableHeader().setReorderingAllowed(false);
        jTableHorario.getTableHeader().setReorderingAllowed(false);
        //setUpSportColumn(jTablePrueba, jTablePrueba.getColumnModel().getColumn(3));
        matricula=matriculaPR;
        labmatricula.setText(matriculaPR);
        OracleBD OracleConnection = new OracleBD();
       try {
            OracleConnection.conectar();
            Connection conn = OracleConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery ("SELECT * FROM Profesor WHERE matriculaPR = '"+matriculaPR+"'");
            while(rs.next()){
                labnombree.setText(rs.getString("nombre")+" "+rs.getString("apellidoPaterno")+" "+rs.getString("apellidoMAterno"));
            }
        }catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
        }
       
       
       jDateChooser1.getDateEditor().setEnabled(false);
       ponerFechas();
        
        btnguardar.setEnabled(false);
        //btnCancelar.setEnabled(false);
        
        
        
        
        
        try{
            OracleConnection.conectar();                
            Connection conn = OracleConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery ("SELECT M.NOMBRE, "
                    + "H.LUNES||H.SALLUN LUNES, "
                    + "H.MARTE||H.SALMAR MARTES, "
                    + "H.MIERC||H.SALMIE MIERCOLES, "
                    + "H.JUEVE||H.SALJUE JUEVES, "
                    + "H.VIERN||H.SALVIE VIERNES, "
                    + "H.SABAD||H.SALSAB SABADO "
                    + "FROM HORARIO2 H JOIN RELPROFESORMATERIA R USING(IDMATERIA) "
                    + "JOIN MATERIA M USING(IDMATERIA) WHERE MATRICULAPR='"+matriculaPR+"'");
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
            OracleConnection.cerrar();
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
        
        
        
        
        jComboBoxGrupo.removeAllItems();
        jComboBoxGrupoCalif.removeAllItems();
        //OracleBD OracleConnection = new OracleBD();
        try{
                    OracleConnection.conectar();
                    Connection conn = OracleConnection.getConnection();
                    Statement s1 = conn.createStatement();
                    ResultSet rs1 = s1.executeQuery ("SELECT DISTINCT nombre FROM GRUPO JOIN RELPROFESORMATERIA USING(IDGRUPO) "
                            + "WHERE MATRICULAPR='"+matriculaPR+"' "
                            + "ORDER BY nombre");
                    while(rs1.next()){
                        jComboBoxGrupo.addItem(rs1.getString("nombre"));
                        jComboBoxGrupoCalif.addItem(rs1.getString("nombre"));
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        labnombree = new javax.swing.JLabel();
        labmatricula = new javax.swing.JLabel();
        componenteAyuda1 = new Aplicacion.ComponenteAyuda();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelHorarioProfesor = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHorario = new javax.swing.JTable();
        jPanelFaltasProfesor = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableFaltas = new javax.swing.JTable();
        btnguardar = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jComboBoxGrupo = new javax.swing.JComboBox();
        jComboBoxMateria = new javax.swing.JComboBox();
        jCheckBoxTodo = new javax.swing.JCheckBox();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanelCalifProfesor = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTableCalif = new javax.swing.JTable();
        jComboBoxGrupoCalif = new javax.swing.JComboBox();
        btnGuardarCalif = new javax.swing.JButton();
        jComboBoxMateriaCalif = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Institución - profesor");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(950, 650));

        jButton2.setText("Cerrar sesión");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        labnombree.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labnombree.setText("Nombre");

        labmatricula.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labmatricula.setText("Matricula");

        componenteAyuda1.setUrl("www.google.com");

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

        javax.swing.GroupLayout jPanelHorarioProfesorLayout = new javax.swing.GroupLayout(jPanelHorarioProfesor);
        jPanelHorarioProfesor.setLayout(jPanelHorarioProfesorLayout);
        jPanelHorarioProfesorLayout.setHorizontalGroup(
            jPanelHorarioProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHorarioProfesorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 886, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelHorarioProfesorLayout.setVerticalGroup(
            jPanelHorarioProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHorarioProfesorLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(442, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Horario", jPanelHorarioProfesor);

        jPanelFaltasProfesor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Faltas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jTableFaltas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTableFaltas);

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

        jCheckBoxTodo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBoxTodo.setText("Marcar Todo");
        jCheckBoxTodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBoxTodoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelFaltasProfesorLayout = new javax.swing.GroupLayout(jPanelFaltasProfesor);
        jPanelFaltasProfesor.setLayout(jPanelFaltasProfesorLayout);
        jPanelFaltasProfesorLayout.setHorizontalGroup(
            jPanelFaltasProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFaltasProfesorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFaltasProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFaltasProfesorLayout.createSequentialGroup()
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelFaltasProfesorLayout.createSequentialGroup()
                        .addGroup(jPanelFaltasProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanelFaltasProfesorLayout.createSequentialGroup()
                                .addGroup(jPanelFaltasProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jComboBoxMateria, 0, 150, Short.MAX_VALUE)
                                    .addComponent(jComboBoxGrupo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBoxTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(204, Short.MAX_VALUE))))
        );
        jPanelFaltasProfesorLayout.setVerticalGroup(
            jPanelFaltasProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFaltasProfesorLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelFaltasProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxTodo))
                .addGap(18, 18, 18)
                .addGroup(jPanelFaltasProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
                    .addGroup(jPanelFaltasProfesorLayout.createSequentialGroup()
                        .addComponent(btnguardar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Asignar Faltas", jPanelFaltasProfesor);

        jPanelCalifProfesor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Calificaciones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jTableCalif.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane8.setViewportView(jTableCalif);

        jComboBoxGrupoCalif.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxGrupoCalif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxGrupoCalifActionPerformed(evt);
            }
        });

        btnGuardarCalif.setText("Guardar Calificaciones");
        btnGuardarCalif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCalifActionPerformed(evt);
            }
        });

        jComboBoxMateriaCalif.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxMateriaCalif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMateriaCalifActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Grupo :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Materia: ");

        javax.swing.GroupLayout jPanelCalifProfesorLayout = new javax.swing.GroupLayout(jPanelCalifProfesor);
        jPanelCalifProfesor.setLayout(jPanelCalifProfesorLayout);
        jPanelCalifProfesorLayout.setHorizontalGroup(
            jPanelCalifProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCalifProfesorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCalifProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCalifProfesorLayout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGuardarCalif))
                    .addGroup(jPanelCalifProfesorLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxMateriaCalif, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCalifProfesorLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxGrupoCalif, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(281, Short.MAX_VALUE))
        );
        jPanelCalifProfesorLayout.setVerticalGroup(
            jPanelCalifProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCalifProfesorLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanelCalifProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxGrupoCalif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanelCalifProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxMateriaCalif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCalifProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarCalif))
                .addContainerGap(264, Short.MAX_VALUE))
        );

        jScrollPane4.setViewportView(jPanelCalifProfesor);

        jTabbedPane1.addTab("Asignar Calififcaciones", jScrollPane4);

        jScrollPane3.setViewportView(jTabbedPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labnombree)
                                    .addComponent(labmatricula))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 723, Short.MAX_VALUE)
                                .addComponent(jButton2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(componenteAyuda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(componenteAyuda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labnombree)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labmatricula)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
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
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBoxMateriaCalifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMateriaCalifActionPerformed
        DefaultTableModel modelo3 = new DefaultTableModel(){
                     
            @Override
            public boolean isCellEditable(int row, int col) {
                return (col >= 4); 
            }
        };

        JComboBox comboBox = new JComboBox();
        String a=null;
        for(int i=0; i <10; i++){
            for(int j=0; j<=9; j++){
                a = ""+i+"."+j;
                //System.out.println(a);
                comboBox.addItem(a);
            }
        }
        //System.out.println(10);

        comboBox.addItem(10);

        modelo3.addColumn("Matricula");
        modelo3.addColumn("Nombre");
        modelo3.addColumn("Ap. Paterno");
        modelo3.addColumn("Ap. Materno");
        modelo3.addColumn("Parcial 1");
        modelo3.addColumn("Parcial 2");
        modelo3.addColumn("Parcial 3");

        String query = ("select matriculaAl, nombre, apellidoPaterno, apellidoMaterno, "
            + "Parcial1, Parcial2, Parcial3 "
            + "from alumno join kardex using(matriculaAl) "
            + "join calificaciones c using(idkardex) "
            + "join RELPROFESORMATERIA r using(idgrupo) "
            + "where c.idMateria=r.idMateria "
            + "AND c.idMateria=(SELECT IDMATERIA FROM MATERIA JOIN RELPROFESORMATERIA USING(IDMATERIA) "
            + "WHERE MATERIA.NOMBRE='"+ (String) jComboBoxMateriaCalif.getSelectedItem() +"' "
            + "AND MATRICULAPR='"+matricula+"' "
            + "AND IDGRUPO=( SELECT IDGRUPO FROM GRUPO WHERE NOMBRE ='"+(String) jComboBoxGrupoCalif.getSelectedItem()+"')) ORDER BY APELLIDOPATERNO");

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
                modelo3.addRow(fila);
            }
            //.setModel(modelo);
            stmt.close();
            OracleConnection.cerrar();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        jTableCalif.setModel(modelo3);
        TableColumn as = jTableCalif.getColumnModel().getColumn(4);
        as.setCellEditor(new DefaultCellEditor(comboBox));
        as = jTableCalif.getColumnModel().getColumn(5);
        as.setCellEditor(new DefaultCellEditor(comboBox));
        as = jTableCalif.getColumnModel().getColumn(6);
        as.setCellEditor(new DefaultCellEditor(comboBox));
    }//GEN-LAST:event_jComboBoxMateriaCalifActionPerformed

    private void btnGuardarCalifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCalifActionPerformed
        int filas = jTableCalif.getRowCount();
        int n=0;
        for (int i=0; i < filas; i++){
            String sQl = null;
            sQl = ("UPDATE Calificaciones "
                + "SET Parcial1 = ?,"
                + "Parcial2 = ?,"
                + "Parcial3 = ? "
                + "WHERE idkardex=(select idkardex from kardex where matriculaal='"+(String ) jTableCalif.getValueAt(i, 0).toString()+"') "
                + "and idmateria=(SELECT IDMATERIA FROM MATERIA JOIN RELPROFESORMATERIA USING(IDMATERIA) "
                + "WHERE MATERIA.NOMBRE='ALGEBRA SUPERIOR' "
                + "AND MATRICULAPR='"+matricula+"' "
                + "AND IDGRUPO=( SELECT IDGRUPO FROM GRUPO WHERE NOMBRE ='"+(String)jComboBoxGrupoCalif.getSelectedItem()+"'))");
            //System.out.println((String ) jTable1.getValueAt(i, 0).toString());
            OracleBD OracleConnection = new OracleBD();
            try{

                OracleConnection.conectar();
                Connection conn = OracleConnection.getConnection();
                PreparedStatement pst = conn.prepareStatement(sQl);// Envia la sentencia SQL en la variavle sSQL ha SQL para ejecutar acciones en la base de datos.
                pst.setString(1,(String ) jTableCalif.getValueAt(i, 4).toString());// Con el metodo setString se envian los valores a la base de datos colocando primero la pocicion del dato y luego la variable que contiene este mismo.
                pst.setString(2,(String ) jTableCalif.getValueAt(i, 5).toString());
                pst.setString(3,(String ) jTableCalif.getValueAt(i, 6).toString());
                n = pst.executeUpdate();

                pst.close();
                OracleConnection.cerrar();
            }catch(Exception ex){
                System.out.println("Error: " + ex.getMessage());
            }
        }
        if(n>0){
            JOptionPane.showMessageDialog(null, "Calificaciones Guardadas");
        }
    }//GEN-LAST:event_btnGuardarCalifActionPerformed

    private void jComboBoxGrupoCalifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxGrupoCalifActionPerformed
        jComboBoxMateriaCalif.removeAllItems();
        OracleBD OracleConnection = new OracleBD();
        try{
            OracleConnection.conectar();
            Connection conn = OracleConnection.getConnection();
            Statement s1 = conn.createStatement();
            ResultSet rs1 = s1.executeQuery ("SELECT nombre MATERIA FROM MATERIA JOIN RELPROFESORMATERIA USING(IDMATERIA) "
                + "WHERE MATRICULAPR='"+matricula+"' "
                + "AND IDGRUPO=(SELECT IDGRUPO FROM GRUPO WHERE NOMBRE='"+(String) jComboBoxGrupoCalif.getSelectedItem()+"') "
                + "Order BY nombre");
            while(rs1.next()){
                jComboBoxMateriaCalif.addItem(rs1.getString("MATERIA"));
            }
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_jComboBoxGrupoCalifActionPerformed

    private void jCheckBoxTodoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxTodoMouseClicked
        int filas = jTableFaltas.getRowCount();
        for (int i=0; i < filas; i++){
            jTableFaltas.setValueAt(jCheckBoxTodo.isSelected(), i, 4);
        }
    }//GEN-LAST:event_jCheckBoxTodoMouseClicked

    private void jComboBoxMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMateriaActionPerformed
        DefaultTableModel modelo2 = new DefaultTableModel(){

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
        modelo2.addColumn("Matricula");
        modelo2.addColumn("Nombre");
        modelo2.addColumn("Ap. Paterno");
        modelo2.addColumn("Ap. Materno");
        modelo2.addColumn("Falta");

        TableRowSorter elQueOrdena = new TableRowSorter(modelo2);//Permite ordenar las filas seleccionando la cabezera
        jTableFaltas.setRowSorter(elQueOrdena);
        jTableFaltas.setModel(modelo2);

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
                modelo2.addRow(fila);
                modelo2.setValueAt(false, modelo2.getRowCount()-1, 4);
                btnguardar.setEnabled(true);
                //btnCancelar.setEnabled(true);
            }
            rs1.close();
            OracleConnection.cerrar();
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
        //Poner el color de los checkbox
        ((JComponent) jTableFaltas.getDefaultRenderer(Boolean.class)).setOpaque(true);
        jCheckBoxTodo.setSelected(false);
    }//GEN-LAST:event_jComboBoxMateriaActionPerformed

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

    private void jDateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser1PropertyChange

    private void jDateChooser1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser1MouseClicked

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        String matAlumno, nombreGrupo;
        String materia = (String) jComboBoxMateria.getSelectedItem();
        nombreGrupo = (String) jComboBoxGrupo.getSelectedItem();
        int filas = jTableFaltas.getRowCount();
        System.out.println("sfsdfsdfsdfsdfsdf");
        for (int i=0; i < filas; i++){
            if( (Boolean) jTableFaltas.getValueAt(i, 4) ){
                matAlumno = (String) jTableFaltas.getValueAt(i, 0);
                System.out.println(matAlumno+" "+fecha);
                OracleBD OracleConnection = new OracleBD();
                try{
                    OracleConnection.conectar();
                    Connection conn = OracleConnection.getConnection();
                    Statement s1 = conn.createStatement();
                    ResultSet rs1 = s1.executeQuery ("SELECT COUNT(*) CUENTA FROM FALTAS WHERE "
                        + "matriculaAL='"+matAlumno+"' AND idMateria=(SELECT IDMATERIA FROM MATERIA JOIN RELPROFESORMATERIA "
                        + "USING(IDMATERIA) WHERE MATERIA.NOMBRE='"+materia+"' AND FECHA='"+fecha+"')");
                    int k=-1;
                    rs1.next();
                    k= (rs1.getInt("CUENTA"));
                    System.out.println(k);
                    if (k==0){
                        s1.executeQuery ("INSERT INTO FALTAS VALUES "
                            + "('',to_date('"+fecha+"','DD/MM/YYYY'),0,'"+matAlumno+"', "
                            + "(SELECT IDMATERIA FROM MATERIA JOIN RELPROFESORMATERIA USING(IDMATERIA) WHERE MATERIA.NOMBRE='"+materia+"' AND "
                            + "MATRICULAPR='"+matricula+"' AND "
                            + "IDGRUPO=(SELECT IDGRUPO FROM GRUPO WHERE NOMBRE='"+nombreGrupo+"')))");
                    }
                }catch(Exception ex){
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Faltas ingresados para la fecha "+fecha);
        jCheckBoxTodo.setSelected(false);
        for (int i=0; i < filas; i++){
            jTableFaltas.setValueAt(jCheckBoxTodo.isSelected(), i, 4);
        }
    }//GEN-LAST:event_btnguardarActionPerformed
    
    
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
                    System.out.println("Error: " + ex.getMessage());
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
            java.util.logging.Logger.getLogger(PantallaProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaProfesor().setVisible(true);
            }
        });
    }

    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarCalif;
    private javax.swing.JButton btnguardar;
    private Aplicacion.ComponenteAyuda componenteAyuda1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBoxTodo;
    private javax.swing.JComboBox jComboBoxGrupo;
    private javax.swing.JComboBox jComboBoxGrupoCalif;
    private javax.swing.JComboBox jComboBoxMateria;
    private javax.swing.JComboBox jComboBoxMateriaCalif;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanelCalifProfesor;
    private javax.swing.JPanel jPanelFaltasProfesor;
    private javax.swing.JPanel jPanelHorarioProfesor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableCalif;
    private javax.swing.JTable jTableFaltas;
    private javax.swing.JTable jTableHorario;
    private javax.swing.JLabel labmatricula;
    private javax.swing.JLabel labnombree;
    // End of variables declaration//GEN-END:variables


    
    
    public void setUpSportColumn(JTable table,
                                 TableColumn sportColumn) {
        //Set up the editor for the sport cells.
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Snowboarding");
        comboBox.addItem("Rowing");
        comboBox.addItem("Knitting");
        comboBox.addItem("Speed reading");
        comboBox.addItem("Pool");
        comboBox.addItem("None of the above");
        sportColumn.setCellEditor(new DefaultCellEditor(comboBox));

        //Set up tool tips for the sport cells.
        DefaultTableCellRenderer renderer =
                new DefaultTableCellRenderer();
        renderer.setToolTipText("Click for combo box");
        sportColumn.setCellRenderer(renderer);
        
    }
    


    
    
}
