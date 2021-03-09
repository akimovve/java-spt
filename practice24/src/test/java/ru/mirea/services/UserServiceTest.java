package ru.mirea.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.mirea.dto.SignUpRequest;
import ru.mirea.models.User;
import ru.mirea.repositories.UserRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Captor
    private ArgumentCaptor<User> argumentCaptor;

    @Test
    void addNewUser() {
        UserService userService = new UserService(userRepository, passwordEncoder);
        userService.addNewUser(
                SignUpRequest.builder()
                        .username("username1")
                        .password(passwordEncoder.encode("12345"))
                        .matchingPassword(passwordEncoder.encode("12345"))
                        .build()
        );
        Mockito.verify(userRepository).save(argumentCaptor.capture());
        User captured = argumentCaptor.getValue();
        assertEquals("username1", captured.getUsername());
    }

    @Test
    void userExists() {
        UserService userService = new UserService(userRepository, passwordEncoder);
        Boolean exists = userService.userExists("username1");
        assertEquals(exists, false);
    }
}