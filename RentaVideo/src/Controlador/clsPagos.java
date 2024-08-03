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
    private int id_sispag;
    private int id_comprobante;
    private float pago;
    private String tipo_sispag;
    private int descuento_sispag;
    private int mora_sispag;
    private int id_admin;

    public clsPagos(int id_sispag, int id_comprobante, float pago, String tipo_sispag, int descuento_sispag, int mora_sispag, int id_admin) {
        this.id_sispag = id_sispag;
        this.id_comprobante = id_comprobante;
        this.pago = pago;
        this.tipo_sispag = tipo_sispag;
        this.descuento_sispag = descuento_sispag;
        this.mora_sispag = mora_sispag;
        this.id_admin = id_admin;
    }

    public clsPagos(int id_sispag, int id_comprobante, float pago, String tipo_sispag, int descuento_sispag, int mora_sispag) {
        this.id_sispag = id_sispag;
        this.id_comprobante = id_comprobante;
        this.pago = pago;
        this.tipo_sispag = tipo_sispag;
        this.descuento_sispag = descuento_sispag;
        this.mora_sispag = mora_sispag;
    }

    public clsPagos(int id_sispag, int id_comprobante, float pago, String tipo_sispag, int descuento_sispag) {
        this.id_sispag = id_sispag;
        this.id_comprobante = id_comprobante;
        this.pago = pago;
        this.tipo_sispag = tipo_sispag;
        this.descuento_sispag = descuento_sispag;
    }

    public clsPagos(int id_sispag, int id_comprobante, float pago, String tipo_sispag) {
        this.id_sispag = id_sispag;
        this.id_comprobante = id_comprobante;
        this.pago = pago;
        this.tipo_sispag = tipo_sispag;
    }

    public clsPagos(int id_sispag, int id_comprobante, float pago) {
        this.id_sispag = id_sispag;
        this.id_comprobante = id_comprobante;
        this.pago = pago;
    }

    public clsPagos(int id_sispag, int id_comprobante) {
        this.id_sispag = id_sispag;
        this.id_comprobante = id_comprobante;
    }

    public clsPagos(int id_sispag) {
        this.id_sispag = id_sispag;
    }

    public clsPagos() {
    }

    public int getId_sispag() {
        return id_sispag;
    }

    public void setId_sispag(int id_sispag) {
        this.id_sispag = id_sispag;
    }

    public int getId_comprobante() {
        return id_comprobante;
    }

    public void setId_comprobante(int id_comprobante) {
        this.id_comprobante = id_comprobante;
    }

    public float getPago() {
        return pago;
    }

    public void setPago(float pago) {
        this.pago = pago;
    }

    public String getTipo_sispag() {
        return tipo_sispag;
    }

    public void setTipo_sispag(String tipo_sispag) {
        this.tipo_sispag = tipo_sispag;
    }

    public int getDescuento_sispag() {
        return descuento_sispag;
    }

    public void setDescuento_sispag(int descuento_sispag) {
        this.descuento_sispag = descuento_sispag;
    }

    public int getMora_sispag() {
        return mora_sispag;
    }

    public void setMora_sispag(int mora_sispag) {
        this.mora_sispag = mora_sispag;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }
    

    
    @Override
    public String toString() {
        return "clsPagos{" + "id_sispag =" + id_sispag    + ", id_comprobante=" + id_comprobante + ", pago=" + pago + ", tipo_sispag  =" + tipo_sispag   + ", descuento_sispag  =" + descuento_sispag + ", mora_sispag  =" + mora_sispag + ", id_admin  =" + id_admin + '}';
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
