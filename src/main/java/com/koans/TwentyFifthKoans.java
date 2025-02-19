package com.koans;

import com.koans.framework.Assert;
import com.koans.framework.Koan;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Este conjunto de testes demonstra operações avançadas com streams, separando os testes para
 * filter, map e reduce.
 */
public class TwentyFifthKoans {

  /** Testa a operação de filter em uma stream. Filtra os números pares de uma lista. */
  @Koan("Teste de filter com Streams")
  public void testStreamFilter() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    List<Integer> evenNumbers =
        numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());

    Assert.equals("[1, 3, 5]", evenNumbers.toString());
  }

  /** Testa a operação de map em uma stream. Multiplica cada número da lista por 10. */
  @Koan("Teste de map com Streams")
  public void testStreamMap() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> multipliedNumbers =
        numbers.stream().map(n -> n * 10).collect(Collectors.toList());

    Assert.equals("[20, 10, 30, 40, 70]", multipliedNumbers.toString());
  }

  /** Testa a operação de reduce em uma stream. Soma todos os números da lista. */
  @Koan("Teste de reduce com Streams")
  public void testStreamReduce() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    Optional<Integer> sum = numbers.stream().reduce((a, b) -> a + b);

    Assert.equals(21, sum.orElse(0));
  }
}
