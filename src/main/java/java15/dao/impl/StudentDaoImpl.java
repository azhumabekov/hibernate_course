package java15.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java15.config.DatabaseConnection;
import java15.dao.StudentDao;
import java15.entity.Student;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    EntityManagerFactory entityManagerFactory = DatabaseConnection.getSessionFactory();

    @Override
    public String addStudent(Student student) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "success";
    }

    @Override
    public Student getStudentById(Long id) {
        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        return List.of();
    }

    @Override
    public String updateStudentById(Long id, Student student) {
        return "";
    }

    @Override
    public String deleteStudentById(Long id) {
    }

    @Override
    public String assignStudentByCourseId(Long studentId, Long courseId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, studentId);

        List courseId1 = entityManager.createQuery("select c from Course c where c.id = :courseId")
                .setParameter("courseId", courseId).getResultList();
//        if (!studentId.equals(studentId) && courseId1.equals(courseId) {
//            new RuntimeException("Student already assigned to course");
//        }
        student.setCourses(courseId1);

        entityManager.getTransaction().commit();
        entityManager.close();

        return "success";
    }








}
