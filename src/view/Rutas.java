/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import model.ConexionMySQL;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Efren
 */
public class Rutas extends javax.swing.JFrame {

    /**
     * Creates new form Boleto
     */
    ConexionMySQL cn = new ConexionMySQL();    
    Connection con = cn.getConexion();  
    
    public Rutas() {
        initComponents();
        this.setLocationRelativeTo(null);
        llenarComboBox();
    }
    
    public String horaActual(){
        SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();

        Date dateObj = calendar.getTime();
        String formattedDate = dtf.format(dateObj);
        
        return formattedDate;
    }

    public void limpiarCajasTexto(){
        txtID.setText("");
        txtOrigen.setText("");
        txtDestino.setText("");
        txtHoraSalida.setText("");
        ComboBoxBusAsignado.setSelectedIndex(0);
        ComboBoxConductor.setSelectedIndex(0);
        txtSeccion.setText("");
    }
    
    public void tablaDiseño(){        
        JTableHeader Header = tablaRutas.getTableHeader();
        Header.setBackground(new Color(42, 69, 114));
        Header.setForeground(Color.white);
        Header.setFont(new Font("Dialog", Font.BOLD, 13));
        Header.setPreferredSize(new Dimension(30, 30));
        
        TableColumnModel columnModel = tablaRutas.getColumnModel();

        columnModel.getColumn(0).setPreferredWidth(30);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(150);
        columnModel.getColumn(3).setPreferredWidth(70);
        columnModel.getColumn(4).setPreferredWidth(120);
        columnModel.getColumn(5).setPreferredWidth(150);
        columnModel.getColumn(6).setPreferredWidth(70);
        
        //Centrar datos en tabla
        DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
        Alinear.setHorizontalAlignment(SwingConstants.CENTER);//.LEFT .RIGHT .CENTER
        tablaRutas.getColumnModel().getColumn(0).setCellRenderer(Alinear);
        tablaRutas.getColumnModel().getColumn(1).setCellRenderer(Alinear);
        tablaRutas.getColumnModel().getColumn(2).setCellRenderer(Alinear);
        tablaRutas.getColumnModel().getColumn(3).setCellRenderer(Alinear);
        tablaRutas.getColumnModel().getColumn(4).setCellRenderer(Alinear);
        tablaRutas.getColumnModel().getColumn(5).setCellRenderer(Alinear);
        tablaRutas.getColumnModel().getColumn(6).setCellRenderer(Alinear);

    }
        
