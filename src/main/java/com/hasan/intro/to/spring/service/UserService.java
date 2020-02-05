package com.hasan.intro.to.spring.service;

import com.hasan.intro.to.spring.entity.User;
import com.hasan.intro.to.spring.model.UserDTO;
import com.hasan.intro.to.spring.model.UserMapper;
import com.hasan.intro.to.spring.repository.UserRepository;
import org.hibernate.validator.internal.util.logging.Log;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public void createUser(UserDTO request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("User with this email is already exist:" + request.getEmail());
        }
        User user = userMapper.toUser(request);
        userRepository.save(user);
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(userMapper::toUserDTO).collect(Collectors.toList());
    }

    public long getNumberOfUsers(){
        return userRepository.count();
    }

    public UserDTO getById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("User is not found with this id: " + id));
        System.out.println("User returned to client with " + id + " id");
        return userMapper.toUserDTO(user) ;
    }

    public User editUser(UserDTO request, Long id) {

        User user = userRepository.findById(id).orElseThrow(NullPointerException::new);
        user.setName(request.getName());
        user.setAge(request.getAge());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return  userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
