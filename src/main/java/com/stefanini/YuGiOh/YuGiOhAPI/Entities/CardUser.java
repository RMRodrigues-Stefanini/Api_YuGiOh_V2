package com.stefanini.YuGiOh.YuGiOhAPI.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  idCardUser;

    @ManyToOne
    private User user;

    @ManyToOne
    private Card card;
}
