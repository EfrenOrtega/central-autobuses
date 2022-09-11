
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.modelConductors;
import model.modelRutas;
import model.modeloAutobuses;
import view.Autobuses;
import view.Boleto;
import view.Conductores;
import view.Inicio; 
import view.Rutas;


public class controller implements ActionListener, MouseListener{

    public Inicio Home;    
    public Boleto Ticket;
    public Autobuses autobuses;
    public Rutas rutes;
    public Conductores conductor;
    
    
    //MODELS
    public modelConductors modelC; 
    public modelRutas model;
    public modeloAutobuses modelA;
    
    public controller(Inicio vH, modelRutas m, Boleto vB, Autobuses vA, Rutas vR, Conductores vC, modelConductors mC, modeloAutobuses mA){
        this.model = m;
        this.modelC = mC;
        this.modelA = mA;
        
        this.Home = vH;
        this.Ticket = vB;
        this.autobuses = vA;
        this.conductor = vC;
        this.rutes = vR;
        
        vH.Boton_Entrar_Boletos.addMouseListener(this);
        vH.Boton_Entrar_Autobuses.addMouseListener(this);
        vH.Boton_Entrar_Rutas.addMouseListener(this);
        vH.Boton_Entrar_Conductores.addMouseListener(this);
        vB.btnInicio.addMouseListener(this);
        
        
        //Autobuses View
        vA.btnInicio.addMouseListener(this);
        vA.Modificar.addMouseListener(this);
        vA.Eliminar.addMouseListener(this);
        vA.GUARDAR.addMouseListener(this);
        
        //Rutes View
        vR.Modificar.addMouseListener(this);
        vR.btnInicio.addMouseListener(this);
        vR.Eliminar.addMouseListener(this);
        vR.GUARDAR.addMouseListener(this);
        
        
        //Conductor View
        vC.btnInicio.addMouseListener(this);
        vC.Modificar.addMouseListener(this);
        vC.Eliminar.addMouseListener(this);
        vC.GUARDAR.addMouseListener(this);

        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        //=======================================
        //          Events Home View
        //========================================
        if(e.getSource() == Home.Boton_Entrar_Boletos){
            Home.setVisible(false);
            Ticket.setVisible(true);
        }
        
        if(e.getSource() == Home.Boton_Entrar_Autobuses){
            CargarAutobuses();
            Home.setVisible(false);
            autobuses.setVisible(true);
        }
        
        if(e.getSource() == Home.Boton_Entrar_Rutas){
            CargarRegistrosRutas();
            Home.setVisible(false);
            rutes.setVisible(true);
        }
        
        if(e.getSource() == Home.Boton_Entrar_Conductores){
            CargarRegistrosConductors();
            Home.setVisible(false);
            conductor.setVisible(true);
        }
        
        
        if(e.getSource() == Ticket.btnInicio){
            Ticket.setVisible(false);
            Home.setVisible(true);
        } 
        
        
               
        //==================================
        //    Events of Autobuses View
        //==================================
        if(e.getSource() == autobuses.btnInicio){
            autobuses.setVisible(false);
            Home.setVisible(true);
        } 
        
        
        //===================================
        //     Events of Rutas View
        //===================================
        if(e.getSource() == rutes.btnInicio){
            rutes.setVisible(false);
            Home.setVisible(true);
        }
        
        if(e.getSource() == rutes.Modificar){
            ActualizarRegistrosRutas();
        }
        
        if(e.getSource() == rutes.Eliminar){
            EliminarRegistro();
        }
        
        if(e.getSource() == rutes.GUARDAR){
            GuardarRegistroRutas();
        }
        
        
        //======================================
        //     Events of Conductores View
        //======================================
        if(e.getSource() == conductor.btnInicio){
            conductor.setVisible(false);
            Home.setVisible(true);
        }
        
        if(e.getSource() == conductor.Modificar){
            ActualizarRegistroConductores();
        }
        
        if(e.getSource() == conductor.Eliminar){
            EliminarConductores();
        }
        
        if(e.getSource() == conductor.GUARDAR){
            GuardarConductores();
        }
                
    }
    
