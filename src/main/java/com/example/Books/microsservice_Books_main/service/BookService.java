package com.example.Books.microsservice_Books_main.service;

import com.example.Books.microsservice_Books_main.entity.Book;
import com.example.Books.microsservice_Books_main.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class BookService {

    public final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(BookService.class.getName());

    @Autowired
    private BookRepository bookRepository;

    public List<Book> listarTodos() {
        logger.info("Todos os livros encontrados.");
        return bookRepository.findAll();
    }

    public Book cadastrar(Book book) {
        logger.info("Livro criado.");
        return bookRepository.save(book);
    }

    public Book editar(Book book) {
        logger.info("Informações editadas.");
        return bookRepository.save(book);
    }

    public void remover(String id) {
        logger.info("Removendo livros.");
        bookRepository.deleteById(Long.parseLong(id));
    }

    public Book buscaPorId(String id){
        logger.info("Livro encontrado.");
        return bookRepository.findById(Long.parseLong(id)).orElse(null);
    }
}
