package com.koans;

import com.koans.framework.Assert;
import com.koans.framework.Koan;
import java.util.Arrays;

/**
 * Este conjunto de testes aborda algoritmos básicos de ordenação e busca, como Bubble Sort e busca
 * linear.
 */
public class EleventhKoans {

  /** Testa a ordenação de um array utilizando o algoritmo Bubble Sort. */
  @Koan("Teste de Bubble Sort")
  public void testBubbleSort() {
    int[] array = {5, 3, 8, 1, 2};
    bubbleSort(array);
    int[] expected = {1, 2, 3, 5, 8};
    Assert.equals(Arrays.toString(expected), Arrays.toString(array));
  }

  /** Testa a busca linear em um array. */
  @Koan("Teste de busca linear")
  public void testLinearSearch() {
    int[] array = {10, 20, 30, 40, 50};
    int index = linearSearch(array, 30);
    Assert.equals(2, index);
    int notFoundIndex = linearSearch(array, 99);
    Assert.equals(-1, notFoundIndex);
  }

  /**
   * Implementa o algoritmo Bubble Sort para ordenar um array de inteiros.
   *
   * @param array o array a ser ordenado.
   */
  private void bubbleSort(int[] array) {
    int n = array.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (array[j] > array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      }
    }
  }

  /**
   * Implementa uma busca linear em um array.
   *
   * @param array o array onde buscar.
   * @param target o valor a ser buscado.
   * @return o índice do valor se encontrado, ou -1 se não encontrado.
   */
  private int linearSearch(int[] array, int target) {
    for (int i = 0; i < array.length; i++) {
      if (array[i] == target) {
        return i;
      }
    }
    return -1;
  }
}
