package com.koans.framework;

/** Classe utilitária para asserções nos testes Koan. */
public class Assert {

  /**
   * Verifica se a condição é verdadeira.
   *
   * @param condition condição a ser verificada.
   * @param message mensagem a ser exibida caso a condição seja falsa.
   * @throws KoanFailureException se a condição for falsa.
   */
  public static void isTrue(boolean condition, String message) {
    if (!condition) {
      throw new KoanFailureException(message);
    }
  }

  /**
   * Verifica se dois objetos são iguais.
   *
   * @param expected valor esperado.
   * @param actual valor atual.
   * @throws KoanFailureException se os valores não forem iguais.
   */
  public static void equals(Object expected, Object actual) {
    if (expected == null && actual == null) return;
    if (expected != null && expected.equals(actual)) return;
    throw new KoanFailureException("Expected: " + expected + " but was: " + actual);
  }
}
