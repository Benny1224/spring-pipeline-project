package com.prueba.pipeline;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.MapElements;
import org.apache.beam.sdk.transforms.SimpleFunction;
import org.apache.beam.sdk.values.TypeDescriptors;

import java.util.List;

public class OrderPipeline {

    public void runPipeline(List<Order> orders) {
        Pipeline pipeline = Pipeline.create();

        pipeline.apply("Crear ordenes", Create.of(orders))
                .apply("Transformar ordenes", MapElements.via(new SimpleFunction<Order, Order>() {
                    @Override
                    public Order apply(Order order) {
                        // Paso 1: Imputar valores faltantes
                        if (order.getDesArea() == null) order.setDesArea("No Definido");
                        if (order.getDesCategoria() == null) order.setDesCategoria("No Definido");
                        if (order.getDesSubcategoria() == null) order.setDesSubcategoria("No Definido");

                        // Paso 2: Convertir fechas a UTC-6
                        if (order.getFecFechaOrden() != null) {
                            order.setFecFechaOrden(order.getFecFechaOrden().minusHours(6));
                        }

                        // Paso 3: Agrupar y calcular columnas nuevas
                        order.setImpTotalOrden(order.getNumCantidad() * (order.getImpPrecioContadoUnitario() - order.getImpDescuentoPromocion()));
                        order.setTotalProdsOrden(order.getNumCantidad());

                        // Agrupar columnas en formato JSON
                        order.setDesAgrupadas(String.format("{\"area\": \"%s\", \"categoria\": \"%s\", \"subcategoria\": \"%s\"}",
                                order.getDesArea(), order.getDesCategoria(), order.getDesSubcategoria()));
                        return order;
                    }
                }));

        pipeline.run().waitUntilFinish();
    }
}
