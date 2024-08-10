/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import Controlador.clsVideo;
import Seguridad.Modelo.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author macho
 */

/*DAO CREADO POR CARLOS HERNANDEZ 9959-21-363*/
public class daoVideo {
    private static final String SQL_SELECT = "SELECT id_video, titulo_video, precio_video, año_estreno_video, genero_video, actores_video, sintesis_video, existencia_video, formato_video FROM tbl_videos";
    private static final String SQL_INSERT = "INSERT INTO tbl_videos(titulo_video, precio_video, año_estreno_video, genero_video, actores_video, sintesis_video, existencia_video, formato_video) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_videos SET titulo_video=?, precio_video=?,  año_estreno_video=?, genero_video=? , actores_video=?, sintesis_video=?, existencia_video=?, formato_video=?   WHERE id_video = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_videos WHERE id_video=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT id_video, titulo_video, precio_video, año_estreno_video, genero_video, actores_video, sintesis_video, existencia_video, formato_video FROM tbl_videos WHERE titulo_video = ?";
    private static final String SQL_SELECT_ID = "SELECT id_video, titulo_video, precio_video, año_estreno_video, genero_video, actores_video, sintesis_video, existencia_video, formato_video FROM tbl_videos WHERE id_video = ?";

     public List<clsVideo> consultaRegistroVideos() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

    List<clsVideo> registroVideos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                int id_video = rs.getInt("id_video");
                String titulo_video = rs.getString("titulo_video");
                float precio_video = rs.getFloat("precio_video");
                String año_estreno_video = rs.getString("año_estreno_video");
                String genero_video = rs.getString("genero_video");
                String actores_video = rs.getString("actores_video");
                String sintesis_video = rs.getString("sintesis_video");
                String existencia_video = rs.getString("existencia_video");
                String formato_video = rs.getString("formato_video");
                
                clsVideo video = new clsVideo();
                video.setId_video(id_video);
                video.setTitulo_video(titulo_video);
                video.setPrecio_video(precio_video);
                video.setAño_estreno_video(año_estreno_video);
                video.setGenero_video(genero_video);
                video.setActores_video(actores_video);
                video.setSintesis_video(sintesis_video);
                video.setExistencia_video(existencia_video);
                video.setFormato_video(formato_video);
                
                registroVideos.add(video);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return registroVideos;
    }
     
     public int ingresarRegistroVideo (clsVideo video) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, video.getTitulo_video());
            stmt.setFloat(2, video.getPrecio_video());
            stmt.setString(3, video.getAño_estreno_video());
            stmt.setString(4, video.getGenero_video());
            stmt.setString(5, video.getActores_video());
            stmt.setString(6, video.getSintesis_video());
            stmt.setString(7, video.getExistencia_video());
            stmt.setString(8, video.getFormato_video());

            
            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

public int actualizaRegistroVideo (clsVideo video) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, video.getTitulo_video());
            stmt.setFloat(2, video.getPrecio_video());
            stmt.setString(3, video.getAño_estreno_video());
            stmt.setString(4, video.getGenero_video());
            stmt.setString(5, video.getActores_video());
            stmt.setString(6, video.getSintesis_video());
            stmt.setString(7, video.getExistencia_video());
            stmt.setString(8, video.getFormato_video());
            stmt.setInt(9, video.getId_video());
            
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
     
       public int borrarRegistroVideo(clsVideo video) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, video.getId_video());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
       
     
       public clsVideo consultaRegistroVideoPorNombre(clsVideo video) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + video);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, moneda.getIdMoneda());            
            stmt.setString(1, video.getTitulo_video());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_video = rs.getInt("id_video");
                String titulo_video = rs.getString("titulo_video");
                float precio_video = rs.getFloat("precio_video");
                String año_estreno_video = rs.getString("año_estreno_video");
                String genero_video = rs.getString("genero_video");
                String actores_video = rs.getString("actores_video");
                String sintesis_video = rs.getString("sintesis_video");
                String existencia_video = rs.getString("existencia_video");
                String formato_video = rs.getString("formato_video");
                //moneda = new clsTipoMoneda();
                video.setId_video(id_video);
                video.setTitulo_video(titulo_video);
                video.setPrecio_video(precio_video);
                video.setAño_estreno_video(año_estreno_video);
                video.setGenero_video(genero_video);
                video.setActores_video(actores_video);
                video.setSintesis_video(sintesis_video);
                video.setExistencia_video(existencia_video);
                video.setFormato_video(formato_video);
                System.out.println(" registro consultado: " + video);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return video;
    }
     
         public clsVideo consultaRegistroVideoPorId(clsVideo video) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + video);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, video.getId_video());            
            //stmt.setString(1, moneda.getTipMondNombre());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_video = rs.getInt("id_video");
                String titulo_video = rs.getString("titulo_video");
                float precio_video = rs.getFloat("precio_video");
                String año_estreno_video = rs.getString("año_estreno_video");
                String genero_video = rs.getString("genero_video");
                String actores_video = rs.getString("actores_video");
                String sintesis_video = rs.getString("sintesis_video");
                String existencia_video = rs.getString("existencia_video");
                String formato_video = rs.getString("formato_video");
                //moneda = new clsTipoMoneda();
                video.setId_video(id_video);
                video.setTitulo_video(titulo_video);
                video.setPrecio_video(precio_video);
                video.setAño_estreno_video(año_estreno_video);
                video.setGenero_video(genero_video);
                video.setActores_video(actores_video);
                video.setSintesis_video(sintesis_video);
                video.setExistencia_video(existencia_video);
                video.setFormato_video(formato_video);
                
                System.out.println(" registro consultado: " + video);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return video;
    } 
     
    
}
