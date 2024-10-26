package java15.dao;

import java15.entity.Student;

import java.util.List;

public interface StudentDao {
    // todo CRUD
    // Create
    String addStudent(Student student);

    // Read
    Student getStudentById(Long id);

    List<Student> getAllStudents();

    // Update
    String updateStudentById(Long id, Student student);

    // Delete
    String deleteStudentById(Long id);

    String assignStudentByCourseId(Long studentId, Long CourseId);
}
