package com.stefanini.YuGiOh.YuGiOhAPI.mapper;

import com.stefanini.YuGiOh.YuGiOhAPI.DTO.CardDTO;
import com.stefanini.YuGiOh.YuGiOhAPI.Entities.Card;
import com.stefanini.YuGiOh.YuGiOhAPI.Entities.CardType;
import com.stefanini.YuGiOh.YuGiOhAPI.Services.CardTypeServices;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
@Slf4j
public class CartaMapper {
    private CartaMapper(){};
    private static CartaMapper instance = new CartaMapper();
    public static CartaMapper getInstance() { return instance;}

    @Autowired
    private CardTypeServices cardTypeServices;

    public CardDTO toDTO(Card card) {
        ModelMapper modelMapper = new ModelMapper();
        CardDTO cardDTO = modelMapper.map(card, CardDTO.class);
        cardDTO.setCardType(card.getCardType().getIdCT());
        return cardDTO;
        }

    public Card toModel(CardDTO cardDTO){
        ModelMapper modelMapper = new ModelMapper();
        log.info("DTO" + cardDTO.getCardType());
        Card card = modelMapper.map(cardDTO, Card.class);
        log.info("CARD :" + cardTypeServices.findById(cardDTO.getCardType()));
       // card.setCardType(cardTypeServices.findById(cardDTO.getCardType()));
        return card;
    }
}
