package models;

import exception.BadEmailFormatException;
import lombok.RequiredArgsConstructor;
import models.valueobjects.Email;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RequiredArgsConstructor
public class EmailValueObjectTest {

    /*
    * EDGE CASES
    *
    *   1  Email malo :(
    *       - Mal formato
    *           null -> NullPointerException()
    *           ¨¨ -> EmptyEmailException()
    *           sin arroba -> BadEmailFormatException()
    *           sin dominio de email existente -> BadEmailFormatException()
    *       - Ya existe -> EmailAlreadyExistException()
    *   2  Email bueno :)
    *
    * */

    @Test
    void should_throws_exception_if_null_email() {
       Exception myException = assertThrows(NullPointerException.class, () -> {
           Email.create(null);
       });

       assertEquals(myException.getMessage(), "Email is null");
    }

    @Test
    void should_throws_exception_if_empty_email() {
        Exception myException = assertThrows(BadEmailFormatException.class, () -> {
            Email.create("");
        });

        assertEquals(myException.getMessage(), "Email is empty");
    }

    @Test
    void should_throws_exception_if_bad_format_email() {
        Exception myException = assertThrows(BadEmailFormatException.class, () -> {
            Email.create("juan.com");
        });

        assertEquals(myException.getMessage(), "Invalid email address");
    }

    @Test
    void should_create_email_if_valid_email_value() {
        Email createdEmail = Email.create("test@gmail.com");

        assertEquals(createdEmail.getValue(), "test@gmail.com");
    }
}
