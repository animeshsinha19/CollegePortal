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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailPersonal() {
        return emailPersonal;
    }

    public void setEmailPersonal(String emailPersonal) {
        this.emailPersonal = emailPersonal;
    }

    public String getEmailUniversity() {
        return emailUniversity;
    }

    public void setEmailUniversity(String emailUniversity) {
        this.emailUniversity = emailUniversity;
    }
}