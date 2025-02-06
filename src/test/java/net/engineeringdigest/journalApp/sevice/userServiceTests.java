package net.engineeringdigest.journalApp.sevice;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import net.engineeringdigest.journalApp.service.UserService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class userServiceTests {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @ParameterizedTest
    @ArgumentsSource(userAurgumentProvider.class)
    public void testByUserName(User user){
        assertTrue(userService.saveNewUser(user));
    }
    public void test(String name){
        assertNotNull(userRepository.findByUserName(name));
    }
    @ParameterizedTest
    @CsvSource({
            "1,1,3",
            "2,2,4",
            "3,3,9",
            "4,4,8"
    })
    public void test1(int a, int b, int c){
        assertEquals(c,a+b);
    }
}
