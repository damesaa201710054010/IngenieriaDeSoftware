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
    private int idLibro;
    private String titulo;
    private String autor;
    private int añoPublicacion;
    private String lugarPublicacion;
    private String editorial;
    public Libro(int idLibro, String titulo, String autor, int añoPublicacion, String lugarPublicacion, String editorial)     
    {
       this.idLibro = idLibro;
       this.titulo = titulo;
       this.autor = autor;
       this.añoPublicacion = añoPublicacion;
       this.lugarPublicacion = lugarPublicacion;
       this.editorial = editorial;     
    }
    
    public String getTitulo()
    {
        return titulo;
    }
    
    public String getAutor()
    {
        return autor;
    }
    
    public String getLugarPublicacion()
    {
        return lugarPublicacion;
    }
    
    public String getEditorial()
    {
        return editorial;
    }
    
    public int getIdLibro()
    {
        return idLibro;
    }
    
    public int getAñoPublicacion()
    {
        return añoPublicacion;
    }
    
    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }
    
    public void setAutor(String autor)
    {
        this.autor = autor;
    }
    
    public void setLugarPublicacion(String lugarPublicacion)
    {
        this.lugarPublicacion =  lugarPublicacion;
    }
    
    public void setEditorial(String editorial)
    {
        this.editorial = editorial;
    }
    
    public void setIdLibro(int idLibro)
    {
        this.idLibro = idLibro;
    }
    
    public void setAñoPublicacion(int añoPublicacion)
    {
        this.añoPublicacion = añoPublicacion;
    }
    
}
