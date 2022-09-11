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
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
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
public class Boleto extends javax.swing.JFrame {

    /**
     * Creates new form Boleto
     */
    
    ConexionMySQL cn = new ConexionMySQL();    
    Connection con = cn.getConexion();    
    String AsientoDisponible;   
    
    public void inicializarAsientos(){
        Asiento1.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 1.png"));
        Asiento2.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 2.png"));
        Asiento3.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 3.png"));
        Asiento4.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 4.png"));
        Asiento5.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 5.png"));
        Asiento6.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 6.png"));
        Asiento7.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 7.png"));
        Asiento8.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 8.png"));
        Asiento9.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 9.png"));
        Asiento10.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 10.png"));
        Asiento11.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 11.png"));
        Asiento12.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 12.png"));
        Asiento13.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 13.png"));
        Asiento14.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 14.png"));
        Asiento15.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 15.png"));
        Asiento16.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 16.png"));
        Asiento17.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 17.png"));
        Asiento18.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 18.png"));
        Asiento19.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 19.png"));
        Asiento20.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 20.png"));
        Asiento21.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 21.png"));
        Asiento22.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 22.png"));
        Asiento23.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 23.png"));
        Asiento24.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 24.png"));                        
    }
    
    public void cargar(){
        BoxAsiento.removeAllItems();
        limpiarcajasTexto();
        String origen = Origen.getSelectedItem().toString();
        String destino = Destino.getSelectedItem().toString();
        String hora = ComboHorario.getSelectedItem().toString();
        
        PreparedStatement ps;
        String sql;

        try{
            sql="SELECT Asiento FROM boletos WHERE Origen=? and Destino=? and Hora=? and Fecha = CURDATE()";
            ps = con.prepareStatement(sql);
            ps.setString(1, origen);
            ps.setString(2, destino);
            ps.setString(3, hora);

            ResultSet rs=ps.executeQuery();  

            if(rs.next()){
                BoxAsiento.removeAllItems();
                if(rs.getRow() > 0){
                    rs=ps.executeQuery();  
                    inicializarAsientos();
                    llenarFormulaio();
                    int x=0;
                    ArrayList<String> AsientosDisponibles = new ArrayList<String>();
                    for (int i=1; i<=24; i++){
                        AsientosDisponibles.add(String.valueOf(i)); 
                    }                   

                    while(rs.next()){
                        String Asientos=rs.getString("Asiento");
                        int Asiento = Integer.parseInt(Asientos);
                        if(Asiento < 12){
                            if(Asiento == 1){
                                Asiento1.setIcon(new ImageIcon("Asientos/Asiento 1 Rojo.png"));                                
                            }else if(Asiento == 2){
                                Asiento2.setIcon(new ImageIcon("Asientos/Asiento 2 Rojo.png"));
                            }else if(Asiento==3){
                                Asiento3.setIcon(new ImageIcon("Asientos/Asiento 3 Rojo.png"));
                            }else if(Asiento==4){
                                Asiento4.setIcon(new ImageIcon("Asientos/Asiento 4 Rojo.png"));                                
                            }else if(Asiento == 5){
                                Asiento5.setIcon(new ImageIcon("Asientos/Asiento 5 Rojo.png"));
                            }else if(Asiento==6){
                                Asiento6.setIcon(new ImageIcon("Asientos/Asiento 6 Rojo.png"));
                            }else if(Asiento==7){
                                Asiento7.setIcon(new ImageIcon("Asientos/Asiento 7 Rojo.png"));
                            }else if(Asiento == 8){
                                Asiento8.setIcon(new ImageIcon("Asientos/Asiento 8 Rojo.png"));
                            }else if(Asiento == 9){
                                Asiento9.setIcon(new ImageIcon("Asientos/Asiento 9 Rojo.png"));
                            }else if(Asiento == 10){
                                Asiento10.setIcon(new ImageIcon("Asientos/Asiento 10 Rojo.png"));
                            }else if(Asiento == 11){
                                Asiento11.setIcon(new ImageIcon("Asientos/Asiento 11 Rojo.png"));
                            }
                        }else if(Asiento >= 12){    
                            if(Asiento == 12){
                                Asiento12.setIcon(new ImageIcon("Asientos/Asiento 12 Rojo.png"));
                            }else if(Asiento == 13){
                                Asiento13.setIcon(new ImageIcon("Asientos/Asiento 13 Rojo.png"));
                            }else if(Asiento == 14){
                                Asiento14.setIcon(new ImageIcon("Asientos/Asiento 14 Rojo.png"));
                            }else if(Asiento == 15){
                                Asiento15.setIcon(new ImageIcon("Asientos/Asiento 15 Rojo.png"));
                            }else if(Asiento == 16){
                                Asiento16.setIcon(new ImageIcon("Asientos/Asiento 16 Rojo.png"));
                            }else  if(Asiento == 17){
                                Asiento17.setIcon(new ImageIcon("Asientos/Asiento 17 Rojo.png"));
                            }else if(Asiento == 18){
                                Asiento18.setIcon(new ImageIcon("Asientos/Asiento 18 Rojo.png"));
                            }else if(Asiento == 19){
                                Asiento19.setIcon(new ImageIcon("Asientos/Asiento 19 Rojo.png"));
                            }else if(Asiento == 20){
                                Asiento20.setIcon(new ImageIcon("Asientos/Asiento 20 Rojo.png"));
                            }else if(Asiento == 21){
                                Asiento21.setIcon(new ImageIcon("Asientos/Asiento 21 Rojo.png"));
                            }else if(Asiento == 22){
                                Asiento22.setIcon(new ImageIcon("Asientos/Asiento 22 Rojo.png"));
                            }else if(Asiento == 23){
                                Asiento23.setIcon(new ImageIcon("Asientos/Asiento 23 Rojo.png"));
                            }else if(Asiento == 24){
                                Asiento24.setIcon(new ImageIcon("Asientos/Asiento 24 Rojo.png"));
                            }
                        }
                    
                        AsientosDisponibles.remove(Asientos);
                        x++;               
                    }
                    String[] miarray = new String[AsientosDisponibles.size()];
                    miarray = AsientosDisponibles.toArray(miarray);
                    for(String s : miarray)
                      BoxAsiento.addItem(s);
                    }

            }else{
                for(int i=1; i<=24; i++){
                    BoxAsiento.addItem(String.valueOf(i));
                }
                inicializarAsientos();
                limpiarcajasTexto();
                llenarFormulaio();

            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexión: " + e.getMessage());
        }   
    }
    
    public String horaActual(){
        SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();

        Date dateObj = calendar.getTime();
        String formattedDate = dtf.format(dateObj);
    
        
        return formattedDate;
    }
    
    public void llenarComboBoxOrigenDestino(){
        PreparedStatement ps;
        String sql;
        
        String HoraActual = horaActual();
        
        try{
            sql="SELECT Origen, Destino FROM rutas WHERE Fecha = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, HoraActual);
            ResultSet rs=ps.executeQuery();  
                
            if(rs.next()){
                if(rs.getRow() > 0){
                    rs=ps.executeQuery();  
                    inicializarAsientos();
                    while(rs.next()){
                        String DBOrigen=rs.getString("Origen");
                        String DBDestino=rs.getString("Destino");
                        Origen.addItem(DBOrigen);
                        Destino.addItem(DBDestino);
                    }                      
                }
            }else{
                System.out.print("No hay Rutas Actuales\n");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
            System.out.print("Hola");
        }   
        
        AutoCompleteDecorator.decorate(Destino);
        AutoCompleteDecorator.decorate(Origen);
    }
    
    public void llenarFormulaio(){
                
        String origen = Origen.getSelectedItem().toString();
        String destino = Destino.getSelectedItem().toString();
        String horaSalida = ComboHorario.getSelectedItem().toString();
        PreparedStatement ps;
        String sql;
        try{
            sql="SELECT HoraSalida, Destino, Origen, Linea FROM rutas AS Rut "
                    + "INNER JOIN autobuses AS Aut ON Rut.AutobusAsignado = Aut.Id_autobus  "
                    + "WHERE Origen=? and Destino=? and HoraSalida =? and Fecha = CURDATE()";
            ps = con.prepareStatement(sql);
            ps.setString(1, origen);
            ps.setString(2, destino);
            ps.setString(3, horaSalida);
            
            ResultSet rs=ps.executeQuery();  
                
            if(rs.next()){
                if(rs.getRow() > 0){
                    rs=ps.executeQuery();  
                    inicializarAsientos();
                    while(rs.next()){
                        String DBHorario=rs.getString("HoraSalida");
                        String DBOrigen=rs.getString("Origen");
                        String DBDestino=rs.getString("Destino");
                        String DBLinea=rs.getString("Linea");
                        txtHorario.setText(DBHorario);
                        txtDestino.setText(DBDestino);
                        txtOrigen.setText(DBOrigen);
                        txtLinea.setText(DBLinea);
                    }                      
                }
            }else{
                JOptionPane.showMessageDialog(null, "No existe esta ruta");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }   

    }
    
    public void tablaDiseño(){        
        JTableHeader Header = TableBoletos.getTableHeader();
        Header.setBackground(new Color(42, 69, 114));
        Header.setForeground(Color.white);
        Header.setFont(new Font("Dialog", Font.BOLD, 13));
        Header.setPreferredSize(new Dimension(30, 30));
        
        TableColumnModel columnModel = TableBoletos.getColumnModel();

        columnModel.getColumn(0).setPreferredWidth(30);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(50);
        columnModel.getColumn(3).setPreferredWidth(50);
        columnModel.getColumn(4).setPreferredWidth(150);
        columnModel.getColumn(5).setPreferredWidth(150);
        columnModel.getColumn(6).setPreferredWidth(70);
        columnModel.getColumn(7).setPreferredWidth(70);
        
        //Centrar datos en tabla
        DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
        Alinear.setHorizontalAlignment(SwingConstants.CENTER);//.LEFT .RIGHT .CENTER
        TableBoletos.getColumnModel().getColumn(0).setCellRenderer(Alinear);
        TableBoletos.getColumnModel().getColumn(1).setCellRenderer(Alinear);
        TableBoletos.getColumnModel().getColumn(2).setCellRenderer(Alinear);
        TableBoletos.getColumnModel().getColumn(3).setCellRenderer(Alinear);
        TableBoletos.getColumnModel().getColumn(4).setCellRenderer(Alinear);
        TableBoletos.getColumnModel().getColumn(5).setCellRenderer(Alinear);
        TableBoletos.getColumnModel().getColumn(6).setCellRenderer(Alinear);
        TableBoletos.getColumnModel().getColumn(7).setCellRenderer(Alinear);
        TableBoletos.getColumnModel().getColumn(8).setCellRenderer(Alinear);
    }
        
    public void actualizarTabla(){
        
        DefaultTableModel tabla = new DefaultTableModel();  
        tabla.addColumn("Id");
        tabla.addColumn("Nombre");
        tabla.addColumn("Costo");
        tabla.addColumn("Asiento");
        tabla.addColumn("Origen");
        tabla.addColumn("Destino");
        tabla.addColumn("Hora");
        tabla.addColumn("Linea");
        tabla.addColumn("Fecha");
        
        PreparedStatement ps;
        String sql;
        try{
            sql="SELECT *FROM boletos";
            ps = con.prepareStatement(sql);

            ResultSet rs=ps.executeQuery();  
                
            if(rs.next()){
                if(rs.getRow() > 0){
                    rs=ps.executeQuery();  
                    while(rs.next()){
                        String DBId=rs.getString("Id_boletos");
                        String DBNombre=rs.getString("Nombre");
                        String DBCosto=rs.getString("Costo");
                        String DBAsiento=rs.getString("Asiento");
                        String DBOrigen=rs.getString("Origen");
                        String DBDestino=rs.getString("Destino");
                        String DBHora=rs.getString("Hora");
                        String DBLinea=rs.getString("Linea");
                        String DBFecha=rs.getString("Fecha");

                        tabla.addRow(new Object[]{DBId,DBNombre,DBCosto,DBAsiento, 
                            DBOrigen, DBDestino, DBHora, DBLinea, DBFecha});
                        
                    }                      
                }
            }else{
                //JOptionPane.showMessageDialog(null, "No hay Registros");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }       
        
        TableBoletos.setModel(tabla);
        tablaDiseño();

    }
    
    public void limpiarcajasTexto(){
        txtID.setText("");
        txtNombre.setText("");
        txtOrigen.setText("");
        txtDestino.setText("");
        txtHorario.setText("");
        txtCosto.setText("");
        txtLinea.setText("");
    }
    
    public void AsientoDisponibles(){

        String origen = txtOrigen.getText();
        String destino = txtDestino.getText();
        String hora = txtHorario.getText();

        String formato = jDateFecha.getDateFormatString();
        Date date = jDateFecha.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        String Fsalida = String.valueOf(sdf.format(date));
        
        String Linea = txtLinea.getText();
        PreparedStatement ps;
        String sql;

        try{
            sql="SELECT Asiento FROM boletos WHERE Origen=? and Destino=? and Hora=? and Fecha = ? and Linea=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, origen);
            ps.setString(2, destino);
            ps.setString(3, hora);
            ps.setString(4, Fsalida);
            ps.setString(5, Linea);

            ResultSet rs=ps.executeQuery();  

            if(rs.next()){
                BoxAsiento.removeAllItems();
                if(rs.getRow() > 0){
                    rs=ps.executeQuery();  
                    inicializarAsientos();
                    int x=0;
                    ArrayList<String> AsientosDisponibles = new ArrayList<String>();
                    for (int i=1; i<=24; i++){
                        AsientosDisponibles.add(String.valueOf(i)); 
                    }                   

                    while(rs.next()){
                        String Asientos=rs.getString("Asiento");
                        int AsientoReservadoActual=Integer.parseInt(AsientoDisponible);
                        int Asiento = Integer.parseInt(Asientos);
                        if(Asiento < 12){
                            if(Asiento == 1){
                                Asiento1.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 1 Rojo.png"));                                
                            }else if(Asiento == 2){
                                Asiento2.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 2 Rojo.png"));
                            }else if(Asiento==3){
                                Asiento3.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 3 Rojo.png"));
                            }else if(Asiento==4){
                                Asiento4.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 4 Rojo.png"));                                
                            }else if(Asiento == 5){
                                Asiento5.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 5 Rojo.png"));
                            }else if(Asiento==6){
                                Asiento6.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 6 Rojo.png"));
                            }else if(Asiento==7){
                                Asiento7.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 7 Rojo.png"));
                            }else if(Asiento == 8){
                                Asiento8.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 8 Rojo.png"));
                            }else if(Asiento == 9){
                                Asiento9.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 9 Rojo.png"));
                            }else if(Asiento == 10){
                                Asiento10.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 10 Rojo.png"));
                            }else if(Asiento == 11){
                                Asiento11.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 11 Rojo.png"));
                            }
                        }else if(Asiento >= 12){    
                            if(Asiento == 12){
                                Asiento12.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 12 Rojo.png"));
                            }else if(Asiento == 13){
                                Asiento13.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 13 Rojo.png"));
                            }else if(Asiento == 14){
                                Asiento14.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 14 Rojo.png"));
                            }else if(Asiento == 15){
                                Asiento15.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 15 Rojo.png"));
                            }else if(Asiento == 16){
                                Asiento16.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 16 Rojo.png"));
                            }else  if(Asiento == 17){
                                Asiento17.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 17 Rojo.png"));
                            }else if(Asiento == 18){
                                Asiento18.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 18 Rojo.png"));
                            }else if(Asiento == 19){
                                Asiento19.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 19 Rojo.png"));
                            }else if(Asiento == 20){
                                Asiento20.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 20 Rojo.png"));
                            }else if(Asiento == 21){
                                Asiento21.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 21 Rojo.png"));
                            }else if(Asiento == 22){
                                Asiento22.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 22 Rojo.png"));
                            }else if(Asiento == 23){
                                Asiento23.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 23 Rojo.png"));
                            }else if(Asiento == 24){
                                Asiento24.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 24 Rojo.png"));
                            }
                        }
                        if(Asiento != AsientoReservadoActual){
                            AsientosDisponibles.remove(Asientos);
                        }
                        x++;               
                    }
                    String[] miarray = new String[AsientosDisponibles.size()];
                    miarray = AsientosDisponibles.toArray(miarray);
                    for(String s : miarray)
                      BoxAsiento.addItem(s);
                    }

            }else{
                System.out.print("No hay registros aun");
                for(int i=1; i<=24; i++){
                    BoxAsiento.addItem(String.valueOf(i));
                }
                inicializarAsientos();
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }   
    }

    public Boleto() {
        initComponents();
        this.setLocationRelativeTo(null);
        llenarComboBoxOrigenDestino();
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
        btnAutobus = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnRutas = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnConductores = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelNombre1 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabelAsiento = new javax.swing.JLabel();
        txtOrigen = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabelOrigen = new javax.swing.JLabel();
        jLabelDestino = new javax.swing.JLabel();
        txtDestino = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabelHorario = new javax.swing.JLabel();
        txtLinea = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabelHorario1 = new javax.swing.JLabel();
        jLabelHorario2 = new javax.swing.JLabel();
        jDateFecha = new com.toedter.calendar.JDateChooser();
        BotonGuardar = new javax.swing.JPanel();
        GUARDAR = new javax.swing.JLabel();
        BotonEliminar = new javax.swing.JPanel();
        Eliminar = new javax.swing.JLabel();
        BotonModificar = new javax.swing.JPanel();
        Modificar = new javax.swing.JLabel();
        BoxFiltro = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableBoletos = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        BoxAsiento = new javax.swing.JComboBox<>();
        txtBuscar = new javax.swing.JTextField();
        label = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JLabel();
        Asiento1 = new javax.swing.JLabel();
        Asiento2 = new javax.swing.JLabel();
        Asiento3 = new javax.swing.JLabel();
        Asiento4 = new javax.swing.JLabel();
        Asiento5 = new javax.swing.JLabel();
        Asiento6 = new javax.swing.JLabel();
        Asiento7 = new javax.swing.JLabel();
        Asiento8 = new javax.swing.JLabel();
        Asiento9 = new javax.swing.JLabel();
        Asiento10 = new javax.swing.JLabel();
        Asiento11 = new javax.swing.JLabel();
        Asiento12 = new javax.swing.JLabel();
        Asiento13 = new javax.swing.JLabel();
        Asiento14 = new javax.swing.JLabel();
        Asiento15 = new javax.swing.JLabel();
        Asiento16 = new javax.swing.JLabel();
        Asiento17 = new javax.swing.JLabel();
        Asiento18 = new javax.swing.JLabel();
        Asiento19 = new javax.swing.JLabel();
        Asiento20 = new javax.swing.JLabel();
        Asiento21 = new javax.swing.JLabel();
        Asiento22 = new javax.swing.JLabel();
        Asiento23 = new javax.swing.JLabel();
        Asiento24 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        Volante = new javax.swing.JLabel();
        VolanteRojo = new javax.swing.JLabel();
        Origen = new javax.swing.JComboBox<>();
        Destino = new javax.swing.JComboBox<>();
        BotonCargar = new javax.swing.JPanel();
        Cargar = new javax.swing.JLabel();
        ComboHorario = new javax.swing.JComboBox<>();
        btnCargar = new javax.swing.JLabel();
        txtHorario = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();

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

        btnAutobus.setFont(new java.awt.Font("Roboto Medium", 0, 16)); // NOI18N
        btnAutobus.setForeground(new java.awt.Color(255, 255, 255));
        btnAutobus.setText("Autobuses");
        btnAutobus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelMenu.add(btnAutobus, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 345, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Bus.png"))); // NOI18N
        jPanelMenu.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 334, -1, -1));

        jPanel4.setBackground(new java.awt.Color(42, 69, 114));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 87, 136), 30, true));
        jPanel4.setForeground(new java.awt.Color(54, 87, 136));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Roboto Medium", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Boletos");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 0, 90, 30));

