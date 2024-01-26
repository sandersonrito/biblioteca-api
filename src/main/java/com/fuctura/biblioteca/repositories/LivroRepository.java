package com.fuctura.biblioteca.repositories;


import com.fuctura.biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// após criar uma interface e fizer o extends da JpaRepository, é necessário criar 2 parametros,
// onde esses parametros so aceita apenas as CLASSES. sendo a primeira a primeira classe e a segunda o tipo do ID
// por isso não aceita int apenas a classe Integer.
@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

    @Query(value = "SELECT obj FROM Livro obj WHERE obj.categoria.id =:id_cat")
    List<Livro> findAllByCategoria(@Param(value = "id_cat") Integer id_cat);

    List<Livro> findByCategoriaNomeContainingIgnoreCase(String nome);
}
