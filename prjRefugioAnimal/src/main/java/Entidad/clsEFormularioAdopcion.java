/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

import java.time.LocalDate;

/**
 *
 * @author mario
 */
public class clsEFormularioAdopcion {

    public clsEFormularioAdopcion(int idformularioadopcion, LocalDate fecha, String p1, String p2, String p3, String p4, String p5, int idusuarioregistro, Estado estado) {
        this.idformularioadopcion = idformularioadopcion;
        this.fecha = fecha;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.p5 = p5;
        this.idusuarioregistro = idusuarioregistro;
        this.estado = estado;
    }

    public int getIdformularioadopcion() {
        return idformularioadopcion;
    }

    public void setIdformularioadopcion(int idformularioadopcion) {
        this.idformularioadopcion = idformularioadopcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }

    public String getP3() {
        return p3;
    }

    public void setP3(String p3) {
        this.p3 = p3;
    }

    public String getP4() {
        return p4;
    }

    public void setP4(String p4) {
        this.p4 = p4;
    }

    public String getP5() {
        return p5;
    }

    public void setP5(String p5) {
        this.p5 = p5;
    }

    public int getIdusuarioregistro() {
        return idusuarioregistro;
    }

    public void setIdusuarioregistro(int idusuarioregistro) {
        this.idusuarioregistro = idusuarioregistro;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    
    
    private int idformularioadopcion;

    private LocalDate fecha;
    private String p1;
    private String p2;
    private String p3;
    private String p4;
    private String p5;
    private int idusuarioregistro;
    public static enum Estado {
    aprobado,pendiente,
    rechazado,
    }
    private Estado estado;

    
    public clsEFormularioAdopcion() {
    }
}
