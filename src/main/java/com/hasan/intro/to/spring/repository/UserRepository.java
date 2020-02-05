package com.hasan.intro.to.spring.repository;

import com.hasan.intro.to.spring.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    boolean existsByEmail(String email);
    List<User> findAll();
}
