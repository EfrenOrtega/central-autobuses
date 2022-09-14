package model;

import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;


public class modelBoletos {

    private JTextField textOrigen;
    private JTextField textDestino;
    private JTextField textHora;
    private JTextField textLinea;
    private JDateChooser jDateFecha;
    private JTable TableBoletos;
    private JTextField txtID;
    private JTextField txtNombre;
    private JTextField txtCosto;

    private JComboBox Destino;
    private JComboBox Origen;
    private JComboBox BoxAsientos;
    private JComboBox ComboHorario;
    private JLabel Asiento1;
    private JLabel Asiento2;
    private JLabel Asiento3;
    private JLabel Asiento4;
    private JLabel Asiento5;
    private JLabel Asiento6;
    private JLabel Asiento7;
    private JLabel Asiento8;
    private JLabel Asiento9;
    private JLabel Asiento10;
    private JLabel Asiento11;
    private JLabel Asiento12;
    private JLabel Asiento13;
    private JLabel Asiento14;
    private JLabel Asiento15;
    private JLabel Asiento16;
    private JLabel Asiento17;
    private JLabel Asiento18;
    private JLabel Asiento19;
    private JLabel Asiento20;
    private JLabel Asiento21;
    private JLabel Asiento22;
    private JLabel Asiento23;
    private JLabel Asiento24;
    
    String AsientoDisponible;

    public JTextField getTextOrigen() {
        return textOrigen;
    }

    public void setTextOrigen(JTextField textOrigen) {
        this.textOrigen = textOrigen;
    }

    public JTextField getTextDestino() {
        return textDestino;
    }

    public void setTextDestino(JTextField textDestino) {
        this.textDestino = textDestino;
    }

    public JTextField getTextHora() {
        return textHora;
    }

    public void setTextHora(JTextField textHora) {
        this.textHora = textHora;
    }  

    public JTextField getTextLinea() {
        return textLinea;
    }

    public void setTextLinea(JTextField textLinea) {
        this.textLinea = textLinea;
    }

    public JTable getTableBoletos() {
        return TableBoletos;
    }

    public void setTableBoletos(JTable TableBoletos) {
        this.TableBoletos = TableBoletos;
    }

    public JTextField getTxtID() {
        return txtID;
    }

