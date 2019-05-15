/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import java.net.*;
import java.io.*;
import static java.lang.System.in;
import Modelo.ConexionBaseDeDatos.Conexion;
import Modelo.ConexionBaseDeDatos.ConexionMedia;
import Modelo.Busqueda.Busqueda;
import Modelo.Busqueda.BusquedaAutor;
/**
 *
 * @author danys
 */
public class ControladorPrincipal {
    String envioDeResultado = "";
    Conexion conexionBase = new Conexion();
    ConexionMedia intermediario = new ConexionMedia(conexionBase);
    ControladorBusqueda busquedas = new ControladorBusqueda(intermediario);
    public void comunicacion()
    {
        ServerSocket servidor;
        ServerSocket servidor2;
        
        System.out.println("esperando");
        try
        {
            servidor = new ServerSocket(30000);
            servidor2 = new ServerSocket(40000);
            while(true)
            {
                Socket sc = servidor.accept();
                Socket sc2 = servidor2.accept();
                BufferedReader entrada = new BufferedReader(new InputStreamReader(sc.getInputStream()));
                BufferedReader entrada1 = new BufferedReader(new InputStreamReader(sc2.getInputStream()));
                DataOutputStream out = new DataOutputStream(sc.getOutputStream());
                PrintWriter salida = new PrintWriter(new OutputStreamWriter(sc.getOutputStream()));
                //PrintWriter salida1 = new PrintWriter(new OutputStreamWriter(sc2.getOutputStream()));
                String keyWord = entrada.readLine().toString();
                String tipoBusqueda = entrada1.readLine().toString();
                System.out.println(keyWord);
                System.out.println(tipoBusqueda);
                if(tipoBusqueda.equalsIgnoreCase("Titulo") || tipoBusqueda.equalsIgnoreCase("Autor") )
                {
                    envioDeResultado = busquedas.busqueda(keyWord, tipoBusqueda);
                }
                System.out.println(envioDeResultado);
                salida.print(envioDeResultado);
                sc.close();
                sc2.close();
            }
         }catch (Exception e) 
         {
             System.err.println(e.getMessage());
             System.exit(1);
         }
    }
}
