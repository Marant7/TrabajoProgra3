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
        String SQL ="INSERT INTO voluntario(fecha,nombres,apellidopaterno,apellidomaterno,direccion,idDistrito,genero,ocupacion,"
               + "edad,clave,estado,dni,hora_inicio,hora_fin )"
        +"VALUES ('"+objVo.getFecha()+"','"+objVo.getNombres()+"','"+objVo.getApellidoPaterno()+"','"+objVo.getApellidoMaterno()+
        "','"+objVo.getDireccion()+"','"+objDi.getIddistrito()+"','"+objVo.getGenero()+"','"+objVo.getOcupacion()+
               "','"+objVo.getEdad()+"','"+objVo.getClave()+"','"+objVo.getEstado()+"','"+objVo.getDni()+"','"+objVo.getHora_inicio()+"','"+objVo.getHora_fin()+"')";
        

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

    //cambiooo
    public String[] mtdValidarVoluntario(clsEVoluntario objEv) {
    String[] datosVoluntario = new String[3]; // Para almacenar nombres, hora_inicio, y hora_fin
    String SQL = "SELECT nombres, hora_inicio, hora_fin FROM voluntario WHERE DNI = ? AND clave = ?;";

    try (Connection con = cn.getConnection();  // Utilizando try-with-resources para garantizar el cierre adecuado de la conexión
         PreparedStatement pstmt = con.prepareStatement(SQL)) {

        // Establecer los parámetros para la consulta preparada
        pstmt.setString(1, objEv.getDni());
        pstmt.setString(2, objEv.getClave());

        try (ResultSet rs = pstmt.executeQuery()) { // Ejecutar la consulta y manejar el ResultSet
            if (rs.next()) { // Si se encontró el voluntario
                datosVoluntario[0] = rs.getString("nombres");
                datosVoluntario[1] = rs.getString("hora_inicio");
                datosVoluntario[2] = rs.getString("hora_fin");
            }
        }
    } catch (SQLException e) {
        // Manejar cualquier excepción SQL
        System.out.println("Error en mtdValidarVoluntario: " + e.getMessage());
    }

    return datosVoluntario; // Devolver los datos del voluntario
}
}
