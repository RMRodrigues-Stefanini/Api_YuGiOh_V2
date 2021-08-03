package com.stefanini.YuGiOh.YuGiOhAPI.Repository;


import com.stefanini.YuGiOh.YuGiOhAPI.Entities.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType,Long>{
}
