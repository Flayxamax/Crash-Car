/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;

/**
 *
 * @author Flayxamax
 */
public class Carro {

    static int car;
    public static int x = 50, y = 550; //Ubicación del carro inicial
    
    /**
     * Regresa el carro
     * 
     * @return carro
     */
    public int getCarro() {
        return car;
    }
    
    /**
     * Setea el carro
     * 
     * @param car carro
     */
    
    public void setCarro(int car) {
        this.car = car;
    }
    
    /**
     * Dibujado del sprite del carro a elegir
     * 
     * @param g dibujo
     */
    public void paint(Graphics2D g) {
        int pos = car;
        switch (pos) {
            case 0:
                ImageIcon carro = new ImageIcon(getClass().getResource("/img/car.gif"));
                g.drawImage(carro.getImage(), x, y, 150, 100, null);
                break;
            case 1:
                ImageIcon carro2 = new ImageIcon(getClass().getResource("/img/bus.gif"));
                g.drawImage(carro2.getImage(), x, y, 150, 100, null);
                break;
            case 2:
                ImageIcon carro3 = new ImageIcon(getClass().getResource("/img/car4.gif"));
                g.drawImage(carro3.getImage(), x, y, 150, 100, null);
                break;
        }

        //Hitbox
        //g.fill(getBoundsCarro());
    }
    
    /**
     * Movimiento mediante teclas del carro
     * 
     * @param e tecla
     */
    public void keyPressed(KeyEvent e) {
        //Limite izq
        if (e.getKeyCode() == 37) {
            if (x > 0) {
                x = x - 50;
            }
        }
        
        //Limite der
        if (e.getKeyCode() == 39) {
            if (x < 847) {
                x = x + 50;
            }
        }
        
        //Limite arriba
        if (e.getKeyCode() == 38) {
            if (y > 300) {
                y = y - 150;
            }
        }
        
        //Limite abajo
        if (e.getKeyCode() == 40) {
            if (y <= 600) {
                y = y + 150;
            }
        }
    }
    
    /**
     * Metodo que dibuja el area hitbox del carro
     * 
     * @return Area
     */
    public Rectangle2D getBoundsCarro() {
        //Hitbox del carro
        return new Rectangle2D.Double(x + 15, y + 15, 125, 75);
    }
}
