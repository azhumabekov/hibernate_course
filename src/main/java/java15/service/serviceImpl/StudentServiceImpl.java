package java15.service.serviceImpl;

import java15.dao.StudentDao;
import java15.dao.impl.StudentDaoImpl;
import java15.entity.Student;
import java15.service.StudentService;

public class StudentServiceImpl implements StudentService {
    StudentDao studentDao = new StudentDaoImpl();
    @Override
    public String addStudent(Student student) {
        return studentDao.addStudent(student);
    }
}
