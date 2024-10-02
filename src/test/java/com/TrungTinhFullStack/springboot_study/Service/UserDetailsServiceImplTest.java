package com.TrungTinhFullStack.springboot_study.Service;

import com.TrungTinhFullStack.springboot_study.Repository.UserRepository;
import com.TrungTinhFullStack.springboot_study.Service.User.UserDetailsServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collections;

import static org.mockito.Mockito.*;

@SpringBootTest
public class UserDetailsServiceImplTest {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @MockBean
    private UserRepository userRepository;

    @Test
    void loadUserByUsernameTest() {
        com.TrungTinhFullStack.springboot_study.Entity.User user = new com.TrungTinhFullStack.springboot_study.Entity.User();
        user.setUsername("Tinh");
        user.setPassword("123456");
        user.setRoles(Collections.singletonList("ADMIN")); // Gán vai trò

        when(userRepository.findByUsername(ArgumentMatchers.anyString()))
                .thenReturn(user);
       UserDetails userDetails =  userDetailsService
               .loadUserByUsername("Tinh");
        Assertions.assertNotNull(userDetails);
        Assertions.assertEquals("Tinh",userDetails.getUsername());
        Assertions.assertEquals("123456",userDetails.getPassword());

    }
}
