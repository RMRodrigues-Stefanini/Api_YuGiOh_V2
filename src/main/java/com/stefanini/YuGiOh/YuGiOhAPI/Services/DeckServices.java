package com.stefanini.YuGiOh.YuGiOhAPI.Services;



import com.stefanini.YuGiOh.YuGiOhAPI.Entities.Deck;
import com.stefanini.YuGiOh.YuGiOhAPI.Repository.DeckRepository;
import com.sun.istack.NotNull;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeckServices {

    @Autowired
    DeckRepository deckRepository;

    public List<Deck> findAll() {return deckRepository.findAll();}

    public Deck findById(Long id){ return checkId (id);}

    public Deck save(Deck deck) { return (Deck) deckRepository.save(deck);}

    public Deck update (@NotNull Deck deck){
        checkId((long) deck.getId_Deck());
        return (Deck) deckRepository.save(deck);
    }

    public void deleteById(Long id){ deckRepository.deleteById(id);}

    public void delete (Deck deck){
        deckRepository.delete(deck);
    }

    private Deck checkId(Long id){
        return (Deck) deckRepository.findById(id).
                orElseThrow(()->new RuntimeException("Id not found"));
    }
}