    public void setTxtID(JTextField txtID) {
        this.txtID = txtID;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtCosto() {
        return txtCosto;
    }

    public void setTxtCosto(JTextField txtCosto) {
        this.txtCosto = txtCosto;
    }

    public JDateChooser getjDateFecha() {
        return jDateFecha;
    }

    public void setjDateFecha(JDateChooser jDateFecha) {
        this.jDateFecha = jDateFecha;
    }

    public JComboBox getBoxAsientos() {
        return BoxAsientos;
    }

    public void setBoxAsientos(JComboBox BoxAsientos) {
        this.BoxAsientos = BoxAsientos;
    }   
    
    
    public JLabel getAsiento1() {
        return Asiento1;
    }

    public void setAsiento1(JLabel Asiento1) {
        this.Asiento1 = Asiento1;
    }

    public JLabel getAsiento2() {
        return Asiento2;
    }

    public void setAsiento2(JLabel Asiento2) {
        this.Asiento2 = Asiento2;
    }

    public JLabel getAsiento3() {
        return Asiento3;
    }

    public void setAsiento3(JLabel Asiento3) {
        this.Asiento3 = Asiento3;
    }

    public JLabel getAsiento4() {
        return Asiento4;
    }

    public void setAsiento4(JLabel Asiento4) {
        this.Asiento4 = Asiento4;
    }

    public JLabel getAsiento5() {
        return Asiento5;
    }

    public void setAsiento5(JLabel Asiento5) {
        this.Asiento5 = Asiento5;
    }

    public JLabel getAsiento6() {
        return Asiento6;
    }

    public void setAsiento6(JLabel Asiento6) {
        this.Asiento6 = Asiento6;
    }

    public JLabel getAsiento7() {
        return Asiento7;
    }

    public void setAsiento7(JLabel Asiento7) {
        this.Asiento7 = Asiento7;
    }

    public JLabel getAsiento8() {
        return Asiento8;
    }

    public void setAsiento8(JLabel Asiento8) {
        this.Asiento8 = Asiento8;
    }

    public JLabel getAsiento9() {
        return Asiento9;
    }

    public void setAsiento9(JLabel Asiento9) {
        this.Asiento9 = Asiento9;
    }

    public JLabel getAsiento10() {
        return Asiento10;
    }

    public void setAsiento10(JLabel Asiento10) {
        this.Asiento10 = Asiento10;
    }

    public JLabel getAsiento11() {
        return Asiento11;
    }

    public void setAsiento11(JLabel Asiento11) {
        this.Asiento11 = Asiento11;
    }

    public JLabel getAsiento12() {
        return Asiento12;
    }

    public void setAsiento12(JLabel Asiento12) {
        this.Asiento12 = Asiento12;
    }

    public JLabel getAsiento13() {
        return Asiento13;
    }

    public void setAsiento13(JLabel Asiento13) {
        this.Asiento13 = Asiento13;
    }

    public JLabel getAsiento14() {
        return Asiento14;
    }

    public void setAsiento14(JLabel Asiento14) {
        this.Asiento14 = Asiento14;
    }

    public JLabel getAsiento15() {
        return Asiento15;
    }

    public void setAsiento15(JLabel Asiento15) {
        this.Asiento15 = Asiento15;
    }

    public JLabel getAsiento16() {
        return Asiento16;
    }

    public void setAsiento16(JLabel Asiento16) {
        this.Asiento16 = Asiento16;
    }

    public JLabel getAsiento17() {
        return Asiento17;
    }

    public void setAsiento17(JLabel Asiento17) {
        this.Asiento17 = Asiento17;
    }

    public JLabel getAsiento18() {
        return Asiento18;
    }

    public void setAsiento18(JLabel Asiento18) {
        this.Asiento18 = Asiento18;
    }

    public JLabel getAsiento19() {
        return Asiento19;
    }

    public void setAsiento19(JLabel Asiento19) {
        this.Asiento19 = Asiento19;
    }

    public JLabel getAsiento20() {
        return Asiento20;
    }

    public void setAsiento20(JLabel Asiento20) {
        this.Asiento20 = Asiento20;
    }

    public JLabel getAsiento21() {
        return Asiento21;
    }

    public void setAsiento21(JLabel Asiento21) {
        this.Asiento21 = Asiento21;
    }

    public JLabel getAsiento22() {
        return Asiento22;
    }

    public void setAsiento22(JLabel Asiento22) {
        this.Asiento22 = Asiento22;
    }

    public JLabel getAsiento23() {
        return Asiento23;
    }

    public void setAsiento23(JLabel Asiento23) {
        this.Asiento23 = Asiento23;
    }

    public JLabel getAsiento24() {
        return Asiento24;
    }

    public void setAsiento24(JLabel Asiento24) {
        this.Asiento24 = Asiento24;
    }

    public JComboBox getComboHorario() {
        return ComboHorario;
    }

    public void setComboHorario(JComboBox ComboHorario) {
        this.ComboHorario = ComboHorario;
    }

    public JComboBox getDestino() {
        return Destino;
    }

    public void setDestino(JComboBox Destino) {
        this.Destino = Destino;
    }

    public JComboBox getOrigen() {
        return Origen;
    }

    public void setOrigen(JComboBox Origen) {
        this.Origen = Origen;
    }

    ConexionMySQL cn = new ConexionMySQL();
    Connection con = cn.getConexion();

    public ArrayList<String[]> CargarRegistros() {

        ArrayList<String[]> objectData = new ArrayList<String[]>();

        PreparedStatement ps;
        String sql;
        try {
            sql = "SELECT *FROM boletos";
            ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                if (rs.getRow() > 0) {
                    rs = ps.executeQuery();
                    while (rs.next()) {

                        objectData.add(new String[]{
                            rs.getString("Id_boletos"),
                            rs.getString("Nombre"),
                            rs.getString("Costo"),
                            rs.getString("Asiento"),
                            rs.getString("Origen"),
                            rs.getString("Destino"),
                            rs.getString("Hora"),
                            rs.getString("Linea"),
                            rs.getString("Fecha")
                        });

                    }
                }
            } else {
                //JOptionPane.showMessageDialog(null, "No hay Registros");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }

        return objectData;
    }

    public boolean ActualizarRegistro(String nombre, Float costo, int Asiento, String Origen, String Destino, String Horario, String Linea, String Fsalida, int Id) {
        PreparedStatement ps;
        String sql;

        try {
            sql = "UPDATE boletos SET Nombre=?, Costo=?, Asiento=?, "
                    + "Origen=?, Destino=?, Hora=?, Linea=?, Fecha=?  WHERE Id_boletos=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setFloat(2, costo);
            ps.setInt(3, Asiento);
            ps.setString(4, Origen);
            ps.setString(5, Destino);
            ps.setString(6, Horario);
            ps.setString(7, Linea);
            ps.setString(8, Fsalida);
            ps.setInt(9, Id);

            ps.executeUpdate();

            //actualizarTabla();
            //AsientoDisponibles();
            //limpiarcajasTexto();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
            return false;
        }
    }

    public boolean EliminarRegistro(int Id) {
        PreparedStatement ps;
        String sql;

        try {
            sql = "DELETE FROM boletos WHERE id_boletos=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, Id);
            ps.executeUpdate();
            //actualizarTabla();
            //limpiarcajasTexto();
            this.inicializarAsientos();
            this.AsientoDisponibles();
            JOptionPane.showMessageDialog(null, "Registro Eliminado");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
            return false;
        }
    }

    public boolean GuardarRegistro(String nombre, Float costo, int Asiento, String Origen, String Destino, String Horario, String Linea, String Fsalida) {
        PreparedStatement ps;
        String sql;

        try {
            sql = "INSERT INTO Boletos(Nombre, Costo, Asiento, Origen, Destino, Hora, Linea, "
                    + "Fecha) values(?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setFloat(2, costo);
            ps.setInt(3, Asiento);
            ps.setString(4, Origen);
            ps.setString(5, Destino);
            ps.setString(6, Horario);
            ps.setString(7, Linea);
            ps.setString(8, Fsalida);
            ps.executeUpdate();

            if ((!this.Destino.getSelectedItem().toString().equals("-- Destino --"))
                    || (!this.Origen.getSelectedItem().toString().equals("-- Origen --"))) {
                this.cargar();
            } else {
                AsientoDisponible = this.BoxAsientos.getSelectedItem().toString();
                AsientoDisponibles();
            }

            //limpiarcajasTexto();
            //actualizarTabla();
            JOptionPane.showMessageDialog(null, "Registro nuevo agregado");
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
            return false;
        }
    }

    public void cargar() {
        this.BoxAsientos.removeAllItems();
        //limpiarcajasTexto();
        String origen = this.Origen.getSelectedItem().toString();
        String destino = this.Destino.getSelectedItem().toString();
        String hora = this.ComboHorario.getSelectedItem().toString();
        PreparedStatement ps;
        String sql;
        
        try {
            sql = "SELECT Asiento FROM boletos WHERE Origen=? and Destino=? and Hora=? and Fecha = CURDATE()";
            ps = con.prepareStatement(sql);
            ps.setString(1, origen);
            ps.setString(2, destino);
            ps.setString(3, hora);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                this.BoxAsientos.removeAllItems();
                if (rs.getRow() > 0) {
                    rs = ps.executeQuery();
                    inicializarAsientos();
                    
                    llenarFormulaio();
                    int x = 0;
                    ArrayList<String> AsientosDisponibles = new ArrayList<String>();
                    for (int i = 1; i <= 24; i++) {
                        AsientosDisponibles.add(String.valueOf(i));
                    }
                    System.out.print("H");
                    while (rs.next()) {
                        String Asientos = rs.getString("Asiento");
                        int Asiento = Integer.parseInt(Asientos);
                        if (Asiento < 12) {
                            if (Asiento == 1) {                                
                                Asiento1.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 1 Rojo.png"));
                            } else if (Asiento == 2) {
                                Asiento2.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 2 Rojo.png"));
                            } else if (Asiento == 3) {
                                Asiento3.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 3 Rojo.png"));
                            } else if (Asiento == 4) {
                                Asiento4.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 4 Rojo.png"));
                            } else if (Asiento == 5) {
                                Asiento5.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 5 Rojo.png"));
                            } else if (Asiento == 6) {
                                Asiento6.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 6 Rojo.png"));
                            } else if (Asiento == 7) {
                                Asiento7.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 7 Rojo.png"));
                            } else if (Asiento == 8) {
                                Asiento8.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 8 Rojo.png"));
                            } else if (Asiento == 9) {
                                Asiento9.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 9 Rojo.png"));
                            } else if (Asiento == 10) {
                                Asiento10.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 10 Rojo.png"));
                            } else if (Asiento == 11) {
                                Asiento11.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 11 Rojo.png"));
                            }
                        } else if (Asiento >= 12) {
                            if (Asiento == 12) {
                                Asiento12.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 12 Rojo.png"));
                            } else if (Asiento == 13) {
                                Asiento13.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 13 Rojo.png"));
                            } else if (Asiento == 14) {
                                Asiento14.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 14 Rojo.png"));
                            } else if (Asiento == 15) {
                                Asiento15.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 15 Rojo.png"));
                            } else if (Asiento == 16) {
                                Asiento16.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 16 Rojo.png"));
                            } else if (Asiento == 17) {
                                Asiento17.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 17 Rojo.png"));
                            } else if (Asiento == 18) {
                                Asiento18.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 18 Rojo.png"));
                            } else if (Asiento == 19) {
                                Asiento19.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 19 Rojo.png"));
                            } else if (Asiento == 20) {
                                Asiento20.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 20 Rojo.png"));
                            } else if (Asiento == 21) {
                                Asiento21.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 21 Rojo.png"));
                            } else if (Asiento == 22) {
                                Asiento22.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 22 Rojo.png"));
                            } else if (Asiento == 23) {
                                Asiento23.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 23 Rojo.png"));
                            } else if (Asiento == 24) {
                                Asiento24.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 24 Rojo.png"));
                            }
                        }

                        AsientosDisponibles.remove(Asientos);
                        x++;
                    }
                    String[] miarray = new String[AsientosDisponibles.size()];
                    miarray = AsientosDisponibles.toArray(miarray);
                    for (String s : miarray) {
                        this.BoxAsientos.addItem(s);
                    }
                }

            } else {
                for (int i = 1; i <= 24; i++) {
                    this.BoxAsientos.addItem(String.valueOf(i));
                }
                inicializarAsientos();
                //limpiarcajasTexto();
                llenarFormulaio();

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión: " + e.getMessage());
        }
    }

    public void inicializarAsientos() {
        this.Asiento1.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 1.png"));
        this.Asiento2.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 2.png"));
        this.Asiento3.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 3.png"));
        this.Asiento4.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 4.png"));
        this.Asiento5.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 5.png"));
        this.Asiento6.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 6.png"));
        this.Asiento7.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 7.png"));
        this.Asiento8.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 8.png"));
        this.Asiento9.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 9.png"));
        this.Asiento10.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 10.png"));
        this.Asiento11.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 11.png"));
        this.Asiento12.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 12.png"));
        this.Asiento13.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 13.png"));
        this.Asiento14.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 14.png"));
        this.Asiento15.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 15.png"));
        this.Asiento16.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 16.png"));
        this.Asiento17.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 17.png"));
        this.Asiento18.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 18.png"));
        this.Asiento19.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 19.png"));
        this.Asiento20.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 20.png"));
        this.Asiento21.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 21.png"));
        this.Asiento22.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 22.png"));
        this.Asiento23.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 23.png"));
        this.Asiento24.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 24.png"));
    }

    public void AsientoDisponibles() {

        String origen = this.textOrigen.getText();
        String destino = this.textDestino.getText();
        String hora = this.textHora.getText();

        String formato = jDateFecha.getDateFormatString();
        Date date = jDateFecha.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        String Fsalida = String.valueOf(sdf.format(date));

        String Linea = this.textLinea.getText();
        PreparedStatement ps;
        String sql;

        try {
            sql = "SELECT Asiento FROM boletos WHERE Origen=? and Destino=? and Hora=? and Fecha = ? and Linea=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, origen);
            ps.setString(2, destino);
            ps.setString(3, hora);
            ps.setString(4, Fsalida);
            ps.setString(5, Linea);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                this.BoxAsientos.removeAllItems();
                if (rs.getRow() > 0) {
                    rs = ps.executeQuery();
                    inicializarAsientos();
                    int x = 0;
                    ArrayList<String> AsientosDisponibles = new ArrayList<String>();
                    for (int i = 1; i <= 24; i++) {
                        AsientosDisponibles.add(String.valueOf(i));
                    }

                    while (rs.next()) {
                        String Asientos = rs.getString("Asiento");
                        int AsientoReservadoActual = Integer.parseInt(AsientoDisponible);
                        int Asiento = Integer.parseInt(Asientos);
                        if (Asiento < 12) {
                            if (Asiento == 1) {
                                Asiento1.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 1 Rojo.png"));
                            } else if (Asiento == 2) {
                                Asiento2.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 2 Rojo.png"));
                            } else if (Asiento == 3) {
                                Asiento3.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 3 Rojo.png"));
                            } else if (Asiento == 4) {
                                Asiento4.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 4 Rojo.png"));
                            } else if (Asiento == 5) {
                                Asiento5.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 5 Rojo.png"));
                            } else if (Asiento == 6) {
                                Asiento6.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 6 Rojo.png"));
                            } else if (Asiento == 7) {
                                Asiento7.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 7 Rojo.png"));
                            } else if (Asiento == 8) {
                                Asiento8.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 8 Rojo.png"));
                            } else if (Asiento == 9) {
                                Asiento9.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 9 Rojo.png"));
                            } else if (Asiento == 10) {
                                Asiento10.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 10 Rojo.png"));
                            } else if (Asiento == 11) {
                                Asiento11.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 11 Rojo.png"));
                            }
                        } else if (Asiento >= 12) {
                            if (Asiento == 12) {
                                Asiento12.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 12 Rojo.png"));
                            } else if (Asiento == 13) {
                                Asiento13.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 13 Rojo.png"));
                            } else if (Asiento == 14) {
                                Asiento14.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 14 Rojo.png"));
                            } else if (Asiento == 15) {
                                Asiento15.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 15 Rojo.png"));
                            } else if (Asiento == 16) {
                                Asiento16.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 16 Rojo.png"));
                            } else if (Asiento == 17) {
                                Asiento17.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 17 Rojo.png"));
                            } else if (Asiento == 18) {
                                Asiento18.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 18 Rojo.png"));
                            } else if (Asiento == 19) {
                                Asiento19.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 19 Rojo.png"));
                            } else if (Asiento == 20) {
                                Asiento20.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 20 Rojo.png"));
                            } else if (Asiento == 21) {
                                Asiento21.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 21 Rojo.png"));
                            } else if (Asiento == 22) {
                                Asiento22.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 22 Rojo.png"));
                            } else if (Asiento == 23) {
                                Asiento23.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 23 Rojo.png"));
                            } else if (Asiento == 24) {
                                Asiento24.setIcon(new ImageIcon("build/classes/img/Asientos/Asiento 24 Rojo.png"));
                            }
                        }
                        if (Asiento != AsientoReservadoActual) {
                            AsientosDisponibles.remove(Asientos);
                        }
                        x++;
                    }
                    String[] miarray = new String[AsientosDisponibles.size()];
                    miarray = AsientosDisponibles.toArray(miarray);
                    for (String s : miarray) {
                        this.BoxAsientos.addItem(s);
                    }
                }

            } else {
                System.out.print("No hay registros aun");
                for (int i = 1; i <= 24; i++) {
                    this.BoxAsientos.addItem(String.valueOf(i));
                }
                inicializarAsientos();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }
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
                        this.textHora.setText(DBHorario);
                        this.textDestino.setText(DBDestino);
                        this.textOrigen.setText(DBOrigen);
                        this.textLinea.setText(DBLinea);
                    }                      
                }
            }else{
                JOptionPane.showMessageDialog(null, "No existe esta ruta");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }   

    }

    public void SeleccionarRegistroTable(MouseEvent evt) {
        int registro = TableBoletos.rowAtPoint(evt.getPoint());
        txtID.setText(String.valueOf(TableBoletos.getValueAt(registro, 0)));
        txtNombre.setText(String.valueOf(TableBoletos.getValueAt(registro, 1)));
        txtCosto.setText(String.valueOf(TableBoletos.getValueAt(registro, 2)));
        //BoxAsiento(String.valueOf(TableBoletos.getValueAt(registro, 3)));

        AsientoDisponible = String.valueOf(TableBoletos.getValueAt(registro, 3));

        this.textOrigen.setText(String.valueOf(TableBoletos.getValueAt(registro, 4)));
        this.textDestino.setText(String.valueOf(TableBoletos.getValueAt(registro, 5)));
        this.textHora.setText(String.valueOf(TableBoletos.getValueAt(registro, 6)));
        this.textLinea.setText(String.valueOf(TableBoletos.getValueAt(registro, 7)));

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fecha;
        fecha = TableBoletos.getValueAt(TableBoletos.getSelectedRow(), 8).toString().trim();
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        jDateFecha.setDate(fechaDate);

        AsientoDisponibles();
        this.BoxAsientos.setSelectedItem(AsientoDisponible);
    }

    public void BuscarRutas(String origen, String destino){
        PreparedStatement ps;
        String sql;

        try {
            sql = "SELECT HoraSalida, Destino, Origen, Linea FROM rutas AS Rut "
                    + "INNER JOIN autobuses AS Aut ON Rut.AutobusAsignado = Aut.Id_autobus  "
                    + "WHERE Origen=? and Destino=? and Fecha = CURDATE()";
            ps = con.prepareStatement(sql);
            ps.setString(1, origen);
            ps.setString(2, destino);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                if (rs.getRow() > 0) {
                    rs = ps.executeQuery();
                    inicializarAsientos();
                    while (rs.next()) {
                        String DBHorario = rs.getString("HoraSalida");
                        ComboHorario.addItem(DBHorario);

                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "No existe esta ruta");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión: 1" + e.getMessage());
        }
    }

    public String horaActual() {
        SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();

        Date dateObj = calendar.getTime();
        String formattedDate = dtf.format(dateObj);

        return formattedDate;
    }    
    
    public void llenarComboBoxOrigenDestino() {
        PreparedStatement ps;
        String sql;

        String HoraActual = horaActual();
                
        try {
            sql = "SELECT Origen, Destino FROM rutas WHERE Fecha = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, HoraActual);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                if (rs.getRow() > 0) {
                    rs = ps.executeQuery();  
                    
                    this.Origen.removeAllItems();
                    this.Destino.removeAllItems();
                    this.Origen.addItem("-- Origen --");
                    this.Destino.addItem("-- Destino --");
                    this.Origen.setSelectedIndex(0);
                    this.Destino.setSelectedIndex(0);


                    
                    inicializarAsientos();
                    while (rs.next()) {
                        String DBOrigen = rs.getString("Origen");
                        String DBDestino = rs.getString("Destino");
                        this.Origen.addItem(DBOrigen);
                        this.Destino.addItem(DBDestino);
                    }
                }
            } else {
                System.out.print("No hay Rutas Actuales\n");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }

        AutoCompleteDecorator.decorate(this.Destino);
        AutoCompleteDecorator.decorate(this.Origen);
    }
}
