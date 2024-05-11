package service;

import exception.EmailAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import models.valueobjects.Email;
import repository.UserSignupRepository;

import java.util.Optional;


public class UserSignupService {

    private UserSignupRepository repository;

    public UserSignupService(UserSignupRepository repository) {
        this.repository = repository;
    }

    public void register(String emailValue) {
        Optional<Email> optionalEmail = repository.existByEmailValue(emailValue);

        if (optionalEmail.isPresent()) {
            throw new EmailAlreadyExistsException();
        }

        repository.register(Email.create(emailValue));
    }
}
