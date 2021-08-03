package com.stefanini.YuGiOh.YuGiOhAPI.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.stefanini.YuGiOh.YuGiOhAPI.Entities.CardType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardDTO {

    @JsonProperty("id")
    private Long  idCard;
    @JsonProperty("name")
    private String nameCard;
    private int atk;
    private int def;
    private String img;
    @JsonProperty("id_tipo")
    private long cardType;
}
