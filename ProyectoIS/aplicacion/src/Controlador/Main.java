/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Busqueda.BusquedaAutor;
import Modelo.ConexionBaseDeDatos.Conexion;
/**
 *
 * @author danys
 */
public class Main {

    /**
     * @param args the command line argument
     */
    public static void main(String[] args) {
        ControladorPrincipal controlador= new ControladorPrincipal();
        controlador.comunicacion();
    }
    
}
