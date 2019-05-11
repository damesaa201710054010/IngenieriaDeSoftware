/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Busqueda.*;
import Busqueda.BusquedaMaterial;
import java.util.ArrayList;

/**
 *
 * @author danys
 */
public class Controlador {

    /**
     * @param args the command line argument
     */
    
    
    public static void main(String[] args) {
        Conexion base = new Conexion();
        BusquedaMaterial bus = new BusquedaMaterial("Titulo", "De animales a dioses", base);
        System.out.println(bus.realizarBusqueda());
        
    }
    
}
