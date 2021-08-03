package com.stefanini.YuGiOh.YuGiOhAPI.Repository;


import com.stefanini.YuGiOh.YuGiOhAPI.Entities.CardType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardTypeRepository extends JpaRepository<CardType,Long> {
}
