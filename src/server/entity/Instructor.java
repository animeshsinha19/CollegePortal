package server.entity;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "Instructor")
public class Instructor extends Person {

    @Column(name = "INSTRUCTORID")
    private long instructorId;

    public long getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(long instructorId) {
        this.instructorId = instructorId;
    }


}
