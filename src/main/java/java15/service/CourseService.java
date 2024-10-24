package java15.service;

import java15.entity.Course;

import java.util.List;

public interface CourseService {
    /// Add
    String saveCourse(Course course);

    // GetCourseById
    Course getCourseById(Long id);

    // update
    String updateCourse(Long id, Course newcourse);
    // delete
    String deleteCourse(Long id);
    // getAll
//    List<Course> getAllCourses();

}
