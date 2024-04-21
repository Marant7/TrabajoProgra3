/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Config.Conexion;
import Entidad.clsEAdoptante;
import Entidad.clsEDistrito;
import Entidad.clsEVoluntario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author zouoz
 */
public class clsNAdoptante {
        Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs; //almaceba datos en la consulta
    Statement st;
    clsEVoluntario A = new clsEVoluntario();
    public boolean mtdGuardarAdoptante(clsEAdoptante objEAdop, clsEDistrito objDi) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
         String SQL = "INSERT INTO adoptante(fecha, nombres, apellidos, idDistrito, genero, ocupacion, celular, edad) "
         + "VALUES ('"+objEAdop.getFecha()+"','"+objEAdop.getNombres()+"','"+objEAdop.getApellidos()+
        "','"+objDi.getIddistrito()+"','"+objEAdop.getGenero()+"','"+objEAdop.getOcupacion()+"','"+objEAdop.getCelular()+
               "','"+objEAdop.getEdad()+"')";

        System.out.println(SQL);
        try {
            con = (Connection) cn.getConnection();
            st=con.createStatement();
            st.executeUpdate(SQL);
            return true;
            
        } catch (SQLException e){
            System.out.println("error"+e.toString());
            return false;
        }
    
    
    }
    
}
