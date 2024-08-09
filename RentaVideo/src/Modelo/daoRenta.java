/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.clsRenta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Seguridad.Modelo.Conexion;
import java.util.Date;
//import java.sql.Date;

/**
 *
 * @author DELL
 */
public class daoRenta {

    private static final String SQL_SELECT = "SELECT id_comprobante, id_cliente, fecha_alquiler, fecha_devolucion, estatus_alquiler, id_video FROM TBL_ALQUILERES";
    private static final String SQL_INSERT = "INSERT INTO tbl_alquileres(id_cliente, fecha_alquiler, fecha_devolucion, estatus_alquiler, id_video) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE TBL_ALQUILERES SET id_cliente=?, fecha_alquiler=?, fecha_devolucion=?, estatus_alquiler=?, id_video=? WHERE id_comprobante = ?";
    private static final String SQL_DELETE = "DELETE FROM TBL_ALQUILERES WHERE id_comprobante=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT id_comprobante, id_cliente, fecha_alquiler, fecha_devolucion, estatus_alquiler, id_video FROM TBL_ALQUILERES WHERE id_cliente = ?";
    private static final String SQL_SELECT_ID = "SELECT id_comprobante, id_cliente, fecha_alquiler, fecha_devolucion, estatus_alquiler, id_video FROM TBL_ALQUILERES WHERE id_comprobante = ?";    

    public List<clsRenta> consultaRenta() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        

        List<clsRenta> rentas = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {

                int id_comprobante = rs.getInt("id_comprobante");
                int id_cliente = rs.getInt("id_cliente");
                Date fecha_alquiler = rs.getDate("fecha_alquiler"); // Usar java.sql.Date
                Date fecha_devolucion = rs.getDate("fecha_devolucion"); // Usar java.sql.Date
                String estatus_alquiler = rs.getString("estatus_alquiler");
                int id_video = rs.getInt("id_video");
                clsRenta renta = new clsRenta();
                renta.setId_comprobante(id_comprobante);
                renta.setId_cliente(id_cliente);
                renta.setFecha_alquiler(fecha_alquiler);
                renta.setFecha_devolucion(fecha_devolucion);
                renta.setEstatus_alquiler(estatus_alquiler);
                renta.setId_video(id_video);
                rentas.add(renta);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rentas;
    }

    public int ingresaRenta(clsRenta renta) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, renta.getId_cliente());
            stmt.setDate(2, new java.sql.Date(renta.getFecha_alquiler().getTime())); // Convertir java.util.Date a java.sql.Date
            stmt.setDate(3, new java.sql.Date(renta.getFecha_devolucion().getTime())); // Convertir java.util.Date a java.sql.Date
            stmt.setString(4, renta.getEstatus_alquiler());
            stmt.setInt(5, renta.getId_video());

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


    public int actualizaRenta(clsRenta renta) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setInt(1, renta.getId_cliente());
            stmt.setDate(2, new java.sql.Date(renta.getFecha_alquiler().getTime())); // Convertir java.util.Date a java.sql.Date
            stmt.setDate(3, new java.sql.Date(renta.getFecha_devolucion().getTime())); // Convertir java.util.Date a java.sql.Date
            stmt.setString(4, renta.getEstatus_alquiler());
            stmt.setInt(5, renta.getId_video());
            stmt.setInt(6, renta.getId_comprobante()); // ID del registro a actualizar

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


    public int borrarRenta(clsRenta renta) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, renta.getId_comprobante());

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


/*    public clsRenta consultaRentaPorNombre(clsRenta renta) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();

            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + renta);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);        
            stmt.setInt(1, renta.getId_cliente());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_comprobante = rs.getInt("id_comprobante");
                int id_cliente = rs.getInt("id_cliente");
                String fecha_alquiler = rs.getString("fecha_alquiler");
                String fecha_devolucion = rs.getString("fecha_devolucion");
                String estatus_alquiler = rs.getString("estatus_alquiler");
                int id_video = rs.getInt("id_video");

                //renta = new clsRenta();
                renta.setId_comprobante(id_comprobante);
                renta.setId_cliente(id_cliente);
                renta.setFecha_alquiler(fecha_alquiler);
                renta.setFecha_devolucion(fecha_devolucion);
                renta.setEstatus_alquiler(estatus_alquiler);
                renta.setId_video(id_video);
                System.out.println(" registro consultado: " + renta);                

            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }


        return renta;
    }*/
    
    
    public clsRenta consultaRentaPorId(clsRenta renta) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();

            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + renta);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, renta.getId_comprobante());            
            //stmt.setString(1, renta.getNombrePerfil());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_comprobante = rs.getInt("id_comprobante");
                int id_cliente = rs.getInt("id_cliente");
                Date fecha_alquiler = rs.getDate("fecha_alquiler");
                Date fecha_devolucion = rs.getDate("fecha_devolucion");
                String estatus_alquiler = rs.getString("estatus_alquiler");
                int id_video = rs.getInt("id_video");

                //renta = new clsRenta();
                renta.setId_comprobante(id_comprobante);
                renta.setId_cliente(id_cliente);
                renta.setFecha_alquiler(fecha_alquiler);
                renta.setFecha_devolucion(fecha_devolucion);
                renta.setEstatus_alquiler(estatus_alquiler);
                renta.setId_video(id_video);
                System.out.println(" registro consultado: " + renta);           

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

        return renta;

    }    
}
