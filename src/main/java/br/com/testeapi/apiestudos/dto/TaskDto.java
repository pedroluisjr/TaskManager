package br.com.testeapi.apiestudos.dto;

import br.com.testeapi.apiestudos.model.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private String name;
    private String description;
    private int status;

    public Task toTask(){
       return new ModelMapper().map(this, Task.class);
    }
}
