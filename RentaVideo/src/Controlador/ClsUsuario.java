/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.daoUsuario;
import java.sql.Date;
import Modelo.daoUsuario;
import java.util.List;

/**
 *
 * @author wendy
 */
public class ClsUsuario {
    private int id_usuario;
    private String nombre_usuario;
    private String contraseña_usuario;
    private Date ultima_sesion_usuario;
    private String status_usuario;
    private String nombre_real_usuario;
    private String correo_usuario;
    private String telefono_usuario;
    private String direccion_usuario;
    private int id_tipo_usuario;

    public ClsUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContraseña_usuario() {
        return contraseña_usuario;
    }

    public void setContraseña_usuario(String contraseña_usuario) {
        this.contraseña_usuario = contraseña_usuario;
    }
    
    public Date getUltima_sesion_usuario() {
        return ultima_sesion_usuario;
    }

    public void setUltima_sesion_usuario(Date ultima_sesion_usuario) {
        this.ultima_sesion_usuario = ultima_sesion_usuario;
    }

    public String getStatus_usuario() {
        return status_usuario;
    }

    public void setStatus_usuario(String status_usuario) {
        this.status_usuario = status_usuario;
    }

    public String getNombre_real_usuario() {
        return nombre_real_usuario;
    }

    public void setNombre_real_usuario(String nombre_real_usuario) {
        this.nombre_real_usuario = nombre_real_usuario;
    }

    public String getCorreo_usuario() {
        return correo_usuario;
    }

    public void setCorreo_usuario(String correo_usuario) {
        this.correo_usuario = correo_usuario;
    }

    public String getTelefono_usuario() {
        return telefono_usuario;
    }

    public void setTelefono_usuario(String telefono_usuario) {
        this.telefono_usuario = telefono_usuario;
    }

    public String getDireccion_usuario() {
        return direccion_usuario;
    }

    public void setDireccion_usuario(String direccion_usuario) {
        this.direccion_usuario = direccion_usuario;
    }

    public int getId_tipo_usuario() {
        return id_tipo_usuario;
    }

    public void setId_tipo_usuario(int id_tipo_usuario) {
        this.id_tipo_usuario = id_tipo_usuario;
    }

    
    
    public ClsUsuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }//public clsUsuario
    
      public ClsUsuario(int id_usuario, String nombre_usuario) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
    }//public clsUsuario
    
       public ClsUsuario(int id_usuario, String nombre_usuario, String contraseña_usuario) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.contraseña_usuario = contraseña_usuario;
    }//public clsUsuario
       
       public ClsUsuario(int id_usuario, String nombre_usuario, String contraseña_usuario, Date ultima_sesion_usuario) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.contraseña_usuario = contraseña_usuario;
        this.ultima_sesion_usuario = ultima_sesion_usuario;
     
    }//public clsUsuario
      
      
      public ClsUsuario(int id_usuario, String nombre_usuario, String contraseña_usuario, Date ultima_sesion_usuario, String status_usuario) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.contraseña_usuario = contraseña_usuario;
        this.ultima_sesion_usuario = ultima_sesion_usuario;
        this.status_usuario = status_usuario;
    }//public clsUsuario
      
        public ClsUsuario(int id_usuario, String nombre_usuario, String contraseña_usuario, Date ultima_sesion_usuario, String status_usuario, String nombre_real_usuario) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.contraseña_usuario = contraseña_usuario;
        this.ultima_sesion_usuario = ultima_sesion_usuario;
        this.status_usuario = status_usuario;
        this.nombre_real_usuario = nombre_real_usuario;
    }//public clsUsuario
      
      
      public ClsUsuario(int id_usuario, String nombre_usuario, String contraseña_usuario, Date ultima_sesion_usuario, String status_usuario, String nombre_real_usuario, String correo_usuario) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.contraseña_usuario = contraseña_usuario;
        this.ultima_sesion_usuario = ultima_sesion_usuario;
        this.status_usuario = status_usuario;
        this.nombre_real_usuario = nombre_real_usuario;
        this.correo_usuario = correo_usuario;
    }//public clsUsuario
      
     public ClsUsuario(int id_usuario, String nombre_usuario, String contraseña_usuario, Date ultima_sesion_usuario, String status_usuario, String nombre_real_usuario, String correo_usuario, String telefono_usuario, String direccion_usuario) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.contraseña_usuario = contraseña_usuario;
        this.ultima_sesion_usuario = ultima_sesion_usuario;
        this.status_usuario = status_usuario;
        this.nombre_real_usuario = nombre_real_usuario;
        this.correo_usuario = correo_usuario;
        this.telefono_usuario = telefono_usuario;
        this.direccion_usuario = direccion_usuario;
       
    }//public clsUsuario

     
    public ClsUsuario(int id_usuario, String nombre_usuario, String contraseña_usuario, Date ultima_sesion_usuario, String status_usuario, String nombre_real_usuario, String correo_usuario, String telefono_usuario, String direccion_usuario, int id_tipo_usuario) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.contraseña_usuario = contraseña_usuario;
        this.ultima_sesion_usuario = ultima_sesion_usuario;
        this.status_usuario = status_usuario;
        this.nombre_real_usuario = nombre_real_usuario;
        this.correo_usuario = correo_usuario;
        this.telefono_usuario = telefono_usuario;
        this.direccion_usuario = direccion_usuario;
        this.id_tipo_usuario = id_tipo_usuario;
    }//public clsUsuario

    @Override
    public String toString() {
        return "ClsUsuario{" + "id_usuario" + id_usuario + ", nombre_usuario = " + nombre_usuario + ", contraseña_usuario = " + contraseña_usuario + 
                ", ultima_sesion_usuario=" + ultima_sesion_usuario + ", status_usuario =" + status_usuario + ", nombre_real_usuario =" + nombre_real_usuario +
                ", correo_usuario = " + correo_usuario + ", telefono_usuario =" + telefono_usuario + ", direccion_usuario" + direccion_usuario +
                ", id_tipo_usuario" + id_tipo_usuario +  '}';
    }
   
    public ClsUsuario getBuscarUsuarioPorID(ClsUsuario users){
        daoUsuario daoUsuario = new daoUsuario();
        return daoUsuario.consultaBuscarUsuarioPorId(users);
    }

    public List<ClsUsuario> getListadoUsuarios()
    {
        daoUsuario daoUsuario = new daoUsuario();
        List<ClsUsuario> listadoUsuario = daoUsuario.consultaUsuario();
        return listadoUsuario;
    }
    
    public int setBorrarUsuarios(ClsUsuario users)
    {
        daoUsuario daoUsuario = new daoUsuario();
        return daoUsuario.borrarUsuario(users);
    }    
   
    public int setIngresarUsuarios( ClsUsuario users)
    {
        daoUsuario daoUsuario = new daoUsuario();
        return daoUsuario.ingresaUsuario(users);
    }              
    public int setModificarUsuario(ClsUsuario users)
    {
        daoUsuario daoUsuario = new daoUsuario();
        return daoUsuario.actualizaUsuario(users);
    }              
    
    
}//clase clsUsuario


