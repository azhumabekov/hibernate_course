package java15.dao.impl;

import java15.dao.MentorDao;
import java15.entity.Lesson;
import java15.entity.Mentor;

import java.util.List;

public class MentorDaoImpl implements MentorDao {
    @Override
    public String addMentor(Mentor mentor) {
        return "";
    }

    @Override
    public String updateMentor(Mentor mentor) {
        return "";
    }

    @Override
    public String deleteMentor(int id) {
        return "";
    }

    @Override
    public Mentor getMentorById(int id) {
        return null;
    }

    @Override
    public List<Mentor> getAllMentors() {
        return List.of();
    }

    @Override
    public Lesson getAllLessonAndStudentByMentor(String mentorName) {
        return null;
    }
}
