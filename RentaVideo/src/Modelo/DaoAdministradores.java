/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.ClsAdministradores;
import Controlador.Conexion;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KevinL
 */


public class DaoAdministradores {

    private static final String SQL_SELECT = "SELECT id_administradores, nombre_administradores, apellido_administradores, direccion_administradores, telefono_administradores, correo_administradores, contraseña_administradores, estado_administradores, nombre_usuario FROM tbl_administradores";
    private static final String SQL_INSERT = "INSERT INTO tbl_administradores(id_administradores, nombre_administradores, apellido_administradores, direccion_administradores, telefono_administradores, correo_administradores, contraseña_administradores, estado_administradores, nombre_usuario) VALUES (?, ?, ?, ?, ?, ?, ?, ? ,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_administradores SET nombre_administradores=?, apellido_administradores=?, direccion_administradores=?, telefono_administradores=?, correo_administradores=?, contraseña_administradores=?, estado_administradores=?, nombre_usuario=? WHERE id_administradores=?";
    private static final String SQL_DELETE = "DELETE FROM tbl_administradores WHERE id_administradores=?";
    private static final String SQL_SELECT_ID = "SELECT id_administradores, nombre_administradores, apellido_administradores, direccion_administradores, telefono_administradores, correo_administradores, contraseña_administradores, estado_administradores, nombre_usuario FROM tbl_administradores WHERE id_administradores=?";
    
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
                int id = rs.getInt( "id_administradores");
                String nombre = rs.getString("nombre_administradores");
                String apellido = rs.getString("apellido_administradores");
                String direccion = rs.getString("direccion_administradores");
                String telefono = rs.getString("telefono_administradores");
                String correo = rs.getString("correo_administradores");
                String contraseña = rs.getString("contraseña_administradores");
                String estado = rs.getString("estado_administradores");
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
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs); // falta la conexion con el driver (conector) de forma exitosa
            Conexion.close(stmt);
            Conexion.close(conn);
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
            stmt.setInt(1, admin.getIdAdmin());
            stmt.setString(2, admin.getNombreAdmin());
            stmt.setString(3, admin.getApellidoAdmin());
            stmt.setString(4, admin.getDireccionAdmin());
            stmt.setString(5, admin.getTelefonoAdmin());
            stmt.setString(6, admin.getCorreoAdmin());
            stmt.setString(7, admin.getContraAdmin());
            stmt.setString(8, admin.getEstadoAdmin());
            stmt.setString(9, admin.getNombreUsuario());
            
            System.out.println("ejecutando query: " + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados: " + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
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
            stmt.setString(1, admin.getNombreAdmin());
            stmt.setString(2, admin.getApellidoAdmin());
            stmt.setString(3, admin.getDireccionAdmin());
            stmt.setString(4, admin.getTelefonoAdmin());
            stmt.setString(5, admin.getCorreoAdmin());
            stmt.setString(6, admin.getContraAdmin());
            stmt.setString(7, admin.getEstadoAdmin());
            stmt.setString(8, admin.getNombreUsuario());
            
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados: " + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
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
            Conexion.close(stmt);
            Conexion.close(conn);
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
            while (rs.next()) {
                int id = rs.getInt( "id_administradores");
                String nombre = rs.getString("nombre_administradores");
                String apellido = rs.getString("apellido_administradores");
                String direccion = rs.getString("direccion_administradores");
                String telefono = rs.getString("telefono_administradores");
                String correo = rs.getString("correo_administradores");
                String contraseña = rs.getString("contraseña_administradores");
                String estado = rs.getString("estado_administradores");
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
                
                System.out.println("registro consultado: " + admin);                
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return admin;
    }    
    
}
    
   



