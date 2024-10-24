package java15.dao;

import java15.entity.Student;

public interface StudentDao {
    String addStudent(Student student);
    String assignStudentByCourseId(Long studentId, Long courseId);
}
