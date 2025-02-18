package com.koans.framework;

/** Exceção lançada quando um teste Koan falha. */
public class KoanFailureException extends RuntimeException {

  /**
   * Construtor que recebe uma mensagem de erro.
   *
   * @param message mensagem descrevendo a falha do teste.
   */
  public KoanFailureException(String message) {
    super(message);
  }
}
