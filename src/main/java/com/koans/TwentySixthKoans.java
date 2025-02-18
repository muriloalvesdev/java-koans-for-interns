package com.koans;

import com.koans.framework.Assert;
import com.koans.framework.Koan;

/**
 * Este conjunto de testes demonstra o cálculo do Máximo Divisor Comum (MDC) utilizando
 * recursividade.
 */
public class TwentySixthKoans {

  /** Testa o cálculo do MDC de dois números. */
  @Koan("Teste de cálculo do MDC")
  public void testGCD() {
    int result = gcd(48, 18);
    Assert.equals(6, result);
  }

  /**
   * Calcula o Máximo Divisor Comum (GCD) de dois números usando o algoritmo de Euclides.
   *
   * @param a o primeiro número.
   * @param b o segundo número.
   * @return o MDC de a e b.
   */
  private int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }
}
