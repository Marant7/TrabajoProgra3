/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

/**
 *
 * @author mario
 */
public class Sesion {
   
    private static int idUsuarioActual;

    // Método para establecer el ID del usuario actualmente autenticado
    public static void setUsuarioActual(int idUsuario) {
        idUsuarioActual = idUsuario;
    }

    // Método para obtener el ID del usuario actualmente autenticado
    public static int obtenerIdUsuarioActual() {
        return idUsuarioActual;
    }
}
