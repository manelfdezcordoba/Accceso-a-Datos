package ies.juanbosco.DAO;
import ies.juanbosco.POJOS.Pedido;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"SqlResolve", "SqlNoDataSourceInspection", "SqlDialectInspection"})


public class PedidoDAO {
    public void insertar(Pedido p)throws SQLException{
        String sqlStock     = "SELECT stock FROM productos WHERE idproductos = ?";
        String sqlInsertar   = "INSERT INTO pedidos (fecha_pedido, cantidad, idproducto) VALUES (?,?,?)";
        String sqlDescuento = "UPDATE productos SET stock = stock - ? WHERE idproductos = ?";
       Connection con = null;
        try{
            con = ConexionDB.getConexion();
            con.setAutoCommit(false);
            int stockActual;
            try(PreparedStatement ps = con.prepareStatement(sqlStock)){
                ps.setInt(1,p.getIdproducto());
                try(ResultSet rs = ps.executeQuery()){
                    if(!rs.next()){
                        throw new SQLException("No existe ningun producto con id" + p.getIdproducto());
                    }
                    stockActual = rs.getInt("stock");
                }
            }
            if (stockActual < p.getCantidad()){
                throw new SQLException("Stock insuficiente \n Stock disponible : "+ stockActual);
            }
            try(PreparedStatement ps = con.prepareStatement(sqlInsertar, Statement.RETURN_GENERATED_KEYS)){
                ps.setDate(1, new java.sql.Date(p.getFechaPedido().getTime()));
                ps.setInt(2, p.getCantidad());
                ps.setInt(3, p.getIdproducto());
                ps.executeUpdate();
                try(ResultSet generadas = ps.getGeneratedKeys()){
                    if (generadas.next()){
                        p.setId(generadas.getInt(1));
                    }
                }
            }
            try(PreparedStatement ps = con.prepareStatement(sqlDescuento)){
                ps.setInt(1, p.getCantidad());
                ps.setInt(2, p.getIdproducto());
                ps.executeUpdate();
            }
            con.commit();
        }catch ( SQLException e){
            if(con != null){
                con.rollback();
            }
            throw e;

        }finally{
            if(con != null){
                con.setAutoCommit(true);
                con.close();
            }
        }
    }
public List<Pedido> listar() throws SQLException {
    String sql = "SELECT ped.idpedidos, ped.fecha_pedido, ped.cantidad, ped.idproducto, "
            + "pro.nombre AS nombre_producto "
            + "FROM pedidos ped "
            + "INNER JOIN productos pro ON ped.idproducto = pro.idproductos "
            + "ORDER BY ped.idpedidos";
        List<Pedido> pedidos = new ArrayList<>();
        try(Connection con = ConexionDB.getConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs= ps.executeQuery()){
            while (rs.next()){
                Pedido p = new Pedido();
                p.setId(rs.getInt("idpedidos"));
                p.setFechaPedido(rs.getDate("fecha_pedido"));
                p.setCantidad(rs.getInt("cantidad"));
                p.setIdproducto(rs.getInt("idproducto"));
                p.setNombre_producto(rs.getString("nombre_producto"));
                pedidos.add(p);
            }
        }
        return pedidos;
    }
}
