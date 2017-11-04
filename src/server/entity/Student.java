package server.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Table;

@Table(name = "Student")
public class Student extends Person {

    @Column(name = "STUDENTID")
    private long studentId;

    @Embedded
    private Course[] courses;

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public Course[] getCourses() {
        return courses;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }
}
