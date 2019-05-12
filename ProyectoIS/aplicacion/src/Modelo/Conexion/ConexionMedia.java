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
    
    public ArrayList<Object> realizarBusquedaPorTituloTodos(String columna)
    {
        return baseDeDatos.getColumna(columna);
    }
    
    public boolean dato(String columna, String keyWord)
    {
        return baseDeDatos.dato(columna, keyWord);
    }
}
