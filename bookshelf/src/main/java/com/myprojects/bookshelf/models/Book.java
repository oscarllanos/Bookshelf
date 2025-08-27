package com.myprojects.bookshelf.models;

import lombok.Getter;
import lombok.Setter;

public class Book {

    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String title;

    @Getter @Setter
    private String author;

    @Getter @Setter
    private String description;

    @Getter @Setter
    private boolean read;

    @Getter @Setter
    private boolean inBookshelf;

}
