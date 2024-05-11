package models.valueobjects;

import exception.BadEmailFormatException;
public class Email {

    private final String value;

    private Email(String emailValue) {
        this.value = emailValue;
    }

    public static Email create(String emailValue) {
        validate(emailValue);
        return new Email(emailValue);
    }

    private static void validate(String emailValue) {
        if (emailValue == null) {
            throw new NullPointerException("Email is null");
        }

        if (emailValue.isEmpty()) {
            throw new BadEmailFormatException("Email is empty");
        }

        if (!emailValue.contains("@")) {
            throw new BadEmailFormatException("Invalid email address");
        }
    }

    public String getValue() {
        return this.value;
    }
}
