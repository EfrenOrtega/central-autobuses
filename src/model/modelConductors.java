package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class modelConductors {
    ConexionMySQL cn = new ConexionMySQL();    
    Connection con = cn.getConexion();
    
    public ArrayList<String[]> cargarRegistrosTabla(){
        ArrayList<String[]> objectData = new ArrayList<String[]>();
        
        PreparedStatement ps;
        String sql;
        try {
            sql = "SELECT *FROM conductores";
            ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getRow() > 0) {
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        
                        objectData.add(new String[]{
                            rs.getString("Id_conductor"),
                            rs.getString("Nombre"),
                            rs.getString("Fecha_Nacimiento"),
                            rs.getString("Domicilio"),
                            rs.getString("Telefono")
                        });
                        
                        
                        /*String DBId = rs.getString("Id_conductor");
                        String DBNombre = rs.getString("Nombre");
                        String DBNacimiento = rs.getString("Fecha_Nacimiento");
                        String DBDomicilio = rs.getString("Domicilio");
                        String DBTelefono = rs.getString("Telefono");

                        tabla.addRow(new Object[]{DBId, DBNombre, DBNacimiento, DBTelefono,
                            DBDomicilio});*/

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

    public boolean ActualizarRegistro(int IDConductor, String Nombre, String Nacimiento, String tel, String Domicilio){
        PreparedStatement ps;
        String sql;

        try {
            sql = "UPDATE conductores SET Nombre = ?, Fecha_Nacimiento = ?, "
                    + "Telefono = ?, Domicilio = ? WHERE Id_Conductor = ?";

            ps = con.prepareStatement(sql);
            ps.setString(1, Nombre);
            ps.setString(2, Nacimiento);
            ps.setString(3, tel);
            ps.setString(4, Domicilio);
            ps.setInt(5, IDConductor);
            ps.executeUpdate();

            //actualizarTabla();
            //limpiarCajasText();
            JOptionPane.showMessageDialog(null, "El Registro de " + Nombre + " fue Modificado");
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
            return false;
        }
    }

    public boolean EliminarRegistro(int IDConductor, String Nombre){
        PreparedStatement ps;
        String sql;

        try {
            sql = "DELETE FROM conductores WHERE Id_Conductor = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, IDConductor);

            ps.executeUpdate();

            //actualizarTabla();
            //limpiarCajasText();
            JOptionPane.showMessageDialog(null, "El registro de " + Nombre + " fue Eliminado");
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
            return false;
        }
    }

    public boolean GuardarRegistro(String Nombre, String Nacimiento, String tel, String Domicilio){
        PreparedStatement ps;
        String sql;

        try {
            sql = "INSERT INTO conductores(Nombre, Fecha_Nacimiento, Telefono, Domicilio) "
                    + "VALUES(?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, Nombre);
            ps.setString(2, Nacimiento);
            ps.setString(3, tel);
            ps.setString(4, Domicilio);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Se agrego un nuevo registro");
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
            return false;
        }
    }
}
