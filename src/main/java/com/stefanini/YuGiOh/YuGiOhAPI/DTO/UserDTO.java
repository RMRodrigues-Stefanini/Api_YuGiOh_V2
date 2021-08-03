package com.stefanini.YuGiOh.YuGiOhAPI.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.stefanini.YuGiOh.YuGiOhAPI.Entities.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Service
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @JsonProperty("id")
    private Long idUser;

    @JsonProperty("name")
    private String nameUser;

    private String login;

    private String cpf;

    @JsonProperty("type")
    private long userType;



}
