package com.koans;

import com.koans.framework.Assert;
import com.koans.framework.Koan;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Este conjunto de testes aborda conceitos de coleções, generics e expressões lambda em Java,
 * permitindo que os alunos pratiquem operações com ArrayList, HashSet, HashMap e o uso de streams.
 */
public class FourthKoans {

  /** Testa operações básicas com ArrayList. */
  @Koan("Teste de ArrayList")
  public void testArrayListOperations() {
    List<String> list = new ArrayList<>();
    list.add("Java");
    list.add("Python");
    list.add("C++");

    Assert.equals(3, list.size());
    Assert.equals("Java", list.get(0));
    list.remove("Python");
    Assert.equals(2, list.size());
  }

  /** Testa operações básicas com HashSet para garantir a unicidade dos elementos. */
  @Koan("Teste de HashSet")
  public void testHashSetOperations() {
    Set<Integer> set = new HashSet<>();
    set.add(1);
    set.add(2);
    set.add(2);
    set.add(3);

    Assert.equals(3, set.size());
  }

  /** Testa operações básicas com HashMap. */
  @Koan("Teste de HashMap")
  public void testHashMapOperations() {
    Map<String, Integer> map = new HashMap<>();
    map.put("Alice", 30);
    map.put("Bob", 25);
    map.put("Carol", 28);

    Assert.equals(25, map.get("Bob"));
    Assert.isTrue(map.containsKey("Carol"), "O mapa deve conter a chave 'Carol'");
  }

  /** Testa a ordenação de uma lista usando Collections.sort. */
  @Koan("Teste de ordenação de lista")
  public void testSortingList() {
    List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 2));
    Collections.sort(numbers);
    List<Integer> expected = Arrays.asList(1, 2, 3, 5, 8);
    Assert.equals(expected, numbers);
  }

  @Koan("Teste de expressões lambda com streams")
  public void testLambdaExpressions() {
    List<String> words =
        new ArrayList<>(Arrays.asList("java", "python", "c++", "ruby", "javascript"));
    List<String> filtered =
        words.stream().filter(word -> word.startsWith("j")).collect(Collectors.toList());

    Assert.equals(2, filtered.size());
    Assert.equals("java", filtered.get(0));
    Assert.equals("javascript", filtered.get(1));
  }

  /** Testa um método genérico simples que retorna o primeiro elemento de uma lista. */
  @Koan("Teste de método genérico")
  public void testGenericMethod() {
    List<String> items = new ArrayList<>(Arrays.asList("item1", "item2", "item3"));
    String first = getFirstElement(items);
    Assert.equals("item1", first);
  }

  /**
   * Método genérico que retorna o primeiro elemento de uma lista.
   *
   * @param list a lista de elementos.
   * @param <T> o tipo dos elementos.
   * @return o primeiro elemento da lista.
   */
  private <T> T getFirstElement(List<T> list) {
    return list.get(0);
  }
}
