    package com.example.Books.microsservice_Books_main.entity;

    import jakarta.persistence.*;

    import java.io.Serializable;
    import java.util.Objects;

    @Entity
    @Table(name = "tb_books")
    public class Book implements Serializable {
        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        private String titulo;
        private String autor;
        private int anoPublicado;
        private String genero;

        public Book() {}

        public Book(long id, String titulo, String autor, int ano, String genero) {
            super();
            this.id = id;
            this.titulo = titulo;
            this.autor = autor;
            this.anoPublicado = ano;
            this.genero = genero;
        }

        public Book(String titulo, String autor, int ano) {
            this.titulo = titulo;
            this.autor = autor;
            this.anoPublicado = ano;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getAutor() {
            return autor;
        }

        public void setAutor(String autor) {
            this.autor = autor;
        }

        public int getAnoPublicado() {
            return anoPublicado;
        }

        public void setAnoPublicado(int anoPublicado) {this.anoPublicado = anoPublicado;}

        public String getGenero() {return genero;}

        public void setGenero(String genero) {this.genero = genero;}

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Book book)) return false;
            return getId() == book.getId() && getAnoPublicado() == book.getAnoPublicado() && Objects.equals(getTitulo(), book.getTitulo()) && Objects.equals(getAutor(), book.getAutor()) && Objects.equals(getGenero(), book.getGenero());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getTitulo(), getAutor(), getAnoPublicado(), getGenero());
        }
    }