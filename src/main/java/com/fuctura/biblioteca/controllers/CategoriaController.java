package com.fuctura.biblioteca.controllers;


import com.fuctura.biblioteca.dtos.CategoriaDto;
import com.fuctura.biblioteca.model.Categoria;
import com.fuctura.biblioteca.services.CategoriaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


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

   @Autowired
   private ModelMapper modelMapper;



   // o ResponseEntity personaliza o codigo de retorno da classe.
 //   @GetMapping("/{id}") ambos os modelos retorna a mesma coisa, o ID
   @GetMapping(value = "/{id}")
   public ResponseEntity<CategoriaDto> findById(@PathVariable Integer id){
      Categoria cat = categoriaService.findById(id);
      return ResponseEntity.ok().body(modelMapper.map(cat, CategoriaDto.class));
   }

   @GetMapping
   public ResponseEntity<List<CategoriaDto>> findAll(){
      List<Categoria> list = categoriaService.findAll();

      // sempre que eu quiser transformar uma lista em outra lista usar o stream().
      return ResponseEntity.ok().body(list.stream().map(obj -> modelMapper.map(obj, CategoriaDto.class)).
              collect(Collectors.toList()));

      // o return irá pegar cada objeto da lista categorias e vai transformar em uma lista de categoriasDto.
   }

   @PostMapping
   public ResponseEntity<CategoriaDto> save(@RequestBody CategoriaDto categoriaDto){
      Categoria cat = categoriaService.save(categoriaDto);
      return ResponseEntity.ok().body(modelMapper.map(cat, CategoriaDto.class));

   }

}
