package com.koans;

import com.koans.framework.Assert;
import com.koans.framework.Koan;

/**
 * Esta classe demonstra detalhadamente o funcionamento de diversos símbolos de expressões
 * regulares. Cada teste foca em um símbolo específico, explicando seu comportamento e aplicação.
 */
public class ThirtyFirstKoans {

  /**
   * Testa o operador ponto (.) que casa com qualquer caractere, exceto nova linha. Exemplo: "a.c"
   * casa com "abc", "aXc", mas não com "ac".
   */
  @Koan("Teste de ponto (.)")
  public void testDotOperator() {
    Assert.isTrue("abc".matches("a.c"), "O ponto deve casar com qualquer caractere");
    Assert.isTrue("aXc".matches("a.c"), "O ponto deve casar com qualquer caractere");
    Assert.isTrue(!"ac".matches("a.c"), "O ponto exige um caractere entre 'a' e 'c'");
  }

  /**
   * Testa o operador asterisco (*) que casa com zero ou mais ocorrências do elemento anterior.
   * Exemplo: "ab*c" casa com "ac", "abc", "abbc", etc.
   */
  @Koan("Teste de asterisco (*)")
  public void testAsteriskOperator() {
    Assert.isTrue("ac".matches("ab*c"), "Asterisco permite zero ocorrências");
    Assert.isTrue("abc".matches("ab*c"), "Asterisco permite uma ocorrência");
    Assert.isTrue("abbc".matches("ab*c"), "Asterisco permite múltiplas ocorrências");
  }

  /**
   * Testa o operador mais (+) que casa com uma ou mais ocorrências do elemento anterior. Exemplo:
   * "ab+c" casa com "abc", "abbc", mas não com "ac".
   */
  @Koan("Teste de mais (+)")
  public void testPlusOperator() {
    Assert.isTrue("abc".matches("ab+c"), "Mais requer pelo menos uma ocorrência");
    Assert.isTrue("abbc".matches("ab+c"), "Mais permite múltiplas ocorrências");
    Assert.isTrue(!"ac".matches("ab+c"), "Mais não casa com zero ocorrências");
  }

  /**
   * Testa o operador interrogação (?) que casa com zero ou uma ocorrência do elemento anterior.
   * Exemplo: "ab?c" casa com "ac" e "abc", mas não com "abbc".
   */
  @Koan("Teste de interrogação (?)")
  public void testQuestionMarkOperator() {
    Assert.isTrue("ac".matches("ab?c"), "Interrogação permite zero ocorrências");
    Assert.isTrue("abc".matches("ab?c"), "Interrogação permite uma ocorrência");
    Assert.isTrue(!"abbc".matches("ab?c"), "Interrogação não permite mais de uma ocorrência");
  }

  /**
   * Testa o símbolo caret (^) que casa com o início da string. Exemplo: "^abc" casa com strings que
   * começam com "abc".
   */
  @Koan("Teste de caret (^) no início da string")
  public void testCaretOperator() {
    Assert.isTrue("abcdef".matches("^abc.*"), "Caret exige que a string comece com 'abc'");
    Assert.isTrue(!"zabc".matches("^abc.*"), "String que não inicia com 'abc' não deve casar");
  }

  /**
   * Testa o símbolo dólar ($) que casa com o final da string. Exemplo: "abc$" casa com strings que
   * terminam com "abc".
   */
  @Koan("Teste de dólar ($) no final da string")
  public void testDollarOperator() {
    Assert.isTrue("xyzabc".matches(".*abc$"), "Dólar exige que a string termine com 'abc'");
    Assert.isTrue(!"abcxyz".matches(".*abc$"), "String que não termina com 'abc' não deve casar");
  }

  /**
   * Testa o uso de classes de caracteres com colchetes []. Exemplo: "a[xyz]c" casa com "axc",
   * "ayc", "azc" e não casa com "abc".
   */
  @Koan("Teste de classe de caracteres com []")
  public void testCharacterClass() {
    Assert.isTrue("axc".matches("a[xyz]c"), "Deve casar com 'axc'");
    Assert.isTrue("ayc".matches("a[xyz]c"), "Deve casar com 'ayc'");
    Assert.isTrue("azc".matches("a[xyz]c"), "Deve casar com 'azc'");
    Assert.isTrue(!"abc".matches("a[xyz]c"), "Não deve casar com 'abc'");
  }

  /**
   * Testa o operador pipe (|) que atua como um OU lógico entre alternativas. Exemplo: "cat|dog"
   * casa com "cat" ou "dog".
   */
  @Koan("Teste do operador pipe (|)")
  public void testPipeOperator() {
    Assert.isTrue("cat".matches("cat|dog"), "Deve casar com 'cat'");
    Assert.isTrue("dog".matches("cat|dog"), "Deve casar com 'dog'");
    Assert.isTrue(!"cow".matches("cat|dog"), "Não deve casar com 'cow'");
  }

  /**
   * Testa o agrupamento com parênteses (). Exemplo: "(abc)+" casa com uma ou mais repetições da
   * sequência "abc".
   */
  @Koan("Teste de agrupamento com parênteses ()")
  public void testGroupingParentheses() {
    Assert.isTrue("abc".matches("(abc)+"), "Deve casar com 'abc'");
    Assert.isTrue("abcabc".matches("(abc)+"), "Deve casar com 'abcabc'");
    Assert.isTrue(!"ab".matches("(abc)+"), "Não deve casar com 'ab'");
  }

  /**
   * Testa o uso de barra invertida (\\) para escapar caracteres especiais. Exemplo: "a\\.c" casa
   * com "a.c" literalmente, não com "abc".
   */
  @Koan("Teste de barra invertida (\\\\) para escape")
  public void testBackslashEscape() {
    Assert.isTrue("a.c".matches("a\\.c"), "Deve casar com 'a.c' literal");
    Assert.isTrue(!"abc".matches("a\\.c"), "Não deve casar com 'abc'");
  }

  /**
   * Testa o literal da barra (/) que em regex é interpretado como caractere normal. Exemplo: "a/b"
   * casa com "a/b" exatamente.
   */
  @Koan("Teste de literal da barra (/)")
  public void testForwardSlashLiteral() {
    Assert.isTrue("a/b".matches("a/b"), "A barra deve ser interpretada como literal");
    Assert.isTrue(!"a-b".matches("a/b"), "Não deve casar com 'a-b'");
  }
}
