package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.TaskDto;
import com.exo1.exo1.entity.Task;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-25T15:11:44+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.5 (Oracle Corporation)"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public TaskDto toDto(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskDto taskDto = new TaskDto();

        taskDto.setId( task.getId() );
        taskDto.setTitle( task.getTitle() );
        taskDto.setStatus( task.getStatus() );

        return taskDto;
    }

    @Override
    public Task toEntity(TaskDto taskDto) {
        if ( taskDto == null ) {
            return null;
        }

        Task task = new Task();

        task.setId( taskDto.getId() );
        task.setTitle( taskDto.getTitle() );
        task.setStatus( taskDto.getStatus() );

        return task;
    }

    @Override
    public List<TaskDto> toDtos(List<Task> tasks) {
        if ( tasks == null ) {
            return null;
        }

        List<TaskDto> list = new ArrayList<TaskDto>( tasks.size() );
        for ( Task task : tasks ) {
            list.add( toDto( task ) );
        }

        return list;
    }

    @Override
    public List<Task> toEntities(List<TaskDto> taskDtos) {
        if ( taskDtos == null ) {
            return null;
        }

        List<Task> list = new ArrayList<Task>( taskDtos.size() );
        for ( TaskDto taskDto : taskDtos ) {
            list.add( toEntity( taskDto ) );
        }

        return list;
    }
}
