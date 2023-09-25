package com.example.tasklisttaskmicroservice.web.controller;

import com.example.tasklisttaskmicroservice.model.Task;
import com.example.tasklisttaskmicroservice.service.TaskService;
import com.example.tasklisttaskmicroservice.web.dto.TaskDTO;
import com.example.tasklisttaskmicroservice.web.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;

    private final TaskMapper taskMapper;

    @Autowired
    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @GetMapping("/{id}")
    public TaskDTO getById(@PathVariable Long id) {
        Task task = taskService.getById(id);
        return taskMapper.toDto(task);
    }

    @GetMapping("/{email}")
    public List<TaskDTO> getAllByUserEmail(@PathVariable("email") String userEmail) {
        List<Task> tasks = taskService.getAllByUserEmail(userEmail);
        return taskMapper.toDto(tasks);
    }

    @PutMapping
    public TaskDTO update(@RequestBody TaskDTO dto) {
        Task task = taskMapper.toEntity(dto);
        return taskMapper.toDto(taskService.update(task));
    }

    @PostMapping
    public TaskDTO create(@RequestBody TaskDTO dto) {
        Task task = taskMapper.toEntity(dto);
        return taskMapper.toDto(taskService.create(task));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        taskService.delete(id);
    }
}
