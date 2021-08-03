package com.stefanini.YuGiOh.YuGiOhAPI.Services;


import com.stefanini.YuGiOh.YuGiOhAPI.Entities.User;
import com.stefanini.YuGiOh.YuGiOhAPI.Repository.UserRepository;
import com.sun.istack.NotNull;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {return userRepository.findAll();}

    public User findById(Long id){ return checkId (id);}

    public User save(User user) { return (User) userRepository.save(user);}

    public User update (@NotNull User user){
        checkId((long) user.getIdUser());
        return (User) userRepository.save(user);
    }

    public void deleteById(Long id){ userRepository.deleteById(id);}

    public void delete (User user){
        userRepository.delete(user);
    }


    private User checkId(Long id){
        return (User) userRepository.findById(id).
                orElseThrow(()->new RuntimeException("Id not found"));
    }
}
