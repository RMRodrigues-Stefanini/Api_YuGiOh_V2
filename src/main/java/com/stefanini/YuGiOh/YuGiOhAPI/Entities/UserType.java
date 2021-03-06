package com.stefanini.YuGiOh.YuGiOhAPI.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  idUT;

    private String nameUT;
}
