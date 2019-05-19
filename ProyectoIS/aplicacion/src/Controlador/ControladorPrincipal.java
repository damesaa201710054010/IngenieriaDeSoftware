package Controlador;
import java.net.*;
import java.io.*;
import static java.lang.System.in;
import Modelo.ConexionBaseDeDatos.Conexion;
import Modelo.ConexionBaseDeDatos.ConexionMedia;
import Modelo.Busqueda.Busqueda;
import Modelo.Busqueda.BusquedaAutor;
/**
 * Ejecuta el programa y establece la conexion con el cliente.
 * @author Daniel Mesa, Felipe Olaya
 * @version 1.0
 */
public class ControladorPrincipal {
    String envioDeResultado = "";
    Conexion conexionBase = new Conexion();
    ConexionMedia intermediario = new ConexionMedia(conexionBase);
    ControladorBusqueda busquedas = new ControladorBusqueda(intermediario);
    /**
     * Este metodo realiza la comunicacion con el cliente, ademas ejecuta el programa, tenieando la decision del tipo de busqueda que debe de realizar
     * ademas este es el unico que e debe de conectar con el servidor, por lo tanto debe de enviar tambien la respuesta al cliente
     * 
     */
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
