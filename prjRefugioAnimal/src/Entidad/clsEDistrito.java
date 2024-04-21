/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

/**
 *
 * @author zouoz
 */
public class clsEDistrito {
    private int iddistrito;
    private String nombre;

    public clsEDistrito() {
    }

    public clsEDistrito(int iddistrito, String nombre) {
        this.iddistrito = iddistrito;
        this.nombre = nombre;
    }

    public int getIddistrito() {
        return iddistrito;
    }

    public void setIddistrito(int iddistrito) {
        this.iddistrito = iddistrito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
