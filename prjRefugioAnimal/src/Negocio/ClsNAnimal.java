/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Config.Conexion;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


/**
 *
 * @author RAUL
 */
public class ClsNAnimal {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;

    public ClsNAnimal() {
        con = cn.getConnection();
    }
    
        public ResultSet mtdListarAnimal() {
        ResultSet rs = null;
        String sql = "SELECT idAnimal, nombre, fecha, estado, genero, tipo, foto FROM animal;";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }

        return rs;
    }
        
        public boolean guardarImagen(String imagePath) {
            if (con != null) {
        try {
            // Convertir la imagen a un array de bytes
            FileInputStream fis = new FileInputStream(imagePath);
            byte[] imageData = new byte[fis.available()];
            fis.read(imageData);
            fis.close();

            // Ejecutar la consulta SQL para insertar la imagen en la base de datos
            String sql = "INSERT INTO animal (foto) VALUES (?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBytes(1, imageData);
            ps.executeUpdate();

            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return false;
    }
               
      
       
        public boolean insertarDatosAnimal(String nombre, String sexo, String tipo, String imagePath) {
    String sql = "INSERT INTO animal (nombre, genero, tipo, foto, fecha) VALUES (?, ?, ?, ?, NOW())"; // Utiliza NOW() para obtener la fecha actual
    
    try {
        // Obtener la conexión a la base de datos
        Connection con = cn.getConnection();
        
        // Preparar la consulta SQL
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nombre);
        ps.setString(2, sexo);
        ps.setString(3, tipo);
        
        // imagePath contiene la ruta de la imagen seleccionada, así que deberías convertirla a bytes aquí
        // Por simplicidad, asumiré que imagePath contiene el camino correcto a la imagen
        File file = new File(imagePath);
        FileInputStream fis = new FileInputStream(file);
        ps.setBinaryStream(4, fis, (int) file.length());
        
        // Ejecutar la consulta de inserción
        int filasInsertadas = ps.executeUpdate();
        
        // Verificar si se insertaron filas
        if (filasInsertadas > 0) {
            return true; // Se insertaron los datos correctamente
        } else {
            return false; // No se pudo insertar los datos
        }
    } catch (SQLException | FileNotFoundException ex) {
        System.out.println("Error al insertar los datos del animal: " + ex.toString());
        return false;
    }
}
        
        public byte[] obtenerImagenAnimal(int idAnimal) {
        byte[] imagenBytes = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = cn.getConnection();
            String sql = "SELECT foto FROM animal WHERE idAnimal = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, idAnimal);
            rs = ps.executeQuery();

            if (rs.next()) {
                imagenBytes = rs.getBytes("foto");
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener la imagen del animal: " + ex.getMessage());
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar recursos: " + ex.getMessage());
            }
        }

        return imagenBytes;
    }
        
        public ImageIcon  mostrarImagenAnimal(int idAnimal) {
        ImageIcon imagen = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = cn.getConnection();
            String sql = "SELECT foto FROM animal WHERE idAnimal = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, idAnimal);
            rs = ps.executeQuery();

            if (rs.next()) {
                byte[] imagenBytes = rs.getBytes("foto");
                // Convertir bytes a imagen
                ByteArrayInputStream bis = new ByteArrayInputStream(imagenBytes);
                BufferedImage bImage = ImageIO.read(bis);
                imagen = new ImageIcon(bImage);
                bis.close();
            }
        } catch (SQLException | IOException ex) {
            System.out.println("Error al obtener la imagen del animal: " + ex.getMessage());
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar recursos: " + ex.getMessage());
            }
        }
    return imagen;
            }
      
}
