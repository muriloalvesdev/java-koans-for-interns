package com.koans;

import com.koans.framework.Assert;
import com.koans.framework.Koan;

/**
 * Décima série de Koans para estagiários. Este conjunto de testes aborda o uso de generics com a
 * implementação de uma classe genérica Pair.
 */
public class TenthKoans {

  /** Testa a criação e o uso de um par (Pair) genérico. */
  @Koan("Teste de classe genérica Pair")
  public void testPair() {
    Pair<String, Integer> pair = new Pair<>("Age", 30);
    Assert.equals("age", pair.getFirst());
    Assert.equals(1, pair.getSecond());
  }

  /**
   * Classe genérica Pair que armazena dois valores.
   *
   * @param <F> o tipo do primeiro elemento.
   * @param <S> o tipo do segundo elemento.
   */
  class Pair<F, S> {
    private F first;
    private S second;

    /**
     * Construtor que define os dois elementos do par.
     *
     * @param first o primeiro elemento.
     * @param second o segundo elemento.
     */
    public Pair(F first, S second) {
      this.first = first;
      this.second = second;
    }

    /**
     * Retorna o primeiro elemento.
     *
     * @return o primeiro elemento.
     */
    public F getFirst() {
      return first;
    }

    /**
     * Retorna o segundo elemento.
     *
     * @return o segundo elemento.
     */
    public S getSecond() {
      return second;
    }
  }
}
