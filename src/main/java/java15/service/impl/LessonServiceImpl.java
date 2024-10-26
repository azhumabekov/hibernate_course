package java15.service.impl;

import java15.dao.LessonDao;
import java15.dao.impl.LessonDaoImpl;
import java15.entity.Lesson;
import java15.service.LessonService;

import java.util.List;

public class LessonServiceImpl implements LessonService {
    private LessonDao lessonDao = new LessonDaoImpl();


    @Override
    public String addLessonToCourse(Long courseId, Long lessonId) {
        return lessonDao.addLessonToCourse(courseId, lessonId);
    }

    @Override
    public String updateLessonToCourse(Long courseId, Long lessonId) {
        return lessonDao.updateLessonToCourse(courseId, lessonId);
    }

    @Override
    public String deleteLessonFromCourse(Long lessonId) {
        return lessonDao.deleteLessonFromCourse(lessonId);
    }

    @Override
    public List<Lesson> getLessonsFromCourse(Long courseId) {
        return lessonDao.getLessonsFromCourse(courseId);
    }

    @Override
    public List<Lesson> getAllLessons() {
        return lessonDao.getAllLessons();
    }

    @Override
    public String deleteLessonByCourseId(Long courseId, Long lessonId) {
        return lessonDao.deleteLessonByCourseId(courseId, lessonId);
    }

    @Override
    public List<Lesson> sortLessonByPublishedDate() {
        return lessonDao.sortLessonByPublishedDate();
    }
}
