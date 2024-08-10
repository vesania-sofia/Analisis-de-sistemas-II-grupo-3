/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import java.util.List;
import Modelo.daoTipUsu;

/**
 *
 * @author DELL
 */
public class clsTipUsu {
    private int id_tipo_usuario;
    private String nombre_Tusuario;
    private String status_Tusuario;

    public clsTipUsu() {
    }

    public clsTipUsu(int id_tipo_usuario) {
        this.id_tipo_usuario = id_tipo_usuario;
    }

    public clsTipUsu(int id_tipo_usuario, String nombre_Tusuario) {
        this.id_tipo_usuario = id_tipo_usuario;
        this.nombre_Tusuario = nombre_Tusuario;
    }

    public clsTipUsu(int id_tipo_usuario, String nombre_Tusuario, String status_Tusuario) {
        this.id_tipo_usuario = id_tipo_usuario;
        this.nombre_Tusuario = nombre_Tusuario;
        this.status_Tusuario = status_Tusuario;
    }

    public int getId_tipo_usuario() {
        return id_tipo_usuario;
    }

    public void setId_tipo_usuario(int id_tipo_usuario) {
        this.id_tipo_usuario = id_tipo_usuario;
    }

    public String getNombre_Tusuario() {
        return nombre_Tusuario;
    }

    public void setNombre_Tusuario(String nombre_Tusuario) {
        this.nombre_Tusuario = nombre_Tusuario;
    }

    public String getStatus_Tusuario() {
        return status_Tusuario;
    }

    public void setStatus_Tusuario(String status_Tusuario) {
        this.status_Tusuario = status_Tusuario;
    }
    
    @Override
    public String toString() {
        return "clsTipUsu{" + "nombre_Tusuario =" + nombre_Tusuario  + ", status_Tusuario=" + status_Tusuario  + '}';
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
    public List<clsTipUsu> getListadoUsuarios()
    {
        daoTipUsu daoTipUsu = new daoTipUsu();
        List<clsTipUsu> listadoUsuario = daoTipUsu.consultausuarios();
        return listadoUsuario;
    }
    
    /*public List<clsTipUsu> getUsuariosVideo()
    {
        daoTipUsu daoTipUsu = new daoTipUsu();
        List<clsTipUsu> listadousuarios = daoTipUsu.consultausuarios();
        return listadousuarios;
    }*/
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
    } 