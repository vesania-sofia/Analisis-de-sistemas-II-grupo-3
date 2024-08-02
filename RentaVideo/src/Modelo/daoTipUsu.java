/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import Controlador.clsTipUsu;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Seguridad.Modelo.Conexion;

/**
 *
 * @author DELL
 */
public class daoTipUsu {
    private static final String SQL_SELECT = "SELECT id_tipo_usuario, nombre_tipo_usuario, status_tipo_usuario FROM TBL_TIPO_USUARIO";
    private static final String SQL_INSERT = "INSERT INTO TBL_TIPO_USUARIO( id_tipo_usuario, nombre_tipo_usuario, status_tipo_usuario) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE TBL_TIPO_USUARIO SET id_tipo_usuario=?, nombre_tipo_usuario=?,  status_tipo_usuario=? WHERE id_tipo_usuario = ?";
    private static final String SQL_DELETE = "DELETE FROM TBL_TIPO_USUARIO WHERE id_tipo_usuario=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT id_tipo_usuario, nombre_tipo_usuario, status_tipo_usuario FROM TBL_TIPO_USUARIO WHERE nombre_tipo_usuario = ?";
    private static final String SQL_SELECT_ID = "SELECT id_tipo_usuario, nombre_tipo_usuario, status_tipo_usuario FROM TBL_TIPO_USUARIO WHERE id_tipo_usuario = ?"; 
    
     public List<clsTipUsu>consultausuarios() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsTipUsu> usuario = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                int id = rs.getInt("id_tipo_usuario");
                String nombre = rs.getString("nombre_tipo_usuario");
                String estatus = rs.getString("status_tipo_usuario");
         
                clsTipUsu tipousuario = new clsTipUsu ();
                tipousuario.setId_tipo_usuario(id);
                tipousuario.setNombre_tipo_usuario(nombre);
                tipousuario.setStatus_tipo_usuario(estatus);
                usuario.add (tipousuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return usuario;
        
    }
    
     public int ingresaUsusarios (clsTipUsu usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, usuario.getId_tipo_usuario());
            stmt.setString(2, usuario.getNombre_tipo_usuario());
            stmt.setString(3, usuario.getStatus_tipo_usuario());
            
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
     
     public int actualizausuarios (clsTipUsu usuario) {
         
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setInt(1, usuario.getId_tipo_usuario());
            stmt.setString(2, usuario.getNombre_tipo_usuario());
            stmt.setString(3, usuario.getStatus_tipo_usuario());            
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
     
     
        public int borrarUsuarios(clsTipUsu usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            
            stmt.setInt(1, usuario.getId_tipo_usuario());
            
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
    
        public clsTipUsu consultaUsuariosPorNombre(clsTipUsu usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + usuario);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);           
            stmt.setString(1, usuario.getNombre_tipo_usuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_tipo_usuario");
                String nombre = rs.getString("nombre_tipo_usuario");
                String estatus = rs.getString("status_tipo_usuario");
                
                usuario.setId_tipo_usuario(id);
                usuario.setNombre_tipo_usuario(nombre);
                usuario.setStatus_tipo_usuario(estatus);
           
                
                System.out.println(" registro consultado: " + usuario );                
            }
           
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return usuario;
    }      
       
        public clsTipUsu consultaUsuariosPorId(clsTipUsu usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + usuario);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, usuario.getId_tipo_usuario());            
           
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_tipo_usuario");
                String nombre = rs.getString("nombre_tipo_usuario");
                String estatus = rs.getString("status_tipo_usuario");
              
                usuario.setId_tipo_usuario(id);
                usuario.setNombre_tipo_usuario(nombre);
                usuario.setStatus_tipo_usuario(estatus);
                
                System.out.println(" registro consultado: " + usuario);                
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return usuario;
    } 

   
    
}

