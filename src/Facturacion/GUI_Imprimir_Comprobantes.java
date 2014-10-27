/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Facturacion;

import Contabilidad.*;
import Clases_Auxiliares.Conexion;
import Clases_Auxiliares.Validaciones;
import Interface.GUI_Principal;
import Objetos.Usuario;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.HashAttributeSet;
import javax.print.attribute.standard.PrinterName;
import javax.servlet.ServletContext;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Manolo
 */
public class GUI_Imprimir_Comprobantes extends javax.swing.JInternalFrame {

    /**
     * Creates new form GUI_A_Prod
     */
    private Conexion r_con;
    private Usuario usr;
    private String nombre_reporte = "recibo.jrxml";
    private String id_modulo_imp = "8";
    
    private String C01_Factura_A = "factura_a.jrxml";
    private String C02_NotaDebito_A = "factura_a.jrxml";
    private String C03_NotaCredito_A = "factura_a.jrxml";
    private String C04_Recibo_A = "recibo.jrxml";
    private String C05_NotaVenta_A = "factura_a.jrxml";
    private String C06_Factura_B = "factura_b.jrxml";
    private String C07_NotaDebito_B = "factura_b.jrxml";
    private String C08_NotaCredito_B = "factura_b.jrxml";
    private String C09_Recibo_B = "recibo.jrxml";
    private String C10_NotaVenta_B = "factura_b.jrxml";
    
    private String reporte_seleccionado;
    private String reporte_letra;
    private String reporte_numero;
    
