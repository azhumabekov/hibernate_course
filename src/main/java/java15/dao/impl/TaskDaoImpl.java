package java15.dao.impl;

import jakarta.persistence.EntityManager;
import java15.dao.TaskDao;
import java15.entity.Task;

public class TaskDaoImpl implements TaskDao {
    @Override
    public String saveTaskToLesson(Long taskId, Long lessonId) {
        EntityManager entityManager = null;
        try {
            entityManager.getTransaction().begin();
            Task task = entityManager.find(Task.class, taskId);
            entityManager.persist(task);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();

            }
        }
        return "";
    }

    @Override
    public Task getTaskById(Long taskId) {
        return null;
    }

    @Override
    public String updateTaskById(Long taskId, Long lessonId) {
        return "";
    }

    @Override
    public String deleteTaskById(Long taskId) {
        return "";
    }

    @Override
    public String deleteTaskByDeadline(Long taskId) {
        return "";
    }
}
