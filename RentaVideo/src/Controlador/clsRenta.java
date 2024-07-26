/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import java.util.List;
import Modelo.daoRenta;

/**
 *
 * @author DELL
 */
public class clsRenta {
    private int id_comprobante;
    private int  id_cliente;
    private String fecha_alquiler;
    private String fecha_devolucion;
    private String estatus_alquiler;
    private int id_video;

    public clsRenta() {
    }

    public clsRenta(int id_comprobante) {
        this.id_comprobante = id_comprobante;
    }

    public clsRenta(int id_comprobante, int id_cliente) {
        this.id_comprobante = id_comprobante;
        this.id_cliente = id_cliente;
    }

    public clsRenta(int id_comprobante, int id_cliente, String fecha_alquiler) {
        this.id_comprobante = id_comprobante;
        this.id_cliente = id_cliente;
        this.fecha_alquiler = fecha_alquiler;
    }

    public clsRenta(int id_comprobante, int id_cliente, String fecha_alquiler, String fecha_devolucion) {
        this.id_comprobante = id_comprobante;
        this.id_cliente = id_cliente;
        this.fecha_alquiler = fecha_alquiler;
        this.fecha_devolucion = fecha_devolucion;
    }

    public clsRenta(int id_comprobante, int id_cliente, String fecha_alquiler, String fecha_devolucion, String estatus_alquiler) {
        this.id_comprobante = id_comprobante;
        this.id_cliente = id_cliente;
        this.fecha_alquiler = fecha_alquiler;
        this.fecha_devolucion = fecha_devolucion;
        this.estatus_alquiler = estatus_alquiler;
    }

    public clsRenta(int id_comprobante, int id_cliente, String fecha_alquiler, String fecha_devolucion, String estatus_alquiler, int id_video) {
        this.id_comprobante = id_comprobante;
        this.id_cliente = id_cliente;
        this.fecha_alquiler = fecha_alquiler;
        this.fecha_devolucion = fecha_devolucion;
        this.estatus_alquiler = estatus_alquiler;
        this.id_video = id_video;
    }

    public int getId_comprobante() {
        return id_comprobante;
    }

    public void setId_comprobante(int id_comprobante) {
        this.id_comprobante = id_comprobante;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getFecha_alquiler() {
        return fecha_alquiler;
    }

    public void setFecha_alquiler(String fecha_alquiler) {
        this.fecha_alquiler = fecha_alquiler;
    }

    public String getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(String fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public String getEstatus_alquiler() {
        return estatus_alquiler;
    }

    public void setEstatus_alquiler(String estatus_alquiler) {
        this.estatus_alquiler = estatus_alquiler;
    }

    public int getId_video() {
        return id_video;
    }

    public void setId_video(int id_video) {
        this.id_video = id_video;
    }
    
    @Override
    public String toString() {
        return "clsRenta{" + "id_comprobante=" + id_comprobante + ", id_cliente=" + id_cliente + ", fecha_alquiler=" + fecha_alquiler + ", fecha_devolucion=" + fecha_devolucion + ", estatus_alquiler=" + estatus_alquiler + ", id_video=" + id_video +'}';
    }
   //Metodos de acceso a la capa controlador
    public clsRenta getBuscarInformacionRentaPorNombre(clsRenta renta)
    {
        daoRenta daorenta = new daoRenta();
        return daorenta.consultaRentaPorNombre(renta);
    }
    public clsRenta getBuscarInformacionRentaPorId(clsRenta renta)
    {
        daoRenta daorenta = new daoRenta();
        return daorenta.consultaRentaPorId(renta);
    }    
    public List<clsRenta> getListadoRentas()
    {
        daoRenta daorenta = new daoRenta();
        List<clsRenta> listadoPerfiles = daorenta.consultaRenta();
        return listadoPerfiles;
    }
    public int setBorrarRenta(clsRenta renta)
    {
        daoRenta daorenta = new daoRenta();
        return daorenta.borrarRenta(renta);
    }          
    public int setIngresarRenta(clsRenta renta)
    {
        daoRenta daorenta = new daoRenta();
        return daorenta.ingresaRenta(renta);
    }              
    public int setModificarRenta(clsRenta renta)
    {
        daoRenta daorenta = new daoRenta();
        return daorenta.actualizaRenta(renta);
    }              
}
