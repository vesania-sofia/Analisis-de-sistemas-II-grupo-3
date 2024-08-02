package Controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author visitante
 */
public class clsAdminConectado {
    private static int id_admin;
    private static String nombre_usuario;     
    
public clsAdminConectado() {
    }    

    public static int setIDAdmin() {
        return id_admin;
    }

    public static void setIDAdmin(int id_admin) {
        clsAdminConectado.id_admin = id_admin;
    }

    public static String getNombreUsuario() {
        return nombre_usuario;
    }

    public static void setNombreUsuario(String nombre_usuario) {
        clsAdminConectado.nombre_usuario = nombre_usuario;
    }

    
    
}
