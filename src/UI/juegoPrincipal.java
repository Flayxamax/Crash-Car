/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import static UI.Juego.chocado;
import static UI.Juego.crash;
import control.Control;
import dao.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Flayxamax
 */
public class juegoPrincipal extends Thread {

    static String usuario = "";
    ImageIcon icon = new ImageIcon(getClass().getResource("/img/carCrashed.gif"));

    /**
     * Método que obtiene el usuario
     *
     * @return Usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Método que setea el usuario
     *
     * @param usuario Usuario que se quiere registrar
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Método que comienza a correr el juego Seteando el tamaño, su visibilidad
     * y establece el icono del juego
     */
    public void run() {
        JFrame ventana = new JFrame("Crash Car - Usuario: " + usuario);
        Juego game = new Juego(usuario);
        ventana.add(game);
        ventana.setSize(1000, 967);
        ventana.setVisible(true);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setIconImage(new ImageIcon(getClass().getResource("/img/iconGame.png")).getImage());
        game.reiniciaJuego();

        //Comprueba constantemente si el carro choco  y  permite al usuario iniciar de nuevo
        while (true) {
            if (chocado) {
                crash.play();
                Usuario user = new Usuario();
                Control control = new Control();
                user.setUsuario(this.getUsuario());
                user = control.obtener(ventana, user);
                if (user != null) {
                    int puntos = game.bache.obtenerPuntos();
                    if (user.getPuntuacion() < puntos) {
                        user.setPuntuacion(puntos);
                    }
                    control.actualizar(ventana, user);
                }
                String options[] = {"Seguir manejando", "Salir"};
                int x = JOptionPane.showOptionDialog(null, "¡CAISTE EN UN OBSTACULO!\n"
                        + "Usuario: " + usuario
                        + "\nObstaculos esquivados: " + game.bache.obtenerPuntos(), "GAME OVER", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, options, options[0]);
                if (x == 0) {
                    game.reiniciaJuego();
                } else if (x == 1) {
                    game.detener();
                    game.reiniciaJuego();
                    ventana.dispose();
                    frmPrincipal prin = new frmPrincipal();
                    prin.setVisible(true);
                    return;
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
            }
            game.repaint();
        }
    }
}
