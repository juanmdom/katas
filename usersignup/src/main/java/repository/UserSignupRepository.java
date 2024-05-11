package repository;

import models.valueobjects.Email;

import java.util.Optional;

public interface UserSignupRepository {
    void register(Email email);
    Optional<Email> existByEmailValue(String emailValue);
}
