/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.daoBitacora;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 *
 * @author visitante
 */
public class clsBitacora {
 private int id_bitacora;
    private String fecha_bitacora;
    private String accion_bitacora;
    private String ip_pc_bitacora;
    private String nombre_pc_bitacor;
    private int id_admin;
    private int id_usuario;

    public clsBitacora(int id_bitacora) {
        this.id_bitacora = id_bitacora;
    }

    public clsBitacora(int id_bitacora, String fecha_bitacora, String accion_bitacora, String ip_pc_bitacora, String nombre_pc_bitacor, int id_admin, int id_usuario) {
        this.id_bitacora = id_bitacora;
        this.fecha_bitacora = fecha_bitacora;
        this.accion_bitacora = accion_bitacora;
        this.ip_pc_bitacora = ip_pc_bitacora;
        this.nombre_pc_bitacor = nombre_pc_bitacor;
        this.id_admin = id_admin;
        this.id_usuario = id_usuario;
    }
     
    public int getId_bitacora() {
        return id_bitacora;
    }

    public void setId_bitacora(int id_bitacora) {
        this.id_bitacora = id_bitacora;
    }

    public String getFecha_bitacora() {
        return fecha_bitacora;
    }

    public void setFecha_bitacora(String fecha_bitacora) {
        this.fecha_bitacora = fecha_bitacora;
    }

    public String getAccion_bitacora() {
        return accion_bitacora;
    }

    public void setAccion_bitacora(String accion_bitacora) {
        this.accion_bitacora = accion_bitacora;
    }

    public String getIp_pc_bitacora() {
        return ip_pc_bitacora;
    }

    public void setIp_pc_bitacora(String ip_pc_bitacora) {
        this.ip_pc_bitacora = ip_pc_bitacora;
    }

    public String getNombre_pc_bitacor() {
        return nombre_pc_bitacor;
    }

    public void setNombre_pc_bitacor(String nombre_pc_bitacor) {
        this.nombre_pc_bitacor = nombre_pc_bitacor;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
  
    
    

    public clsBitacora() {
    }




    @Override
    public String toString() {
        return "clsBitacora{" + "id_bitacora=" + id_bitacora + ", fecha_bitacora=" + fecha_bitacora + ", accion_bitacora=" + accion_bitacora + ", ip_pc_bitacora=" + ip_pc_bitacora + ", nombre_pc_bitacor=" + nombre_pc_bitacor + ", id_admin=" + id_admin + ", id_usuario=" + id_usuario + '}';
    }
    public int setIngresarBitacora(int codigoUsuario, int codigoAplicacion, String accion)
    {
        daoBitacora daobitacora = new daoBitacora();
        return daobitacora.insert(codigoUsuario, codigoAplicacion, accion);
    }
    public List<clsBitacora> getListadoBitacora(String primeraFecha, String segundaFecha) throws ParseException
    {
        daoBitacora daobitacora = new daoBitacora();
        List<clsBitacora> listadoBitacora = daobitacora.query(primeraFecha, segundaFecha);
        return listadoBitacora;
    }    
}
