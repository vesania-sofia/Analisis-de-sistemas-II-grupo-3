/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author maria
 */
public class ClsUsuarioConectado {

    private static int id_usuario;
    private static String nombre_usuario;     
    
public ClsUsuarioConectado() {
    }    

    public static int getid_usuario() {
        return id_usuario;
    }

    public static void setid_usuario(int id_usuario) {
        ClsUsuarioConectado.id_usuario = id_usuario;
    }

    public static String getnombre_usuario() {
        return nombre_usuario;
    }

    public static void setnombre_usuario(String nombre_usuario) {
        ClsUsuarioConectado.nombre_usuario = nombre_usuario;
    }

    
    
}

    

