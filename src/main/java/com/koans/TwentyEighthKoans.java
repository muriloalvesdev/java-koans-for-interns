package com.koans;

import com.koans.framework.Assert;
import com.koans.framework.Koan;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Este conjunto de testes demonstra a implementação de uma Queue (fila) simples utilizando
 * LinkedList.
 */
public class TwentyEighthKoans {

  /** Testa as operações básicas de uma Queue personalizada. */
  @Koan("Teste de Queue personalizada")
  public void testCustomQueue() {
    CustomQueue<Integer> queue = new CustomQueue<>();
    Assert.equals(0, queue.size());

    queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(30);
    Assert.equals(3, queue.size());
    Assert.equals(10, queue.peek());

    int dequeued = queue.dequeue();
    Assert.equals(10, dequeued);
    Assert.equals(2, queue.size());
  }

  /**
   * Implementa uma Queue simples utilizando LinkedList.
   *
   * @param <T> o tipo dos elementos da fila.
   */
  class CustomQueue<T> {
    private LinkedList<T> list = new LinkedList<>();

    /**
     * Adiciona um elemento ao final da fila.
     *
     * @param element o elemento a ser enfileirado.
     */
    public void enqueue(T element) {
      list.addLast(element);
    }

    /**
     * Remove e retorna o primeiro elemento da fila.
     *
     * @return o elemento removido.
     * @throws NoSuchElementException se a fila estiver vazia.
     */
    public T dequeue() {
      if (list.isEmpty()) {
        throw new NoSuchElementException("Queue is empty");
      }
      return list.removeFirst();
    }

    /**
     * Retorna o primeiro elemento da fila sem removê-lo.
     *
     * @return o primeiro elemento.
     * @throws NoSuchElementException se a fila estiver vazia.
     */
    public T peek() {
      if (list.isEmpty()) {
        throw new NoSuchElementException("Queue is empty");
      }
      return list.getFirst();
    }

    /**
     * Retorna o número de elementos na fila.
     *
     * @return o tamanho da fila.
     */
    public int size() {
      return list.size();
    }
  }
}
