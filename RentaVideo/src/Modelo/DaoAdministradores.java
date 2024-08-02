/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.ClsAdministradores;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KevinL
 */


public class DaoAdministradores {

    private static final String SQL_SELECT = "SELECT id_admin, nombre_admin, apellido_admin, direccion_admin, telefono_admin, correo_admin, contraseña_admin, estado_admin, nombre_usuario FROM tbl_administradores";
    private static final String SQL_INSERT = "INSERT INTO tbl_administradores(nombre_admin, apellido_admin, direccion_admin, telefono_admin, correo_admin, contraseña_admin, estado_admin, nombre_usuario) VALUES (?, ?, ?, ?, ?, ?, ? ,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_administradores SET nombre_admin=?, apellido_admin=?, direccion_admin=?, telefono_admin=?, correo_admin=?, contraseña_admin=?, estado_admin=?, nombre_usuario=? WHERE id_admin=?";
    private static final String SQL_DELETE = "DELETE FROM tbl_administradores WHERE id_admin=?";
    private static final String SQL_SELECT_ID = "SELECT id_admin, nombre_admin, apellido_admin, direccion_admin, telefono_admin, correo_admin, contraseña_admin, estado_admin, nombre_usuario FROM tbl_administradores WHERE id_admin=?";
    
    // Método auxiliar para cerrar recursos
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
    
    //Metodo para asignar los valores al PreparedStatement
    private void setPreparedStatementValues(PreparedStatement stmt, ClsAdministradores admin) throws SQLException{
            stmt.setString(1, admin.getNombreAdmin());
            stmt.setString(2, admin.getApellidoAdmin());
            stmt.setString(3, admin.getDireccionAdmin());
            stmt.setString(4, admin.getTelefonoAdmin());
            stmt.setString(5, admin.getCorreoAdmin());
            stmt.setString(6, admin.getContraAdmin());
            stmt.setString(7, admin.getEstadoAdmin());
            stmt.setString(8, admin.getNombreUsuario());
    }
    
    //Metodo para mapear ResultSet a ClsAdministradores
    private ClsAdministradores mapResultSetToAdmin(ResultSet rs) throws SQLException{
        ClsAdministradores admin = new ClsAdministradores();
        admin.setIDAdmin(rs.getInt("id_admin"));
        admin.setNombreAdmin(rs.getString("nombre_admin"));
        admin.setApellidoAdmin(rs.getString("apellido_admin"));
        admin.setDireccionAdmin(rs.getString("direccion_admin"));
        admin.setTelefonoAdmin(rs.getString("telefono_admin"));
        admin.setCorreoAdmin(rs.getString("correo_admin"));
        admin.setContraAdmin(rs.getString("contraseña_admin"));
        admin.setEstadoAdmin(rs.getString("estado_admin"));
        admin.setNombreUsuario(rs.getString("nombre_usuario"));
        return admin;
    }
    
