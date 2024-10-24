package java15.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java15.config.DatabaseConnection;
import java15.dao.CourseDao;
import java15.entity.Course;

public class CourseDaoImpl implements CourseDao, AutoCloseable {
    EntityManagerFactory entityManagerFactory = DatabaseConnection.getSessionFactory();

    @Override
    public String saveCourse(Course course) {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(course);
            entityManager.getTransaction().commit();
            return " Successfully saved the course.";
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }


    public int countOfStudentByCourseId(String courseId) {
        EntityManager entityManager = null;
        try {
        entityManager.getTransaction().begin();
        Long count = entityManager.createQuery(
                "select count(s.id) from Student s inner join s.courses sc where sc.id = :courseId",  Long.class)
                .setParameter("courseId", courseId)
                .getSingleResult();
        entityManager.getTransaction().commit();
        return count.intValue();
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
            return 0;
        }

//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.createQuery("select count(s.id) from Student s inner join s.courses sc" +
//                " where sc.id = :courseId", Long.class).setParameter("courseId", courseId).getSingleResult();
//        entityManager.getTransaction().commit();
//        entityManager.close();
//        return 1;

    }

    @Override
    public Course findById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, id);
        entityManager.getTransaction().commit();
        return course;

    }

    @Override
    public Course getCourseById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.find(Course.class, id);
        entityManager.getTransaction().commit();
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

    @Override
    public void close() throws Exception {
        entityManagerFactory.close();
    }

//    @Override
//    public List<Course> getAllCourses() {
//        return List.of();
//    }
}
