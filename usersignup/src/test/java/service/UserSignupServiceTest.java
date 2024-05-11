package service;

import exception.EmailAlreadyExistsException;
import models.valueobjects.Email;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.UserSignupRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class UserSignupServiceTest {

    /*
     * Use cases:
     *   1) Usuario no registrado porque existe
     *   2) Usuario registrado
     */

    UserSignupService service;
    UserSignupRepository repository;

    @BeforeEach
    void setUp() {
        this.repository = mock(UserSignupRepository.class);
        this.service = new UserSignupService(this.repository);
    }


    @Test
    void shouldNotRegisterIfEmailExists() {
        String emailString = "juanmdom@gmail.com";

        when(repository.existByEmailValue(emailString)).thenReturn(Optional.of(Email.create(emailString)));


        Exception myException = assertThrows(EmailAlreadyExistsException.class, () -> {
            service.register(emailString);
        });
        verify(repository, never()).register(Email.create("juanmdom@gmail.com"));
        assertEquals(myException.getMessage(), "Email already exists");
    }

}
