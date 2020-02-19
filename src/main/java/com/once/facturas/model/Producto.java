package com.once.facturas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * 
 * Creamos la entidad Producto
 * 
 */

 // Para generar objeto o tabla en base de dato usamos la siguiente etiqueta 
@Entity
@Table(name="Producto")
public class Producto {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@Column(name = "DESCRIPCION", nullable = false)
	@Size(max = 200)
    private String descripcion;

    @Column(name = "FABRICANTE")
	@Size(max = 100)
    private String fabricante;
   
    @Column(name = "PRECIO")
    private Float precio;

// GENERAMOS GETTER AND SETTER
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

 
	
    // GENERAMOS CONSTRUCTOR

    public Producto( String descripcion, String fabricante, Float precio) {	
		this.descripcion = descripcion;
		this.fabricante = fabricante;
		this.precio = precio;
    }
    
    // constructor por defecto

    public Producto(){

    }

   
     
    // GENERAMOS toString

    @Override
    public String toString() {
        return "Producto [descripcion=" + descripcion + ", fabricante=" + fabricante + ", precio=" + precio + ", id=" + id + "]";
    }
    

    




    
}