    public GUI_Imprimir_Comprobantes(Usuario u, Conexion con) {
        usr = u;
        r_con=con;      
        initComponents(); 
        cargarComboPV();
        cargarComboComprobante();
        jTextField1.setText("1");
        jTextField2.setText("1");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        combo_punto_venta = new javax.swing.JComboBox();
        combo_tipo_comprobante = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Generar Comprobantes");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/articulo.png"))); // NOI18N
        setInheritsPopupMenu(true);

        combo_punto_venta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PV" }));

        combo_tipo_comprobante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Factura", "Nota de Débito", "Nota de Crédito", "Recibo" }));

        jTextField1.setToolTipText("");

        jTextField2.setToolTipText("");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/print.png"))); // NOI18N
        jButton3.setText("Imprimir Comprobantes");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancelar.png"))); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Preferencias:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("desde Número:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setText("hasta Número:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel7.setForeground(java.awt.Color.red);
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("  ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setText("Punto de Venta:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel5.setText("Tipo Comprobante:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel8.setForeground(java.awt.Color.red);
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("  ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(157, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(combo_tipo_comprobante, javax.swing.GroupLayout.Alignment.LEADING, 0, 264, Short.MAX_VALUE)
                                .addComponent(combo_punto_venta, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_punto_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(combo_tipo_comprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        r_con.cierraConexion();
    }//GEN-LAST:event_jButton1ActionPerformed
   
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //obtengo el punto de venta para el numero de factura
        String pv = combo_punto_venta.getSelectedItem().toString();
        String [] separar = pv.split("-");
        pv=separar[0].trim();
        
        //obtengo el tipo de comprobante para el numero de factura
        String nc = combo_tipo_comprobante.getSelectedItem().toString();
        separar = nc.split("-");
        nc=separar[0].trim();
        nc=String.format("%02d", Integer.parseInt(nc));
        
        if (identificarReporte(nc)){
        if (validarDatos()){
            try {                   
                r_con.Connection();
                //vector con las impresoras del modulo de la base de datos
                Vector<Vector<String>>v = r_con.getContenidoTabla("SELECT * FROM impresoras WHERE imp_id_modulo = "+id_modulo_imp);
                //total impresoras disponibles
                PrintService [] impresoras = PrintServiceLookup.lookupPrintServices(null, null);
                //vector con las impresoras del modulo como objeto impresora (PrintService)
                Vector<PrintService>impresoras_modulo = new Vector();
                //objeto impresora en el que se imprime
                PrintService impresora = null;

                if (v.size()>0){
                    String nombre_imp;
                    //caso en que haya mas de una impresora por modulo
                    if (v.size()>=1){
                        //localizo con el simple nombre de la base de dato, el objeto impresora y los cargo
                        for (int i = 0; i < v.size(); i++) {
                            nombre_imp=v.elementAt(i).firstElement();
                            AttributeSet aset = new HashAttributeSet();
                            aset.add(new PrinterName(nombre_imp, null));
                            impresoras = PrintServiceLookup.lookupPrintServices(null, aset);
                            impresora = impresoras[0];
                            impresoras_modulo.add(impresora);
                        }
                        //paso las impresoras del modulo a un arreglo para poder mostrarlo en el Dialog
                        PrintService [] listado_impresoras = new PrintService[impresoras_modulo.size()];
                        for (int i = 0; i < impresoras_modulo.size(); i++) {
                            listado_impresoras[i]=impresoras_modulo.elementAt(i);
                        }
                        //muestro el listado de impresoras como objeto y se la asigno a la impresora a imprimir
                        impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccione una impresora asignada a este módulo:",
                            "Imprimir Reporte", JOptionPane.QUESTION_MESSAGE, null, listado_impresoras, listado_impresoras[0]);
                    }
                    
                    //si hay impresora para el modulo
                    if (impresora != null){
                        //cargo Parametros del Reporte
                        Map parametros = new HashMap();
                        //para que funcione el logo debo pasar la ruta completa
                        String dir_logo = (System.getProperty("user.dir"));
                        dir_logo+="/src/Reportes/logo.png";

                        parametros.put("url_logo", dir_logo);
                        parametros.put("letra_comprobante", this.reporte_letra);
                        parametros.put("cod_comprobante", this.reporte_numero);

                        //localizo el reporte para usarlo
                        JasperReport report = JasperCompileManager.compileReport("src/Reportes/"+this.reporte_seleccionado);
                        //cargo los datos
                        JasperPrint print = JasperFillManager.fillReport(report, parametros, r_con.getConn());
                        
                        JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();
                        jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print );
                        jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora );
                        jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE);
                        jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);

                        int copias = (Integer.parseInt(jTextField2.getText())+1) - Integer.parseInt(jTextField1.getText());
                        String message="Esta a punto de imprimir "+copias+" comprobantes, ¿esta seguro? " ;
                        int rta=JOptionPane.showConfirmDialog(null, message, "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

                        if (rta==JOptionPane.YES_OPTION){                            
                            //agrego los 0 necesarios
                            String numero_com = String.format("%02d", Integer.parseInt(this.reporte_numero));
                            String numero_pto = String.format("%04d", Integer.parseInt(pv));                                       

                            //repito la cantidad de veces
                            for (int i = Integer.parseInt(jTextField1.getText()); i <= Integer.parseInt(jTextField2.getText()); i++) {
                                String numero_fac = String.format("%08d", i);
                                parametros.put("num_factura",(numero_com+"-"+numero_pto+"-"+numero_fac));
                                print = JasperFillManager.fillReport(report, parametros, r_con.getConn());
                                jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print );
                                jrprintServiceExporter.exportReport(); 
                            }  
                        }                                             
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "No hay Impresoras asignadas a este Modulo, "
                        + "\npóngase en contacto con el Administrador de Impresoras.","Atención",JOptionPane.WARNING_MESSAGE);
                }
                r_con.cierraConexion();
            } catch (JRException ex) {
                 r_con.cierraConexion();
                Logger.getLogger(GUI_Imprimir_PC.class.getName()).log(Level.SEVERE, null, ex);           
            }
        }
        }
        else{
            JOptionPane.showMessageDialog(null, "No hay Reporte asignado a este Comprobante, "
            + "\npóngase en contacto con el Administrador.","Atención",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed
                  
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox combo_punto_venta;
    private javax.swing.JComboBox combo_tipo_comprobante;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

public void setTitleLabel (String t){
        this.jLabel1.setText(t);
}

    private boolean validarDatos() {
        //unicamente valido el numero de cuenta
        boolean valido = false;
        Validaciones val = new Validaciones();
        
        if (jTextField1.getText().equals("") || jTextField2.getText().equals("")){
            mensajeError("Ingrese un valor para Desde.. Hasta.");
        }
        else{
            if (!val.isInt(jTextField1.getText()) || !val.isInt(jTextField2.getText())){
                mensajeError("Ingrese un valor NUMERICO para Desde.. Hasta.");
            }
            else{
                if ((Integer.parseInt(jTextField1.getText())>0) || (Integer.parseInt(jTextField1.getText())>0)){
                    valido = true;
                    mensajeError(" ");
                }
                else{
                     mensajeError("Ingrese un valor POSITIVO para Desde.. Hasta.");
                }
            }
        } 
        return valido;
    }
    
    private void mensajeError(String msj) {
        jLabel7.setText(msj);        
    }
    
    private void cargarComboPV(){
        try {
            combo_punto_venta.removeAllItems();
            r_con.Connection();            
            ResultSet res = r_con.Consultar("SELECT * FROM punto_venta WITH (INDEX(PK_pv_codigo)) ");            

            while(res.next()){
               combo_punto_venta.addItem(res.getString(1)+ " - "+res.getString(2)); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(IGUI_Asignar_Pto_Venta_Comprobante.class.getName()).log(Level.SEVERE, null, ex);
        } finally {            
            r_con.cierraConexion();
        } 
    }
    
    private void cargarComboComprobante(){
        try {
            combo_tipo_comprobante.removeAllItems();
            r_con.Connection();  
            String consulta = ("SELECT * "+
                               "FROM tipo_comprobante WITH (INDEX(PK_tc_codigo))");
            ResultSet res = r_con.Consultar(consulta);            

            while(res.next()){
               combo_tipo_comprobante.addItem(res.getString(1)+ " - "+res.getString(2)); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(IGUI_Asignar_Pto_Venta_Comprobante.class.getName()).log(Level.SEVERE, null, ex);
        } finally {            
            r_con.cierraConexion();
        } 
    }
    
    private boolean identificarReporte (String nro){
        boolean identificado = true;
        
        switch(nro) {
            case "01": 
                reporte_seleccionado = this.C01_Factura_A;
                reporte_letra = "A";
                break;
            case "02": 
                reporte_seleccionado = this.C02_NotaDebito_A;
                reporte_letra = "A";
                break;
            case "03": 
                reporte_seleccionado = this.C03_NotaCredito_A;
                reporte_letra = "A";
                break;
            case "04": 
                reporte_seleccionado = this.C04_Recibo_A;
                reporte_letra = "A";
                break;
            case "05": 
                reporte_seleccionado = this.C05_NotaVenta_A;
                reporte_letra = "A";
                break;
            case "06": 
                reporte_seleccionado = this.C06_Factura_B;
                reporte_letra = "B";
                break;
            case "07": 
                reporte_seleccionado = this.C07_NotaDebito_B;
                reporte_letra = "B";
                break;
            case "08": 
                reporte_seleccionado = this.C08_NotaCredito_B;
                reporte_letra = "B";
                break;
            case "09": 
                reporte_seleccionado = this.C09_Recibo_B;
                reporte_letra = "B";
                break;
            case "10": 
                reporte_seleccionado = this.C10_NotaVenta_B;
                reporte_letra = "B";
                break;
            default: 
                identificado = false;
                break;
        }
        
        if (identificado){
            reporte_numero = nro;
        }
        return identificado;
    }

}
