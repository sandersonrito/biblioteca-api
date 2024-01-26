package com.fuctura.biblioteca.controllers;

import com.fuctura.biblioteca.dtos.LivroDto;
import com.fuctura.biblioteca.model.Livro;
import com.fuctura.biblioteca.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/{id}")
    public ResponseEntity<LivroDto> findById(@PathVariable Integer id) {
        Livro livro = livroService.findById(id);
        return ResponseEntity.ok().body(new LivroDto(livro));
    }

    @GetMapping
    public ResponseEntity<List<LivroDto>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Integer id) {
        List<Livro> list = livroService.findAll(id);
        return ResponseEntity.ok().body(list.stream().map(obj -> new LivroDto(obj)).collect(Collectors.toList()));
        //localhost:8081/livro?categoria=1
    }

    @GetMapping("categoria/{nome}")
    public ResponseEntity<List<LivroDto>> findAllByNome(@PathVariable String nome) {
        List<Livro> list = livroService.findAllLivroByCategoriaName(nome);
        return ResponseEntity.ok().body(list.stream().map(obj -> new LivroDto(obj)).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<LivroDto> save(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat,
                                         @Valid @RequestBody LivroDto livroDTO) {
        Livro livro = livroService.save(id_cat, livroDTO);
        return ResponseEntity.ok().body(new LivroDto(livro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroDto>upDate(@PathVariable Integer id, @RequestBody LivroDto livroDTO) {
        Livro livro = livroService.upDate(id, livroDTO);
        return ResponseEntity.ok().body(new LivroDto(livro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        livroService.delete(id);
        return ResponseEntity.noContent().build();
    }




}
