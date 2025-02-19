package net.engineeringdigest.journalApp.repository;

import net.engineeringdigest.journalApp.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserRepositoryImpleTests {

    @Autowired
    private UserRepositoryImpl userRepository;
    @Test
    public void testByUserName(){
        userRepository.getUserForSA();
    }
}
