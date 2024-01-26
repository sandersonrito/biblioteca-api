package com.fuctura.biblioteca.services;

import com.fuctura.biblioteca.dtos.LivroDto;
import com.fuctura.biblioteca.exceptions.ObjectNotFoundException;
import com.fuctura.biblioteca.model.Categoria;
import com.fuctura.biblioteca.model.Livro;
import com.fuctura.biblioteca.repositories.LivroRepository;
import com.fuctura.biblioteca.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoriaService categoriaService;

    public Livro findById (Integer id){
        Optional<Livro> liv = livroRepository.findById(id);

        if(liv.isPresent()){
            return liv.get();
        }
        throw new ObjectNotFoundException("Livro não encontrada!");
    }

    public List<Livro> findAll(Integer id_cat){
        livroRepository.findAll();
        return livroRepository.findAllByCategoria(id_cat);

    }

    public List<Livro> findAllLivroByCategoriaName(String nome) {
        categoriaService.buscarPorNome(nome);
        return livroRepository.findByCategoriaNomeContainingIgnoreCase(nome);
    }

    public Livro save(Integer id_cat, LivroDto livroDTO) {
        livroDTO.setId(null);
        Categoria cat = categoriaService.findById(id_cat);
        livroDTO.setCategoria(cat);
        return livroRepository.save(new Livro(livroDTO));
    }

    public Livro upDate(Integer id, LivroDto livroDTO) {
        Livro livro = findById(id);
        livroDTO.setId(id);
        upDateDados(livro, livroDTO);
        return livroRepository.save(livro);
    }

    public void delete(Integer id) {
        findById(id);
        livroRepository.deleteById(id);
    }

    private void upDateDados(Livro livro, LivroDto livroDTO) {
        livro.setTitulo(livroDTO.getTitulo());
        livro.setNome_autor(livroDTO.getNome_autor());
        livro.setTexto(livroDTO.getTexto());
        livro.setTamanho(livroDTO.getTamanho());
        livro.setCategoria(livroDTO.getCategoria());
    }
}
