package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.ProjetDto;
import com.exo1.exo1.dto.TaskDto;
import com.exo1.exo1.entity.Projet;
import com.exo1.exo1.entity.Task;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-25T15:11:44+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.5 (Oracle Corporation)"
)
@Component
public class ProjetMapperImpl implements ProjetMapper {

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public ProjetDto toDto(Projet projet) {
        if ( projet == null ) {
            return null;
        }

        ProjetDto projetDto = new ProjetDto();

        projetDto.setId( projet.getId() );
        projetDto.setName( projet.getName() );
        projetDto.setDescription( projet.getDescription() );
        projetDto.setTasks( taskSetToTaskDtoList( projet.getTasks() ) );

        return projetDto;
    }

    @Override
    public Projet toEntity(ProjetDto projetDto) {
        if ( projetDto == null ) {
            return null;
        }

        Projet projet = new Projet();

        projet.setId( projetDto.getId() );
        projet.setName( projetDto.getName() );
        projet.setDescription( projetDto.getDescription() );
        projet.setTasks( taskDtoListToTaskSet( projetDto.getTasks() ) );

        return projet;
    }

    @Override
    public List<ProjetDto> toDtos(List<Projet> projets) {
        if ( projets == null ) {
            return null;
        }

        List<ProjetDto> list = new ArrayList<ProjetDto>( projets.size() );
        for ( Projet projet : projets ) {
            list.add( toDto( projet ) );
        }

        return list;
    }

    @Override
    public List<Projet> toEntities(List<ProjetDto> projetDtos) {
        if ( projetDtos == null ) {
            return null;
        }

        List<Projet> list = new ArrayList<Projet>( projetDtos.size() );
        for ( ProjetDto projetDto : projetDtos ) {
            list.add( toEntity( projetDto ) );
        }

        return list;
    }

    protected List<TaskDto> taskSetToTaskDtoList(Set<Task> set) {
        if ( set == null ) {
            return null;
        }

        List<TaskDto> list = new ArrayList<TaskDto>( set.size() );
        for ( Task task : set ) {
            list.add( taskMapper.toDto( task ) );
        }

        return list;
    }

    protected Set<Task> taskDtoListToTaskSet(List<TaskDto> list) {
        if ( list == null ) {
            return null;
        }

        Set<Task> set = new LinkedHashSet<Task>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( TaskDto taskDto : list ) {
            set.add( taskMapper.toEntity( taskDto ) );
        }

        return set;
    }
}