    public void actualizarTabla(){
        
        DefaultTableModel tabla = new DefaultTableModel();  
        tabla.addColumn("Id");
        tabla.addColumn("Origen");
        tabla.addColumn("Destino");
        tabla.addColumn("Hora Salida");
        tabla.addColumn("Autobus Asignado");
        tabla.addColumn("Conductor");
        tabla.addColumn("Sección");
        PreparedStatement ps;
        String sql;
        try{
            sql="SELECT Id_Rutas, Origen, Destino, HoraSalida, Matricula, Nombre, "
            + "Sección, Fecha FROM(rutas AS Rut INNER JOIN autobuses AS Aut ON "
            + "Rut.AutobusAsignado=Aut.Id_autobus) INNER JOIN conductores "
            + "AS Cond ON Rut.Conductor = Cond.Id_Conductor ORDER BY Id_Rutas";
            ps = con.prepareStatement(sql);

            ResultSet rs=ps.executeQuery();  
                
            if(rs.next()){
                if(rs.getRow() > 0){
                    rs=ps.executeQuery();  
                    while(rs.next()){
                        String DBId=rs.getString("Id_Rutas");
                        String DBOrigen=rs.getString("Origen");
                        String DBDestino=rs.getString("Destino");
                        String DBHoraSalida=rs.getString("HoraSalida");
                        String DBMatricula=rs.getString("Matricula");
                        String DBConductor=rs.getString("Nombre");
                        String DBSeccion=rs.getString("Sección");

                        tabla.addRow(new Object[]{DBId,DBOrigen,DBDestino,DBHoraSalida, 
                            DBMatricula, DBConductor, DBSeccion});
                        
                    }                      
                }
            }else{
                //JOptionPane.showMessageDialog(null, "No hay Registros");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }       
        
        tablaRutas.setModel(tabla);
        tablaDiseño();

    }
    
    public void llenarComboBox(){
        PreparedStatement ps;
        String sql;
        try{
            sql="SELECT Matricula FROM autobuses";
            ps = con.prepareStatement(sql);

            ResultSet rs=ps.executeQuery();  
                
            if(rs.next()){
                if(rs.getRow() > 0){
                    rs=ps.executeQuery();  
                    while(rs.next()){
                        String DBMatricula=rs.getString("Matricula");
                        ComboBoxBusAsignado.addItem(DBMatricula);
                    }                      
                }
            }else{
                System.out.print("Error");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }   
        
        try{
            sql="SELECT Nombre FROM conductores";
            ps = con.prepareStatement(sql);

            ResultSet rs=ps.executeQuery();  
                
            if(rs.next()){
                if(rs.getRow() > 0){
                    rs=ps.executeQuery();  
                    while(rs.next()){
                        String DBNombre=rs.getString("Nombre");
                        ComboBoxConductor.addItem(DBNombre);
                    }                      
                }
            }else{
                System.out.print("Error");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
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
        jPanelMenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        btnInicio = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAutobuses = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnBoletos = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btnConductores = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Asientos = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtOrigen = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabelMatricula = new javax.swing.JLabel();
        jLabelAño = new javax.swing.JLabel();
        txtDestino = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabelMarca = new javax.swing.JLabel();
        txtHoraSalida = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabelAutobusAsignado = new javax.swing.JLabel();
        jLabelHorario = new javax.swing.JLabel();
        txtSeccion = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabelHorario1 = new javax.swing.JLabel();
        BotonGuardar = new javax.swing.JPanel();
        GUARDAR = new javax.swing.JLabel();
        BotonEliminar = new javax.swing.JPanel();
        Eliminar = new javax.swing.JLabel();
        BotonModificar = new javax.swing.JPanel();
        Modificar = new javax.swing.JLabel();
        BoxFiltro = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRutas = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JLabel();
        ComboBoxConductor = new javax.swing.JComboBox<>();
        ComboBoxBusAsignado = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelMenu.setBackground(new java.awt.Color(42, 69, 114));
        jPanelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo.png"))); // NOI18N
        jLabel1.setToolTipText("");
        jPanelMenu.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 23, 225, -1));

        jSeparator1.setBackground(new java.awt.Color(232, 242, 241));
        jPanelMenu.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 114, 225, -1));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Menu");
        jPanelMenu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 138, 225, -1));

