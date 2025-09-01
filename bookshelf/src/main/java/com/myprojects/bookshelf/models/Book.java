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

    @Getter @Setter @Column(name = "title")
    private String title;

    @Getter @Setter @Column(name = "author")
    private String author;

    @Getter @Setter @Column(name = "description")
    private String description;

    @Getter @Setter @Column(name = "read")
    private String read;

    @Getter @Setter @Column(name = "inbookshelf")
    private String inBookshelf;

}
