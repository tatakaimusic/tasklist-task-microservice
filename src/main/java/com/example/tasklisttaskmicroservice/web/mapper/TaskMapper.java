package com.example.tasklisttaskmicroservice.web.mapper;

import com.example.tasklisttaskmicroservice.model.Task;
import com.example.tasklisttaskmicroservice.web.dto.TaskDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface TaskMapper extends Mappable<Task, TaskDTO> {

}
