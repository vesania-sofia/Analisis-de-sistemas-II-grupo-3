/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Controlador.ClsUsuario;
import Seguridad.Modelo.Conexion;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;




/**
 *
 * @author wendy
 */
public class daoUsuario {

    private static final String SQL_SELECT = "SELECT id_usuario, nombre_usuario, contraseña_usuario, ultima_sesion_usuario, status_usuario, nombre_real_usuario, correo_usuario, telefono_usuario, direccion_usuario, id_tipo_usuario FROM tbl_usuario";
    private static final String SQL_INSERT = "INSERT INTO tbl_usuario(nombre_usuario, contraseña_usuario, ultima_sesion_usuario, status_usuario, nombre_real_usuario, correo_usuario, telefono_usuario, direccion_usuario, id_tipo_usuario) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_usuario SET nombre_usuario = ?,contraseña_usuario = ?, ultima_sesion_usuario = ?, status_usuario = ?, nombre_real_usuario = ?, correo_usuario = ?, telefono_usuario = ?, direccion_usuario = ?, id_tipo_usuario = ? WHERE id_usuario = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_usuario WHERE Id_usuario=?";
    private static final String SQL_SELECT_ID = "SELECT id_usuario, nombre_usuario,contraseña_usuario, ultima_sesion_usuario, status_usuario, nombre_real_usuario, correo_usuario, telefono_usuario, direccion_usuario, id_tipo_usuario FROM tbl_usuario WHERE id_usuario = ?";     
    private static final String SQL_SELECT_NOMBRE = "SELECT id_usuario, nombre_usuario, contraseña_usuario, ultima_sesion_usuario, status_usuario, nombre_real_usuario, correo_usuario, telefono_usuario, direccion_usuario,  id_tipo_usuario  FROM tbl_usuario WHERE nombre_usuario = ?";
    
      public List<ClsUsuario> consultaUsuario() {
      
           Connection conn = null;
           PreparedStatement stmt = null;
           ResultSet rs = null;
           
           List<ClsUsuario> usuarios = new ArrayList<>();
           try{
              conn = Conexion.getConnection();
              stmt = conn.prepareStatement(SQL_SELECT);
              rs = stmt.executeQuery();
              while (rs.next()) {
                   int id_usuario = rs.getInt("id_usuario");
                   String nombre_usuario = rs.getString("nombre_usuario");
                   String contraseña_usuario = rs.getString("contraseña_usuario");
                   String ultima_sesion_usuario = rs.getString("ultima_sesion_usuario");
                   String status_usuario = rs.getString("status_usuario");
                   String nombre_real_usuario = rs.getString("nombre_real_usuario");
                   String correo_usuario = rs.getString("correo_usuario");
                   String telefono_usuario = rs.getString("telefono_usuario");
                   String direccion_usuario = rs.getString("direccion_usuario");
                   int id_tipo_usuario = rs.getInt("id_tipo_usuario");

                   ClsUsuario usuario = new ClsUsuario();
                   usuario.setid_usuario(id_usuario);
                   usuario.setnombre_usuario(nombre_usuario);
                   usuario.setcontraseña_usuario(contraseña_usuario);
                   usuario.setultima_sesion_usuario(ultima_sesion_usuario);
                   usuario.setstatus_usuario(status_usuario);
                   usuario.setnombre_real_usuario(nombre_real_usuario);
                   usuario.setcorreo_usuario(correo_usuario);
                   usuario.settelefono_usuario(telefono_usuario);
                   usuario.setdireccion_usuario(direccion_usuario);
                   usuario.setid_tipo_usuario(id_tipo_usuario);
                   
                   usuarios.add(usuario);
               }//end while
        
            }catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return usuarios;  
      }///public list cls usuario
      
      
      public int ingresarUsuario (ClsUsuario usuario){
            Connection conn = null;
            PreparedStatement stmt = null;
            int rows = 0;
            try{
                conn = Conexion.getConnection();
                stmt = conn.prepareStatement(SQL_INSERT);
                stmt.setString(1, usuario.getnombre_usuario());
                stmt.setString(2, usuario.getcontraseña_usuario());
                stmt.setString(3, usuario.getultima_sesion_usuario());
                stmt.setString(4, usuario.getstatus_usuario());
                stmt.setString(5, usuario.getnombre_real_usuario());
                stmt.setString(6, usuario.getcorreo_usuario());
                stmt.setString(7, usuario.gettelefono_usuario());
                stmt.setString(8, usuario.getdireccion_usuario());
                stmt.setInt(9, usuario.getid_tipo_usuario());
                            
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
      
      public int actualizaUsuario (ClsUsuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
             stmt.setString(1, usuario.getnombre_usuario());
             stmt.setString(2, usuario.getcontraseña_usuario());
             stmt.setString(3, usuario.getultima_sesion_usuario());
             stmt.setString(4, usuario.getstatus_usuario());
             stmt.setString(5, usuario.getnombre_real_usuario());
             stmt.setString(6, usuario.getcorreo_usuario());
             stmt.setString(7, usuario.gettelefono_usuario());
             stmt.setString(8, usuario.getdireccion_usuario());
             stmt.setInt(9, usuario.getid_tipo_usuario());
             stmt.setInt(10, usuario.getid_usuario());
                         
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
      
      public int borrarUsuario(ClsUsuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getid_usuario());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
      }//public borrar
      
      public ClsUsuario consultaUsuarioPorNombre(ClsUsuario usuario){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
          try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + usuario);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            stmt.setString(1, usuario.getnombre_usuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                  int id_usuario = rs.getInt("id_usuario");
                   String nombre_usuario = rs.getString("nombre_usuario");
                   String contraseña_usuario = rs.getString("contraseña_usuario");
                   String ultima_sesion_usuario = rs.getString("ultima_sesion_usuario");
                   String status_usuario = rs.getString("status_usuario");
                   String nombre_real_usuario = rs.getString("nombre_real_usuario");
                   String correo_usuario = rs.getString("correo_usuario");
                   String telefono_usuario = rs.getString("telefono_usuario");
                   String direccion_usuario = rs.getString("direccion_usuario");
                   int id_tipo_usuario = rs.getInt("id_tipo_usuario");
      
                   usuario.setid_usuario(id_usuario);
                   usuario.setnombre_usuario(nombre_usuario);
                   usuario.setcontraseña_usuario(contraseña_usuario);
                   usuario.setultima_sesion_usuario(ultima_sesion_usuario);
                   usuario.setstatus_usuario(status_usuario);
                   usuario.setnombre_real_usuario(nombre_real_usuario);
                   usuario.setcorreo_usuario(correo_usuario);
                   usuario.settelefono_usuario(telefono_usuario);
                   usuario.setdireccion_usuario(direccion_usuario);
                   usuario.setid_tipo_usuario(id_tipo_usuario);
                  System.out.println(" registro consultado: " + usuario);                
              }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return usuario;
      }
      
      public ClsUsuario consultaUsuarioPorId(ClsUsuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_ID + " objeto recibido: " + usuario);
             stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, usuario.getid_usuario());
            rs = stmt.executeQuery();
           
