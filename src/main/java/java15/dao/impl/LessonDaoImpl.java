package java15.dao.impl;

import java15.dao.LessonDao;
import java15.entity.Lesson;
import java15.entity.Mentor;

import java.util.List;

public class LessonDaoImpl implements LessonDao {

    @Override
    public String addLessonToCourse(Long courseId, Long lessonId) {
        return "";
    }

    @Override
    public String updateLessonToCourse(Long courseId, Long lessonId) {
        return "";
    }

    @Override
    public String deleteLessonFromCourse(Long lessonId) {
        return "";
    }

    @Override
    public List<Lesson> getLessonsFromCourse(Long courseId) {
        return List.of();
    }

    @Override
    public List<Lesson> getAllLessons() {
        return List.of();
    }

    @Override
    public String deleteLessonByCourseId(Long courseId, Long lessonId) {
        return "";
    }

    @Override
    public List<Lesson> sortLessonByPublishedDate() {
        return List.of();
    }
}
