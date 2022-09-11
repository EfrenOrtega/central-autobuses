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
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import model.ConexionMySQL;

/**
 *
 * @author Efren
 */
public class Autobuses extends javax.swing.JFrame {

    /**
     * Creates new form Boleto
     */
    ConexionMySQL cn = new ConexionMySQL();    
    Connection con = cn.getConexion();    
    
    public Autobuses() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public void tablaDiseño(){        
        JTableHeader Header = tablaBus.getTableHeader();
        Header.setBackground(new Color(42, 69, 114));
        Header.setForeground(Color.white);
        Header.setFont(new Font("Dialog", Font.BOLD, 13));
        Header.setPreferredSize(new Dimension(30, 30));
        
        //Centrar datos en tabla
        DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
        Alinear.setHorizontalAlignment(SwingConstants.CENTER);//.LEFT .RIGHT .CENTER
        tablaBus.getColumnModel().getColumn(0).setCellRenderer(Alinear);
        tablaBus.getColumnModel().getColumn(1).setCellRenderer(Alinear);
        tablaBus.getColumnModel().getColumn(2).setCellRenderer(Alinear);
        tablaBus.getColumnModel().getColumn(3).setCellRenderer(Alinear);
        tablaBus.getColumnModel().getColumn(4).setCellRenderer(Alinear);
        tablaBus.getColumnModel().getColumn(5).setCellRenderer(Alinear);
        tablaBus.getColumnModel().getColumn(6).setCellRenderer(Alinear);

    }
        
    public void actualizarTabla(){
     
        
            DefaultTableModel tabla = new DefaultTableModel();  
            tabla.addColumn("ID");
            tabla.addColumn("Matricula");
            tabla.addColumn("Año");
            tabla.addColumn("Marca");
            tabla.addColumn("Modelo");
            tabla.addColumn("No. Asientos");
            tabla.addColumn("Linea");

            PreparedStatement ps;
            String sql;
            try{
                sql="SELECT *FROM autobuses";
                ps = con.prepareStatement(sql);

                ResultSet rs=ps.executeQuery();  

                if(rs.next()){
                    if(rs.getRow() > 0){
                        rs=ps.executeQuery();  
                        while(rs.next()){
                            String DBID = rs.getString("Id_autobus");
                            String DBMatricula=rs.getString("Matricula");
                            String DBAño=rs.getString("Año");
                            String DBMarca=rs.getString("Marca");
                            String DBModelo=rs.getString("Modelo");
                            String DBNoAsientos=rs.getString("NoAsientos");
                            String DBLinea=rs.getString("Linea");

                            tabla.addRow(new Object[]{DBID, DBMatricula,DBAño,DBMarca,DBModelo, 
                                DBNoAsientos, DBLinea});

                        }                      
                    }
                }else{
                    //JOptionPane.showMessageDialog(null, "No hay Registros");
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
            }       

            tablaBus.setModel(tabla);
            tablaDiseño();        
    }
    
    public void limpiarCajasTexto(){
        txtID.setText("");
        txtMatricula.setText("");
        txtAño.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtAsientos.setText("");
        txtLinea.setText("");
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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnBoletos = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnRutas = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnConductores = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Asientos = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabelMatricula = new javax.swing.JLabel();
        jLabelAño = new javax.swing.JLabel();
        txtAño = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabelMarca = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabelDestino = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtAsientos = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabelHorario = new javax.swing.JLabel();
        txtLinea = new javax.swing.JTextField();
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
        tablaBus = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JLabel();

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
        btnInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelMenu.add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 189, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Home.png"))); // NOI18N
        jPanelMenu.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 174, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Boleto.png"))); // NOI18N
        jPanelMenu.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 254, -1, -1));

