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
public class ConexionMedia {
    Conexion baseDeDatos;
    public ConexionMedia(Conexion baseDeDatos)
    {
        this.baseDeDatos = baseDeDatos;
    }
    
    public Libro busquedaEspecifica(String keyWord, String tipoDeBusqueda)
    {
        return baseDeDatos.getDato(keyWord, tipoDeBusqueda);
    }
    
    public ArrayList<Libro> busquedaKeyWord()
    {
        return baseDeDatos.getColumna();
    }
}
