/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import Clases_Auxiliares.Conexion;
import java.awt.Component;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Manolo
 */
public class GUI_Login extends javax.swing.JInternalFrame {

    /**
     * Creates new form GUI_A_Prod
     */
    private Conexion r_con = new Conexion();
    
    public GUI_Login() {
        initComponents();
        r_con.Connection();  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Login");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/articulo.png"))); // NOI18N
        setInheritsPopupMenu(true);

        jTextField1.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setText("Contraseña");

        jPasswordField1.setText("jPasswordField1");
        jPasswordField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordField1FocusGained(evt);
            }
        });
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyPressed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/aceptar.png"))); // NOI18N
        jButton2.setText("Aceptar");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
        jLabel1.setText("LOGUEO");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("Usuario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPasswordField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField1FocusGained
        // TODO add your handling code here:
        jPasswordField1.setText("");
    }//GEN-LAST:event_jPasswordField1FocusGained

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jPasswordField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10){
            String usuario="";
            usuario=jTextField1.getText();
            String pass="";
            int id_usuario=-1;
            pass=jPasswordField1.getText();
            if((!usuario.equals(""))&&(!pass.equals(""))){
                try {
                    String consulta="";
                    consulta="select usr_id_usuario from usuario where usr_nombre_usuario='"+usuario+"' and usr_contraseña='"+pass+"'";
                    ResultSet rs=r_con.Consultar(consulta);
                    while(rs.next()){
                        id_usuario=rs.getInt(1);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(GUI_Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(id_usuario!=-1){                    
                    dispose();
                }
                else
                JOptionPane.showMessageDialog(null,"El usuario ingresado o la contraseña no son correctas");
            }
            else{
                if(usuario.equals(""))
                JOptionPane.showMessageDialog(null,"El campo usuario esta vacio");
                else
                JOptionPane.showMessageDialog(null,"El campo contraseña esta vacio");
            }
        }
    }//GEN-LAST:event_jPasswordField1KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String usuario="";
        usuario=jTextField1.getText();
        String pass="";
        int id_usuario=-1;
        for(char c:jPasswordField1.getPassword())
        pass=pass+c;
        if((!usuario.equals(""))&&(!pass.equals(""))){
            try {
                String consulta="";
                consulta="select usr_id_usuario from usuario where usr_nombre_usuario='"+usuario+"' and usr_contraseña='"+pass+"'";
                ResultSet rs=r_con.Consultar(consulta);
                while(rs.next()){
                    id_usuario=rs.getInt(1);
                }
            } catch (SQLException ex) {
                Logger.getLogger(GUI_Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(id_usuario!=-1){                
                dispose();
            }
            else
            JOptionPane.showMessageDialog(null,"El usuario ingresado o la contraseña no son correctas");
        }
        else{
            if(usuario.equals(""))
            JOptionPane.showMessageDialog(null,"El campo usuario esta vacio");
            else
            JOptionPane.showMessageDialog(null,"El campo contraseña esta vacio");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        r_con.cierraConexion();
    }//GEN-LAST:event_jButton1ActionPerformed

    
        
    private boolean camposNecesarios () {
       if ((jTextField1.getText().length()==0)) 
       {
            JOptionPane.showMessageDialog(null, "Complete todos los campos!","Atención",JOptionPane.WARNING_MESSAGE);
            return false;
       }
       return true;      
               
    }
    private void mostrarMSSG (Component c){
        KeyEvent ke = new KeyEvent(c, KeyEvent.KEY_PRESSED,
        System.currentTimeMillis(), InputEvent.CTRL_MASK, KeyEvent.VK_F1, KeyEvent.CHAR_UNDEFINED);
        c.dispatchEvent(ke);
    }
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

public void setTitleLabel (String t){
        this.jLabel1.setText(t);
}

public void buttonBuscar (){
    jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar.png")));
    jButton2.setText("Buscar");
    jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
}

public void buttonAceptar (){
    jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/aceptar.png")));
    jButton2.setText("Aceptar");
    jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
    
}

public void buttonEliminar (){
    jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/eliminar.png")));
    jButton2.setText("Eliminar");
    jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
}

public void buttonModificar (){
    jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/modificar.png")));
    jButton2.setText("Modificar");
    jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
}

public void buttonNuevaConsulta (){
    jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/aceptar.png")));
    jButton2.setText("Nueva Consulta");
    jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
    
}

public void form_onlySearch (){
    //this.jTextField2.setEnabled(false);
}

public void form_Complete (){
    //this.jTextField2.setEnabled(true);
}

public void limpiarForm(){
    jTextField1.setText("");
}

}