        jPanelMenu.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 259, 98, 30));

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
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 174, -1, -1));

        jLabel14.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jLabel14.setText("ID:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(374, 260, -1, -1));

        txtID.setEditable(false);
        txtID.setBackground(new java.awt.Color(255, 255, 255));
        txtID.setForeground(new java.awt.Color(51, 51, 51));
        txtID.setBorder(null);
        jPanel1.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 284, 100, 25));

        jLabel13.setBackground(new java.awt.Color(204, 204, 204));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Caja TextoInabilitada 114.png"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(374, 281, 114, 30));

        txtNombre.setToolTipText("");
        txtNombre.setBorder(null);
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(536, 284, 210, 25));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Contorno Caja Texto222.png"))); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(526, 281, 222, 30));

        jLabelNombre.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jLabelNombre.setText("Nombre:");
        jPanel1.add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(526, 260, -1, -1));

        jLabelNombre1.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jLabelNombre1.setText("Costo:");
        jPanel1.add(jLabelNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(782, 260, -1, -1));

        txtCosto.setBorder(null);
        jPanel1.add(txtCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(792, 284, 100, 25));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Caja Texto114.png"))); // NOI18N
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(782, 281, 114, 30));

        jLabelAsiento.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jLabelAsiento.setText("Asiento:");
        jPanel1.add(jLabelAsiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 260, -1, -1));

        txtOrigen.setBorder(null);
        jPanel1.add(txtOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 378, 123, 25));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Caja Texto136.png"))); // NOI18N
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 375, 136, 30));

        jLabelOrigen.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jLabelOrigen.setText("Origen:");
        jPanel1.add(jLabelOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 354, -1, -1));

        jLabelDestino.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jLabelDestino.setText("Destino:");
        jPanel1.add(jLabelDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 354, -1, -1));

        txtDestino.setBorder(null);
        jPanel1.add(txtDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 378, 114, 25));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Caja Texto127.png"))); // NOI18N
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 375, 127, 30));

        jLabelHorario.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jLabelHorario.setText("Horario:");
        jPanel1.add(jLabelHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(686, 354, -1, -1));

        txtLinea.setBorder(null);
        jPanel1.add(txtLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(835, 378, 100, 25));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Caja Texto114.png"))); // NOI18N
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(825, 375, 114, 30));

        jLabelHorario1.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jLabelHorario1.setText("Linea:");
        jPanel1.add(jLabelHorario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(825, 354, -1, -1));

        jLabelHorario2.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jLabelHorario2.setText("Fecha:");
        jPanel1.add(jLabelHorario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 354, -1, -1));

        jDateFecha.setBackground(new java.awt.Color(255, 255, 255));
        jDateFecha.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(jDateFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 375, 122, 30));

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

        jPanel1.add(BotonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(489, 447, 120, 35));

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

        jPanel1.add(BotonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(799, 447, 120, 35));

        BoxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "ID", "Nombre", "Costo", "Asiento", "Destino", "Origen", "Hora", "Linea", "Fecha" }));
        jPanel1.add(BoxFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 520, 110, 30));

        jScrollPane1.setBorder(null);

        TableBoletos.setBackground(new java.awt.Color(231, 247, 253));
        TableBoletos.setModel(new javax.swing.table.DefaultTableModel(
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
        TableBoletos.setRowHeight(23);
        jScrollPane1.setViewportView(TableBoletos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 558, 817, 150));

        jLabel21.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        jLabel21.setText("Boletos");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 529, -1, -1));

        BoxAsiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));
        BoxAsiento.setBorder(null);
        jPanel1.add(BoxAsiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 281, 114, 30));

        txtBuscar.setBorder(null);
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 522, 188, 25));

        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Caja Texto200.png"))); // NOI18N
        jPanel1.add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 520, 200, 30));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Buscar.png"))); // NOI18N
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 520, -1, -1));

        Asiento1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Asientos/Asiento 1.png"))); // NOI18N
        jPanel1.add(Asiento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 182, -1, -1));

        Asiento2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Asientos/Asiento 2.png"))); // NOI18N
        jPanel1.add(Asiento2, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 59, -1, -1));

        Asiento3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Asientos/Asiento 3.png"))); // NOI18N
        jPanel1.add(Asiento3, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 23, -1, -1));

        Asiento4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Asientos/Asiento 4.png"))); // NOI18N
        jPanel1.add(Asiento4, new org.netbeans.lib.awtextra.AbsoluteConstraints(576, 182, -1, -1));

        Asiento5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Asientos/Asiento 5.png"))); // NOI18N
        jPanel1.add(Asiento5, new org.netbeans.lib.awtextra.AbsoluteConstraints(576, 59, -1, -1));

        Asiento6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Asientos/Asiento 6.png"))); // NOI18N
        jPanel1.add(Asiento6, new org.netbeans.lib.awtextra.AbsoluteConstraints(576, 23, -1, -1));

        Asiento7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Asientos/Asiento 7.png"))); // NOI18N
        jPanel1.add(Asiento7, new org.netbeans.lib.awtextra.AbsoluteConstraints(633, 182, -1, -1));

        Asiento8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Asientos/Asiento 8.png"))); // NOI18N
        jPanel1.add(Asiento8, new org.netbeans.lib.awtextra.AbsoluteConstraints(633, 59, -1, -1));

        Asiento9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Asientos/Asiento 9.png"))); // NOI18N
        jPanel1.add(Asiento9, new org.netbeans.lib.awtextra.AbsoluteConstraints(633, 23, -1, -1));

        Asiento10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Asientos/Asiento 10.png"))); // NOI18N
        jPanel1.add(Asiento10, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 182, -1, -1));

        Asiento11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Asientos/Asiento 11.png"))); // NOI18N
        jPanel1.add(Asiento11, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 59, -1, -1));

        Asiento12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Asientos/Asiento 12.png"))); // NOI18N
        jPanel1.add(Asiento12, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 23, -1, -1));

        Asiento13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Asientos/Asiento 13.png"))); // NOI18N
        jPanel1.add(Asiento13, new org.netbeans.lib.awtextra.AbsoluteConstraints(748, 182, -1, -1));

        Asiento14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Asientos/Asiento 14.png"))); // NOI18N
        jPanel1.add(Asiento14, new org.netbeans.lib.awtextra.AbsoluteConstraints(748, 59, -1, -1));

        Asiento15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Asientos/Asiento 15.png"))); // NOI18N
        jPanel1.add(Asiento15, new org.netbeans.lib.awtextra.AbsoluteConstraints(748, 23, -1, -1));

        Asiento16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Asientos/Asiento 16.png"))); // NOI18N
        jPanel1.add(Asiento16, new org.netbeans.lib.awtextra.AbsoluteConstraints(805, 182, -1, -1));

        Asiento17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Asientos/Asiento 17.png"))); // NOI18N
        jPanel1.add(Asiento17, new org.netbeans.lib.awtextra.AbsoluteConstraints(805, 59, -1, -1));

        Asiento18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Asientos/Asiento 18.png"))); // NOI18N
        jPanel1.add(Asiento18, new org.netbeans.lib.awtextra.AbsoluteConstraints(805, 23, -1, -1));

        Asiento19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Asientos/Asiento 19.png"))); // NOI18N
        jPanel1.add(Asiento19, new org.netbeans.lib.awtextra.AbsoluteConstraints(862, 182, -1, -1));

        Asiento20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Asientos/Asiento 20.png"))); // NOI18N
        jPanel1.add(Asiento20, new org.netbeans.lib.awtextra.AbsoluteConstraints(862, 59, -1, -1));

        Asiento21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Asientos/Asiento 21.png"))); // NOI18N
        jPanel1.add(Asiento21, new org.netbeans.lib.awtextra.AbsoluteConstraints(862, 23, -1, -1));

        Asiento22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Asientos/Asiento 22.png"))); // NOI18N
        jPanel1.add(Asiento22, new org.netbeans.lib.awtextra.AbsoluteConstraints(919, 182, -1, -1));

        Asiento23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Asientos/Asiento 23.png"))); // NOI18N
        jPanel1.add(Asiento23, new org.netbeans.lib.awtextra.AbsoluteConstraints(919, 59, -1, -1));

        Asiento24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Asientos/Asiento 24.png"))); // NOI18N
        jPanel1.add(Asiento24, new org.netbeans.lib.awtextra.AbsoluteConstraints(919, 23, -1, -1));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Asientos/Pasillo.png"))); // NOI18N
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 111, -1, -1));

        Volante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Asientos/Volante.png"))); // NOI18N
        jPanel1.add(Volante, new org.netbeans.lib.awtextra.AbsoluteConstraints(442, 182, -1, -1));

        VolanteRojo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Asientos/VolanteRojo.png"))); // NOI18N
        jPanel1.add(VolanteRojo, new org.netbeans.lib.awtextra.AbsoluteConstraints(442, 182, -1, -1));

        Origen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Origen --" }));
        Origen.setDoubleBuffered(true);
        Origen.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                OrigenItemStateChanged(evt);
            }
        });
        jPanel1.add(Origen, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 140, 30));

        Destino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Destino --" }));
        jPanel1.add(Destino, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 140, 30));

        BotonCargar.setBackground(new java.awt.Color(54, 87, 136));

        Cargar.setBackground(new java.awt.Color(54, 87, 136));
        Cargar.setFont(new java.awt.Font("Roboto Medium", 1, 16)); // NOI18N
        Cargar.setForeground(new java.awt.Color(255, 255, 255));
        Cargar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Cargar.setText("Buscar");
        Cargar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout BotonCargarLayout = new javax.swing.GroupLayout(BotonCargar);
        BotonCargar.setLayout(BotonCargarLayout);
        BotonCargarLayout.setHorizontalGroup(
            BotonCargarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Cargar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        BotonCargarLayout.setVerticalGroup(
            BotonCargarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Cargar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.add(BotonCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 120, 35));

        ComboHorario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Horario --" }));
        ComboHorario.setBorder(null);
        ComboHorario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboHorarioItemStateChanged(evt);
            }
        });
        jPanel1.add(ComboHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 140, 30));

        btnCargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Recargar.png"))); // NOI18N
        jPanel1.add(btnCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, -1, -1));

        txtHorario.setBorder(null);
        jPanel1.add(txtHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(697, 378, 100, 25));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Caja Texto114.png"))); // NOI18N
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(686, 375, 114, 30));

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

    private void ComboHorarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboHorarioItemStateChanged
    }//GEN-LAST:event_ComboHorarioItemStateChanged

    private void OrigenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_OrigenItemStateChanged
    }//GEN-LAST:event_OrigenItemStateChanged

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
    
        if(!BoxFiltro.getSelectedItem().toString().equals("Todos")){
            if(!txtBuscar.getText().equals("")){

                DefaultTableModel tabla = new DefaultTableModel();  
                tabla.addColumn("Id");
                tabla.addColumn("Nombre");
                tabla.addColumn("Costo");
                tabla.addColumn("Asiento");
                tabla.addColumn("Origen");
                tabla.addColumn("Destino");
                tabla.addColumn("Hora");
                tabla.addColumn("Linea");
                tabla.addColumn("Fecha");

                String Campo = BoxFiltro.getSelectedItem().toString();

                if(BoxFiltro.getSelectedItem().toString().equals("ID")){
                    Campo = "Id_boletos";
                }

                String Dato = txtBuscar.getText();
                PreparedStatement ps;
                String sql;
                try{
                    sql="SELECT *FROM boletos WHERE " + Campo + " = ?";
                    ps = con.prepareStatement(sql);
                    ps.setString(1, Dato);

                    ResultSet rs=ps.executeQuery();  

                    if(rs.next()){
                        if(rs.getRow() > 0){
                            rs=ps.executeQuery();  
                            while(rs.next()){
                                String DBId=rs.getString("Id_boletos");
                                String DBNombre=rs.getString("Nombre");
                                String DBCosto=rs.getString("Costo");
                                String DBAsiento=rs.getString("Asiento");
                                String DBOrigen=rs.getString("Origen");
                                String DBDestino=rs.getString("Destino");
                                String DBHora=rs.getString("Hora");
                                String DBLinea=rs.getString("Linea");
                                String DBFecha=rs.getString("Fecha");

                                tabla.addRow(new Object[]{DBId,DBNombre,DBCosto,DBAsiento, 
                                    DBOrigen, DBDestino, DBHora, DBLinea, DBFecha});

                            }                      
                        }
                        TableBoletos.setModel(tabla);
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
            limpiarcajasTexto();
            inicializarAsientos();
            txtBuscar.setText("");
        }
    }//GEN-LAST:event_btnBuscarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]){
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
            java.util.logging.Logger.getLogger(Boleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Boleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Boleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Boleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Boleto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel Asiento1;
    public javax.swing.JLabel Asiento10;
    public javax.swing.JLabel Asiento11;
    public javax.swing.JLabel Asiento12;
    public javax.swing.JLabel Asiento13;
    public javax.swing.JLabel Asiento14;
    public javax.swing.JLabel Asiento15;
    public javax.swing.JLabel Asiento16;
    public javax.swing.JLabel Asiento17;
    public javax.swing.JLabel Asiento18;
    public javax.swing.JLabel Asiento19;
    public javax.swing.JLabel Asiento2;
    public javax.swing.JLabel Asiento20;
    public javax.swing.JLabel Asiento21;
    public javax.swing.JLabel Asiento22;
    public javax.swing.JLabel Asiento23;
    public javax.swing.JLabel Asiento24;
    public javax.swing.JLabel Asiento3;
    public javax.swing.JLabel Asiento4;
    public javax.swing.JLabel Asiento5;
    public javax.swing.JLabel Asiento6;
    public javax.swing.JLabel Asiento7;
    public javax.swing.JLabel Asiento8;
    public javax.swing.JLabel Asiento9;
    private javax.swing.JPanel BotonCargar;
    private javax.swing.JPanel BotonEliminar;
    private javax.swing.JPanel BotonGuardar;
    private javax.swing.JPanel BotonModificar;
    public javax.swing.JComboBox<String> BoxAsiento;
    public javax.swing.JComboBox<String> BoxFiltro;
    public javax.swing.JLabel Cargar;
    public javax.swing.JComboBox<String> ComboHorario;
    public javax.swing.JComboBox<String> Destino;
    public javax.swing.JLabel Eliminar;
    public javax.swing.JLabel GUARDAR;
    public javax.swing.JLabel Modificar;
    public javax.swing.JComboBox<String> Origen;
    public javax.swing.JTable TableBoletos;
    private javax.swing.JLabel Volante;
    private javax.swing.JLabel VolanteRojo;
    public javax.swing.JLabel btnAutobus;
    public javax.swing.JLabel btnBuscar;
    public javax.swing.JLabel btnCargar;
    public javax.swing.JLabel btnConductores;
    public javax.swing.JLabel btnInicio;
    public javax.swing.JLabel btnRutas;
    public com.toedter.calendar.JDateChooser jDateFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelAsiento;
    private javax.swing.JLabel jLabelDestino;
    private javax.swing.JLabel jLabelHorario;
    private javax.swing.JLabel jLabelHorario1;
    private javax.swing.JLabel jLabelHorario2;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelNombre1;
    private javax.swing.JLabel jLabelOrigen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label;
    public javax.swing.JTextField txtBuscar;
    public javax.swing.JTextField txtCosto;
    public javax.swing.JTextField txtDestino;
    public javax.swing.JTextField txtHorario;
    public javax.swing.JTextField txtID;
    public javax.swing.JTextField txtLinea;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtOrigen;
    // End of variables declaration//GEN-END:variables
}
