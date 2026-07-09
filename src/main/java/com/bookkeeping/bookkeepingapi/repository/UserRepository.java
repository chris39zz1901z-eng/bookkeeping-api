package com.bookkeeping.bookkeepingapi.repository;

import com.bookkeeping.bookkeepingapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByUsername(String username);

    List<User> findByAgeBetween(Integer ageStart, Integer ageEnd);
}
