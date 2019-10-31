package app;

import app.domain.entities.Course;
import app.domain.entities.Student;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Engine implements Runnable {

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private final EntityManager entityManager;

    @Override
    public void run() {

        this.entityManager.getTransaction().begin();
        Student student = new Student();
        student.setFirstName("Pesho");
        Course course = new Course();
        course.setName("Java");

//        this.entityManager.persist(student);
//        this.entityManager.persist(course);

        List<Student> students = this.entityManager.createQuery("FROM Student", Student.class)
                .getResultList();

        for(Student st : students){
            System.out.println(st.getFirstName());
            Set<Course> courses = st.getAttendance();
            for(Course cr : courses){
                System.out.println(cr.getName());
            }
            System.out.println("======================");
        }
    }
}
