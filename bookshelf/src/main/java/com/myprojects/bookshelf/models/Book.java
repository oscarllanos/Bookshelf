package com.myprojects.bookshelf.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "books")
@ToString @EqualsAndHashCode
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;

    @Getter @Setter @Column(name = "Título")
    private String title;

    @Getter @Setter @Column(name = "Autor")
    private String author;

    @Getter @Setter @Column(name = "Descripción")
    private String description;

    @Getter @Setter @Column(name = "leído")
    private String read;

    @Getter @Setter @Column(name = "En mi librero")
    private String inBookshelf;

    @Getter @Setter @Column(name = "usuario")
    private String userName;

}
