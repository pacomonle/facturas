package com.once.facturas.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * 
 * Creamos el repositorio Repositoryproducto
 * 
 */

// etiqueta para crear un Repositoryrun
@Repository
public interface Repositoryproducto extends CrudRepository <Producto, Long> {

 //   Iterable<Producto> findByName(String name);
 //   repositoryProducto.findAll();

 // public Iterable<Producto> getAllbyDescripcionLikeIterable(String ){  }

// PagingAndRepository.class <T, Id>


}

