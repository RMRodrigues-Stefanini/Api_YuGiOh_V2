package com.stefanini.YuGiOh.YuGiOhAPI.Entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Usr")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUser;

    @Column
    private String nameUser;

    @Column
    private String login;

    @Column
    private String cpf;

    @ManyToOne
    private UserType userType;
}
