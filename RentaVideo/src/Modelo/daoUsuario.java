/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Controlador.ClsUsuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author wendy
 */
public class daoUsuario {

    private static final String SQL_SELECT = "SELECT id_usuario, nombre_usuario,contraseña_usuario, ultima_sesion_usuario, status_usuario, nombre_real_usuario, correo_usuario, telefono_usuario, direccion_usuario, id_tipo_usuario";
    private static final String SQL_INSERT = "INSERT INTO tbl_usuario(nombre_usuario,contraseña_usuario, ultima_sesion_usuario, status_usuario, nombre_real_usuario, correo_usuario, telefono_usuario, direccion_usuario, id_tipo_usuario) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_usuario SET nombre_usuario = ?,contraseña_usuario = ?, ultima_sesion_usuario = ?, status_usuario = ?, nombre_real_usuario = ?, correo_usuario = ?, telefono_usuario = ?, direccion_usuario = ?, id_tipo_usuario = ?";
    private static final String SQL_DELETE = "\"DELETE FROM tbl_usuario WHERE Id_usuario=?";
    private static final String SQL_SELECT_ID = "SELECT nombre_usuario,contraseña_usuario, ultima_sesion_usuario, status_usuario, nombre_real_usuario, correo_usuario, telefono_usuario, direccion_usuario, id_tipo_usuario FROM tbl_usuario WHERE Id_usuario = ?";     
    private static final String SQL_SELECT_NOMBRE = "SELECT id_usuario, nombre_usuario, contraseña_usuario, ultima_sesion_usuario, status_usuario, nombre_real_usuario, correo_usuario, telefono_usuario, direccion_usuario,  id_tipo_usuario  FROM tbl_usuario WHERE nombre_usuario = ?";
    
      public List<ClsUsuario> consultaUsuario() {
      
           Connection conn = null;
           PreparedStatement stmt = null;
           ResultSet rs = null;
           
           List<ClsUsuario> tipusuarios = new ArrayList<>();
           try{
              
              conn = Conexion.getConnection();
              stmt = conn.prepareStatement(SQL_SELECT);
              rs = stmt.executeQuery();
              while (rs.next()) {
                  
                   int id = rs.getInt("id_usuario");
                   String nombre = rs.getString("nombre_usuario");
                   String contraseña = rs.getString("contraseña_usuario");
                   Date   sesion = rs.getDate("ultima_sesion_usuario");
                   String  estado = rs.getString("status_usuario");
                   String  nombreReal = rs.getString("nombre_real_usuario");
                   String  correo = rs.getString("correo_usuario");
                   String  telefono = rs.getString("telefono_usuario");
                   String  direccion = rs.getString("direccion_usuario");
                   int idTipo = rs.getInt("id_tipo_usuario");

                   ClsUsuario usuario = new ClsUsuario();
                   usuario.setId_usuario(id);
                   usuario.setNombre_usuario(nombre);
                   usuario.setContraseña_usuario(contraseña);
                   usuario.setUltima_sesion_usuario(sesion);
                   usuario.setStatus_usuario(estado);
                   usuario.setNombre_real_usuario(nombreReal);
                   usuario.setCorreo_usuario(correo);
                   usuario.setTelefono_usuario(telefono);
                   usuario.setDireccion_usuario(direccion);
                   usuario.setId_tipo_usuario(idTipo);
                   tipusuarios.add(usuario);
               }//end while
        
            }catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return tipusuarios;  
      }///public list cls usuario
      
      
      public int ingresaUsuario (ClsUsuario users){
            Connection conn = null;
            PreparedStatement stmt = null;
            int rows = 0;
            try{
                conn = Conexion.getConnection();
                stmt = conn.prepareStatement(SQL_INSERT);
                
                stmt.setString(1, users.getNombre_usuario());
                stmt.setString(2, users.getContraseña_usuario());
                stmt.setDate(3, users.getUltima_sesion_usuario());
                stmt.setString(4, users.getStatus_usuario());
                stmt.setString(5, users.getNombre_real_usuario());
                stmt.setString(6, users.getCorreo_usuario());
                stmt.setString(7, users.getTelefono_usuario());
                stmt.setString(8, users.getDireccion_usuario());
                            
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
            
            //
            
            
            
      }
      
      public int actualizaUsuario (ClsUsuario users) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try{
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            
             stmt.setString(1, users.getNombre_usuario());
             stmt.setString(2, users.getContraseña_usuario());
             stmt.setDate(3, users.getUltima_sesion_usuario());
             stmt.setString(4, users.getStatus_usuario());
             stmt.setString(5, users.getNombre_real_usuario());
             stmt.setString(6, users.getCorreo_usuario());
             stmt.setString(7, users.getTelefono_usuario());
             stmt.setString(8, users.getDireccion_usuario());
             stmt.setInt(9, users.getId_tipo_usuario());
                         
             rows = stmt.executeUpdate();
             System.out.println("Registros actualizado:" + rows); 
        }catch (SQLException ex) {
            ex.printStackTrace(System.out);
            
        } finally {
           Conexion.close(stmt);
           Conexion.close(conn);
        }

        return rows;
      }//public end
      
