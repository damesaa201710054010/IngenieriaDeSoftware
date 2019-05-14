/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Busqueda;
import Modelo.ConexionBaseDeDatos.ConexionMedia;
import java.util.ArrayList;

/**
 *
 * @author danys
 */
public class BusquedaAutor extends Busqueda {
    
    /**
     *
     * @param tipoDeBusqueda
     * @param keyWord
     * @param conexionBaseDeDatos
     */
    ConexionMedia conexionBaseDeDatos;
    public BusquedaAutor(String tipoDeBusqueda, String keyWord, ConexionMedia conexionBaseDeDatos)
    {
        super(tipoDeBusqueda, keyWord);
        this.conexionBaseDeDatos = conexionBaseDeDatos;
    }
    
    @Override
    public boolean busquedaEspecifica(String keyWord)
    {
        String resultadoBD= "";
        boolean respuesta = false;
        resultadoBD = conexionBaseDeDatos.busquedaEspecifica(tipoDeBusqueda, keyWord);
        if(keyWord.equals(resultadoBD))
        {
            respuesta = true;
        }else if(resultadoBD == null || !(keyWord.equals(resultadoBD)))
        {
            respuesta = false;
        }
        return respuesta;   
    }
    
    @Override
    public ArrayList<String> busquedaKeyWord(String keyWord)
    {
        ArrayList<String> resultadosBD = conexionBaseDeDatos.busquedaKeyWord(tipoDeBusqueda);
        ArrayList<String> respuesta = new ArrayList<>();
        for(int i = 0; i < resultadosBD.size(); i++)
        {
            if(resultadosBD.get(i).contains(keyWord))
            {
                respuesta.add(resultadosBD.get(i));
            }
        }
        return respuesta;
    }
}
