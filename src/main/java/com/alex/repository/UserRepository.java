package com.alex.repository;

import com.alex.entity.UserE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserE,Integer> {

    @Query(value="select * from users where username=:username",nativeQuery=true)
    public abstract UserE findByUsername(String username);


}
