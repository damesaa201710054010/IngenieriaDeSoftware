/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Busqueda;

import Modelo.ConexionBaseDeDatos.ConexionMedia;
import Modelo.Referenciacion.Referencia;
import java.util.ArrayList;

/**
 *
 * @author danys
 */
public class BusquedaTitulo extends Busqueda {
     /**
     *
     * @param tipoDeBusqueda
     * @param keyWord
     * @param conexionBaseDeDatos
     */
    ConexionMedia conexionBaseDeDatos;
    public BusquedaTitulo(String keyWord, ConexionMedia conexionBaseDeDatos, Referencia cita)
    {
        super(keyWord, cita);
        this.conexionBaseDeDatos = conexionBaseDeDatos;
    }
    
    @Override
    public boolean busquedaEspecifica()
    {
        Libro resultadoBD= null;
        boolean respuesta = false;
        resultadoBD = conexionBaseDeDatos.busquedaEspecifica(keyWord, "Titulo");
        if(resultadoBD != null) 
        {
            respuesta = true;
            citacion = cita.construirCita(resultadoBD.getAutor(), resultadoBD.getAñoPublicacion(), resultadoBD.getTitulo(), resultadoBD.getLugarPublicacion(), resultadoBD.getEditorial());
        }else if(resultadoBD == null || !(resultadoBD.getTitulo().equals(keyWord)))
        {
            respuesta = false;
        }
     return respuesta;
    }
    
    @Override
    public ArrayList<Object> busquedaKeyWord()
    {
        ArrayList<Libro> resultadosBD = conexionBaseDeDatos.busquedaKeyWord();
        ArrayList<Object> respuesta = new ArrayList<>();
        for(int i = 0; i < resultadosBD.size(); i++)
        {
            if(resultadosBD.get(i).getTitulo().equals(keyWord))
            {
                respuesta.add(resultadosBD.get(i));
            }
        }
        return respuesta;
    }
    
    @Override
    public String getCita()
    {
        return citacion;
    }
}
