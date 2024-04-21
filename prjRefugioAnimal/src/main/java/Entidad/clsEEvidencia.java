/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

/**
 *
 * @author mario
 */
public class clsEEvidencia {

    public clsEEvidencia(int idevidencia, String nombre) {
        this.idevidencia = idevidencia;
        this.nombre = nombre;
    }

    public int getIdevidencia() {
        return idevidencia;
    }

    public void setIdevidencia(int idevidencia) {
        this.idevidencia = idevidencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    private int idevidencia;
    private String nombre;
    
    public clsEEvidencia() {
    }
}
