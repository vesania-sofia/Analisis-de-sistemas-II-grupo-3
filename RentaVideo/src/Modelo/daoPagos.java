/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.clsPagos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Seguridad.Modelo.Conexion;
/**
 *
 * @author sofia
 */
public class daoPagos {
    
    private static final String SQL_SELECT = "SELECT id_sispag, id_comprobante, pago, tipo_sispag, descuento_sispag, mora_sispag, id_admin  FROM TBL_SISTEMA_DE_PAGOS";
    private static final String SQL_INSERT = "INSERT INTO TBL_SISTEMA_DE_PAGOS(id_comprobante, pago, tipo_sispag, descuento_sispag, mora_sispag, id_admin) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE TBL_SISTEMA_DE_PAGOS SET id_comprobante=?, pago=?, tipo_sispag=?, descuento_sispag=?, mora_sispag=?, id_admin=? WHERE id_sispag = ?";
    private static final String SQL_DELETE = "DELETE FROM TBL_SISTEMA_DE_PAGOS WHERE tipModId=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT id_sispag, pago, tipo_sispag, descuento_sispag, mora_sispag, id_admin  FROM TBL_SISTEMA_DE_PAGOS WHERE id_comprobante = ?";
    private static final String SQL_SELECT_ID = "SELECT id_comprobante, pago, tipo_sispag, descuento_sispag, mora_sispag, id_admin FROM TBL_SISTEMA_DE_PAGOS WHERE id_sispag = ?";     

    
      public List<clsPagos> consultaPagos() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        

        List<clsPagos> Spagos = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {

                int id_sispag = rs.getInt("id_sispag");
                int id_comprobante = rs.getInt("id_comprobante");
                float pago = rs.getFloat ("pago");
                String tipo_sispag = rs.getString("tipo_sispag");
                int descuento_sispag = rs.getInt("descuento_sispag");
                int mora_sispag = rs.getInt("mora_sispag");
                int id_admin = rs.getInt("id_admin");
                clsPagos  Spago = new clsPagos();
                Spago.setId_sispag(id_sispag);
                Spago.setId_comprobante(id_comprobante);
                Spago.setPago(pago);
                Spago.setTipo_sispag(tipo_sispag);
                Spago.setDescuento_sispag(descuento_sispag);
                Spago.setMora_sispag(mora_sispag);
                Spago.setId_admin(id_admin);
                Spagos.add(Spago);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return Spagos;
    }  

  public int ingresaPago(clsPagos Spago) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setInt(1, Spago.getId_comprobante());
            stmt.setFloat(2, Spago.getPago());
            stmt.setString(3, Spago.getTipo_sispag());
            stmt.setInt(4, Spago.getDescuento_sispag());
            stmt.setInt(5, Spago.getMora_sispag());
            stmt.setInt(5, Spago.getId_admin());

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
   
  public int actualizaPago(clsPagos Spago) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setInt(1, Spago.getId_comprobante());
            stmt.setFloat(2, Spago.getPago());
            stmt.setString(3, Spago.getTipo_sispag());
            stmt.setInt(4, Spago.getDescuento_sispag());
            stmt.setInt(5, Spago.getMora_sispag());
            stmt.setInt(5, Spago.getId_admin());

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
    
  public int borrarPago(clsPagos Spago) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, Spago.getId_sispag());

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
  
      public clsPagos consultaPagoPorNombre(clsPagos Spago) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();

            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + Spago);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);        
            stmt.setInt(1, Spago.getId_comprobante());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_sispag = rs.getInt("id_sispag");
                int id_comprobante = rs.getInt("id_comprobante");
                float pago = rs.getFloat ("pago");
                String tipo_sispag = rs.getString("tipo_sispag");
                int descuento_sispag = rs.getInt("descuento_sispag");
                int mora_sispag = rs.getInt("mora_sispag");
                int id_admin = rs.getInt("id_admin");

                //renta = new clsRenta();
                Spago.setId_sispag(id_sispag);
                Spago.setId_comprobante(id_comprobante);
                Spago.setPago(pago);
                Spago.setTipo_sispag(tipo_sispag);
                Spago.setDescuento_sispag(descuento_sispag);
                Spago.setMora_sispag(mora_sispag);
                Spago.setId_admin(id_admin);
                System.out.println(" registro consultado: " + Spago);                

            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }


        return Spago;
    }
  
      public clsPagos consultaPagoPorId(clsPagos Spago) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();

            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + Spago);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, Spago.getId_sispag());            
            //stmt.setString(1, renta.getNombrePerfil());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_sispag = rs.getInt("id_sispag");
                int id_comprobante = rs.getInt("id_comprobante");
                float pago = rs.getFloat ("pago");
                String tipo_sispag = rs.getString("tipo_sispag");
                int descuento_sispag = rs.getInt("descuento_sispag");
                int mora_sispag = rs.getInt("mora_sispag");
                int id_admin = rs.getInt("id_admin");

                //renta = new clsRenta();
                Spago.setId_sispag(id_sispag);
                Spago.setId_comprobante(id_comprobante);
                Spago.setPago(pago);
                Spago.setTipo_sispag(tipo_sispag);
                Spago.setDescuento_sispag(descuento_sispag);
                Spago.setMora_sispag(mora_sispag);
                Spago.setId_admin(id_admin);
                System.out.println(" registro consultado: " + Spago);           

            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }


        return Spago;

    }    
  
}
