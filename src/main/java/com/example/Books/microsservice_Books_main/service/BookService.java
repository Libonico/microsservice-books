package com.example.Books.microsservice_Books_main.service;

import com.example.Books.microsservice_Books_main.entity.Book;
import com.example.Books.microsservice_Books_main.enums.ContentRatingEnum;
import com.example.Books.microsservice_Books_main.exception.ResourceNotFoundException;
import com.example.Books.microsservice_Books_main.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class BookService {

    public final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(BookService.class.getName()); //cria o logger

    @Autowired
    private BookRepository bookRepository;

    private static String UPLOAD_DIR = "uploads/";

    //função para registro de livros
    public Book register(Book book) {
        logger.info("Book registred."); //logger para fins de confirmação através do console
        return bookRepository.save(book);
    }

    //função para edição de livros
    public Book edit(Book book) {
        logger.info("The informations has been edited."); //logger para fins de confirmação através do console
        Book entity = bookRepository.findById(book.getId()).
                orElseThrow(() -> new ResourceNotFoundException("Book not found!"));

        entity.setAuthor(book.getAuthor());
        entity.setTitle(book.getTitle());
        entity.setPublishedYear(book.getPublishedYear());
        entity.setGender(book.getGender());

        return bookRepository.save(book);
    }

    //função para remoção de livros do sistema
    public void remove(Long id) {
        logger.info("Book removed."); //logger para fins de confirmação através do console
        Book entity = bookRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Book not found!"));

        bookRepository.delete(entity);
    }

    //função de localização do livro pelo id
    public Book findBookById(Long id) {
        logger.info("Book found."); //logger para fins de confirmação através do console
        return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found!"));
    }

    //função de localização de todos os livros cadastrados
    public List<Book> listAllBooks() {
        logger.info("Books found."); //logger para fins de confirmação através do console
        return bookRepository.findAll();
    }

    //função de localização de todos os livros filtrados por classificação indicativa ou por título
    public List<Book> listBooksByContentRatingOrTitle(String contentRating, String title) {
        logger.info("Books found."); //logger para fins de confirmação através do console
        if (contentRating != null && !contentRating.isEmpty()) {
            ContentRatingEnum contentRatingEnum = ContentRatingEnum.valueOf(contentRating.toUpperCase());
            return bookRepository.findBooksByContentRating(contentRatingEnum);
        }
        if (title != null && !title.trim().isEmpty()) {
            return bookRepository.findBooksByTitleContainingIgnoreCase(title);
        }
        return bookRepository.findAll();
    }

    public Book saveBookImage(Long id, MultipartFile file) throws IOException {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found!"));

        // garante que o diretório de uploads exista
        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // gera um nome de arquivo único para evitar conflitos
        String originalFileName = file.getOriginalFilename();
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
        String uniqueFileName = UUID.randomUUID().toString() + extension;

        Path path = uploadPath.resolve(uniqueFileName);
        Files.copy(file.getInputStream(), path);

        book.setImagePath(path.toString());

        Book updatedBook = bookRepository.save(book);

        return bookRepository.save(book);
    }
}
