/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import Controlador.clsRegistroCliente;
import Modelo.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maria
 */
public class daoRegistroCliente {
    private static final String SQL_SELECT = "SELECT id_cliente, nombre_cliente, apellido_cliente, direccion_cliente, telefono_cliente, correo_cliente, estado_cliente FROM tbl_clientes";
    private static final String SQL_INSERT = "INSERT INTO tbl_clientes(nombre_cliente,apellido_cliente, direccion_cliente, telefono_cliente, correo_cliente, estado_cliente) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_clientes SET nombre_cliente=?, apellido_cliente=?,  direccion_cliente=?, telefono_cliente=? , correo_cliente=?, estado_cliente=?  WHERE id_cliente = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_clientes WHERE id_cliente=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT id_cliente, nombre_cliente, apellido_cliente, direccion_cliente, telefono_cliente, correo_cliente, estado_cliente FROM tbl_clientes WHERE nombre_cliente = ?";
    private static final String SQL_SELECT_ID = "SELECT id_cliente, nombre_cliente, apellido_cliente, direccion_cliente, telefono_cliente, correo_cliente, estado_cliente FROM tbl_clientes WHERE id_cliente = ?";     


   public List<clsRegistroCliente> consultaRegistroCliente() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsRegistroCliente> registroCliente = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_cliente = rs.getInt("id_cliente");
                String nombre_cliente = rs.getString("nombre_cliente");
                String apellido_cliente = rs.getString("apellido_cliente");
                String direccion_cliente = rs.getString("direccion_cliente");
                String telefono_cliente = rs.getString("telefono_cliente");
                String correo_cliente = rs.getString("correo_cliente");
                String estado_cliente = rs.getString("estado_cliente");
                
                clsRegistroCliente cliente = new clsRegistroCliente();
                cliente.setid_cliente(id_cliente);
                cliente.setnombre_cliente(nombre_cliente);
                cliente.setapellido_cliente(apellido_cliente);
                cliente.setdireccion_cliente(direccion_cliente);
                cliente.settelefono_cliente(telefono_cliente);
                cliente.setcorreo_cliente(correo_cliente);
                cliente.setestado_cliente(estado_cliente);
                
                registroCliente.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return registroCliente;
    }


     public int ingresarRegistroCliente (clsRegistroCliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cliente.getnombre_cliente());
            stmt.setString(2, cliente.getapellido_cliente());
            stmt.setString(3, cliente.getdireccion_cliente());
            stmt.setString(4, cliente.gettelefono_cliente());
            stmt.setString(5, cliente.getcorreo_cliente());
            stmt.setString(6, cliente.getestado_cliente());

            
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

    public int actualizaRegistroCliente (clsRegistroCliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cliente.getnombre_cliente());
            stmt.setString(2, cliente.getapellido_cliente());
            stmt.setString(3, cliente.getdireccion_cliente());
            stmt.setString(4, cliente.gettelefono_cliente());
            stmt.setString(5, cliente.getcorreo_cliente());
            stmt.setString(6, cliente.getestado_cliente());
            stmt.setInt(7, cliente.getid_cliente());
            
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

    public int borrarRegistroCliente(clsRegistroCliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cliente.getid_cliente());
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

    public clsRegistroCliente consultaRegistroClientePorNombre(clsRegistroCliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + cliente);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, moneda.getIdMoneda());            
            stmt.setString(1, cliente.getnombre_cliente());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_cliente = rs.getInt("id_cliente");
                String nombre_cliente = rs.getString("nombre_cliente");
                String apellido_cliente = rs.getString("apellido_cliente");
                String direccion_cliente = rs.getString("direccion_cliente");
                String telefono_cliente = rs.getString("telefono_cliente");
                String correo_cliente = rs.getString("correo_cliente");
                String estado_cliente = rs.getString("estado_cliente");
                //moneda = new clsTipoMoneda();
                cliente.setid_cliente(id_cliente);
                cliente.setnombre_cliente(nombre_cliente);
                cliente.setapellido_cliente(apellido_cliente);
                cliente.setdireccion_cliente(direccion_cliente);
                cliente.settelefono_cliente(telefono_cliente);
                cliente.setcorreo_cliente(correo_cliente);
                cliente.setestado_cliente(estado_cliente);
                System.out.println(" registro consultado: " + cliente);                
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
        return cliente;
    }
    public clsRegistroCliente consultaRegistroClientePorId(clsRegistroCliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + cliente);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, cliente.getid_cliente());            
            //stmt.setString(1, moneda.getTipMondNombre());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_cliente = rs.getInt("id_cliente");
                String nombre_cliente = rs.getString("nombre_cliente");
                String apellido_cliente = rs.getString("apellido_cliente");
                String direccion_cliente = rs.getString("direccion_cliente");
                String telefono_cliente = rs.getString("telefono_cliente");
                String correo_cliente = rs.getString("correo_cliente");
                String estado_cliente = rs.getString("estado_cliente");
                //moneda = new clsTipoMoneda();
                cliente.setid_cliente(id_cliente);
                cliente.setnombre_cliente(nombre_cliente);
                cliente.setapellido_cliente(apellido_cliente);
                cliente.setdireccion_cliente(direccion_cliente);
                cliente.settelefono_cliente(telefono_cliente);
                cliente.setcorreo_cliente(correo_cliente);
                cliente.setestado_cliente(estado_cliente);
                System.out.println(" registro consultado: " + cliente);                
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
        return cliente;
    } 

}
