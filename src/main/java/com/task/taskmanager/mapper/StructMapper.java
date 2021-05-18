package com.task.taskmanager.mapper;

import com.task.taskmanager.dto.AuthResponse;
import com.task.taskmanager.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StructMapper {

  AuthResponse toAuthResponse(User user);

}
