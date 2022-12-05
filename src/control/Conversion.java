/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.Usuario;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Flayxamax
 */
public class Conversion {

    String nombresColumnasTablaUsuario[] = {"Nombre de Usuario", "Puntuación Máxima"};

    /**
     * Metodo que recoore la lista de usuarios que almacena el nombre y la
     * puntuacion del usuario para guardarlos en un arreglo
     *
     * @param listaUsuarios Lista de usuarios
     * @return El arreglo con los nombres y puntajes del usuario
     */
    public DefaultTableModel usuariosTableModel(List<Usuario> listaUsuarios) {
        Object tabla[][];
        if (listaUsuarios != null) {
            tabla = new Object[listaUsuarios.size()][2];
            for (int i = 0; i < listaUsuarios.size(); i++) {
                // Obten un publicacionED de la lista de usuarios
                Usuario usuario = listaUsuarios.get(i);
                // Almacena sus atributos en la fila del arreglo
                tabla[i][0] = usuario.getUsuario();
                tabla[i][1] = usuario.getPuntuacion();
            }
            return new DefaultTableModel(tabla, nombresColumnasTablaUsuario);
        }
        return null;
    }
}
