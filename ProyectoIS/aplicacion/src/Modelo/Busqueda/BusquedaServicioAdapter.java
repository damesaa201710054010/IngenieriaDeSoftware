/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Busqueda;
import Modelo.Referenciacion.Referencia;
import java.util.ArrayList;

/**
 *
 * @author danys
 */
public class BusquedaServicioAdapter extends Busqueda {
    private BusquedaServicio servicio;
    public BusquedaServicioAdapter(String keyWord, Referencia cita)
    {
        super(keyWord, cita);
        servicio = new BusquedaServicio(keyWord);
    }
    
    public boolean busquedaEspecifica()
    {
        ArrayList<Servicio> consulta = servicio.busquedaGeneral();
        for(int i = 0; i < consulta.size(); ++i)
        {
            if(consulta.get(i).getNombre().equalsIgnoreCase(keyWord))
            {
                return true;
            }
            
        }
        return false;
    }
    
    public ArrayList<Object> busquedaKeyWord()
    {
        ArrayList<Object> consulta = new ArrayList<>();
        consulta = servicio.busquedaDescripcion(keyWord);
        return consulta;
    }
    
    public String getCita()
    {
        return citacion;
    }
    
}
