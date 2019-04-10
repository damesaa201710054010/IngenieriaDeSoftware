/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

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
    
    private Connection getConexion()
    {
        Connection con = null; 
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
            /*if(con != null)
            {
                System.out.println ("conexion establecida");
            }*/
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
    public ArrayList<Object> consultaColumna(String columna)
    {
        ArrayList<Object> resultado = new ArrayList<>();
        try{    
            Connection conexionBaseDeDatos = getConexion();
            PreparedStatement consulta = conexionBaseDeDatos.prepareStatement("SELECT"+" "+columna+" "+"FROM libros");
            ResultSet resultados = consulta.executeQuery();
            while(resultados.next())
            {
               resultado.add(resultados.getString(columna));
            }
            conexionBaseDeDatos.close();
            resultados.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return resultado;
    }
}
