/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.Graphics2D;
import javax.swing.ImageIcon;

/**
 *
 * @author Flayxamax
 */
public class Fondo {

    Juego myGame;

    //Variables del tamaño del fondo
    int anchoFondo = 1000;
    int altoFondo = 967;

    //Coordenadas iniciales para mover el fondo
    int x1 = 1000;
    int y1 = 0;

    //Coordenadas auxiliares que mueven otro fondo
    int x2 = 0;
    int y2 = 0;

    public Fondo(Juego myGame) {
        this.myGame = myGame;
    }

    /**
     * Metodo que mueve el fondo para generar el efecto de movimiento
     */
    public void mover() {
        x1 -= 2;
        x2 -= 2;
        if (x1 == 0 && x2 == -1000) {
            x1 = 1000;
            x2 = 0;
        }
    }

    /**
     * Método que pinta el fondo
     *
     * @param g Dibujo
     */
    public void paint(Graphics2D g) {
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/img/roadBG.jpg"));
        g.drawImage(imagenFondo.getImage(), x1, y1, anchoFondo, altoFondo, null);
        g.drawImage(imagenFondo.getImage(), x2, y2, anchoFondo, altoFondo, null);
    }
}
