package com.ms.codify;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.slf4j.Slf4j;

/**
 * Inicializacion del Spring Boot
 *
 * @author Jesus Garcia
 * @since 1.0
 * @version jdk-11
 */
@Slf4j
@SpringBootApplication
@ComponentScan("com.ms.codify.*")
public class CodifyApplication {
	
	@Value("${api.config.codify.uri}")
	private String urlServicio = "";
	
    public static void main(String[] args){
        SpringApplication.run(CodifyApplication.class,args);
    }
    
    @Bean
	public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
		log.info("webServerFactoryCustomizer[]::inicia servicio web de cliente");
		return factory -> factory.setContextPath(this.urlServicio);
	}
    
}