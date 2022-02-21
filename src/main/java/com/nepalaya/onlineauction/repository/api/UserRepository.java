package com.nepalaya.onlineauction.repository.api;


import com.nepalaya.onlineauction.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
