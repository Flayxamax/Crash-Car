/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;

/**
 *
 * @author Flayxamax
 */
public class Bache {

    //Coordenadas iniciales
    public static int xBache1 = 1000, yBache1 = 400;
    public static int xBache2 = 1400, yBache2 = 700;
    public static int xBache3 = 1700, yBache3 = 500;
    public static int xBache4 = 1900, yBache4 = 400;

    //Valores
    public static int puntos = 0;
    public static int nivel = 1;
    public Juego j;
    int incremento = 5;
    Area b1, b2, b3, b4, bacheArea;
    int inicioY = 800;
    int inicioX = 10;
    int finX = 1000;
    int finY = 900;
    boolean a, b, c, d = true;
    int ran1 = 1;
    int ran2 = 3;
    int ran3 = 5;

    /**
     * Constructor obstaculo
     *
     * @param j2 Juego
     */
    public Bache(Juego j2) {
        this.j = j2;
    }

    /**
     * Metodo para dibujar las imagenes de los obstaculo
     *
     * @param g Dibujo
     */
    public void paint(Graphics2D g) {

        ImageIcon perro = new ImageIcon(getClass().getResource("/img/perro.gif"));

        //Si el nivel es 1 spawnea  aleatoriamente un bache o un cono que fungiran como obstaculos a esquivar
        if (nivel >= 1) {
            while (a) {
                ran1 = (int) (Math.random() * (3 - 1) + 1);
                break;
            }
            a = false;

            switch (ran1) {
                case 1:
                    ImageIcon ob1 = new ImageIcon(getClass().getResource("/img/bache.png"));
                    g.drawImage(ob1.getImage(), xBache1, yBache1, 100, 100, null);
                    break;
                case 2:
                    ImageIcon ob2 = new ImageIcon(getClass().getResource("/img/cono.png"));
                    g.drawImage(ob2.getImage(), xBache1, yBache1, 100, 100, null);
                    break;
            }
        }
        //Si el nivel es 2 spawnea aleatoriamente dos tipos de npc que fungiran como obstaculos a esquivar
        if (nivel >= 2) {
            while (b) {
                ran2 = (int) (Math.random() * (5 - 3) + 3);
                break;
            }
            b = false;
            switch (ran2) {
                case 3:
                    ImageIcon person = new ImageIcon(getClass().getResource("/img/npc.gif"));
                    g.drawImage(person.getImage(), xBache2, yBache2, 100, 100, null);
                    break;
                case 4:
                    ImageIcon person2 = new ImageIcon(getClass().getResource("/img/npc2.gif"));
                    g.drawImage(person2.getImage(), xBache2, yBache2, 100, 100, null);
                    break;
            }
        }
        //Si el nivel es 3 spawnea aleatoriamente 3 tipos de bicicletas que fungiran como obstaculos a esquivar
        if (nivel >= 3) {
            while (c) {
                ran3 = (int) (Math.random() * (8 - 5) + 5);
                break;
            }
            c = false;
            switch (ran3) {
                case 5:
                    ImageIcon bici = new ImageIcon(getClass().getResource("/img/bici.gif"));
                    g.drawImage(bici.getImage(), xBache3, yBache3, 100, 100, null);
                    break;
                case 6:
                    ImageIcon bici2 = new ImageIcon(getClass().getResource("/img/bici2.gif"));
                    g.drawImage(bici2.getImage(), xBache3, yBache3, 100, 100, null);
                    break;
                case 7:
                    ImageIcon bici3 = new ImageIcon(getClass().getResource("/img/bici3.gif"));
                    g.drawImage(bici3.getImage(), xBache3, yBache3, 100, 100, null);
                    break;
            }
        }
        //Si el nive es 4 spawnea  aleatoriamente un perro que fungiran como obstaculo a esquivar
        if (nivel >= 4) {
            g.drawImage(perro.getImage(), xBache4, yBache4, 100, 100, null);
        }
    }

    /**
     * Metodo que comprueba si el area colisiona
     *
     * @return colisión
     */
    public boolean choque() {
        Area areaPersonaje = new Area(j.carro.getBoundsCarro());
        areaPersonaje.intersect(getBoundsBache());
        return !areaPersonaje.isEmpty();
    }

    /**
     * Metodo que mueve el obstaculo
     *
     */
    public void mover() {
        if (choque()) {
            j.chocado = true;
        }
        //Si es el nivel 1 mueve los baches a cierta velocidad
        if (nivel >= 1) {
            if (xBache1 == -60) {
                xBache1 = 1000;
                yBache1 = (int) (Math.random() * (100 - 600) + 700);
                puntos++;
                nivel++;
                a = true;
            } else {
                a = false;
                xBache1 = xBache1 - incremento;
            }
        }
        //Si es el nivel 2 mueve los bache a una velocidad mayor al nivel 1
        if (nivel >= 2) {
            if (xBache2 == -60) {
                xBache2 = 1400;
                yBache2 = (int) (Math.random() * (100 - 600) + 700);
                puntos++;
                nivel++;
                b = true;
            } else {
                b = false;
                xBache2 = xBache2 - incremento;
            }
        }
        //Si es el nivel 3 mueve los bache a una velocidad mayor al nivel 2
        if (nivel >= 3) {
            if (xBache3 == -60) {
                xBache3 = 1600;
                yBache3 = (int) (Math.random() * (100 - 600) + 700);
                puntos++;
                nivel++;
                c = true;
            } else {
                c = false;
                xBache3 = xBache3 - incremento;
            }
        }
        //Si es el nivel 4 mueve los bache a una velocidad mayor al nivel 3
        if (nivel >= 4) {
            if (xBache4 == -60) {
                xBache4 = 1800;
                yBache4 = (int) (Math.random() * (100 - 600) + 700);
                puntos++;
                nivel++;
            } else {
                xBache4 = xBache4 - incremento;
            }
        }
    }

    /**
     * Metodo que regresa el puntaje hecho
     *
     * @return puntos
     */
    public int obtenerPuntos() {
        return puntos;
    }

    /**
     * Metodo que dibuja el area hitbox del obstaculo
     *
     * @return AreaObstaculo
     */
    public Area getBoundsBache() {
        Ellipse2D bache1, bache2, bache3, bache4;

        bache4 = new Ellipse2D.Double(xBache4 + 25, yBache4 + 25, 55, 55);
        b4 = new Area(bache4);
        bacheArea = b4;

        if (nivel >= 1) {
            bache1 = new Ellipse2D.Double(xBache1 + 25, yBache1 + 25, 55, 55);
            b1 = new Area(bache1);
            bacheArea.add(b1);
        }

        if (nivel >= 2) {
            bache2 = new Ellipse2D.Double(xBache2 + 25, yBache2 + 25, 55, 55);
            b2 = new Area(bache2);
            bacheArea.add(b2);
        }

        if (nivel >= 3) {
            bache3 = new Ellipse2D.Double(xBache3 + 25, yBache3 + 25, 55, 55);
            b3 = new Area(bache3);
            bacheArea.add(b3);
        }

        if (nivel >= 4) {
            bache4 = new Ellipse2D.Double(xBache4 + 25, yBache4 + 25, 55, 55);
            b4 = new Area(bache4);
            bacheArea.add(b4);
        }
        return bacheArea;
    }
}
