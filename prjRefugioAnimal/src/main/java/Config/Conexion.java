/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

/**
 *
 * @author mario
 */

import java.sql. *;

public class Conexion {
    Connection con = null;
    public Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bdrefugio","root","");
        }
        catch(ClassNotFoundException | SQLException e)
        {
            
        }
    }
    public Connection getConnection (){
        return con;
    }
}
