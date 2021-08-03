package com.stefanini.YuGiOh.YuGiOhAPI.mapper;

import com.stefanini.YuGiOh.YuGiOhAPI.DTO.CardDTO;
import com.stefanini.YuGiOh.YuGiOhAPI.Entities.Card;
import com.stefanini.YuGiOh.YuGiOhAPI.Entities.CardType;
import com.stefanini.YuGiOh.YuGiOhAPI.Services.CardTypeServices;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Slf4j
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CartaMapper {


    private final CardTypeServices cardTypeServices;

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
        Optional<CardType> cardType = cardTypeServices.findById(cardDTO.getCardType());
        if(cardType.isEmpty()){
            card.setCardType(null);
        }
             card.setCardType(cardType.get());
        return card;
    }
}
