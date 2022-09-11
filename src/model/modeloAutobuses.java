
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class modeloAutobuses {
    
    ConexionMySQL cn = new ConexionMySQL();    
    Connection con = cn.getConexion();
    
    public ArrayList<String[]> CargarRegistros(){
        
        ArrayList<String[]> objectData = new ArrayList<String[]>();
        
        PreparedStatement ps;
        String sql;
        try {
            sql = "SELECT *FROM autobuses";
            ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                if (rs.getRow() > 0) {
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        
                        objectData.add(new String[]{
                            rs.getString("Id_autobus"),
                            rs.getString("Matricula"),
                            rs.getString("Año"),
                            rs.getString("Marca"),
                            rs.getString("Modelo"),
                            rs.getString("NoAsientos"),
                            rs.getString("Linea")
                        });
                        
                        /*String DBID = rs.getString("Id_autobus");
                        String DBMatricula = rs.getString("Matricula");
                        String DBAño = rs.getString("Año");
                        String DBMarca = rs.getString("Marca");
                        String DBModelo = rs.getString("Modelo");
                        String DBNoAsientos = rs.getString("NoAsientos");
                        String DBLinea = rs.getString("Linea");

                        tabla.addRow(new Object[]{DBID, DBMatricula, DBAño, DBMarca, DBModelo,
                            DBNoAsientos, DBLinea});*/

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

    public boolean ActualizarRegistro(String Matricula, int año, String marca, String Modelo, int asientos, String linea, int id){
        PreparedStatement ps;
        String sql;

        try {
            sql = "UPDATE autobuses SET Matricula=?, Año=?, Marca=?, Modelo = ?, "
                    + "NoAsientos=?, Linea = ? WHERE Id_autobus = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, Matricula);
            ps.setInt(2, año);
            ps.setString(3, marca);
            ps.setString(4, Modelo);
            ps.setInt(5, asientos);
            ps.setString(6, linea);
            ps.setInt(7, id);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro Modificado");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
            return false;
        }
    }

    public boolean EliminarRegistro(int id){
        PreparedStatement ps;
        String sql;

        try {
            sql = "DELETE FROM autobuses WHERE Id_autobus=?";
            ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Registro Eliminado");
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
            return false;
        }
    }
    
    public boolean GuardarRegistro(String Matricula, String Año, String Marca, String Modelo, String NoAsientos, String linea){
        PreparedStatement ps;
        String sql;

        try {
            sql = "INSERT INTO autobuses(Matricula, Año, Marca, Modelo, NoAsientos, "
                    + "Linea) values(?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, Matricula);
            ps.setString(2, Año);
            ps.setString(3, Marca);
            ps.setString(4, Modelo);
            ps.setString(5, NoAsientos);
            ps.setString(6, linea);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro Agregado");
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
            return false;
        }
    }
    
}
