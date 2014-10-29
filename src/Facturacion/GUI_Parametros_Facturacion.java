/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Facturacion;

import Contabilidad.*;
import Clases_Auxiliares.Conexion;
import Clases_Auxiliares.Fechas;
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
 * @author GB_Software
 */
public class GUI_Parametros_Facturacion extends javax.swing.JInternalFrame {

    /**
     * Creates new form GUI_A_Prod
     */
    private Conexion r_con;
    private Usuario usr;
    private Fechas fecha=new Fechas();
 
    
    public GUI_Parametros_Facturacion(Usuario u, Conexion con) {
        usr = u;
        r_con=con;      
        initComponents(); 
        cargarComboPV();
        cargarComboComprobante();
        cargarFechaFacturacion();
        jTextField1.setText("");
        jTextField1.setEditable(false);
        jTextField2.setText("");
        jButton3.setEnabled(false);
    }

    private void cargarFechaFacturacion(){
        r_con.Connection();
        ResultSet rs=r_con.Consultar("select * from parametros_facturacion");
        try{
            if(rs.next()){
                fecha_factura.setText(fecha.convertirBarras(rs.getString(1)));
            }
        }
        catch(Exception e){}
        finally{r_con.cierraConexion();}
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fecha_factura = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();

        setBackground(new java.awt.Color(204, 204, 204));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gestion Parametros de Facturacion");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/articulo.png"))); // NOI18N
        setInheritsPopupMenu(true);

        combo_punto_venta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PV" }));
        combo_punto_venta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                combo_punto_ventaFocusLost(evt);
            }
        });

        combo_tipo_comprobante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Factura", "Nota de Débito", "Nota de Crédito", "Recibo" }));
        combo_tipo_comprobante.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                combo_tipo_comprobanteFocusLost(evt);
            }
        });

        jTextField1.setToolTipText("");

        jTextField2.setToolTipText("");
        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField2FocusLost(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/aceptar.png"))); // NOI18N
        jButton3.setText("Aplicar Cambios");
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
        jLabel1.setText("Parametros Facturacion");

        jLabel2.setText("Ultimo:");

        jLabel3.setText("Nuevo:");

        jLabel4.setText("Punto de Venta:");

        jLabel5.setText("Tipo Comprobante:");

        jLabel8.setForeground(java.awt.Color.red);
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("  ");

        jLabel6.setText("Ultima Fecha Facturacion:");

        try {
            fecha_factura.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fecha_factura.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fecha_facturaFocusLost(evt);
            }
        });

        jLabel7.setText("Contraseña Administrador:");

        jPasswordField1.setText("jPasswordField1");
        jPasswordField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordField1FocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3))
                .addContainerGap(145, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(fecha_factura, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(combo_punto_venta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(combo_tipo_comprobante, 0, 183, Short.MAX_VALUE))))
                                .addGap(0, 75, Short.MAX_VALUE)))
                        .addContainerGap())))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_tipo_comprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fecha_factura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(46, 46, 46))
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
        int nuevo=Integer.parseInt(jTextField2.getText());
        r_con.Connection();
        r_con.ActualizarSinCartel("update ptoventa_x_tipocomprobante set vxc_numero="+nuevo+" where vxc_id_pto_venta="+pv+" and vxc_id_tipo_comprobante="+nc);
        r_con.cierraConexion();
        dispose();        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void fecha_facturaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fecha_facturaFocusLost
        if(!fecha.isFechaValida(fecha_factura.getText())){
            mensajeError("La fecha es invalida");
            fecha_factura.requestFocusInWindow();
        }       
    }//GEN-LAST:event_fecha_facturaFocusLost

    private void combo_tipo_comprobanteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo_tipo_comprobanteFocusLost
        
      cargarUltimo();
    }//GEN-LAST:event_combo_tipo_comprobanteFocusLost

    private void jPasswordField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField1FocusLost
        // TODO add your handling code here:        
        if(usr.getContraseña().equals(jPasswordField1.getText())){
            jButton3.setEnabled(true);
        }
        else
        {
            jButton3.setEnabled(false);
            mensajeError("La contraseña es incorrecta");        
        }
    }//GEN-LAST:event_jPasswordField1FocusLost

    private void jPasswordField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField1FocusGained
        // TODO add your handling code here:
        jPasswordField1.setText("");
    }//GEN-LAST:event_jPasswordField1FocusGained

    private void jTextField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusLost
        // TODO add your handling code here:
        try{
            int nuevo=Integer.parseInt(jTextField2.getText());
            mensajeError(" ");
        }
        catch(Exception e){
            jTextField2.requestFocusInWindow();
            mensajeError("Debe ingresar un valor numérico");}
    }//GEN-LAST:event_jTextField2FocusLost

    private void combo_punto_ventaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo_punto_ventaFocusLost
        cargarUltimo();
    }//GEN-LAST:event_combo_punto_ventaFocusLost
                  
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox combo_punto_venta;
    private javax.swing.JComboBox combo_tipo_comprobante;
    private javax.swing.JFormattedTextField fecha_factura;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

    public void setTitleLabel (String t){
            this.jLabel1.setText(t);
    }

    private void cargarUltimo(){
        
        System.out.println(combo_punto_venta.getSelectedItem()!=null);
        System.out.println(combo_tipo_comprobante.getSelectedItem()!=null);
        if((combo_punto_venta.getSelectedItem()!=null)&&(combo_tipo_comprobante.getSelectedItem()!=null)){
            
            String pv = combo_punto_venta.getSelectedItem().toString();
            String [] separar = pv.split("-");
            pv=separar[0].trim();        
            //obtengo el tipo de comprobante para el numero de factura
            String nc = combo_tipo_comprobante.getSelectedItem().toString();
            separar = nc.split("-");
            nc=separar[0].trim();

            r_con.Connection();
            ResultSet rs=r_con.Consultar("select vxc_numero from ptoventa_x_tipocomprobante where vxc_id_pto_venta="+pv+" and vxc_id_tipo_comprobante="+nc);
            try{
               if(rs.next()){
                   jTextField1.setText(rs.getInt(1)+"");               
               }             
            }
            catch(Exception e){}
            finally{r_con.cierraConexion();}  
        }  
        
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
        jLabel8.setText(msj);        
    }
    
    private void cargarComboPV(){
        try {
            combo_punto_venta.removeAllItems();
            r_con.Connection();            
            ResultSet res = r_con.Consultar("SELECT * FROM punto_venta WITH (INDEX(PK_pv_codigo)) ");            

            while(res.next()){
               combo_punto_venta.addItem(res.getString(1)+ " - "+res.getString(2)); 
            }
            combo_punto_venta.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cargarUltimo();
            }
            });
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
            combo_tipo_comprobante.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cargarUltimo();
            }
            });
            
        } catch (SQLException ex) {
            Logger.getLogger(IGUI_Asignar_Pto_Venta_Comprobante.class.getName()).log(Level.SEVERE, null, ex);
        } finally {            
            r_con.cierraConexion();
        } 
    }
  

}
