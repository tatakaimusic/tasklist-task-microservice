package com.example.tasklisttaskmicroservice.service.impl;

import com.example.tasklisttaskmicroservice.model.Status;
import com.example.tasklisttaskmicroservice.model.Task;
import com.example.tasklisttaskmicroservice.model.exception.TaskNotFoundException;
import com.example.tasklisttaskmicroservice.repository.TaskRepository;
import com.example.tasklisttaskmicroservice.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task getById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task with this id not found!"));
    }

    @Override
    public List<Task> getAllByUserEmail(String userEmail) {
        return taskRepository.getAllByUserEmail(userEmail).orElseThrow(() -> new TaskNotFoundException("Task with this user email not found!"));
    }

    @Override
    @Transactional
    public Task create(Task task) {
        if (task.getStatus() == null) {
            task.setStatus(Status.TODO);
        }
        return taskRepository.save(task);
    }

    @Override
    @Transactional
    public Task update(Task task) {
        if (task.getStatus() == null) {
            task.setStatus(Status.TODO);
        }
        return taskRepository.save(task);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}
