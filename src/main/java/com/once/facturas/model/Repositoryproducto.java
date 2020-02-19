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

}

