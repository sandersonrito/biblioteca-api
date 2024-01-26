package com.fuctura.biblioteca.services;

import com.fuctura.biblioteca.dtos.CategoriaDto;
import com.fuctura.biblioteca.exceptions.IllegalArgumentException;
import com.fuctura.biblioteca.exceptions.ObjectNotFoundException;
import com.fuctura.biblioteca.model.Categoria;
import com.fuctura.biblioteca.repositories.CategoriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {


    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ModelMapper modelMapper;

    //metodo pesquisar por ID do crud, Onde nele alem de pesquisar esse metodo serve para saber se o objeto existe
    public Categoria findById(Integer id){
        Optional <Categoria> cat = categoriaRepository.findById(id);

        //usando o lambida para fazer tratamento da exceção.
        //return cat.orElseThrow(() -> new ObjectNotFoundExceptions("Categoria não encontrada!"));

        if (cat.isPresent()){
            return cat.get();
        }

        throw new ObjectNotFoundException("Categoria não encontrada!");
    }

    //metodo pesquisar todos do crud
    public List<Categoria> findAll(){

        return categoriaRepository.findAll();

    }

    //metodo salvar do crud
    public Categoria save(CategoriaDto objDTO){
        findByNome(objDTO);
        objDTO.setId(null);
        return categoriaRepository.save(modelMapper.map(objDTO, Categoria.class));
    }

    //metodo atualizar do crud
    public Categoria upDate(CategoriaDto categoriaDto) {
        findById(categoriaDto.getId());
        return categoriaRepository.save(modelMapper.map(categoriaDto, Categoria.class));
    }

    //metodo deletar do crud
    public void delete(Integer id){
        findById(id);
        Optional<Categoria> cat = categoriaRepository.findById(id);
        if (cat.get().getLivros().size()>0){
            throw new IllegalArgumentException("Categoria possui livros, não pode ser deletada!");
        }
        categoriaRepository.deleteById(id);
    }

    //metodo pesquisar por nome do crud
    private void findByNome(CategoriaDto categoriaDto) {
        Optional<Categoria> cat = categoriaRepository.findByNome(categoriaDto.getNome());
        if (cat.isPresent() && cat.get().getNome().equals(categoriaDto.getNome())){
            throw new IllegalArgumentException("Já existe uma categoria com este nome" + categoriaDto.getNome());
        }
    }

    public void buscarPorNome(String nome) {
        Optional<Categoria> cat = categoriaRepository.findByNomeContainingIgnoreCase(nome);
        if (cat.isEmpty()) {
            throw new ObjectNotFoundException("Categoria não encontrada!");
        }
    }
}
