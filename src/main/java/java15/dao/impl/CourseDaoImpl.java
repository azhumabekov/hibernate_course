package java15.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java15.config.DatabaseConnection;
import java15.dao.CourseDao;
import java15.entity.Course;

import java.util.Collections;
import java.util.List;

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

    @Override
    public Long countOfStudentByCourseId(Long courseId) {
        EntityManager entityManager = null;
        try {
            entityManager.getTransaction().begin();
            Long count = entityManager.createQuery(
                            "select count(s.id) from Student s inner join s.courses sc where sc.id = :courseId",  Long.class)
                    .setParameter("courseId", courseId)
                    .getSingleResult();
            entityManager.getTransaction().commit();
            return count.longValue();
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
            return 0L;
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
    public List<Course> sortCourseToPrice(String ascOrDesc) {
        EntityManager entityManager = null;
        List<Course> courses = Collections.emptyList();
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            String sortOrder = ascOrDesc.equalsIgnoreCase("desc") ? "DESC" : "ASC";
            courses = entityManager.createQuery(
                            "SELECT c FROM Course c ORDER BY c.price " + sortOrder, Course.class)
                    .getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }

        return courses;
    }

    @Override
    public Course findById(Long id) {
            EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            Course course = entityManager.find(Course.class, id);
            return course;
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Course getCourseById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.find(Course.class, id);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
                System.out.println(e.getMessage());
            }
        }
        return null;

    }


    @Override
    public String updateCourse(Long id, Course newcourse) {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Course course = entityManager.find(Course.class, id);
            course.setName(newcourse.getName());
            course.setPrice(newcourse.getPrice());
            entityManager.merge(course);
            entityManager.getTransaction().commit();
            return " Successfully updated the course.";
        } catch (Exception e) {
            if (entityManager == null || entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
                System.out.println(e.getMessage());
            }
        }
        return " Failed to update the course.";
    }

    @Override
    public String deleteCourse(Long id) {
        return "";
    }

    @Override
    public List<Course> getAllCourses() {
        EntityManager entityManager = null;
        List<Course> courses = Collections.emptyList();
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            courses = entityManager.createQuery("SELECT c FROM Course c", Course.class).getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        return courses;
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
