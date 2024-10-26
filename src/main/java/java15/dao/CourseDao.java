package java15.dao;

import java15.entity.Course;

import java.util.List;

public interface CourseDao {
    /// Add
    String saveCourse(Course course);

    // update
    String updateCourse(Long id, Course newCourse);

    // delete
    String deleteCourse(Long id);
    // getAll
    List<Course> getAllCourses();

    // find By id
    Course findById(Long id);

    // GetCourseById
    Course getCourseById(Long id);

    Long countOfStudentByCourseId(Long courseId);

    List<Course> sortCourseToPrice(String ascOrDesc);

}
