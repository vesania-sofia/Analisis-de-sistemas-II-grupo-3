/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import java.util.List;
import Modelo.daoTipUsu;

/**
 *
 * @author macho
 */
public class clsTipUsu {

    public int getId_tipo_usuario() {
        return id_tipo_usuario;
    }

    public void setId_tipo_usuario(int id_tipo_usuario) {
        this.id_tipo_usuario = id_tipo_usuario;
    }

    public String getNombre_tipo_usuario() {
        return nombre_tipo_usuario;
    }

    public void setNombre_tipo_usuario(String nombre_tipo_usuario) {
        this.nombre_tipo_usuario = nombre_tipo_usuario;
    }

    public String getStatus_tipo_usuario() {
        return status_tipo_usuario;
    }

    public void setStatus_tipo_usuario(String status_tipo_usuario) {
        this.status_tipo_usuario = status_tipo_usuario;
    }
    

    public clsTipUsu(int id_tipo_usuario, String nombre_tipo_usuario, String status_tipo_usuario) {
        this.id_tipo_usuario = id_tipo_usuario;
        this.nombre_tipo_usuario = nombre_tipo_usuario;
        this.status_tipo_usuario = status_tipo_usuario;
    }

    public clsTipUsu(int id_tipo_usuario, String nombre_tipo_usuario) {
        this.id_tipo_usuario = id_tipo_usuario;
        this.nombre_tipo_usuario = nombre_tipo_usuario;
    }

    public clsTipUsu(int id_tipo_usuario) {
        this.id_tipo_usuario = id_tipo_usuario;
    }

  
    
    private int id_tipo_usuario;
    private String nombre_tipo_usuario;
    private String status_tipo_usuario;

    public clsTipUsu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
    @Override
    public String toString() {
        return "clsTipUsu{" + "nombre_tipo_usuario =" + nombre_tipo_usuario  + ", status_tipo_usuario=" + status_tipo_usuario  + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsTipUsu getBuscarInformacionUsuarioPorNombre(clsTipUsu usuarios)
    {
        daoTipUsu daoTipUsu = new daoTipUsu();
        return daoTipUsu.consultaUsuariosPorNombre(usuarios);
    }
    public clsTipUsu getBuscarInformacionUsuarioPorId(clsTipUsu usuario)
    {
        daoTipUsu daoTipUsu = new daoTipUsu();
        return daoTipUsu.consultaUsuariosPorId(usuario);
    }    
    public List<clsTipUsu> getUsuariosVideo()
    {
        daoTipUsu daoTipUsu = new daoTipUsu();
        List<clsTipUsu> listadousuarios = daoTipUsu.consultausuarios();
        return listadousuarios;
    }
    public int setBorrarUsuario(clsTipUsu usuarios)
    {
        daoTipUsu daoTipUsu = new daoTipUsu();
        return daoTipUsu.borrarUsuarios(usuarios);
    }          
    public int setIngresarUsuario(clsTipUsu usuarios)
    {
        daoTipUsu daoTipUsu = new daoTipUsu();
        return daoTipUsu.ingresaUsusarios(usuarios);
    }              
    public int setModificarUsuario(clsTipUsu usuarios)
    {
        daoTipUsu daoTipUsu = new daoTipUsu();
        return daoTipUsu.actualizausuarios(usuarios);
    }              

    
    
    public void setId_tipo_ususario(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setNombre_tipo_ususario(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int id_tipo_ususario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String nombre_tipo_usuario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

    public String status_tipo_usuario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String gettitulo_video() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<clsTipUsu> getListadoUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



 
    
}
