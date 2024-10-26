package java15.service.impl;

import java15.dao.StudentDao;
import java15.dao.impl.StudentDaoImpl;
import java15.entity.Student;
import java15.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    StudentDao studentDao = new StudentDaoImpl();


    @Override
    public String addStudent(Student student) {
        return studentDao.addStudent(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentDao.getStudentById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    @Override
    public String updateStudentById(Long id, Student student) {
        return studentDao.updateStudentById(id, student);
    }

    @Override
    public String deleteStudentById(Long id) {
        return studentDao.deleteStudentById(id);
    }

    @Override
    public String assignStudentByCourseId(Long studentId, Long CourseId) {
        return studentDao.assignStudentByCourseId(studentId, CourseId);
    }
}
