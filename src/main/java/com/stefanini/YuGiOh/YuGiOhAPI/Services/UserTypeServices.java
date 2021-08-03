package com.stefanini.YuGiOh.YuGiOhAPI.Services;



import com.stefanini.YuGiOh.YuGiOhAPI.Entities.UserType;
import com.stefanini.YuGiOh.YuGiOhAPI.Repository.UserTypeRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserTypeServices {

    @Autowired
    UserTypeRepository userTypeRepository;

    public List<UserType> findAll() {return userTypeRepository.findAll();}

    public Optional<UserType> findById(Long id){ return userTypeRepository.findById (id);}

    public UserType save(UserType userType) { return (UserType) userTypeRepository.save(userType);}

    public UserType update (@NotNull UserType userType){
        checkId((long) userType.getIdUT());
        return (UserType) userTypeRepository.save(userType);
    }

    public void deleteById(Long id){ userTypeRepository.deleteById(id);}

    public void delete (UserType userType){
        userTypeRepository.delete(userType);
    }



    private UserType checkId(Long id){
        return (UserType) userTypeRepository.findById(id).
                orElseThrow(()->new RuntimeException("Id not found"));
    }
}