    //===========================
    //  Métodos Autobuses
    //===========================
    public void CargarAutobuses(){
        
        ArrayList<String[]> objectData = new ArrayList<>(modelA.CargarRegistros());
        
        
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.addColumn("ID");
        tabla.addColumn("Matricula");
        tabla.addColumn("Año");
        tabla.addColumn("Marca");
        tabla.addColumn("Modelo");
        tabla.addColumn("No. Asientos");
        tabla.addColumn("Linea");

        //Model
        for (int i = 0; i < objectData.size(); i++) {

            String DBID = objectData.get(i)[0];
            String DBMatricula = objectData.get(i)[1];
            String DBAño = objectData.get(i)[2];
            String DBMarca = objectData.get(i)[3];
            String DBModelo = objectData.get(i)[4];
            String DBNoAsientos = objectData.get(i)[5];
            String DBLinea = objectData.get(i)[6];

            tabla.addRow(new Object[]{DBID, DBMatricula, DBAño, DBMarca, DBModelo,
                DBNoAsientos, DBLinea});

        }
        
        
        autobuses.tablaBus.setModel(tabla);
        autobuses.tablaDiseño();   
    }
    
    public void ActualizarAutobuses(){
                if(!autobuses.txtID.getText().equals("")){
            if(!autobuses.txtMatricula.getText().equals("")&& !autobuses.txtAño.getText().equals("")
            && !autobuses.txtMarca.getText().equals("") && !autobuses.txtModelo.getText().equals("")
            && !autobuses.txtAsientos.getText().equals("") && !autobuses.txtLinea.getText().equals("")){

                    int id = Integer.parseInt(autobuses.txtID.getText());
                    String Matricula = autobuses.txtMatricula.getText();
                    int año = Integer.parseInt(autobuses.txtAño.getText());
                    String marca = autobuses.txtMarca.getText();
                    String Modelo = autobuses.txtModelo.getText();
                    int asientos = Integer.parseInt(autobuses.txtAsientos.getText());
                    String linea = autobuses.txtLinea.getText();

                    //Model
                    boolean res = modelA.ActualizarRegistro(Matricula, año, marca, Modelo, asientos, linea, id);
                    if(res){
                        this.CargarAutobuses();
                    }
                    
                    
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Llene todos los campo");
                }
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione un Registro");
        }
    }
    
    public void EliminarAutobuses(){
        if(!autobuses.txtID.getText().equals("")){
        
            int id = Integer.parseInt(autobuses.txtID.getText());
            
            //Model
            boolean res = modelA.EliminarRegistro(id);
            if(res){
                this.ActualizarAutobuses();
            }
            
            
            
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione un registro");
        }
    }
    
    public void GuardarAutobuses(){
                if(!autobuses.txtMatricula.getText().equals("")&& !autobuses.txtAño.getText().equals("")
           && !autobuses.txtMarca.getText().equals("") && !autobuses.txtModelo.getText().equals("")
           && !autobuses.txtAsientos.getText().equals("") && !autobuses.txtLinea.getText().equals("")){
        
            String Matricula = autobuses.txtMatricula.getText();
            String Año = autobuses.txtAño.getText();
            String Marca = autobuses.txtMarca.getText();
            String Modelo = autobuses.txtModelo.getText();
            String NoAsientos = autobuses.txtAsientos.getText();
            String linea = autobuses.txtLinea.getText();

            //Model
            
            modelA.GuardarRegistro(Matricula, Año, Marca, Modelo, NoAsientos, linea);
        }else{
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        }
    }
    
    public void limpiarCajasTextoAutobuses(){}
    //===========================
    //  Métodos Conductors View
    //===========================
    public void CargarRegistrosConductors(){
        ArrayList<String[]> objectData = new ArrayList<>(modelC.cargarRegistrosTabla());

        DefaultTableModel tabla = new DefaultTableModel();
        tabla.addColumn("Id");
        tabla.addColumn("Nombre");
        tabla.addColumn("Fecha de Nacimiento");
        tabla.addColumn("Telefono");
        tabla.addColumn("Domicilio");

        //COnsulta a DB
        for (int i = 0; i < objectData.size(); i++) {
                
            String DBId = objectData.get(i)[0];
            String DBNombre = objectData.get(i)[1];
            String DBNacimiento = objectData.get(i)[2];
            String DBDomicilio = objectData.get(i)[3];
            String DBTelefono = objectData.get(i)[4];

            tabla.addRow(new Object[]{DBId, DBNombre, DBNacimiento, DBTelefono,
                DBDomicilio}); 
                        
        }
        
        conductor.tablaConductor.setModel(tabla);
        conductor.tablaDiseño();
    }
    
