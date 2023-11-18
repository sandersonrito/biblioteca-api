package com.fuctura.biblioteca.repositories;

import com.fuctura.biblioteca.model.Categoria;
import com.fuctura.biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// após criar uma interface e fizer o extends da JpaRepository, é necessário criar 2 parametros,
// onde esses parametros so aceita apenas as CLASSES. sendo a primeira a primeira classe e a segunda o tipo do ID
// por isso não aceita int apenas a classe Integer.
@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {
}
