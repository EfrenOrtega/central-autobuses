/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


/**
 *
 * @author Efren
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Boleto
     */
    public Inicio() {
        initComponents();
        this.setLocationRelativeTo(null); 
               
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
        BtnAutobus = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        BtnBoleto = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        BtnRutas = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnConductores = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        Asientos = new javax.swing.JLabel();
        Boletos_Menu1 = new javax.swing.JLabel();
        Boton_Entrar_Boletos = new javax.swing.JLabel();
        Img_Boletos_Menu1 = new javax.swing.JLabel();
        Autobuses_Menu = new javax.swing.JLabel();
        Boton_Entrar_Autobuses = new javax.swing.JLabel();
        Img_Autobuses_Menu = new javax.swing.JLabel();
        Rutas_Menu = new javax.swing.JLabel();
        Boton_Entrar_Rutas = new javax.swing.JLabel();
        Img_Rutas_Menu = new javax.swing.JLabel();
        Rutas_Menu1 = new javax.swing.JLabel();
        Boton_Entrar_Conductores = new javax.swing.JLabel();
        Img_Rutas_Menu1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setToolTipText("");
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
        jPanelMenu.add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 185, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Home.png"))); // NOI18N
        jPanelMenu.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 174, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Boleto.png"))); // NOI18N
        jPanelMenu.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 254, -1, -1));

        BtnAutobus.setFont(new java.awt.Font("Roboto Medium", 0, 16)); // NOI18N
        BtnAutobus.setForeground(new java.awt.Color(255, 255, 255));
        BtnAutobus.setText("Autobuses");
        BtnAutobus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelMenu.add(BtnAutobus, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 345, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Bus.png"))); // NOI18N
        jPanelMenu.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 334, -1, -1));

        BtnBoleto.setFont(new java.awt.Font("Roboto Medium", 0, 16)); // NOI18N
        BtnBoleto.setForeground(new java.awt.Color(255, 255, 255));
        BtnBoleto.setText("Boletos");
        BtnBoleto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelMenu.add(BtnBoleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 265, 90, 30));

        jPanel4.setBackground(new java.awt.Color(42, 69, 114));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 87, 136), 30, true));
        jPanel4.setForeground(new java.awt.Color(54, 87, 136));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanelMenu.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 180, 98, 30));

        BtnRutas.setFont(new java.awt.Font("Roboto Medium", 0, 16)); // NOI18N
        BtnRutas.setForeground(new java.awt.Color(255, 255, 255));
        BtnRutas.setText("Rutas");
        BtnRutas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelMenu.add(BtnRutas, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 425, -1, -1));

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

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo_Peque??o.png"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1037, 233, -1, -1));

        Asientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Portada Inicio.png"))); // NOI18N
        jPanel1.add(Asientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 23, 891, 262));

        Boletos_Menu1.setFont(new java.awt.Font("Roboto Medium", 1, 20)); // NOI18N
        Boletos_Menu1.setForeground(new java.awt.Color(255, 255, 255));
        Boletos_Menu1.setText("Boletos");
        jPanel1.add(Boletos_Menu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 356, -1, -1));

        Boton_Entrar_Boletos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Boton_Entrar.png"))); // NOI18N
        Boton_Entrar_Boletos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(Boton_Entrar_Boletos, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 433, -1, -1));

        Img_Boletos_Menu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Menu_Boletos.png"))); // NOI18N
        jPanel1.add(Img_Boletos_Menu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 339, -1, -1));

        Autobuses_Menu.setFont(new java.awt.Font("Roboto Medium", 1, 20)); // NOI18N
        Autobuses_Menu.setForeground(new java.awt.Color(255, 255, 255));
        Autobuses_Menu.setText("Autobuses");
        jPanel1.add(Autobuses_Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(795, 356, -1, -1));

        Boton_Entrar_Autobuses.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Boton_Entrar.png"))); // NOI18N
        Boton_Entrar_Autobuses.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(Boton_Entrar_Autobuses, new org.netbeans.lib.awtextra.AbsoluteConstraints(786, 430, -1, -1));

        Img_Autobuses_Menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Menu_Autobuses.png"))); // NOI18N
        jPanel1.add(Img_Autobuses_Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(772, 339, -1, -1));

        Rutas_Menu.setFont(new java.awt.Font("Roboto Medium", 1, 20)); // NOI18N
        Rutas_Menu.setForeground(new java.awt.Color(255, 255, 255));
        Rutas_Menu.setText("Rutas");
        jPanel1.add(Rutas_Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 563, -1, -1));

        Boton_Entrar_Rutas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Boton_Entrar.png"))); // NOI18N
        Boton_Entrar_Rutas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(Boton_Entrar_Rutas, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 640, -1, -1));

        Img_Rutas_Menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Menu_Rutas.png"))); // NOI18N
        jPanel1.add(Img_Rutas_Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 546, -1, -1));

        Rutas_Menu1.setFont(new java.awt.Font("Roboto Medium", 1, 20)); // NOI18N
        Rutas_Menu1.setForeground(new java.awt.Color(255, 255, 255));
        Rutas_Menu1.setText("Conductores");
        jPanel1.add(Rutas_Menu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(795, 563, -1, -1));

        Boton_Entrar_Conductores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Boton_Entrar.png"))); // NOI18N
        Boton_Entrar_Conductores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(Boton_Entrar_Conductores, new org.netbeans.lib.awtextra.AbsoluteConstraints(786, 640, -1, -1));

        Img_Rutas_Menu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Menu_Conductores.png"))); // NOI18N
        jPanel1.add(Img_Rutas_Menu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(772, 546, -1, -1));

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Asientos;
    private javax.swing.JLabel Autobuses_Menu;
    private javax.swing.JLabel Boletos_Menu1;
    public javax.swing.JLabel Boton_Entrar_Autobuses;
    public javax.swing.JLabel Boton_Entrar_Boletos;
    public javax.swing.JLabel Boton_Entrar_Conductores;
    public javax.swing.JLabel Boton_Entrar_Rutas;
    public javax.swing.JLabel BtnAutobus;
    public javax.swing.JLabel BtnBoleto;
    public javax.swing.JLabel BtnRutas;
    private javax.swing.JLabel Img_Autobuses_Menu;
    private javax.swing.JLabel Img_Boletos_Menu1;
    private javax.swing.JLabel Img_Rutas_Menu;
    private javax.swing.JLabel Img_Rutas_Menu1;
    private javax.swing.JLabel Rutas_Menu;
    private javax.swing.JLabel Rutas_Menu1;
    public javax.swing.JLabel btnConductores;
    private javax.swing.JLabel btnInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
