package com.example.tasklisttaskmicroservice.service;

import com.example.tasklisttaskmicroservice.model.Task;

import java.util.List;

public interface TaskService {

    Task getById(Long id);

    List<Task> getAllByUserEmail(String userEmail);

    Task create(Task task);

    Task update(Task task);

    void delete(Long id);
}
