package com.TrungTinhFullStack.springboot_study.Service.User;

import com.TrungTinhFullStack.springboot_study.Entity.User;
import com.TrungTinhFullStack.springboot_study.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAllUser() {
        LOGGER.info("Get all user success ! : {} ",userRepository.findAll());
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        LOGGER.info("Get user by id success ! : id {} ",id);
        return userRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public User addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        LOGGER.info("Add user success ! user {} ",user);
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User updateUser(Long id, User user) {
        User user1 = getUserById(id);
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        user1.setJournalEntries(user.getJournalEntries());
        LOGGER.info("Update user success ! user {} ",user1);
        userRepository.save(user1);
        return user1;
    }

    @Override
    @Transactional
    public User deleteUser(Long id) {
        User user = getUserById(id);
        userRepository.delete(user);
        LOGGER.info("Delete user success ! id {} ",id);
        return user;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
