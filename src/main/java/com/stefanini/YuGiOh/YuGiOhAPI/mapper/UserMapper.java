package com.stefanini.YuGiOh.YuGiOhAPI.mapper;

import com.stefanini.YuGiOh.YuGiOhAPI.DTO.UserDTO;
import com.stefanini.YuGiOh.YuGiOhAPI.Entities.User;
import com.stefanini.YuGiOh.YuGiOhAPI.Entities.UserType;
import com.stefanini.YuGiOh.YuGiOhAPI.Entities.User;
import com.stefanini.YuGiOh.YuGiOhAPI.Services.UserTypeServices;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class UserMapper {

    private UserTypeServices userTypeServices;



    public UserDTO toDTO(User user) {
        ModelMapper modelMapper = new ModelMapper();
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        log.info("UserDTO : " + userDTO );
        userDTO.setUserType(user.getUserType().getIdUT());
        return userDTO;
    }

    public User toModel(UserDTO userDTO){
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userDTO, User.class);
        Optional<UserType> userType = userTypeServices.findById(userDTO.getUserType());
        if(userType.isEmpty()){
            user.setUserType(null);
        }
        user.setUserType(userType.get());
        return user;
    }
}
