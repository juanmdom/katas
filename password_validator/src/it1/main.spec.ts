import { describe, expect, it } from "vitest";
import { PasswordValidator } from "./main.js";

describe("Password validator", () => {
  it("should validate a valid password", () => {
    const pwd: string = "ValidPassword1_";
    expect(PasswordValidator.validate(pwd)).toBe(true);
  });

  it("should be aware of invalid password length", () => {
    const pwd: string = "Short_1";
    expect(PasswordValidator.validate(pwd)).toBe(false);
    expect(PasswordValidator.isValidLength(pwd)).toBe(false);
  });

  it("should be aware of not containing a capital letter", () => {
    const pwd: string = "invalidpassword_1";
    expect(PasswordValidator.validate(pwd)).toBe(false);
    expect(PasswordValidator.containsCapitalLetter(pwd)).toBe(false);
  });

  it("should be aware of not containing a lowercase letter", () => {
    const pwd: string = "INVALIDPASSWORD_1";
    expect(PasswordValidator.validate(pwd)).toBe(false);
    expect(PasswordValidator.containsLowercaseLetter(pwd)).toBe(false);
  });

  it("should be aware of not containing a number", () => {
    const pwd: string = "InvalidPassword_";
    expect(PasswordValidator.validate(pwd)).toBe(false);
    expect(PasswordValidator.containsNumber(pwd)).toBe(false);
  });

  it("should be aware of not containing a underscore", () => {
    const pwd: string = "InvalidPassword1";
    expect(PasswordValidator.validate(pwd)).toBe(false);
    expect(PasswordValidator.containsUnderscore(pwd)).toBe(false);
  });
});
