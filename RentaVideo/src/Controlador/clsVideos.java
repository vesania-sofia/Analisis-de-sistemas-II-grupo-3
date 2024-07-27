/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import java.util.List;
import Modelo.daoVideos;


/**
 *
 * @author macho
 */
public class clsVideos {
    
     private int id_video;
    private String titulo_video;
    private String precio_video;
    private float año_estreno_video;
    private String genero_video;
    private String actores_video;
    private String sintesis_video;
    private String existencia_video;
    private String formato_video;
   

    public clsVideos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

  
    public int getid_video() {
        return id_video;
    }

    public void setid_video(int id_video) {
        this.id_video = id_video;
    }

    public String gettitulo_video() {
        return titulo_video;
    }

    public void settitulo_video(String titulo_video) {
        this.titulo_video = titulo_video;
    }

    public String getprecio_video() {
        return precio_video;
    }

    public void setprecio_video(String precio_video) {
        this.precio_video = precio_video;
    }

    public float getaño_estreno_video() {
        return año_estreno_video;
    }

    public void setaño_estreno_video(float año_Estreno_video) {
        this.año_estreno_video = año_Estreno_video;
    }

    public String getgenero_video() {
        return genero_video;
    }

    public void setgenero_video(String genero_video) {
        this.genero_video = genero_video;
    }

    public String getactores_video() {
        return actores_video;
    }

    public void setactores_video(String actores_video) {
        this.actores_video = actores_video;
    }

    public String getsintesis_video() {
        return sintesis_video;
    }

    public void setsintesis_video(String sintesis_video) {
        this.sintesis_video = sintesis_video;
    }

    public String getexistencia_video() {
        return existencia_video;
    }

    public void setexistencia_video(String existencia_video) {
        this.existencia_video = existencia_video;
    }

    public String getformato_video() {
        return formato_video;
    }

    public void setformato_video(String formato_video) {
        this.formato_video = formato_video;
    }

  

    public clsVideos(int id_video, String titulo_video, String precio_video, float año_estreno_video, String genero_video, String actores_video, String sintesis_video, String existencia_video, String formato_video) {
        this.id_video = id_video;
        this.titulo_video = titulo_video;
        this.precio_video = precio_video;
        this.año_estreno_video = año_estreno_video;
        this.genero_video = genero_video;
        this.actores_video = actores_video;
        this.sintesis_video = sintesis_video;
        this.existencia_video = existencia_video;
        this.formato_video = formato_video;
        
    }

    public clsVideos(int id_video, String titulo_video, String precio_video, float año_estreno_video, String genero_video, String actores_video, String sintesis_video, String existencia_video) {
        this.id_video = id_video;
        this.titulo_video = titulo_video;
        this.precio_video = precio_video;
        this.año_estreno_video = año_estreno_video;
        this.genero_video = genero_video;
        this.actores_video = actores_video;
        this.sintesis_video = sintesis_video;
        this.existencia_video = existencia_video;
    
    }

    public clsVideos(int id_video, String titulo_video, String precio_video, float año_estreno_video, String genero_video, String actores_video, String sintesis_video) {
        this.id_video = id_video;
        this.titulo_video = titulo_video;
        this.precio_video = precio_video;
        this.año_estreno_video = año_estreno_video;
        this.genero_video = genero_video;
        this.actores_video = actores_video;
        this.sintesis_video = sintesis_video;
  
    }

    public clsVideos(int id_video, String titulo_video, String precio_video, float año_estreno_video, String genero_video, String actores_video) {
        this.id_video = id_video;
        this.titulo_video = titulo_video;
        this.precio_video = precio_video;
        this.año_estreno_video = año_estreno_video;
        this.genero_video = genero_video;
        this.actores_video = actores_video;
        
    }

    public clsVideos(int id_video, String titulo_video, String precio_video, float año_estreno_video, String genero_video) {
        this.id_video = id_video;
        this.titulo_video = titulo_video;
        this.precio_video = precio_video;
        this.año_estreno_video = año_estreno_video;
        this.genero_video = genero_video;
    
    }

    public clsVideos(int id_video, String titulo_video, String precio_video, float año_estreno_video) {
        this.id_video = id_video;
        this.titulo_video = titulo_video;
        this.precio_video = precio_video;
        this.año_estreno_video = año_estreno_video;
      
    }

    public clsVideos(int id_video, String titulo_video, String precio_video) {
        this.id_video = id_video;
        this.titulo_video = titulo_video;
        this.precio_video = precio_video;
        
    }

    public clsVideos(int id_video, String titulo_video) {
        this.id_video = id_video;
        this.titulo_video = titulo_video;
        
    }

    public clsVideos(int id_video) {
        this.id_video = id_video;
       
    }

  
    
   @Override
    public String toString() {
        return "clsVideos{" + "id_video =" + id_video  + ", titulo_video=" + titulo_video + ", precio_video=" + precio_video + ", año_estreno_video  =" + año_estreno_video   + ", genero_video  =" + genero_video + ",actores_video   =" + actores_video   +  ",sintesis_video" + sintesis_video+ "existencia_video" + existencia_video + "formato_video" + formato_video +  '}';
    }
    //Metodos de acceso a la capa controlador
    public clsVideos getBuscarInformacionVideoPorNombre(clsVideos video)
    {
        daoVideos daoVideos = new daoVideos();
        return daoVideos.consultaVideosPorNombre(video);
    }
    public clsVideos getBuscarInformacionVideoPorId(clsVideos video)
    {
        daoVideos daoVideos = new daoVideos();
        return daoVideos.consultaVideosPorId(video);
    }    
    public List<clsVideos> getListadoVideo()
    {
        daoVideos daoVideos = new daoVideos();
        List<clsVideos> listadovideos = daoVideos.consultavideos();
        return listadovideos;
    }
    public int setBorrarVideo(clsVideos video)
    {
        daoVideos daoVideos = new daoVideos();
        return daoVideos.borrarVideos(video);
    }          
    public int setIngresarVideo(clsVideos video)
    {
        daoVideos daoVideos = new daoVideos();
        return daoVideos.ingresaVideos(video);
    }              
    public int setModificarVideo(clsVideos video)
    {
        daoVideos daoVideos = new daoVideos();
        return daoVideos.actualizaVideos(video);
    }              


    
}