      public int borrarUsuario(ClsUsuario users) {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, users.getId_usuario());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
            
        
        }catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
      }//public borrar
      
      public ClsUsuario consultaListadoUsuariosPorNombre(ClsUsuario users){
          
          Connection conn = null;
          PreparedStatement stmt = null;
          ResultSet rs = null;
          try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + users);
            stmt.setString(1, users.getNombre_usuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                  int id = rs.getInt("id_usuario");
                  String nombre = rs.getString("nombre_usuario");
                  String contraseña = rs.getString("contraseña_usuario");
                  Date  sesiones = rs.getDate("ultima_sesion_usuario");
                  String  estado = rs.getString("status_usuario");
                  String  nombreReal = rs.getString("nombre_real_usuario");
                  String  correo = rs.getString("correo_usuario");
                  String  telefono = rs.getString("telefono_usuario");
                  String  direccion = rs.getString("direccion_usuario");
                  int idTipo = rs.getInt("id_tipo_usuario");
                  
                 
                  users.setId_usuario(id);
                  users.setNombre_usuario(nombre);
                  users.setContraseña_usuario(contraseña);
                  users.setStatus_usuario(estado);
                  users.setNombre_real_usuario(nombreReal);
                  users.setCorreo_usuario(correo);
                  users.setTelefono_usuario(telefono);
                  users.setDireccion_usuario(direccion);
                  System.out.println(" registro consultado: " + users);                
              }
          }catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
           
      }
          return users;
      }
      
      public ClsUsuario consultaBuscarUsuarioPorId(ClsUsuario users) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + users);
            stmt.setInt(1, users.getId_usuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_usuario");
                  String nombre = rs.getString("nombre_usuario");
                  String contraseña = rs.getString("contraseña_usuario");
                  String  sesiones = rs.getString("ultima_sesion_usuario");
                  String  estado = rs.getString("status_usuario");
                  String  nombreReal = rs.getString("nombre_real_usuario");
                  String  correo = rs.getString("correo_usuario");
                  String  telefono = rs.getString("telefono_usuario");
                  String  direccion = rs.getString("direccion_usuario");
                  int idTipo = rs.getInt("id_tipo_usuario");
                
                  
                users.setId_usuario(id);
                users.setNombre_usuario(nombre);
                users.setContraseña_usuario(contraseña);
                users.setStatus_usuario(estado);
                users.setNombre_real_usuario(nombreReal);
                users.setCorreo_usuario(correo);
                users.setTelefono_usuario(telefono);
                users.setDireccion_usuario(direccion);
                System.out.println(" registro consultado: " + users);                
            }
        }catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return users;
      }
      }///end classs daousuario
