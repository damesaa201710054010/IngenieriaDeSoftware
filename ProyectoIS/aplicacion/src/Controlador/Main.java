package Controlador;

import Modelo.Busqueda.BusquedaAutor;
import Modelo.ConexionBaseDeDatos.Conexion;
/**
 * Clase principal para el llamado del sistema
 * @author Daniel Mesa, Felipe Olaya
 * @version 1.0
 */
public class Main {

    /**
     * Crea el controlador principal para la ejecucion del programa
     * @param args the command line argument
     */
    public static void main(String[] args) {
        ControladorPrincipal controlador= new ControladorPrincipal();
        controlador.comunicacion();
    }
    
}
