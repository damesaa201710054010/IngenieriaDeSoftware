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
public abstract class Busqueda {
    protected String keyWord;
    protected Referencia cita;
    protected String citacion;
    public Busqueda(String keyWord, Referencia cita)
    {
        this.keyWord = keyWord;
        this.cita = cita;
    }
   abstract public boolean busquedaEspecifica();
   abstract public ArrayList<Object> busquedaKeyWord();
   abstract public String getCita();
}
