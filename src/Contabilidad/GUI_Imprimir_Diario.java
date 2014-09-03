/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Contabilidad;

import Clases_Auxiliares.Conexion;
import Clases_Auxiliares.Fechas;
import Clases_Auxiliares.Validaciones;
import Objetos.Usuario;
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
public class GUI_Imprimir_Diario extends javax.swing.JInternalFrame {

    /**
     * Creates new form GUI_A_Prod
     */
    private Conexion r_con;
    private Usuario usr;
    private String nameTable = "asientos";
    private String nombre_reporte = "libro_diario.jrxml";
    private String id_modulo_imp = "8";
    private String inicio_FEC, cierre_FEC,ult_impre_FEC,maxFEC;
    private int ult_renglon,nro_folio;
    
    private Fechas fecha = new Fechas ();
    
    public GUI_Imprimir_Diario(Usuario u, Conexion con) {
        usr = u;
        r_con=con;      
        initComponents();        
        ult_impre_FEC="";
        maxFEC="";
        minimosYmaximos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        campoFecha1 = new javax.swing.JFormattedTextField();
        campoFecha2 = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Filtro Reporte Asientos");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/articulo.png"))); // NOI18N
        setInheritsPopupMenu(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Preferencias:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancelar.png"))); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/previsualizar.png"))); // NOI18N
        jButton2.setText("Visualizar Reporte");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setText("Ultima Impresión del Libro Diario:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel5.setText("Hasta Fecha:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel7.setForeground(java.awt.Color.red);
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("  ");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/print.png"))); // NOI18N
        jButton3.setText("Imprimir Reporte");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        campoFecha1.setEditable(false);
        try {
            campoFecha1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoFecha1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoFecha1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoFecha1FocusLost(evt);
            }
        });

        try {
            campoFecha2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoFecha2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoFecha2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoFecha2FocusLost(evt);
            }
        });

        jLabel2.setText("Ultimo Folio:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("-");

        jLabel6.setText("Ultimo Renglon:");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("-");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(157, 157, 157))))
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(campoFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoFecha1, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(120, 150, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(campoFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(27, 27, 27)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        r_con.cierraConexion();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (validarDatos()){
            try {
                  
                  //cargo Parametros del Reporte
                   Map parametros = new HashMap();
                   parametros.put("name_empresa", r_con.getRazon_social());
                   parametros.put("ultimo_asto",0);
                   if (ult_renglon!=0){
                        parametros.put("min_fec",campoFecha1.getText());
                    }
                    else{
                       parametros.put("min_fec",fecha.addDaysToDate(campoFecha1.getText(), -1));                    
                    }
                   parametros.put("max_fec",campoFecha2.getText());
                   parametros.put("cierre_fec",this.cierre_FEC);
                   if (nro_folio!=0){
                        parametros.put("nro_folio",this.nro_folio+1);
                    }
                    else{
                        parametros.put("nro_folio",this.nro_folio+1);
                    }
                   parametros.put("ultimo_renglon",ult_renglon);

                   //System.out.println(ult_renglon+" "+fecha.addDaysToDate(campoFecha1.getText(), -1)+" "+campoFecha2.getText()+" "+nro_folio);
                  
                    //localizo el reporte para usarlo
                    JasperReport report = JasperCompileManager.compileReport("src/Reportes/"+nombre_reporte);
                    
                    r_con.Connection();
                    JasperPrint print = JasperFillManager.fillReport(report, parametros, r_con.getConn());
           
                    //creo un objeto Visor del Reporte
                    JasperViewer jviewer = new JasperViewer(print,false);
                    jviewer.setTitle("Reporte Libro Diario."); 
            
                    //quito el boton de imprimir del Visor
                    JRootPane JRP = (JRootPane) jviewer.getComponent(0);           
                    JLayeredPane JLP = (JLayeredPane) JRP.getComponent(1);
                    JPanel JP = (JPanel) JLP.getComponent(0);
                    JPanel JP2 = (JPanel) JP.getComponent(0);
                    JRViewer JRV = (JRViewer) JP2.getComponent(0);
                    JPanel JP3 = (JPanel) JRV.getComponent(0);            
                    //COMPONENTE 0 es el Boton Guardar, el 1 el es de Imprimir
                    JP3.getComponent(1).setEnabled(false);
                    
                    jviewer.setVisible(true);
            
            
            } catch (Exception e) {
                r_con.cierraConexion();
                System.out.println(e.getMessage());
            } 
            finally {
                      r_con.cierraConexion();
            }    
       }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            if (validarDatos()){
                //cargo Parametros del Reporte
                Map parametros = new HashMap();
                parametros.put("name_empresa", r_con.getRazon_social());
                parametros.put("ultimo_asto",0);
                if (ult_renglon!=0){
                    parametros.put("min_fec",campoFecha1.getText());
                }
                else{
                   parametros.put("min_fec",fecha.addDaysToDate(campoFecha1.getText(), -1));                    
                }
                parametros.put("max_fec",campoFecha2.getText());
                parametros.put("cierre_fec",this.cierre_FEC);
                if (nro_folio!=0){
                    parametros.put("nro_folio",this.nro_folio);
                }
                else{
                    parametros.put("nro_folio",this.nro_folio+1);
                }
                parametros.put("ultimo_renglon",ult_renglon);

                //System.out.println(ult_renglon+" "+fecha.addDaysToDate(campoFecha1.getText(), -1)+" "+campoFecha2.getText()+" "+nro_folio);

                //localizo el reporte para usarlo
                JasperReport report = JasperCompileManager.compileReport("src/Reportes/"+nombre_reporte);

                r_con.Connection();
                //cargo los datos
                JasperPrint print = JasperFillManager.fillReport(report, parametros, r_con.getConn());            
                
                //paginas que ocupó
                nro_folio = nro_folio+print.getPages().size();
                
                //renglones que ocupó
                String sql = "SELECT COUNT(*) FROM asientos WHERE as_fecha_contabilidad <= '"+campoFecha2.getText()+"'";
                ResultSet res = r_con.Consultar(sql);
                try {
                    if(res.next()){
                         this.ult_renglon=res.getInt(1);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(GUI_Imprimir_Diario.class.getName()).log(Level.SEVERE, null, ex);
                }               

                //System.out.println(ult_renglon+" "+fecha.addDaysToDate(campoFecha1.getText(), -1)+" "+campoFecha2.getText()+" "+nro_folio);
                
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

                    //mando a imprimir el reporte en la impresora
                    if (impresora != null){   
                        JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();                        
                        jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print );
                        jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora );
                        jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.TRUE);
                        jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);
                        jrprintServiceExporter.exportReport();
                        
                        String message="Se solicito la impresión del libro Diario, ¿Confirma la CORRECTA impresión?.";
                        int rta=JOptionPane.showConfirmDialog(null, message, "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        if (rta==JOptionPane.YES_OPTION){
                            sql = "UPDATE parametros_contables SET pc_fecha_impresion_diario = '"+campoFecha2.getText()+"', pc_nro_renglon_diario = "+ult_renglon+", pc_nro_folio = "+nro_folio+";";
                            System.out.println(sql);
                            r_con.ActualizarSinCartel(sql);
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Los parametros no se actualizaron. Puede volver a imprimir el Libro Diario.","Error",JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    else{
                        System.out.println("IMPRESORA NULA VER QUE PASO.");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "No hay Impresoras asignadas a este Modulo, "
                        + "\npóngase en contacto con el Administrador de Impresoras.","Atención",JOptionPane.WARNING_MESSAGE);
                }
                r_con.cierraConexion();
            }
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null,"Ocurrió un Error.","Error",JOptionPane.WARNING_MESSAGE);
                Logger.getLogger(GUI_Imprimir_Diario.class.getName()).log(Level.SEVERE, null, ex);
                r_con.cierraConexion();
            }
        
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void campoFecha1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoFecha1FocusGained
        campoFecha1.select(0,0);
    }//GEN-LAST:event_campoFecha1FocusGained

    private void campoFecha1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoFecha1FocusLost
        if (!fecha.isFechaValida(campoFecha1.getText())){
            mensajeError("La Fecha ingresada no se reconoce como valida.");
        }
        else{
            mensajeError(" ");
        }
    }//GEN-LAST:event_campoFecha1FocusLost

    private void campoFecha2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoFecha2FocusGained
        // TODO add your handling code here:
        campoFecha2.select(0,0);
    }//GEN-LAST:event_campoFecha2FocusGained

    private void campoFecha2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoFecha2FocusLost
        // TODO add your handling code here:
        if (!fecha.isFechaValida(campoFecha2.getText())){
            mensajeError("La Fecha ingresada no se reconoce como valida.");
        }
        else{
            mensajeError(" ");
        }
    }//GEN-LAST:event_campoFecha2FocusLost
   
    
    private void minimosYmaximos (){
        
        try {
            r_con.Connection();     
            ResultSet res = r_con.Consultar("SELECT * FROM parametros_contables");
            if(res.next()){
                inicio_FEC=res.getString(1);
                cierre_FEC=res.getString(2);
                ult_impre_FEC=res.getString(4);
                ult_renglon=res.getInt(5);
                nro_folio=res.getInt(6);
            }
            
            jLabel3.setText(""+nro_folio);
            jLabel8.setText(""+ult_renglon);
            campoFecha1.setText(fecha.convertirBarras(ult_impre_FEC));
            campoFecha2.setText(fecha.getHoy());
            this.maxFEC=fecha.getHoy();
            
        } catch (SQLException ex) {
            Logger.getLogger(GUI_Imprimir_Diario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
               
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JFormattedTextField campoFecha1;
    private javax.swing.JFormattedTextField campoFecha2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables

public void setTitleLabel (String t){
        this.jLabel1.setText(t);
}

    private boolean validarDatos() {
        //unicamente valido el numero de cuenta
        boolean valido = false;
        Validaciones val = new Validaciones();
        
                    if (!fecha.isFechaValida(campoFecha1.getText()) || (!fecha.isFechaValida(campoFecha2.getText()))){
                        mensajeError("Ingrese Fechas Validas por favor.");
                    }
                    else{
                        valido = true;
                        mensajeError(" ");
                    }        
            
           
        return valido;
    }
    
    private void mensajeError(String msj) {
        jLabel7.setText(msj);        
    }

}
