package com.once.facturas.controller;

import com.once.facturas.model.Producto;
import com.once.facturas.model.Repositoryproducto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * MainController- ProductosController
 * 
 */

// etiqueta para crear un controller
 
@Controller
public class ProductosController {

   
 // creamos el endpoint /producto - vamos a introducir datos  de nuevos productos  
    
     // primero llamamos al repositorio    
     @Autowired
     Repositoryproducto repositoryProducto;     

     @GetMapping("/producto")
     @ResponseBody
     public ModelAndView creaProducto() {
 
         ModelAndView modelAndView=new ModelAndView("producto");
         modelAndView.addObject("mensaje", "");
         return modelAndView;
     }
 
     @PostMapping("/producto")
     public ModelAndView clientePost(
         @RequestParam("descripcion") String descripcion,
         @RequestParam("fabricante") String fabricante,
         @RequestParam("precio") Float precio
     ){
         ModelAndView modelAndView=new ModelAndView("producto");
         Producto producto=new Producto(descripcion, fabricante, precio);
         /*cliente.setNombre(nombre);
         cliente.setApellido(apellido);
         cliente.setEdad(edad);*/
         repositoryProducto.save(producto);
         
         return modelAndView;
     }


    
     // creamos el endpoint /contar - vamos a contar el numero de productos que tenemos

     

     @GetMapping("/count")
     @ResponseBody
     public String countProducto() {

       return "Tengo " + String.valueOf(repositoryProducto.count()) + " productos " ;

     }

}   
