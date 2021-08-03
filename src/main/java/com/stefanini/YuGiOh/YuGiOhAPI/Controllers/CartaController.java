package com.stefanini.YuGiOh.YuGiOhAPI.Controllers;


import com.stefanini.YuGiOh.YuGiOhAPI.DTO.CardDTO;
import com.stefanini.YuGiOh.YuGiOhAPI.Entities.Card;
import com.stefanini.YuGiOh.YuGiOhAPI.Entities.CardType;
import com.stefanini.YuGiOh.YuGiOhAPI.Services.CardServices;
import com.stefanini.YuGiOh.YuGiOhAPI.Services.CardTypeServices;
import com.stefanini.YuGiOh.YuGiOhAPI.mapper.CartaMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/card")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CartaController {

    private final CardServices cardServices;

    private final CartaMapper cartaMapper;

    @GetMapping(value = "/{id}")
    public ResponseEntity getCardById(@PathVariable("id") long id) {
        Card cardsData = cardServices.findById(id);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(cardsData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carta nao encontrada");
        }
    }


    @PostMapping
    public ResponseEntity<CardDTO> createCard(@RequestBody CardDTO cardDTO) {
        Card card = cartaMapper.toModel(cardDTO);
        try {
            Card cardSaved = cardServices.save(card);
            return new ResponseEntity(cardSaved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        try {
            cardServices.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardDTO> updateCard(@PathVariable long id, @RequestBody CardDTO cardDTO) {
        cardDTO.setIdCard(id);
        Card card = cartaMapper.toModel(cardDTO);
        try {
            Card cardSaved = cardServices.save(card);
            return new ResponseEntity(cardSaved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}


