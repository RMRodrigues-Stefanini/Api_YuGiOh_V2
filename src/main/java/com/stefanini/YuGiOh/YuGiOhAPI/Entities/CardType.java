package com.stefanini.YuGiOh.YuGiOhAPI.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  idCT;

    @Column
    private String nameCT;
}
