/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

/**
 *
 * @author mario
 */
public class clsEAdmin {

    private String dni;
    private String contraseña;
    
    public clsEAdmin(){
    }
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    

    public clsEAdmin(String dni, String contraseña) {
        this.dni = dni;
        this.contraseña = contraseña;
    }
}
