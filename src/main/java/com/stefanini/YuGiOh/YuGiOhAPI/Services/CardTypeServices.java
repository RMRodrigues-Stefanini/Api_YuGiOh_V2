package com.stefanini.YuGiOh.YuGiOhAPI.Services;



import com.stefanini.YuGiOh.YuGiOhAPI.Entities.CardType;
import com.stefanini.YuGiOh.YuGiOhAPI.Repository.CardTypeRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardTypeServices {

    @Autowired
    CardTypeRepository cardTypeRepository;

    public List<CardType> findAll() {return cardTypeRepository.findAll();}

    public Optional<CardType> findById(Long id){ return cardTypeRepository.findById(id);}

    public CardType save(CardType cardType) { return cardTypeRepository.save(cardType);}

    public CardType update (@NotNull CardType cardType){
        checkId(cardType.getIdCT());
        return  cardTypeRepository.save(cardType);
    }

    public void deleteById(Long id){ cardTypeRepository.deleteById(id);}

    public void delete (CardType cardType){
        cardTypeRepository.delete(cardType);
    }




    private CardType checkId(Long id){
        return  cardTypeRepository.findById(id).
                orElseThrow(()->new RuntimeException("Id not found"));
    }
}
