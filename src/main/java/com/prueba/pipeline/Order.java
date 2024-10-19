	package com.prueba.pipeline;
	import java.time.LocalDateTime;
	
public class Order {

	private int iduArticuloCodigo;
    private int flagEstatus;
    private String desArea;
    private String desCategoria;
    private String desSubcategoria;
    private int numCantidad;
    private int secOrden;
    private int secOrdenCommerce;
    private LocalDateTime fecFechaOrden;
    private int iduBodegaCodigo;
    private boolean flagPromocion;
    private double impPrecioContadoUnitario;
    private double impDescuentoPromocion;

    // Nuevas columnas calculadas
    private double impTotalOrden;
    private int totalProdsOrden;
    private String desAgrupadas;
	public int getIduArticuloCodigo() {
		return iduArticuloCodigo;
	}
	public void setIduArticuloCodigo(int iduArticuloCodigo) {
		this.iduArticuloCodigo = iduArticuloCodigo;
	}
	public int getFlagEstatus() {
		return flagEstatus;
	}
	public void setFlagEstatus(int flagEstatus) {
		this.flagEstatus = flagEstatus;
	}
	public String getDesArea() {
		return desArea;
	}
	public void setDesArea(String desArea) {
		this.desArea = desArea;
	}
	public String getDesCategoria() {
		return desCategoria;
	}
	public void setDesCategoria(String desCategoria) {
		this.desCategoria = desCategoria;
	}
	public String getDesSubcategoria() {
		return desSubcategoria;
	}
	public void setDesSubcategoria(String desSubcategoria) {
		this.desSubcategoria = desSubcategoria;
	}
	public int getNumCantidad() {
		return numCantidad;
	}
	public void setNumCantidad(int numCantidad) {
		this.numCantidad = numCantidad;
	}
	public int getSecOrden() {
		return secOrden;
	}
	public void setSecOrden(int secOrden) {
		this.secOrden = secOrden;
	}
	public int getSecOrdenCommerce() {
		return secOrdenCommerce;
	}
	public void setSecOrdenCommerce(int secOrdenCommerce) {
		this.secOrdenCommerce = secOrdenCommerce;
	}
	public LocalDateTime getFecFechaOrden() {
		return fecFechaOrden;
	}
	public void setFecFechaOrden(LocalDateTime fecFechaOrden) {
		this.fecFechaOrden = fecFechaOrden;
	}
	public int getIduBodegaCodigo() {
		return iduBodegaCodigo;
	}
	public void setIduBodegaCodigo(int iduBodegaCodigo) {
		this.iduBodegaCodigo = iduBodegaCodigo;
	}
	public boolean isFlagPromocion() {
		return flagPromocion;
	}
	public void setFlagPromocion(boolean flagPromocion) {
		this.flagPromocion = flagPromocion;
	}
	public double getImpPrecioContadoUnitario() {
		return impPrecioContadoUnitario;
	}
	public void setImpPrecioContadoUnitario(double impPrecioContadoUnitario) {
		this.impPrecioContadoUnitario = impPrecioContadoUnitario;
	}
	public double getImpDescuentoPromocion() {
		return impDescuentoPromocion;
	}
	public void setImpDescuentoPromocion(double impDescuentoPromocion) {
		this.impDescuentoPromocion = impDescuentoPromocion;
	}
	public double getImpTotalOrden() {
		return impTotalOrden;
	}
	public void setImpTotalOrden(double impTotalOrden) {
		this.impTotalOrden = impTotalOrden;
	}
	public int getTotalProdsOrden() {
		return totalProdsOrden;
	}
	public void setTotalProdsOrden(int totalProdsOrden) {
		this.totalProdsOrden = totalProdsOrden;
	}
	public String getDesAgrupadas() {
		return desAgrupadas;
	}
	public void setDesAgrupadas(String desAgrupadas) {
		this.desAgrupadas = desAgrupadas;
	}

    // Getters y Setters
    
}


