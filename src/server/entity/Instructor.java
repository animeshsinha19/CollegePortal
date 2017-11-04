package server.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Table;

@Table(name = "Instructor")
public class Instructor extends Person {

    @Column(name = "INSTRUCTORID")
    private long instructorId;

    @Embedded
    private Department department;

    @Embedded
    private Course[] courses;

    public long getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(long instructorId) {
        this.instructorId = instructorId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Course[] getCourses() {
        return courses;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }
}