        jLabel7.setFont(new java.awt.Font("Roboto Medium", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Autobuses");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelMenu.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 345, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Bus.png"))); // NOI18N
        jPanelMenu.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 334, -1, -1));

        btnBoletos.setFont(new java.awt.Font("Roboto Medium", 0, 16)); // NOI18N
        btnBoletos.setForeground(new java.awt.Color(255, 255, 255));
        btnBoletos.setText("Boletos");
        btnBoletos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelMenu.add(btnBoletos, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 265, 90, 30));

        jPanel4.setBackground(new java.awt.Color(42, 69, 114));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 87, 136), 30, true));
        jPanel4.setForeground(new java.awt.Color(54, 87, 136));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanelMenu.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 339, 98, 30));

        btnRutas.setFont(new java.awt.Font("Roboto Medium", 0, 16)); // NOI18N
        btnRutas.setForeground(new java.awt.Color(255, 255, 255));
        btnRutas.setText("Rutas");
        btnRutas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelMenu.add(btnRutas, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 425, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Rutas.png"))); // NOI18N
        jPanelMenu.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 414, -1, -1));

        btnConductores.setFont(new java.awt.Font("Roboto Medium", 0, 16)); // NOI18N
        btnConductores.setForeground(new java.awt.Color(255, 255, 255));
        btnConductores.setText("Conductores");
        btnConductores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        Asientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Portada_Bus.png"))); // NOI18N
        jPanel1.add(Asientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(386, 25, 635, 182));

        jLabel14.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jLabel14.setText("ID:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 260, -1, -1));

        txtID.setEditable(false);
        txtID.setBackground(new java.awt.Color(255, 255, 255));
        txtID.setForeground(new java.awt.Color(102, 102, 102));
        txtID.setBorder(null);
        jPanel1.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 284, 100, 25));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Caja Texto114.png"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 281, 114, 30));

        txtMatricula.setToolTipText("");
        txtMatricula.setBorder(null);
        jPanel1.add(txtMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(597, 284, 90, 25));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Caja Texto114.png"))); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(587, 281, 114, 30));

        jLabelMatricula.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jLabelMatricula.setText("Matricula:");
        jPanel1.add(jLabelMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(587, 260, -1, -1));

        jLabelAño.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jLabelAño.setText("Año:");
        jPanel1.add(jLabelAño, new org.netbeans.lib.awtextra.AbsoluteConstraints(743, 260, -1, -1));

        txtAño.setBorder(null);
        jPanel1.add(txtAño, new org.netbeans.lib.awtextra.AbsoluteConstraints(753, 284, 100, 25));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Caja Texto114.png"))); // NOI18N
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(743, 281, 114, 30));

        jLabelMarca.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jLabelMarca.setText("Marca:");
        jPanel1.add(jLabelMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(891, 260, -1, -1));

        txtMarca.setBorder(null);
        jPanel1.add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(901, 284, 100, 25));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Caja Texto114.png"))); // NOI18N
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(891, 281, 114, 30));

        jLabelDestino.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jLabelDestino.setText("Modelo:");
        jPanel1.add(jLabelDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 354, -1, -1));

        txtModelo.setBorder(null);
        jPanel1.add(txtModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 378, 70, 25));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Caja Texto82.png"))); // NOI18N
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 375, 82, 30));

        txtAsientos.setBorder(null);
        jPanel1.add(txtAsientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 378, 102, 25));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Caja Texto114.png"))); // NOI18N
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 375, 114, 30));

        jLabelHorario.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jLabelHorario.setText("No. Asientos:");
        jPanel1.add(jLabelHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 354, -1, -1));

        txtLinea.setBorder(null);
        jPanel1.add(txtLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(835, 378, 100, 25));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Caja Texto114.png"))); // NOI18N
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(825, 375, 114, 30));

        jLabelHorario1.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jLabelHorario1.setText("Linea:");
        jPanel1.add(jLabelHorario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(825, 354, -1, -1));

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

        BoxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "ID", "Matricula", "Año", "Marca", "Modelo", "Linea" }));
        jPanel1.add(BoxFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 520, 110, 30));

        jScrollPane1.setBorder(null);

        tablaBus.setBackground(new java.awt.Color(231, 247, 253));
        tablaBus.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaBus.setRowHeight(23);
        tablaBus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaBusMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaBus);

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
        jLabel21.setText("Autobuses");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 529, -1, -1));

        txtBuscar.setBorder(null);
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 522, 188, 25));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Caja Texto200.png"))); // NOI18N
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 520, 200, 30));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Buscar.png"))); // NOI18N
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 524, -1, -1));

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

    private void tablaBusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaBusMouseClicked
        int registro = tablaBus.rowAtPoint(evt.getPoint());
        txtID.setText(String.valueOf(tablaBus.getValueAt(registro, 0)));
        txtMatricula.setText(String.valueOf(tablaBus.getValueAt(registro, 1)));
        txtAño.setText(String.valueOf(tablaBus.getValueAt(registro, 2)));
        txtMarca.setText(String.valueOf(tablaBus.getValueAt(registro, 3)));
        txtModelo.setText(String.valueOf(tablaBus.getValueAt(registro, 4)));
        txtAsientos.setText(String.valueOf(tablaBus.getValueAt(registro, 5)));
        txtLinea.setText(String.valueOf(tablaBus.getValueAt(registro, 6)));
        
    }//GEN-LAST:event_tablaBusMouseClicked

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
    
        if(!BoxFiltro.getSelectedItem().toString().equals("Todos")){
            if(!txtBuscar.getText().equals("")){

                DefaultTableModel tabla = new DefaultTableModel();  
                tabla.addColumn("ID");
                tabla.addColumn("Matricula");
                tabla.addColumn("Año");
                tabla.addColumn("Marca");
                tabla.addColumn("Modelo");
                tabla.addColumn("No. Asientos");
                tabla.addColumn("Linea");

                String Campo = BoxFiltro.getSelectedItem().toString();
                String Dato = txtBuscar.getText();
                if(BoxFiltro.getSelectedItem().toString().equals("ID")){
                    Campo="Id_autobus";
                }

                PreparedStatement ps;
                String sql;

                try {
                    sql = "SELECT *FROM autobuses WHERE " +Campo+ " =?";
                    ps = con.prepareStatement(sql);
                    ps.setString(1, Dato);

                    ResultSet rs=ps.executeQuery();  

                    if(rs.next()){
                        if(rs.getRow() > 0){
                        rs=ps.executeQuery();  
                            while(rs.next()){
                                String DBID = rs.getString("Id_autobus");
                                String DBMatricula=rs.getString("Matricula");
                                String DBAño=rs.getString("Año");
                                String DBMarca=rs.getString("Marca");
                                String DBModelo=rs.getString("Modelo");
                                String DBNoAsientos=rs.getString("NoAsientos");
                                String DBLinea=rs.getString("Linea");

                                tabla.addRow(new Object[]{DBID, DBMatricula,DBAño,DBMarca,DBModelo, 
                                DBNoAsientos, DBLinea});

                            }                      
                        }
                        tablaBus.setModel(tabla);
                        tablaDiseño();
                    }else{
                        actualizarTabla();
                        JOptionPane.showMessageDialog(null, "No se Encontro el Registro");
                    }                

                } catch (SQLException e) {
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
            java.util.logging.Logger.getLogger(Autobuses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Autobuses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Autobuses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Autobuses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Autobuses().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Asientos;
    private javax.swing.JPanel BotonEliminar;
    private javax.swing.JPanel BotonGuardar;
    private javax.swing.JPanel BotonModificar;
    public javax.swing.JComboBox<String> BoxFiltro;
    public javax.swing.JLabel Eliminar;
    public javax.swing.JLabel GUARDAR;
    public javax.swing.JLabel Modificar;
    public javax.swing.JLabel btnBoletos;
    public javax.swing.JLabel btnBuscar;
    public javax.swing.JLabel btnConductores;
    public javax.swing.JLabel btnInicio;
    public javax.swing.JLabel btnRutas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelAño;
    private javax.swing.JLabel jLabelDestino;
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
    public javax.swing.JTable tablaBus;
    public javax.swing.JTextField txtAsientos;
    public javax.swing.JTextField txtAño;
    public javax.swing.JTextField txtBuscar;
    public javax.swing.JTextField txtID;
    public javax.swing.JTextField txtLinea;
    public javax.swing.JTextField txtMarca;
    public javax.swing.JTextField txtMatricula;
    public javax.swing.JTextField txtModelo;
    // End of variables declaration//GEN-END:variables
}
