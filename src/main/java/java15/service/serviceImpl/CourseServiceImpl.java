package java15.service.serviceImpl;

import java15.dao.CourseDao;
import java15.dao.impl.CourseDaoImpl;
import java15.entity.Course;
import java15.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    CourseDao courseDao = new CourseDaoImpl();

    @Override
    public String saveCourse(Course course) {
        return courseDao.saveCourse(course);
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

}
