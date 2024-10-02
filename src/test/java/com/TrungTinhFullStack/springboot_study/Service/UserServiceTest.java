package com.TrungTinhFullStack.springboot_study.Service;

import com.TrungTinhFullStack.springboot_study.Entity.User;
import com.TrungTinhFullStack.springboot_study.Repository.UserRepository;
import com.TrungTinhFullStack.springboot_study.Service.JournalEntry.JournalEntryService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "Tinh",
            "Hieu",
            "Tan"
    })
    public void testFindByUsername(String username) {

        User user = userRepository.findByUsername(username);
        assertEquals(username,user.getUsername());
        assertTrue(5>2);
    }

    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,10,12",
            "3,3,6"
    })
    public void test(int a, int b, int expected) {
        assertEquals(expected,a+b);
    }
}
