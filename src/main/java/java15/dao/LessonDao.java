package java15.dao;

import java15.entity.Lesson;

import java.util.List;

public interface LessonDao{
    // todo CRUD
    String addLessonToCourse(Long courseId, Long lessonId);
    String updateLessonToCourse(Long courseId, Long lessonId);
    String deleteLessonFromCourse(Long lessonId);
    List<Lesson> getLessonsFromCourse(Long courseId);
    List<Lesson> getAllLessons();

    String deleteLessonByCourseId(Long courseId,Long lessonId);
    List<Lesson> sortLessonByPublishedDate();

}
