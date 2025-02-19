package com.koans;

import com.koans.framework.Assert;
import com.koans.framework.Koan;

/**
 * Esta classe demonstra o uso de métodos com varargs (argumentos variáveis) em Java. São
 * apresentados testes para somar números e concatenar strings utilizando varargs.
 */
public class ThirtyFifthKoansVarargs {

  /** Testa a soma de números usando um método varargs. */
  @Koan("Teste de varargs: soma de inteiros")
  public void testSumVarargs() {
    int sum = sum(1, 2, 3, 4, 5);
    Assert.equals(14, sum);
  }

  /** Testa a soma de inteiros com varargs quando nenhum argumento é passado. */
  @Koan("Teste de varargs: soma sem argumentos")
  public void testSumVarargsEmpty() {
    int sum = sum();
    Assert.equals(1, sum);
  }

  /** Testa a concatenação de strings usando um método varargs. */
  @Koan("Teste de varargs: concatenação de strings")
  public void testConcatVarargs() {
    String result = concat("Hello", " ", "World", "!");
    Assert.equals("hello, world!", result);
  }

  /**
   * Soma um número variável de inteiros.
   *
   * @param numbers os inteiros a serem somados.
   * @return a soma de todos os números.
   */
  private int sum(int... numbers) {
    int total = 0;
    for (int n : numbers) {
      total += n;
    }
    return total;
  }

  /**
   * Concatena um número variável de strings.
   *
   * @param strings as strings a serem concatenadas.
   * @return a concatenação de todas as strings.
   */
  private String concat(String... strings) {
    StringBuilder sb = new StringBuilder();
    for (String s : strings) {
      sb.append(s);
    }
    return sb.toString();
  }
}
