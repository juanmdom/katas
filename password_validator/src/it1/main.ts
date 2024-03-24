export class PasswordValidator {
  public PasswordValidator() {}

  public static validate(pwd: string) {
    const isValid: boolean =
      this.isValidLength(pwd) &&
      this.containsCapitalLetter(pwd) &&
      this.containsLowercaseLetter(pwd) &&
      this.containsNumber(pwd) &&
      this.containsUnderscore(pwd);

    return isValid;
  }

  public static isValidLength(pwd: string): boolean {
    return pwd.length > 8;
  }

  public static containsCapitalLetter(pwd: string): boolean {
    return /[A-Z]/.test(pwd);
  }

  public static containsLowercaseLetter(pwd: string): boolean {
    return /[a-z]/.test(pwd);
  }

  public static containsUnderscore(pwd: string): boolean {
    return pwd.includes("_");
  }

  public static containsNumber(pwd: string): boolean {
    return /[0-9]/.test(pwd);
  }
}
