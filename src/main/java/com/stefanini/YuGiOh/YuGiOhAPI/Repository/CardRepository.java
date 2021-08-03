package com.stefanini.YuGiOh.YuGiOhAPI.Repository;

import com.stefanini.YuGiOh.YuGiOhAPI.Entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card,Long> {
}
