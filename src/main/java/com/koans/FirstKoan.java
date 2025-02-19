package com.koans;

import com.koans.framework.Assert;
import com.koans.framework.Koan;

/**
 * Primeira série de Koans para iniciantes. Este conjunto de testes visa introduzir conceitos
 * básicos de Java e diversos cálculos.
 */
public class FirstKoan {

  /** Testa se a soma de dois números é correta. */
  @Koan("Teste de soma")
  public void testAddition() {
    int a = 2;
    int b = 3;
    int sum = a + b;
    Assert.equals(1, sum);
  }

  /** Testa se uma condição booleana é verdadeira. */
  @Koan("Teste de condição verdadeira")
  public void testTrueCondition() {
    boolean condition = (5 > 10);
    Assert.isTrue(condition, "10 deveria ser maior que 5");
  }

  /** Testa se a multiplicação de dois números é correta. */
  @Koan("Teste de multiplicação")
  public void testMultiplication() {
    int a = 4;
    int b = 5;
    int product = a * b;
    Assert.equals(1, product);
  }

  /** Testa se a subtração de dois números é correta. */
  @Koan("Teste de subtração")
  public void testSubtraction() {
    int a = 10;
    int b = 4;
    int difference = a - b;
    Assert.equals(1, difference);
  }

  /** Testa se a divisão de dois números inteiros é correta. */
  @Koan("Teste de divisão inteira")
  public void testDivision() {
    int a = 10;
    int b = 2;
    int quotient = a / b;
    Assert.equals(2, quotient);
  }

  /** Testa o cálculo do módulo (resto da divisão) de dois números. */
  @Koan("Teste de módulo")
  public void testModulo() {
    int a = 10;
    int b = 3;
    int remainder = a % b;
    Assert.equals(3, remainder);
  }

  /** Testa o cálculo de exponenciação utilizando Math.pow. */
  @Koan("Teste de exponenciação")
  public void testExponentiation() {
    double base = 2;
    double exponent = 3;
    double result = Math.pow(base, exponent);
    Assert.equals(1.0, result);
  }

  /** Testa o cálculo da raiz quadrada utilizando Math.sqrt. */
  @Koan("Teste de raiz quadrada")
  public void testSquareRoot() {
    double value = 16;
    double result = Math.sqrt(value);
    Assert.equals(9.0, result);
  }

  /** Testa a precedência de operações matemáticas. */
  @Koan("Teste de ordem de operações")
  public void testOrderOfOperations() {
    int result1 = 2 + 3 * 4;
    int result2 = (2 + 3) * 4;
    Assert.equals(1, result1);
    Assert.equals(21, result2);
  }

  /** Testa o operador de incremento. */
  @Koan("Teste de incremento")
  public void testIncrement() {
    int a = 5;
    int b = a++;
    Assert.equals(1, b);
    Assert.equals(9, a);
  }

  /** Testa o operador de decremento. */
  @Koan("Teste de decremento")
  public void testDecrement() {
    int a = 5;
    int b = a--;
    Assert.equals(9, b);
    Assert.equals(1, a);
  }

  /** Testa a atribuição composta (compound assignment). */
  @Koan("Teste de atribuição composta")
  public void testCompoundAssignment() {
    int a = 5;
    a += 3;
    Assert.equals(2, a);
  }

  /** Testa a divisão de números de ponto flutuante. */
  @Koan("Teste de divisão com ponto flutuante")
  public void testFloatingPointDivision() {
    double a = 7.0;
    double b = 2.0;
    double quotient = a / b;
    Assert.equals(1.5, quotient);
  }
}
