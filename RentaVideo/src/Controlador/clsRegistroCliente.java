/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import java.util.List;
import Modelo.daoRegistroCliente;
/**
 *
 * @author maria
 */
public class clsRegistroCliente {
    private int id_cliente;
    private String nombre_cliente;
    private String apellido_cliente;
    private String direccion_cliente;
    private String telefono_cliente;
    private String correo_cliente;
    private String estado_cliente;
    

    public int getid_cliente() {
        return id_cliente;
    }

    public void setid_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getnombre_cliente() {
        return nombre_cliente;
    }

    public void setnombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }
    
    public String getapellido_cliente() {
        return apellido_cliente;
    }

    public void setapellido_cliente(String apellido_cliente) {
        this.apellido_cliente = apellido_cliente;
    }
    
    public String getdireccion_cliente() {
    return direccion_cliente;
    }

    public void setdireccion_cliente(String direccion_cliente) {
        this.direccion_cliente = direccion_cliente;
    }
    
    public String gettelefono_cliente() {
    return telefono_cliente;
    }

    public void settelefono_cliente(String telefono_cliente) {
        this.telefono_cliente = telefono_cliente;
    }
    
    public String getcorreo_cliente() {
    return correo_cliente;
    }

    public void setcorreo_cliente(String correo_cliente) {
        this.correo_cliente = correo_cliente;
    }

    public String getestado_cliente() {
    return estado_cliente;
    }

    public void setestado_cliente(String estado_cliente) {
        this.estado_cliente = estado_cliente;
    }

    public clsRegistroCliente() {
    }

    public clsRegistroCliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    
    public clsRegistroCliente(int id_cliente, String nombre_cliente, String apellido_cliente) {
        this.id_cliente = id_cliente;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
    }
    
    public clsRegistroCliente(int id_cliente, String nombre_cliente, String apellido_cliente, String direccion_cliente) {
        this.id_cliente = id_cliente;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
        this.direccion_cliente = direccion_cliente;
    }
    
    public clsRegistroCliente(int id_cliente, String nombre_cliente, String apellido_cliente, String direccion_cliente, String telefono_cliente) {
        this.id_cliente = id_cliente;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
        this.direccion_cliente = direccion_cliente;
        this.telefono_cliente = telefono_cliente;
    }
    
    public clsRegistroCliente(int id_cliente, String nombre_cliente, String apellido_cliente, String direccion_cliente, String telefono_cliente,
            String correo_cliente) {
        this.id_cliente = id_cliente;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
        this.direccion_cliente = direccion_cliente;
        this.telefono_cliente = telefono_cliente;
        this.correo_cliente = correo_cliente;
    }
    
    public clsRegistroCliente(int id_cliente, String nombre_cliente, String apellido_cliente, String direccion_cliente, String telefono_cliente,
            String correo_cliente, String estado_cliente) {
        this.id_cliente = id_cliente;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
        this.direccion_cliente = direccion_cliente;
        this.telefono_cliente = telefono_cliente;
        this.correo_cliente = correo_cliente;
        this.estado_cliente = estado_cliente;
    }


    @Override
    public String toString() {
        return "clsRegistroClientes{" + "id_cliente =" + id_cliente    + ", nombre_cliente=" + nombre_cliente + ", apellido_cliente=" + apellido_cliente + ", direccion_cliente  =" + direccion_cliente   + ", telefono_cliente  =" + telefono_cliente + 
                ", correo_cliente  =" + correo_cliente + ", estado_cliente  =" + estado_cliente +    '}';
    }
    //Metodos de acceso a la capa controlador
    public clsRegistroCliente getBuscarInformacionRegistroClientePorNombre(clsRegistroCliente cliente)
    {
        daoRegistroCliente daoRegistroCliente = new daoRegistroCliente();
        return daoRegistroCliente.consultaRegistroClientePorNombre(cliente);
    }
    public clsRegistroCliente getBuscarInformacionRegistroClientePorId(clsRegistroCliente cliente)
    {
        daoRegistroCliente daoRegistroCliente = new daoRegistroCliente();
        return daoRegistroCliente.consultaRegistroClientePorId(cliente);
    }    
    public List<clsRegistroCliente> getListadoRegistroCliente()
    {
        daoRegistroCliente daoRegistroCliente = new daoRegistroCliente();
        List<clsRegistroCliente> listadoCliente = daoRegistroCliente.consultaRegistroCliente();
        return listadoCliente;
    }
    public int setBorrarRegistroCliente(clsRegistroCliente cliente)
    {
        daoRegistroCliente daoRegistroCliente = new daoRegistroCliente();
        return daoRegistroCliente.borrarRegistroCliente(cliente);
    }          
    public int setIngresaRegistroCliente(clsRegistroCliente cliente)
    {
        daoRegistroCliente daoRegistroCliente = new daoRegistroCliente();
        return daoRegistroCliente.ingresaRegistroCliente(cliente);
    }              
    public int setModificarRegistroCLiente(clsRegistroCliente cliente)
    {
        daoRegistroCliente daoRegistroCliente = new daoRegistroCliente();
        return daoRegistroCliente.actualizaRegistroCliente(cliente);
    }              

    public void getTipModValor(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getTipMondValor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
