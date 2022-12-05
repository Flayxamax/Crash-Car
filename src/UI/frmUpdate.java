/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import control.Control;
import control.CustomFont;
import dao.Usuario;
import java.applet.AudioClip;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import validadores.Validadores;

/**
 *
 * @author Flayxamax
 */
public class frmUpdate extends javax.swing.JFrame {
    
    private Usuario usuario;
    private int operacion;
    private StringBuffer respuesta;
    private Validadores validadores=new Validadores();
    
    /**
     * Constructor de ventana de actualizar usuario
     * 
     * @param user Usuario
     */
    public frmUpdate(Usuario user) {
        initComponents();
        setResizable(false);
        setTitle("Actualizando usuario: "+user.getUsuario());
        setIconImage(new ImageIcon(getClass().getResource("/img/iconGame.png")).getImage());
        setSize(839,600);
        usuario=user;
        setVisible(true);
        txtUsuario.setText(user.getUsuario());
        txtClave.setText(user.getPassword());
        txtNombre.setText(user.getNombre());
        txtEmail.setText(user.getCorreo());
        txtUsuario.setEditable(false);
        CustomFont cf = new CustomFont();
        btnNuevo.setFont(cf.MyFont(0, 17));
        btnActualizar.setFont(cf.MyFont(0, 17));
        btnSalir.setFont(cf.MyFont(0, 17));
        txtUsuario.setFont(cf.MyFont(0, 30));
        txtNombre.setFont(cf.MyFont(0, 30));
        txtEmail.setFont(cf.MyFont(0, 30));
    }

    public frmUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsuario1 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        espacio = new javax.swing.JLabel();
        espacio2 = new javax.swing.JLabel();
        espacio3 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        espacio4 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        txtEmail = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtClave = new javax.swing.JPasswordField();
        imgCarro = new javax.swing.JLabel();
        lblPlayer = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblBg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsuario1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(lblUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 38, -1, -1));

        jToolBar1.setBackground(new java.awt.Color(204, 204, 255));
        jToolBar1.setFloatable(false);

        btnNuevo.setBackground(new java.awt.Color(204, 204, 255));
        btnNuevo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(0, 0, 0));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Nuevo.png"))); // NOI18N
        btnNuevo.setText("Regresar");
        btnNuevo.setFocusable(false);
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNuevo);

        espacio.setText("       ");
        jToolBar1.add(espacio);

        espacio2.setText("              ");
        jToolBar1.add(espacio2);

        espacio3.setText("       ");
        jToolBar1.add(espacio3);

        btnActualizar.setBackground(new java.awt.Color(204, 204, 255));
        btnActualizar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(0, 0, 0));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Actualizar.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setFocusable(false);
        btnActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnActualizar);

        espacio4.setText("                                                                                                                                                                                 ");
        jToolBar1.add(espacio4);

        btnSalir.setBackground(new java.awt.Color(204, 204, 255));
        btnSalir.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(0, 0, 0));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Inicio.png"))); // NOI18N
        btnSalir.setText("Cerrar");
        btnSalir.setFocusable(false);
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSalir);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 70));

        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 280, 30));

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 280, 30));

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 280, 30));
        getContentPane().add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 280, 30));

        imgCarro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carU.gif"))); // NOI18N
        getContentPane().add(imgCarro, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 320, -1, -1));

        lblPlayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/racer.gif"))); // NOI18N
        getContentPane().add(lblPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, -1, -1));

        lblUsuario.setFont(new java.awt.Font("Trebuchet MS", 0, 28)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reg.png"))); // NOI18N
        getContentPane().add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, 310));

        lblBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/roadbgR.gif"))); // NOI18N
        getContentPane().add(lblBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        AudioClip Sound; //Sonido botón
        Sound = java.applet.Applet.newAudioClip(getClass().getResource("/audio/ClicSFX.wav"));
        Sound.play();
        frmLogin log = new frmLogin();
        log.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        AudioClip Sound; //Sonido botón
        Sound = java.applet.Applet.newAudioClip(getClass().getResource("/audio/ClicSFX.wav"));
        Sound.play();
        txtUsuario.setText(usuario.getUsuario());
        txtClave.setText(usuario.getPassword());
        txtNombre.setText(usuario.getNombre());
        txtEmail.setText(usuario.getCorreo());
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        AudioClip Sound; //Sonido botón
        Sound = java.applet.Applet.newAudioClip(getClass().getResource("/audio/ClicSFX.wav"));
        Sound.play();
        if(!validadores.validaUsuario(txtUsuario.getText())){
            JOptionPane.showMessageDialog(this, "Usuario inválido, debe contener entre 5 y 20 caracteres", "Error", 0);
        }else{
//            String clave=String.valueOf(txtClave.getPassword());
            String clave="";
            for(int i=0;i<txtClave.getPassword().length;i++){
                clave=clave+txtClave.getPassword()[i];
            }
            if(!validadores.validaPassword(clave)){
                JOptionPane.showMessageDialog(this, "Clave inválida, debe contener entre 8 y 15 caracteres", "Error", 0);
            }else{
                if(!validadores.validaNombre(txtNombre.getText())){
                    JOptionPane.showMessageDialog(this, "Nombre inválido, debe contener entre 5 y 50 caracteres", "Error", 0);
                }else{
                    if(!validadores.validaCorreo(txtEmail.getText())){
                        JOptionPane.showMessageDialog(this, "Correo inválido, no cumple con los requisitos", "Error", 0);
                    }else{
                        usuario.setUsuario(txtUsuario.getText());
                        usuario.setPassword(clave);
                        usuario.setNombre(txtNombre.getText());
                        usuario.setCorreo(txtEmail.getText());
                        control.actualizar(this, usuario);
                        dispose();
                        frmLogin principal=new frmLogin();
                        principal.setVisible(true);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        // TODO add your handling code here:
        if(txtClave.getPassword().length>=15){
            evt.consume();
        }
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
        if(txtNombre.getText().length()>=50){
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyTyped
        // TODO add your handling code here:
        if(txtEmail.getText().length()>41){
            evt.consume();
        }
    }//GEN-LAST:event_txtEmailKeyTyped


    Control control=new Control();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel espacio;
    private javax.swing.JLabel espacio2;
    private javax.swing.JLabel espacio3;
    private javax.swing.JLabel espacio4;
    private javax.swing.JLabel imgCarro;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblBg;
    private javax.swing.JLabel lblPlayer;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuario1;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
