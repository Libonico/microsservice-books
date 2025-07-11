package com.example.Books.microsservice_Books_main.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 1. USA EXATAMENTE A MESMA LÓGICA DO SERVICE para encontrar a pasta
        Path uploadDir = Paths.get(System.getProperty("user.home"), "app-livros-uploads", "images");
        String uploadPath = uploadDir.toFile().getAbsolutePath();

        registry
                // 2. O caminho público que o Angular vai chamar na URL
                .addResourceHandler("/images/**")

                // 3. O caminho físico onde as imagens realmente estão
                .addResourceLocations("file:/" + uploadPath + "/");
    }
}
