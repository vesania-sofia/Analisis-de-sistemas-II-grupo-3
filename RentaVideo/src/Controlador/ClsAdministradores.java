/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.List;
import Modelo.DaoAdministradores;

/**
 *
 * @author KevinL
 */
public class ClsAdministradores {

    private int id_administradores;
    private String nombre_administradores;
    private String apellido_administradores;
    private String direccion_administradores;
    private String telefono_administradores;
    private String correo_administradores;
    private String contraseña_administradores;
    private String estado_administradores;
    private String nombre_usuario;
    
    public int getIdAdmin() {return id_administradores; }  //getter
    public void setIDAdmin(int id_administradores){this.id_administradores = id_administradores;} //setter
    
    public String getNombreAdmin() {return nombre_administradores; }
    public void setNombreAdmin(String nombre_administradores){this.nombre_administradores = nombre_administradores;}
    
    public String getApellidoAdmin() {return apellido_administradores; }
    public void setApellidoAdmin(String apellido_administradores){this.apellido_administradores = apellido_administradores;}
    
    public String getDireccionAdmin() {return direccion_administradores; }
    public void setDireccionAdmin(String direccion_administradores){this.direccion_administradores = direccion_administradores;}
    
    public String getTelefonoAdmin() {return telefono_administradores; }
    public void setTelefonoAdmin(String telefono_administradores){this.telefono_administradores = telefono_administradores;}
    
    public String getCorreoAdmin() {return correo_administradores; }
    public void setCorreoAdmin(String correo_administradores){this.correo_administradores = correo_administradores;}
    
    public String getContraAdmin() {return contraseña_administradores; }
    public void setContraAdmin(String contraseña_administradores){this.contraseña_administradores = contraseña_administradores;}
    
    public String getEstadoAdmin() {return estado_administradores; }
    public void setEstadoAdmin(String estado_administradores){this.estado_administradores = estado_administradores;}
    
    public String getNombreUsuario() {return nombre_usuario; }
    public void setNombreUsuario(String nombre_usuario){this.nombre_usuario = nombre_usuario;}
    
    public ClsAdministradores() {  
    }
    
    public ClsAdministradores (int id_administradores) {
        this.id_administradores = id_administradores;
    }
    
    public ClsAdministradores(int id_administradores, String nombre_administradores) {
        this.id_administradores = id_administradores;
        this.nombre_administradores = nombre_administradores;
    }

    public ClsAdministradores(int id_administradores, String nombre_administradores, String apellido_administradores) {
        this.id_administradores = id_administradores;
        this.nombre_administradores = nombre_administradores;
        this.apellido_administradores = apellido_administradores;
    }

    public ClsAdministradores(int id_administradores, String nombre_administradores, String apellido_administradores, String direccion_administradores) {
        this.id_administradores = id_administradores;
        this.nombre_administradores = nombre_administradores;
        this.apellido_administradores = apellido_administradores;
        this.direccion_administradores = direccion_administradores;
    }

    public ClsAdministradores(int id_administradores, String nombre_administradores, String apellido_administradores, String direccion_administradores, String telefono_administradores) {
        this.id_administradores = id_administradores;
        this.nombre_administradores = nombre_administradores;
        this.apellido_administradores = apellido_administradores;
        this.direccion_administradores = direccion_administradores;
        this.telefono_administradores = telefono_administradores;
    }

    public ClsAdministradores(int id_administradores, String nombre_administradores, String apellido_administradores, String direccion_administradores, String telefono_administradores, String correo_administradores) {
        this.id_administradores = id_administradores;
        this.nombre_administradores = nombre_administradores;
        this.apellido_administradores = apellido_administradores;
        this.direccion_administradores = direccion_administradores;
        this.telefono_administradores = telefono_administradores;
        this.correo_administradores = correo_administradores;
    }

