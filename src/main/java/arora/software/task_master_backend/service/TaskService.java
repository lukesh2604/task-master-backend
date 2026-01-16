package arora.software.task_master_backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import arora.software.task_master_backend.dto.TaskDto;
import arora.software.task_master_backend.model.Task;
import arora.software.task_master_backend.repository.TaskRepository;
import org.modelmapper.ModelMapper;

@Service
public class TaskService {
    
    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper; 
    public TaskService(TaskRepository taskRepository, ModelMapper modelMapper){
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
    }
    public List<Task> getAll(){
        List<Task> list = this.taskRepository.findAll();
        return list;
    }
    public Task createTask(Task task){
        task.setStatus("Open");
        return this.taskRepository.save(task);
    }
    public void deleteTask(Long id){
        this.taskRepository.deleteById(id);
    }
    public Task updateTask(Long id, Task updatedTask){

        Task task = this.taskRepository.findById(id).orElseThrow();
        task.setStatus(updatedTask.getStatus());

        return this.taskRepository.save(task);
    }

}
