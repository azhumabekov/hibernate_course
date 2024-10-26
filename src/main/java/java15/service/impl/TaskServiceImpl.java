package java15.service.impl;

import java15.dao.TaskDao;
import java15.dao.impl.TaskDaoImpl;
import java15.entity.Task;
import java15.service.TaskService;

public class TaskServiceImpl implements TaskService {
    private final TaskDao taskDao = new TaskDaoImpl();

    @Override
    public String saveTaskToLesson(Long taskId, Long lessonId) {
        return taskDao.saveTaskToLesson(taskId, lessonId);
    }

    @Override
    public Task getTaskById(Long taskId) {
        return taskDao.getTaskById(taskId);
    }

    @Override
    public String updateTaskById(Long taskId, Long lessonId) {
        return taskDao.updateTaskById(taskId, lessonId);
    }

    @Override
    public String deleteTaskById(Long taskId) {
        return taskDao.deleteTaskById(taskId);
    }

    @Override
    public String deleteTaskByDeadline(Long taskId) {
        return taskDao.deleteTaskByDeadline(taskId);
    }
}
