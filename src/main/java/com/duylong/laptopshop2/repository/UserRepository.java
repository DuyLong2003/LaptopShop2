package com.duylong.laptopshop2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duylong.laptopshop2.domain.User;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // insert into user values (....)
    User save(User duylong);

    List<User> findAll();

    User findById(long id);

    void deleteById(long id);
}
