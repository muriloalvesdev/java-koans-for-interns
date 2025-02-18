package com.koans;

import com.koans.framework.Assert;
import com.koans.framework.Koan;
import com.koans.framework.KoanFailureException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Optional;

/**
 * Este conjunto de testes aborda temas como tratamento de exceções, blocos finally,
 * try-with-resources, uso de enums, recursividade, sobrecarga de métodos, Optional, exceções
 * personalizadas, inicialização estática e manipulação de arrays.
 */
public class FifthKoans {

  /** Variável estática para teste de inicialização estática. */
  private static int staticCounter;

  static {
    staticCounter = 10;
  }

  /** Testa o tratamento de exceção ao tentar dividir por zero. */
  @Koan("Teste de tratamento de exceção")
  public void testExceptionHandling() {
    try {
      int result = 10 / 0;
      Assert.equals(true, false);
    } catch (ArithmeticException e) {
      // não deve lançar exception aqui por é apenas uma tratativa, não existe divisão por zero e
      // estamos apenas
      // adicionando o catch excpetion pra que a execução continue mesmo dando erro
    }
  }

  /** Testa se o bloco finally é executado após um try-catch. */
  @Koan("Teste de bloco finally")
  public void testFinallyBlock() {
    int value = 0;
    try {
      int result = 10 / 2;
    } catch (Exception e) {
      throw new KoanFailureException(e.getMessage());
    } finally {
      value = 5;
    }
    Assert.equals(5, value);
  }

  /** Testa o uso de try-with-resources para ler uma String. */
  @Koan("Teste de try-with-resources")
  public void testTryWithResources() {
    String input = "Hello Koans";
    String output = "";
    try (StringReader sr = new StringReader(input);
        BufferedReader br = new BufferedReader(sr)) {
      output = br.readLine();
    } catch (IOException e) {
      throw new KoanFailureException(e.getMessage());
    }
    Assert.equals("Hello Koans", output);
  }

  /** Enum para teste de uso de enum. */
  public enum Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
  }

  /** Testa o uso de enum verificando o valor do enum. */
  @Koan("Teste de uso de enum")
  public void testEnumUsage() {
    Day day = Day.WEDNESDAY;
    Assert.equals("WEDNESDAY", day.toString());
  }

  /**
   * Método recursivo para cálculo de fatorial.
   *
   * @param n número para cálculo do fatorial.
   * @return o fatorial de n.
   */
  private long factorial(int n) {
    if (n <= 1) {
      return 1;
    }
    return n * factorial(n - 1);
  }

  /** Testa a recursividade calculando o fatorial de 5. */
  @Koan("Teste de recursividade com fatorial")
  public void testRecursionFactorial() {
    long fact5 = factorial(5);
    Assert.equals(120L, fact5);
  }

  /**
   * Método sobrecarregado que soma dois inteiros.
   *
   * @param a primeiro inteiro.
   * @param b segundo inteiro.
   * @return a soma dos inteiros.
   */
  private int sum(int a, int b) {
    return a + b;
  }

  /**
   * Método sobrecarregado que soma dois doubles.
   *
   * @param a primeiro double.
   * @param b segundo double.
   * @return a soma dos doubles.
   */
  private double sum(double a, double b) {
    return a + b;
  }

  /** Testa a sobrecarga de métodos, verificando a soma de inteiros e doubles. */
  @Koan("Teste de sobrecarga de métodos")
  public void testMethodOverloading() {
    int intSum = sum(3, 4);
    double doubleSum = sum(2.5, 3.5);
    Assert.equals(7, intSum);
    Assert.equals(6.0, doubleSum);
  }

  /** Testa o uso da classe Optional para valores presentes e ausentes. */
  @Koan("Teste de uso de Optional")
  public void testOptionalUsage() {
    Optional<String> optionalValue = Optional.of("Koans");
    String value = optionalValue.orElse("Default");
    Assert.equals("Koans", value);

    Optional<String> emptyOptional = Optional.empty();
    String defaultValue = emptyOptional.orElse("Default");
    Assert.equals("Default", defaultValue);
  }

  /** Exceção personalizada para os testes de exceção. */
  public static class CustomKoanException extends Exception {
    /**
     * Construtor que define a mensagem da exceção.
     *
     * @param message mensagem de erro.
     */
    public CustomKoanException(String message) {
      super(message);
    }
  }

  /**
   * Método que sempre lança uma exceção personalizada.
   *
   * @throws CustomKoanException sempre lançada.
   */
  private void methodThatThrows() throws CustomKoanException {
    throw new CustomKoanException("Custom error occurred");
  }

  /** Testa o lançamento e o tratamento de uma exceção personalizada. */
  @Koan("Teste de exceção personalizada")
  public void testCustomException() {
    try {
      methodThatThrows();
      Assert.equals(true, false);
    } catch (CustomKoanException e) {
      // exception personalizada executada no método methodThatThrows(),
      // se verificar a mensagem da variável 'e' você verá a mensagem personalizada da exception
      // personalizada
    }
  }

  /** Testa se a inicialização estática foi realizada corretamente. */
  @Koan("Teste de inicialização estática")
  public void testStaticInitialization() {
    Assert.equals(10, staticCounter);
  }

  /** Testa o lançamento de ArrayIndexOutOfBoundsException ao acessar índice inválido. */
  @Koan("Teste de ArrayIndexOutOfBoundsException")
  public void testArrayIndexOutOfBounds() {
    int[] array = {1, 2, 3};
    try {
      int value = array[5];
      Assert.equals(true, false); // Não deve chegar aqui
    } catch (ArrayIndexOutOfBoundsException e) {
      // Verifica se o tamanho do array é 3
      Assert.equals("3", String.valueOf(array.length));
    }
  }
}
