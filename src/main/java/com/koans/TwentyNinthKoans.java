package com.koans;

import com.koans.framework.Assert;
import com.koans.framework.Koan;

/** Este conjunto de testes demonstra a implementação de uma busca binária em um array ordenado. */
public class TwentyNinthKoans {

  /** Testa a busca binária em um array ordenado. */
  @Koan("Teste de busca binária")
  public void testBinarySearch() {
    int[] sortedArray = {1, 3, 5, 7, 9, 11};
    int index = binarySearch(sortedArray, 7);
    Assert.equals(3, index);

    int notFound = binarySearch(sortedArray, 4);
    Assert.equals(-1, notFound);
  }

  /**
   * Implementa a busca binária em um array de inteiros.
   *
   * @param array o array ordenado.
   * @param target o valor a ser buscado.
   * @return o índice do valor se encontrado, ou -1 se não encontrado.
   */
  private int binarySearch(int[] array, int target) {
    int low = 0;
    int high = array.length - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (array[mid] == target) {
        return mid;
      } else if (array[mid] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return -1;
  }
}
