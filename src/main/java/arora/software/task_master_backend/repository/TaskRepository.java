package arora.software.task_master_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import arora.software.task_master_backend.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
    
}