    public ClsAdministradores(int id_administradores, String nombre_administradores, String apellido_administradores, String direccion_administradores, String telefono_administradores, String correo_administradores, String contraseña_administradores) {
        this.id_administradores = id_administradores;
        this.nombre_administradores = nombre_administradores;
        this.apellido_administradores = apellido_administradores;
        this.direccion_administradores = direccion_administradores;
        this.telefono_administradores = telefono_administradores;
        this.correo_administradores = correo_administradores;
        this.contraseña_administradores = contraseña_administradores;
    }
    
    public ClsAdministradores(int id_administradores, String nombre_administradores, String apellido_administradores, String direccion_administradores, String telefono_administradores, String correo_administradores, String contraseña_administradores, String estado_administradores) {
        this.id_administradores = id_administradores;
        this.nombre_administradores = nombre_administradores;
        this.apellido_administradores = apellido_administradores;
        this.direccion_administradores = direccion_administradores;
        this.telefono_administradores = telefono_administradores;
        this.correo_administradores = correo_administradores;
        this.contraseña_administradores = contraseña_administradores;
        this.estado_administradores = estado_administradores;
    }

    public ClsAdministradores(int id_administradores, String nombre_administradores, String apellido_administradores, String direccion_administradores, String telefono_administradores, String correo_administradores, String contraseña_administradores, String estado_administradores, String nombre_usuario) {
        this.id_administradores = id_administradores;
        this.nombre_administradores = nombre_administradores;
        this.apellido_administradores = apellido_administradores;
        this.direccion_administradores = direccion_administradores;
        this.telefono_administradores = telefono_administradores;
        this.correo_administradores = correo_administradores;
        this.contraseña_administradores = contraseña_administradores;
        this.estado_administradores = estado_administradores;
        this.nombre_usuario = nombre_usuario;
    }
    
    
    
@Override
public String toString() {
        return "ClsAdministradores{" +
               "id_administradores=" + id_administradores +
               ", nombre_administradores='" + nombre_administradores + '\'' +
               ", apellido_administradores='" + apellido_administradores + '\'' +
               ", direccion_administradores='" + direccion_administradores + '\'' +
               ", telefono_administradores='" + telefono_administradores + '\'' +
               ", correo_administradores='" + correo_administradores + '\'' +
               ", contraseña_administradores='" + contraseña_administradores + '\'' +
               ", estado_administradores='" + estado_administradores + '\'' +
               ", nombre_usuario="+ nombre_usuario + '}';
    }

    //Busqueda por nombre posiblemente no se utilice
/*
    public ClsAdministradores getBuscarAdministradorPorNombre(ClsAdministradores administrador){ //Pendiente atributo administrador en modelo
        DaoAdministradores DaoAdministradores = new DaoAdministradores();
        return DaoAdministradores.consultaAdministradorPorNombre(administrador); //Pendiente funcion en modelo
    }
*/    
    public ClsAdministradores getBuscarAdministradorPorId(ClsAdministradores admin){ 
        DaoAdministradores DaoAdministradores = new DaoAdministradores();
        return DaoAdministradores.consultaAdministradorPorId(admin); 
    }
    
    public List<ClsAdministradores> getListadoAdministradores(){
        DaoAdministradores DaoAdministradores = new DaoAdministradores();
        List<ClsAdministradores> ListadoAdministradores = DaoAdministradores.consultaAdministradores();
        return ListadoAdministradores;
    }
    
    public int setBorrarAdministrador(ClsAdministradores admin){ 
        DaoAdministradores DaoAdministradores = new DaoAdministradores();
        return DaoAdministradores.borrarAdministrador(admin);
    }
    
    public int setIngresarAdministrador(ClsAdministradores admin){ 
        DaoAdministradores DaoAdministradores = new DaoAdministradores();
        return DaoAdministradores.ingresaAdministrador(admin); 
    }
    
    public int setModificarAdministrador(ClsAdministradores admin){ 
        DaoAdministradores DaoAdministradores = new DaoAdministradores();
        return DaoAdministradores.actualizarAdministradorPorId(admin); 
    }
    
}



