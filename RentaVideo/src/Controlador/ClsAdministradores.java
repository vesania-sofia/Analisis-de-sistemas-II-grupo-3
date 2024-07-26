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

    private int id_admin;
    private String nombre_admin;
    private String apellido_admin;
    private String direccion_admin;
    private String telefono_admin;
    private String correo_admin;
    private String contraseña_admin;
    private String estado_admin;
    private String nombre_usuario;
    
    public int getIdAdmin() {return id_admin; }  //getter
    public void setIDAdmin(int id_admin){this.id_admin = id_admin;} //setter
    
    public String getNombreAdmin() {return nombre_admin; }
    public void setNombreAdmin(String nombre_admin){this.nombre_admin = nombre_admin;}
    
    public String getApellidoAdmin() {return apellido_admin; }
    public void setApellidoAdmin(String apellido_admin){this.apellido_admin = apellido_admin;}
    
    public String getDireccionAdmin() {return direccion_admin; }
    public void setDireccionAdmin(String direccion_admin){this.direccion_admin = direccion_admin;}
    
    public String getTelefonoAdmin() {return telefono_admin; }
    public void setTelefonoAdmin(String telefono_administradores){this.telefono_admin = telefono_administradores;}
    
    public String getCorreoAdmin() {return correo_admin; }
    public void setCorreoAdmin(String correo_administradores){this.correo_admin = correo_administradores;}
    
    public String getContraAdmin() {return contraseña_admin; }
    public void setContraAdmin(String contraseña_admin){this.contraseña_admin = contraseña_admin;}
    
    public String getEstadoAdmin() {return estado_admin; }
    public void setEstadoAdmin(String estado_admin){this.estado_admin = estado_admin;}
    
    public String getNombreUsuario() {return nombre_usuario; }
    public void setNombreUsuario(String nombre_usuario){this.nombre_usuario = nombre_usuario;}
    
    public ClsAdministradores() {  
    }
    
    public ClsAdministradores (int id_adm) {
        this.id_admin = id_admin;
    }
    
    public ClsAdministradores(int id_administradores, String nombre_admin) {
        this.id_admin = id_admin;
        this.nombre_admin = nombre_admin;
    }

    public ClsAdministradores(int id_admin, String nombre_admin, String apellido_admin) {
        this.id_admin = id_admin;
        this.nombre_admin = nombre_admin;
        this.apellido_admin = apellido_admin;
    }

    public ClsAdministradores(int id_admin, String nombre_admin, String apellido_admin, String direccion_admin) {
        this.id_admin = id_admin;
        this.nombre_admin = nombre_admin;
        this.apellido_admin = apellido_admin;
        this.direccion_admin = direccion_admin;
    }

    public ClsAdministradores(int id_admin, String nombre_admin, String apellido_admin, String direccion_admin, String telefono_admin) {
        this.id_admin = id_admin;
        this.nombre_admin = nombre_admin;
        this.apellido_admin = apellido_admin;
        this.direccion_admin = direccion_admin;
        this.telefono_admin = telefono_admin;
    }

    public ClsAdministradores(int id_admin, String nombre_admin, String apellido_admin, String direccion_admin, String telefono_admin, String correo_admin) {
        this.id_admin = id_admin;
        this.nombre_admin = nombre_admin;
        this.apellido_admin = apellido_admin;
        this.direccion_admin = direccion_admin;
        this.telefono_admin = telefono_admin;
        this.correo_admin = correo_admin;
    }

    public ClsAdministradores(int id_admin, String nombre_admin, String apellido_admin, String direccion_admin, String telefono_admin, String correo_admin, String contraseña_admin) {
        this.id_admin = id_admin;
        this.nombre_admin = nombre_admin;
        this.apellido_admin = apellido_admin;
        this.direccion_admin = direccion_admin;
        this.telefono_admin = telefono_admin;
        this.correo_admin = correo_admin;
        this.contraseña_admin = contraseña_admin;
    }
    
    public ClsAdministradores(int id_admin, String nombre_admin, String apellido_admin, String direccion_admin, String telefono_admin, String correo_admin, String contraseña_admin, String estado_admin) {
        this.id_admin = id_admin;
        this.nombre_admin = nombre_admin;
        this.apellido_admin = apellido_admin;
        this.direccion_admin = direccion_admin;
        this.telefono_admin = telefono_admin;
        this.correo_admin = correo_admin;
        this.contraseña_admin = contraseña_admin;
        this.estado_admin = estado_admin;
    }

    public ClsAdministradores(int id_admin, String nombre_admin, String apellido_admin, String direccion_admin, String telefono_admin, String correo_admin, String contraseña_admin, String estado_admin, String nombre_usuario) {
        this.id_admin = id_admin;
        this.nombre_admin = nombre_admin;
        this.apellido_admin = apellido_admin;
        this.direccion_admin = direccion_admin;
        this.telefono_admin = telefono_admin;
        this.correo_admin = correo_admin;
        this.contraseña_admin = contraseña_admin;
        this.estado_admin = estado_admin;
        this.nombre_usuario = nombre_usuario;
    }
    
    
    
@Override
public String toString() {
        return "ClsAdministradores{" +
               "id_administradores=" + id_admin +
               ", nombre_administradores='" + nombre_admin + '\'' +
               ", apellido_administradores='" + apellido_admin + '\'' +
               ", direccion_administradores='" + direccion_admin + '\'' +
               ", telefono_administradores='" + telefono_admin + '\'' +
               ", correo_administradores='" + correo_admin + '\'' +
               ", contraseña_administradores='" + contraseña_admin+ '\'' +
               ", estado_administradores='" + estado_admin + '\'' +
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



