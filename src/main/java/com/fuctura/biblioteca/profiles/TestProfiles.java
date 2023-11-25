package com.fuctura.biblioteca.profiles;

import com.fuctura.biblioteca.services.DbServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


//toda classe que for de configuração deve apresentar @Configuration, e deve apresentar o @Profile("") onde apresentara no application.properties e application-test.properties
@Configuration
@Profile("test")
public class TestProfiles {

    @Autowired
    private DbServices dbServices;


    // para acessar o que está dentro do @Configuration é necessário o @Bean, que serve para ficar disponivel para executar os metodos.
    @Bean
    public void instanciaDB(){
        this.dbServices.instanciaDB();
    }
}
