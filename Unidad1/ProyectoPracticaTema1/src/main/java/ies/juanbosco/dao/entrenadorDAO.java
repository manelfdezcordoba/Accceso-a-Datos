package ies.juanbosco.dao;


import ies.juanbosco.POJOs.entrenador;

import java.sql.*;
@SuppressWarnings({"SqlResolve", "SqlNoDataSourceInspection", "SqlDialectInspection"})

// para que no salga errores con los nombres de las consultas a la bdd
public class entrenadorDAO {

    public boolean insertar(entrenador e)throws SQLException{
    String sqlInsertar = "INSERT INTO entrenador (nombre, region) VALUES (?,?)";
   try(Connection con = conexionDB.getConexionDB();
       PreparedStatement ps = con.prepareStatement(sqlInsertar, Statement.RETURN_GENERATED_KEYS)){
       ps.setString(1,e.getNombre());
       ps.setString(2, e.getRegion());

   if (ps.executeUpdate() == 0 )return false;
   try(ResultSet rs = ps.getGeneratedKeys()){
       if (rs.next()){
           e.setId(rs.getInt(1));
       }
   }
   return true;
   }
    }
    public entrenador devolverporNombre(String nombre)throws SQLException{
        String sqlBuscar= "SELECT idEntrenador, nombre, region FROM entrenador WHERE nombre = ?";
    try(Connection con = conexionDB.getConexionDB();
    PreparedStatement ps = con.prepareStatement(sqlBuscar)){
        ps.setString(1, nombre);
        try(ResultSet rs = ps.executeQuery()){
            if (!rs.next()){
                return null;
            }
            return new entrenador(rs.getInt("idEntrenador"),
                    rs.getString("nombre"),
                    rs.getString("region"));


            }
        }

    }


    }




