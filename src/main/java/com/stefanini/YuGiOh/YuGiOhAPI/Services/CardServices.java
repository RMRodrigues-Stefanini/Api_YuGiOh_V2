package com.stefanini.YuGiOh.YuGiOhAPI.Services;


import com.stefanini.YuGiOh.YuGiOhAPI.Entities.Card;
import com.stefanini.YuGiOh.YuGiOhAPI.Repository.CardRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CardServices {

    @Autowired
    CardRepository cardRepository;

    public List<Card> findAll() {return cardRepository.findAll();}

    public Card findById(Long id){ return checkId (id);}

    public Card save(Card card) { return cardRepository.save(card);}

    public Card update (@NotNull Card card){
        checkId(card.getIdCard());
        return cardRepository.save(card);
    }

    public void deleteById(Long id){ cardRepository.deleteById(id);}

    public void delete (Card card){
        cardRepository.delete(card);
    }

     private Card checkId(Long id){
       return cardRepository.findById(id).
                orElseThrow(()->new RuntimeException("Id not found"));
    }
}
