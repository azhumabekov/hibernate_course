package java15.dao.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import java15.config.DatabaseConnection;
import java15.dao.CourseDao;
import java15.entity.Course;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;

import javax.xml.crypto.Data;
import java.util.List;

public class CourseDaoImpl implements CourseDao {
    EntityManagerFactory entityManagerFactory = DatabaseConnection.getSessionFactory();
    @Override
    public String saveCourse(Course course) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(course); entityManager.getTransaction().commit();
        entityManager.close();
        return " Successfully saved the course.";
    }

    
    public int countOfStudentByCourseId(String courseId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("select count(s.id) from Student s inner join s.courses sc" +
                " where sc.id = :courseId", Long.class).setParameter("courseId", courseId).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return 1;
        
    }
    @Override
    public Course getCourseById(Long id) {
        return null;
    }

    @Override
    public String updateCourse(Long id, Course newcourse) {
        return "";
    }

    @Override
    public String deleteCourse(Long id) {
        return "";
    }

//    @Override
//    public List<Course> getAllCourses() {
//        return List.of();
//    }
}
