package br.com.testeapi.apiestudos.service;

import br.com.testeapi.apiestudos.dto.GetTaskDto;
import br.com.testeapi.apiestudos.dto.TaskDto;
import br.com.testeapi.apiestudos.model.Task;
import br.com.testeapi.apiestudos.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public Task createTask(TaskDto taskDto){
        return taskRepository.save(taskDto.toTask());
    }
    public Page<GetTaskDto> getTask(Pageable pageable){
        return taskRepository.findAll(pageable).map(GetTaskDto::new);
    }
    public Task actualizeTask(int id, TaskDto taskDto){
        Task task = taskDto.toTask();
        task.setId(id);
        return taskRepository.save(task);
    }
    public void deleteTask(int id){
        taskRepository.deleteById(id);
    }

    public Optional<Task> getTaskById(int id){
        return taskRepository.findById(id);
    }
}
