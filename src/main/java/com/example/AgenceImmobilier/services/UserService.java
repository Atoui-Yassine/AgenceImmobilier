package com.example.AgenceImmobilier.services;


import com.example.AgenceImmobilier.exceptions.EntityNotFoundException;
import com.example.AgenceImmobilier.models.user.UserModel;
import com.example.AgenceImmobilier.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }
    public Boolean existsByUsername(String username){
        return userRepository.existsByUsername(username);
    }
    public Boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }
    public UserModel findById(Long id){
        UserModel user=userRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("User not found with id : "+id));
        return user;
    }
    public List<UserModel> findAllUser(){
        return userRepository.findAllByEnabledTrue();
    }
    public Boolean existsByUsernameOrEmail(String usernameOrEmail){
        return userRepository.existsByUsernameOrEmail(usernameOrEmail);
    }


}

