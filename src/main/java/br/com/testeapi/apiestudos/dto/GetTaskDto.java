package br.com.testeapi.apiestudos.dto;

import br.com.testeapi.apiestudos.model.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTaskDto {
    private int id;
    private String name;
    private String description;
    private int status;

    public GetTaskDto(Task task){
        new ModelMapper().map(task, this);
    }
}
