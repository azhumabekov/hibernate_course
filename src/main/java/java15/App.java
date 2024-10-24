package java15;

import java15.config.DatabaseConnection;
import java15.entity.Course;
import java15.entity.Student;
import java15.service.CourseService;
import java15.service.StudentService;
import java15.service.serviceImpl.CourseServiceImpl;
import java15.service.serviceImpl.StudentServiceImpl;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        // TODO
        //   OneToOne
        //   OneToMany
        //   ManyToOne
        //   ManyToMany
//        DatabaseConnection.getSessionFactory();

        CourseService courseService = new CourseServiceImpl();
//        courseService.saveCourse(new Course("java15", 14000, LocalDate.of(2024, 6,26)));

        StudentService studentService = new StudentServiceImpl();

        studentService.addStudent(new Student("Adilet", "adilet05@gmail.com", 2005));
    }



}
