package com.fuctura.biblioteca.profiles;


import com.fuctura.biblioteca.services.DbServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevProfiles {

    @Autowired
    private DbServices dbServices;


    /*o @Value serve para a gente pegar o valor da string (na classe onde a variavel está localizada) e não atribuindo
     um valor direto a ela */
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddl;

    @Bean
    public boolean instanciaDB(){
    if (ddl.equals("create-drop")){
        this.dbServices.instanciaDB();
    }
        return false;
    }

}
