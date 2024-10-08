/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.ClsAdministradores;
//import java.security.MessageDigest;   Parte de la funcion de encriptacion
//import java.security.NoSuchAlgorithmException;
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
    private static final String SQL_SELECT_NOMBRE = "SELECT id_admin, nombre_admin, apellido_admin, direccion_admin, telefono_admin, correo_admin, contraseña_admin, estado_admin, nombre_usuario FROM tbl_administradores WHERE nombre_usuario=? AND contraseña_admin=?";
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
                
            //String contraseñaEncriptada = encriptarPassword(admin.getContraAdmin()); Parte de la funcion de encriptacion
            //stmt.setString(6, contraseñaEncriptada); Parte de la funcion de encriptacion
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
            conn = Conexion.getConnection(); 
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()){
                admins.add(mapResultSetToAdmin(rs));

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            
            closeResources(rs, stmt, conn);

        }       
        return admins;
    }
    /* Encriptacion Funcional pero necesita modificaciones en login, necesita revision.
    public String encriptarPassword(String password){
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash){
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch(NoSuchAlgorithmException e){
            e.printStackTrace();
            return null;
        }
    }*/
    
    
    public int ingresaAdministrador(ClsAdministradores admin){
        Connection conn = null;
        PreparedStatement stmt = null;
        
        int rows= 0;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            
            setPreparedStatementValues(stmt, admin);

            System.out.println("ejecutando query: " + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados: " + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            closeResources(stmt, conn);

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

            stmt.setInt(9, admin.getIdAdmin());
            
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados: " + rows);
            System.out.println("ID del administrador a actualizar: " + admin.getIdAdmin());


        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            closeResources(stmt, conn);

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

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            
            closeResources(rs, stmt, conn);

        }
        
        return admin;
    } 
    
public ClsAdministradores consultaAdministradorPorNombre(ClsAdministradores admin) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + admin);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);  

            stmt.setString(1, admin.getNombreUsuario());
            rs = stmt.executeQuery();
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

                //renta = new clsRenta();
                admin.setIDAdmin(id);
                admin.setNombreAdmin(nombre);
                admin.setApellidoAdmin(apellido);
                admin.setDireccionAdmin(direccion);
                admin.setTelefonoAdmin(telefono);
                admin.setCorreoAdmin(correo);
                admin.setContraAdmin(contraseña);
                admin.setEstadoAdmin(estado);
                admin.setNombreUsuario(usuario);
                System.out.println(" registro consultado: " + admin);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return admin;
}

public ClsAdministradores login(String nombreUsuario, String contraseña) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    ClsAdministradores admin = null;

    try {
        conn = Conexion.getConnection();
        stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
        stmt.setString(1, nombreUsuario);
        stmt.setString(2, contraseña);
        rs = stmt.executeQuery();

        if (rs.next()) {
            admin = mapResultSetToAdmin(rs);
        }
    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    } finally {
        closeResources(rs, stmt, conn);
    }
    return admin;
}
}    
   
