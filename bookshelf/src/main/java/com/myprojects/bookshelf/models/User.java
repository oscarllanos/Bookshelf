package com.myprojects.bookshelf.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "users")
@ToString @EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;

    @Getter @Setter @Column(name = "Nombre")
    private String nombre;

    @Getter @Setter @Column(name = "Apellido")
    private String apellido;

    @Getter @Setter @Column(name = "Email")
    private String email;

    @Getter @Setter @Column(name = "Password")
    private String password;

}
