/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Config.Conexion;
import Entidad.clsEAdmin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mario
 */
public class clsNAdmin {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs; //almaceba datos en la consulta
    Statement st;
    /*clsEAdmin D = new clsEAdmin();*/
    public ResultSet mtdValidarAdministrador(clsEAdmin objAd) {
        ResultSet rs = null;
        String SQL = "SELECT * FROM administrador " +
                     "WHERE DNI = '" + objAd.getDni() +
                     "' AND contraseña = '" + objAd.getContraseña() + "';";
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