            while (rs.next()) {
                  int id_usuario = rs.getInt("id_usuario");
                   String nombre_usuario = rs.getString("nombre_usuario");
                   String contraseña_usuario = rs.getString("contraseña_usuario");
                   String ultima_sesion_usuario = rs.getString("ultima_sesion_usuario");
                   String status_usuario = rs.getString("status_usuario");
                   String nombre_real_usuario = rs.getString("nombre_real_usuario");
                   String correo_usuario = rs.getString("correo_usuario");
                   String telefono_usuario = rs.getString("telefono_usuario");
                   String direccion_usuario = rs.getString("direccion_usuario");
                   int id_tipo_usuario = rs.getInt("id_tipo_usuario");
      
                   usuario.setid_usuario(id_usuario);
                   usuario.setnombre_usuario(nombre_usuario);
                   usuario.setcontraseña_usuario(contraseña_usuario);
                   usuario.setultima_sesion_usuario(ultima_sesion_usuario);
                   usuario.setstatus_usuario(status_usuario);
                   usuario.setnombre_real_usuario(nombre_real_usuario);
                   usuario.setcorreo_usuario(correo_usuario);
                   usuario.settelefono_usuario(telefono_usuario);
                   usuario.setdireccion_usuario(direccion_usuario);
                   usuario.setid_tipo_usuario(id_tipo_usuario);
                  System.out.println(" registro consultado: " + usuario);               
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return usuario;
        
      }        
        public ClsUsuario login(String nombreUsuario, String contraseña) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    ClsUsuario usuario = null;

    try {
        conn = Conexion.getConnection();
        stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
        stmt.setString(1, nombreUsuario);
        stmt.setString(2, contraseña);
        rs = stmt.executeQuery();

        if (rs.next()) {
           /* int id_usuario = rs.getInt("id_usuario");
                   String nombre_usuario = rs.getString("nombre_usuario");
                   String contraseña_usuario = rs.getString("contraseña_usuario");
                   String ultima_sesion_usuario = rs.getString("ultima_sesion_usuario");
                   String status_usuario = rs.getString("status_usuario");
                   String nombre_real_usuario = rs.getString("nombre_real_usuario");
                   String correo_usuario = rs.getString("correo_usuario");
                   String telefono_usuario = rs.getString("telefono_usuario");
                   String direccion_usuario = rs.getString("direccion_usuario");
                   int id_tipo_usuario = rs.getInt("id_tipo_usuario");
      */     
        }
    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    } finally {
        closeResources(rs, stmt, conn);
    }
    return usuario;
}
    
    private void closeResources(AutoCloseable... resources) {
        for (AutoCloseable resource : resources) {
            if (resource != null) {
                try {
                    resource.close();
                } catch (Exception e) {
                    e.printStackTrace(System.out);
                }
            }
        }
    }
    

}