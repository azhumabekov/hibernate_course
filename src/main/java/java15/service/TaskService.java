package java15.service;

import java15.entity.Task;

public interface TaskService {
    //  TODO crud
    String saveTaskToLesson(Long taskId,Long lessonId);
     // Read
    Task getTaskById(Long taskId);
    // Update
    String updateTaskById(Long taskId,Long lessonId);
    // Delete
    String deleteTaskById(Long taskId);


    //    Drop methods
//    TODO Eger Task'tyn dealine'ny buto elek bolso Task ochup ketpesh kerek
    String deleteTaskByDeadline(Long taskId);

}
