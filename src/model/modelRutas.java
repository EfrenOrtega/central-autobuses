
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Efren
 */
public class modelRutas {
    
    ConexionMySQL cn = new ConexionMySQL();    
    Connection con = cn.getConexion();
    
    
    private int ID;
    private String Origin;
    private String Destino;
    private String HoraSalida;
    private String IDAutobus;
    private String Conductor;
    private String Seccion;

    public void setCn(ConexionMySQL cn) {
        this.cn = cn;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String Origin) {
        this.Origin = Origin;
    }

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String Destino) {
        this.Destino = Destino;
    }

    public String getHoraSalida() {
        return HoraSalida;
    }

    public void setHoraSalida(String HoraSalida) {
        this.HoraSalida = HoraSalida;
    }

    public String getIDAutobus() {
        return IDAutobus;
    }

    public void setIDAutobus(String IDAutobus) {
        this.IDAutobus = IDAutobus;
    }

    public String getConductor() {
        return Conductor;
    }

    public void setConductor(String Conductor) {
        this.Conductor = Conductor;
    }

    public String getSeccion() {
        return Seccion;
    }

    public void setSeccion(String Seccion) {
        this.Seccion = Seccion;
    }
    
    
    
    //MÉTODOS
    
    public ArrayList<String[]> actualizarTabla(){
        
        ArrayList<String[]> objectData = new ArrayList<String[]>();
                
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
                        
                        objectData.add(new String[]{
                            rs.getString("Id_Rutas"), 
                            rs.getString("Origen"),
                            rs.getString("Destino"),
                            rs.getString("HoraSalida"),
                            rs.getString("Matricula"),
                            rs.getString("Nombre"),
                            rs.getString("Sección")
                        });
                        
                        
                        /*RutasData.add(rs.getString("Origen"));
                        RutasData.add(rs.getString("Destino"));
                        RutasData.add(rs.getString("HoraSalida"));
                        RutasData.add(rs.getString("Matricula"));
                        RutasData.add(rs.getString("Nombre"));
                        RutasData.add(rs.getString("Sección"));*/
                        
                        
  
                        /*
                        String DBId=rs.getString("Id_Rutas");
                        String DBOrigen=rs.getString("Origen");
                        String DBDestino=rs.getString("Destino");
                        String DBHoraSalida=rs.getString("HoraSalida");
                        String DBMatricula=rs.getString("Matricula");
                        String DBConductor=rs.getString("Nombre");
                        String DBSeccion=rs.getString("Sección");

                        tabla.addRow(new Object[]{DBId,DBOrigen,DBDestino,DBHoraSalida, 
                            DBMatricula, DBConductor, DBSeccion});*/
                        
                    }  
                }
            }else{
                //JOptionPane.showMessageDialog(null, "No hay Registros");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }       
        
        //tablaRutas.setModel(tabla);
        //tablaDiseño();
        
        return objectData;

    }
    
    public boolean actualizarRegistro(int DBID_autobus, int DBID_conductor, int id, String origen, String destino, String HoraSalida, String Matricula, String Conductor, String seccion, String HoraActual){
        PreparedStatement ps;
        String sql;

        try {
            sql = "SELECT Id_Conductor FROM conductores WHERE Nombre = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, Conductor);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getRow() > 0) {
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        DBID_conductor = Integer.parseInt(rs.getString("Id_Conductor"));
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "No existe este Registro");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
            return false;
        }

        try {
            sql = "SELECT Id_autobus FROM autobuses WHERE Matricula = ?";
            ps = con.prepareStatement(sql);

            ps.setString(1, Matricula);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                if (rs.getRow() > 0) {
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        DBID_autobus = Integer.parseInt(rs.getString("Id_autobus"));
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "No existe este Registro");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
            return false;
        }

        try {
            sql = "UPDATE rutas SET Origen=?, Destino=?, HoraSalida=?, AutobusAsignado=?, Conductor=?, Sección=?, Fecha=? WHERE Id_Rutas=?";
            ps = con.prepareStatement(sql);

            ps.setString(1, origen);
            ps.setString(2, destino);
            ps.setString(3, HoraSalida);
            ps.setInt(4, DBID_autobus);
            ps.setInt(5, DBID_conductor);
            ps.setString(6, seccion);
            ps.setString(7, HoraActual);
            ps.setInt(8, id);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Se Modifico el Registro");
            return true;
            //limpiarCajasTexto();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
            return false;
        }        
    }
    
    public boolean eliminarRegistro(int id){
        PreparedStatement ps;
        String sql;

        try {
            sql = "DELETE FROM rutas WHERE Id_Rutas=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro Eliminado");
            //limpiarCajasTexto();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
            return false;
        }
    }

    public boolean guardarRegistro(String origen, String Destino, String HoraSalida, String BusAsignado, String Conductor, String Seccion, String HoraActual){
        PreparedStatement ps;
        String sql;
        int DBIdAutobus = 0;
        int BDIdConductor = 0;

        try {
            sql = "SELECT Id_Conductor FROM conductores WHERE Nombre=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, Conductor);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                if (rs.getRow() > 0) {
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        BDIdConductor = rs.getInt("Id_Conductor");
                    }
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
            return false;
        }

        try {
            sql = "SELECT Id_autobus FROM autobuses WHERE Matricula=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, BusAsignado);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                if (rs.getRow() > 0) {
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        DBIdAutobus = rs.getInt("Id_autobus");
                        System.out.print(DBIdAutobus);
                    }
                }
            } else {
                //JOptionPane.showMessageDialog(null, "No hay Registros");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
            return false;
        }

        try {
            sql = "INSERT INTO Rutas(Origen, Destino, HoraSalida, AutobusAsignado, Conductor, Sección,"
                    + "Fecha) values(?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, origen);
            ps.setString(2, Destino);
            ps.setString(3, HoraSalida);
            ps.setInt(4, DBIdAutobus);
            ps.setInt(5, BDIdConductor);
            ps.setString(6, Seccion);
            ps.setString(7, HoraActual);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro nuevo agregado");
            //limpiarCajasTexto();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());            
            return false;
        }
        
    }
}
