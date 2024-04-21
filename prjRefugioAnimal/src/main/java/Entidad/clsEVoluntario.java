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
public class clsEVoluntario {
        
    private int idVoluntario;
    private LocalDate  fecha;
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
    private String edad;
    private String clave;
    //private int idCargo;
    
    public static enum Estado {
    activo,
    inactivo
    }
    private Estado estado;
    private String dni;
    

    public clsEVoluntario() {
    }

    public clsEVoluntario(int idVoluntario, LocalDate fecha, String nombres, String apellidos, String direccion, Genero genero, String ocupacion, String edad, String clave, Estado estado, String dni) {
        this.idVoluntario = idVoluntario;
        this.fecha = fecha;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.genero = genero;
        this.ocupacion = ocupacion;
        this.edad = edad;
        this.clave = clave;
        this.estado = estado;
        this.dni = dni;
    }

    public int getIdVoluntario() {
        return idVoluntario;
    }

    public void setIdVoluntario(int idVoluntario) {
        this.idVoluntario = idVoluntario;
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

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    

}