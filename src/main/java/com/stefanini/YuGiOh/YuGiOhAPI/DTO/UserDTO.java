package com.stefanini.YuGiOh.YuGiOhAPI.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.stefanini.YuGiOh.YuGiOhAPI.Entities.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long idUser;

    @JsonProperty("name")
    private String nameUser;

    private String login;

    private String cpf;

    @JsonProperty("type")
    private UserType userType;
}
