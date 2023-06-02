package com.agrimensuramisiones;

import com.agrimensuramisiones.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AgrimensuramisionesApplication {

//    @Autowired
//    public UsuarioService usuarioService;
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(usuarioService).
//                passwordEncoder(new BCryptPasswordEncoder());
//    }
    
    public static void main(String[] args) {
            SpringApplication.run(AgrimensuramisionesApplication.class, args);
    }

}
