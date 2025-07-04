package com.example.Books.microsservice_Books_main.controller;

import com.example.Books.microsservice_Books_main.entity.Book;
import com.example.Books.microsservice_Books_main.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService service;

    @RequestMapping(value = "/cadastrar",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Book cadastrar(@RequestBody Book book) {
        return service.cadastrar(book);
    }

    @RequestMapping(value = "/editar",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Book editar(@RequestBody Book book) {
        return service.editar(book);
    }

    @RequestMapping(value = "/remover/{id}", method = RequestMethod.DELETE)
    public void remover(@PathVariable("id") String id) {
        service.remover(id);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Book findById(@PathVariable("id") String id) {
        return service.buscaPorId(id);
    }

    @RequestMapping(value ="/listar_todos",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Book> listarTodos() {
        return service.listarTodos();
    }

}
