/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Busqueda.BusquedaMaterial;
/**
 *
 * @author danys
 */
public class Main {

    /**
     * @param args the command line argument
     */
    
    
    public static void main(String[] args) {
        System.out.println("main");
        ControladorConexion conexionApp = new ControladorConexion();
        System.out.println("metodo");
        conexionApp.comunicacion();
    }
    
}
