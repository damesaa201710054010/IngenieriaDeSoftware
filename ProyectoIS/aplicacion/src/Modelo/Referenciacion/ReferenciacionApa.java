/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Referenciacion;

/**
 *
 * @author danys
 */
public class ReferenciacionApa implements Referencia {
    @Override
    public String construirCita(String autor, int añoPublicacion, String titulo, String lugarPublicacion, String editorial)
    {
        String cita = autor+" "+" ("+añoPublicacion+"). "+titulo+". "+lugarPublicacion+":"+editorial+".";
        return cita;
    }
}
