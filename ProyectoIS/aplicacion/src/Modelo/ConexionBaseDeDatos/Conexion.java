/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.ConexionBaseDeDatos;
import Modelo.Busqueda.Libro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author danys
 */
public class Conexion {
    private final String URL = "jdbc:mysql://localhost:3306/librosdisponibles?useTimezone=true&serverTimezone=UTC"; 
    private final String USERNAME = "root";
    private final String PASSWORD = "2611";
    Connection conexionBaseDeDatos;
    
    public Conexion()
    {
        conexionBaseDeDatos = getConexion();
    }
    
    private Connection getConexion()
    {
        Connection con = null; 
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
        return con;
    }
    
    /**
     *
     * @param columna
     * @return
     */
    public ArrayList<Libro> getColumna()
    {
        Libro libro = null;
        ArrayList<Libro> resultado = new ArrayList<>();
        try{    
            PreparedStatement consulta = conexionBaseDeDatos.prepareStatement("SELECT"+" *"+" "+"FROM libros");
            ResultSet resultados = consulta.executeQuery();
            while(resultados.next())
            {
                int idLibro = resultados.getInt(1);
                String titulo =  resultados.getString(2);
                String autor = resultados.getString(3);
                int añoPublicacion = resultados.getInt(4);
                String lugarPublicacion =resultados.getString(5);
                String editorial = resultados.getString(6);
                libro = new Libro(idLibro, titulo, autor, añoPublicacion, lugarPublicacion, editorial);
                resultado.add(libro);
            }
            resultados.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return resultado;
    }
    
    
    public Libro getDato(String keyWord, String tipoDeBusqueda)
    {
        Libro libro = null;
        try{  
            PreparedStatement consulta = conexionBaseDeDatos.prepareStatement("SELECT"+" *"+" "+"FROM libros"+" where "+tipoDeBusqueda+" = "+ "\""+keyWord+"\"");
            ResultSet resultados = consulta.executeQuery();
            while(resultados.next())
            {
                int idLibro = resultados.getInt(1);
                String titulo =  resultados.getString(2);
                String autor = resultados.getString(3);
                int añoPublicacion = resultados.getInt(4);
                String lugarPublicacion =resultados.getString(5);
                String editorial = resultados.getString(6);
                libro = new Libro(idLibro, titulo, autor, añoPublicacion, lugarPublicacion, editorial);
                break;
            }
            resultados.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return libro;
    }
}
