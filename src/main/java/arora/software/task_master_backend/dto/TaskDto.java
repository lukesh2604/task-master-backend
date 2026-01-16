package arora.software.task_master_backend.dto;

import lombok.Data;

@Data
public class TaskDto {
    private String id;
    private String title;
    private String description;
    private String status;
}
