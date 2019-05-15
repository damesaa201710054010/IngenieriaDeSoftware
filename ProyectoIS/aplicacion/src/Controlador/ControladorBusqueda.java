/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Busqueda.BusquedaAutor;
import Modelo.Busqueda.BusquedaTitulo;
import Modelo.ConexionBaseDeDatos.ConexionMedia;
import Modelo.Referenciacion.Referencia;
import Modelo.Referenciacion.ReferenciacionApa;
import Vista.Respuesta;

/**
 *
 * @author danys
 */
public class ControladorBusqueda {
    private ConexionMedia baseDeDatos;
    public ControladorBusqueda(ConexionMedia baseDeDatos)
    {
        this.baseDeDatos = baseDeDatos;
    }
    
    public String busqueda(String keyWord, String tipoDeBusqueda)
    {
        if(tipoDeBusqueda.equalsIgnoreCase("Titulo"))
        {
            return busquedaPorTitulo(keyWord);
        }else if(tipoDeBusqueda.equalsIgnoreCase("Autor"))
        {
           return busquedaPorAutor(keyWord);
        }
        return "Busqueda invalida";
    }
    
    public String busquedaPorTitulo(String keyWord)
    {
        Referencia cita = new ReferenciacionApa();
        BusquedaTitulo buscar = new BusquedaTitulo(keyWord, baseDeDatos, cita);
        Respuesta envio = new Respuesta();
        boolean resultado = buscar.busquedaEspecifica();
        return envio.reespuestaEspecifica(resultado, buscar.getCita(), keyWord);
    }
    
    public String busquedaPorAutor(String keyWord)
    {
        Referencia cita = new ReferenciacionApa();
        BusquedaAutor buscar = new BusquedaAutor(keyWord, baseDeDatos, cita);
        Respuesta envio = new Respuesta();
        boolean resultado = buscar.busquedaEspecifica();
        return envio.reespuestaEspecifica(resultado, buscar.getCita(), keyWord);
    }
    
    
}
