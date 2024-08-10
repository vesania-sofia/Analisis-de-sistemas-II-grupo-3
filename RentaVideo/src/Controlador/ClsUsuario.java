/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;//  


import Modelo.daoUsuario;
import java.util.Date;
import java.util.List;

/**
 *
 * @author wendy
 */
public class ClsUsuario {
    private int id_usuario;
    private String nombre_usuario;
    private String contraseña_usuario;
    private String ultima_sesion_usuario;
    private String status_usuario;
    private String nombre_real_usuario;
    private String correo_usuario;
    private String telefono_usuario;
    private String direccion_usuario;
    private int id_tipo_usuario;
    public int getid_usuario;
    
    public int getid_usuario() {
        return id_usuario;
    }

    public void setid_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getnombre_usuario() {
        return nombre_usuario;
    }

    public void setnombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getcontraseña_usuario() {
        return contraseña_usuario;
    }

    public void setcontraseña_usuario(String contraseña_usuario) {
        this.contraseña_usuario = contraseña_usuario;
    }
    
    public String getultima_sesion_usuario() {
        return ultima_sesion_usuario;
    }

     public void setultima_sesion_usuario(String ultima_sesion_usuario) {
        this.ultima_sesion_usuario = ultima_sesion_usuario;
    }
    
    public String getstatus_usuario() {
        return status_usuario;
    }

    public void setstatus_usuario(String status_usuario) {
        this.status_usuario = status_usuario;
    }

    public String getnombre_real_usuario() {
        return nombre_real_usuario;
    }

    public void setnombre_real_usuario(String nombre_real_usuario) {
        this.nombre_real_usuario = nombre_real_usuario;
    }

    public String getcorreo_usuario() {
        return correo_usuario;
    }

    public void setcorreo_usuario(String correo_usuario) {
        this.correo_usuario = correo_usuario;
    }

    public String gettelefono_usuario() {
        return telefono_usuario;
    }

    public void settelefono_usuario(String telefono_usuario) {
        this.telefono_usuario = telefono_usuario;
    }

    public String getdireccion_usuario() {
        return direccion_usuario;
    }

    public void setdireccion_usuario(String direccion_usuario) {
        this.direccion_usuario = direccion_usuario;
    }

    public int getid_tipo_usuario() {
        return id_tipo_usuario;
    }

    public void setid_tipo_usuario(int id_tipo_usuario) {
        this.id_tipo_usuario = id_tipo_usuario;
    }

    public ClsUsuario() {
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
       
       public ClsUsuario(int id_usuario, String nombre_usuario, String contraseña_usuario, String ultima_sesion_usuario) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.contraseña_usuario = contraseña_usuario;
        this.ultima_sesion_usuario = ultima_sesion_usuario;
     
    }//public clsUsuario
      
      
      public ClsUsuario(int id_usuario, String nombre_usuario, String contraseña_usuario, String ultima_sesion_usuario, String status_usuario) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.contraseña_usuario = contraseña_usuario;
        this.ultima_sesion_usuario = ultima_sesion_usuario;
        this.status_usuario = status_usuario;
    }//public clsUsuario
      
        public ClsUsuario(int id_usuario, String nombre_usuario, String contraseña_usuario, String ultima_sesion_usuario, String status_usuario, String nombre_real_usuario) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.contraseña_usuario = contraseña_usuario;
        this.ultima_sesion_usuario = ultima_sesion_usuario;
        this.status_usuario = status_usuario;
        this.nombre_real_usuario = nombre_real_usuario;
    }//public clsUsuario
      
      
      public ClsUsuario(int id_usuario, String nombre_usuario, String contraseña_usuario, String ultima_sesion_usuario, String status_usuario, String nombre_real_usuario, String correo_usuario) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.contraseña_usuario = contraseña_usuario;
        this.ultima_sesion_usuario = ultima_sesion_usuario;
        this.status_usuario = status_usuario;
        this.nombre_real_usuario = nombre_real_usuario;
        this.correo_usuario = correo_usuario;
    }//public clsUsuario
      
     public ClsUsuario(int id_usuario, String nombre_usuario, String contraseña_usuario, String ultima_sesion_usuario, String status_usuario, String nombre_real_usuario, String correo_usuario, String telefono_usuario) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.contraseña_usuario = contraseña_usuario;
        this.ultima_sesion_usuario = ultima_sesion_usuario;
        this.status_usuario = status_usuario;
        this.nombre_real_usuario = nombre_real_usuario;
        this.correo_usuario = correo_usuario;
        this.telefono_usuario = telefono_usuario;}
        
     public ClsUsuario(int id_usuario, String nombre_usuario, String contraseña_usuario, String ultima_sesion_usuario, String status_usuario, String nombre_real_usuario, String correo_usuario, String telefono_usuario, String direccion_usuario) {
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

     
    public ClsUsuario(int id_usuario, String nombre_usuario, String contraseña_usuario, String ultima_sesion_usuario, String status_usuario, String nombre_real_usuario, String correo_usuario, String telefono_usuario, String direccion_usuario, int id_tipo_usuario) {
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
        return "ClsUsuario{" + "id_usuario =" + id_usuario    + ", nombre_usuario=" + nombre_usuario + ", contraseña_usuario=" + contraseña_usuario + ", ultima_sesion_usuario  =" + ultima_sesion_usuario   + ", status_usuario  =" + status_usuario + 
                ", nombre_real_usuario  =" + nombre_real_usuario + ", correo_usuario  =" + correo_usuario + 
                ", telefono_usuario  =" + telefono_usuario + ", direccion_usuario  =" + direccion_usuario + ", id_tipo_usuario  =" + id_tipo_usuario + '}';
    }
    //Metodos de acceso a la capa controlador
    public ClsUsuario getBuscarInformacionUsuarioPorNombre(ClsUsuario usuario)
    {
        daoUsuario daoUsuario = new daoUsuario();
        return daoUsuario.consultaUsuarioPorNombre(usuario);
    }
    public ClsUsuario getBuscarInformacionUsuarioPorId(ClsUsuario usuario)
    {
        daoUsuario daoUsuario = new daoUsuario();
        return daoUsuario.consultaUsuarioPorId(usuario);
    }    
    public List<ClsUsuario> getListadoUsuario()
    {
        daoUsuario daoUsuario = new daoUsuario();
        List<ClsUsuario> listadoUsuario = daoUsuario.consultaUsuario();
        return listadoUsuario;
    }
    public int setBorrarUsuario(ClsUsuario usuario)
    {
        daoUsuario daoUsuario = new daoUsuario();
        return daoUsuario.borrarUsuario(usuario);
    }          
    public int setIngresarRegistroCliente(ClsUsuario usuario)
    {
        daoUsuario daoUsuario = new daoUsuario();
        return daoUsuario.ingresarUsuario(usuario);
    }              
    public int setModificarUsuario(ClsUsuario usuario)
    {
        daoUsuario daoUsuario = new daoUsuario();
        return daoUsuario.actualizaUsuario(usuario);
    }              

    public void getTipModValor(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getTipMondValor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setUltima_sesion_usuario_util(java.sql.Date sqlDate) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public ClsUsuario login(String nombre_usuario, String contraseña_usuario) {
    ClsUsuario usuario = new ClsUsuario();
    usuario.setnombre_usuario(nombre_usuario);
    usuario.setcontraseña_usuario(contraseña_usuario);
    return new daoUsuario().consultaUsuarioPorNombre(usuario);
}

}

