/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.ConexionBaseDeDatos;
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
    public ArrayList<String> getColumna(String columna)
    {
        ArrayList<String> resultado = new ArrayList<>();
        try{    
            PreparedStatement consulta = conexionBaseDeDatos.prepareStatement("SELECT"+" "+columna+" "+"FROM libros");
            ResultSet resultados = consulta.executeQuery();
            while(resultados.next())
            {
               resultado.add(resultados.getString(columna));
            }
            resultados.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return resultado;
    }
    
    
    public String  getDato(String columna, String keyWord)
    {
        String resultado = "";
        try{  
            PreparedStatement consulta = conexionBaseDeDatos.prepareStatement("SELECT"+" "+columna+" "+"FROM libros"+" where Titulo = "+ "\""+keyWord+"\"");
            ResultSet resultados = consulta.executeQuery();
            while(resultados.next())
            {
               resultado = resultados.getString(columna);
            }
            resultados.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return resultado;
    }
}
