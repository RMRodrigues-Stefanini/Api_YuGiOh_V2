package com.stefanini.YuGiOh.YuGiOhAPI.mapper;

import com.stefanini.YuGiOh.YuGiOhAPI.DTO.UserDTO;
import com.stefanini.YuGiOh.YuGiOhAPI.Entities.User;
import org.modelmapper.ModelMapper;

public class UserMapper {
    private UserMapper(){};
    private static UserMapper instance = new UserMapper();
    public static UserMapper getInstance() { return instance;}

    public UserDTO toDTO(User user) {
        ModelMapper modelMapper = new ModelMapper();
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }

    public User toModel(UserDTO userDTO){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(userDTO, User.class);
    }
}