    public List<ClsAdministradores> consultaAdministradores(){ 
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<ClsAdministradores> admins = new ArrayList<>();
        try {
            conn = Conexion.getConnection(); // falta  la conexion con el driver (conector) de forma exitosa
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()){
                admins.add(mapResultSetToAdmin(rs));
                
                /*
                int id = rs.getInt( "id_admin");
                String nombre = rs.getString("nombre_admin");
                String apellido = rs.getString("apellido_admin");
                String direccion = rs.getString("direccion_admin");
                String telefono = rs.getString("telefono_admin");
                String correo = rs.getString("correo_admin");
                String contraseña = rs.getString("contraseña_admin");
                String estado = rs.getString("estado_admin");
                String usuario = rs.getString("nombre_usuario");
                ClsAdministradores adm = new ClsAdministradores();
                adm.setIDAdmin(id);
                adm.setNombreAdmin(nombre);
                adm.setApellidoAdmin(apellido);
                adm.setDireccionAdmin(direccion);
                adm.setTelefonoAdmin(telefono);
                adm.setCorreoAdmin(correo);
                adm.setContraAdmin(contraseña);
                adm.setEstadoAdmin(estado);
                adm.setNombreUsuario(usuario);
                admins.add(adm);
                */
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            
            closeResources(rs, stmt, conn);
            /*
            Conexion.close(rs); // falta la conexion con el driver (conector) de forma exitosa
            Conexion.close(stmt);
            Conexion.close(conn);
            */
        }       
        return admins;
    }
    
    
    public int ingresaAdministrador(ClsAdministradores admin){
        Connection conn = null;
        PreparedStatement stmt = null;
        
        int rows= 0;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            
            setPreparedStatementValues(stmt, admin);
            /*
            stmt.setString(1, admin.getNombreAdmin());
            stmt.setString(2, admin.getApellidoAdmin());
            stmt.setString(3, admin.getDireccionAdmin());
            stmt.setString(4, admin.getTelefonoAdmin());
            stmt.setString(5, admin.getCorreoAdmin());
            stmt.setString(6, admin.getContraAdmin());
            stmt.setString(7, admin.getEstadoAdmin());
            stmt.setString(8, admin.getNombreUsuario());
            */
            System.out.println("ejecutando query: " + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados: " + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            closeResources(stmt, conn);
            /*
            Conexion.close(stmt);
            Conexion.close(conn);
            */
        }
        return rows;
    }
    
    
    public int actualizarAdministradorPorId (ClsAdministradores admin) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            setPreparedStatementValues(stmt, admin);
            /*
            stmt.setString(1, admin.getNombreAdmin());
            stmt.setString(2, admin.getApellidoAdmin());
            stmt.setString(3, admin.getDireccionAdmin());
            stmt.setString(4, admin.getTelefonoAdmin());
            stmt.setString(5, admin.getCorreoAdmin());
            stmt.setString(6, admin.getContraAdmin());
            stmt.setString(7, admin.getEstadoAdmin());
            stmt.setString(8, admin.getNombreUsuario());
            */
            stmt.setInt(9, admin.getIdAdmin());
            
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados: " + rows);
            System.out.println("ID del administrador a actualizar: " + admin.getIdAdmin());


        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            closeResources(stmt, conn);
            /*
            Conexion.close(stmt);
            Conexion.close(conn);
            */
        }

        return rows;
    }
    
    
    public int borrarAdministrador(ClsAdministradores admin) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, admin.getIdAdmin());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados: " + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            closeResources(stmt, conn);
            /*
            Conexion.close(stmt);
            Conexion.close(conn);
            */
        }

        return rows;
    }
    
    public ClsAdministradores consultaAdministradorPorId(ClsAdministradores admin) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_SELECT_ID + " objeto recibido: " + admin);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, admin.getIdAdmin());            
            rs = stmt.executeQuery();
            
            if(rs.next()){
                admin = mapResultSetToAdmin(rs);
                System.out.println("registro consultado: " + admin);
            }
            /*
            while (rs.next()) {
                int id = rs.getInt( "id_admin");
                String nombre = rs.getString("nombre_admin");
                String apellido = rs.getString("apellido_admin");
                String direccion = rs.getString("direccion_admin");
                String telefono = rs.getString("telefono_admin");
                String correo = rs.getString("correo_admin");
                String contraseña = rs.getString("contraseña_admin");
                String estado = rs.getString("estado_admin");
                String usuario = rs.getString("nombre_usuario");
                admin.setIDAdmin(id);
                admin.setNombreAdmin(nombre);
                admin.setApellidoAdmin(apellido);
                admin.setDireccionAdmin(direccion);
                admin.setTelefonoAdmin(telefono);
                admin.setCorreoAdmin(correo);
                admin.setContraAdmin(contraseña);
                admin.setEstadoAdmin(estado);
                admin.setNombreUsuario(usuario);
                
                                
            }*/
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            
            closeResources(rs, stmt, conn);
            /*
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
            */
        }
        
        return admin;
    }    
    
}
    
   



