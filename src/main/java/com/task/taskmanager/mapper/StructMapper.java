package com.task.taskmanager.mapper;

import com.task.taskmanager.dto.UserDto;
import com.task.taskmanager.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StructMapper {

    UserDto toUserDto(User user);

}
