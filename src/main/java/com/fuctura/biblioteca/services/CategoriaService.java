package com.fuctura.biblioteca.services;

import com.fuctura.biblioteca.model.Categoria;
import com.fuctura.biblioteca.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {


    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria findById(Integer id){
        Optional <Categoria> obj = categoriaRepository.findById(id);
    return obj.orElse(null);
    }

    public List<Categoria> findAll(){

        return categoriaRepository.findAll();

    }

    public Categoria save(Categoria obj){

        return categoriaRepository.save(obj);
    }
}
