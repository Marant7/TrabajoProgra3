/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Config.Conexion;
import Entidad.Sesion;
import Entidad.clsEAdmin;
import Entidad.clsEDistrito;
import Entidad.clsEEvidencia;
import Entidad.clsEFormularioAdopcion;
import Entidad.clsEVoluntario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

/**
 *
 * @author mario
 */
public class clsNFormularioAdopcion {
    

    public boolean mtdGuardarFormulario(clsEFormularioAdopcion objFo,clsEVoluntario objVO, clsEEvidencia objEVI) {
        String SQL ="INSERT INTO formularioadopcion(fecha,idvoluntario,p1,p2,p3,p4,p5,idusuarioregistro,estado,idEvidencia)"
               + "VALUES ('"+objFo.getFecha()+"','"+objVO.getIdVoluntario()+"','"+objFo.getP1()+"','"+objFo.getP2()+"','"+objFo.getP3()+"','"+objFo.getP4()+"','"+objFo.getP5()+"','"+Sesion.obtenerIdUsuarioActual()+"','"+objFo.getEstado()+"','"+objEVI.getIdevidencia()+"')";
        

        System.out.println(SQL);
        try {
            Conexion cn = new Conexion();
            Connection con = cn.getConnection();
            Statement st=con.createStatement();
            st.executeUpdate(SQL);
            return true; // Registro exitoso
            
        } catch (SQLException e){
            System.out.println("error"+e.toString());
            return false; // Fallo en el registro
        }
    }
    
}

    



