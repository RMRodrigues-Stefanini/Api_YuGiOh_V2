package com.stefanini.YuGiOh.YuGiOhAPI.Repository;

import com.stefanini.YuGiOh.YuGiOhAPI.Entities.CardUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardUserRepository extends JpaRepository<CardUser,Long> {
}
