package com.stefanini.YuGiOh.YuGiOhAPI.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  idCard;

    @Column
    private String nameCard;

    @Column
    private int atk;

    @Column
    private int def;

    @Column
    private String img;

    @ManyToOne
    private CardType cardType;
}
