package com.example.Books.microsservice_Books_main.config;

import com.example.Books.microsservice_Books_main.entity.Book;
import com.example.Books.microsservice_Books_main.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.logging.Logger;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private BookService bookService;

    @Override
    public void run(String... args) throws Exception {
        // Se o banco (livros) estiver vazio
        if (bookService.listAllBooks().isEmpty()) {
            populateBooks();
        }
    }

    // Cria os livros e os adiciona
    private void populateBooks() throws Exception {
        /* GÊNEROS
           ROMANCE
           TERROR
           FANTASIA
           DRAMA
           MISTÉRIO
           SUSPENSE
         */

        // Livro 1
        Book book1 = new Book();
        book1.setTitle("Duna");
        book1.setAuthor("Frank Herbert");
        book1.setPublishedYear(1965);
        book1.setGender("Fantasia");
        book1.setPagesQuantity("680");
        MultipartFile file1 = createMultipartFile("seed-images/d.jpg", "image/jpeg");
        bookService.registerWithImage(book1, "QUATORZE", file1);

        // Livro 2
        Book book2 = new Book();
        book2.setTitle("O Iluminado");
        book2.setAuthor("Stephen King");
        book2.setPublishedYear(1977);
        book2.setGender("Terror");
        book2.setPagesQuantity("497");
        MultipartFile file2 = createMultipartFile("seed-images/oi.jpg", "image/jpeg");
        bookService.registerWithImage(book2, "DEZESSEIS", file2);

        // Livro 3
        Book book3 = new Book();
        book3.setTitle("1984");
        book3.setAuthor("George Orwell");
        book3.setPublishedYear(1949);
        book3.setGender("Drama");
        book3.setPagesQuantity("416");
        MultipartFile file3 = createMultipartFile("seed-images/1984.jpg", "image/jpeg");
        bookService.registerWithImage(book3, "DEZESSEIS", file3);

        Book book4 = new Book();
        book4.setTitle("Harry Potter e a Pedra Filosofal");
        book4.setAuthor("J.K. Rowling");
        book4.setPublishedYear(2001);
        book4.setGender("Fantasia");
        book4.setPagesQuantity("317");
        MultipartFile file4 = createMultipartFile("seed-images/hp.jpg", "image/jpeg");
        bookService.registerWithImage(book4, "LIVRE", file4);

        // Livro 5
        Book book5 = new Book();
        book5.setTitle("Frankenstein");
        book5.setAuthor("Mary Shelley");
        book5.setPublishedYear(1818);
        book5.setGender("Terror");
        book5.setPagesQuantity("280");
        MultipartFile file5 = createMultipartFile("seed-images/frankenstein.jpg", "image/jpeg");
        bookService.registerWithImage(book5, "QUATORZE", file5);

        // Livro 6
        Book book6 = new Book();
        book6.setTitle("Orgulho e Preconceito");
        book6.setAuthor("Jane Austen");
        book6.setPublishedYear(1813);
        book6.setGender("Romance");
        book6.setPagesQuantity("432");
        MultipartFile file6 = createMultipartFile("seed-images/orgulho.jpg", "image/jpeg");
        bookService.registerWithImage(book6, "LIVRE", file6);

        // Livro 7
        Book book7 = new Book();
        book7.setTitle("O Morro dos Ventos Uivantes");
        book7.setAuthor("Emily Brontë");
        book7.setPublishedYear(1847);
        book7.setGender("Romance");
        book7.setPagesQuantity("416");
        MultipartFile file7 = createMultipartFile("seed-images/morro.jpg", "image/jpeg");
        bookService.registerWithImage(book7, "DEZESSEIS", file7);

        // Livro 8
        Book book8 = new Book();
        book8.setTitle("A Garota no Trem");
        book8.setAuthor("Paula Hawkins");
        book8.setPublishedYear(2015);
        book8.setGender("Suspense");
        book8.setPagesQuantity("378");
        MultipartFile file8 = createMultipartFile("seed-images/garotatrem.jpg", "image/jpeg");
        bookService.registerWithImage(book8, "DEZESSEIS", file8);

        // Livro 9
        Book book9 = new Book();
        book9.setTitle("O Silêncio dos Inocentes");
        book9.setAuthor("Thomas Harris");
        book9.setPublishedYear(1988);
        book9.setGender("Suspense");
        book9.setPagesQuantity("368");
        MultipartFile file9 = createMultipartFile("seed-images/silencio.jpg", "image/jpeg");
        bookService.registerWithImage(book9, "DEZOITO", file9);

        // Livro 10
        Book book10 = new Book();
        book10.setTitle("Assassinato no Expresso do Oriente");
        book10.setAuthor("Agatha Christie");
        book10.setPublishedYear(1934);
        book10.setGender("Mistério");
        book10.setPagesQuantity("256");
        MultipartFile file10 = createMultipartFile("seed-images/expresso.jpg", "image/jpeg");
        bookService.registerWithImage(book10, "DOZE", file10);

        // Livro 11
        Book book11 = new Book();
        book11.setTitle("A Sombra do Vento");
        book11.setAuthor("Carlos Ruiz Zafón");
        book11.setPublishedYear(2001);
        book11.setGender("Mistério");
        book11.setPagesQuantity("448");
        MultipartFile file11 = createMultipartFile("seed-images/sombravento.jpg", "image/jpeg");
        bookService.registerWithImage(book11, "QUATORZE", file11);

        // Livro 12
        Book book12 = new Book();
        book12.setTitle("O Hobbit");
        book12.setAuthor("J.R.R. Tolkien");
        book12.setPublishedYear(1937);
        book12.setGender("Fantasia");
        book12.setPagesQuantity("310");
        MultipartFile file12 = createMultipartFile("seed-images/hobbit.jpg", "image/jpeg");
        bookService.registerWithImage(book12, "LIVRE", file12);

        // Livro 13
        Book book13 = new Book();
        book13.setTitle("It: A Coisa");
        book13.setAuthor("Stephen King");
        book13.setPublishedYear(1986);
        book13.setGender("Terror");
        book13.setPagesQuantity("1104");
        MultipartFile file13 = createMultipartFile("seed-images/it.jpg", "image/jpeg");
        bookService.registerWithImage(book13, "DEZOITO", file13);

        // Livro 14
        Book book14 = new Book();
        book14.setTitle("Psicose");
        book14.setAuthor("Robert Bloch");
        book14.setPublishedYear(1959);
        book14.setGender("Suspense");
        book14.setPagesQuantity("208");
        MultipartFile file14 = createMultipartFile("seed-images/psicose.jpg", "image/jpeg");
        bookService.registerWithImage(book14, "DEZESSEIS", file14);

        // Livro 15
        Book book15 = new Book();
        book15.setTitle("A Paciente Silenciosa");
        book15.setAuthor("Alex Michaelides");
        book15.setPublishedYear(2019);
        book15.setGender("Suspense");
        book15.setPagesQuantity("352");
        MultipartFile file15 = createMultipartFile("seed-images/aps.jpg", "image/jpeg");
        bookService.registerWithImage(book15, "DEZESSEIS", file15);

        // Livro 16
        Book book16 = new Book();
        book16.setTitle("O Nome do Vento");
        book16.setAuthor("Patrick Rothfuss");
        book16.setPublishedYear(2007);
        book16.setGender("Fantasia");
        book16.setPagesQuantity("656");
        MultipartFile file16 = createMultipartFile("seed-images/nomevento.jpg", "image/jpeg");
        bookService.registerWithImage(book16, "DEZESSEIS", file16);

        // Livro 17
        Book book17 = new Book();
        book17.setTitle("A Menina que Roubava Livros");
        book17.setAuthor("Markus Zusak");
        book17.setPublishedYear(2005);
        book17.setGender("Drama");
        book17.setPagesQuantity("480");
        MultipartFile file17 = createMultipartFile("seed-images/meninarl.jpg", "image/jpeg");
        bookService.registerWithImage(book17, "DOZE", file17);

        // Livro 18
        Book book18 = new Book();
        book18.setTitle("O Conto da Aia");
        book18.setAuthor("Margaret Atwood");
        book18.setPublishedYear(1985);
        book18.setGender("Drama");
        book18.setPagesQuantity("368");
        MultipartFile file18 = createMultipartFile("seed-images/contodaia.jpg", "image/jpeg");
        bookService.registerWithImage(book18, "DEZESSEIS", file18);

        // Livro 19
        Book book19 = new Book();
        book19.setTitle("E Não Sobrou Nenhum");
        book19.setAuthor("Agatha Christie");
        book19.setPublishedYear(1939);
        book19.setGender("Mistério");
        book19.setPagesQuantity("272");
        MultipartFile file19 = createMultipartFile("seed-images/naosobrou.jpg", "image/jpeg");
        bookService.registerWithImage(book19, "DOZE", file19);

        // Livro 20
        Book book20 = new Book();
        book20.setTitle("Drácula");
        book20.setAuthor("Bram Stoker");
        book20.setPublishedYear(1897);
        book20.setGender("Terror");
        book20.setPagesQuantity("448");
        MultipartFile file20 = createMultipartFile("seed-images/dracula.jpg", "image/jpeg");
        bookService.registerWithImage(book20, "QUATORZE", file20);

        // Livro 21
        Book book21 = new Book();
        book21.setTitle("O Apanhador no Campo de Centeio");
        book21.setAuthor("J.D. Salinger");
        book21.setPublishedYear(1951);
        book21.setGender("Drama");
        book21.setPagesQuantity("224");
        MultipartFile file21 = createMultipartFile("seed-images/apanhador.jpg", "image/jpeg");
        bookService.registerWithImage(book21, "DEZESSEIS", file21);

        // Livro 22
        Book book22 = new Book();
        book22.setTitle("Dom Casmurro");
        book22.setAuthor("Machado de Assis");
        book22.setPublishedYear(1899);
        book22.setGender("Romance");
        book22.setPagesQuantity("256");
        MultipartFile file22 = createMultipartFile("seed-images/casmurro.jpg", "image/jpeg");
        bookService.registerWithImage(book22, "QUATORZE", file22);

        // Livro 23
        Book book23 = new Book();
        book23.setTitle("O Guia do Mochileiro das Galáxias");
        book23.setAuthor("Douglas Adams");
        book23.setPublishedYear(1979);
        book23.setGender("Fantasia");
        book23.setPagesQuantity("208");
        MultipartFile file23 = createMultipartFile("seed-images/guia.jpg", "image/jpeg");
        bookService.registerWithImage(book23, "DOZE", file23);

        // Livro 24
        Book book24 = new Book();
        book24.setTitle("A Batalha do Apocalipse");
        book24.setAuthor("Eduardo Spohr");
        book24.setPublishedYear(2007);
        book24.setGender("Fantasia");
        book24.setPagesQuantity("586");
        MultipartFile file24 = createMultipartFile("seed-images/batalha.jpg", "image/jpeg");
        bookService.registerWithImage(book24, "QUATORZE", file24);
    }

    // Simula um upload de arquivo (para adicionar a imagem do livro)
    private MultipartFile createMultipartFile(String resourcePath, String contentType) throws Exception {
        // Localiza o arquivo dentro de resources
        ClassPathResource resource = new ClassPathResource(resourcePath);
        try (InputStream inputStream = resource.getInputStream()) {
            return new MockMultipartFile(
                    resource.getFilename(),
                    resource.getFilename(),
                    contentType,
                    // Lê o arquivo completo
                    inputStream.readAllBytes()
            );
        }
    }
}
