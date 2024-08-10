/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import java.util.List;
import Modelo.daoVideo; 

/**
 *
 * @author macho
 */

/*CLASE CREADO POR CARLOS HERNANDEZ 9959-21-363*/
public class clsVideo {
    
    private int id_video;
    private String titulo_video;
    private float precio_video;
    private String año_estreno_video;
    private String genero_video;
    private String actores_video;
    private String sintesis_video;
    private String existencia_video;
    private String formato_video;

    public clsVideo(int id_video, String titulo_video, float precio_video, String año_estreno_video, String genero_video, String actores_video, String sintesis_video, String existencia_video, String formato_video) {
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

    public clsVideo(int id_video, String titulo_video, float precio_video, String año_estreno_video, String genero_video, String actores_video, String sintesis_video, String existencia_video) {
        this.id_video = id_video;
        this.titulo_video = titulo_video;
        this.precio_video = precio_video;
        this.año_estreno_video = año_estreno_video;
        this.genero_video = genero_video;
        this.actores_video = actores_video;
        this.sintesis_video = sintesis_video;
        this.existencia_video = existencia_video;
    }

    public clsVideo(int id_video, String titulo_video, float precio_video, String año_estreno_video, String genero_video, String actores_video, String sintesis_video) {
        this.id_video = id_video;
        this.titulo_video = titulo_video;
        this.precio_video = precio_video;
        this.año_estreno_video = año_estreno_video;
        this.genero_video = genero_video;
        this.actores_video = actores_video;
        this.sintesis_video = sintesis_video;
    }

    public clsVideo(int id_video, String titulo_video, float precio_video, String año_estreno_video, String genero_video, String actores_video) {
        this.id_video = id_video;
        this.titulo_video = titulo_video;
        this.precio_video = precio_video;
        this.año_estreno_video = año_estreno_video;
        this.genero_video = genero_video;
        this.actores_video = actores_video;
    }

    public clsVideo(int id_video, String titulo_video, float precio_video, String año_estreno_video, String genero_video) {
        this.id_video = id_video;
        this.titulo_video = titulo_video;
        this.precio_video = precio_video;
        this.año_estreno_video = año_estreno_video;
        this.genero_video = genero_video;
    }

    public clsVideo(int id_video, String titulo_video, float precio_video, String año_estreno_video) {
        this.id_video = id_video;
        this.titulo_video = titulo_video;
        this.precio_video = precio_video;
        this.año_estreno_video = año_estreno_video;
    }

    public clsVideo(int id_video, String titulo_video, float precio_video) {
        this.id_video = id_video;
        this.titulo_video = titulo_video;
        this.precio_video = precio_video;
    }

    public clsVideo(int id_video, String titulo_video) {
        this.id_video = id_video;
        this.titulo_video = titulo_video;
    }

    public clsVideo(int id_video) {
        this.id_video = id_video;
    }
   
    public clsVideo() {
        
    }
    
  

    public int getId_video() {
        return id_video;
    }

    public void setId_video(int id_video) {
        this.id_video = id_video;
    }

    public String getTitulo_video() {
        return titulo_video;
    }

    public void setTitulo_video(String titulo_video) {
        this.titulo_video = titulo_video;
    }

    public float getPrecio_video() {
        return precio_video;
    }

    public void setPrecio_video(float precio_video) {
        this.precio_video = precio_video;
    }

    public String getAño_estreno_video() {
        return año_estreno_video;
    }

    public void setAño_estreno_video(String año_estreno_video) {
        this.año_estreno_video = año_estreno_video;
    }

    public String getGenero_video() {
        return genero_video;
    }

    public void setGenero_video(String genero_video) {
        this.genero_video = genero_video;
    }

    public String getActores_video() {
        return actores_video;
    }

    public void setActores_video(String actores_video) {
        this.actores_video = actores_video;
    }

    public String getSintesis_video() {
        return sintesis_video;
    }

    public void setSintesis_video(String sintesis_video) {
        this.sintesis_video = sintesis_video;
    }

    public String getExistencia_video() {
        return existencia_video;
    }

    public void setExistencia_video(String existencia_video) {
        this.existencia_video = existencia_video;
    }

    public String getFormato_video() {
        return formato_video;
    }

    public void setFormato_video(String formato_video) {
        this.formato_video = formato_video;
    }
   
     @Override
    public String toString() {
        return "clsVideo{" + "id_video =" + id_video    + ", titulo_video=" + titulo_video + ", precio_video=" + precio_video + ", año_estreno_video  =" + año_estreno_video   + ", genero_video  =" + genero_video + 
                ", actores_video  =" + actores_video + ", sintesis_video  =" + sintesis_video + ", existencia_video  =" + existencia_video + ", formato_video  =" + formato_video +    '}';
    }
    //Metodos de acceso a la capa controlador
    public clsVideo getBuscarInformacionRegistroVideoPorNombre(clsVideo video)
    {
        daoVideo daoVideo = new daoVideo();
        return daoVideo.consultaRegistroVideoPorNombre(video);
    }
    public clsVideo getBuscarInformacionRegistroVideoPorId(clsVideo video)
    {
        daoVideo daoVideo = new daoVideo();
        return daoVideo.consultaRegistroVideoPorId(video);
    }    
    public List<clsVideo> getListadoRegistroVideo()
    {
        daoVideo daoVideo = new daoVideo();
        List<clsVideo> listadoVideos = daoVideo.consultaRegistroVideos();
        return listadoVideos;
    }
    public int setBorrarRegistroVideo(clsVideo video)
    {
        daoVideo daoVideo = new daoVideo();
        return daoVideo.borrarRegistroVideo(video);
    }          
    public int setIngresarRegistroVideo(clsVideo video)
    {
        daoVideo daoVideo = new daoVideo();
        return daoVideo.ingresarRegistroVideo(video);
    }              
    public int setModificarRegistroVideo(clsVideo video)
    {
        daoVideo daoVideo = new daoVideo();
        return daoVideo.actualizaRegistroVideo(video);
    }              

    public void getTipModValor(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getTipMondValor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
