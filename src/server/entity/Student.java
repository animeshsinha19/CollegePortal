package server.entity;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "Student")
public class Student {

    @Column(name = "studentid")
    private long studentId;
}
