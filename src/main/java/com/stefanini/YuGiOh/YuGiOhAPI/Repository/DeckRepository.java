package com.stefanini.YuGiOh.YuGiOhAPI.Repository;

import com.stefanini.YuGiOh.YuGiOhAPI.Entities.Deck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckRepository extends JpaRepository <Deck,Long>{
}
