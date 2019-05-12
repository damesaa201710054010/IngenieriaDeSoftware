/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import java.net.*;
//importar la libreria java.net
 
import java.io.*;
import static java.lang.System.in;
import Modelo.Conexion.Conexion;
import Modelo.Conexion.ConexionMedia;
import Modelo.Busqueda.Busqueda;
import Modelo.Busqueda.BusquedaMaterial;
//importar la libreria java.io
/**
 *
 * @author danys
 */
public class ControladorConexion {
    String keyWord;
    Conexion conexionBase = new Conexion();
    ConexionMedia intermediario = new ConexionMedia(conexionBase);
    String envioDeResultado;
    public void comunicacion()
    {
        ServerSocket servidor;
        Socket sc  = null;
        int puerto = 15000;
        DataInputStream in;
        DataOutputStream out;
        System.out.println("esperand1o");
        try
        {
            servidor = new ServerSocket(puerto);
            System.out.println("esperando");
            while(true)
            {
                System.out.println("esperando R");
                sc = servidor.accept();
                System.out.println("esperando");
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());
                System.out.println("esperando");
                keyWord = in.readUTF();
                System.out.println(keyWord);
                BusquedaMaterial busqueda = new BusquedaMaterial("Titulo", keyWord, intermediario);
                envioDeResultado = busqueda.realizarBusqueda();
                out.writeUTF(envioDeResultado);
                sc.close();
            }
            
         }catch (Exception e) 
         {
             System.err.println(e.getMessage());
             System.exit(1);
         }
    }
}
