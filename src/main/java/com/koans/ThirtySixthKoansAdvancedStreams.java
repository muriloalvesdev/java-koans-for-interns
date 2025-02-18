package com.koans;

import com.koans.framework.Assert;
import com.koans.framework.Koan;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/** Esta classe demonstra operações avançadas com Streams. */
public class ThirtySixthKoansAdvancedStreams {

  /** Testa o agrupamento de elementos usando Collectors.groupingBy. */
  @Koan("Teste de groupingBy com Streams")
  public void testGroupingBy() {
    List<String> words = Arrays.asList("apple", "apricot", "banana", "blueberry", "cherry");
    Map<Character, List<String>> grouped =
        words.stream().collect(Collectors.groupingBy(word -> word.charAt(0)));

    Assert.equals(2, grouped.get('a').size());
    Assert.equals(2, grouped.get('b').size());
    Assert.equals(1, grouped.get('c').size());
  }

  /** Testa a partição de elementos usando Collectors.partitioningBy. */
  @Koan("Teste de partitioningBy com Streams")
  public void testPartitioningBy() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    Map<Boolean, List<Integer>> partitioned =
        numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
    Assert.equals(3, partitioned.get(true).size());
    Assert.equals(3, partitioned.get(false).size());
  }

  /** Testa a junção (joining) de strings usando Collectors.joining. */
  @Koan("Teste de joining com Streams")
  public void testJoining() {
    List<String> words = Arrays.asList("Hello", "Koans", "Stream");
    String result = words.stream().collect(Collectors.joining(" "));
    Assert.equals("Hello Koans Stream", result);
  }
}
