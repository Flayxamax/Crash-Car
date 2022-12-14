/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import control.Control;
import control.CustomFont;
import control.Tabla;
import java.applet.AudioClip;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Flayxamax
 */
public class frmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form frmPrincipal
     */
    public frmPrincipal() {
        initComponents();
        setResizable(false);
        setTitle("Crash car");
        setIconImage(new ImageIcon(getClass().getResource("/img/iconGame.png")).getImage());
        setSize(1000, 562);
        CustomFont cf = new CustomFont();
        lblJugar.setFont(cf.MyFont(0, 75));
        lblFAQ.setFont(cf.MyFont(0, 75));
        boxV.setFont(cf.MyFont(0, 30));

        ImageIcon tsuru = new ImageIcon(getClass().getResource("/img/car.gif"));
        Icon img = new ImageIcon(tsuru.getImage().getScaledInstance(imgV.getWidth(), imgV.getHeight(), Image.SCALE_DEFAULT));
        imgV.setIcon(img);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imgV = new javax.swing.JLabel();
        boxV = new javax.swing.JComboBox<>();
        lblApagar = new javax.swing.JLabel();
        lblPuntaje = new javax.swing.JLabel();
        lblFAQ = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblJugar = new javax.swing.JLabel();
        lblBotonJ = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblBg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(imgV, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, 320, 130));

        boxV.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        boxV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tsuru", "Cocore??o", "Troca ganadera" }));
        boxV.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boxVItemStateChanged(evt);
            }
        });
        boxV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boxVMouseClicked(evt);
            }
        });
        boxV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxVActionPerformed(evt);
            }
        });
        getContentPane().add(boxV, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 420, 320, -1));

        lblApagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/shutdown.png"))); // NOI18N
        lblApagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblApagarMouseClicked(evt);
            }
        });
        getContentPane().add(lblApagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        lblPuntaje.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lista.png"))); // NOI18N
        lblPuntaje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPuntajeMouseClicked(evt);
            }
        });
        getContentPane().add(lblPuntaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, -1, -1));

        lblFAQ.setFont(new java.awt.Font("Consolas", 0, 48)); // NOI18N
        lblFAQ.setForeground(new java.awt.Color(255, 255, 255));
        lblFAQ.setText("FAQ");
        getContentPane().add(lblFAQ, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botonAmarillo.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, -1, -1));

        lblJugar.setFont(new java.awt.Font("Consolas", 0, 48)); // NOI18N
        lblJugar.setForeground(new java.awt.Color(255, 255, 255));
        lblJugar.setText("JUGAR");
        getContentPane().add(lblJugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, -1, -1));

        lblBotonJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botonAmarillo.png"))); // NOI18N
        lblBotonJ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBotonJMouseClicked(evt);
            }
        });
        getContentPane().add(lblBotonJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, -1, -1));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/crash car.gif"))); // NOI18N
        getContentPane().add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, -1));

        lblBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bgMain.gif"))); // NOI18N
        getContentPane().add(lblBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblBotonJMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonJMouseClicked
        // TODO add your handling code here:
        AudioClip Sound; //Sonido bot??n
        Sound = java.applet.Applet.newAudioClip(getClass().getResource("/audio/ClicSFX.wav"));
        Sound.play();
        frmLogin log = new frmLogin();
        Carro car = new Carro();
        car.setCarro(boxV.getSelectedIndex());
        log.setVisible(true);
        dispose();
    }//GEN-LAST:event_lblBotonJMouseClicked

    private void boxVItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxVItemStateChanged
        // TODO add your handling code here:
        int pos;
        pos = boxV.getSelectedIndex();

        switch (pos) {
            case 0:
                ImageIcon tsuru = new ImageIcon(getClass().getResource("/img/car.gif"));
                Icon img = new ImageIcon(tsuru.getImage().getScaledInstance(imgV.getWidth(), imgV.getHeight(), Image.SCALE_DEFAULT));
                imgV.setIcon(img);
                break;
            case 1:
                ImageIcon bus = new ImageIcon(getClass().getResource("/img/bus.gif"));
                Icon img2 = new ImageIcon(bus.getImage().getScaledInstance(imgV.getWidth(), imgV.getHeight(), Image.SCALE_DEFAULT));
                imgV.setIcon(img2);
                break;
            case 2:
                ImageIcon agro = new ImageIcon(getClass().getResource("/img/car4.gif"));
                Icon img3 = new ImageIcon(agro.getImage().getScaledInstance(imgV.getWidth(), imgV.getHeight(), Image.SCALE_DEFAULT));
                imgV.setIcon(img3);
                break;
        }
    }//GEN-LAST:event_boxVItemStateChanged

    private void boxVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxVActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        AudioClip Sound; //Sonido bot??n
        Sound = java.applet.Applet.newAudioClip(getClass().getResource("/audio/ClicSFX.wav"));
        Sound.play();
        FAQ faq = new FAQ();
        faq.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void lblPuntajeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPuntajeMouseClicked
        // TODO add your handling code here:
        AudioClip Sound; //Sonido bot??n
        Sound = java.applet.Applet.newAudioClip(getClass().getResource("/audio/ClicSFX.wav"));
        Sound.play();
        Tabla puntuaciones = control.getTablaPuntuaciones(this);
        if (puntuaciones != null) {
            despliegaTabla(puntuaciones);
        }

    }//GEN-LAST:event_lblPuntajeMouseClicked

    private void lblApagarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblApagarMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_lblApagarMouseClicked

    private void boxVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxVMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_boxVMouseClicked

    public void despliegaTabla(Tabla tabla) {
        // Crea la tabla a partir del modelo de la tabla con los valores
        // de los titulos de las columnas y los valores de las celdas
        dlgPuntuaciones puntos = new dlgPuntuaciones(this, true, tabla);
        puntos.setVisible(true);
    }

    Control control = new Control();

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxV;
    private javax.swing.JLabel imgV;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblApagar;
    private javax.swing.JLabel lblBg;
    private javax.swing.JLabel lblBotonJ;
    private javax.swing.JLabel lblFAQ;
    private javax.swing.JLabel lblJugar;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblPuntaje;
    // End of variables declaration//GEN-END:variables
}
