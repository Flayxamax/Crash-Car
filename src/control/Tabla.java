/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author Flayxamax
 */
import javax.swing.table.DefaultTableModel;

public class Tabla {
    private String titulo;
    private DefaultTableModel modeloTabla;
    /**
     * Método constructor por omisión
     */
    public Tabla(){
        
    }
    /**
     * Constructor que inicializa un objeto Tabla con un titulo y un modelo especifico
     * @param titulo titulo de la tabla
     * @param modeloTabla modelo de la tabla
     */
    public Tabla(String titulo, DefaultTableModel modeloTabla){
        this.titulo=titulo;
        this.modeloTabla=modeloTabla;
    }
    /**
     * Método get que regresa el titulo de la tabla
     * @return titulo de la tabla
     */
    public String getTitulo() {
        return titulo;
    }
    /**
     * Método set que le asigna un valor al titulo de la tabla
     * @param titulo titulo de la tabla que se le quiere asignar
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    /**
     * Método get que regresa el modelo de la tabla
     * @return un objeto DefaultTableModel que contiene el modelo de la tabla
     */
    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }
    /**
     * Método set que le asigna un valor al modeloTabla
     * @param modeloTabla modeloTabla que se le quiere asignar
     */
    public void setModeloTabla(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }
}
