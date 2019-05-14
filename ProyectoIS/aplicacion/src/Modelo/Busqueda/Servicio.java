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
public class Servicio {
    private String nombre;
    private String url;
    private String descripcion;
    public Servicio(String nombre, String url, String descripcion)
    {
        this.nombre = nombre;
        this.url = url;
        this.descripcion = descripcion;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public String getUrl()
    {
        return url;
    }
    public String getDescripcion()
    {
        return descripcion;
    }
    public void setNombre(String nombre)
    {
        this.nombre =  nombre;
    }
    public void setUrl(String url)
    {
        this.url = url;
    }
    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }
    
}
