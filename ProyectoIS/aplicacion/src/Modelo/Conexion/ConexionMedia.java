/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Conexion;

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
public class ConexionMedia {
    Conexion baseDeDatos;
    public ConexionMedia(Conexion baseDeDatos)
    {
        this.baseDeDatos = baseDeDatos;
    }
    
    private ArrayList<Object> realizarBusquedaPorTitulo(String titulo)
    {
        return baseDeDatos.consultaColumna(titulo);
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
