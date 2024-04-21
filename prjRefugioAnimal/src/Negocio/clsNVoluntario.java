/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Config.Conexion;
import Entidad.clsEAdmin;
import Entidad.clsEDistrito;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Entidad.clsEVoluntario;
/**
 *
 * @author zouoz
 */
public class clsNVoluntario {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs; //almaceba datos en la consulta
    Statement st;
    clsEVoluntario A = new clsEVoluntario();
    
    public boolean mtdGuardarVoluntario(clsEVoluntario objVo, clsEDistrito objDi) {
        String SQL ="INSERT INTO voluntario(fecha,nombres,apellidos,direccion,idDistrito,genero,ocupacion,"
               + "edad,clave,estado,dni )"
        +"VALUES ('"+objVo.getFecha()+"','"+objVo.getNombres()+"','"+objVo.getApellidos()+
        "','"+objVo.getDireccion()+"','"+objDi.getIddistrito()+"','"+objVo.getGenero()+"','"+objVo.getOcupacion()+
               "','"+objVo.getEdad()+"','"+objVo.getClave()+"','"+objVo.getEstado()+"','"+objVo.getDni()+"')";
        

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

    
    public ResultSet mtdValidarVoluntario(clsEVoluntario objEv) {
        ResultSet rs = null;
        String SQL = "SELECT * FROM voluntario " +
                     "WHERE DNI = '" + objEv.getDni()+
                     "' AND clave = '" + objEv.getClave()+ "';";
        try {
            con = (Connection) cn.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(SQL);
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
        return rs;
    }
}