    public void ActualizarRegistroConductores(){
        if(!conductor.txtID.getText().equals("")){
            if(!conductor.txtNombre.getText().equals("")&& conductor.jDateFecha.getDate() != null
               &&!conductor.txtDomicilio.getText().equals("")&&!conductor.txtTelefono.equals("")){

                String Nombre = conductor.txtNombre.getText();
                String Domicilio = conductor.txtDomicilio.getText();
                String tel = conductor.txtTelefono.getText();

                String formato = conductor.jDateFecha.getDateFormatString();
                Date date=conductor.jDateFecha.getDate();
                SimpleDateFormat sdf = new SimpleDateFormat(formato);
                String Nacimiento = String.valueOf(sdf.format(date));

                int IDConductor = Integer.parseInt(conductor.txtID.getText());
                
                //Modelo
                boolean res = modelC.ActualizarRegistro(IDConductor, Nombre, Nacimiento, tel, Domicilio);
                if(res){
                    this.CargarRegistrosConductors();
                }
                this.limpiarCajasTextoConductores();
                
            }else{
                JOptionPane.showMessageDialog(null, "Llene todo los campos");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione un Registro");
        }
    }
    
    public void EliminarConductores(){
        if (!conductor.txtID.getText().equals("")) {
            int IDConductor = Integer.parseInt(conductor.txtID.getText());

            String Nombre = conductor.txtNombre.getText();
            
            //MODEL
            boolean res = modelC.EliminarRegistro(IDConductor, Nombre);
            if(res){
                this.ActualizarRegistroConductores();
            }
            this.limpiarCajasTextoConductores();
            
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un Registro");
        }
    }
    
    public void GuardarConductores(){
        if (!conductor.txtNombre.getText().equals("") && conductor.jDateFecha.getDate() != null
                && !conductor.txtDomicilio.getText().equals("") && !conductor.txtTelefono.equals("")) {

            String Nombre = conductor.txtNombre.getText();
            String Domicilio = conductor.txtDomicilio.getText();
            String tel = conductor.txtTelefono.getText();

            String formato = conductor.jDateFecha.getDateFormatString();
            Date date = conductor.jDateFecha.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat(formato);
            String Nacimiento = String.valueOf(sdf.format(date));

            //Model
            boolean res = modelC.GuardarRegistro(Nombre, Nacimiento, tel, Domicilio);
            if(res){
                this.CargarRegistrosConductors();
            }
            this.limpiarCajasTextoConductores();
            
        } else {
            JOptionPane.showMessageDialog(null, "LLene todos los campos");
        }

    }
    
    public void limpiarCajasTextoConductores(){
        conductor.txtNombre.setText("");
        conductor.txtDomicilio.setText("");
        conductor.txtID.setText("");
        conductor.txtTelefono.setText("");
    }
    
    
    //======================
    //  Métodos Rutas View  
    //======================
    public void limpiarCajasTexto(){
        rutes.txtID.setText("");
        rutes.txtOrigen.setText("");
        rutes.txtDestino.setText("");
        rutes.txtHoraSalida.setText("");
        rutes.ComboBoxBusAsignado.setSelectedIndex(0);
        rutes.ComboBoxConductor.setSelectedIndex(0);
        rutes.txtSeccion.setText("");
    }
    
    public void CargarRegistrosRutas(){
        
        ArrayList<String[]> objectData = new ArrayList<String[]>(model.actualizarTabla());

        DefaultTableModel tabla = new DefaultTableModel();  
        tabla.addColumn("Id");
        tabla.addColumn("Origen");
        tabla.addColumn("Destino");
        tabla.addColumn("Hora Salida");
        tabla.addColumn("Autobus Asignado");
        tabla.addColumn("Conductor");
        tabla.addColumn("Sección");
        
        for (int i = 0; i < objectData.size(); i++) {
                
            String DBId=objectData.get(i)[0];
            String DBOrigen=objectData.get(i)[1];
            String DBDestino=objectData.get(i)[2];
            String DBHoraSalida=objectData.get(i)[3];
            String DBMatricula=objectData.get(i)[4];
            String DBConductor=objectData.get(i)[5];
            String DBSeccion=objectData.get(i)[6];

            tabla.addRow(new Object[]{DBId,DBOrigen,DBDestino,DBHoraSalida, 
            DBMatricula, DBConductor, DBSeccion});               
                        
        }
        
        rutes.tablaRutas.setModel(tabla);
        rutes.tablaDiseño();
    }
    
    public void ActualizarRegistrosRutas(){
        if(!rutes.txtID.getText().equals("")){
            
            if(!rutes.ComboBoxBusAsignado.getSelectedItem().toString().equals("-- Autobus --") 
            && !rutes.ComboBoxConductor.getSelectedItem().toString().equals("-- Conductor --")
            && !rutes.txtOrigen.getText().equals("") && !rutes.txtDestino.getText().equals("")&&
            !rutes.txtHoraSalida.getText().equals("") && !rutes.txtSeccion.getText().equals("")){                
                       
                int id = Integer.parseInt(rutes.txtID.getText());
                String origen = rutes.txtOrigen.getText();
                String destino = rutes.txtDestino.getText();
                String HoraSalida = rutes.txtHoraSalida.getText();
                String Matricula = rutes.ComboBoxBusAsignado.getSelectedItem().toString();
                String Conductor = rutes.ComboBoxConductor.getSelectedItem().toString();
                String seccion = rutes.txtSeccion.getText();
                String HoraActual = rutes.horaActual();
                
                int DBID_autobus = 0;
                int DBID_conductor =0;
                        
                //Actualizar Registro DB ....
                boolean res = model.actualizarRegistro(DBID_autobus, DBID_conductor, id, origen, destino, HoraSalida, Matricula, Conductor, seccion, HoraActual);
                if(res){                    
                    this.CargarRegistrosRutas();
                }
                this.limpiarCajasTexto();
            }else{
                JOptionPane.showMessageDialog(null, "LLene todos los campos");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Selecciona un Registro");
        }     
    }
    
    public void EliminarRegistro(){
        if (!rutes.txtID.getText().equals("")) {
            int id = Integer.parseInt(rutes.txtID.getText());
            
            //Eliminación desde Model.
            boolean res = model.eliminarRegistro(id);
            if(res){
                this.CargarRegistrosRutas();
            }
            this.limpiarCajasTexto();
            
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un registro");
        }
    }
    
    public void GuardarRegistroRutas(){
        if (!rutes.txtOrigen.getText().equals("") && !rutes.txtDestino.getText().equals("")
                && !rutes.txtHoraSalida.getText().equals("") && !rutes.ComboBoxBusAsignado.getSelectedItem().toString().equals("-- Autobus --")
                && !rutes.ComboBoxConductor.getSelectedItem().toString().equals("-- Conductor --")
                && !rutes.txtSeccion.getText().equals("")) {

            String origen = rutes.txtOrigen.getText();
            String Destino = rutes.txtDestino.getText();
            String HoraSalida = rutes.txtHoraSalida.getText();
            String BusAsignado = rutes.ComboBoxBusAsignado.getSelectedItem().toString();
            String Conductor = rutes.ComboBoxConductor.getSelectedItem().toString();
            String Seccion = rutes.txtSeccion.getText();
            String HoraActual = rutes.horaActual();

            //GUARDAR REGISTRO...
            boolean res = model.guardarRegistro(origen, Destino, HoraSalida, BusAsignado, Conductor, Seccion, HoraActual);
            if(res){
                this.CargarRegistrosRutas();
            }
            this.limpiarCajasTexto();
            
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese todos los datos");
        }       
    }
    
    
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
        
    //Code created by E.O
}
