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
    public BusquedaMaterial(String tipoDeBusqueda, String keyWord, ConexionMedia conexionBaseDeDatos)
    {
        super(tipoDeBusqueda, keyWord);
        this.conexionBaseDeDatos = conexionBaseDeDatos;
    }
    
    public String realizarBusqueda()
    {
        String resultadoEnviar= "";
        ArrayList<Object> resultados = new ArrayList<>();
        resultados = conexionBaseDeDatos.consultaColumna(tipoDeBusqueda);
        if(resultados.contains(keyWord))
        {
            resultadoEnviar = construirRespuestaPositiva(resultados);
        }else
        {
            resultadoEnviar = construirRepuestaNegativa();
        }
        return resultadoEnviar;
        
    }
    
    private String construirRespuestaPositiva(ArrayList<Object> resultados)
    {
        String resultado = "Se encontraron los siguientes registros: ";
        for(int i  = 0; i < resultados.size(); i++)
        {
            if(resultados.get(i).equals(keyWord))
            {
                resultado = resultado + resultados.get(i);
            }
        }
        return resultado;
    }
    
    private String construirRepuestaNegativa()
    {
        String resp = "No se han encontrado registros para la siguiente busqueda: "+keyWord;
        return resp;
    }
}
