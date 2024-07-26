/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import java.util.List;
import Modelo.daoPagos;
/**
 *
 * @author sofia
 */
public class clsPagos {
    private int id_recibo;
    private int id_alquiler;
    private float pago;
    private String tipo_pago;
    private int descuento_pago;
    private int mora_pago;
    

    public int getId_recibo() {
        return id_recibo;
    }

    public void setId_recibo(int id_recibo) {
        this.id_recibo = id_recibo;
    }

    public int getId_alquiler() {
        return id_alquiler;
    }

    public void setId_alquiler(int id_alquiler) {
        this.id_alquiler = id_alquiler;
    }

    public float getPago() {
        return pago;
    }

    public void setPago(float pago) {
        this.pago = pago;
    }

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public int getDescuento_pago() {
        return descuento_pago;
    }

    public void setDescuento_pago(int descuento_pago) {
        this.descuento_pago = descuento_pago;
    }

    public int getMora_pago() {
        return mora_pago;
    }

    public void setMora_pago(int mora_pago) {
        this.mora_pago = mora_pago;
    }
    
     public clsPagos() {
     }
    
    public clsPagos(int id_recibo, int id_alquiler, float pago, String tipo_pago, int descuento_pago, int mora_pago) {
        this.id_recibo = id_recibo;
        this.id_alquiler = id_alquiler;
        this.pago = pago;
        this.tipo_pago = tipo_pago;
        this.descuento_pago = descuento_pago;
        this.mora_pago = mora_pago;
    }

    public clsPagos(int id_recibo, int id_alquiler, float pago, String tipo_pago, int descuento_pago) {
        this.id_recibo = id_recibo;
        this.id_alquiler = id_alquiler;
        this.pago = pago;
        this.tipo_pago = tipo_pago;
        this.descuento_pago = descuento_pago;
    }

    public clsPagos(int id_recibo, int id_alquiler, float pago, String tipo_pago) {
        this.id_recibo = id_recibo;
        this.id_alquiler = id_alquiler;
        this.pago = pago;
        this.tipo_pago = tipo_pago;
    }

    public clsPagos(int id_recibo, int id_alquiler, float pago) {
        this.id_recibo = id_recibo;
        this.id_alquiler = id_alquiler;
        this.pago = pago;
    }

    public clsPagos(int id_recibo, int id_alquiler) {
        this.id_recibo = id_recibo;
        this.id_alquiler = id_alquiler;
    }

    public clsPagos(int id_recibo) {
        this.id_recibo = id_recibo;
    }

    
    @Override
    public String toString() {
        return "clsPagos{" + "id_recibo =" + id_recibo    + ", id_alquiler=" + id_alquiler + ", pago=" + pago + ", tipo_pago  =" + tipo_pago   + ", descuento_pago  =" + descuento_pago + ", mora_pago  =" + mora_pago +  '}';
    }
    //Metodos de acceso a la capa controlador
    public clsPagos getBuscarInformacionPagoPorNombre(clsPagos Spago)
    {
        daoPagos daoPagos = new daoPagos();
        return daoPagos.consultaPagoPorNombre(Spago);
    }
    public clsPagos getBuscarInformacionPagoPorId(clsPagos Spago)
    {
        daoPagos daopagos = new daoPagos();
        return daopagos.consultaPagoPorId(Spago);
    }    
    
    public List<clsPagos> getListadoPagos()
    {
        daoPagos daopago = new daoPagos();
        List<clsPagos> listadoPerfiles = daopago.consultaPagos();
        return listadoPerfiles;
    }
    

    
    public int setBorrarPago(clsPagos Spago)
    {
        daoPagos daopagos = new daoPagos();
        return daopagos.borrarPago(Spago);
    }          
    public int setIngresarPago(clsPagos Spago)
    {
        daoPagos daopagos = new daoPagos();
        return daopagos.ingresaPago(Spago);
    }              
    public int setModificarPago(clsPagos Spago)
    {
        daoPagos daopagos = new daoPagos();
        return daopagos.actualizaPago(Spago);
    }              

    
}
