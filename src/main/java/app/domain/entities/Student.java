package app.domain.entities;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Student")
public class Student extends Person {

    private double averageGrade;
    private Set<Course> attendance;

    public Student() {
    }

    @Column(name = "average_grade")
    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "students_courses",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"))
    public Set<Course> getAttendance() {
        return attendance;
    }

    public void setAttendance(Set<Course> attendance) {
        this.attendance = attendance;
    }
}
