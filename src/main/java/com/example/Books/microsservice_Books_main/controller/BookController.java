package com.example.Books.microsservice_Books_main.controller;

import com.example.Books.microsservice_Books_main.entity.Book;
import com.example.Books.microsservice_Books_main.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;

import java.util.List;

@RestController
//define o prefixo "book" na url
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService service;
    @Autowired
    private BookService bookService;

    //retorna o registro de um livro em sistema
    //localhost:8888/registrer
    @PostMapping(value = "/register")
    public ResponseEntity<Book> register(@RequestBody Book book) {
        Book registredBook = bookService.register(book);

        URI url = URI.create("/book/" + registredBook.getId());

        return ResponseEntity.created(url).body(registredBook);
    }

    //retorna o livro editado
    //localhost:8888/edit
    @PutMapping(value = "/edit")
    public ResponseEntity<Book> edit(@RequestBody Book book) {
        return ResponseEntity.ok(service.edit(book));
    }

    //faz a remoção do livro do sistema
    //localhost:8888/books/remove/{id}
    @DeleteMapping(value = "/remove/{id}")
    public ResponseEntity<?> remove(@PathVariable("id") Long id) {
        service.remove(id);
        return ResponseEntity.noContent().build();
    }

    //retorna o livro pelo id localizado
    //localhost:8888/books/{id}
    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findBookById(id));
    }

    //retorna os todos os livros cadastrados em sistema
    //localhost:8888/books/all_books
    @GetMapping(value ="/all_books")
    public List<Book> listAllBooks() {
        return service.listAllBooks();
    }

    //retorna os todos os livros filtrados por classificação indicativa
    @GetMapping
    public List<Book> listBooksByContentRating(@RequestParam(required = false) String contentRating) {
        return service.listBooksByContentRating(contentRating);
    }

    //retorna os todos os livros filtrados por título
    @GetMapping
    public List<Book> listBooksByTitleContainingIgnoreCase(@RequestParam(required = false) String title) {
        return service.listBooksByTitleContainingIgnoreCase(title);
    }
}
