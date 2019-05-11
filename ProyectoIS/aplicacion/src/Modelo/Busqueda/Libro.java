/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Busqueda;

/**
 *
 * @author danys
 */
public class Libro {
    int idLibro;
    String titulo;
    String autor;
    int añoPublicacion;
    String lugarPublicacion;
    String Editorial;
    public Libro(int idLibro, String titulo, String autor, int añoPublicacion, String lugarPublicacion, String Editorial)     
    {
       this.idLibro = idLibro;
       this.titulo = titulo;
       this.autor = autor;
       this.añoPublicacion = añoPublicacion;
       this.lugarPublicacion = lugarPublicacion;
       this.Editorial = Editorial;     
    }
    
    
}
