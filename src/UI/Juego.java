/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import control.Control;
import control.Tabla;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Flayxamax
 */
public class Juego extends JPanel {

    private javax.swing.JTable jtabla;
    private javax.swing.JLabel tituloTabla;
    URL direccionMusica, direccionUD, direccionCarro, direccionStart, direccionCrash;
    static AudioClip musicaFondo, carroUD, Carro, start, crash;
    public static boolean chocado = false;
    Bache bache = new Bache(this);
    Carro carro = new Carro();
    Fondo fondo = new Fondo(this);
    private final String usuario;
    boolean a = true;
    int rand;

    /**
     * Constructor que inicia los sonidos del juego y configura el movimiento
     *
     * @param usuario Usuario
     */
    public Juego(String usuario) {
        this.usuario = usuario;
        direccionStart = getClass().getResource("/audio/startSFX.wav");
        start = Applet.newAudioClip(direccionStart);
        start.play();

        direccionMusica = getClass().getResource("/audio/bgMusic.wav");
        musicaFondo = Applet.newAudioClip(direccionMusica);
        musicaFondo.loop();

        direccionUD = getClass().getResource("/audio/mudSFX.wav");
        carroUD = Applet.newAudioClip(direccionUD);

        direccionCarro = getClass().getResource("/audio/carSFX.wav");
        Carro = Applet.newAudioClip(direccionCarro);
        Carro.loop();

        direccionCrash = getClass().getResource("/audio/crashSFX.wav");
        crash = Applet.newAudioClip(direccionCrash);

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            //Metodo que permite el movimiento del jugador
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    carroUD.play();
                    carro.keyPressed(e);
                }

                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    carroUD.play();
                    carro.keyPressed(e);
                }

                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    carro.keyPressed(e);
                }

                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    carro.keyPressed(e);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        setFocusable(true);
    }

    /**
     * Método que muestra el puntaje y calle en pantalla
     *
     * @param g Dibujo
     */
    public void dibujarPuntaje(Graphics2D g) {
        Graphics2D g1 = g, g2 = g;
        //CustomFont cf = new CustomFont();
        Font score = new Font("consolas", Font.BOLD, 30);
        //g.setFont(cf.MyFont(3, 40));
        g.setFont(score);
        g.setColor(Color.darkGray);
        g2.drawString("Obstáctulos esquivados: "+bache.obtenerPuntos(), 500,30);
        while (a) {
            rand = (int) (Math.random() * (13 - 1) + 1);
            a = false;
        }
            switch (rand){
                case 1: 
                g1.drawString("Calle 200", 10, 30);
                break;
                
                case 2: 
                g1.drawString("Calle 300", 10, 30);
                break;
                
                case 3: 
                g1.drawString("Calle Miguel Aleman", 10, 30);
                break;
                
                case 4: 
                g1.drawString("Calle Kino", 10, 30);
                break;
                
                case 5: 
                g1.drawString("Calle Paris", 10, 30);
                break;
                
                case 6: 
                g1.drawString("Calle Antonio caso", 10, 30);
                break;
                
                case 7: 
                g1.drawString("Calle Morelos", 10, 30);
                break;
                
                case 8: 
                g1.drawString("Calle 400", 10, 30);
                break;
                
                case 9: 
                g1.drawString("Calle Guerrero", 10, 30);
                break;
                
                case 10: 
                g1.drawString("Calle Nainari", 10, 30);
                break;
                
                case 11: 
                g1.drawString("Calle Tabasco", 10, 30);
                break;
                
                case 12: 
                g1.drawString("Calle Las torres", 10, 30);
                break;
            } 
    }

    /**
     * Método que reinicia los valores del juego
     */
    public void reiniciaJuego() {
        bache.xBache1 = 1000;
        bache.yBache1 = 400;
        bache.xBache2 = 1400;
        bache.yBache2 = 700;
        bache.xBache3 = 1700;
        bache.yBache3 = 500;
        bache.xBache4 = 1900;
        bache.yBache4 = 400;
        fondo.altoFondo = 967;
        fondo.anchoFondo = 1000;
        fondo.x1 = 1000;
        fondo.x2 = 0;
        fondo.y1 = 0;
        fondo.y2 = 0;
        carro.x = 50;
        carro.y = 550;
        chocado = false;
        bache.puntos = 0;
        a=true;
    }

    /**
     * Método que pinta toda la pantalla con los gráficos correspondientes
     *
     * @param g Dibujo
     */
    @Override
    public void paint(Graphics g) {
        fondo.paint((Graphics2D) g);
        fondo.mover();
        dibujarPuntaje((Graphics2D) g);
        bache.paint((Graphics2D) g);
        bache.mover();
        carro.paint((Graphics2D) g);
        g.dispose();

    }

    /**
     * Método que detiene todos los componentes de sonido del videojuego
     */
    public void detener() {
        start.stop();
        musicaFondo.stop();
        Carro.stop();
    }

    /**
     * Método que muestra las puntuaciones de los usuarios
     *
     * @param frame Ventana
     */
    public void muestraPuntuaciones(JFrame frame) {
        Control control = new Control();
        Tabla tablaPuntos = control.getTablaPuntuaciones(frame);

        if (tablaPuntos != null) {
            despliegaTabla(tablaPuntos);
        }
    }

    /**
     * Método que despliega la tabla con los puntajes
     *
     * @param tabla Tabla
     */
    public void despliegaTabla(Tabla tabla) {
        // Crea la tabla a partir del modelo de la tabla con los valores
        // de los titulos de las columnas y los valores de las celdas
        jtabla = new javax.swing.JTable(tabla.getModeloTabla());

        // Establece el título de la tabla
        tituloTabla.setText(tabla.getTitulo());

        // Hace visible la tabla dentro del panel con barras de deslizamiento
        jtabla.setVisible(true);
    }

}
