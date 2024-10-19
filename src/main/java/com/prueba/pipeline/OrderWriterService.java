package com.prueba.pipeline;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.dao.DataAccessException;

import jakarta.transaction.Transactional;

@Service
public class OrderWriterService {

    private static final Logger logger = LoggerFactory.getLogger(OrderWriterService.class);
    private final JdbcTemplate jdbcTemplate;

    public OrderWriterService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void writeOrders(List<Order> orders) {
        String insertQuery = "INSERT INTO [pipeline].[dbo].[OrdenesProcesadas] "
                + "(sec_OrdenCommerce, imp_TotalOrden, total_ProdsOrden, des_Agrupadas) VALUES (?, ?, ?, ?)";
        for (Order order : orders) {
        	try {
        	    jdbcTemplate.update(insertQuery, order.getSecOrdenCommerce(), order.getImpTotalOrden(), order.getTotalProdsOrden(), order.getDesAgrupadas());
        	} catch (DataAccessException e) {
        	    logger.error("Error al insertar la orden  sec_OrdenCommerce {}: {}", order.getSecOrdenCommerce(), e.getMessage());
        	    logger.debug("detalle de orden: {}", order, e);
        	}
        }
    }

}

