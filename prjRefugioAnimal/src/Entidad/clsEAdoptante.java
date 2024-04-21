/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

import java.time.LocalDate;


/**
 *
 * @author zouoz
 */
public class clsEAdoptante {
    private int idAdoptante;
    private LocalDate fecha;
    private String nombres;
    private String apellidos;
    private String direccion;
    //private int idDistrito;
    public static enum Genero {
    masculino,
    femenino
    }
    private Genero genero;
    private String ocupacion;
    private String celular;
    private String edad;
    public clsEAdoptante(){
    }

    public clsEAdoptante(int idAdoptante, LocalDate fecha, String nombres, String apellidos, String direccion, Genero genero, String ocupacion, String celular, String edad) {
        this.idAdoptante = idAdoptante;
        this.fecha = fecha;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.genero = genero;
        this.ocupacion = ocupacion;
        this.celular = celular;
        this.edad = edad;
    }

    public int getIdAdoptante() {
        return idAdoptante;
    }

    public void setIdAdoptante(int idAdoptante) {
        this.idAdoptante = idAdoptante;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
    
    
  
    


}
