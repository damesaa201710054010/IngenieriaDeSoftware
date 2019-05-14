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
public abstract class Busqueda {
    protected String tipoDeBusqueda;
    protected String keyWord;
    public Busqueda(String tipoDeBusqueda, String keyWord)
    {
        this.tipoDeBusqueda = tipoDeBusqueda;
        this.keyWord = keyWord;
    }
   abstract public boolean busquedaEspecifica(String keyWord);
   abstract public ArrayList<String> busquedaKeyWord(String keyWord);
   
}
