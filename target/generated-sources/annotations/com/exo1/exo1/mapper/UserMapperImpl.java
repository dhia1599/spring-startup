package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.ProjetDto;
import com.exo1.exo1.dto.UserDto;
import com.exo1.exo1.entity.Projet;
import com.exo1.exo1.entity.User;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-25T17:58:24+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.5 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private ProjetMapper projetMapper;

    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setName( user.getName() );
        userDto.setEmail( user.getEmail() );
        userDto.setProjets( projetSetToProjetDtoList( user.getProjets() ) );

        return userDto;
    }

    @Override
    public User toEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDto.getId() );
        user.setName( userDto.getName() );
        user.setEmail( userDto.getEmail() );
        user.setProjets( projetDtoListToProjetSet( userDto.getProjets() ) );

        return user;
    }

    @Override
    public List<UserDto> toDtos(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( users.size() );
        for ( User user : users ) {
            list.add( toDto( user ) );
        }

        return list;
    }

    @Override
    public List<User> toEntities(List<UserDto> userDtos) {
        if ( userDtos == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( userDtos.size() );
        for ( UserDto userDto : userDtos ) {
            list.add( toEntity( userDto ) );
        }

        return list;
    }

    protected List<ProjetDto> projetSetToProjetDtoList(Set<Projet> set) {
        if ( set == null ) {
            return null;
        }

        List<ProjetDto> list = new ArrayList<ProjetDto>( set.size() );
        for ( Projet projet : set ) {
            list.add( projetMapper.toDto( projet ) );
        }

        return list;
    }

    protected Set<Projet> projetDtoListToProjetSet(List<ProjetDto> list) {
        if ( list == null ) {
            return null;
        }

        Set<Projet> set = new LinkedHashSet<Projet>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( ProjetDto projetDto : list ) {
            set.add( projetMapper.toEntity( projetDto ) );
        }

        return set;
    }
}
