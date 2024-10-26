package java15.dao;

import java15.entity.Lesson;
import java15.entity.Mentor;

import java.util.List;

public interface MentorDao {
    // todo CRUD
    String addMentor(Mentor mentor);
    String updateMentor(Mentor mentor);
    String deleteMentor(int id);
    Mentor getMentorById(int id);
    List<Mentor> getAllMentors();

    Lesson getAllLessonAndStudentByMentor(String mentorName);

}
