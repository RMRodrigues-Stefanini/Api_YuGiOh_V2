package com.stefanini.YuGiOh.YuGiOhAPI.Services;


import com.stefanini.YuGiOh.YuGiOhAPI.Entities.CardUser;
import com.stefanini.YuGiOh.YuGiOhAPI.Repository.CardUserRepository;
import com.sun.istack.NotNull;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CardUserServices {

    @Autowired
    CardUserRepository cardUserRepository;

    public List<CardUser> findAll() {return cardUserRepository.findAll();}

    public CardUser findById(Long id){ return checkId (id);}

    public CardUser save(CardUser cardUser) { return (CardUser) cardUserRepository.save(cardUser);}

    public CardUser update (@NotNull CardUser cardUser){
        checkId((long) cardUser.getIdCardUser());
        return (CardUser) cardUserRepository.save(cardUser);
    }

    public void deleteById(Long id){ cardUserRepository.deleteById(id);}

    public void delete (CardUser cardUser){
        cardUserRepository.delete(cardUser);
    }




    private CardUser checkId(Long id){
        return (CardUser) cardUserRepository.findById(id).
                orElseThrow(()->new RuntimeException("Id not found"));
    }
}
