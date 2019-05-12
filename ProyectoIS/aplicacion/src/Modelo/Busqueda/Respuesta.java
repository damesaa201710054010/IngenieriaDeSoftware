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
public class Respuesta {
    public String respuestaPositiva(String keyWord, String columna )
    {
        return keyWord+" se encontro disponible en "+columna;
    }
    
    public String respuestaNegativa(String keyWord, String columna)
    {
        return keyWord+" no se encontro disponible en "+columna;
    }
}
