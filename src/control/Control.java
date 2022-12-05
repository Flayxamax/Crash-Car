/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import UI.frmLogin;
import UI.frmUpdate;
import UI.frmUsuarios;
import dao.Usuario;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.table.DefaultTableModel;
import persistencia.PersistenciaUsuariosArchivos;
import validadores.Validadores;

/**
 *
 * @author Flayxamax
 */
public class Control {

    Validadores validadores = new Validadores();
    ArrayList<Usuario> usuarios = new ArrayList();
    PersistenciaUsuariosArchivos registros = new PersistenciaUsuariosArchivos();
    Usuario usuarioActual = new Usuario();
    Conversion conversion;

    /**
     * Método que agrega usuarios al archivo.
     *
     * @param frame Ventana
     * @param usuaria Usuario que se desea agregar.
     */
    public void agregaUsuario(JFrame frame, Usuario usuaria) {
        try {
            String usuario = usuaria.getUsuario();
            if (usuario == null) {
                frmUsuarios principal = new frmUsuarios();
                principal.setVisible(true);
                return;
            }
            String clave = usuaria.getPassword();
            if (clave == null) {
                return;
            }
            Usuario usuario1 = new Usuario();
            usuario1.setUsuario(usuario);
            usuario1.setPassword(clave);
            //Se valida si el usuario ingresado por el usuario cumple con los requisitos
            if (!validadores.validaUsuario(usuario)) {
                JOptionPane.showMessageDialog(frame, "Usuario inválido, debe contener entre 8 y 14 caracteres", "Error", 0);
                frmUsuarios principal = new frmUsuarios();
                principal.setVisible(true);
                return;
            }
            //Se valida si el usuario ya existe
            if (registros.obten(usuario1) != null) {
                JOptionPane.showMessageDialog(frame, "Ese nombre de usuario ya existe", "Error", 0);
            }
            usuario1 = usuaria;
            if (!"".equals(usuario1.getNombre())) {
                registros.agregar(usuario1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Error", 0);
        }
    }

    /**
     * Método que elimina usuarios del archivo.
     *
     * @param frame Ventana
     * @param usuario Usuario que se desea eliminar.
     */
    public void eliminarUsuario(Frame frame, String usuario) {
        // Usuarios instance = new Usuarios(nomArchivo);
        Usuario user = new Usuario();
        Usuario encontrado = null;

        user.setUsuario(usuario);

        try {
            encontrado = registros.obten(user);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Error: " + e.getMessage());
        }

        if (encontrado != null) {
            JPasswordField clave = new JPasswordField();
            String contra = "";

            contra = JOptionPane.showInputDialog(frame, "Contraseña",
                    "Confirmar Contraseña",
                    JOptionPane.QUESTION_MESSAGE);
            if (contra != null) {
                if (encontrado.getPassword().equals(contra)) {
                    if (JOptionPane.showConfirmDialog(frame, "¿Está seguro que desea eliminar el usuario?", "Confirmación", JOptionPane.OK_CANCEL_OPTION) == 0) {
                        try {
                            registros.eliminar(user);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(frame, "Error: " + e.getMessage());
                        }
                    }
                    frmUsuarios us = new frmUsuarios();
                    us.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(frame, "Contraseña incorrecta");
                    frmUsuarios us = new frmUsuarios();
                    us.setVisible(true);
                }
            } else {
                frmUsuarios us = new frmUsuarios();
                us.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Usuario no encontrado");
            frmUsuarios us = new frmUsuarios();
            us.setVisible(true);
        }
    }

    /**
     * Método que actualiza a los usuarios existentes en el archivo.
     *
     * @param frame Ventana
     * @param usuario Usuario que se desea actualizar.
     */
    public void actualizarUsuario(Frame frame, String usuario) {
        // Usuarios instance = new Usuarios(nomArchivo);
        Usuario user = new Usuario();
        Usuario encontrado = null;

        user.setUsuario(usuario);

        try {
            encontrado = registros.obten(user);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Error: " + e.getMessage());
        }

        if (encontrado != null) {
            JPasswordField clave = new JPasswordField();
            String contra = "";
            contra = JOptionPane.showInputDialog(frame, "Contraseña",
                    "Confirmar Contraseña",
                    JOptionPane.QUESTION_MESSAGE);
            if (contra != null) {
                if (encontrado.getPassword().equals(contra)) {
                    if (JOptionPane.showConfirmDialog(frame, "¿Está seguro que desea actualizar la informacion del usuario?", "Confirmación", JOptionPane.OK_CANCEL_OPTION) == 0) {
                        try {
                            frmUpdate actualiza = new frmUpdate(encontrado);
                            actualiza.setVisible(true);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(frame, "Error: " + e.getMessage());
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Contraseña incorrecta");
                    frmUsuarios us = new frmUsuarios();
                    us.setVisible(true);
                }
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Usuario no encontrado");
            frmUsuarios us = new frmUsuarios();
            us.setVisible(true);
        }
    }

    /**
     * Método que inicia el videojuego si el usuario si existe.
     *
     * @param frame Ventana
     * @param usuario Usuario con el que se iniciará sesión.
     * @return Regresa true en caso de que se pueda iniciar sesión de forma
     * correcta.
     */
    public boolean iniciar(Frame frame, Usuario usuario) {
        Usuario encontrado = null;
        try {
            encontrado = registros.obten(usuario);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Error: " + e.getMessage());
        }

        if (encontrado != null) {
            if (encontrado.getPassword().equals(usuario.getPassword())) {
                JOptionPane.showMessageDialog(frame, "Sesion iniciada correctamente");
                return true;
            } else {
                JOptionPane.showMessageDialog(frame, "Contraseña incorrecta");
                frmLogin log = new frmLogin();
                log.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Usuario no encontrado");
            frmLogin log = new frmLogin();
            log.setVisible(true);
        }
        return false;
    }

    /**
     * Actualiza usuario
     *
     * @param frame Ventana
     * @param user Usuario
     */
    public void actualizar(Frame frame, Usuario user) {
        try {
            registros.actualizar(user);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Error: " + e.getMessage());
        }
    }

    /**
     * Método que obtiene usuarios del archivo.
     *
     * @param frame Ventana
     * @param user Usuario que se quiere obtener.
     * @return El usuario encontrado.
     */
    public Usuario obtener(Frame frame, Usuario user) {
        try {
            return registros.obten(user);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Error: " + e.getMessage());
        }
        return null;
    }

    /**
     * Método que devuelve la tabla con las puntuaciones de cada usuario que
     * haya jugado.
     *
     * @param frame Ventana
     * @return La tabla con las puntuaciones.
     */
    public Tabla getTablaPuntuaciones(JFrame frame) {
        ArrayList<Usuario> listaUsuarios;
        try {
            // Obtiene la lista de usuarios
            listaUsuarios = registros.consultarUsuarios();
        } catch (Exception e) {
            // Si ocurrio un error al obtener la lista de la base de datos,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Error!!.",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
        String nombresColumnasTablaUsuario[] = {"Usuario", "Puntos"};
        Object tabla[][];
        if (listaUsuarios != null) {
            tabla = new Object[listaUsuarios.size()][2];
            Usuario[] arr = new Usuario[listaUsuarios.size()];
            for (int i = 0; i < listaUsuarios.size(); i++) {
                arr[i] = listaUsuarios.get(i);
            }
            MergeSort mergeSort = new MergeSort();
            mergeSort.sort(arr, 0, arr.length - 1);
            int j = 0;
            for (int i = arr.length - 1; i >= 0; i--) {
                // Obten un usuario de la lista de usuarios
                Usuario usuario = arr[i];
                // Almacena sus atributos en la fila del arreglo
                tabla[j][0] = usuario.getUsuario();
                tabla[j][1] = usuario.getPuntuacion();
                j++;
            }
            DefaultTableModel modeloTabla = new DefaultTableModel(tabla, nombresColumnasTablaUsuario);
            return new Tabla("Clasificación de puntajes", modeloTabla);
        }
        return null;
    }
}
