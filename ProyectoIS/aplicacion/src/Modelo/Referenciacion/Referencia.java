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
public interface  Referencia {
    
   public abstract String construirCita(String autor, int añoPublicacion, String titulo, String lugarPublicacion, String editorial);
}
