/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author visitante
 */
import java.net.InetAddress;
import java.net.UnknownHostException;
import Controlador.clsBitacora;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;

/**
 *
 * @author visitante
 */
public class daoBitacora {

    private static final String SQL_SELECT = "SELECT id_bitacora, fecha_bitacora, accion_bitacora, ip_pc_bitacora, nombre_pc_bitacor, id_admin, id_usuario FROM TBL_BITACORAS";  
    private static final String SQL_INSERT = "INSERT INTO TBL_BITACORAS(fecha_bitacora, accion_bitacora, ip_pc_bitacora, nombre_pc_bitacor, id_admin, id_usuario) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_QUERY = "SELECT id_bitacora, fecha_bitacora, accion_bitacora, ip_pc_bitacora, nombre_pc_bitacor, id_admin, id_usuario FROM TBL_BITACORAS WHERE fecha_bitacora BETWEEN ? AND ?";    


//se agrega metodo para bitacora
//averiguar IP
    public String fechaActual() {

        java.util.Date fecha = new java.util.Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");

        return formatoFecha.format(fecha);

    }

    public static String horaActual() {

        java.util.Date fecha = new java.util.Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("hh:mm:ss");

        return formatoFecha.format(fecha);

    }
    
    private String obtenerNombrePc() throws UnknownHostException {   
        return InetAddress.getLocalHost().getHostName();
    }
            
    private String obtenerIP() throws UnknownHostException {
        InetAddress ip = InetAddress.getLocalHost();
        return ip.getHostAddress();
    }        

    public List<clsBitacora> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsBitacora bitacora = null;
        List<clsBitacora> bitacoras = new ArrayList<clsBitacora>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_bitacora = rs.getInt("id_bitacora");
                String fecha_bitacora = rs.getString("fecha_bitacora");
                String accion_bitacora = rs.getString("accion_bitacora");
                String ip_pc_bitacora = rs.getString("ip_pc_bitacora");
                String nombre_pc_bitacor = rs.getString("nombre_pc_bitacor");
                int id_admin = rs.getInt("id_admin");
                int id_usuario = rs.getInt("id_usuario");
                
                bitacora = new clsBitacora();
                bitacora.setId_bitacora(id_bitacora);
                bitacora.setFecha_bitacora(fecha_bitacora);
                bitacora.setAccion_bitacora(accion_bitacora);
                bitacora.setIp_pc_bitacora(ip_pc_bitacora);
                bitacora.setNombre_pc_bitacor(nombre_pc_bitacor);
                bitacora.setId_admin(id_admin);
                bitacora.setId_usuario(id_usuario);
                
                bitacoras.add(bitacora);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return bitacoras;
    }

    public int insert(int m_usuid, int m_aplicacion, String m_accion) {
        String ipAsignada;
        String nombrepcAsignada;
        ipAsignada = " ";
        nombrepcAsignada = " ";
        //System.out.println("Parametros Bitacora: " + m_usuid + " " + m_aplicacion + " " + m_accion);
       
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            try {
                   ipAsignada= obtenerIP();
                   nombrepcAsignada= obtenerNombrePc();            
            } catch (UnknownHostException ex)
                {
                }               
            stmt = conn.prepareStatement(SQL_INSERT);
                       
            stmt.setString(1, fechaActual());
            stmt.setString(2, m_accion);
            stmt.setInt(3, m_usuid);
            stmt.setInt(4, m_aplicacion);
            stmt.setString(5, ipAsignada);
            stmt.setString(6, nombrepcAsignada);
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
 // Modificacion acceso a Bitacora  
    public List<clsBitacora> query( String primeraFecha, String segundaFecha )
    {
        System.out.println("Fechas recibidas : " + primeraFecha + " " + segundaFecha);        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsBitacora bitacora = null;
        List<clsBitacora> bitacoras = new ArrayList<clsBitacora>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, primeraFecha);            
            stmt.setString(2, segundaFecha);
            rs = stmt.executeQuery();
            System.out.println("query : " + stmt);
            while (rs.next()) {
                int id_bitacora = rs.getInt("id_bitacora");
                String fecha_bitacora = rs.getString("fecha_bitacora");
                String accion_bitacora = rs.getString("accion_bitacora");
                String ip_pc_bitacora = rs.getString("ip_pc_bitacora");
                String nombre_pc_bitacor = rs.getString("nombre_pc_bitacor");
                int id_admin = rs.getInt("id_admin");
                int id_usuario = rs.getInt("id_usuario");
                
                bitacora = new clsBitacora();
               bitacora.setId_bitacora(id_bitacora);
                bitacora.setFecha_bitacora(fecha_bitacora);
                bitacora.setAccion_bitacora(accion_bitacora);
                bitacora.setIp_pc_bitacora(ip_pc_bitacora);
                bitacora.setNombre_pc_bitacor(nombre_pc_bitacor);
                bitacora.setId_admin(id_admin);
                bitacora.setId_usuario(id_usuario);
                
                bitacoras.add(bitacora);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return bitacoras;
    } 
}
