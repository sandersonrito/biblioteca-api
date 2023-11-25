package com.fuctura.biblioteca.controllers;

import com.fuctura.biblioteca.model.Categoria;
import com.fuctura.biblioteca.repositories.CategoriaRepository;
import com.fuctura.biblioteca.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//usado para comunicar com o corpo
@RestController

//end point para comiunicar com o front end
@RequestMapping("/categoria")
public class CategoriaController {

//   @GetMapping("/{id}") = buscar por id
//   @GetMapping() = buscar todos
//   @PostMapping(obj) = inserir no banco
//   @PutMapping(obj) = atualizar no banco
//   @DeleteMapping(id) = deletar obj

   @Autowired
   private CategoriaService categoriaService;

//   @GetMapping("/{id}") ambos os modelos retorna a mesma coisa, o ID
   @GetMapping(value = "/{id}")
   public Categoria findById(@PathVariable Integer id){
      Categoria cat = categoriaService.findById(id);
      return cat;
   }

   @GetMapping
   public List<Categoria> findAll(){

      return categoriaService.findAll();
   }

   @PostMapping
   public Categoria save(@RequestBody Categoria obj){
      return categoriaService.save(obj);
   }

}
