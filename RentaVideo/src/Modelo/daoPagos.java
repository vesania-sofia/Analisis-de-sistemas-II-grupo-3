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
    
    private static final String SQL_SELECT = "SELECT id_recibo, id_alquiler, pago, tipo_pago, descuento_pago, mora_pago FROM TBL_SISTEMA_DE_PAGOS";
    private static final String SQL_INSERT = "INSERT INTO TBL_SISTEMA_DE_PAGOS(id_alquiler, pago, tipo_pago, descuento_pago, mora_pago) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE TBL_SISTEMA_DE_PAGOS SET id_alquiler=?, pago=?,  tipo_pago=?, descuento_pago=?, mora_pago=? WHERE id_recibo = ?";
    private static final String SQL_DELETE = "DELETE FROM TBL_SISTEMA_DE_PAGOS WHERE id_recibo=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT id_recibo, pago, tipo_pago, descuento_pago, mora_pago  FROM TBL_SISTEMA_DE_PAGOS WHERE id_alquiler = ?";
    private static final String SQL_SELECT_ID = "SELECT id_recibo, id_alquiler, pago, tipo_pago, descuento_pago, mora_pago FROM TBL_SISTEMA_DE_PAGOS WHERE id_recibo = ?";     

    
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

                int id_recibo = rs.getInt("id_recibo");
                int id_alquiler = rs.getInt("id_alquiler");
                float pago = rs.getFloat ("pago");
                String tipo_pago = rs.getString("tipo_pago");
                int descuento_pago = rs.getInt("descuento_pago");
                int mora_pago = rs.getInt("mora_pago");
                clsPagos  Spago = new clsPagos();
                Spago.setId_recibo(id_recibo);
                Spago.setId_alquiler(id_alquiler);
                Spago.setPago(pago);
                Spago.setTipo_pago(tipo_pago);
                Spago.setDescuento_pago(descuento_pago);
                Spago.setMora_pago(mora_pago);
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

            stmt.setInt(1, Spago.getId_alquiler());
            stmt.setFloat(2, Spago.getPago());
            stmt.setString(3, Spago.getTipo_pago());
            stmt.setInt(4, Spago.getDescuento_pago());
            stmt.setInt(5, Spago.getMora_pago());

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

            stmt.setInt(1, Spago.getId_alquiler());
            stmt.setFloat(2, Spago.getPago());
            stmt.setString(3, Spago.getTipo_pago());
            stmt.setInt(4, Spago.getDescuento_pago());
            stmt.setInt(5, Spago.getMora_pago());

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

            stmt.setInt(1, Spago.getId_recibo());

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
            stmt.setInt(1, Spago.getId_alquiler());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_recibo = rs.getInt("id_recibo");
                int id_alquiler = rs.getInt("id_alquiler");
                float pago = rs.getFloat ("pago");
                String tipo_pago = rs.getString("tipo_pago");
                int descuento_pago = rs.getInt("descuento_pago");
                int mora_pago = rs.getInt("mora_pago");

                //renta = new clsRenta();
                Spago.setId_recibo(id_recibo);
                Spago.setId_alquiler(id_alquiler);
                Spago.setPago(pago);
                Spago.setTipo_pago(tipo_pago);
                Spago.setDescuento_pago(descuento_pago);
                Spago.setMora_pago(mora_pago);
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
            stmt.setInt(1, Spago.getId_recibo());            
            //stmt.setString(1, renta.getNombrePerfil());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_recibo = rs.getInt("id_recibo");
                int id_alquiler = rs.getInt("id_alquiler");
                float pago = rs.getFloat ("pago");
                String tipo_pago = rs.getString("tipo_pago");
                int descuento_pago = rs.getInt("descuento_pago");
                int mora_pago = rs.getInt("mora_pago");

                //renta = new clsRenta();
                Spago.setId_recibo(id_recibo);
                Spago.setId_alquiler(id_alquiler);
                Spago.setPago(pago);
                Spago.setTipo_pago(tipo_pago);
                Spago.setDescuento_pago(descuento_pago);
                Spago.setMora_pago(mora_pago);
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
