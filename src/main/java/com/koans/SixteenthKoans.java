package com.koans;

import com.koans.framework.Assert;
import com.koans.framework.Koan;

/**
 * Este conjunto de testes aborda o uso de interfaces funcionais, expressões lambda e referências de
 * método.
 */
public class SixteenthKoans {

  /** Testa o uso de uma interface funcional com uma expressão lambda. */
  @Koan("Teste de interface funcional com lambda")
  public void testFunctionalInterfaceLambda() {
    Calculator add = (a, b) -> a + b;
    int result = add.compute(5, 7);
    Assert.equals(12, result);
  }

  /** Testa o uso de uma referência de método para uma interface funcional. */
  @Koan("Teste de referência de método")
  public void testMethodReference() {
    Calculator multiply = Math::multiplyExact;
    int result = multiply.compute(4, 5);
    Assert.equals(20, result);
  }

  /** Interface funcional para realizar cálculos. */
  interface Calculator {
    /**
     * Realiza um cálculo com dois inteiros.
     *
     * @param a o primeiro inteiro.
     * @param b o segundo inteiro.
     * @return o resultado do cálculo.
     */
    int compute(int a, int b);
  }
}
