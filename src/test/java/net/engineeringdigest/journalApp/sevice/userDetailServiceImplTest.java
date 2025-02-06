package net.engineeringdigest.journalApp.sevice;

import net.engineeringdigest.journalApp.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import net.engineeringdigest.journalApp.repository.UserRepository;

import net.engineeringdigest.journalApp.service.UserDetailServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

import static org.mockito.Mockito.*;


public class userDetailServiceImplTest {
    @InjectMocks
    private UserDetailServiceImpl userDetailService;


    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void loadUserByUserNameTest(){
        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(User.builder().userName("Rana1234").password("3fafaf").roles(new ArrayList<>()).build());
        UserDetails user = (UserDetails) userDetailService.loadUserByUsername("Rana1234");
    Assertions.assertNotNull(user);
    }
}
