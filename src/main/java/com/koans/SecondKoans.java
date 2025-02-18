package com.koans;

import com.koans.framework.Assert;
import com.koans.framework.Koan;

/**
 * Segunda série de Koans para iniciantes. Este conjunto de testes visa aprofundar conceitos básicos
 * de Java, incluindo manipulação de Strings, arrays, laços de repetição e estruturas de controle.
 */
public class SecondKoans {

  /** Testa o comprimento de uma String. */
  @Koan("Teste de comprimento de String")
  public void testStringLength() {
    String text = "Hello, Java!";
    int length = text.length();
    Assert.equals(12, length);
  }

  /** Testa a concatenação de duas Strings. */
  @Koan("Teste de concatenação de String")
  public void testStringConcatenation() {
    String part1 = "Hello, ";
    String part2 = "World!";
    String result = part1 + part2;
    Assert.equals("Hello, World!", result);
  }

  /** Testa a extração de uma substring. */
  @Koan("Teste de substring")
  public void testSubstring() {
    String text = "Java Programming";
    String sub = text.substring(5);
    Assert.equals("Programming", sub);
  }

  /** Testa a soma dos elementos de um array de inteiros. */
  @Koan("Teste de soma de elementos do array")
  public void testArraySum() {
    int[] numbers = {1, 2, 3, 4, 5};
    int sum = 0;
    for (int num : numbers) {
      sum += num;
    }
    Assert.equals(15, sum);
  }

  /** Testa a busca do maior elemento em um array de inteiros. */
  @Koan("Teste de máximo em array")
  public void testArrayMax() {
    int[] numbers = {3, 7, 2, 9, 4};
    int max = numbers[0];
    for (int num : numbers) {
      if (num > max) {
        max = num;
      }
    }
    Assert.equals(9, max);
  }

  /** Testa o uso de um laço 'for' para calcular a soma dos números de 1 a 10. */
  @Koan("Teste de laço for")
  public void testForLoop() {
    int sum = 0;
    for (int i = 1; i <= 10; i++) {
      sum += i;
    }
    Assert.equals(55, sum);
  }

  @Koan("Teste de laço while")
  public void testWhileLoop() {
    int counter = 10;
    int sum = 0;
    while (counter > 0) {
      sum += counter;
      counter--;
    }
    Assert.equals(55, sum);
  }

  /** Testa uma estrutura condicional 'if-else' para verificar se um número é par. */
  @Koan("Teste de estrutura condicional if-else")
  public void testIfElse() {
    int number = 20;
    String result;
    if (number % 2 == 0) {
      result = "even";
    } else {
      result = "odd";
    }
    Assert.equals("even", result);
  }

  /** Testa uma estrutura de controle 'switch-case' para identificar o dia da semana. */
  @Koan("Teste de estrutura switch-case")
  public void testSwitchCase() {
    int day = 3;
    String dayName;
    switch (day) {
      case 1:
        dayName = "Monday";
        break;
      case 2:
        dayName = "Tuesday";
        break;
      case 3:
        dayName = "Wednesday";
        break;
      case 4:
        dayName = "Thursday";
        break;
      case 5:
        dayName = "Friday";
        break;
      case 6:
        dayName = "Saturday";
        break;
      case 7:
        dayName = "Sunday";
        break;
      default:
        dayName = "Invalid";
        break;
    }
    Assert.equals("Wednesday", dayName);
  }

  /** Testa a chamada de um método simples que retorna a soma de dois números. */
  @Koan("Teste de chamada de método")
  public void testMethodCall() {
    int result = sum(8, 12);
    Assert.equals(20, result);
  }

  /**
   * Método auxiliar que retorna a soma de dois números.
   *
   * @param a primeiro número.
   * @param b segundo número.
   * @return a soma de a e b.
   */
  private int sum(int a, int b) {
    return a + b;
  }

  /** Testa o uso de arrays multidimensionais para acessar um elemento específico. */
  @Koan("Teste de array multidimensional")
  public void testMultidimensionalArray() {
    int[][] matrix = {
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}
    };
    Assert.equals(5, matrix[1][1]);
  }

  /** Testa o uso de operadores lógicos. */
  @Koan("Teste de operadores lógicos")
  public void testLogicalOperators() {
    boolean a = true;
    boolean b = false;
    boolean result = a && !b;
    Assert.isTrue(result, "A expressão deve ser verdadeira");
  }
}
