package br.com.testeapi.apiestudos.controller;

import br.com.testeapi.apiestudos.dto.GetTaskDto;
import br.com.testeapi.apiestudos.dto.TaskDto;
import br.com.testeapi.apiestudos.model.Task;
import br.com.testeapi.apiestudos.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping
    public Task createTask(@RequestBody TaskDto taskDto) {
        return taskService.createTask(taskDto);
    }

    @GetMapping
    public Page<GetTaskDto> getTask(@PageableDefault Pageable pageable){
        return taskService.getTask(pageable);
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable("id") int id){
        return taskService.getTaskById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Task actualizeTask(@PathVariable("id") int id,@RequestBody  TaskDto taskDto){
        return taskService.actualizeTask(id, taskDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") int id) {
        taskService.deleteTask(id);
    }
}
