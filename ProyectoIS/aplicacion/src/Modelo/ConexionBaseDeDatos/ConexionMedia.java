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
public class ConexionMedia {
    Conexion baseDeDatos;
    public ConexionMedia(Conexion baseDeDatos)
    {
        this.baseDeDatos = baseDeDatos;
    }
    
    public String busquedaEspecifica(String keyWord, String columna)
    {
        return baseDeDatos.getDato(columna , keyWord);
    }
    
    public ArrayList<String> busquedaKeyWord(String columna)
    {
        return baseDeDatos.getColumna(columna);
    }
}
