package server.entity;

import javax.persistence.*;

@Entity
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "emailpersonal")
    private String emailPersonal;

    @Column(name = "emailuniversity")
    private String emailUniversity;
}
