package java15.service.impl;

import java15.dao.CourseDao;
import java15.dao.impl.CourseDaoImpl;
import java15.entity.Course;
import java15.service.CourseService;

import java.util.List;

public class

CourseServiceImpl implements CourseService {
    CourseDao courseDao = new CourseDaoImpl();

    @Override
    public String saveCourse(Course course) {
        return courseDao.saveCourse(course);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseDao.getCourseById(id);
    }

    @Override
    public String updateCourse(Long id, Course newCourse) {
        return courseDao.updateCourse(id, newCourse);
    }

    @Override
    public String deleteCourse(Long id) {
        return courseDao.deleteCourse(id);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseDao.getAllCourses();
    }

    @Override
    public Long countOfStudentByCourseId(Long id) {
        return courseDao.countOfStudentByCourseId(id);
    }

    @Override
    public List<Course> sortCourseToPrice(String ascOrDesc) {
        return courseDao.sortCourseToPrice(ascOrDesc);
    }

}
