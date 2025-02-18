package com.koans;

import com.koans.framework.Assert;
import com.koans.framework.Koan;

/**
 * Este conjunto de testes aborda algoritmos matemáticos básicos, como o cálculo da sequência de
 * Fibonacci.
 */
public class FourteenthKoans {

  /** Testa o cálculo do n-ésimo número da sequência de Fibonacci usando uma abordagem iterativa. */
  @Koan("Teste de sequência de Fibonacci")
  public void testFibonacci() {
    int fib10 = fibonacci(10);
    Assert.equals(55, fib10);
  }

  /**
   * Calcula o n-ésimo número da sequência de Fibonacci de forma iterativa.
   *
   * @param n o índice do número na sequência.
   * @return o número da sequência de Fibonacci.
   */
  private int fibonacci(int n) {
    if (n <= 0) return 0;
    if (n == 1) return 1;
    int a = 0, b = 1;
    for (int i = 2; i <= n; i++) {
      int temp = a + b;
      a = b;
      b = temp;
    }
    return b;
  }
}
