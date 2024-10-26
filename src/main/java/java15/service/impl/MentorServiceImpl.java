package java15.service.impl;

import java15.dao.MentorDao;
import java15.dao.impl.MentorDaoImpl;
import java15.entity.Lesson;
import java15.entity.Mentor;
import java15.service.MentorService;

import java.util.List;

public class MentorServiceImpl implements MentorService {
    MentorDao mentorDao = new MentorDaoImpl();

    @Override
    public String addMentor(Mentor mentor) {
        return mentorDao.addMentor(mentor);
    }

    @Override
    public String updateMentor(Mentor mentor) {
        return mentorDao.updateMentor(mentor);
    }

    @Override
    public String deleteMentor(int id) {
        return mentorDao.deleteMentor(id);
    }

    @Override
    public Mentor getMentorById(int id) {
        return mentorDao.getMentorById(id);
    }

    @Override
    public List<Mentor> getAllMentors() {
        return mentorDao.getAllMentors();
    }

    @Override
    public Lesson getAllLessonAndStudentByMentor(String mentorName) {
        return mentorDao.getAllLessonAndStudentByMentor(mentorName);
    }
}
