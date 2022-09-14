
package central_autobuses_mvc_v2;

import controller.controller;
import model.modelBoletos;
import model.modelConductors;
import model.modelRutas;
import model.modeloAutobuses;
import view.Autobuses;
import view.Boleto;
import view.Conductores;
import view.Inicio;
import view.Loader;
import view.Rutas;

public class Central_autobuses_mvc_v2 {

    public static void main(String[] args) {

        Inicio Home = new Inicio();
        Home.setVisible(true);
        
        
        //Models
        modelRutas modelR = new modelRutas();
        modelConductors modelC = new modelConductors();
        modeloAutobuses modelA = new modeloAutobuses();
        modelBoletos modelB = new modelBoletos();
        
        //Views
        Boleto BoletoView = new Boleto();
        Autobuses autobuses = new Autobuses();
        Rutas rutas = new Rutas();
        Conductores conductores = new Conductores();
        
        controller Autobus_con = new controller(Home, modelR, BoletoView, autobuses, 
                rutas, conductores, modelC, modelA, modelB);
        
    }
    
}
