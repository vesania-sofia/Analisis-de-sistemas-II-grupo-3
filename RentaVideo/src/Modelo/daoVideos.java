/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.clsVideos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Seguridad.Modelo.Conexion;

/**
 *
 * @author macho
 */
public class daoVideos {
    
    private static final String SQL_SELECT = "SELECT id_video, titulo_video, precio_video, año_estreno_video, genero_video, actores_video, sintesis_video, existencia_video , formato_video FROM TBL_VIDEOS";
    private static final String SQL_INSERT = "INSERT INTO TBL_VIDEOS( titulo_video, precio_video, año_estreno_video, genero_video,actores_video,sintesis_video,existencia_video,formato_video) VALUES(?, ?, ?, ?, ?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE TBL_VIDEOS SET titulo_video=?, precio_video=?,  año_estreno_video=?, genero_video=? , actores_video=? , sintesis_video=? , existencia_video=? , formato_video=?   WHERE id_video = ?";
    private static final String SQL_DELETE = "DELETE FROM TBL_VIDEOS WHERE id_video=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT id_video, titulo_video, precio_video, año_estreno_video, genero_video, actores_video, sintesis_video, existencia_video , formato_video  FROM TBL_VIDEOS WHERE titulo_video = ?";
    private static final String SQL_SELECT_ID = "SELECT Id_video, titulo_video, precio_video, año_estreno_video, genero_video, actores_video, sintesis_video, existencia_video , formato_video FROM TBL_VIDEOS WHERE id_videos = ?";     
    
    
      public List<clsVideos>consultavideos() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsVideos> video = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_video");
                String titulo = rs.getString("titulo_video");
                String precio = rs.getString("precio_video");
                float año = rs.getFloat ("año_estreno_video");
                String genero =rs.getString("genero_video");
                String actores =rs.getString("actores_video");
                String sitensis =rs.getString("sintesis_video");
                String extension =rs.getString("existencia_video");
                String formato =rs.getString("formato_video");
               
                clsVideos tipovideos = new clsVideos ();
                tipovideos.setid_video(id);
                tipovideos.settitulo_video(titulo);
                tipovideos.setprecio_video(precio);
                tipovideos.setaño_estreno_video(año);
                tipovideos.setgenero_video(genero);
                tipovideos.setactores_video(actores);
                tipovideos.setsintesis_video(sitensis);
                tipovideos.setexistencia_video(extension);
                tipovideos.setformato_video(formato);
              
                video.add (tipovideos);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return video;
    }
      
       public int ingresaVideos (clsVideos video) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, video.getid_video());
            stmt.setString(2, video.gettitulo_video());
            stmt.setString(3, video.getprecio_video());
            stmt.setFloat(4, video.getaño_estreno_video());
            stmt.setString(5, video.getgenero_video());
            stmt.setString(6, video.getactores_video());
            stmt.setString(7, video.getsintesis_video());
            stmt.setString(8, video.getexistencia_video());
            stmt.setString(9, video.getformato_video());
            
            
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
       
        public int actualizaVideos (clsVideos video) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, video.gettitulo_video());
            stmt.setString(2, video.getprecio_video());
            stmt.setFloat(3, video.getaño_estreno_video());
            stmt.setString(4, video.getgenero_video());
            stmt.setString(5, video.getactores_video());
            stmt.setString(6, video.getsintesis_video());
            stmt.setString(7, video.getexistencia_video());
            stmt.setString(8, video.getformato_video());
            
            
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
       
        public int borrarVideos(clsVideos video) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, video.getid_video());
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
       
       
         public clsVideos consultaVideosPorNombre(clsVideos video) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + video);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);           
            stmt.setString(1, video.gettitulo_video());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("Id_video");
                String titulo = rs.getString("Titulo_video");
                String precio = rs.getString("Precio_video");
                float año = rs.getFloat("Año_Estreno_video");
                String genero = rs.getString("Genero_video");
                String actores = rs.getString("Actores_video");
                String sintesis = rs.getString("Sintesis_video");
                String extension = rs.getString("Extension_video");
                String formato = rs.getString("Formato_video");
                
                
                video.setid_video(id);
                video.settitulo_video(titulo);
                video.setprecio_video(precio);
                video.setaño_estreno_video(año);
                video.setgenero_video(genero);
                video.setactores_video(actores);
                video.setsintesis_video(sintesis);
                video.setexistencia_video(extension);
                video.setformato_video(formato);
                
                System.out.println(" registro consultado: " + video );                
            }
           
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return video;
    }
         
         
        public clsVideos consultaVideosPorId(clsVideos video) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + video);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, video.getid_video());            
           
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("Id_video");
                String titulo = rs.getString("Titulo_video");
                String precio = rs.getString("Precio_video");
                float año = rs.getFloat("Año_Estreno_video");
                String genero = rs.getString("Genero_video");
                String actores = rs.getString("Actores_video");
                String sintesis = rs.getString("Sintesis_video");
                String extension = rs.getString("Extension_video");
                String formato = rs.getString("Formato_video");
                
            
                video.setid_video(id);
                video.settitulo_video(titulo);
                video.setprecio_video(precio);
                video.setaño_estreno_video(año);
                video.setgenero_video(genero);
                video.setactores_video(actores);
                video.setsintesis_video(sintesis);
                video.setexistencia_video(extension);
                video.setformato_video(formato);
                ;
                System.out.println(" registro consultado: " + video);                
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return video;
    }   
}
