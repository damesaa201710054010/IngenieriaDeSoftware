/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Busqueda;

import Modelo.Conexion.ConexionMedia;
import java.util.ArrayList;

/**
 *
 * @author danys
 */
public class BusquedaMaterial extends Busqueda {
    
    /**
     *
     * @param tipoDeBusqueda
     * @param keyWord
     * @param conexionBaseDeDatos
     */
    ConexionMedia conexionBaseDeDatos;
    public BusquedaMaterial(String columna, String keyWord, ConexionMedia conexionBaseDeDatos)
    {
        super(columna, keyWord);
        this.conexionBaseDeDatos = conexionBaseDeDatos;
    }
    
    public String realizarBusqueda()
    {
        String resultadoEnviar= "";
        boolean estadoDeRespuesta = false;
        estadoDeRespuesta = conexionBaseDeDatos.dato(columna, keyWord);
        Respuesta construirRespuesta =  new Respuesta();
        if(estadoDeRespuesta)
        {
            resultadoEnviar = construirRespuesta.respuestaPositiva(keyWord, columna );
        }else if(!estadoDeRespuesta)
        {
            resultadoEnviar = construirRespuesta.respuestaNegativa(keyWord, columna);
        }
        return resultadoEnviar;   
    }
}
