/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Busqueda;
import java.util.ArrayList;
/**
 *
 * @author danys
 */
public class BusquedaServicio {
    ArrayList<Servicio> servicios;
    String keyWord;
    public BusquedaServicio(String keyWord)
    {
        this.keyWord = keyWord;
    }
    
    public ArrayList<Servicio> busquedaGeneral()
    {
        ArrayList<Servicio> respuestas = new ArrayList<>();
        for(int i = 0; i < servicios.size(); i++)
        {
            if(servicios.get(i).getNombre().contains(keyWord))
            {
                respuestas.add(servicios.get(i));
            }
        }
        return respuestas;
    }
    
    public ArrayList<Object> busquedaDescripcion(String keyWord)
    {
        ArrayList<Object> resultados = new ArrayList<>();
        for(int i = 0; i < servicios.size(); ++i)
        {
            if(servicios.get(i).getDescripcion().contains(keyWord))
            {
                resultados.add(servicios.get(i));
            }
        }
        return resultados;
    }
    
    public void addServicio(String nombre, String url, String descripcion)
    {
        servicios.add(new Servicio(nombre, url, descripcion));
    }
    
    public void removeServicio(String nombre)
    {
        for(int i = 0; i < servicios.size(); ++i)
        {
            if(servicios.get(i).getNombre().equals(nombre))
            {
                servicios.remove(i);
                break;
            }
        }
        
    }
}