        btnInicio.setFont(new java.awt.Font("Roboto Medium", 0, 16)); // NOI18N
        btnInicio.setForeground(new java.awt.Color(255, 255, 255));
        btnInicio.setText("Inicio");
        btnInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelMenu.add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 189, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Home.png"))); // NOI18N
        jPanelMenu.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 174, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Boleto.png"))); // NOI18N
        jPanelMenu.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 254, -1, -1));

        btnAutobuses.setFont(new java.awt.Font("Roboto Medium", 0, 16)); // NOI18N
        btnAutobuses.setForeground(new java.awt.Color(255, 255, 255));
        btnAutobuses.setText("Autobuses");
        btnAutobuses.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAutobuses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAutobusesMouseClicked(evt);
            }
        });
        jPanelMenu.add(btnAutobuses, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 345, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Bus.png"))); // NOI18N
        jPanelMenu.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 334, -1, -1));

        btnBoletos.setFont(new java.awt.Font("Roboto Medium", 0, 16)); // NOI18N
        btnBoletos.setForeground(new java.awt.Color(255, 255, 255));
        btnBoletos.setText("Boletos");
        btnBoletos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBoletos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBoletosMouseClicked(evt);
            }
        });
        jPanelMenu.add(btnBoletos, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 265, 90, 30));

        jLabel9.setFont(new java.awt.Font("Roboto Medium", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Rutas");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelMenu.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 423, -1, -1));

        jPanel4.setBackground(new java.awt.Color(42, 69, 114));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 87, 136), 30, true));
        jPanel4.setForeground(new java.awt.Color(54, 87, 136));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanelMenu.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 417, 98, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Rutas.png"))); // NOI18N
        jPanelMenu.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 414, -1, -1));

        btnConductores.setFont(new java.awt.Font("Roboto Medium", 0, 16)); // NOI18N
        btnConductores.setForeground(new java.awt.Color(255, 255, 255));
        btnConductores.setText("Conductores");
        btnConductores.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnConductores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConductoresMouseClicked(evt);
            }
        });
        jPanelMenu.add(btnConductores, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 500, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Conductor.png"))); // NOI18N
        jPanelMenu.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 489, -1, -1));

        jPanel1.add(jPanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 225, 730));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 174, -1, -1));

        Asientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Portada_Rutas.png"))); // NOI18N
        jPanel1.add(Asientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(386, 25, 635, 182));

        jLabel14.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jLabel14.setText("ID:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 260, -1, -1));

        txtID.setEditable(false);
        txtID.setBackground(new java.awt.Color(255, 255, 255));
        txtID.setForeground(new java.awt.Color(102, 102, 102));
        txtID.setBorder(null);
        jPanel1.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 284, 100, 25));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Caja TextoInabilitada 114.png"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 281, 114, 30));

        txtOrigen.setToolTipText("");
        txtOrigen.setBorder(null);
        jPanel1.add(txtOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(533, 284, 146, 25));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Caja Texto160.png"))); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(523, 281, 160, 30));

        jLabelMatricula.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jLabelMatricula.setText("Origen:");
        jPanel1.add(jLabelMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(523, 260, -1, -1));

        jLabelAño.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jLabelAño.setText("Destino:");
        jPanel1.add(jLabelAño, new org.netbeans.lib.awtextra.AbsoluteConstraints(726, 260, -1, -1));

        txtDestino.setBorder(null);
        jPanel1.add(txtDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(734, 284, 150, 25));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Caja Texto160.png"))); // NOI18N
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(726, 281, 160, 30));

        jLabelMarca.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jLabelMarca.setText("Hora Salida:");
        jPanel1.add(jLabelMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(926, 260, -1, -1));

        txtHoraSalida.setBorder(null);
        jPanel1.add(txtHoraSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(936, 284, 100, 25));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Caja Texto114.png"))); // NOI18N
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(926, 281, 114, 30));

        jLabelAutobusAsignado.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jLabelAutobusAsignado.setText("Autobus Asignado:");
        jPanel1.add(jLabelAutobusAsignado, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 354, -1, -1));

        jLabelHorario.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jLabelHorario.setText("Conductor:");
        jPanel1.add(jLabelHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(616, 354, -1, -1));

        txtSeccion.setBorder(null);
        jPanel1.add(txtSeccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(897, 377, 100, 25));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Caja Texto114.png"))); // NOI18N
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(887, 375, 114, 30));

        jLabelHorario1.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jLabelHorario1.setText("Sección:");
        jPanel1.add(jLabelHorario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(887, 354, -1, -1));

        BotonGuardar.setBackground(new java.awt.Color(54, 87, 136));

        GUARDAR.setBackground(new java.awt.Color(54, 87, 136));
        GUARDAR.setFont(new java.awt.Font("Roboto Medium", 1, 16)); // NOI18N
        GUARDAR.setForeground(new java.awt.Color(255, 255, 255));
        GUARDAR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GUARDAR.setText("GUARDAR");
        GUARDAR.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout BotonGuardarLayout = new javax.swing.GroupLayout(BotonGuardar);
        BotonGuardar.setLayout(BotonGuardarLayout);
        BotonGuardarLayout.setHorizontalGroup(
            BotonGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(GUARDAR, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        BotonGuardarLayout.setVerticalGroup(
            BotonGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(GUARDAR, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.add(BotonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 447, 120, 35));

        BotonEliminar.setBackground(new java.awt.Color(54, 87, 136));

        Eliminar.setBackground(new java.awt.Color(54, 87, 136));
        Eliminar.setFont(new java.awt.Font("Roboto Medium", 1, 16)); // NOI18N
        Eliminar.setForeground(new java.awt.Color(255, 255, 255));
        Eliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Eliminar.setText("ELIMINAR");
        Eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout BotonEliminarLayout = new javax.swing.GroupLayout(BotonEliminar);
        BotonEliminar.setLayout(BotonEliminarLayout);
        BotonEliminarLayout.setHorizontalGroup(
            BotonEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        BotonEliminarLayout.setVerticalGroup(
            BotonEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.add(BotonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(644, 447, 120, 35));

        BotonModificar.setBackground(new java.awt.Color(54, 87, 136));

        Modificar.setBackground(new java.awt.Color(54, 87, 136));
        Modificar.setFont(new java.awt.Font("Roboto Medium", 1, 16)); // NOI18N
        Modificar.setForeground(new java.awt.Color(255, 255, 255));
        Modificar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Modificar.setText("MODIFICAR");
        Modificar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout BotonModificarLayout = new javax.swing.GroupLayout(BotonModificar);
        BotonModificar.setLayout(BotonModificarLayout);
        BotonModificarLayout.setHorizontalGroup(
            BotonModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        BotonModificarLayout.setVerticalGroup(
            BotonModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.add(BotonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 447, 120, 35));

        BoxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "ID", "Origen", "Destino", "Hora Salida", "Autobus Asignado", "Sección", "Fecha" }));
        jPanel1.add(BoxFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 520, 110, 30));

        jScrollPane1.setBorder(null);

        tablaRutas.setBackground(new java.awt.Color(231, 247, 253));
        tablaRutas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaRutas.setRowHeight(21);
        tablaRutas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaRutasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaRutas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 558, 817, 150));

        jLabel21.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        jLabel21.setText("Rutas");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 529, -1, -1));

        txtBuscar.setBorder(null);
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 523, 188, 25));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Caja Texto200.png"))); // NOI18N
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 520, 200, 30));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Buscar.png"))); // NOI18N
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 520, -1, -1));

        ComboBoxConductor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Conductor --" }));
        jPanel1.add(ComboBoxConductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(616, 375, 200, 30));

        ComboBoxBusAsignado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Autobus --" }));
        jPanel1.add(ComboBoxBusAsignado, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 375, 140, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBoletosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBoletosMouseClicked
        Boleto Ticket = new Boleto();
        this.setVisible(false);
        Ticket.setVisible(true);
    }//GEN-LAST:event_btnBoletosMouseClicked

    private void btnAutobusesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAutobusesMouseClicked
        Autobuses Bus = new Autobuses();
        this.setVisible(false);
        Bus.setVisible(true);    }//GEN-LAST:event_btnAutobusesMouseClicked

    private void btnConductoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConductoresMouseClicked
        Conductores Chofer = new Conductores();
        this.setVisible(false);
        Chofer.setVisible(true);    }//GEN-LAST:event_btnConductoresMouseClicked

    private void tablaRutasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaRutasMouseClicked
        int registro = tablaRutas.rowAtPoint(evt.getPoint());
        txtID.setText(String.valueOf(tablaRutas.getValueAt(registro, 0)));
        txtOrigen.setText(String.valueOf(tablaRutas.getValueAt(registro, 1)));
        txtDestino.setText(String.valueOf(tablaRutas.getValueAt(registro, 2))); 
        ComboBoxBusAsignado.setSelectedItem(String.valueOf(tablaRutas.getValueAt(registro, 4)));       
        txtHoraSalida.setText(String.valueOf(tablaRutas.getValueAt(registro, 3)));
        ComboBoxConductor.setSelectedItem(String.valueOf(tablaRutas.getValueAt(registro, 5)));        
        txtSeccion.setText(String.valueOf(tablaRutas.getValueAt(registro, 6)));
    }//GEN-LAST:event_tablaRutasMouseClicked

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
    
        if(!BoxFiltro.getSelectedItem().toString().equals("Todos")){
            if(!txtBuscar.getText().equals("")){

                DefaultTableModel tabla = new DefaultTableModel();  
                tabla.addColumn("Id");
                tabla.addColumn("Origen");
                tabla.addColumn("Destino");
                tabla.addColumn("Hora Salida");
                tabla.addColumn("Autobus Asignado");
                tabla.addColumn("Conductor");
                tabla.addColumn("Sección");

                String Campo = BoxFiltro.getSelectedItem().toString();

                if(BoxFiltro.getSelectedItem().toString().equals("ID")){
                    Campo = "Id_Rutas";
                }
                if(BoxFiltro.getSelectedItem().toString().equals("Hora Salida")){
                    Campo = "HoraSalida";
                }
                
                if(BoxFiltro.getSelectedItem().toString().equals("Autobus Asignado")){
                    Campo = "Matricula";
                }

                String Dato = txtBuscar.getText();
                PreparedStatement ps;
                String sql;
                try{
                    sql="SELECT Id_Rutas, Origen, Destino, HoraSalida, Matricula, Nombre, "
                    + "Sección, Fecha FROM(rutas AS Rut INNER JOIN autobuses AS Aut ON "
                    + "Rut.AutobusAsignado=Aut.Id_autobus) INNER JOIN conductores "
                    + "AS Cond ON Rut.Conductor = Cond.Id_Conductor WHERE "+Campo+" = ? ORDER BY Id_Rutas";
                    ps = con.prepareStatement(sql);
                    ps.setString(1, Dato);

                    ResultSet rs=ps.executeQuery();  

                    if(rs.next()){
                        if(rs.getRow() > 0){
                            rs=ps.executeQuery();  
                            while(rs.next()){
                                String DBId=rs.getString("Id_Rutas");
                                String DBOrigen=rs.getString("Origen");
                                String DBDestino=rs.getString("Destino");
                                String DBHoraSalida=rs.getString("HoraSalida");
                                String DBMatricula=rs.getString("Matricula");
                                String DBConductor=rs.getString("Nombre");
                                String DBSeccion=rs.getString("Sección");

                                tabla.addRow(new Object[]{DBId,DBOrigen,DBDestino,DBHoraSalida, 
                                DBMatricula, DBConductor, DBSeccion});
                            }                      
                        }
                        tablaRutas.setModel(tabla);
                        tablaDiseño();
                    }else{
                        actualizarTabla();
                        JOptionPane.showMessageDialog(null, "No se encontro el Registro");
                    }
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
                }       
            }else{
                JOptionPane.showMessageDialog(null, "Ingresa un dato para buscar");
            }
        }else{
            actualizarTabla();
            limpiarCajasTexto();
            txtBuscar.setText("");
        }

    }//GEN-LAST:event_btnBuscarMouseClicked

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
            java.util.logging.Logger.getLogger(Rutas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rutas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rutas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rutas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rutas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Asientos;
    private javax.swing.JPanel BotonEliminar;
    private javax.swing.JPanel BotonGuardar;
    private javax.swing.JPanel BotonModificar;
    public javax.swing.JComboBox<String> BoxFiltro;
    public javax.swing.JComboBox<String> ComboBoxBusAsignado;
    public javax.swing.JComboBox<String> ComboBoxConductor;
    public javax.swing.JLabel Eliminar;
    public javax.swing.JLabel GUARDAR;
    public javax.swing.JLabel Modificar;
    public javax.swing.JLabel btnAutobuses;
    public javax.swing.JLabel btnBoletos;
    private javax.swing.JLabel btnBuscar;
    public javax.swing.JLabel btnConductores;
    public javax.swing.JLabel btnInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAutobusAsignado;
    private javax.swing.JLabel jLabelAño;
    private javax.swing.JLabel jLabelHorario;
    private javax.swing.JLabel jLabelHorario1;
    private javax.swing.JLabel jLabelMarca;
    private javax.swing.JLabel jLabelMatricula;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTable tablaRutas;
    public javax.swing.JTextField txtBuscar;
    public javax.swing.JTextField txtDestino;
    public javax.swing.JTextField txtHoraSalida;
    public javax.swing.JTextField txtID;
    public javax.swing.JTextField txtOrigen;
    public javax.swing.JTextField txtSeccion;
    // End of variables declaration//GEN-END:variables
}
