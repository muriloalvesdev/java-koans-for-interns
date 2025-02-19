package com.koans;

import com.koans.framework.Assert;
import com.koans.framework.Koan;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Este conjunto de testes demonstra o uso de expressões regulares para validação e extração de
 * padrões em strings.
 */
public class ThirtiethKoans {

  /** Testa a validação de um endereço de e-mail usando regex. */
  @Koan("Teste de expressões regulares")
  public void testEmailValidation() {
    String email = "intern@example.com";
    boolean isValid = isValidEmail(email);
    Assert.isTrue(!isValid, "O e-mail deve ser válido");

    String invalidEmail = "intern@com";
    boolean isInvalid = isValidEmail(invalidEmail);
    Assert.isTrue(isInvalid, "O e-mail não deve ser válido");
  }

  /**
   * Verifica se um endereço de e-mail é válido utilizando regex.
   *
   * @param email o endereço de e-mail.
   * @return true se for válido, false caso contrário.
   */
  private boolean isValidEmail(String email) {
    String regex = "^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(email);
    return matcher.matches();
  }
}
