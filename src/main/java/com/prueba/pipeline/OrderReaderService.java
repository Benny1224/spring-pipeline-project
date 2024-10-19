package com.prueba.pipeline;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderReaderService {

    private final JdbcTemplate jdbcTemplate;

    public OrderReaderService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Order> readOrders() {
        String query = "SELECT * FROM [pipeline].[dbo].[Ordenes]";
        try {
            return jdbcTemplate.query(query, (rs, rowNum) -> {
                Order order = new Order();
                order.setIduArticuloCodigo(rs.getInt("idu_ArticuloCodigo"));
                order.setFlagEstatus(rs.getInt("flag_Estatus"));
                order.setDesArea(rs.getString("des_Area"));
                order.setDesCategoria(rs.getString("des_Categoria"));
                order.setDesSubcategoria(rs.getString("des_Subcategoria"));
                order.setNumCantidad(rs.getInt("num_Cantidad"));
                order.setSecOrden(rs.getInt("sec_Orden"));
                order.setSecOrdenCommerce(rs.getInt("sec_OrdenCommerce"));
                order.setFecFechaOrden(rs.getTimestamp("fec_FechaOrden").toLocalDateTime());
                order.setIduBodegaCodigo(rs.getInt("idu_BodegaCodigo"));
                order.setFlagPromocion(rs.getBoolean("flag_Promocion"));
                order.setImpPrecioContadoUnitario(rs.getDouble("imp_PrecioContadoUnitario"));
                order.setImpDescuentoPromocion(rs.getDouble("imp_DescuentoPromocion"));
                return order;
            });
        } catch (Exception e) {
            System.err.println("Error al leer los datos de la tabla Ordenes: " + e.getMessage());
            return null;
        }
    }
}

