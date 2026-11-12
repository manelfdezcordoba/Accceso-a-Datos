package ies.juanbosco.dao;

import ies.juanbosco.POJOs.pokemon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"SqlResolve", "SqlNoDataSourceInspection", "SqlDialectInspection"})

public class pokemonDAO {

public void insertar(pokemon pk )throws SQLException{
    String sqlInsertar = "INSERT INTO pokemon (nombre, numero, genero, habilidad, identrenador)  VALUES(?,?,?,?,?)";

    Connection con = conexionDB.getConexionDB();

    try(PreparedStatement ps = con.prepareStatement(sqlInsertar, Statement.RETURN_GENERATED_KEYS)){
ps.setString(1, pk.getNombre());
 ps.setInt(2,pk.getNumero());
 ps.setString(3,pk.getGenero());
 ps.setString(4,pk.getHabilidad());
 ps.setInt(5,pk.getIdentrandor());
 ps.executeUpdate();
 try(ResultSet rs = ps.getGeneratedKeys()){
     if (rs.next()){
         pk.setId(rs.getInt(1));
     }
 }

    }

}
public List <pokemon> verPokemon()throws SQLException{
    String sql = "SELECT pk.id, pk.nombre, pk.numero, pk.genero, pk.habilidad, " +
            "pk.identrenador, ent.nombre AS nombre_entre " +
            "FROM pk pokemon INNER JOIN entrenador ent ON pk.identrenador = ent.idEntrenador " +
            "ORDER BY pk.id";

    List<pokemon> pokemons = new ArrayList<>();
        try(Connection con = conexionDB.getConexionDB() ;
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                pokemon p = new pokemon();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setNumero(rs.getInt("numero"));
                p.setGenero(rs.getString("genero"));
                p.setHabilidad(rs.getString("habilidad"));
                p.setIdentrandor(rs.getInt("identrenador"));
                p.setNombreEnt(rs.getString("nombre_entre"));
                pokemons.add(p);
        }
    }
        return pokemons;
}



}
