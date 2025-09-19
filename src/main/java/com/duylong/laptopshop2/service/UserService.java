package com.duylong.laptopshop2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.duylong.laptopshop2.domain.User;
import com.duylong.laptopshop2.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public User handleSaveUser(User user) {
        User dlong = this.userRepository.save(user);
        System.out.println(dlong);
        return dlong;
    }

    public User getUserById(long id) {
        return this.userRepository.findById(id);
    }

    public void deleteAUser(long id) {
        this.userRepository.deleteById(id);
    }
}
