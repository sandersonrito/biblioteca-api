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
